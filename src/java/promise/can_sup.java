/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package promise;
import java.sql.*;
import java.sql.SQLException;
import cluster.*;
import servlets.*;
/**
 *
 * @author
 */
public class can_sup {
    public static float max_sup=0;
    public static float min_support=(float)0.3;
    public static float min_support_old,min_PL=0,min_support_new;
    public static int[] index=new int[220];
    public static String[] c2items=new String[220];
    public static String[] c3items=new String[220];
    public static String[] c4items=new String[220];
    public static String Data1="";
   // public static String Data_item ="";
    public static int k =0;

   

    public static void originalDB_count (String tname,float tsize,float isize) throws Exception
    {
        try{

             Statement stmt1 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query1="select * from "+tname;//Use Main.tab_name;
             ResultSet resultset1=stmt1.executeQuery(query1);
             resultset1.last();
             resultset1.beforeFirst();
             int i=0;
             while(resultset1.next())
             {
                 c2items[i]=resultset1.getString(7);
                 c3items[i]=resultset1.getString(13);
                 c4items[i]=resultset1.getString(19);
                 index[i]=resultset1.getInt(23);
//                 System.out.println(" c2items[i]*********"+ c2items[i]);
//                 System.out.println(" c3items[i]*********"+ c3items[i]);
//                 System.out.println(" c4items[i]*********"+ c4items[i]);
//                  System.out.println(" Index*********"+ index[i]);
                
                 i++;
             }
             System.out.println(i);
             //System.out.println(tname+" :   over");

             resultset1.close();
             //select the transactions of the incremental day
             Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query="select * from promise_trans where trans_day="+admin.last_day;//+Main.last_day;
             ResultSet resultset=stmt.executeQuery(query);
             resultset.last();
             resultset.beforeFirst();
             //find the subsequence of the string and increment the count
             while(resultset.next())
             {
                 String str=resultset.getString(4);
                 System.out.println(str);
                 int j=2,k=0;
                 while(k<i)
                 {
                     if(c2items[k]!=null)
                     {
                        j=can_sup.isSubsequence(c2items[k], str);
                        if(j!=3)
                        {
                            can_sup.updatecount(tname,"c2sup",c2items[k], index[k]);
                        }
                     }
                     if(c3items[k]!=null)
                     {
                        j=can_sup.isSubsequence(c3items[k], str);
                        if(j!=3)
                        {
                            can_sup.updatecount(tname,"c3sup",c3items[k], index[k]);
                        }
                     }
                     if(c4items[k]!=null)
                     {
                        j=can_sup.isSubsequence(c4items[k], str);
                        if(j!=3)
                        {
                            can_sup.updatecount(tname,"c4sup",c4items[k], index[k]);
                        }
                     }
                    k++;
                 }
             }
             //if(Main.last_day!=1)
             Frequentitems(tname,tsize,isize);
        }
        catch(SQLException e)
        {
                System.err.println("Exception caught at original db count "+e);
        }
    }
    //returns 1 or 2 if "s" is a subsequence of "t"
    //else returns 3
    public static int isSubsequence(String s, String t) {
        int M = s.length();
        int N = t.length();
        String rev = new StringBuffer(t).reverse().toString();
        int i = 0,rl=0,x=0;
        rl=rev.length();
        for (int j = 0; j < N; j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
            if (i == M) return 1;
        }
        for (int j = 0; j < rl; j++) {
            if (s.charAt(x) == rev.charAt(j)) x++;
            if (x == M) return 2;
        }

        return 3;
    }
 public static void updatecount(String tab,String e,String s, int ind) throws Exception {
     try{
     Statement stmt2 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query2="select * from "+tab+" where count="+ind;
             ResultSet resultset=stmt2.executeQuery(query2);
             resultset.last();
             int c=0;
             if(e.equals("c2sup"))
             c=resultset.getInt(8);
             if(e.equals("c3sup"))
             c=resultset.getInt(14);
             if(e.equals("c4sup"))
             c=resultset.getInt(20);
             System.out.println(c);
             c=c+1;
             String q="update "+tab+" set "+e+"="+c+" where count="+ind;
             int records=Db_connection.stmt.executeUpdate(q);
     }
     catch(SQLException ex)
        {
                System.err.println("Exception caught at updatecount "+ex);
        }
 }
 //find frequent and promising frequent itemsets and update them in the database
public static void Frequentitems(String t,float tsize,float isize){

    //Data_item = "<h4> Frequent Item  and Their Support count for Table----"+t+"<h4>";
    try
    {
             Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query="select * from "+t;
             ResultSet resultset=stmt.executeQuery(query);
             resultset.last();
             resultset.beforeFirst();
             min_support_old=(int)Math.round(min_support*tsize);
             //admin.Data ="";

//             System.out.println("##### support for table "+t+" is  "+min_support_old);
             //admin.Data =admin.Data+"<h4>support for table "+t+" is  "+min_support_old+"<br/>";

             while(resultset.next())
             {
                 String can1=resultset.getString(1);
                 String can2=resultset.getString(7);
                 String can3=resultset.getString(13);
                 String can4=resultset.getString(19);
                 float temp1=resultset.getInt(2);
                 float temp2=resultset.getInt(8);
                 float temp3=resultset.getInt(14);
                 float temp4=resultset.getInt(20);
                 String PL1 = resultset.getString("PL1");
                 String PL2 = resultset.getString("PL2");
                 String PL3 = resultset.getString("PL3");
                 float ptemp1 =resultset.getInt("PL2sup");
                 float ptemp2 =resultset.getInt("PL3sup");


//               System.out.println( "PL1*******"+PL1  );
//               System.out.println( "PL2*******"+PL2  );
//               System.out.println( "PL3*******"+PL3  );
////
                 if(temp1>max_sup)
                 {
                     if(can1.equals("U")||can1.equals("V")||can1.equals("W")||can1.equals("X")||can1.equals("Y")||can1.equals("Z")||
                        can1.equals("u")||can1.equals("v")||can1.equals("w")||can1.equals("x")||can1.equals("y")||can1.equals("z"))
                     {
                         System.out.println();
                     }
                     else
                     {
                         max_sup=temp1;
                     }
                 }
                 //System.out.println(max_sup);
                 if(temp1>=min_support_old)
                 {
//                     System.out.println(t+" t  is temp1:"+temp1+"min_support_old  "+min_support_old);
                     String query3="update "+t+" set L1='"+resultset.getString(1)+"',L1sup="+temp1+" where BINARY c1DB='"+can1+"'";
                     System.out.println(query3);
                    // admin.Data = admin.Data+"<h4>Frequent  Item  "+can1+" and Support Count is :"+temp1+"</h4><br/>" ;
                     int records=Db_connection.stmt.executeUpdate(query3);
                    // System.out.println("records "+records);
//                     System.out.println("query3 updated");
                     if(records>0){
                         if(PL1!=null){
                             String qry ="update "+t+" set PL1sup = null , PL1 = null  where BINARY  PL1 = '"+PL1+"' ";
                             Db_connection.stmt.executeUpdate(qry);
                             System.out.println(qry +"Updated "+records+" pl1      "+PL1);
                         }


                     }
                     //Data_item = Data_item+"<h4> Frequent Item "+can1+"  support value  is "+temp1+"</h4><br/>";
                   
                 }
                 if(temp2>=min_support_old)
                 {
//                      System.out.println(t+"  t  is is temp2:"+temp2+"min_support_old  "+min_support_old);
                     String query4="update "+t+" set L2='"+resultset.getString(7)+"',L2sup="+temp2+" where BINARY c2='"+can2+"'";
                    // admin.Data = admin.Data+"<h4>Frequent  Item  "+can2+" and Support Count is :"+temp2+"</h4><br/>" ;
//                     System.out.println(query4);
                     int records=Db_connection.stmt.executeUpdate(query4);

                     //String qry ="update "+t+" set PL2sup = null  where BINARY PL2 = '"+resultset.getString(7)+"' ";

                     if(records>0){
                         if(PL2!=null){
                             String qry ="update "+t+" set PL2sup = null , PL2 = null where  BINARY PL2 = '"+PL2+"' ";
                              Db_connection.stmt.executeUpdate(qry);
                           System.out.println(qry +"Updated "+records+" pl2      "+PL2);
                         }
                      }

                  //   Data_item = Data_item+"<h4> Frequent Item "+can2+"  support value  is "+temp2+"</h4><br/>";
                //       System.out.println("query4 updated");
                 }
                 if(temp3>=min_support_old)
                 {
//                     System.out.println(t+" is temp3:"+temp3+"min_support_old  "+min_support_old);
                     String query5="update "+t+" set L3='"+resultset.getString(13)+"',L3sup="+temp3+" where BINARY c3='"+can3+"'";
                     System.out.println(query5);
                   //  admin.Data = admin.Data+"<h4>Frequent  Item  "+can3+" and Support Count is :"+temp3+"</h4><br/>" ;
                     int records=Db_connection.stmt.executeUpdate(query5);
                      if(records>0){
                         if(PL3!=null){
                             String qry ="update "+t+" set PL3sup = null ,PL3 =null where BINARY PL3 = '"+PL3+"' ";
                             Db_connection.stmt.executeUpdate(qry);
                            System.out.println(qry +"Updated "+records+" pl3       "+PL3);
                      }
                      }


                 //    Data_item = Data_item+"<h4> Frequent Item "+can3+"  support value  is "+temp3+"</h4><br/>";
                 //    System.out.println("query5 updated");
                 }
                 if(temp4>=min_support_old)
                 {
                     System.out.println("tis is temp4:"+temp4+"min_support_old  "+min_support_old);
                     String query6="update "+t+" set L4='"+resultset.getString(19)+"',L4sup="+temp4+"  where  BINARY c4='"+can4+"'";
                     System.out.println(query6);
                    // admin.Data = admin.Data+"<h4>Frequent  Item  "+can4+" and Support Count is :"+temp4+"</h4><br/>" ;
                     int records=Db_connection.stmt.executeUpdate(query6);
                  //   Data_item = Data_item+"<h4> Frequent Item "+can4+"  support value  is "+temp4+"</h4><br/>";
                   //  System.out.println("query6 updated");
                 }
             }

             Data1 ="";
             System.out.println("##### support for table "+t+" is  "+min_support_old);
             Data1 =Data1+"<h4>support for table "+t+" is  "+min_support_old+"<br/>";
             max_sup=max_sup-admin.pro_PL;
             System.out.println("maxsup: "+max_sup);
             System.out.println("totsize: "+tsize);
             System.out.println("inc_size: "+isize);
             Data1 =Data1+" maxsup: "+max_sup+"<br/>";
             min_PL=Math.round(min_support_old-((max_sup/tsize)*isize));

             System.out.println("min_pl for table "+t+" is "+min_PL);
             Data1 =Data1+" min_pl for table "+t+ " is "+min_PL+"</h4><br/><br/>";
              try {
                 transaction_info.writeFile(Data1);
                 System.out.print("Data1 ************************************************"+Data1);
                 Data1 ="";
                 }catch(Exception ex) {

                     System.err.println(ex);
                 }


//              if(t.equalsIgnoreCase("SPORTS"))
//                  admin.Data =admin.Data+"<h3>Clustering </h3><br/> ";
             resultset.beforeFirst();
             while(resultset.next())
             {
                 String can1=resultset.getString(1);
                 String can2=resultset.getString(7);
                 String can3=resultset.getString(13);
                 String can4=resultset.getString(19);
                 int temp1=resultset.getInt(2);
                 int temp2=resultset.getInt(8);
                 int temp3=resultset.getInt(14);
                 int temp4=resultset.getInt(20);

               //    Data_item = Data_item+"<h4> Promising Frequent Item  and Their Support count for Table----"+t+"<h4><br/>";
                 if(temp1>=(int)min_PL && temp1<min_support_old)
                 {
                    String query7="update "+t+" set PL1='"+resultset.getString(1)+"',PL1sup="+temp1+" where binary c1DB='"+can1+"'";
                    int records=Db_connection.stmt.executeUpdate(query7);
//                    System.out.println(query7);
                //    Data_item = Data_item+"<h4> Frequent Item "+can1+"  support value  is "+temp1+"</h4><br/>";
               //     admin.Data = admin.Data+"<h4>Promise Frequent  Item  "+can1+" and Support Count is :"+temp1+"</h4><br/>" ;
                 }
                 if(temp2>=(int)min_PL && temp2<min_support_old)
                 {
                    String query8="update "+t+" set PL2='"+resultset.getString(7)+"',PL2sup="+temp2+" where binary c2='"+can2+"'";
                    int records=Db_connection.stmt.executeUpdate(query8);
//                    System.out.println(query8);
                //    Data_item = Data_item+"<h4> Frequent Item "+can2+"  support value  is "+temp2+"</h4><br/>";
                 //   admin.Data = admin.Data+"<h4>Frequent  Item  "+can2+" and Support Count is :"+temp2+"</h4><br/>" ;
                 }
                 if(temp3>=(int)min_PL && temp3<min_support_old)
                 {
                    String query9="update "+t+" set PL3='"+resultset.getString(13)+"',PL3sup="+temp3+" where binary c3='"+can3+"'";
                    int records=Db_connection.stmt.executeUpdate(query9);
//                    System.out.println(query9);
                 //   Data_item = Data_item+"<h4> Frequent Item "+can3+"  support value  is "+temp3+"</h4><br/>";
                  //  admin.Data = admin.Data+"<h4>Frequent  Item  "+can3+" and Support Count is :"+temp3+"</h4><br/>" ;
                 }
               /*  if(temp4>=(int)min_PL && temp4<min_support_old)
                 {
                    String query10="update "+t+" set PL4='"+resultset.getString(19)+"',PL4sup="+temp1+" where c4='"+can4+"'";
                    int records=Db_connection.stmt.executeUpdate(query10);
                 }******/
             }

          /* Data1 ="";
             System.out.println("##### support for table "+t+" is  "+min_support_old);
             Data1 =Data1+"<h4>support for table "+t+" is  "+min_support_old+"<br/>";
             max_sup=max_sup-admin.pro_PL;
             System.out.println("maxsup: "+max_sup);
             System.out.println("totsize: "+tsize);
             System.out.println("inc_size: "+isize);
             Data1 =Data1+" maxsup: "+max_sup+"<br/>";
             min_PL=Math.round(min_support_old-((max_sup/tsize)*isize));

             System.out.println("min_pl for table "+t+" is "+min_PL);
             Data1 =Data1+" min_pl for table "+t+ " is "+min_PL+"</h4><br/><br/>";
             ++k;
             System.out.println(k+"###Data1   "+Data1);
               try {
                 transaction_info.writeFile(Data1);
                 System.out.print("Data1 ************************************************"+Data1);
                 Data1 ="";
                 }catch(Exception ex) {

                     System.err.println(ex);
                 }*/



//                try {
//                 FrequentItems.writeFrequentItems(Data_item);
//                 System.out.print("Data_item ************************************************"+Data_item);
//                 Data_item ="";
//                 }catch(Exception ex) {
//
//                     System.err.println(ex);
//                 }



    }
    catch(SQLException e)
    {
        System.err.println("Exception caught at frequentitems() (in can_sup) "+e);
    }
}
}
