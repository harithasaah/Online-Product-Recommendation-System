

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package cluster;
import servlets.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class refinement {
 public refinement()
    {
        String l_item[]=new String[50];
        l_item[0]="";
        int ii=0,cl_num,cluster_number=0;
        move_excess();//assigns cluster no =-ve value for the transactions whoose slr=-1 or slr>slr_threshold
        for(int i=1;i<=cluster_transactions.cluster_space;i++)
            cluster_transactions.update_cluster(i);//it computes small and large items for each cluster.
       // for(int i=0;i<10;i++)
          //  System.out.println();
        refine();//empty clusters checked but not deleted
        delete_excess();//deletes finally excess transactions that cannot be accomodated in any cluster

        System.out.println("Printing after removing excess");
        System.out.println("Large Items");
        try{
              for(int i=0;i<cluster_transactions.cluster_space;)
              {
                  l_item[ii]="";
                for(int j=0;cluster_transactions.large_items[i][j]!='\0';j++)
                {
                    l_item[ii]=l_item[ii]+cluster_transactions.large_items[i][j];

                    System.out.print(cluster_transactions.large_items[i][j]+ " ");
                }
                cl_num=++i;
                ii++;
                System.out.println("");
               }
        }
        catch(Exception e)
        {
            System.out.println("Exception in inserting large items (in refinement)"+e);
        }



               System.out.println("Small Items");
              for(int i=0;i<cluster_transactions.cluster_space;i++)
              {
                for(int j=0;cluster_transactions.small_items[i][j]!='\0';j++)
                {
                    System.out.print(cluster_transactions.small_items[i][j]+ " ");
                }
                System.out.println();

               }

 }

    public void move_excess()
    {
        Statement stmt_ref,stmt2;
        try
        {
            stmt_ref = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
            stmt2 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
            String query = "select * from "+fpurchase.tabname+" order by transaction_id";
            ResultSet result_ref = stmt_ref.executeQuery(query);
            while(result_ref.next())
            {
                if((result_ref.getFloat(6)==-1)||(result_ref.getFloat(6)>slr.slr_threshold))
                {
                    query="update "+fpurchase.tabname+" set cluster_no=-cluster_no where transaction_id="+result_ref.getInt(2);
                    stmt2.executeUpdate(query);
                }
            }
            result_ref.close();

            stmt_ref.close();
            stmt2.close();
        }
        catch(SQLException e)
        {
            System.err.println("Exception at move_excess in refinement"+e);
        }

    }

    public void refine()
    {
        Statement st;
        try
        {
            st = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
            String query = "select * from "+fpurchase.tabname+" where cluster_no<0";
            ResultSet rs = st.executeQuery(query);
            rs.last();
            System.out.println("No. of excess transaction="+rs.getRow());
            rs.beforeFirst();
            while(rs.next())
            {
                reassign(rs.getInt(2));
            }
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.println("Exception caught at refinement "+e);
        }
    }

    public void reassign(int trans_number)
    {

            Statement stmt_empty,stmt3,stmt4;
            float slr_best=0;
            int best_cluster=0;
            int best_cost=0;
            System.out.println("in reassign()");
            float temp_slr=0,temp;
            int records;
            String query;
            boolean empty;
            boolean flag_isempty=false;
            boolean threshold_set=false;
            int original_cluster = 0;

            ArrayList empty_clusters=new ArrayList();//to hold the indices of empty clusters

            System.out.println("For trans_number "+trans_number);
            try
            {
                stmt3= Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
                query="select * from "+fpurchase.tabname+" where transaction_id="+trans_number;
                ResultSet rs_original=stmt3.executeQuery(query);
                while(rs_original.next())
                {
                    original_cluster=rs_original.getInt(5);
                    best_cluster=original_cluster;
                    System.out.println("Original cluster of transaction "+trans_number+" is "+original_cluster);
                }
                stmt_empty= Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
                for(int i=1;i<=cluster_transactions.cluster_space;i++)
                {
                    empty=true;
                    query="select * from "+fpurchase.tabname+" where cluster_no="+i;
                    ResultSet rs_empty=stmt_empty.executeQuery(query);
                    if(rs_empty.next())//if a row is present in any of the cluster then it wont be empty
                    {
                        empty=false;
                    }
                    rs_empty.close();
                    if(empty)
                    {
                        empty_clusters.add(i);
                    }
                }

                stmt3= Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
                for(int i=1;i<=cluster_transactions.cluster_space;i++)
                {
                    flag_isempty=false;
                    for(int j=0;j<empty_clusters.size();j++)
                    {
                        if(Integer.parseInt(empty_clusters.get(j).toString())==i)
                        {
                            flag_isempty=true;
                            System.out.println("Cluster "+i+" is empty");
                        }

                    }
                    if((!flag_isempty)&&(i!=(-original_cluster)))//it checks with each cluster other than ite original cluster
                    {
                     System.out.println("Entering iteration "+i);
                     query="update "+fpurchase.tabname+" set cluster_no ="+i+ " where transaction_id = "+trans_number;
                     records=stmt3.executeUpdate(query);//need
                     cluster_transactions.update_cluster(i);//for computing small and large items wen excess transaction s present in that cluster.
                     temp_slr=slr.sl_ratio(i);//calculating slr for t excess transaction when it is present that cluster.
                     System.out.println("SLR for cluster "+i+" for transaction "+trans_number+" is "+temp_slr);
                     if((temp_slr!=-1)&&(!threshold_set))//it will be executed only for first cluster assigned
                     {
                         threshold_set=true;
                         slr_best=temp_slr;
                         best_cluster=i;
                         best_cost=cluster_transactions.calculate_cost();
                     }
                     else if((temp_slr!=-1)&&(temp_slr<=slr_best))
                     {
                         if(temp_slr==slr_best)
                         {
                             int temp_cost=cluster_transactions.calculate_cost();
                             if(temp_cost<best_cost)//to find the best clustering in case of equal slr
                             {
                                 slr_best=temp_slr;
                                 best_cluster=i;
                                 best_cost=cluster_transactions.calculate_cost();
                             }
                         }
                         else
                         {
                            slr_best=temp_slr;
                            best_cluster=i;
                         }
                     }
                     query="update "+fpurchase.tabname+" set cluster_no ="+original_cluster+" where transaction_id =" + trans_number;
                     records=Db_connection.stmt.executeUpdate(query);
                     System.out.println("before second call to update_cluster");
                     cluster_transactions.update_cluster(i);
                     //print();
                    }
                  }
                 if((threshold_set)&&(slr_best<=slr.slr_threshold))//threshold set if false means slr in all clusters is -1
                 {
                    query="update "+fpurchase.tabname+" set cluster_no =" + best_cluster + " where transaction_id = " + trans_number;
                    Db_connection.stmt.executeUpdate(query);
                    cluster_transactions.update_cluster(best_cluster);
                    query="update "+fpurchase.tabname+" set slr =" + slr_best + " where transaction_id = " + trans_number;
                    Db_connection.stmt.executeUpdate(query);

                 }
                 System.out.println("Final Cost="+cluster_transactions.calculate_cost());
            }


            catch(SQLException e)
            {
                System.err.println("Exception caught at reassign:(in refinement) "+e);
            }
    }

    public void delete_excess()
    {
        try
        {
            Statement st=Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
            String query="delete from "+ fpurchase.tabname +" where cluster_no<0";
            st.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println("Exception caught at delete_excess:(in refinement"+e);
        }
    }
}
