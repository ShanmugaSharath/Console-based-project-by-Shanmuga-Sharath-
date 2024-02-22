package controllers;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import view.admin;

//import com.mysql.cj.xdevapi.Statement;

public class orderlist extends connection {
    
    public static int n=1;
     public static void orderby() throws Exception{
       
        Scanner sc=new Scanner(System.in);
            connection.getConnection();
            String query="select * from cust_list order by reg_date";
            
             Statement st=con.createStatement();
             ResultSet re=st.executeQuery(query);
             while(re.next())
             {
                 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                 System.out.println(n+".  "+re.getString(1)+"   |  "+re.getString(2)+"         |     "+re.getString(3)+"      |     "+re.getString(4)+"      |     "+re.getString(5));
                 n++;
                 
             }
             con.close();
           
         }
     }



