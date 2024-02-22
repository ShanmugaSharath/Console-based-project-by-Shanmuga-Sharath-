package models;

import java.sql.PreparedStatement;

import controllers.adduser;

public class userlist extends sqlconnect {
    public static String full_name;
    public static String user_name;
    public static String pass_word;
    public static String login_admin;
    public static String phonenumber;
    
    public static void adduser() throws Exception{//using preparedStatement
       
        sqlconnect.getConnection();
      
     full_name=adduser.full_name;
     user_name=adduser.user_name;
     pass_word=adduser.pass_word;
     login_admin=adduser.login_admin;
     phonenumber=adduser.phonenumber;
      
      
        //Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="insert into login_checker values(?,?,?,?,?);";
         PreparedStatement p=con.prepareStatement(query);
         p.setString(1, full_name);
         p.setString(2, user_name);
         p.setString(3, pass_word);
         p.setString(4, login_admin);
         p.setString(5, phonenumber);

         
         int r=p.executeUpdate();//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("YOUR ACCOUNT CREATED SUCCESSFULL!");
         }
        con.close();
    
    }
}
