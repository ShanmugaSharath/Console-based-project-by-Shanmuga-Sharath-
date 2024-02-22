package controllers;

import models.customerlist;

public class customer {
    
    public static String name;
   public void deletecust(String name) throws Exception{
       this.name=name;
       customerlist.deletecustomer();
   }
}
