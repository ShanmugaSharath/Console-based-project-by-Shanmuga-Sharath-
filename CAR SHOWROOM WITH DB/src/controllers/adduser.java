package controllers;

import java.sql.PreparedStatement;
import java.util.Scanner;

import models.sqlconnect;
import models.userlist;

public class adduser {
    public static String full_name;
    public static String user_name;
    public static String pass_word;
    public static String login_admin;
    public static String phonenumber;
     public  void adduser1(String full_name,String user_name,String pass_word,String login_admin,String phonenumber) throws Exception{
    
         this.full_name=full_name;
         this.user_name=user_name;
         this.pass_word=pass_word;
         this.login_admin=login_admin;
         this.phonenumber=phonenumber;
         
        userlist.adduser();
    
    }
}
