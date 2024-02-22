package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection extends env2 {
    
   protected static Connection con;
  //  protected static Statement state;
    public static void getConnection() throws SQLException
    {
        con=DriverManager.getConnection(env2.DB_URL, env2.USER,env2.PASS);
       // Statement p=con.createStatement();
    }
}