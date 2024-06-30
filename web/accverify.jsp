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
<SCRIPT type="text/javascript">
window.history.forward();
function noBack()
{
window.history.forward();
}
function accvl(){
    if(document.acval.un.value==0 || document.acval.pas.value==0 || document.acval.key.value==0)
        {
            alert("Please Enter all the Values")
            return false;
        }
        
        
}
</SCRIPT>


</head>

<body onLoad="noBack();"
onpageshow="if (event.persisted) noBack();" onUnload="">

    <form name="acval" action="accverifyJ.jsp" onsubmit="return accvl()">

<table align="center">
<tr>
<td height="2" colspan="2"></td>
</tr>
<tr>
<td height="131" colspan="2" align="center"><h1>Account Verification Process</h1></td>
</tr>
<tr>
<th width="194" height="38" align="right">
User Name</th>
<td width="239">
<input type="text" name="un"/></td>
</tr>
<tr>
<th height="41" align="right">Password</th>
<td><input type="password" name="pas"/></td>
</tr>
<tr>
<th height="43" align="right">Key</th>
<td><input type="text" name="key"/></td>
</tr>
<tr>
<td height="45" colspan="2" align="center"><input type="submit" value="SUBMIT"/></td>
</tr>
<tr>
    <td>
        <%
            String ms=request.getParameter("m");
            if(ms!=null)
            {
                if(ms.equals("s"))
                                       {
                    out.println("Please Enter the key to Activate your Account, Check your mail to get key.");
                }
                else
                                       {
                out.println("Please Enter the Keyword Again");
                               }
            }


%>
    </td>
</tr>
</table>
    </form>
</body>
</html>

