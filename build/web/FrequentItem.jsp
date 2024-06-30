<%-- 
    
--%>

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




    <br>
    <br>
  <%--  <%=cluster.cluster_transactions.Data_html   %> --%>

  <%    java.sql.Statement stmt   =null;
        java.sql.Connection con = null;
        java.sql.ResultSet rs = null;
        java.sql.ResultSet rs1 = null;
        java.sql.ResultSet rs2 = null;
        java.sql.ResultSet rs3 = null;
        String L2 ="";
        String L3 ="";
        String L4 ="";
        String PL2 ="";
        String PL3 ="";
        int L2sup =0;
        int L3sup =0;
        int L4sup =0;

       

        try {
            Class.forName("com.mysql.jdbc.Driver");
//           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con  = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","admin");
            System.out.println("Connection created "+con);
            stmt = con.createStatement();
          }catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
             } catch (SQLException ex) {
            System.err.println("SQLException: (in Db_connection) " + ex.getMessage());
        }
         out.println("<h3> maximum  Frequent item set is Student category </h4></br>");
                rs = stmt.executeQuery("SELECT  L2,L2sup FROM student WHERE L2sup =  (SELECT  MAX(L2Sup) FROM student)");
                if(rs.next()) {
                   L2 = rs.getString("L2");
                   L2sup= rs.getInt("L2sup");
                   out.print("<h4>L2   &nbsp;&nbsp;&nbsp;&nbsp;  "+L2 );
                   out.print("  &nbsp;&nbsp;&nbsp;&nbsp; L2sup  &nbsp;&nbsp;&nbsp;&nbsp;   "+L2sup+"<br/>");

                }

                  rs = stmt.executeQuery("SELECT  L3,L3sup FROM student WHERE L3sup =  (SELECT  MAX(L3Sup) FROM student)");
                if(rs.next()) {
                   L3 = rs.getString("L3");
                   L3sup= rs.getInt("L3sup");
                out.print("<h4>L3 &nbsp;&nbsp;&nbsp;&nbsp;    "+L3 );
                   out.print("&nbsp;&nbsp;&nbsp;&nbsp;  L3sup &nbsp;&nbsp;&nbsp;&nbsp;    "+L3sup+"<br/>");


                }

                 rs = stmt.executeQuery("SELECT  L4,L4sup FROM student WHERE L4sup =  (SELECT  MAX(L4Sup) FROM student)");
                if(rs.next()) {
                   L4 = rs.getString("L4");
                   L4sup= rs.getInt("L4sup");
                  out.print("<h4>L4  &nbsp;&nbsp;&nbsp;&nbsp;   "+L4 );
                   out.print(" &nbsp;&nbsp;&nbsp;&nbsp;  L4sup  &nbsp;&nbsp;&nbsp;&nbsp;    "+L4sup+"<br/>");

                }


               if(L2sup >L3sup)

                   if(L2sup> L4sup)
                    {
                       out.println("<h4>Maximum Freqquent Item_set  in category student is   "+L2+ " support count is   "+L2sup+"</h4><br/>");
                    }
               else if (L3sup >L4sup)
                      out.println("<h4> Maximum Freqquent Item_set  in category student is   "+L3+ " support count is   "+L3sup+"</h4><br/>");

              else
                     out.println("<h4> Maximum Freqquent Item_set  in category student is   "+L4+ " support count is   "+L4sup+"</h4><br/>");


                 out.println("<h3> maximum  Frequent item set is business category </h4></br>");
                 
                 rs1 = stmt.executeQuery("SELECT  L2,L2sup FROM business WHERE L2sup =  (SELECT  MAX(L2Sup) FROM business)");
                if(rs1.next()) {
                   L2 = rs1.getString("L2");
                   L2sup= rs1.getInt("L2sup");
                   out.print("<h4>L2   &nbsp;&nbsp;&nbsp;&nbsp;  "+L2 );
                   out.print("  &nbsp;&nbsp;&nbsp;&nbsp; L2sup  &nbsp;&nbsp;&nbsp;&nbsp;   "+L2sup+"<br/>");

                }

                  rs1 = stmt.executeQuery("SELECT  L3,L3sup FROM business WHERE L3sup =  (SELECT  MAX(L3Sup) FROM business)");
                if(rs1.next()) {
                   L3 = rs1.getString("L3");
                   L3sup= rs1.getInt("L3sup");
                out.print("<h4>L3 &nbsp;&nbsp;&nbsp;&nbsp;    "+L3 );
                   out.print("&nbsp;&nbsp;&nbsp;&nbsp;  L3sup &nbsp;&nbsp;&nbsp;&nbsp;    "+L3sup+"<br/>");


                }

                 rs1 = stmt.executeQuery("SELECT  L4,L4sup FROM business WHERE L4sup =  (SELECT  MAX(L4Sup) FROM business)");
                if(rs1.next()) {
                   L4 = rs1.getString("L4");
                   L4sup= rs1.getInt("L4sup");
                  out.print("<h4>L4  &nbsp;&nbsp;&nbsp;&nbsp;   "+L4 );
                   out.print(" &nbsp;&nbsp;&nbsp;&nbsp;  L4sup  &nbsp;&nbsp;&nbsp;&nbsp;    "+L4sup+"<br/>");

                }


               if(L2sup >L3sup)

                   if(L2sup> L4sup)
                    {
                       out.println("<h4>Maximum Freqquent Item_set  in category business is   "+L2+ " support count is   "+L2sup+"</h4><br/>");
                    }
               else if (L3sup >L4sup)
                      out.println("<h4> Maximum Freqquent Item_set  in category business is   "+L3+ " support count is   "+L3sup+"</h4><br/>");

              else
                     out.println("<h4> Maximum Freqquent Item_set  in category business is   "+L4+ " support count is   "+L4sup+"</h4><br/>");




                 out.println("<h3> maximum  Frequent item set is Media category </h4></br>");



           rs2 = stmt.executeQuery("SELECT  L2,L2sup FROM media WHERE L2sup =  (SELECT  MAX(L2Sup) FROM media)");
                if(rs2.next()) {
                   L2 = rs2.getString("L2");
                   L2sup= rs2.getInt("L2sup");
                   out.print("<h4>L2   &nbsp;&nbsp;&nbsp;&nbsp;  "+L2 );
                   out.print("  &nbsp;&nbsp;&nbsp;&nbsp; L2sup  &nbsp;&nbsp;&nbsp;&nbsp;   "+L2sup+"<br/>");

                }

                  rs2 = stmt.executeQuery("SELECT  L3,L3sup FROM media WHERE L3sup =  (SELECT  MAX(L3Sup) FROM media)");
                if(rs2.next()) {
                   L3 = rs2.getString("L3");
                   L3sup= rs2.getInt("L3sup");
                out.print("<h4>L3 &nbsp;&nbsp;&nbsp;&nbsp;    "+L3 );
                   out.print("&nbsp;&nbsp;&nbsp;&nbsp;  L3sup &nbsp;&nbsp;&nbsp;&nbsp;    "+L3sup+"<br/>");


                }

                 rs2 = stmt.executeQuery("SELECT  L4,L4sup FROM media WHERE L4sup =  (SELECT  MAX(L4Sup) FROM media)");
                if(rs2.next()) {
                   L4 = rs2.getString("L4");
                   L4sup= rs2.getInt("L4sup");
                  out.print("<h4>L4  &nbsp;&nbsp;&nbsp;&nbsp;   "+L4 );
                   out.print(" &nbsp;&nbsp;&nbsp;&nbsp;  L4sup  &nbsp;&nbsp;&nbsp;&nbsp;    "+L4sup+"<br/>");

                }


               if(L2sup >L3sup)

                   if(L2sup> L4sup)
                    {
                       out.println("<h4>Maximum Freqquent Item_set  in category media is   "+L2+ " support count is   "+L2sup+"</h4><br/>");
                    }
               else if (L3sup >L4sup)
                      out.println("<h4> Maximum Freqquent Item_set  in category media is   "+L3+ " support count is   "+L3sup+"</h4><br/>");

              else
                     out.println("<h4> Maximum Freqquent Item_set  in category media is   "+L4+ " support count is   "+L4sup+"</h4><br/>");



              out.println("<h3> maximum  Frequent item set is Sports category </h4></br>");

               rs3 = stmt.executeQuery("SELECT  L2,L2sup FROM sports WHERE L2sup =  (SELECT  MAX(L2Sup) FROM sports)");
                if(rs3.next()) {
                   L2 = rs3.getString("L2");
                   L2sup= rs3.getInt("L2sup");
                   out.print("<h4>L2   &nbsp;&nbsp;&nbsp;&nbsp;  "+L2 );
                   out.print("  &nbsp;&nbsp;&nbsp;&nbsp; L2sup  &nbsp;&nbsp;&nbsp;&nbsp;   "+L2sup+"<br/>");

                }

                  rs3 = stmt.executeQuery("SELECT  L3,L3sup FROM sports WHERE L3sup =  (SELECT  MAX(L3Sup) FROM sports)");
                if(rs3.next()) {
                   L3 = rs3.getString("L3");
                   L3sup= rs3.getInt("L3sup");
                out.print("<h4>L3 &nbsp;&nbsp;&nbsp;&nbsp;    "+L3 );
                   out.print("&nbsp;&nbsp;&nbsp;&nbsp;  L3sup &nbsp;&nbsp;&nbsp;&nbsp;    "+L3sup+"<br/>");


                }

                 rs3 = stmt.executeQuery("SELECT  L4,L4sup FROM sports WHERE L4sup =  (SELECT  MAX(L4Sup) FROM sports)");
                if(rs3.next()) {
                   L4 = rs3.getString("L4");
                   L4sup= rs3.getInt("L4sup");
                  out.print("<h4>L4  &nbsp;&nbsp;&nbsp;&nbsp;   "+L4 );
                   out.print(" &nbsp;&nbsp;&nbsp;&nbsp;  L4sup  &nbsp;&nbsp;&nbsp;&nbsp;    "+L4sup+"<br/>");

                }


               if(L2sup >L3sup)

                   if(L2sup> L4sup)
                    {
                       out.println("<h4>Maximum Freqquent Item_set  in category sports is   "+L2+ " support count is   "+L2sup+"</h4><br/>");
                    }
               else if (L3sup >L4sup)
                      out.println("<h4> Maximum Freqquent Item_set  in category sports is   "+L3+ " support count is   "+L3sup+"</h4><br/>");

              else
                     out.println("<h4> Maximum Freqquent Item_set  in category sports is   "+L4+ " support count is   "+L4sup+"</h4><br/>");
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
