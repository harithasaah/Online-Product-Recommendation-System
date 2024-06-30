<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
    
<html>

<head>
<link rel="stylesheet" href="images/tradeone.css" type="text/css" />
<script type="text/javascript">
    function reg1()
    {
    if(document.regi.name.value=="")
    {
    	alert("Enter the username");
    	document.regi.name.focus();

    return false;
    }
    else
    if(document.regi.pwd.value=="")
    {
    	alert("Enter the password");
    	document.regi.pwd.focus();
    	return false;
    }
    

    else
        if(document.regi.occup.value=="- SELECT Categry -")
            {
    	alert("Select the catery");
    	document.regi.occup.focus();
    	return false;
    }
    else
        if(document.regi.Date.value=="Date")
            {
    	alert("Select the Date");
    	document.regi.Date.focus();
    	return false;
    }
    else
        if(document.regi.Month.value=="Month")
            {
    	alert("Select the Month");
    	document.regi.Month.focus();
    	return false;
    }
    else
        if(document.regi.Year.value=="Year")
            {
    	alert("Select the Year");
    	document.regi.Year.focus();
    	return false;
    }
    else
        if(document.regi.mail.value=="")
            {
    	alert("Enter the Mail-Id");
    	document.regi.mail.focus();
    	return false;
    }
    else

        if(document.regi.Month.value=="02" && document.regi.Date.value=="30" || document.regi.Date.value=="31")
            {
    	alert("Select The Valid Date");
    	document.regi.Date.focus();
    	return false;
    }
 }
    </script>

<title>TradeOnE</title>



</head>

<body>

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
			<li><a href="indexBl.jsp">Home</a></li>
			<li><a href="registration.jsp" id="current">Registration</a></li>
			<li><a href="productlistBl.jsp">ProductList</a></li>
		</ul>

	</div></div>

	<!-- content-wrap starts here -->
	<div id="content-wrap"><div id="content">

	<div id="main">
    <h1>Welcome to TradeOnE...</h1>
<form action="regster" method="post" name="regi" onsubmit="return reg1();" >
   <!--<form action="reg" method="post" name="regi" onsubmit="return reg1();" >-->
 <!--  <form name="login" action="login" method="post" onSubmit="return reg();">-->
    <table bgcolor="#FFCCFF">
        <tr><td>
       
               <font size="3" color="a52a2a">Name:</td><td>
                        <input  type="text" name="name" size="15" width="140" height="30" ></td><td colspan="2"><%
try
               {
String ms=request.getParameter("mm");
if(ms!=null)
                                                   {
                            out.println("User Name Already Existing, Pls Try Some Other Name");
                                                       }
}

catch(Exception e)
               {
    out.println(e);
       }%></td>
        </tr><tr>   <td colspan="4"> (At least 6 characters & 12 characters max are allowed)</td></tr><tr><td>
        <font size="3" color="a52a2a" >Password:</td><td colspan="3">
        <input type="password" name="pwd" size="15" width="140" height="30" maxlength="12">
       </td></tr><tr><td>
         <!--<label><font size="3" color="a52a2a" >Retype Password:
        <input type="password" name="pwd2" size="35" width="140" height="30" maxlength="12"></font></label>
        <br><br><br>-->
        <font size="3" color="a52a2a">DateOfBirth:</td><td>
        <select name="Date"><option>Date</option>
		<option>01</option>
		<option>02</option>
		<option>03</option>
		<option>04</option>
		<option>05</option>
		<option>06</option>
		<option>07</option>
		<option>08</option>
		<option>09</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
		<option>13</option>
		<option>14</option>
		<option>15</option>
		<option>16</option>
		<option>17</option>
		<option>18</option>
		<option>19</option>
		<option>20</option>
		<option>21</option>
		<option>22</option>
		<option>23</option>
		<option>24</option>
		<option>25</option>
		<option>26</option>
		<option>27</option>
		<option>28</option>
		<option>29</option>
		<option>30</option>
		<option>31</option>
		</select> </td><td>
		 <select name="Month">
		 <option>Month</option>
		<option>01</option>
		<option>02</option>
		<option>03</option>
		<option>04</option>
		<option>05</option>
		<option>06</option>
		<option>07</option>
		<option>08</option>
		<option>09</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
				</select></td><td>
		 <select name="Year">
		 <option>Year</option>
                 <option>2022</option>
                 <option>2021</option>
                 <option>2020</option>
                 <option>2019</option>
                 <option>2018</option>
                 <option>2017</option>
                 <option>2016</option>
                 <option>2015</option>
                 <option>2014</option>
                 <option>2013</option>
                 <option>2012</option>
                 <option>2011</option>
                 <option>2010</option>
                 <option>2009</option>
                 <option>2008</option>
                 <option>2007</option>
                 <option>2006</option>
                 <option>2005</option>
                 <option>2004</option>
                 <option>2003</option>
                 <option>2002</option>
                 <option>2001</option>
                 <option>2000</option>
                 <option>1999</option>
                 <option>1998</option>
                 <option>1997</option>
                 <option>1996</option>
                 <option>1995</option>
		<option>1994</option>
		<option>1993</option>
		<option>1992</option>
		<option>1991</option>
		<option>1990</option>
		<option>1989</option>
		<option>1988</option>
		<option>1987</option>
		<option>1986</option>
		<option>1985</option>
		<option>1984</option>
		<option>1983</option>
		<option>1982</option>
		<option>1981</option>
		<option>1980</option>
		<option>1979</option>
		<option>1978</option>
		<option>1977</option>
		<option>1976</option>
		<option>1975</option>
		<option>1974</option>
		<option>1973</option>
		<option>1972</option>
		<option>1971</option>
		<option>1970</option>
		<option>1969</option>
		<option>1968</option>
		<option>1967</option>
		<option>1966</option>
		<option>1965</option>
		<option>1964</option>
                <option>1963</option>
		<option>1962</option>
		<option>1961</option>
		<option>1960</option>
		<option>1959</option>
		<option>1958</option>
		<option>1957</option>
		<option>1956</option>
		<option>1955</option>
		<option>1954</option>
		<option>1953</option>
		<option>1952</option>
                <option>1951</option>
                <option>1950</option>
                 </select></td></tr><tr><td>
        
        <label><font size="3" color="a52a2a">Preference:</td><td colspan="3">
        <select name="occup">
    <option> - SELECT Categry - </option>
    <option value="Student">Student</option>
   <option value="Business">Buisness</option>
    <option value="Media">Media</option>
    <option value="Sports">Sports</option>
  <!--  <option value="others"> Others </option> -->
        </select></td></tr>
                 <tr><td>
        <font size="3" color="a52a2a">E-Mail:</td><td colspan="3">
        <input type="email" name="mail" size="35" width="140" height="100">
                          </td></tr> <tr><td colspan="4">
   <!--     <input align="center" type="image" src="images/accept.jpg" onmouseover="this.src='images/acceptover.jpg';" onmouseout="this.src='images/accept.jpg';" width="140" height="30" />-->
   <input type="submit" name="Submit" value="Submit" id="reg" /></td></tr>
    
    </table>
	
	
    </form>
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
                    </form><!--
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