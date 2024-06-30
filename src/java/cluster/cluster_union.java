/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package cluster;

/**
 *
 * @author
 */
import servlets.*;
import java.sql.*;

//import java.util.ArrayList;
public class cluster_union {
    static int total_clus=0;
    public cluster_union()
    {
                       union();


    }
    public static void union()
         {

            System.out.println("in union of cluster() ");
            int row_count,i=0,j,k,matrix_rows=0;
            int cluster_number=0;
            String items_seperator,query;
            String it[]=new String[20];
            for(i=0;i<20;i++)
            {
                it[i]="";
            }
            //System.out.println("total clusters:="+clus_num);
            i=0;
            try
            {

                query="select * from "+fpurchase.tabname+" where cluster_no is not null";
                ResultSet resultset=Db_connection.stmt.executeQuery(query);
                resultset.last();
                row_count=resultset.getRow();
                System.out.println("Records in update_cluster:"+row_count);
                byte transaction_matrix[][] = new byte[40][52];
                int y=0;
                resultset.beforeFirst();
                //cluster_number[y]=clus_num;
               while(resultset.next())
                {
                    cluster_number=resultset.getInt(5);
                    items_seperator=resultset.getString(4);
                    k=0;

                    for(int len=0;len<items_seperator.length();len++)
                    {
                        //System.out.println("111111111");
                      for(j=0;j<26;j++)
                       {

                              if(items_seperator.charAt(k)==(char)(j+65))
                                transaction_matrix[cluster_number][j]= 1;
                         //System.out.println("22222222");


                      }

                        for(j=26;j<52;j++)
                        {
                              if(items_seperator.charAt(k)==(char)(j+71))
                                transaction_matrix[cluster_number][j]= 1;
                        }

                       k++;
                    }
                    if(i < cluster_number)
                    {
                        i=cluster_number;
                    }
                    }



                resultset.close();
                //cluster_number=0;
                System.out.println("cluster:"+i);
                y=0;
                System.out.println("cluster items");
               for(k=1;k<=i;k++)
                {
                  for(j=0;j<26;j++)
                  {
                	if(transaction_matrix[k][j]==1)
                    {
                        it[k]+=(char)(j+65);
                        System.out.println((char)(j+65));
                    }
                  }
                  for(j=26;j<52;j++)
                  {
                	if(transaction_matrix[k][j]==1)
                    {
                        it[k]+=(char)(j+71);
                        System.out.println((char)(j+71));
                    }
                  }
                  System.out.println();
                }

                  for(k=1;k<=i;k++)
                  {
                      System.out.println("item in cluster "+ k +"are: "+it[k]);
                      //Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                        PreparedStatement pst = Db_connection.con.prepareStatement("insert into clusteryam (cluster, item)       values(?,?)");
                        pst.setInt(1,k);
                        pst.setString(2,it[k]);
                        int ii = pst.executeUpdate();
                        if(ii!=0)
                            System.out.println("Record has been inserted");
                        else
                            System.out.println("Record has not inserted successfully");
                  }

                }

                catch(Exception e)
                {
                    System.out.println("Exception in clusterYam (in cluster Union)"+e);
                }
  }

}
