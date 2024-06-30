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


		<div id="header-links">
			<p>
                <font size="2"><a href="index.html">Logout</a></font>
			</p>
		</div>
        <!-- Menu Tabs -->
		<ul>
			<li><a href="index.jsp" >Home</a></li>
                        
			
			<li><a href="productlist.jsp" id="current">ProductList</a></li>
                        <li><a href="bestoffer.jsp" >Best Offers for You</a></li>
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
       String price[] = new String[60];
       String manu [] = new String[60];
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
                            price[i]= resultset.getString(4);
                            manu [i] = resultset.getString(3);
                            i++;
                        }
                                               for(int j=0;j<i;j++)
                        {
                            if(id[j]!=null)
                            {
                         %>
                        <tr><form action="prod.jsp" method="get">
                            <td><input type="hidden" name="item" value="<%= id[j]%>" ><font size="2" color="blue"><%= n[j] %></font></td>
                             </form>
                             <%
                             }
                            if(id[j+1]!=null)
                                 {%>
                            <form action="prod.jsp" method="post">
                                <td><input type="hidden" name="item" value="<%= id[j+1]%>"><font size="2" color="blue"><%= n[j + 1]%></font></td>
                             </form><%}%>
                              <% if(id[j+2]!=null)
                                 {%>
                            <form action="prod.jsp" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j+2]%>" ><a href="prod.jsp"><font size="2" color="blue"><%= n[j+2] %></font></a></td>
                            </form><%}%>
                        </tr>

                        <tr>
                            <%if(id[j]!=null)
                            {%>
                            <form action="prod.jsp" method="post">
                                <td><input type="hidden" name="item" value="<%= id[j]%>"><input type="image" src="<%= im[j]%>" height="100" width="100" onmouseover="document.getElementById('ring<%= im[j]%>').style.display='inline';" onmouseout="document.getElementById('ring<%= im[j]%>').style.display='none';" > <div id="ring<%= im[j]%>" style="display:none; z-index:200; border:1px solid #000; width:200px; position:absolute;  background-image:url(images/bgforbox2.png); background-repeat:repeat;"><table width="200" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><strong> Lable : <%=id[j]%></strong><br />
        name  :<%=n[j]%> <br /> Price  :<%=price[j]%><br /> Manufacturer :<%=manu[j]%><br />
      <em>Click on the image to buy</em> </td>
  </tr>
</table></div> </td>
                            </form>
                        <%     } if(id[j+1]!=null)
                                 {%>
                            <form action="prod.jsp" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j+1]%>"><input type="image" src="<%= im[j+1]%>" height="100" width="100" onmouseover="document.getElementById('ring<%= im[j+1]%>').style.display='inline';" onmouseout="document.getElementById('ring<%= im[j+1]%>').style.display='none';" ><div id="ring<%= im[j+1]%>" style="display:none; z-index:200; border:1px solid #000; width:200px; position:absolute;  background-image:url(images/bgforbox2.png); background-repeat:repeat;"><table width="200" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><strong> Lable : <%=id[j+1]%></strong><br />
      name  :<%=n[j+1]%>  <br />Price  :<%=price[j+1]%><br /> Manufacturer :<%=manu[j+1]%><br />
      <em>Click on the image to buy</em></td>
  </tr>
</table></div> </td>
                            </form><%}%> <% if(id[j+2]!=null)
                                 {%>
                            <form action="prod.jsp" method="post">
                            <td><input type="hidden" name="item" value="<%= id[j+2]%>"><input type="image" src="<%= im[j+2]%>" height="100" width="100" onmouseover="document.getElementById('ring<%= im[j+2]%>').style.display='inline';" onmouseout="document.getElementById('ring<%= im[j+2]%>').style.display='none';"><div id="ring<%= im[j+2]%>" style="display:none; z-index:200; border:1px solid #000; width:200px; position:absolute;  background-image:url(images/bgforbox2.png); background-repeat:repeat;"><table width="200" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><strong> Lable : <%=id[j+2]%></strong><br />
      name  :<%=n[j+2]%>  <br />Price  :<%=price[j+2]%><br /> Manufacturer :<%=manu[j+2]%><br />
      <em>Click on the image to buy</em></td>
  </tr>
</table></div> </td>
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
				<ul class="sidemenu">
					<<li><a href="index.jsp">Home</a></li>
					<li><a href="computer.jsp">Computers</a></li>
					<li><a href="mobile.jsp">Mobiles</a></li>
					<li><a href="camera.jsp">Cameras</a></li>
					<li><a href="sports.jsp">Sports</a></li>
                                        <li><a href="others.jsp">Others</a></li>
                                        <li><a href="product.jsp">Make Ur WishList</a></li>
                                        <li><a href="wishlist.jsp"> WishList</a></li>
                                        <li><a href="friendList.jsp"> Friend WishList</a></li>
                 
				</ul>
            

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

