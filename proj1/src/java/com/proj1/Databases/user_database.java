package com.proj1.Databases;

import java.sql.*;
import com.proj1.Entities.user_info;



public class user_database {
    
    public Connection con;
    
    public user_database(Connection con){
    this.con = con;
    
    }
    //for singnup purpose
    public boolean save_user_info(user_info user){
        boolean t = false;
       try{
        String query = "insert into user_info(name,email,password,gender,about) values(?,?,?,?,?)";
    
        PreparedStatement stmt = this.con.prepareStatement(query);
        
        stmt.setString(1 ,user.getName());
        stmt.setString(2 ,user.getEmail());
        stmt.setString(3 ,user.getPassword());
        stmt.setString(4 ,user.getGender());
        stmt.setString(5 ,user.getAbout());
        
        stmt.executeUpdate();
        
        t= true;
        
       }
       catch(Exception e){
       e.printStackTrace();
       }
       
       return t;
    }
    //for login purpose
    public user_info get_User_Info(String email, String password){
        user_info user = null;
        
        try{
        String query = "select * from user_info where email=? and password=?";
        
        PreparedStatement stmt = this.con.prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet set = stmt.executeQuery();
        
        
        
        if(set.next()){
            user = new user_info();
            
          user.setId(set.getInt("id"));
          user.setName(set.getString("name"));
          user.setEmail(set.getString("email"));
          user.setPassword(set.getString("password"));
          user.setGender(set.getString("gender"));
          user.setAbout(set.getString("about"));
          user.setRdate(set.getTimestamp("rdate"));
          user.setProfile(set.getString("profile"));
         }
        }
        catch(Exception e){e.printStackTrace();}
        
        return user;
        }
    
    public boolean update_User_Info(user_info user){
    boolean f=false;
    try{
    String query = "update user_info set name=? , password=? , email=? , about=? ,profile=?  where id=?";
    
    PreparedStatement stmt = this.con.prepareStatement(query);
    
    stmt.setString(1, user.getName());
    stmt.setString(2, user.getPassword());
    stmt.setString(3, user.getEmail());
    stmt.setString(4, user.getAbout());
    stmt.setString(5, user.getProfile());
    stmt.setInt(6, user.getId());
    
    stmt.executeUpdate();
    
    f=true;
    }
    catch(Exception e){e.printStackTrace();}
    return f;
    }
    
    public user_info getUserByUserId(int userId){
    
        user_info user = new user_info();
    try{
     String query ="select * from user_info where id=?";
     
     PreparedStatement stmt = this.con.prepareStatement(query);
     
     stmt.setInt(1,userId );
     
     ResultSet set =stmt.executeQuery();
     
    if(set.next()){
       
          user.setId(set.getInt("id"));
          user.setName(set.getString("name"));
          user.setEmail(set.getString("email"));
          user.setPassword(set.getString("password"));
          user.setGender(set.getString("gender"));
          user.setAbout(set.getString("about"));
          user.setRdate(set.getTimestamp("rdate"));
          user.setProfile(set.getString("profile"));
    
    }
     
    }
    catch(Exception e){
    e.printStackTrace();
    }
    return user;
    }
    
    
}
