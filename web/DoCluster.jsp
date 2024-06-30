<%-- 
      
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Docluster</title>
        <script language="javascript">

    function getCluster(){

    str ="cluster";
    /*if(str=="")   {
    document.getElementById("cluster").innerHTML="";
    return;
    }*/

    if (window.XMLHttpRequest)    {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
    }
    else  {
    // code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)    {
    document.getElementById("cluster").innerHTML=xmlhttp.responseText;
    //document.getElementById('details').style.display='inline';

    }
    }
    xmlhttp.open("GET","Clustering.jsp?q="+str,true);

    xmlhttp.send();

}
  var cluster=setInterval("getCluster()",2000);
   //alert("hai cluster"+cluster);

</script>
    </head>
    <body  onload ="cluster" >
     
        <div id ="cluster">


        </div>


    </body>
</html>
