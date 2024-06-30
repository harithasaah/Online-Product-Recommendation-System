/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */
package servlets;

import cluster.*;
import promise.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author 
 */
public class add2cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static String items_bought="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Db_connection.getOracleJDBCConnection();
        String it1=request.getParameter("Buttonname");
        String it[]=new String[100];
        String tabname=null;
        int i=0,r=0,k=0,pos=0,rr=0,z=0,j=0,zz=-1;
        int g[]=new int[600];
        char y[]=new char[200];
        String n1[]=new String[500];
        String id1[]=new String[600];
        String im1[]=new String[600];
        String d1[]=new String[600];
        String p1[]=new String[600];
        String col_name="";
        String ritem="";

        try {

            char q=it1.charAt(0);
            items_bought+=it1;
            System.out.println("items bought are: "+items_bought);
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"images/tradeone.css\" type=\"text/css\" />");
            out.println("<title>TradeOnE</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"header-wrap\"><div id=\"header-content\">");
            out.println("<h1 id=\"logo\"><a href=\"index.jsp\" title=\"\"><span class=\"orange\">Trade</span>On<span class=\"orange\">E</span></a></h1>");
            out.println("<h2 id=\"slogan\"><font size=\"2\">Bringing you Visibility , Velocity & Value</font></h2>");
            out.println("<div id=\"header-links\"><p><font size=\"2\"><a href=\"index.html\">Logout</a></font></p></div>");
            out.println("<ul><li><a href=\"index.jsp\" >Home</a></li><li><a href=\"registration.jsp\">Registration</a></li><li><a href=\"productlist.jsp\" id=\"current\">ProductList</a></li></ul></div></div>");
            out.println("<div id=\"content-wrap\"><div id=\"content\"><div id=\"main\">");
            out.println("<table>");//<tr><td><img src=\"images/"+q+".jpg\" width=\"500\" height=\"400\"></td></tr>");
             try{
                        Statement stmt=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                        String query = "select * from items order by item_id";
                        ResultSet resultset=stmt.executeQuery(query);
                        while(resultset.next())
                        {
                            if(it1.compareTo(resultset.getString(1))==0)
                            {

                                out.println("<tr><td><font size=\"5\" color\"#191970\">"+resultset.getString(2)+"</font></td></tr>");
                                out.println("<tr><td><img src=\""+resultset.getString(5)+"\" height=\"450\" width=\"450\"></td></tr>");
                                out.println("<tr><td><p><font size=\"3\" color=\"#191970\">"+resultset.getString(3)+"</font></p></td></tr>");
                                out.println("<tr><td><font size=\"3\" color=\"#191970\">Price:"+resultset.getString(4)+"</font></td></tr>");
                                out.println("<form action=\"fpurchase\" method=\"post\">");
                                out.println("<tr><td>If you have finished your purchase click on the submit button</td></tr>");
                                out.println("<tr><td><p align=\"center\"><input type=\"hidden\" name=\"fbutton\" value=\"true\"><input type=\"image\" src=\"images/submit.jpg\" onmouseover=\"this.src=\'images/submitover.jpg\';\" onmouseout=\"this.src=\'images/submit.jpg\';\"></p></td></tr></form></table>");
                            }
                        }
                        resultset.close();
                        stmt.close();
             }

             catch(Exception e1)
             {
                 System.out.println("Exception at buying items: (in add2cart)"+e1);
             }
             if(((int)q>64) && ((int)q<75))
                //out.println("rrrrrrrrrr");
                tabname="student";
            else if(((int)q>74) && ((int)q<85))
                tabname="business";
            else if(((int)q>96) && ((int)q<107))
                tabname="media";
            else if(((int)q>106) && ((int)q<117))
                tabname="sports";

            i=0;
            if(items_bought.length()==1)
                col_name="l2";
            else if(items_bought.length()==2)
                col_name="l3";
            else if(items_bought.length()==3) 
                 col_name="l4";
            else if(items_bought.length()>3)
            {
                tabname="clusteryam";
                col_name="item";
            }
               try {
                    Statement st = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
                    String s="select "+col_name+",count from "+tabname+" where "+col_name+" is not null order by count";
                    ResultSet r1=st.executeQuery(s);
                    r1.last();
                    int w=r1.getRow();
                    r1.beforeFirst();
                    while(r1.next())
                    {
                        it[i]=r1.getString(1);
                        int length=it[i].length();
                        k = can_sup.isSubsequence(items_bought,it[i]);
                        if(k==1 || k==2)
                        {
                           for(int i1=0;i1<it[i].length();i1++)
                           {
                               if(it[i].charAt(i1)!=',')
                               {
                                    if(items_bought.indexOf(it[i].charAt(i1))< 0)
                                    {
                                        ritem+=it[i].charAt(i1);
                                    }
                               }
                           }
                        }
                        i++;
                    }

                    r1.close();
                    st.close();
                    r=0;
                    for(int j1=0;j1<ritem.length();j1++)
                    {
                               y[r++]=ritem.charAt(j1);
                    }

                    i=0;
                    out.println("<table><tr><td><h2><font color=\"#daa520\">Our recommendations for You:</font></h2></td></tr></table><table>");
                    try{
                        Statement stmt=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                        String query = "select * from items order by item_id";
                        ResultSet resultset=stmt.executeQuery(query);
                        while(resultset.next())
                        {
                            id1[i]=resultset.getString(1);
                            n1[i]=resultset.getString(2);
                            d1[i]=resultset.getString(3);
                            p1[i]=resultset.getString(4);
                            im1[i]=resultset.getString(5);
                            i++;
                        }
                        for(int ii=0;ii<r;ii++)
                        {
                            for(j=0;j<i;j++)
                            {
                                if(y[ii]==id1[j].charAt(0))
                                {
                                    g[z]=j;
                                    z++;
                                }
                            }
                        }
                        for(rr=0;rr<z;rr++)
                        {
                            j=g[rr];
                            out.println("<form action=\"prod.jsp\" method=\"post\">");
                            out.println("<tr><td><font size=\"2\" color=\"blue\">"+ n1[j]+"</font></td></tr>");
                            out.println("<tr><td><input type=\"hidden\" name=\"item\" value=\""+id1[j]+"\"><input type=\"image\" src=\""+im1[j]+"\" height=\"100\" width=\"100\"> </td>");
                            out.println("<td><font size=\"1\"> <p>"+d1[j]+"<br>Price:"+p1[j]+"</p></font></td></tr></form>");
                        }
                        out.println("</table></div>");
                 }
                 catch(Exception e)
                 {
                     System.out.println("Exception caught in printing related items:  (in add2cart)"+e);
                 }


               out.println("<div id=\"sidebar\"><h1>Menu</h1><ul class=\"sidemenu\"><li><a href=\"index.jsp\">Home</a></li>");
               out.println("<li><a href=\"computer.jsp\">Computers</a></li><li><a href=\"mobile.jsp\">Mobiles</a></li>");
               out.println("<li><a href=\"camera.jsp\">Cameras</a></li><li><a href=\"sports.jsp\">Sports</a></li><li><a href=\"product.jsp\">Make Ur WishList</a></li>" +
                       "<li><a href=\"wishlist.jsp\"> WishList</a></li><li><a href=\"others.jsp\">Others</a></li></ul>");
   /*          out.println("<h1>Login</h1>");
               out.println("<form action=\"login\" method=\"post\">");
               out.println("<ul class=\"sidemenu\">");
               out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p>");
               out.println("<p><label>Password:</label><input type=\"password\" name=\"pword\"></p>");
               out.println("<p><input type=\"image\" src=\"images/signin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\">");
               out.println("</p>");
               out.println("</ul>");
               out.println("</form>");
               out.println("<h1>Registration</h1>");
               out.println("<form action=\"reg\" method=\"post\">");
               out.println("<ul class=\"sidemenu\">");
               out.println("<li><p>New User?<br>Register for Trade0nE ACCOUNT</p></li>");
               out.println("<li><a href=\"registration.jsp\"><font color=\"dc143c\" size=\"3\"><b>Sign up</b></font></a></li>");
               out.println("</ul></form>");*/
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
             }catch(Exception e1)
             {
               System.out.println("Exception caught in finding related items:"+e1);
             }

               out.println("</body>");
               out.println("</html>");


        }finally {
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
