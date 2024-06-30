<%--
     
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ page import="java.sql.*" %>
<%@page import="cluster.*" %>
<head>
<link rel="stylesheet" href="images/tradeone.css" type="text/css" />

<title>TradeOnE</title>

</head>

<body>

	<!-- header starts here -->
	<div id="header-wrap"><div id="header-content">

       	<!-- <h1 id="logo"><a href="index.jsp" title=""><span class="orange"></span>On<span class="orange">E</span></a></h1>
        <h2 id="slogan"><font size="2">Bringing you Visibility , Velocity & Value</font></h2>	-->
       	<!-- Menu Tabs -->
<ul>
			<li><a href="index.html" >Home</a></li>
			
			<li><a href="registration.jsp" id="current">Registration</a></li>
	  </ul>

	</div></div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">

    <table>
       <%   int i=0;
       String n[]=new String[60];
       String id[]=new String[60];
       String im[]=new String[60];
            Db_connection.getOracleJDBCConnection();
            if(Db_connection.con!=null)
            {
                 try{
                        Statement stmt=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                        String query = "select * from items order by item_id";
                        ResultSet resultset=stmt.executeQuery(query);
                        while(resultset.next())
                        {
                            id[i]=resultset.getString(1);
                            n[i]=resultset.getString(2);
                            im[i]=resultset.getString(5);
                            i++;
                        }
                        for(int j=0;j<i;j++)
                        {

                        %>
                        <tr><form action="#" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j]%>" ><font size="2" color="blue"><%= n[j] %></font></td>
                             </form>
                             <% if(id[j+1]!=null)
                                 { %>
                            <form action="#" method="post">
                                <td><input type="hidden" name="item" value="<%= id[j+1]%>"><font size="2" color="blue"><%= n[j + 1]%></font></td>
                             </form><%}%>
                              <% if(id[j+2]!=null)
                                 { %>
                            <form action="#" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j+2]%>" ><a href="prod.jsp"><font size="2" color="blue"><%= n[j+2] %></font></a></td>
                            </form><%}%>
                        </tr>

                        <tr>
                            <form action="#" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j]%>"><input type="image" src="<%= im[j]%>" height="100" width="100" > </td>
                            </form>
                             <% if(id[j+1]!=null)
                                 {%>
                            <form action="#" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j+1]%>"><input type="image" src="<%= im[j+1]%>" height="100" width="100" > </td>
                            </form><%}%>
                            <% if(id[j+2]!=null)
                                 {%>
                            <form action="#" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j+2]%>"><input type="image" src="<%= im[j+2]%>" height="100" width="100" > </td>
                            </form><%}%>
                        </tr>
                        <%j=j+2;
                        }
                 }
                 catch(Exception e)
                 {
                     System.out.println("Exception caught");
                 }
                 }%>
    </table>
    </div>
	<div id="sidebar">
				<h1>Menu</h1>
				<ul class="sidemenu"><li></li>
					<li><a href="index.html">Home</a></li>
					<li><a href="computerBl.jsp">Computers</a></li>
					<li><a href="mobileBl.jsp">Mobiles</a></li>
					<li><a href="cameraBl.jsp">Cameras</a></li>
					<li><a href="sportsBl.jsp">Sports</a></li>
                                        <li><a href="othersBl.jsp">Others</a></li>
				</ul>
                <h1>Login</h1>
            <form action="login" method="post">
            <ul class="sidemenu">
                <li><p>You Have Account?<br> Then, Login to Trade0nE ACCOUNT</p></li>
            <li><a href="login.jsp"><font color="dc143c" size="3"><b>Login</b></font></a></li>

            </ul>
            </form>
			<h1>Registration</h1>
            <form action="reg" method="post">
            <ul class="sidemenu">
            <li><p>New User?<br>Register for Trade0nE ACCOUNT</p></li>
            <li><a href="registration.jsp"><font color="dc143c" size="3"><b>Sign up</b></font></a></li>

              </ul>
      </form>

			<h1>Advertisements</h1>
			<ul class="sidemenu">

			<li><img src="images/advt1.jpg" width=70px height=70px alt="plasma TV"/><br><c> Panasonic Viera </c>50-Inch Plasma HDTV Price:$900.00</br></li>
			<li><img src="images/advt3.jpg" width=70px height=70px alt="Watch"/><br><c>IWC Portuguese </c>Perpetual Calendar 18kt Rose Gold Brown Watch:$25120.00 </li>
			<li><img src="images/advt5.jpg" width=70px height=70px alt="Digital Camera"/><br><c>Sony Cybershot</c> 7.2 mp Digital Camera with 3x optical zoom Price:$180.00 </li>			</ul>
	  </div>

	<!-- content-wrap ends here -->
	</div></div>

	<!-- footer starts here -->
	<div id="footer-wrap"><div id="footer-content">

		<div class="col float-left space-sep">
            <ul class="columns">	</ul>
        </div>
			<div class="col float-left">
            <ul class="columns">		</ul>

		</div>

		<div class="col2 float-right">
					</div>

	</div></div>
	<!--footer ends here -->

</body>
</html>

