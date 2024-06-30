/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
*/
package cluster;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 
 */
public class Db_connection {

    public static String userid = "root", password = "admin";
  public static String url = "jdbc:mysql://localhost:3306/webboss";
  // public static String url = "jdbc:mysql://localhost:3306/sample";

      public static Statement stmt;
      public static Connection con = null;

    public static void getOracleJDBCConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try 
        {
            con = DriverManager.getConnection(url, userid, password);
            System.out.println("Connection created "+con);
            stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    java.sql.ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) 
        {
            System.err.println("SQLException: (in Db_connection) " + ex.getMessage());
        }
    }

    public  String getEmail(String usrName) {
        ResultSet resultSet =null;
        String email ="";
        getOracleJDBCConnection();
        String query = "SELECT email FROM cdetails WHERE user_name ='"+usrName+"'";
        try {
            stmt = con.createStatement();

        resultSet =  stmt.executeQuery(query);

        while(resultSet.next()){
         email = resultSet.getString(1);

        }
         } catch (SQLException ex) {
            System.out.println("Exception "+ex);
        }
        return email;

    }

    public void removeItem(String item) throws Exception {
        //getOracleJDBCConnection();
        String query ="update wishlist set isValid = 0 where item = binary '"+item+"'";
        stmt.executeUpdate(query);
        System.out.println("Updated Successfully");
    }

 



}
