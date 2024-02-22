package models;


    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlconnect extends env {
    
    protected static Connection con;
  //  protected static Statement state;
    public static void getConnection() throws SQLException
    {
        con=DriverManager.getConnection(env.DB_URL, env.USER,env.PASS);
       // Statement p=con.createStatement();
    }
}


