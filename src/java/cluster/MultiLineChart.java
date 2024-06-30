//package cluster;
//
///**
// * 
// * @author Uniqtech
// */
//import java.awt.*;
////import org.jfree.ui.*;
//import org.jfree.chart.*;
//import org.jfree.chart.plot.*;
//import org.jfree.data.xy.*;
//import org.jfree.chart.axis.NumberAxis;
//
//public class MultiLineChart //extends ApplicationFrame
//{
//public MultiLineChart(final String title) {
////super(title);
//final XYDataset dataset = createDataset();
//final JFreeChart chart = createChart(dataset);
//final ChartPanel chartPanel = new ChartPanel(chart);
//chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
////setContentPane(chartPanel);
//}
//private XYDataset createDataset() {
//final XYSeries series1 = new XYSeries("Test");
//
//series1.add(1.0, 60.0);
//series1.add(2.0, 80.0);
//series1.add(3.0, 35.0);
//series1.add(4.0, 100.0);
//series1.add(5.0, 95.0);
//series1.add(6.0, 85.0);
//series1.add(7.0, 70.0);
//series1.add(8.0, 30.0);
//series1.add(9.0, 45.0);
//series1.add(10.0, 50.0);
//
///*final XYSeries series2 = new XYSeries("Max marks to pass the test");
//series2.add(1.0, 40.0);
//series2.add(2.0, 40.0);
//series2.add(3.0, 40.0);
//series2.add(4.0, 40.0);
//series2.add(5.0, 40.0);
//series2.add(6.0, 40.0);
//series2.add(7.0, 40.0);
//series2.add(8.0, 40.0);
//series2.add(9.0, 40.0);
//series2.add(10.0, 40.0);*/
//
//final XYSeriesCollection dataset = new XYSeriesCollection();
//dataset.addSeries(series1);
////dataset.addSeries(series2);
//
//return dataset;
//}
//private JFreeChart createChart(final XYDataset dataset) {
//final JFreeChart chart = ChartFactory.createXYLineChart(
//"Marks obtained by students in tests",
//"Roll No of the students",
//"Marks",
//dataset,
//PlotOrientation.VERTICAL,
//true,
//true,
//false
//);
////chart.setBackgroundPaint(Color.white);
////final XYPlot plot1 = chart.getXYPlot();
////plot1.setBackgroundPaint(Color.lightGray);
////plot1.setDomainGridlinePaint(Color.white);
////plot1.setRangeGridlinePaint(Color.white);
////
////final XYPlot plot2 = chart.getXYPlot();
////plot2.setBackgroundPaint(Color.lightGray);
////plot2.setDomainGridlinePaint(Color.white);
////plot2.setRangeGridlinePaint(Color.white);
////
////final XYPlot plot3 = chart.getXYPlot();
////plot3.setBackgroundPaint(Color.lightGray);
////plot3.setDomainGridlinePaint(Color.white);
////plot3.setRangeGridlinePaint(Color.white);
//
//return chart;
//}
//public static void main(final String[] args) {
//final MultiLineChart demo = new MultiLineChart("Multi Line Chart");
///*demo.pack();
//RefineryUtilities.centerFrameOnScreen(demo);
//demo.setVisible(true);*/
//}
//}