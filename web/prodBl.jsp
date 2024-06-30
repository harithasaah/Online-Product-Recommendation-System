<%-- 
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@page import=" cluster. * " %>
   <%@page import=" java.sql.* " %>
   <%@page import=" java.io.* " %>
   <%@page import=" javax. servlet. * " %>
   <%@page import=" javax. servlet. http.* "  %>
<html>

<head>
<link rel="stylesheet" href="images/tradeone.css" type="text/css" />

<title>TradeOnE</title>

</head>

<body>

	<!-- header starts here -->
	<div id="header-wrap"><div id="header-content">

        <h1 id="logo"><a href="index.jsp" title=""><span class="orange">Trade</span>On<span class="orange">E</span></a></h1>
        <h2 id="slogan"><font size="2">Bringing you Visibility , Velocity & Value</font></h2>

        <!-- Menu Tabs -->
<ul>
			<li><a href="index.jsp">Home</a></li>
			
			<li><a href="registration.jsp">Registration</a></li>
	  </ul>

	</div></div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">

    <table> 
        <% String itemid=request.getParameter("item");
            PrintWriter o=response.getWriter();
            //o.println(itemid);
           Db_connection.getOracleJDBCConnection();
            if(Db_connection.con!=null)
            {
                 try{
                        Statement stmt=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                        String query = "select * from items order by item_id";
                        ResultSet resultset=stmt.executeQuery(query);

                        while(resultset.next())
                        {
                            if(itemid.compareTo(resultset.getString(1))==0)
                            {
                        %>
                                <form action="add2cart" method="post">
                                <tr><td><font size="5" color="#191970"><%=resultset.getString(2)%></font></td></tr>
                                <tr><td><img src="<%=resultset.getString(5)%>" height="450" width="450"></td></tr>
                                <tr><td><p><font size="3" color="#191970"><%=resultset.getString(3)%></font></p></td></tr>
                                <tr><td><font size="3" color="#191970">Price:<%=resultset.getString(4)%></font></td></tr>
                                <tr><td><p align="center"><input type="hidden" name="Buttonname" value="<%= itemid%>"><input type="image" src="images/cart.jpg" onmouseover="this.src='images/cartover.jpg';" onmouseout="this.src='images/cart.jpg';"></p></td></tr></form>
                                
                                <%  }

                        //else{
                          //  %>
                            <!--wwwwwwwwwwwwwwwwwwwwwwww-->
                            <%
                            }
                        
                    }catch(Exception e)
                    {
                        System.out.println("Exception in prod:"+e);
                    }
                 }
               %>
       
            </table>
    </div>
	<div id="sidebar">
				<h1>Menu</h1>
				<ul class="sidemenu">
					<li><a href="indexBl.jsp">Home</a></li>
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

