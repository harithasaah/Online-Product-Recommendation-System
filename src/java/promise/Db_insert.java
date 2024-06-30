/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. 
 */

package promise;
import cluster.*;
import java.sql.*;
/**
 *
 * @author nge
 */
public class Db_insert {
    public static void student () throws Exception
    {
       int m=0,i=0,j=1,k=2,l=3,num=0,num1=0,xx=1,inc;
       Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
       for(i=0;i<10;i++)
        {
            for(j=i+1;j<10;j++)
            {
                for(k=j+1;k<10;k++)
                {
                    for(l=k+1;l<10;l++)
                    {
                        num++;
                    System.out.println((char)(i+65)+","+(char)(j+65)+","+(char)(k+65)+","+(char)(l+65));
                    System.out.println(num);
                    String quer="insert into student(C4,C4sup,count) values('"+(char)(i+65)+""+(char)(j+65)+""+(char)(k+65)+""+(char)(l+65)+"',"+m+","+num+")";
                    int records=Db_connection.stmt.executeUpdate(quer);
                    }
                }
            }
        }System.out.println(num);
       num=0;
        for(i=0;i<10;i++)
        {

            for(j=i+1;j<10;j++)
            {

                for(k=j+1;k<10;k++)
                {
                    num++;
                    System.out.println((char)(i+65)+","+(char)(j+65)+","+(char)(k+65));
                    System.out.println(num);
                    String q="update student set C3='"+(char)(i+65)+""+(char)(j+65)+""+(char)(k+65)+"', C3sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
                }
            }
        }
       num=0;
        for(i=0;i<10;i++)
        {
            for(j=i+1;j<10;j++)
            {
                    num++;
                    System.out.println((char)(i+65)+","+(char)(j+65));
                    System.out.println(num);
                    String q="update student set C2='"+(char)(i+65)+""+(char)(j+65)+"', C2sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
            }
        }
        num=0;
        for(i=0;i<58;i++)
        {
            if(i<26 || i>31)
            {
                    num++;
                    System.out.println((char)(i+65));
                    System.out.println(num);
                    String q="update student set c1DB='"+(char)(i+65)+"', c1DBsup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
            }
        }

    }
    public static void business () throws Exception
    {
       int m=0,i=0,j=1,k=2,l=3,num=0,num1=0,xx=1,inc;
       Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
       for(i=10;i<20;i++)
        {
            for(j=i+1;j<20;j++)
            {
                for(k=j+1;k<20;k++)
                {
                    for(l=k+1;l<20;l++)
                    {
                        num++;
                    System.out.println((char)(i+65)+","+(char)(j+65)+","+(char)(k+65)+","+(char)(l+65));
                    System.out.println(num);
                    String quer="insert into business(C4,C4sup,count) values('"+(char)(i+65)+""+(char)(j+65)+""+(char)(k+65)+""+(char)(l+65)+"',"+m+","+num+")";
                    int records=Db_connection.stmt.executeUpdate(quer);
                    }
                }
            }
        }System.out.println(num);
       num=0;
        for(i=10;i<20;i++)
        {

            for(j=i+1;j<20;j++)
            {

                for(k=j+1;k<20;k++)
                {
                    num++;
                    System.out.println((char)(i+65)+","+(char)(j+65)+","+(char)(k+65));
                    System.out.println(num);
                    String q="update business set C3='"+(char)(i+65)+""+(char)(j+65)+""+(char)(k+65)+"', C3sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
                }
            }
        }
       num=0;
        for(i=10;i<20;i++)
        {
            for(j=i+1;j<20;j++)
            {
                    num++;
                    System.out.println((char)(i+65)+","+(char)(j+65));
                    System.out.println(num);
                    String q="update business set C2='"+(char)(i+65)+""+(char)(j+65)+"', C2sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
            }
        }
        num=0;
        for(i=0;i<58;i++)
        {
            if(i<26 || i>31)
            {
                    num++;
                    System.out.println((char)(i+65));
                    System.out.println(num);
                    String q="update business set c1DB='"+(char)(i+65)+"', c1DBsup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
            }
        }
            System.out.println("Business inserted successfully "  );
    }
    public static void media () throws Exception
    {
       int m=0,i=0,j=1,k=2,l=3,num=0,num1=0,xx=1,inc;
       Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
       for(i=0;i<10;i++)
        {
            for(j=i+1;j<10;j++)
            {
                for(k=j+1;k<10;k++)
                {
                    for(l=k+1;l<10;l++)
                    {
                        num++;
                    System.out.println((char)(i+97)+","+(char)(j+97)+","+(char)(k+97)+","+(char)(l+97));
                    System.out.println(num);
                    String quer="insert into media(C4,C4sup,count) values('"+(char)(i+97)+""+(char)(j+97)+""+(char)(k+97)+""+(char)(l+97)+"',"+m+","+num+")";
                    int records=Db_connection.stmt.executeUpdate(quer);
                    }
                }
            }
        }System.out.println(num);
       num=0;
        for(i=0;i<10;i++)
        {

            for(j=i+1;j<10;j++)
            {

                for(k=j+1;k<10;k++)
                {
                    num++;
                    System.out.println((char)(i+97)+","+(char)(j+97)+","+(char)(k+97));
                    System.out.println(num);
                    String q="update media set C3='"+(char)(i+97)+""+(char)(j+97)+""+(char)(k+97)+"', C3sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
                }
            }
        }
       num=0;
        for(i=0;i<10;i++)
        {
            for(j=i+1;j<10;j++)
            {
                    num++;
                    System.out.println((char)(i+97)+","+(char)(j+97));
                    System.out.println(num);
                    String q="update media set C2='"+(char)(i+97)+""+(char)(j+97)+"', C2sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
            }
        }
        num=0;
        for(i=0;i<58;i++)
        {
            if(i<26 || i>31)
            {
                    num++;
                    System.out.println((char)(i+65));
                    System.out.println(num);
                    String q="update media set c1DB='"+(char)(i+65)+"', c1DBsup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
            }
        }
        System.out.println("Media inserted successfully "  );

    }
    public static void sports () throws Exception
    {
       int m=0,i=0,j=1,k=2,l=3,num=0,num1=0,xx=1,inc;
       Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
       for(i=10;i<20;i++)
        {
            for(j=i+1;j<20;j++)
            {
                for(k=j+1;k<20;k++)
                {
                    for(l=k+1;l<20;l++)
                    {
                        num++;
                    System.out.println((char)(i+97)+","+(char)(j+97)+","+(char)(k+97)+","+(char)(l+97));
                    System.out.println(num);
                    String quer="insert into sports(C4,C4sup,count) values('"+(char)(i+97)+""+(char)(j+97)+""+(char)(k+97)+""+(char)(l+97)+"',"+m+","+num+")";
                    int records=Db_connection.stmt.executeUpdate(quer);
                    }
                }
            }
        }System.out.println(num);
       num=0;
        for(i=10;i<20;i++)
        {

            for(j=i+1;j<20;j++)
            {

                for(k=j+1;k<20;k++)
                {
                    num++;
                    System.out.println((char)(i+97)+","+(char)(j+97)+","+(char)(k+97));
                    System.out.println(num);
                    String q="update sports set C3='"+(char)(i+97)+""+(char)(j+97)+""+(char)(k+97)+"', C3sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
                }
            }
        }
       num=0;
        for(i=10;i<20;i++)
        {
            for(j=i+1;j<20;j++)
            {
                    num++;
                    System.out.println((char)(i+97)+","+(char)(j+97));
                    System.out.println(num);
                    String q="update sports set C2='"+(char)(i+97)+""+(char)(j+97)+"', C2sup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
            }
        }
        num=0;
        for(i=0;i<58;i++)
        {
                    if(i<26 || i>31)
                    {
                    num++;
                    System.out.println((char)(i+65));
                    System.out.println(num);
                    String q="update sports set c1DB='"+(char)(i+65)+"', c1DBsup="+m+" where count="+num;
                    int records=Db_connection.stmt.executeUpdate(q);
                    }
        }

        System.out.println("Sports inserted successfully "  );

    }
    public static void candidate()throws Exception
    {
         Statement stmt = Db_connection.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
         for(int i=0;i<58;i++)
         {
             if(i<26 || i>31)
             {
                    System.out.println((char)(i+65));
                    String q="insert into candidate (C1DB,C1DBsup,C1NEWSUP) values ('"+(char)(i+65)+"',0,0)";
                    int records=Db_connection.stmt.executeUpdate(q);
             }
         }
         System.out.println("candidate inserted successfully "  );
    }

}