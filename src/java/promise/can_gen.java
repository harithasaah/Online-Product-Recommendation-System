/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package promise;
import cluster.*;
//import servlets.*;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class can_gen {

    public static int inc_size;

    /**
     * @param args the command line arguments
     */
    public static void scan_originalDB(){
            int row_count,k,i=0,j;
            int support_count[]=new int[52];
            Statement stmt;
            String item_seperator;

            try
            {
             stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query="select * from promise_trans where trans_day=1";//get transactions for original database
             ResultSet resultset=stmt.executeQuery(query);
             resultset.last();
                row_count=resultset.getRow();
                System.out.println("Records in promise_trans:"+row_count);
                byte transaction_matrix[][] = new byte[row_count][52];
                resultset.beforeFirst();
                //to get transaction matrix for transactions
                while(resultset.next())
                {
                    item_seperator=resultset.getString(4);
                    System.out.println(item_seperator);
                    k=0;

                    for(int len=0;len<item_seperator.length();len++)
                    {
                       for(j=0;j<26;j++)
                       {
                         if(item_seperator.charAt(k)==(char)(j+65))
                         transaction_matrix[i][j]= 1;
                       }
                       for(int u=j;u<j+26;u++)
                       {
                         if(item_seperator.charAt(k)==(char)(u+71))
                         transaction_matrix[i][u]= 1;
                       }
                       k++;
                    }
                    i++;
                }
                resultset.close();
                System.out.println("Transaction Matrix");
                for(i=0;i<row_count;i++)
                {
                  for(j=0;j<52;j++)
                  {
                	System.out.print(transaction_matrix[i][j]+" ");
                  }
                  System.out.println();
                }
                System.out.println();
                //getting support count
                for(i=0;i<row_count;i++)
                {
                  for(j=0;j<52;j++)
                  {
                      if(transaction_matrix[i][j]==1)
                      support_count[j]++;
                  }
                }
                System.out.println("Support count");
                for(j=0;j<52;j++)
                {
                   System.out.print((int)support_count[j]+ " ");
                }
                //update the support of corresponding item in candidate table
                System.out.println("before candidate\n\n");
                for(j=0;j<26;j++)
                {
                         System.out.println("support"+support_count[j]+"\tchar"+(char)(j+65));
                        int record=Db_connection.stmt.executeUpdate("update candidate set  C1DBSUP="+support_count[j]+" where binary C1DB= '"+(char)(j+65)+"'");
                         System.out.println("After support"+support_count[j]+"\tchar"+(char)(j+65));
                }
                for(int u=26;u<52;u++)
                {
                        System.out.println("support"+support_count[u]+"\tchar"+(char)(u+71));
                        int record=Db_connection.stmt.executeUpdate("update candidate set  C1DBSUP="+support_count[u]+" where binary C1DB= '"+(char)(u+71)+"'");
                        System.out.println("After support"+support_count[u]+"\tchar"+(char)(u+71));
                }
                //find the frequent items and the count
                can_gen.add_DB();
            }
            catch(SQLException e)
            {
                System.err.println("Exception caught at original db in (in can_gen) "+e);
            }

    }//to scan incremental database and to add it in the candidate table
  public static void scan_incrementalDB(int day){
            int k,i=0,j;
            float support_count[]=new float[52];
            Statement stmt;
            String item_seperator;
            try
            {
                 stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                            java.sql.ResultSet.CONCUR_UPDATABLE);
                 String query="select * from promise_trans where trans_day="+day;
                 ResultSet resultset=stmt.executeQuery(query);
                 resultset.last();
                 inc_size=resultset.getRow();
                 System.out.println("Records in promise_trans for day "+day+":"+inc_size);
                 byte transaction_matrix[][] = new byte[inc_size][52];
                 resultset.beforeFirst();

                while(resultset.next())
                {
                    item_seperator=resultset.getString(4);
                    System.out.println(item_seperator);
                    k=0;

                    for(int len=0;len<item_seperator.length();len++)
                    {
                      for(j=0;j<26;j++)
                       {
                         if(item_seperator.charAt(k)==(char)(j+65))
                         transaction_matrix[i][j]= 1;
                       }
                      for(int u=j;u<j+26;u++)
                       {
                         if(item_seperator.charAt(k)==(char)(u+71))
                         transaction_matrix[i][u]= 1;
                       }
                       k++;
                     }
                     i++;
                }
                resultset.close();
                System.out.println("Transaction Matrix");
                for(i=0;i<inc_size;i++)
                {
                  for(j=0;j<52;j++)
                  {
                	System.out.print(transaction_matrix[i][j]+" ");
                  }
                  System.out.println();
                }
                System.out.println();

                for(i=0;i<inc_size;i++)
                {
                  for(j=0;j<52;j++)
                  {
                      if(transaction_matrix[i][j]==1)
                      support_count[j]++;
                  }
                }
                System.out.println("Support count");
                for(j=0;j<52;j++)
                {
                   System.out.print("Support_count "+(int)support_count[j]+ " ");
                }

                i=0;
                for(j=0;j<58;j++)
                {
                    if(j<26 || j>31)
                    {
                         int record=Db_connection.stmt.executeUpdate("update candidate set C1NEWSUP="+support_count[i]+" where BINARY C1DB= '"+(char)(j+65)+"';");
                         System.out.println("Record "+record);
                         System.out.println("Updated**********update candidate set C1NEWSUP="+support_count[i]+" where  BINARY C1DB= '"+(char)(j+65)+"'");
                         i++;
                    }
                }
                can_gen.add_DB();

            }
            catch(SQLException e)
            {
                System.err.println("Exception caught at incremental db (in can_gen)"+e);
            }
  }

public static void add_DB(){
    int row_count1=0,row_count2=0,j=0,k=0,min,max;
    String[] items1=new String[30];
    int count1[]=new int[30],i=0;
    String[] items2=new String[30];
    int count2[]=new int[30];
    try{

             Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query1="select * from candidate";
             ResultSet resultset2=stmt.executeQuery(query1);
             resultset2.last();
             row_count2=resultset2.getRow();
             resultset2.beforeFirst();
             //keep this for future reference don't delete
             /*
             while(resultset2.next())
             {
                 if(resultset2.getString(1)!=null)
                 {
                 items1[i]=resultset2.getString(1);
                 count1[i]=resultset2.getInt(2);
                 System.out.println(items1[i]);
                 System.out.println(count1[i]);
                 i++;
                 }
             }
             resultset2.beforeFirst();
             while(resultset2.next())
             {
                 if(resultset2.getString(3)!=null)
                 {
                 items2[j]=resultset2.getString(3);
                 count2[j]=resultset2.getInt(4);
                 System.out.println(items2[j]);
                 System.out.println(count2[j]);
                 j++;
                 }
             }
             System.out.println("tis is i"+i);
             System.out.println("this is j "+j);
             if(i>j)
             {
                 max=i;
                 min=j;
             }
             else
             {
                 max=j;min=i;
             }
             System.out.println("tis is max: "+max);
             System.out.println("this is min: "+min);
             for(int l=0;l<min;l++)
             {
                 for(k=0;k<max;k++)
                 {
                     if(items2[l].equals(items1[k]))
                        {
                            count1[k]+=count2[l];
                            Statement stmt1 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                            stmt1.executeUpdate("update c1db set c1sup="+count1[k]+"where c1='"+items1[k]+"'");
                            Statement stmt2 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                            stmt2.executeUpdate("update frequent set c1dbsup="+count1[k]+"where c1db='"+items1[k]+"'");
                            System.out.println("item:"+items1[k]+"support:"+count1[k]+"this is if(equal)");
                            break;
                        }
                     Statement stmt3 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                            stmt3.executeUpdate("alter table c1db drop column db1");
                            stmt3.executeUpdate("alter table c1db drop column db1sup");
                     Statement stmt4 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                            stmt4.executeUpdate("alter table c1db add(db1 VARCHAR2(4000) NULL,db1sup number)");
             /*********to find new item in the incremental transaction
                          else if(count2[l]!=0 && k==max-1)
                         {
                             items1[max]=items2[l];
                             count1[max]=count2[l];
                             System.out.println("item:"+items1[max]+"support:"+count1[max]+"this is position"+max);
                             max++;
                             break;
                         }***********
                }
             }*/
             //get the old and new support
             //add them & update in the table
             while(resultset2.next())
             {
                 String str=resultset2.getString(1);
                 i=resultset2.getInt(2);
                 j=resultset2.getInt(3);
                 i=i+j;
                 System.out.println(i);
                 Statement stmt1 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                 stmt1.executeUpdate("update candidate set C1DBsup="+i+"  where BINARY C1DB='"+str+"'");
                 Statement stmt2 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                 stmt2.executeUpdate("update student set C1DBsup="+i+"  where BINARY C1DB='"+str+"'");
                 Statement stmt3 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                 stmt3.executeUpdate("update business set C1DBsup="+i+" where BINARY C1DB='"+str+"'");
                 Statement stmt4 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                 stmt4.executeUpdate("update media set C1DBsup="+i+" where  BINARY C1DB='"+str+"'");
                 Statement stmt5 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                 stmt5.executeUpdate("update sports set C1DBsup="+i+" where BINARY C1DB='"+str+"'");
             }

    }
    catch(SQLException e)
    {
                System.err.println("Exception caught at add db (in can_gen)"+e);
    }
  }
//this function is there in can_sup
//kept for reference
/*
public static void Frequentitems(int incsize){
    try{

        Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query="select c1db,c1dbsup from frequent";
             ResultSet resultset=stmt.executeQuery(query);
             resultset.last();
             resultset.beforeFirst();
             min_support_old=(int)(min_support*Main.totalsize);
             System.out.println(min_support_old);
             int temp;

             while(resultset.next())
             {
                 temp=resultset.getInt(2);
                 if(temp>max_sup)
                 {
                     max_sup=temp;
                 }
                 System.out.println(max_sup);
                 if(temp>min_support_old)
                 {
                     String query2="insert into frequent(l1,l1sup) values('"+resultset.getString(1)+"',"+temp+")";
                     int records=Db_connection.stmt.executeUpdate(query2);
                 }
             }
             min_PL=min_support_old-((max_sup/Main.totalsize)*incsize);
             System.out.println(min_PL);
             resultset.beforeFirst();
             temp=0;
             while(resultset.next())
             {
                 temp=resultset.getInt(2);
                 if(temp>min_PL && temp<min_support_old)
                 {
                     String query3="insert into frequent(pl1,pl1sup) values('"+resultset.getString(1)+"',"+temp+")";
                     int record=Db_connection.stmt.executeUpdate(query3);
                 }
             }
    }
    catch(SQLException e)
    {
        System.err.println("Exception caught at frequent items "+e);
    }
}*/
}