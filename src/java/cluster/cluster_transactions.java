/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package cluster;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlets.*;
import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author 
 */
public class cluster_transactions {

         public static int best_cost;
         public static int best_cluster;
         public static char large_items[][]=new char[100][52];
         public static char small_items[][]=new char[100][52];
         public static int cluster_space=1;
         public int cluster_number;

         public static String Datas ="";
         public static String Data_html ="";
         public static String cost_Data ="";
         public static String cost_Data_html ="";

         public static boolean cluster_flag =false;

         public cluster_transactions()
         {
              try
              {
                Statement stat_ini=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                String query_temp = "select * from "+ fpurchase.tabname + " where cluster_no is not null order by cluster_no desc";
                ResultSet resultset_temp=stat_ini.executeQuery(query_temp);
                if(resultset_temp.next())
                {
                 cluster_space=resultset_temp.getInt(5);
                 System.out.println("Initial Cluster space="+cluster_space);
                 for(int i=1;i<=cluster_space;i++)
                     update_cluster(i);
                }
                resultset_temp.close();
                stat_ini.close();
              }
              catch(SQLException e)
              {
                System.out.println("Exception caught before call to allocate_cluster (in cluster_transactions 1)");
              }

              allocate_cluster();


              System.out.println("Final Cluster space: "+cluster_space);
              System.out.println("Large Items");
          for(int i=0;i<cluster_space;i++)
              {
                for(int j=0;large_items[i][j]!='\0';j++)
                {
                    System.out.print(large_items[i][j]+ " ");
                }
                System.out.println("");
               }

               System.out.println("Small Items");
              for(int i=0;i<cluster_space;i++)
              {
                for(int j=0;small_items[i][j]!='\0';j++)
                {
                    System.out.print(small_items[i][j]+ " ");
                }
                System.out.println();
               }
         }



         public void allocate_cluster()//it just retrieves all the transactions from DB and calls assign cluster method to assign cluster for t transactions
         {
            Statement stmt;
            System.out.println("in allocate_cluster()");
            try
            {
             stmt=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        java.sql.ResultSet.CONCUR_UPDATABLE);
             String query="select * from "+fpurchase.tabname+" order by transaction_id";
             ResultSet resultset=stmt.executeQuery(query);
             resultset.last();//it is needed for getting total no of rows in the resultset
             //System.out.println("lllllllllll");
             System.out.println(resultset.getRow());
             //System.out.println("sssssssssss");
             resultset.beforeFirst();
             while(resultset.next())
             {
                if(resultset.getString(5)==null)
                {
                  System.out.println(" assign_cluster(resultset.getInt(2))"+resultset.getInt(2))  ;
                  assign_cluster(resultset.getInt(2));
                }

             }
             resultset.close();
             stmt.close();
             print();
            }

            catch(SQLException e)
            {
                System.err.println("Exception caught at allocate_cluster (in cluster_transactions 2) "+e);
            }
         }




         public static void update_cluster(int cluster_number)
         {

            String large="";
            String small=""; //this method calculates support count of each items in that cluster and calculates small and large items of that cluster.
            System.out.println("in update_cluster() called with the parameter "+cluster_number);
            int row_count,i=0,j,k,matrix_rows=0;
            float support_count[]=new float[52];
            float min_support=(float)0.6;
            float max_ceiling=(float)0.3;
            char local_large_items[]=new char[100];
            char local_small_items[]=new char[100];
            String item_seperator,query;
            try
            {
                query="select * from "+fpurchase.tabname+" where cluster_no="+cluster_number;
                ResultSet resultset=Db_connection.stmt.executeQuery(query);
                resultset.last();
                row_count=resultset.getRow();
                System.out.println("Records in update_cluster:"+row_count);
                byte transaction_matrix[][] = new byte[row_count][52];
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

                        for(j=26;j<52;j++)
                        {
                                  if(item_seperator.charAt(k)==(char)(j+71))
                                            transaction_matrix[i][j]= 1;
                        }

                       k++;
                        }

                     i++;
                }
                resultset.close();


                System.out.println("Transaction Matrix");
             /*   for(i=0;i<row_count;i++)
                {
                  for(j=0;j<52;j++)
                  {
                	System.out.print(transaction_matrix[i][j]+" ");
                  }
                  System.out.println();
                }*/
                System.out.println();

                for(i=0;i<row_count;i++)
                {
                  for(j=0;j<52;j++)
                  {
                      if(transaction_matrix[i][j]==1)
                      support_count[j]++;

                  }
                }

                System.out.println("Support count");
               /* for(j=0;j<52;j++)
                {
                   System.out.print((int)support_count[j]+ " ");
                }*/

                System.out.println();

                for(j=0;j<52;j++)
                {
                    support_count[j]=support_count[j]/row_count;
                    if(support_count[j]!=0)
                    System.out.println("Item support count "+support_count[j]  );
                }
                i=0;
                k=0;

                for(j=0;j<26;j++)
                {
                   if(support_count[j]>min_support)
                   {
                     local_large_items[i]=(char)(j+65);
                     System.out.println(" local_large_items[i]  in "+i+  "  "+ local_large_items[i]);

                     i++;
                   }
                   else if((support_count[j]>0)&&(support_count[j]<max_ceiling))
                   {
                       local_small_items[k]=(char)(j+65);
                        System.out.println(" local_small_items[k]  in "+k+  "  "+ local_small_items[k]);
                       k++;
                   }
                }
                 for(j=26;j<52;j++)
                {
                   if(support_count[j]>min_support)
                   {
                     local_large_items[i]=(char)(j+71);
                     i++;
                   }
                   else if((support_count[j]>0)&&(support_count[j]<max_ceiling))
                   {
                       local_small_items[k]=(char)(j+71);
                       k++;
                   }
                }
                 Datas = "Large and small Items in  Cluster "+cluster_number+ "\n";
                 Data_html =" <h4>Large and small Items in  Cluster "+cluster_number+ "</h4></br>";
                for(j=0;j<i;j++)
                   cluster_transactions.large_items[cluster_number-1][j]=local_large_items[j];
                cluster_transactions.large_items[cluster_number-1][j]='\0';
                for(j=0;j<k;j++)
                   cluster_transactions.small_items[cluster_number-1][j]=local_small_items[j];
                cluster_transactions.small_items[cluster_number-1][j]='\0';
                Datas =Datas+"Large Items\n";
                Data_html =Data_html+"Large Items</br>";
                System.out.println("Large items");
                for(j=0;j<i;j++)
                {
                    System.out.print(cluster_transactions.large_items[cluster_number-1][j]+" ");
                    large = large+cluster_transactions.large_items[cluster_number-1][j]+"\n"  ;
                }
                Datas= Datas+large+"\n";
                Data_html= Data_html+large+"</br>";
                System.out.println();
                System.out.println("Small items");
                for(j=0;j<k;j++)
                {
                    System.out.print(cluster_transactions.small_items[cluster_number-1][j]+" ");
                    small= small+cluster_transactions.small_items[cluster_number-1][j]+"\n";
                }
                Datas= Datas+"Small Items\n"+small+"\n";
                Data_html= Data_html+"Small Items :"+small+"</br>";

            if(cluster_flag){
            try {
                System.out.println("##############"+Datas);
                //promise.transaction_info.writeFile(Datas);
                promise.transaction_info.writeFile(Data_html);
                Data_html="";
                System.out.println("after write Datas 267 "+Data_html);
                Datas="";
                 System.out.println("after write Datas 267 "+Datas);
                //cost_Data="";
            } catch (IOException ex) {
                Logger.getLogger(cluster_transactions.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println();
                System.out.println("End of update_cluster");

            }
            }
            catch(SQLException e)
            {
               System.err.println("Exception caught at update_cluster (in cluster_transactions 3)"+e);
            }



         }




         public void assign_cluster(int trans_number)
         {

            System.out.println("in assign_cluster()");
            int cost=0,temp;
            int records;
            String query;

            System.out.println("For trans_number "+trans_number);
            try
            {
                //print();
                for(int i=1;i<=cluster_space;i++)
                {
                    System.out.println("Entering iteration "+i);
                    //query="update "+fpurchase.tabname+" set cluster_no = " +i+ "where transaction_id = "+ trans_number;
                    query="UPDATE "+fpurchase.tabname+"  SET cluster_no = "+i+ " WHERE transaction_id = "+trans_number+"";

//                     System.out.println("First :::"+query);
                    records=Db_connection.stmt.executeUpdate(query);
//                     System.out.println(" after EXEC First :::"+query);
                    System.out.println("Records="+records);
                    update_cluster(i);
                    cost=calculate_cost();
                    if(i==1)
                    {
                        best_cost=cost;
                        best_cluster=i;
                    }
                    if((cost<best_cost))
                    {
                        best_cost=cost;
                        best_cluster=i;
                    }
                    query="update "+fpurchase.tabname+" set cluster_no = null where transaction_id =" +trans_number;
//                    System.out.println("second :::"+query);
                    records=Db_connection.stmt.executeUpdate(query);
//                    System.out.println("before second call to update_cluster");
                    update_cluster(i);
                    //print();
                 }
                 temp=cluster_space+1;
                 query="update "+fpurchase.tabname+" set cluster_no = " +temp+ "  where transaction_id = " +trans_number;
//                 System.out.println("Third :::"+query);
                 records=Db_connection.stmt.executeUpdate(query);
                  System.out.println(" after EXEC Third :::"+query);
                 update_cluster(cluster_space+1);
                 cost=calculate_cost();
                 if(cost<best_cost)
                 {
                       best_cost=cost;
                       best_cluster=temp;
                       cluster_space=temp;

                    cost_Data = "\n Findig  Suitable Cluster by Cost Comparison  \n" ;
                    cost_Data =cost_Data+"\nbest_cost= "+best_cost+"\n";
                    cost_Data= cost_Data+"\nbest_Cluster  :"+best_cluster+"\n";
                    System.out.println("Cost_Data "+cost_Data);
                    cost_Data_html ="<h3>Findig  Suitable Cluster by Cost Comparison For Transaction Id :"+trans_number+" </h3></br>";
                    cost_Data_html =cost_Data_html+"<h4>best_cost= "+best_cost+"</h4><br/>";
                    cost_Data_html= cost_Data_html+"<h4>best_Cluster  :"+best_cluster+"</h4><br/>";
                    cluster_flag =true;


                    try {

                        promise.transaction_info.writeFile(cost_Data_html);
                        cost_Data_html="";
                        cluster_flag =false;
                        //promise.transaction_info.writeFile(cost_Data);
                        cost_Data="";

                     System.out.println("after write cost_Data  352"+cost_Data);

                    }catch(IOException e){
                        System.err.println("cost_Data" +e);
                    }


                 }
                 else
                {
                  query="update "+fpurchase.tabname+" set cluster_no =" + best_cluster + " where transaction_id = " + trans_number;
                  System.out.println("fourth :::"+query);
                  records=Db_connection.stmt.executeUpdate(query);
                  System.out.println(" after EXEC fourth :::"+query);
                  update_cluster(best_cluster);
                     cost_Data = "\n Findig  Suitable Cluster by Cost Comparison\n" ;
                    cost_Data =cost_Data+"\nbest_cost= "+best_cost+"\n";
                    cost_Data= cost_Data+"\nbest_Cluster  :"+best_cluster+"\n";
                    System.out.println("Cost_Data "+cost_Data);
                    cost_Data_html ="<h3>Findig  Suitable Cluster by Cost Comparison For Transaction Id :"+trans_number+" </h3></br>";
                    cost_Data_html =cost_Data_html+"<h4>best_cost= "+best_cost+"</h4><br/>";
                    cost_Data_html= cost_Data_html+"<h4>best_Cluster  :"+best_cluster+"</h4><br/>";
                    try {
                     promise.transaction_info.writeFile(cost_Data_html);
                     cost_Data_html="";
//                   promise.transaction_info.writeFile(cost_Data);
                     cost_Data=" ";
                     System.out.println("after write cost_Data 381"+cost_Data);
                     }catch(IOException e){
                         System.err.println("cost_Data" +e);
                     }
                    cluster_flag =true;
                 }

//                    cost_Data = "\n Findig  Suitable Cluster by Cost Comparison\n" ;
//                    cost_Data =cost_Data+"\nbest_cost= "+best_cost+"\n";
//                    cost_Data= cost_Data+"\nbest_Cluster  :"+best_cluster+"\n";
//                    System.out.println("Cost_Data "+cost_Data);
//                    cost_Data_html ="<h3>Findig  Suitable Cluster by Cost Comparison</h3></br>";
//                    cost_Data_html =cost_Data_html+"<h4>best_cost= "+best_cost+"</h4></br>";
//                    cost_Data_html= cost_Data_html+"<h4>best_Cluster  :"+best_cluster+"</h4></br>";
//
//
//                    try {
//                     promise.transaction_info.writeFile(cost_Data_html);
//                     cost_Data_html="";
////                    promise.transaction_info.writeFile(cost_Data);
//                    cost_Data=" ";
//                    System.out.println("after write cost_Data 381"+cost_Data);
//                    }catch(IOException e){
//                        System.err.println("cost_Data" +e);
//                    }
            }

            catch(SQLException e)
            {
                System.err.println("Exception caught at assign_cluster  (in cluster_transactions 4)"+e);
            }
         }




         public static int calculate_cost( )//calculates intercluster similarity by counting total large items and
                 //calculates intra cluster dissimilarity by counting small items and so calculates cost.
         {

           System.out.println("in calculate_cost()");
           int cost=0,weightage= 1;
           int i=0,j=0,k=0,temp=0,large_item_union;
           int intra_cluster_dissimilarity,inter_cluster_similarity;
           byte[] presence=new byte[52];
           for(i=0;i<52;i++)
           {
               presence[i]=0;
           }
           for(i=0;i<cluster_transactions.cluster_space;i++)
          {
               for(j=0; cluster_transactions.small_items[i][j]!='\0';j++)
               {
                   temp=(int)cluster_transactions.small_items[i][j];
                  System.out.println("temp****"+temp);
                  if(temp>0 && temp<91)
                  presence[temp-65]=1;
                  else if(temp>90)
                      presence[temp-71]=1;
               }
           }
           System.out.println("Small Item Union");
	   for(i=0;i<52;i++)
           {
               System.out.print(presence[i]+ " ");
           }
	  intra_cluster_dissimilarity=0;
          i=0;
          for(i=0;i<52;i++)
          {
              if(presence[i]==1)
              {
                 intra_cluster_dissimilarity++;
              }
          }

	  System.out.println("intra_cluster_dissimilarity "+intra_cluster_dissimilarity);
          for(i=0;i<52;i++)
          {
               presence[i]=0;
          }
          k=0;
	  for(i=0;i<cluster_transactions.cluster_space;i++)
      {
              for(j=0;cluster_transactions.large_items[i][j]!='\0';j++)
              {
                  temp=(int)cluster_transactions.large_items[i][j];
                   System.out.println("temp*********"+temp);
                  if(temp>0 && temp<91)
                  presence[temp-65]=1;
                  else if(temp>90)
                      presence[temp-71]=1;
   	          k++;
              }
          }
          System.out.println("k="+k+"\n"+"Large item presence:");
	   for(i=0;i<52;i++)
          {
              System.out.print(presence[i]+" ");

          }

	  inter_cluster_similarity=0;
	  large_item_union=0;
          i=0;
          while(i<52)
          {
              if(presence[i]==1)
              {
                  large_item_union++;
              }
              i++;
          }
		//System.out.println(large_item_union);
          inter_cluster_similarity=k-large_item_union;
          System.out.println("inter cluster similarity : "+inter_cluster_similarity);
          cost=(weightage*intra_cluster_dissimilarity)+inter_cluster_similarity;
          System.out.println("end of calculate_cost() :" +cost);

          //cost_Data ="cost= intra_Cluster_dissimilarity + inter_cluster_similarity ";
          //cost_Data= cost_Data+"\nintra_cluster_dissimilarity = "+intra_cluster_dissimilarity;
          //cost_Data=cost_Data+"\ninter cluster similarity = "+inter_cluster_similarity;
          cost_Data_html ="<br/> intra_cluster_dissimilarity = "+intra_cluster_dissimilarity+"<br/>inter cluster similarity = "+inter_cluster_similarity+"<br/>Cost of Clustering "+cost+"<br/>";

          //System.out.println(cost_Data);
        try {
            promise.transaction_info.writeFile(cost_Data_html);
            cost_Data ="";
           System.out.println("after write cost_Data  485"+cost_Data);
        } catch (IOException ex) {
            Logger.getLogger(cluster_transactions.class.getName()).log(Level.SEVERE, null, ex);
        }

   	  return cost;
         }


        public static void print()
        {

            System.out.println("in print()");
            try
            {
                Db_connection.stmt=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
                String query="select * from "+fpurchase.tabname;
                ResultSet resultset=Db_connection.stmt.executeQuery(query);
                //System.out.println("works till here");
                while(resultset.next()) //since initially the cursor will be placed before the first row and not the first row
                {
	            System.out.print(resultset.getString(1));
	            System.out.print("\t");
	            System.out.print(resultset.getString(2));
	            System.out.print("\t");
	            System.out.print(resultset.getString(3));
                           System.out.print("\t");
	            System.out.print(resultset.getString(4));
                           System.out.print("\t");
                System.out.print(resultset.getString(5));
                           System.out.print("\t");
                           System.out.print(resultset.getString(6));
                           System.out.print("\n");
	           // System.out.println(resultset.getString(5));
                }
            }

            catch(SQLException e)
            {
	        System.err.println("Exception caught at Print  (in cluster_transactions 5)"+e);
            }

  }

}
