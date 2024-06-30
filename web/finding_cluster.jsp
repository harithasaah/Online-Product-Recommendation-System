<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="promise.* ,cluster.* , java.util.*" %>
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
			<li><a href="index.jsp" id="current">Home</a></li>
		
			<li><a href="productlist.jsp">ProductList</a></li>
		</ul>

	</div></div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">
        <h1>Finding  Best Cluster Through Cost Comparsion </h1>

    <table>
        <tr>
            <td>item Label </td>
            <td>Item_Name</td>

        </tr>

           <%int count = 0;
            ArrayList arrl = NewClass.getItem_info();
            for (int i = 0; i < arrl.size(); i++) {
              out.print(arrl.get(i)); }
//out.print("</table>"); %>
         
    </table>
<div>

    <span>


        <h3> For Clustering </h3>

        <h3>Threshold Value of Min_support is .6(60%)  </h3></br>
        <h3>Threshold Value of Max_ceiling is .3(30%)</h3></br>

        
        <h4>IF Item Support > Min_support(60%)</h4></br>
             <h4>Then large Item = item </h4> </br>
         
             <h4>  IF Item Support < Max_ceiling(30%)</h4> </br>
             <h4> Then small Item = Item </h4></br>

            <h2> Calculating Cost : </h2></br>
            <h4> inter cluster similarity    =  Large Items total – union of Large Items </h4></br>
            <h4>intra_cluster_dissimilarity =  union of Small Items</h4></br>

           <h4>cost = inter cluster similarity + intra_cluster_dissimilarity  </h4></br>




            <h3>For  Association : </h3></br>

            <h2> Finding  Frequent Item Set of DataBase </br></h2>

            <h2>  ThresHold value of  min_support is (float)0.3; </br></h2>


            <h4 > frequent itemsets (min_PL)</br>
                Min_Sup(db) = min_support*total_size(Table)</br></br>
                min_PL  =  Min_Sup(db) – ((maxsup)/total_size )*inc_size) </br> </br>


               min_sup(DB) is minimum support count for an original database </br>
               maxsupp is maximum support count of itemsets</br>
               total_size of Table</br>
               inc_size of Table</br> </br> </h4>

            <h4><font color="blue"> IF Item Support Count > min_sup(DB)</br>
               Then </br>
               Item to be a Frequent Item .</br></br>


               IF (Item Support Count >= min_PL   and Item Support Count < min_sup(DB)) </br>
               Then </br>
               Item to be a Promise Frequent Item . </br></font> </h4>








</span> 
    <br>
    <br>
  <%--  <%=cluster.cluster_transactions.Data_html   %> --%>

  <%
       java.io.File file =null;
       java.io.FileReader fr =null;
       java.io.BufferedReader  br =null;
      try{

        String data ="";
         file = new java.io.File("D:\\Haritha\\WebBoss1\\Transaction_info_new.doc");
         fr = new java.io.FileReader(file);
         br = new java.io.BufferedReader(fr);

        while ((data=br.readLine())!=null){
                out.println(data);
            }

      }catch(Exception ex) {

          System.out.println(ex);

          }

          finally {
              fr.close();
              br.close();


         }


  %>


</div>


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
            <h1>Login</h1>
            <form action="login" method="post">
            <ul class="sidemenu">
                <p><label>Username:<input type="text" name="uname"></label></p>
                <p><label>Password:</label><input type="password" name="pword"></p>
                <p><input type="image" src="images/signin.jpg" onmouseover="this.src='images/signinover.jpg';" onmouseout="this.src='images/signin.jpg';">
                    </p>
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
