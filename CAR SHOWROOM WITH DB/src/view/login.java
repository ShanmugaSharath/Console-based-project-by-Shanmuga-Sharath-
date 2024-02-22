package view;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import controllers.adduser;
import controllers.booking;
import controllers.connection;
import models.userlist;
public class login extends connection  {
   static Scanner sc=new Scanner(System.in);
    public static admin ad=new admin();
    public static adduser u=new adduser();
    public static void showroom_list() throws Exception {
        
       connection.getConnection();
       String query="select * from showroom_list";
       
        Statement st=con.createStatement();
        ResultSet re=st.executeQuery(query);
        while(re.next())
        {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(re.getInt(1)+"   |  "+re.getString(2)+"         |     "+re.getString(3)+"      |     "+re.getString(4));
            
        }
        con.close();
        System.out.println("GO BACK TO MAIN MENU PRESS 0 or NEXT PAGE PRESS 1");
        int back=sc.nextInt();
        if(back==0)
        {
               admin.admin_option();
        }
    }
    public static void car_list() throws Exception{
        Scanner sc=new Scanner(System.in);
        connection.getConnection();
        String query="select * from cars_list ";
        
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);//executequery just show the colums
        int n=1;
        while(rs.next())
        {
            System.out.println("********************************************************************************************************************************************");
            System.out.println(n+"       "+rs.getInt(1)+"   &  "+rs.getString(2)+"  &  "+rs.getString(3)+"  &   "+rs.getString(4));
            n++;
            //System.out.println("--------------------------------");
            
        }
        con.close();
        System.out.println("GO BACK TO MAIN MENU PRESS 0 or NEXT PAGE PRESS 1");
        int back=sc.nextInt();
        if(back==0)
        {
               admin.admin_option();
        }
        
    }
    public static void cust_list() throws Exception{
        Scanner sc=new Scanner(System.in);
        connection.getConnection();
        String query="select * from cust_list ";
        
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);//executequery just show the colums
        int n=1;
        while(rs.next())
        {
            System.out.println("********************************************************************************************************************************************");
            System.out.println(n+"       "+rs.getString(1)+"   &  "+rs.getString(2)+"  &  "+rs.getString(3)+"  &   "+rs.getString(4)+"  &   "+rs.getString(5));
            n++;
            //System.out.println("--------------------------------");
            
        }
        con.close();
        System.out.println("GO BACK TO MAIN MENU PRESS 0 or NEXT PAGE PRESS 1");
        int back=sc.nextInt();
        if(back==0)
        {
               admin.admin_option();
        }
        
    }
    
    
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        //customerbooking c=new customerbooking();
        
        System.out.println("1.SIGN IN");
        System.out.println("2.SIGN UP");
        int user=sc.nextInt();
        if(user==1)
        {
            System.out.println("ENTER USERNAME");
            String username=sc.next();
            System.out.println("ENTER PASSWORD");
            String password=sc.next();
            connection.getConnection();
            Statement st=con.createStatement();
            String query="select user_name from login_checker";
            ResultSet rs1=st.executeQuery(query);//executequery just show the colums
            int having=0;
            //int nothaving=0;
            while(rs1.next())
            {
                String s=rs1.getString(1);
                if(s.equals(username))
                {
                    having=1;
                    break;
                }
            }
            //con.close();
            connection.getConnection();
            Statement st1=con.createStatement();
            
            
            String query2="select login_admin from login_checker where user_name='"+username+"'";
            ResultSet rs2=st1.executeQuery(query2);//executequery just show the colums
            if(having!=0)
            {
                //ResultSet rs2=st.executeQuery(query2);
                int admin=0;
                while(rs2.next())
                {
                    String s2=rs2.getString(1);
                    if(s2.equals("YES"))
                    {
                        System.out.println("yes you are admin");
                        admin++;
                        break;
                    }
                }
                con.close();
                if(admin!=0)
                {

                    ad.admin_option();
                }
                else
                {
                    login l=new login();
                    l.showroom_list();
                    System.out.println("PLEASE SELECT SHOWROOM");
                    int n1=sc.nextInt();
                    if(n1==1)
                    {
                        l.car_list();
                        System.out.println("PLEASE SELECT CAR");
                        int n2=sc.nextInt();
                        if(n2==1)
                        {
                            booking.addcalling();
                        }
                    }
                }
            }
            else
            {
                System.out.println("INVALID USERNAME AND PASSWORD");
            }
            
        }
        else if(user==2)
        {
             System.out.println("ENTER YOUR FULL NAME");
             String full_name=sc.next();
             System.out.println("ENTER NEW USER NAME WITH (8-characters && @gmail && (1-9)nums)");
             String user_name=sc.next();
             System.out.println("ENTER NEW PASSWORD");
             String pass_word=sc.next();
             System.out.println("IF YOUR ADMIN TYPE ('YES' AND ADMIN_CODE) OR TYPE 'NO'");
             String login_admin=sc.next();
             System.out.println("ENTER PHONENUMBER");
             String phonenumber=sc.next();

            u.adduser1(full_name, user_name, pass_word, login_admin,phonenumber);

        } 
            
    } 
   
    
    
    
      
  
   



}
