<%-- 
   
--%>

html>
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





  <%
       java.io.File file =null;
       java.io.FileReader fr =null;
       java.io.BufferedReader  br =null;
      try{

        String data ="";
         file = new java.io.File("D:\\Haritha\\WebBoss1\\Frequent_Item.doc");
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
