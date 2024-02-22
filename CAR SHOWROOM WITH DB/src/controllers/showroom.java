package controllers;

import models.showroomlist;

public class showroom {
    
  public static int id;
   public static String name;
   public static String location;
   public static String service;
   
public void showroomadd(int id,String name,String location,String service) throws Exception
   {
    this.id=id;
    this.name=name;
    this.location=location;
    this.service=service;
    showroomlist.insertshowrooom();
   }
   public void showroomdelete(int id) throws Exception
   {
    this.id=id;
    showroomlist.deleteshowrooom();
   }

}
