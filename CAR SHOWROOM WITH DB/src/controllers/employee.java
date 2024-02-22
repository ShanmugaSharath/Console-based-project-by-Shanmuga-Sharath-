package controllers;

import models.employeelist;

public class employee {
    public static int showid;
    public static String name;
    public static String age;
    public static Long phone;
    public  void addemployee(int showid,String name,String age,Long phone) throws Exception{
    this.showid=showid;
    this.name=name;
    this.age = age;
    this.phone=phone;
    employeelist.addemployee();


    }
    public void deleteemployee(String name) throws Exception
    {
        this.name=name;
        employeelist.deleteemployee();
    }

}
