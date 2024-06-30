<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<link rel="stylesheet" href="images/tradeone.css" type="text/css" />

<title>Trade OnE</title>

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
    <a href=index.html ><b>Logout</b></a>>

	<!-- header starts here -->
	<div id="header-wrap"><div id="header-content">

      	<!-- <h1 id="logo"><a href="index.jsp" title=""><span class="orange"></span>On<span class="orange">E</span></a></h1>
        <h2 id="slogan"><font size="2">Bringing you Visibility , Velocity & Value</font></h2>	-->

        <div id="header-links">
			<!--<p>
				<font size="2"><a href="index.html">Logout</a></font>
			</p>
		</div>
		<!-- Menu Tabs -->
		<ul>
			<li><a href="index.jsp" id="current">Home</a></li>
			
			<li><a href="productlist.jsp">Product List</a></li>
		</ul>

	</div></div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">

    <table> <tr><td>
       <img src="images/index.jpg" width="450" height="350">
            </td></tr>
    <tr><td>
        <form accept="admin" method="post">
       <p align="center" ><input type="submit" value="DoAssociation"></p></form>
    </td></tr></table>
    </div>
	<div id="sidebar" >
				<h1>Menu</h1>
				<ul class="sidemenu">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="">Computers</a></li>
					<li><a href="">Mobiles</a></li>
					<li><a href="">Cameras</a></li>
					<li><a href="sports.jsp">Sport</a></li>
                                        <li><a href="product.jsp">Make Ur WishList</a></li>
                                        <li><a href="wishlist.jsp"> WishList</a></li>
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
