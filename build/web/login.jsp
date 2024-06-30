<%-- 
    
--%>

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
    else{
    if(document.login.pword.value=="")
    {
    	alert("Enter the password");
    	document.login.pword.focus();
    	return false;
    }
    }}
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
				
			</p>
		</div>
        <!-- Menu Tabs -->
		<ul>
			<li><a href="inde.html">Home</a></li>
			<li><a href="registration.jsp" id="current">Registration</a></li>
			<li><a href="productlistBl.jsp">ProductList</a></li>
		</ul>

	</div></div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">
    <h1>Welcome to TradeOnE...</h1>

    <form name="login" action="login" method="post" onSubmit="return reg();">
    <p >
       <table width="413" height="222" background="login.jpg">
  <tr>
    <td>username</td>
    <td><label>
      <input name="uname" type="text" id="uname" />
    </label></td>
  </tr>
  <tr>
    <td>password</td>
    <td><label>
      <input type="password" name="pword" id="pword" />
    </label></td>
  </tr>
  <tr>
    <td height="30"><label>
      <input type="submit" name="Submit" value="Login" id="Login" />
    </label></td>
    <td><input type="reset" name="Cancel" value="Cancel" /></td>
  </tr>
</table>
    </p>
    </form>
    </div>
	<div id="sidebar">
				<h1>Menu</h1>
				<ul class="sidemenu">
					<li><a href="index.html">Home</a></li>
					<li><a href="#">Computers</a></li>
					<li><a href="#">Mobiles</a></li>
					<li><a href="#">Cameras</a></li>
					<li><a href="#">Sports</a></li>
                    <li><a href="#">Others</a></li>
				</ul>
            <!--
			<h1>Registration</h1>
            <form action="reg" method="post">
            <ul class="sidemenu">
            <li><p>New User?<br>Register for Trade0nE ACCOUNT</p></li>
            <li><a href="registration.jsp"><font color="dc143c" size="3"><b>Sign up</b></font></a></li>

                </ul>
                </form>-->

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