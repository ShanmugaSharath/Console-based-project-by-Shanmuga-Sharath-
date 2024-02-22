package models;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import controllers.showroom;
import view.admin;

public class showroomlist extends sqlconnect {
    
    private static int id;
   private static String name;
   private static String location;
   private static String service;
   
     public static void insertshowrooom() throws Exception{//using preparedStatement
        Scanner sc=new Scanner(System.in);
       /*  String DB_URL="jdbc:mysql://localhost:3306/carshowroom";
        String USER="root";
        String PASS="7397";
        */
      
       

      
       // Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="insert into showroom_list values(?,?,?,?);";
        sqlconnect.getConnection();
       
         PreparedStatement p=con.prepareStatement(query);
         id=showroom.id;
         name=showroom.name;
         location=showroom.location;
         service=showroom.service;
         p.setInt(1, id);
         p.setString(2, name);
         p.setString(3, location);
         p.setString(4, service);
         
         int r=p.executeUpdate();//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("SHOWROOM ADDED SUCCESSFULL");
             System.out.println("GO BACK TO MAIN MENU PRESS 0");
             int back=sc.nextInt();
             if(back==0)
             {
                    admin.admin_option();
             }
         }
        con.close();
    
    }
     public static void deleteshowrooom() throws Exception{//using preparedStatement
        Scanner sc=new Scanner(System.in);
   /*     String DB_URL="jdbc:mysql://localhost:3306/carshowroom";
        String USER="root";
        String PASS="7397";
        */
        sqlconnect.getConnection();
      id=showroom.id;
      //System.out.println("enter showroom id");
       //int id=sc.nextInt();

      sqlconnect.getConnection();
        //Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="delete from showroom_list where showrooms_id = "+id;
         Statement p=con.createStatement();
         
         
         int r=p.executeUpdate(query);//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("SHOWROOM DELETED SUCCESSFULL");
             System.out.println("GO BACK TO MAIN MENU PRESS 0");
             int back=sc.nextInt();
             if(back==0)
             {
                    admin.admin_option();
             }
         }
        con.close();
    
    }
}
