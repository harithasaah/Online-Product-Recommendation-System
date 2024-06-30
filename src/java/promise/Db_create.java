/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package promise;
import cluster.*;
import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author 
 */
public class Db_create {
    public static void create() throws SQLException
    {
        try
        {
        int i;
        /*Statement stmt1 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
        String query1="create table business (c1DB varchar(2000),c1DBsup number,L1 varchar(2000),L1sup number,PL1 varchar(2000),PL1sup number,C2 varchar(2000),C2sup number,L2 varchar(2000),L2sup number,PL2 varchar(2000),PL2sup number,C3 varchar(2000),C3sup number,L3 varchar(2000),L3sup number,PL3 varchar(2000),PL3sup number,C4 varchar(2000),C4sup number,L4 varchar(2000),L4sup number,count number)";
        stmt1.executeQuery(query1);
        Statement stmt2 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
        String query2="create table student (c1DB varchar(2000),c1DBsup number,L1 varchar(2000),L1sup number,PL1 varchar(2000),PL1sup number,C2 varchar(2000),C2sup number,L2 varchar(2000),L2sup number,PL2 varchar(2000),PL2sup number,C3 varchar(2000),C3sup number,L3 varchar(2000),L3sup number,PL3 varchar(2000),PL3sup number,C4 varchar(2000),C4sup number,L4 varchar(2000),L4sup number,count number)";
        stmt2.executeQuery(query2);
        Statement stmt3 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
        String query3="create table media (c1DB varchar(2000),c1DBsup number,L1 varchar(2000),L1sup number,PL1 varchar(2000),PL1sup number,C2 varchar(2000),C2sup number,L2 varchar(2000),L2sup number,PL2 varchar(2000),PL2sup number,C3 varchar(2000),C3sup number,L3 varchar(2000),L3sup number,PL3 varchar(2000),PL3sup number,C4 varchar(2000),C4sup number,L4 varchar(2000),L4sup number,count number)";
        stmt3.executeQuery(query3);
        Statement stmt4 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
        String query4="create table sports (c1DB varchar(2000),c1DBsup number,L1 varchar(2000),L1sup number,PL1 varchar(2000),PL1sup number,C2 varchar(2000),C2sup number,L2 varchar(2000),L2sup number,PL2 varchar(2000),PL2sup number,C3 varchar(2000),C3sup number,L3 varchar(2000),L3sup number,PL3 varchar(2000),PL3sup number,C4 varchar(2000),C4sup number,L4 varchar(2000),L4sup number,count number)";
        stmt4.executeQuery(query4);*/
        Statement stmt5 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
        String query5="create table candidate (c1DB varchar(2000),c1DBsup number,c1newsup number)";
        stmt5.executeQuery(query5);
        /*Statement stmt6 = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
        String query6="create table promise_trans (trans_day number,transaction_id number,customer_id number,items varchar(2000),cluster_no number,SLR float)";
        stmt6.executeQuery(query6);*/
        }
        catch(Exception e)
        {
            System.out.println("exception caught at Db_create()"+e);
        }
    }

}
