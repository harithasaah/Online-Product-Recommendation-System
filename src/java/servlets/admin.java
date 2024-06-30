/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package servlets;

import cluster.*;
import promise.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
public class admin extends HttpServlet {
public static int last_day,pro_PL=0;
public static float totalsize=0,totalsize_student=0,totalsize_sports=0,totalsize_business=0,totalsize_media=0;
public static float inc_student=0,inc_business=0,inc_media=0,inc_sports=0;
public static String tab_name;
public static String Data="";
public static String Data1="";
int temppp=0;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

       // String Data="";

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int day=0;
        Db_connection.getOracleJDBCConnection();
         //Db_create.create();// to create databases


        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"images/tradeone.css\" type=\"text/css\" />");
            out.println("<title>TradeOnE</title>");
            out.println("</head>");
            out.println("<body>");
         //m   out.println("<a href =\"DoCluster.jsp\">Clustering </a>" );
            out.println("<div id=\"header-wrap\"><div id=\"header-content\">");
            out.println("<h1 id=\"logo\"><a href=\"index.jsp\" title=\"\"><span class=\"orange\">Trade</span>On<span class=\"orange\">E</span></a></h1>");
            out.println("<h2 id=\"slogan\"><font size=\"2\">Bringing you Visibility , Velocity & Value</font></h2>");
        	out.println("<div id=\"header-links\"><p><font size=\"2\"><a href=\"index.html\">Logout</a></font></p></div>");
            out.println("<ul><li><a href=\"index.jsp\" >Home</a></li><li><a href=\"registration.jsp\">Registration</a></li><li><a href=\"productlist.jsp\" id=\"current\">ProductList</a></li></ul></div></div>");
            out.println("<div id=\"content-wrap\"><div id=\"content\"><div id=\"main\">");
   // am putting this line of code---
            out.println("<tr><td><form action=\"clustering\" method=\"post\"><p align=\"center\" ><input type=\"submit\" value=\"DoClustering\"></p></form></td></tr>");
                                      
            out.println("<table>");
            try
            {
                Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                            java.sql.ResultSet.CONCUR_UPDATABLE);
                 String query="select trans_day from promise_trans";
                 ResultSet resultset=stmt.executeQuery(query);
                 resultset.last();
                 totalsize=resultset.getRow();
                 System.out.println("total size"+resultset.getRow());
                  Data= "Transaction Total size "+totalsize+"<br/>";
                 last_day=resultset.getInt(1);//to get the last day from transaction table if last day is 1 then have to do original database recovery
                 //System.out.println(last_day);
                 //String query1="select trans_day from promise_trans where occupation_id=1";
                 String query1="select trans_day from promise_trans where category_id=1";
                 ResultSet rs1=stmt.executeQuery(query1);
                 rs1.last();
                 totalsize_student=rs1.getRow();
                 System.out.println(rs1.getRow());
                 Data=  Data+"Student Category   "+ totalsize_student+"<br/>";
                 String query4="select trans_day from promise_trans where category_id=4";
                 ResultSet rs4=stmt.executeQuery(query4);
                 rs4.last();
                 totalsize_sports=rs4.getRow();
                 System.out.println(rs4.getRow());
                 Data=  Data+"Sports Category   "+totalsize_sports+"<br/>";
                 String query2="select trans_day from promise_trans where category_id=2";
                 ResultSet rs2=stmt.executeQuery(query2);
                 rs2.last();
                 totalsize_business=rs2.getRow();
                 System.out.println(rs2.getRow());
                 Data= Data+"business Category   "+totalsize_business+"<br/>";
                 String query3="select trans_day from promise_trans where category_id=3";
                 ResultSet rs3=stmt.executeQuery(query3);
                 rs3.last();
                 totalsize_media=rs3.getRow();
                 System.out.println(rs3.getRow());
                 Data= Data+"media Category   "+totalsize_media+"<br/>";

                 System.out.println("############"+Data);

//                try {
//                 transaction_info.writeFile(Data);
//                 Data ="";
//                 }catch(Exception ex) {
//
//                     System.err.println(ex);
//                 }


                 if(last_day==1)
                 {
                    can_gen.scan_originalDB();
                 }
                 else
                 {
                    can_gen.scan_incrementalDB(last_day);
                    pro_PL=(last_day-1)*8;//updating frequent and promising frequent itemsets
                 String q1="select * from promise_trans where category_id=1 and trans_day="+last_day;
                 ResultSet irs1=stmt.executeQuery(q1);
                 irs1.last();
                 System.out.println("INC SIZE FOR STUDENT");
                 inc_student=irs1.getRow();
                 Data = Data+"INC SIZE FOR STUDENT "+inc_student+"<br/>";
                 System.out.println(irs1.getRow());
                 String q2="select * from promise_trans where category_id=2 and trans_day="+last_day;
                 ResultSet irs2=stmt.executeQuery(q2);
                 irs2.last();
                 System.out.println("INC SIZE-BUSINESS");
                 inc_business=irs2.getRow();
                  Data = Data+"INC SIZE-BUSINESS "+inc_business+"<br/>";
                 System.out.println(irs2.getRow());
                 String q3="select * from promise_trans where category_id=3 and trans_day="+last_day;
                 ResultSet irs3=stmt.executeQuery(q3);
                 irs3.last();
                 System.out.println("INC SIZE-MEDIA");
                 inc_media=irs3.getRow();
                 Data = Data+"INC SIZE-MEDIA "+inc_media+"<br/>";
                 System.out.println(irs3.getRow());
                 String q4="select * from promise_trans where category_id=4 and trans_day="+last_day;
                 ResultSet irs4=stmt.executeQuery(q4);
                 irs4.last();
                 System.out.println("INC SIZE-SPORTS");
                 inc_sports=irs4.getRow();
                  Data = Data+"INC SIZE-SPORTS "+ inc_sports+"<br/>";
               //   int temppp=0;
                 if(temppp==0) {
                 try {
                 transaction_info.writeFile(Data);
                 System.out.println("Temppp"+temppp+" Tx_Data############ "+Data);
                 ++temppp;
                 //System.out.println("Temppp"+temppp+" Tx_Data############ "+Data);
                 

                 
                 }catch(Exception ex) {

                     System.err.println(ex);
                 }
                 }// end of if 

                // System.out.println(irs4.getRow());
                 }
                 can_sup.originalDB_count("STUDENT",totalsize_student,inc_student);
                 can_sup.originalDB_count("BUSINESS",totalsize_business,inc_business);
                 can_sup.originalDB_count("MEDIA",totalsize_media,inc_media);
                 can_sup.originalDB_count("SPORTS",totalsize_sports,inc_sports);//table name to find frequent items
//                  try {
//                    Data= "<h4>"+Data+"</h4>";
//                 transaction_info.writeFile(Data);
//                 Data ="";
//                 }catch(Exception ex) {
//
//                     System.err.println(ex);
//                 }

                }
            catch (Exception ex) {
                System.out.println("Exception in admin:"+ex);
            }
            out.println("</table></div>");
               out.println("<div id=\"sidebar\"><h1>Menu</h1><ul class=\"sidemenu\"><li><a href=\"index.jsp\">Home</a></li>");
               out.println("<li><a href=\"computer.jsp\">Computers</a></li><li><a href=\"mobile.jsp\">Mobiles</a></li>");
               out.println("<li><a href=\"camera.jsp\">Cameras</a></li><li><a href=\"sports.jsp\">Sports</a></li><li><a href=\"others.jsp\">Others</a></li></ul>");
               /*out.println("<h1>Login</h1>");
               out.println("<form action=\"login\" method=\"post\">");
               out.println("<ul class=\"sidemenu\">");
               out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p>");
               out.println("<p><label>Password:</label><input type=\"password\" name=\"pword\"></p>");
               out.println("<p><input type=\"image\" src=\"images/signin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\">");
               out.println("</p>");
               out.println("</ul>");
               out.println("</form>");*/
               out.println("<h1>Registration</h1>");
               out.println("<form action=\"reg\" method=\"post\">");
               out.println("<ul class=\"sidemenu\">");
               out.println("<li><p>New User?<br>Register for Trade0nE ACCOUNT</p></li>");
               out.println("<li><a href=\"registration.jsp\"><font color=\"dc143c\" size=\"3\"><b>Sign up</b></font></a></li>");
               out.println("</ul></form>");
               out.println("<h1>Advertisements</h1>");
               out.println("<ul class=\"sidemenu\">");
               out.println("<li><img src=\"images/advt1.jpg\" width=70px height=70px alt=\"plasma TV\"/><br><c> Panasonic Viera </c>50-Inch Plasma HDTV Price:$900.00</br></li>");
               out.println("<li><img src=\"images/advt3.jpg\" width=70px height=70px alt=\"Watch\"/><br><c>IWC Portuguese </c>Perpetual Calendar 18kt Rose Gold Brown Watch:$25120.00 </li>");
               out.println("<li><img src=\"images/advt5.jpg\" width=70px height=70px alt=\"Digital Camera\"/><br><c>Sony Cybershot</c> 7.2 mp Digital Camera with 3x optical zoom Price:$180.00 </li></ul>");
               out.println("</div>");
               out.println("<!-- content-wrap ends here -->");
               out.println("</div></div>");
               out.println("<!-- footer starts here -->");
               out.println("<div id=\"footer-wrap\"><div id=\"footer-content\">");
               out.println("<div class=\"col float-left space-sep\">");
               out.println("<ul class=\"columns\"></ul>");
               out.println("</div>");
               out.println("<div class=\"col float-left\">");
               out.println("<ul class=\"columns\"></ul>");
               out.println("</div>");
               out.println("<div class=\"col2 float-right\">");
               out.println("</div>");
               out.println("</div></div>");
               out.println("<!--footer ends here -->");
               out.println("</body>");
               out.println("</html>");
        } finally {
            out.close();
        }
         RequestDispatcher rd = request.getRequestDispatcher("/admin");
         rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
