/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proj1.Entities;

import java.sql.Timestamp;


public class user_info {
   private int id;
   private String name;
   private String email;
   private String password;
   private String gender;
   private String about;
   private Timestamp rdate;
   private String profile;
   
  public user_info(int id, String name, String email, String password, String gender, String about, Timestamp rdate) {//for intialization of the data of the user 
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.about = about;
        this.rdate = rdate;
    }
    public user_info(){}
    
    public user_info( String name, String email, String password, String gender, String about) {//for intialization of the data of the user 
      
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.about = about;
        this.rdate = rdate;
        /*
        for manupalation of data of the user we are using getters and setters because 
        all data members are private che and apde ene manipulate nathi kari shakta
        
        */
        
      //for getting value of datamembers  
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getAbout() {
        return about;
    }

    public Timestamp getRdate() {
        return rdate;
    }

    public String getProfile() {
        return profile;
    }

    
    //for setting value of data members
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setRdate(Timestamp rdate) {
        this.rdate = rdate;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    
   
}
