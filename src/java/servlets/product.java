/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package servlets;

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
public class product extends HttpServlet {

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
            /* TODO output your page here*/
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
            out.println("<ul><li><a href=\"index.jsp\" id=\"current\">Home</a></li><li><a href=\"registration.jsp\">Registration</a></li><li><a href=\"index.html\">ProductList</a></li></ul></div></div>");
            out.println("<div id=\"content-wrap\"><div id=\"content\"><div id=\"main\">");
            out.println("<table><tr><td><img src=\"images/index.jpg\" width=\"500\" height=\"400\"></td></tr></table>" +
                     "<table><tr><td><a href=\"productlist.jsp\">click here to see the product list</a></td></tr></table></div>");
            out.println("<div id=\"sidebar\"><h1>Menu</h1><ul class=\"sidemenu\"><li><a href=\"index.jsp\">Home</a></li>");
            out.println("<li><a href=\"computer.jsp\">Computers</a></li><li><a href=\"mobile.jsp\">Mobiles</a></li>");
               out.println("<li><a href=\"camera.jsp\">Cameras</a></li><li><a href=\"sports.jsp\">Sports</a></li><li><a href=\"others.jsp\">Others</a></li></ul>");
            out.println("<h1>Login</h1><form action=\"login\" method=\"post\"><ul class=\"sidemenu\">");
            out.println("<p><label>Username:<input type=\"text\" name=\"uname\"></label></p><p><label>Password:</label><input type=\"password\" name=\"pword\"></p>");
            out.println("<p><input type=\"image\" src=\"images/signin.jpg\" onmouseover=\"this.src=\'images/signinover.jpg\';\" onmouseout=\"this.src=\'images/signin.jpg\';\"></p>");
            out.println("<h1>Registration</h1><form action=\"reg\" method=\"post\"><ul class=\"sidemenu\">");
            out.println("<li><p>New User?<br>Register for Trade0nE ACCOUNT</p></li><li><a href=\"registration.jsp\">Sign up</a></li></ul></form>");
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
