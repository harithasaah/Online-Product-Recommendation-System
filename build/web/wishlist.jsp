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
			<li><a href="index.jsp" id="current">Home</a></li>
			
			<li><a href="productlist.jsp">ProductList</a></li>
			
			<li><a href="chat.jsp">Clich to Chat</a></li>
		</ul>

	</div></div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">

    <table> <tr><td><img src="ram.jpg" width="500" height="500"></td>
    </tr></table>
            <br>
            <b><font size="4"><span class="orange"> </span></font>

            </b><br>
            <table> 
                <%    try      {          
                                       if(session.getAttribute("USER")!=null)
                                                  {
                                                   String  username = (String) session.getAttribute("USER");
                                                    String item="";
                                                    ResultSet rs = null;
                                                    String query1= "SELECT  item FROM wishlist WHERE customer_name ='"+username+"' and isValid=1 ";
                                                    cluster.Db_connection.getOracleJDBCConnection();
                                                    Statement stmt1=cluster.Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                                                    out.print("<table>");
                                                    ResultSet rset=stmt1.executeQuery(query1);
                                                    while(rset.next())
                                                    {
                                                     item = rset.getString(1);
                                                    // out.print("fafasasdfadfgadfasdff *****"+item);

                                                     String query = "select * from items where item_id = Binary '"+item+"'";
                                                     Statement stmt = cluster.Db_connection.con.createStatement();
                                                     rs = stmt.executeQuery(query);
                                                     while(rs.next()) {
                                                     //out.println("zzzzzzzzzzzz");

                                                    out.println("<form action=\"wishlistprod.jsp\" method=\"post\">");
                                                    out.println("<tr><td><font size=\"2\" color=\"blue\">"+rs.getString(2)+"</font></td></tr>");
                                                    out.println("<tr><td><input type=\"hidden\" name=\"item\" value=\""+rs.getString(1)+"\"><input type=\"image\" src=\""+rs.getString(5)+"\" height=\"100\" width=\"100\"> </td>");
                                                    out.println("<td><font size=\"1\"> <p>"+rs.getString(3)+"<br>Price:"+rs.getString(4)+"</p></font></td></form>");
                                                    out.println("<td><form action=\"remove.jsp\" method =\"post\">" );
                                                    out.println("<input type=\"hidden\" name =\"ITEM\" value=\""+rs.getString(1)+"\"");
                                                    out.println("<font size =\"2\" color =\"blue\"><input type =\"Submit\" Value=\"RemoveItem\"></td></tr></form>");

                                                    }

                                                    }
                                                    //rset.close();
                                                    query1="";
                                             }
                                            }
                                             catch(Exception e)
                                             {
                                                 System.out.println("Exception in printing ritems for occup in login.java"+e);
                                             }
                                          //out.println("</table></div>");
                         %>

                          </table></div>


    </div>
	<div id="sidebar">
				<h1>Menu</h1>
				<ul class="sidemenu">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="computer.jsp">Computers</a></li>
					<li><a href="mobile.jsp">Mobiles</a></li>
					<li><a href="camera.jsp">Cameras</a></li>
					<li><a href="sports.jsp">Sports</a></li>
                                        <li><a href="others.jsp">Others</a></li>
                                        <li><a href="product.jsp">Make Ur WishList</a></li>
                                        <li><a href="wishlist.jsp"> WishList</a></li>
                                        <li><a href="friendList.jsp">Friend WishList</a></li>
                                       
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
