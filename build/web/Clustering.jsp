<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="promise.* , java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <%@ page import="java.sql.*" %>
<%@page import="cluster.*" %>
    <head>


<title>TradeOnE</title>

</head>

<body>

	
	

	<!-- content-wrap starts here  -->
	<div id="content-wrap"><div id="content">

	<div id="main">
        <h1>Clusters</h1>

    <table>
        <%int count = 0;
            ArrayList arrl = NewClass.getCluster();
            for (int i = 0; i < arrl.size(); i++) {
                ClusterBean cb = (ClusterBean) arrl.get(i);
                if (count != cb.getCluster_no()) {
                    out.print("<table border=\"1\"><tr>");

        out.print("<td colspan=\"2\"> Cluster_"+cb.getCluster_no()+"</td</tr>");
        out.print("<tr><td >Transaction_id </td><td> item</td></tr>");}
        out.print("<tr><td>"+cb.getTransaction_id()+"</td>");
        out.print("<td>"+cb.getItem()+"</td> </tr>");
        count = cb.getCluster_no();
            }
out.print("</table>"); %>
    </table>
    </div>


	<!-- footer starts here -->
	<div id="footer-wrap"><div id="footer-content">

		<div class="col float-left space-sep">
            <ul class="columns">	</ul>
        </div>
		
</body>
</html>














