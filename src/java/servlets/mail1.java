package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.Security;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static servlets.mail.processRequest;

public class mail1 extends HttpServlet {

    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_PORT = "465";
    private static final String emailFromAddress = "mailfromcloud4@gmail.com";
   
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String message = request.getParameter("k");
            String s = request.getParameter("m");

            String emailMsgTxt = "Test Message Contents";
            String emailSubjectTxt = "A test from gmail";

            String[] recipients = s.split(",");

            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            boolean debug = true;

            Properties props = new Properties();

            props.put("mail.smtp.host", SMTP_HOST_NAME);

            props.put("mail.smtp.auth", "true");

            props.put("mail.debug", "true");
            props.put("mail.smtp.port", SMTP_PORT);
            props.put("mail.smtp.socketFactory.port", SMTP_PORT);
            props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.put("mail.smtp.socketFactory.fallback", "false");
            //I added
            props.put("mail.smtp.ssl.enable", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("mailfromcloud4", "Corona1!@#");
                    
                }
            });

            session.setDebug(debug);

            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(emailFromAddress);
            msg.setFrom(addressFrom);

            InternetAddress[] addressTo = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                addressTo[i] = new InternetAddress(recipients[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);

// Setting the Subject and Content Type
            msg.setSubject(emailSubjectTxt);
            msg.setContent(message, "text/plain");
            Transport.send(msg);
            System.out.println("Sucessfully Sent mail to All Users");
            
            response.sendRedirect("accverify.jsp");

        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(mail1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(mail1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
