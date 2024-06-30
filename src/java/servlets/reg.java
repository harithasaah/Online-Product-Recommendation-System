/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package servlets;
import java.sql.*;
import cluster.*;
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
public class reg extends HttpServlet {

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
          try{
              int am=0;
              int ct=0;
              int i=0,ii=0,flag=0;
             String name=request.getParameter("name");
            String pwd=request.getParameter("pwd");
          //m  Date dob1= java.sql.Date.valueOf(request.getParameter("dob"));
            String date=request.getParameter("Date");
            String month=request.getParameter("Month");
            String year=request.getParameter("Year");
            String category=request.getParameter("occup");
            String mail=request.getParameter("mail");
            String invalid = " "; // Invalid character is a space
            int  minLength = 6; // Minimum length

            Db_connection.getOracleJDBCConnection();

            if(Db_connection.con!=null)
            {
                try{
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"images/tradeone.css\" type=\"text/css\" />");
            out.println("<title>TradeOnE</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"header-wrap\"><div id=\"header-content\">");
            out.println("<h1 id=\"logo\"><a href=\"login.jsp\" title=\"\"><span class=\"orange\">Trade</span>On<span class=\"orange\">E</span></a></h1>");
            out.println("<h2 id=\"slogan\"><font size=\"2\">Bringing you Visibility , Velocity & Value</font></h2>");
        	out.println("<div id=\"header-links\"><p><font size=\"2\"></font></p></div>");
            out.println("<ul><li><a href=\"indexBl.jsp\" id=\"current\">Home</a></li><li><a href=\"registration.jsp\">Registration</a></li><li><a href=\"indexBl.jsp\">ProductList</a></li></ul></div></div>");
            out.println("<div id=\"content-wrap\"><div id=\"content\"><div id=\"main\">");
            if (pwd.length() < minLength) {
            out.println("Your password must be at least " + minLength + " characters long.<br>");
            out.println("<a href=\"registration.jsp\">tryagain</a></div>");
            out.println("<table><tr><td><img src=\"sorry.jpg\" width=\"500\" height=\"400\"></td></tr></table></div>");
            flag=1;
            }
            if(flag==0)
            {
                Statement st=Db_connection.con.createStatement();
                ResultSet rs=st.executeQuery("select user_name from cdetails where user_name='"+name+"'");
                while(rs.next())
                {
                    response.sendRedirect("registration.jsp?mm=alr");
                    flag=2;
                    break;
                    
                }
                if(flag==0)
                {
                    
                    Statement stmt1=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                    String query = "select * from cdetails";
                    ResultSet resultset=stmt1.executeQuery(query);
                    resultset.last();
                    i=resultset.getRow();
                    //out.println(i);
                    PreparedStatement pst = Db_connection.con.prepareStatement("insert into cdetails values(?,?,AES_ENCRYPT(?,'pwd'),?,?,?,?,?,?,?)");
                    pst.setInt(1,++i);
                    pst.setString(2,name);
                    pst.setString(3,pwd);
                    pst.setString(4,date);
                    pst.setString(5,month);
                    pst.setString(6,year);
                    pst.setString(7,category);
                    pst.setString(8,mail);
                    pst.setInt(9,am);
                    pst.setInt(10,ct);
                    ii = pst.executeUpdate();
      if(ii!=0){
        out.println("<h1>Thank You...</h1><table><tr><td><img src=\"Welcome.jpg\" width=\"500\" height=\"400\"></td></tr></table></div>");

      }
      else{
        out.println("<h1>Please enter valid data..<br> sorry try again..</h1>");
        out.println("<table><tr><td><img src=\"sorry.jpg\" width=\"500\" height=\"400\"></td></tr></table></div>");
      }

                }
            }
                }
             catch(Exception e)
                {
                    out.println("exception is in reg.java"+e);
                }
                out.println("<div id=\"sidebar\"><h1>Menu</h1><ul class=\"sidemenu\"><li><a href=\"indexBl.jsp\">Home</a></li>");
out.println("<li><a href=\"computerBl.jsp\">Computers</a></li><li><a href=\"mobileBl.jsp\">Mobiles</a></li>");
               out.println("<li><a href=\"cameraBl.jsp\">Cameras</a></li><li><a href=\"sportsBl.jsp\">Sports</a></li>" +
                                       " <li><a href=\"othersBl.jsp\">Others</a></li></ul>");
            //    out.println("<h1>Login</h1><form action=\"login\" method=\"post\"><ul class=\"sidemenu\">");
             //   out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p><p><label>Password:</label><input type=\"password\" name=\"pword\"></p>");
             //   out.println("<p><input type=\"image\" src=\"images/signin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\"></p>");



                        out.println("<h1>Login</h1><form action=\"login\" method=\"post\"><ul class=\"sidemenu\">");
          //m              out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p><p><label>Password:</label><input type=\"password\" name=\"pword\"></p>");
    out.println("<p>You Have Account?<br> Then, Login to Trade0nE ACCOUNT</p>");
                   //m     out.println("<p><input type=\"image\" src=\"images/signin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\"></p>");
    out.println("<a href=\"login.jsp\"><h3><b>Login</b></h3></a>");
                        out.println("</ul></form>");
 //m out.println("<a href=\"registration.jsp\">tryagain</a></div>");

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
