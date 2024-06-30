<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="org.jfree.chart.ChartFrame" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>
<%@ page import="org.jfree.data.*" %>
<%@ page import="org.jfree.data.jdbc.JDBCCategoryDataset"%>
<%@ page import="org.jfree.ui.*" %>
<%@ page import="org.jfree.chart.*"%>
<%@ page import=" org.jfree.chart.plot.*" %>
<%@ page import="org.jfree.data.xy.* "%>
<%@ page import="org.jfree.chart.axis.NumberAxis"%>

<%

   //String query="select transaction_id , slr from promise_trans";
  //String query="SELECT i.name,  c.c1newsup  AS items FROM candidate c, items i WHERE i.item_id = c.c1DB AND c1newsup!=0";
//JDBCCategoryDataset dataset=new JDBCCategoryDataset("jdbc:mysql://localhost:3306/webboss","com.mysql.jdbc.Driver","root","admin");
//final XYDataset dataset = createDataset();
//final JFreeChart chart = createChart(dataset);
//final XYDataset dataset ;
//final ChartPanel chartPanel = new ChartPanel(chart);
//public  XYDataset createDataset() {
final XYSeries series1 = new XYSeries("Test");
String query="select transaction_id , slr from promise_trans";
cluster.Db_connection.getOracleJDBCConnection();
try {
java.sql.ResultSet resultSet = cluster.Db_connection.stmt.executeQuery(query);
while(resultSet.next()) {
series1.add(resultSet.getInt(1), resultSet.getFloat(2));
}
/*final XYSeries series2 = new XYSeries("Max marks to pass the test");
series2.add(1.0, 40.0);
series2.add(2.0, 40.0);
series2.add(3.0, 40.0);
series2.add(4.0, 40.0);
series2.add(5.0, 40.0);
series2.add(6.0, 40.0);
series2.add(7.0, 40.0);
series2.add(8.0, 40.0);
series2.add(9.0, 40.0);
series2.add(10.0, 40.0);*/



final XYSeriesCollection dataset = new XYSeriesCollection();
dataset.addSeries(series1);
//dataset.addSeries(series2);
final JFreeChart chart = ChartFactory.createXYLineChart(
"SLR Ratio Comparison Chart",
"Transaction ",
"SLR",
dataset,
PlotOrientation.VERTICAL,
true,
true,
false
);
try
{
File image = new File("D:\\Haritha\\WebBoss1\\web\\images\\slrchart1.jpg");
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


}catch (Exception e) {
    System.err.println(e);
}



//return dataset;


//private JFreeChart createChart(final XYDataset dataset) {

//chart.setBackgroundPaint(Color.white);
//final XYPlot plot1 = chart.getXYPlot();
//plot1.setBackgroundPaint(Color.lightGray);
//plot1.setDomainGridlinePaint(Color.white);
//plot1.setRangeGridlinePaint(Color.white);
//
//final XYPlot plot2 = chart.getXYPlot();
//plot2.setBackgroundPaint(Color.lightGray);
//plot2.setDomainGridlinePaint(Color.white);
//plot2.setRangeGridlinePaint(Color.white);
//
//final XYPlot plot3 = chart.getXYPlot();
//plot3.setBackgroundPaint(Color.lightGray);
//plot3.setDomainGridlinePaint(Color.white);
//plot3.setRangeGridlinePaint(Color.white);

//return chart;
//}

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <!meta  http-equiv="refresh" content="1">
        <title>chart</title>
    </head>
  <body>
        <IMG SRC="images/slrchart1.png" WIDTH="100%" HEIGHT="50%" alt=""  BORDER="0" USEMAP="#chart">
    </body>
    </html>