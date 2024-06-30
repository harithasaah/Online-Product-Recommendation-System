<%-- 
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
<link rel="stylesheet" href="images/tradeone.css" type="text/css" />

<title> </title>
<SCRIPT type="text/javascript">
window.history.forward();
function noBack()
{
window.history.forward();
}
</SCRIPT>
</head>

<body onLoad="noBack();"
onpageshow="if (event.persisted) noBack();" onUnload="">

  
    <%
    
    String username=request.getParameter("un");
    String password=request.getParameter("pas");
    String key=request.getParameter("key");
    
     Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webboss","root","admin");
            int f=0;
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from cdetails");
            while(rs.next())
                               {
                String usr=rs.getString("user_name");
                String pas=rs.getString("password");
                String ky=rs.getString("sckey");
                
                if(usr.equals(username) && pas.equals(password) && ky.equals(key))
                                       {
                    st.executeUpdate("update cdetails set status='"+1+"' ");
                   session.setAttribute( "USER",username);
                   f=1;
                   break;
                }
            }
            if(f==1)
                               {
                 response.sendRedirect("login.jsp");
                 
            }
            else
                               {
                  response.sendRedirect("accverify.jsp?m=a");
            }
          
    
    session.setAttribute( "USER",username);
    



%>

</body>
</html> 
