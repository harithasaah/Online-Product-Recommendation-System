/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package servlets;

import cluster.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
public class fpurchase extends HttpServlet {
   public static String tabname="promise_trans";
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
        PrintWriter out = response.getWriter();
        try {
            //* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"images/tradeone.css\" type=\"text/css\" />");
            out.println("<title>TradeOnE</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"header-wrap\"><div id=\"header-content\">");
            out.println("<h1 id=\"logo\"><a href=\"index.jsp\" title=\"\"><span class=\"orange\">Trade</span>On<span class=\"orange\">E</span></a></h1>");
            out.println("<h2 id=\"slogan\"><font size=\"2\">Put your site slogan here...</font></h2>");
            out.println("<div id=\"header-links\"><p><font size=\"2\"><a href=\"index.html\">Logout</a></font></p></div>");
        	out.println("<ul><li><a href=\"index.jsp\" >Home</a></li><li><a href=\"registration.jsp\">Registration</a></li><li><a href=\"productlist.jsp\" id=\"current\">ProductList</a></li></ul></div></div>");
            out.println("<div id=\"content-wrap\"><div id=\"content\"><div id=\"main\">");
            out.println("<table>");
            String p_items= add2cart.items_bought;
            
          int amm=0;
            int transid=0;
            int transday=2;
            int cust_id=login.custid;
            int oc_id=0;
            if(login.custid !=0)
            {
                if(login.occupation.compareTo("Student")==0)
                    oc_id=1;
                else if(login.occupation.compareTo("Business")==0)
                    oc_id=2;
                else if(login.occupation.compareTo("Media")==0)
                    oc_id=3;
                else if(login.occupation.compareTo("Sports")==0)
                    oc_id=4;
            }


            Db_connection.getOracleJDBCConnection();
            if(Db_connection.con!=null)
            {
                try{
                Statement stmt1=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
             String pitm[]=p_items.split("(?!^)");
            
            for(int u=0;u<pitm.length;u++)
            {
                String ini=pitm[u];
                 Statement st1=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                ResultSet rst=st1.executeQuery("select price from items where item_id='"+ini+"'");
                while(rst.next())
                {
                    int am=rst.getInt("price");
                    amm=amm+am;
                    break;
                }
            }   
                
   Statement smt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);               
   ResultSet rss=smt.executeQuery("select * from cdetails where user_id='"+cust_id+"'");
   while(rss.next())
   {
       
       int aammt=rss.getInt("amt");
       int ccnt=rss.getInt("cunt");
       int ccunt=ccnt+1;
       int ammt=aammt+amm;
       smt.executeUpdate("update cdetails set amt='"+ammt+"',cunt='"+ccunt+"' where user_id='"+cust_id+"'");
       break;
   }
   
                    String query = "select * from " + tabname;
                    ResultSet resultset=stmt1.executeQuery(query);
                    resultset.last();
                    transid=resultset.getRow();
                    resultset.close();
                    stmt1.close();

                    Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
                   /// String quer="insert into "+tabname+"(trans_day,transaction_id,customer_id,items,occupation_id) values("+transday+","+ ++transid +","+ cust_id+",'"+p_items+"',"+oc_id+")";
                     String quer="insert into "+tabname+"(trans_day,transaction_id,user_id,items,category_id) values("+transday+","+ ++transid +","+ cust_id+",'"+p_items+"',"+oc_id+")";
                    int records=Db_connection.stmt.executeUpdate(quer);
                    add2cart.items_bought="";
                    out.println("<tr><td>Thank you..</td></tr>");
                    

                    out.println("<li><img src=\"images/advt1.jpg\" width=70px height=70px alt=\"plasma TV\"/><br><c> Panasonic Viera </c>50-Inch Plasma HDTV Price:$900.00</br></li>");


                }
                 catch (SQLException ex) {
                    System.out.println("exception in fpurchase:"+ ex);
                }

            }

               out.println("</table></div>");
               out.println("<div id=\"sidebar\"><h1>Menu</h1><ul class=\"sidemenu\"><li><a href=\"index.jsp\">Home</a></li>");
               out.println("<li><a href=\"computer.jsp\">Computers</a></li><li><a href=\"mobile.jsp\">Mobiles</a></li>");
               out.println("<li><a href=\"camera.jsp\">Cameras</a></li><li><a href=\"sports.jsp\">Sports</a></li><li><a href=\"product.jsp\">Make Ur WishList</a></li>"+
                                       "<li><a href=\"wishlist.jsp\"> WishList</a></li><li><a href=\"others.jsp\">Others</a></li></ul>");
               if(cust_id == 0)
               {
               out.println("<h1>Login</h1>");
               out.println("<form action=\"login\" method=\"post\">");
               out.println("<ul class=\"sidemenu\">");
               out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p>");
               out.println("<p><label>Password:</label><input type=\"password\" name=\"pword\"></p>");
               out.println("<p><input type=\"image\" src=\"images/signin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\">");
               out.println("</p>");
               out.println("</ul>");
               out.println("</form>");
               }
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
