package view;

import java.util.Scanner;

import controllers.cars;
import controllers.customer;
import controllers.employee;
import controllers.orderlist;
import controllers.showroom;
//import java.sql.*;
public class admin {
    static Scanner sc=new Scanner(System.in);
    static showroom s=new showroom();
    static cars c=new cars();
    static employee e=new employee();
    static customer cu=new customer();
    
    public static void admin_option() throws Exception{
       System.out.println("****************************************************************************************************");
       System.out.println("1. SHOWROOM's LIST                                 2.CAR's LIST");
       System.out.println();
       System.out.println("3.EMPLOYEE's LIST                                  4.CUSTOMER's LIST");
       System.out.println();
       System.out.println("5.ORDERS DETAILS");
       System.out.println();

       System.out.println("select the option");
       int sh=sc.nextInt();
       if(sh==1)
       {
        login.showroom_list();
        System.out.println("1.ADD SHOWROOM");
        System.out.println("2.DELETE SHOWROOM");
        int sh1=sc.nextInt();
        if(sh1==1)
        {
            System.out.println("ENTER SHOWROOM ID ");
            int id=sc.nextInt();
            System.out.println("ENTER SHOWROOM NAME");
            String name=sc.next();
            System.out.println("ENTER SHOWROOM LOCATION");
            String location=sc.next();
            System.out.println("ENTER SERVICE AVILABLE");
            String service=sc.next();
            s.showroomadd(id, name, location, service);

        }
       
       else if(sh1==2)
       {
          System.out.println("ENTER SHOWROOM ID");
          int id=sc.nextInt();
          s.showroomdelete(id);
          
      }

       }
       else if(sh==2)
       {
        login.car_list();
        System.out.println("1.ADD CARS");
        System.out.println("2.DELETE CARS");
        int sh1=sc.nextInt();
        if(sh1==1)
        {
            System.out.println("enter showroom id");
            int showid=sc.nextInt();
            System.out.println("enter car id");
            String carid=sc.next();
            System.out.println("enter car model");
            String carname=sc.next();
            System.out.println("enter price");
            String price=sc.next();
               c.addcar(showid, carid, carname, price);
        }
        else if(sh1==2)
        {
          System.out.println("enter car id");
          String car_id=sc.next();
          c.deletecar(car_id);
        }

       }
       else if(sh==3)
       {
        System.out.println("1.ADD EMPLOYEE");
        System.out.println("2.DELETE EMPLOYEE");
        int sh1=sc.nextInt();
        if(sh1==1)
        {
            System.out.println("enter showroom id");
       int showid=sc.nextInt();
       System.out.println("enter employee name");
         String name=sc.next();
          System.out.println("enter employee age");
        String age=sc.next();
       System.out.println("enter employee phonenumber");
          Long phone=sc.nextLong();
          e.addemployee(showid, name, age, phone);
        }
        else if(sh1==2)
        {
            System.out.println("ENTER EMPLOYEE NAME");
            String name=sc.next();
            e.deleteemployee(name);
        }
       }
       else if(sh==4)
       {
        login.cust_list();
        System.out.println("1.DELETE CUSTOMER");
        System.out.println("ENTER CUSTOMER NAME");
        String name=sc.next();
             cu.deletecust(name);
       }
       else if(sh==5)
       {
        System.out.print("ORDERS LIST");
        System.out.println();
        orderlist.orderby();
        System.out.println();
        System.out.print("NO OF ORDERS ");
        System.out.println((orderlist.n)-1);
        System.out.println("GO BACK TO MAIN MENU PRESS 0");
        int back=sc.nextInt();
        if(back==0)
        {
               admin.admin_option();
        }
       }
    }
}
   
        
        
        
       
         
        

        
       


