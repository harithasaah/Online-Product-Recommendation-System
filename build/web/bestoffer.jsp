
 <%
   String c=request.getParameter("item");
   String c1=c;
  
  String usernamec1=(String)session.getAttribute("USER");
  out.println(usernamec1);
  
//--------------------------------------------------------- 
 
  
  
  
  
//---------------------------------------------------------
 
  
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

   <%@page import=" cluster. * " %>
   <%@page import=" java.sql.* " %>
   <%@page import=" java.io.* " %>
   <%@page import=" javax. servlet. * " %>
   <%@page import=" javax. servlet. http.* "  %>
   
 
   
   
   
<html>

<head>
<link rel="stylesheet" href="images/tradeone.css" type="text/css" />

<title>TradeOnE</title>
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
	<div id="header-wrap">
            <div id="header-content">

        <h1 id="logo"><a href="index.jsp" title=""><span class="orange">Trade</span>On<span class="orange">E</span></a></h1>
        <h2 id="slogan"><font size="2">Bringing you Visibility , Velocity & Value</font></h2>

        <div id="header-links">
			<p>
				<font size="2"><a href="index.html">Logout</a></font>
			</p>
		</div>
		<!-- Menu Tabs -->
		<ul>
        <li><a href="bestoffer.jsp" >Best Offers for You</a></li>
			<li><a href="index.jsp">Home</a></li>
			
			<li><a href="index.jsp">ProductList</a></li>
			
		
		</ul>

	</div>
        </div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">
<table border='1' width='500'> 
    <tr>
        <th>Product</th>
        <th>Price</th>
        <th>Offer</th>
        <th>Discounted_Price</th>
    </tr>
  <%
   out.println(usernamec1);
  Connection con=null;
    Statement st1=null;
     ResultSet rs1=null;
     try
    {
        String url="jdbc:mysql://localhost:3306/webboss";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,"root","admin");
        st1 = con.createStatement();
 rs1=st1.executeQuery("select * from clickstore");
          int flag=0;
          while(rs1.next())
          {
             int offerusercount=rs1.getInt("count");
             String offerusername=rs1.getString("username");
             String offeruserlabel=rs1.getString("itemlabel");
             String offeruserlabel1=offeruserlabel.concat(".jpg");
             int offeruserprice=rs1.getInt("Price");
             double offerdiscount= offeruserprice*0.2;
             double offerdiscount1=offeruserprice-offerdiscount;
 
 if(usernamec1.equals(offerusername) && offerusercount>=10)
 {
     out.println("<tr> ");
     out.println("<td> ");
     out.println("<img src='images/"+offeruserlabel1+"' width='100' height='100px'/>");
     out.println("</td> ");
   
    

    out.println("<td> ");
    out.println(offeruserprice);
    out.println("</td> ");
    
    out.println("<td> ");
out.println("2% Offer");
    out.println("</td> "); 
    
    out.println("<td> ");
    out.println(offerdiscount1);
    out.println("</td> ");
    
    
    

    out.println("</tr> "); 
    
     
 }
 else
 {
     //out.println("<table border='1' width='500' height=''> "); 
  
   // out.println("<tr> ");
   // out.println("No Offers found...");
    //out.println("<td> ");
    
   // out.println("</tr> "); 
    // out.println("</table> ");
               
 }

             
          }
     }
     catch(Exception e)
         {
         
         }
             
 out.println("");
     out.println("</table> ");     

//---------------------------------------------------------
%>
        </div>
        
	<div id="sidebar">
				<h1>Menu</h1>
				<ul class="sidemenu">
                                    <li><a href="Nsports.jsp">Sports</a></li>
                                    <li><a href="Nmobile.jsp">Mobiles</a></li>
				<!--	<li><a href="index.jsp">Home</a></li>
					<li><a href="computer.jsp">Computers</a></li>
					<li><a href="mobile.jsp">Mobiles</a></li>
					<li><a href="camera.jsp">Cameras</a></li>
					<li><a href="sports.jsp">Sports</a></li>
                                        <li><a href="others.jsp">Others</a></li>
                                       --> <li><a href="product.jsp">Make Ur WishList</a></li>
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

