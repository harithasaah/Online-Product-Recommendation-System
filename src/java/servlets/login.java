/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package servlets;

import cluster.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.mail.Session;
import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */
public class login extends HttpServlet {
    public static int custid=0;
    public static String occupation="";
    String query1="";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //String sessionid= request.getRequestedSessionId();
        //HttpSession session=request.getSession(true);

        PrintWriter out = response.getWriter();
HttpSession session=request.getSession(true);

        try{
            String username=request.getParameter("uname");
            String pwd=request.getParameter("pword");
            int i=0,ii=0,j=0;
            String itid[]=new String[20];
            Db_connection.getOracleJDBCConnection();
            if(Db_connection.con!=null)
            {
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"images/tradeone.css\" type=\"text/css\" />");
                out.println("<title>TradeOnE</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div id=\"header-wrap\"><div id=\"header-content\">");
                out.println("<ul><li><a href=\"index.html\" id=\"current\">LOGOUT</a></li></ul>");
                out.println("<h1 id=\"logo\"><a href=\"index.jsp\" title=\"\"><span class=\"orange\">Trade</span>On<span class=\"orange\">E</span></a></h1>");
                out.println("<h2 id=\"slogan\"><font size=\"2\">Bringing you Visibility , Velocity & Value</font></h2>");
                out.println("<div id=\"header-links\"><p><font size=\"2\"><a href=\"index.html\"></a></font></p></div>");
        	out.println("<ul><li><a href=\"bestoffer.jsp\" id=\"current\">Best Offers for You</a></li><li><a href=\"index.jsp\" id=\"current\">Home</a></li><li><a href=\"productlist.jsp\">ProductList</a></li><li><a href=\"offer.jsp\">Offers to You  </a></li></ul></div></div>");
                out.println("<div id=\"content-wrap\"><div id=\"content\"><div id=\"main\">");
              out.println("<table><tr><td><img src=\"Welcome1.jpg\" width=\"500\" height=\"400\"></td></tr></table>" +
                      "<table><!--<tr><td><a href=\"productlist.jsp\"> product list</a>  | <a href=\"finding_cluster.jsp\">Asociation & Cluster</a> |<a href=\"algorithm.jsp\">Details </a> </td></tr>-->");
                try{

                    Statement stmt=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                    String query = "select * from cdetails";
                    ResultSet resultset=stmt.executeQuery(query);

                    while(resultset.next())
                    {
                        String uname=resultset.getString(2);
                        if(username.compareTo(uname)==0)
//                            if(username.compareTo(uname)==0)
                        {
                          i=1;
                            if(pwd.compareTo(resultset.getString(3))==0 && resultset.getInt(12)==1)
//                                 if(pwd.compareTo(resultset.getString(3))==0 && resultset.getInt(12)==1)
                            {
                                ii=1;
                                if(username.compareTo("admin")==0)
//                                    if(username.compareTo("admin")==0)
                                {
                                    response.sendRedirect("adminA.jsp");

                                        out.println("<tr><td><form action=\"admin\" method=\"post\"><p align=\"center\" ><input type=\"submit\" value=\"DoAssociation\"></p></form> <a href =\"#\"></td></tr>");
                                        out.println("<tr><td><form action=\"clustering\" method=\"post\"><p align=\"center\" ><input type=\"submit\" value=\"DoClustering\"></p></form></td></tr>");
                                      

                                        out.println("</table></div>");
                                }

                                
                                else
                                {
                                    add2cart.items_bought="";
                                    custid=resultset.getInt(1);
                                    occupation=resultset.getString(7);
                                    System.out.println("custid"+custid);
                                    session.setAttribute("cid", custid);
                                    if(occupation.compareTo("Student")==0)
                                        query1 = "select * from items where item_id>'"+(char)(64)+"' and item_id<'"+(char)(75)+"'";
                                    else if(occupation.compareTo("Business")==0)
                                        query1 = "select * from items where item_id>'"+(char)(74)+"' and item_id<'"+(char)(85)+"'";
                                    else if(occupation.compareTo("Media")==0)
                                        query1 = "select * from items where item_id>'"+(char)(96)+"' and item_id<'"+(char)(107)+"'";
                                    else if(occupation.compareTo("Sports")==0)
                                        query1 = "select * from items where item_id>'"+(char)(106)+"' and item_id<'"+(char)(117)+"'";


                                             try{
                                                    Statement stmt1=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);

                                                    ResultSet rset=stmt1.executeQuery(query1);
                                                    while(rset.next())
                                                    {
                                                    out.println("<form action=\"prod.jsp\" method=\"post\">");
                                                    out.println("<tr><td><font size=\"2\" color=\"blue\">"+rset.getString(2)+"</font></td></tr>");
                                                    out.println("<tr><td><input type=\"hidden\" name=\"item\" value=\""+rset.getString(1)+"\"><input type=\"image\" src=\""+rset.getString(5)+"\" height=\"100\" width=\"100\"> </td>");
                                                    out.println("<td><font size=\"1\"> <p>"+rset.getString(3)+"<br>Price:"+rset.getString(4)+"</p></font></td></tr></form>");

                                                    }
                                                    rset.close();
                                                    query1="";
                                             }
                                             catch(Exception e)
                                             {
                                                 System.out.println("Exception in printing ritems for occup in login.java"+e);
                                             }

                                        out.println("</table></div>");
                                        out.println("<div id=\"header-links\"><p><font size=\"2\" color=\"006400\">Welcome<b> "+username+"</b></font></p></div>");
                                  //      HttpSession session = request.getSession(true);
                                        session.setAttribute( "USER",username);

                                    }
                            }
                        }
                    }







            //    out.println("<h1>Login</h1><form action=\"login\" method=\"post\"><ul class=\"sidemenu\">");
             //   out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p><p><label>Password:</label><input type=\"password\" name=\"pword\"></p>");
             //   out.println("<p><input type=\"image\" src=\"images/signin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\"></p>");

                    if(ii==0 || i==0)
                    {
                         out.println("<table><tr><td><img src=\"sorry.jpg\" width=\"500\" height=\"400\"></td></tr></table>" );
                        out.println("<h1>Login</h1><form action=\"login\" method=\"post\"><ul class=\"sidemenu\">");
                        out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p><p><label>Password:<input type=\"password\" name=\"pword\"></label></p>");
                        out.println("<p><input type=\"image\" src=\"singin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\"></p>");
                        out.println("INVALID USERID or PASSWORD");
                        out.println("TRY AGAIN");
                        out.println("</ul></form>");
                        out.println("<h1>Registration</h1><form action=\"reg\" method=\"post\"><ul class=\"sidemenu\">");
                        out.println("<li><p>New User?<br>Register for Trade0nE ACCOUNT</p></li><li><a href=\"registration.jsp\">Sign up</a></li></ul></form>");
                    }
                }
                catch(Exception e)
                {
                    out.println("exception is in login.java"+e);
                }
                out.println("<h1>Advertisements</h1><ul class=\"sidemenu\">");
                out.println("<li><img src=\"images/advt1.jpg\" width=70px height=70px alt=\"plasma TV\"/><br><c> Panasonic Viera </c>50-Inch Plasma HDTV Price:$900.00</br></li>");
                out.println("<li><img src=\"images/advt3.jpg\" width=70px height=70px alt=\"Watch\"/><br><c>IWC Portuguese </c>Perpetual Calendar 18kt Rose Gold Brown Watch:$25120.00 </li>");
                out.println("<li><img src=\"images/advt5.jpg\" width=70px height=70px alt=\"Digital Camera\"/><br><c>Sony Cybershot</c> 7.2 mp Digital Camera with 3x optical zoom Price:$180.00 </li>");
                out.println("</ul></div><!-- content-wrap ends here --></div></div><!-- footer starts here -->");
                out.println("<div id=\"footer-wrap\"><div id=\"footer-content\"><div class=\"col float-left space-sep\">");
                out.println("<ul class=\"columns\">	</ul></div><div class=\"col float-left\"><ul class=\"columns\"></ul></div>");
                out.println("<div class=\"col2 float-right\"></div></div></div><!--footer ends here -->");
                out.println("</body>");
                out.println("</html>");
    }
        else{
            out.println("didnt get connection");
         }
    }
    finally { out.close(); }
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
