<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@ page import="org.jfree.chart.ChartFrame" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>
<%@ page import="org.jfree.data.*" %>
<%@ page import="org.jfree.data.jdbc.JDBCCategoryDataset"%>

<%
  String query="select transaction_id , slr from promise_trans";
  //String query="SELECT i.name,  c.c1newsup  AS items FROM candidate c, items i WHERE i.item_id = c.c1DB AND c1newsup!=0";
JDBCCategoryDataset dataset=new JDBCCategoryDataset("jdbc:mysql://localhost:3306/webboss","com.mysql.jdbc.Driver","root","admin");

dataset.executeQuery(query);
JFreeChart chart = ChartFactory .createBarChart3D(
"SLR Ratio Comparison Chart",
"Transaction ",
"SLR",
dataset,
PlotOrientation.VERTICAL,true, true, false);

try
{
File image = new File("D:\\Haritha\\WebBoss1\\web\\images\\slrchart.jpg");
ChartUtilities.saveChartAsJPEG(image, chart,1000, 600);
FileInputStream fileInStream=new FileInputStream(image);
ServletOutputStream outStream=response.getOutputStream();
long fileLength;
byte[] byteStream;

fileLength = image.length();
byteStream = new byte[(int)fileLength];
fileInStream.read(byteStream, 0, (int)fileLength);

response.setContentType("image/jpg");
response.setContentLength((int)fileLength);
fileInStream.close();
outStream.write(byteStream);
outStream.close();

}
catch (IOException e)
{
System.out.println("Problem in creating chart.");
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <!meta  http-equiv="refresh" content="1">
        <title>chart</title>
    </head>
  <body>
        <IMG SRC="images/slrchart.png" WIDTH="100%" HEIGHT="50%" alt=""  BORDER="0" USEMAP="#chart">
    </body>
    </html>