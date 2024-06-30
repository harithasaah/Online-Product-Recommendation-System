<%-- 
    
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
    
<html>

<head>

<link rel="stylesheet" href="images/tradeone.css" type="text/css" />
<script type="text/javascript">
    function reg()
    {
    if(document.login.uname.value=="")
    {
    	alert("Enter the username");
    	document.login.uname.focus();
    
    return false;
    }
    else
    if(document.login.pword.value=="")
    {
    	alert("Enter the password");
    	document.login.pword.focus();
    	return false;
    }
    }
    </script>

<title>TradeOnE</title>



</head>

<body >

	<!-- header starts here -->
	<div id="header-wrap"><div id="header-content">

       	<!-- <h1 id="logo"><a href="index.jsp" title=""><span class="orange"></span>On<span class="orange">E</span></a></h1>
        <h2 id="slogan"><font size="2">Bringing you Visibility , Velocity & Value</font></h2>	-->


		<div id="header-links">
			<p>
		 <h4> <a href="index.html">Logout</a></h4>
			
		</div>
        <!-- Menu Tabs -->
		

	</div></div>
	<table>
	<tr><th><a href="fusers.jsp">Frequent Users</a></th><th>Utility Users</th>
	<th colspan="2"><a href="fuusers.jsp">Frequent Utility Users</a> </th>
	
	</tr>
	</table>
<h3><a href="userdet.jsp"></a></h3>
	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">
    <h1>Welcome to TradeOnE...</h1>

    <form name="login" action="login" method="post" onSubmit="return reg();">
    <p >
       <table width="413" height="36" background="login.jpg">
  <tr>
<td><%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webboss","root","admin");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from cdetails where amt>=500000");
%>
<table align="center">
    <tr>
        <th>User_Id</th><th>User_Name</th><th>Email-Id</th><th>Amount</th>
    </tr>
<%
while(rs.next())
       { 
    %>
    <tr><td><%=rs.getInt("user_id")%> </td><td><%=rs.getString("user_name") %></td><td><%=rs.getString("email")%></td><td><%=rs.getInt("amt") %></td></tr>
<%}




%>
</table>
</td>
    </tr>
</table>
    
    </form>
    </div>
	<!-- content-wrap ends here -->
    </div>
	</div>

	<!-- footer starts here -->
	<div id="footer-wrap"><div id="footer-content">
	  <div class="col2 float-right">
	  </div>

	</div></div>
	<!--footer ends here -->

</body>
</html>