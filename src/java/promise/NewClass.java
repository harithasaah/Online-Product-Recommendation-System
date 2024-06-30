/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */
package promise;

import cluster.*;


/**
 *
 * @author 
 */
public class NewClass {

    public void sample() {
        int support_count[] = new int[220];
        int i = 0;
        for (int j = 0; j < 58; j++) {
            if (j < 26 || j > 31) {
                // int record=Db_connection.stmt.executeUpdate("update candidate set C1NEWSUP="+support_count[i]+" where C1DB= '"+(char)j+65+"'");
                // System.out.println("Refcord "+record);
                System.out.println(j + "Updated**********update candidate set C1NEWSUP=" + support_count[i] + " where C1DB= '" + (char) (j + 65) + "'");
                i++;
                System.out.println("ii" + i);
            }
        }
    }

    public static java.util.ArrayList getCluster() throws Exception {

        java.sql.ResultSet rs = null;
        java.util.ArrayList arrl = new java.util.ArrayList();
        ClusterBean cb = null;


        String query = "SELECT * FROM  promise_trans WHERE cluster_no IS NOT NULL ORDER BY cluster_no";

        try {
            Db_connection.getOracleJDBCConnection();
            rs = Db_connection.stmt.executeQuery(query);
//            rs.last();
//            int last_row = rs.getRow();
//            rs.beforeFirst();
//            for(int i=0; i<last_row; i++) {
            while (rs.next()) {
                cb = new ClusterBean();
                cb.setTransaction_id(rs.getInt(2));
                cb.setItem(rs.getString(4));
                cb.setCluster_no(rs.getInt(5));
                arrl.add(cb);

            }

        } catch (Exception e)
        {

            System.out.println("Exception " + e);
        }


        

//        finally {
//            try {
//                rs.close();
//                Db_connection.stmt.close();
//                Db_connection.con.close();
//            } catch (java.sql.SQLException ex) {
//                System.out.println("EXCeption  " + ex);
//
//            }
//       }


        return arrl;
    }


    public static java.util.ArrayList getItem_info() throws Exception {

        java.sql.ResultSet rs = null;
        java.util.ArrayList arrl = new java.util.ArrayList();
        ClusterBean cb = null;


        String query = "SELECT CONCAT('<tr><td>',item_id ,'</td><td>',NAME ,'</td></tr>') FROM items WHERE item_id BETWEEN  BINARY'A' AND  BINARY 'Z' ORDER BY item_id";

        try {
            Db_connection.getOracleJDBCConnection();
            rs = Db_connection.stmt.executeQuery(query);
//            rs.last();
//            int last_row = rs.getRow();
//            rs.beforeFirst();
//            for(int i=0; i<last_row; i++) {
            while (rs.next()) {
               
                arrl.add(rs.getString(1));

            }

        } catch (Exception e) {

            System.out.println("Exception " + e);
        }
        
        
        

        return arrl;
    }


    public static void main(String args[]) {
//    String  fpurchasetabname ="promise_trans" ;
//    int i=0;
//    int trans_number =1;
//    int temp = 0;
//
//    //String   query ="UPDATE "+fpurchasetabname+"  SET cluster_no = "+i+"WHERE transaction_id = "+trans_number+"";
//    String query="update "+fpurchasetabname+" set cluster_no = " + temp +" where transaction_id = "+ trans_number+"";
//    System.out.println(query);
        // new NewClass().sample();
       
        try {
           Db_connection.getOracleJDBCConnection();
           Db_insert.student();
           Db_insert.business();
           Db_insert.media();
           Db_insert.sports();
          Db_insert.candidate();
        } catch (Exception e) {
            System.out.println("Exception  in newcalss.java " + e);
        }
    }
}
