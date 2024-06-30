/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package cluster;
import servlets.*;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class slr {
static float slratio[]=new float[100];
    static float slr_threshold=(float)3/2;

    public slr()
    {
        System.out.println("Entered slr");
        Statement stmt_slr,stmt_new;
        String query;
        int trans_count,i=0,j=0;
        System.out.println("SLR Threshold="+slr_threshold);
        try
        {
            stmt_slr = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
            query = "select * from "+fpurchase.tabname;
            ResultSet result1_slr = stmt_slr.executeQuery(query);
            while(result1_slr.next())
            {
                 i=result1_slr.getInt(2);
                 slratio[i]=sl_ratio(i);
                 stmt_new = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
                 query="update "+fpurchase.tabname+" set slr="+slratio[i]+"where transaction_id="+i;
                 stmt_new.executeUpdate(query);
                 stmt_new.close();
            }

        } catch (SQLException ex) {
            System.out.println("Exception in slr 1 "+ex);
        }
    }


    static float sl_ratio(int trans_id)
    {
        int small=0,large=0;
        float slr=0;
        try {
            System.out.println("In sl_ratio");
            Statement stm_slr = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
            String query = "select * from "+fpurchase.tabname+" where transaction_id="+trans_id;
            ResultSet resultset_slr = stm_slr.executeQuery(query);
            resultset_slr.next();//needed since result set will initially be before the first transaction
            String finder=resultset_slr.getString(4);
            int cl_no=resultset_slr.getInt(5);
            resultset_slr.close();
            stm_slr.close();
            System.out.println("Transaction "+trans_id+" is present in cluster "+cl_no);
            for(int i=0;i<finder.length();i++)
            {
                for(int j=0;j<26;j++)
                {
                    if(finder.charAt(i)==(char)(j+65))
                    {
                        System.out.println("Cluster_no   i val ="+i+"j val ="+j+ " cl_no "+cl_no );
                        System.out.println("cluster_transactions.small_items[cl_no-1][k]***"+cluster_transactions.small_items[cl_no-1][0]);


                        for(int k=0;cluster_transactions.small_items[cl_no-1][k]!='\0';k++)
                        {
                            if(finder.charAt(i)==cluster_transactions.small_items[cl_no-1][k]){
                                small++;
                                System.out.println("Small Item In cluster "+cl_no+"   is : "+cluster_transactions.small_items[cl_no-1][k]   );
                            }
                        }
                        for(int k=0;cluster_transactions.large_items[cl_no-1][k]!='\0';k++)
                        {
                            if(finder.charAt(i)==cluster_transactions.large_items[cl_no-1][k]){
                                large++;
                                System.out.println("Large Item In cluster "+cl_no+"   is : "+cluster_transactions.large_items[cl_no-1][k] );
                            }
                        }

                    }
                }
                for(int j=26;j<52;j++)
                {
                    if(finder.charAt(i)==(char)(j+71))
                    {
                        for(int k=0;cluster_transactions.small_items[cl_no-1][k]!='\0';k++)
                        {
                            if(finder.charAt(i)==cluster_transactions.small_items[cl_no-1][k])
                                small++;
                        }
                        for(int k=0;cluster_transactions.large_items[cl_no-1][k]!='\0';k++)
                        {
                            if(finder.charAt(i)==cluster_transactions.large_items[cl_no-1][k])
                                large++;
                        }

                    }
                }
            }
            if(large==0)
                slr=-1;
            else
                slr=(float)small/(float)large;
            System.out.println("SL Ratio of transaction "+trans_id+" is "+slr);

        }
        catch (SQLException ex)
        {
            System.out.println("Exception caught at sl_ratio: "+ex);
        }

        return slr;//for use in refinement
    }
}
