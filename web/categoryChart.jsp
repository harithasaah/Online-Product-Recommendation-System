<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
 
<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>
<%@ page  import="org.jfree.chart.*" %>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>

<%
            double  student_size = servlets.admin.totalsize_student;
            double  sports_size  = servlets.admin.totalsize_sports;
            double  media_size   = servlets.admin.totalsize_media;
            double  businese_size = servlets.admin.totalsize_business;

            final DefaultPieDataset data = new DefaultPieDataset();
           /*data.setValue("Students", new Double(43.2));
            data.setValue("Sports", new Double(10));
            data.setValue("Media", new Double(27.5));
            data.setValue("Business", new Double(17.5));*/

             data.setValue("Students", new Double(student_size));
            data.setValue("Sports", new Double(sports_size));
            data.setValue("Media", new Double(media_size));
            data.setValue("Business", new Double(businese_size));
            /*data.setValue("Five", new Double(11.0));
            data.setValue("Six", new Double(19.4));*/

            JFreeChart chart = ChartFactory.createPieChart
            ("Pie Chart ", data, true, true, false);

            try {
                final ChartRenderingInfo info = new
              ChartRenderingInfo(new StandardEntityCollection());

                final File file1 = new File("D:\\Haritha\\WebBoss1\\web\\images\\piechart.png");
                ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
            } catch (Exception e) {
                out.println(e);
            }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pie Chart</title>
    </head>
    <body>
        <IMG SRC="images/piechart.png" WIDTH="600" HEIGHT="400" alt=""  BORDER="0" USEMAP="#chart">
    </body>
</html> 