package models;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import controllers.employee;

public class employeelist extends sqlconnect {
    public static int showid;
    public static String name;
    public static String age;
    public static Long phone;

    public static void addemployee() throws Exception{//using preparedStatement
       
        sqlconnect.getConnection();
      
     
      showid=employee.showid;
      name=employee.name;
      age=employee.age;
      phone=employee.phone;
      
        //Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="insert into employe_list values(?,?,?,?);";
         PreparedStatement p=con.prepareStatement(query);
         p.setInt(1, showid);
         p.setString(2, name);
         p.setString(3, age);
         p.setLong(4, phone);
         
         int r=p.executeUpdate();//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("employee LIST ADD SUCCESSFULL!");
         }
        con.close();
    
    }
     public static void deleteemployee() throws Exception{//using preparedStatement
       
        sqlconnect.getConnection();
      
       name=employee.name;

      
        //Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
        String query="delete from employe_list where emp_name = '"+name+"'";
         Statement p=con.createStatement();
         
         
         int r=p.executeUpdate(query);//executeupdate is upadte in tables
         if(r==1)
         {
             System.out.println("EMPLOYEE LIST DELETED SUCCESSFULL");
         }
        con.close();
    
    }

}
