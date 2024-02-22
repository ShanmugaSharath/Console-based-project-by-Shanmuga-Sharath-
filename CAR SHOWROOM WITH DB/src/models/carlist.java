package models;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import controllers.cars;
import view.admin;

public class carlist extends sqlconnect {
    private static int showid;
    private static String carid;
    private static String carname;
    private static String price;

     public static void addcar() throws Exception{//using preparedStatement
        Scanner sc=new Scanner(System.in);
     /*    String DB_URL="jdbc:mysql://localhost:3306/carshowroom";
        String USER="root";
        String PASS="7397";
        */
      

sqlconnect.getConnection();
      
       // Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="insert into cars_list values(?,?,?,?);";
         PreparedStatement p=con.prepareStatement(query);
         showid=cars.id;
         carid=cars.car_id;
         carname=cars.model;
         price=cars.price;
         
         p.setInt(1, showid);
         p.setString(2, carid);
         p.setString(3, carname);
         p.setString(4, price);
         
         int r=p.executeUpdate();//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("CAR LIST ADD SUCCESSFULL!");
             System.out.println("GO BACK TO MAIN MENU PRESS 0");
             int back=sc.nextInt();
             if(back==0)
             {
                    admin.admin_option();
             }
         }
        con.close();
    
    }
    public static void deletecar() throws Exception{//using preparedStatement
        Scanner sc=new Scanner(System.in);
       /*  String DB_URL="jdbc:mysql://localhost:3306/carshowroom";
        String USER="root";
        String PASS="7397";
        */
        sqlconnect.getConnection();
      
    carid=cars.car_id;

      
        //Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="delete from cars_list where car_id = '"+carid+"'";
         Statement p=con.createStatement();
         
         
         int r=p.executeUpdate(query);//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("CARLIST DELETED SUCCESSFULL");
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
