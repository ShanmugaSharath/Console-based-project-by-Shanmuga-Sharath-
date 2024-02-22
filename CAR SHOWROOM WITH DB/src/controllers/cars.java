package controllers;

import models.carlist;

public class cars {
    //public static int id;
   public static String car_id;
   public static String model;
   public static String price;
public static int id;
   //public static String reg_date;
   public void addcar(int name,String car_id,String model,String price)
   {
    this.id=name;
    cars.car_id=car_id;
    this.model=model;
    this.price=price;
    //this.reg_date=reg_date;
    try {
        carlist.addcar();
    } catch (Exception e) {
        
        e.printStackTrace();
    }

   }
   public void deletecar(String car_id) throws Exception
   {
    cars.car_id=car_id;
    carlist.deletecar();
   }
   
}
