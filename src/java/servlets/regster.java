/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
public class regster extends HttpServlet {

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
            
            
          
            String name=request.getParameter("name");
            String pwd=request.getParameter("pwd");
            String date=request.getParameter("Date");
            String month=request.getParameter("Month");
            String year=request.getParameter("Year");
            String category=request.getParameter("occup");
            String email=request.getParameter("mail");
           // String number=request.getParameter("number");
            String[] k=name.split("(?!^)");
            String[] p=year.split("(?!^)");
            String k1=k[0];
            String k2=p[0];
            String k3=k[1];
            String k4=p[2];
            String skey=k1+k2+k3+k4;
        
        int i=0;    
        int id=0;
        
            Class.forName("com.mysql.jdbc.Driver");
           Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webboss","root","admin");
           
            
        Statement st=con.createStatement();
           
            
             
         st.executeUpdate("insert into cdetails(user_name,password,date,month,year,category,email,sckey,status) values('"+name+"','"+pwd+"','"+date+"','"+month+"','"+year+"','"+category+"','"+email+"','"+skey+"','0')");
        
            response.sendRedirect("mail?k="+skey+"&m="+email);
        }
        catch(Exception e)
        {
            out.println(e);
        }
        finally {            
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

