package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import controllers.customer;
import view.admin;

public class customerlist extends sqlconnect {
    public static String name;
    public static void deletecustomer() throws Exception{//using preparedStatement
        Scanner sc=new Scanner(System.in);
        
        sqlconnect.getConnection();
      
     name=customer.name;

      
       // Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="delete from cust_list where cust_name = '"+name+"'";
         Statement p=con.createStatement();
         
         
         int r=p.executeUpdate(query);//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("CUSTOMERLIST DELETED SUCCESSFULL");
             System.out.println("GO BACK TO MAIN MENU PRESS 0");
             int back=sc.nextInt();
             if(back==0)
             {
                    admin.admin_option();
             }
         }
        con.close();
    
    }


    public static void add_customer() throws Exception{//using preparedStatement
        Scanner sc=new Scanner(System.in);
       sqlconnect.getConnection();
      
        System.out.println("please enter name");
        String name=sc.next();
        System.out.println("please enter car_id");
        String carid=sc.next();
        System.out.println("ARE YOU BOOKING! SURE then please enter YES & if you not booking please enter NO ");
        String booking=sc.next();
        System.out.println("if you want service please enter yes or no");
        String service=sc.next();
        System.out.println("please enter DATE for register");
        String regdate=sc.next();
      
        //Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="insert into cust_list values(?,?,?,?,?);";
         PreparedStatement p=con.prepareStatement(query);
         p.setString(1, name);
         p.setString(2, carid);
         p.setString(3, booking);
         p.setString(4, service);
         p.setString(5, regdate);
         int r=p.executeUpdate();//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("YOUR BOOKING SUCCESSFULL");
         }
        con.close();
    
    }
}