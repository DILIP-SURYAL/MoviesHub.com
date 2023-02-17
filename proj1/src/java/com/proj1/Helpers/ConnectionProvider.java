/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proj1.Helpers;

import java.sql.*;

public class ConnectionProvider {

    public static Connection con;

    public static Connection getConnection() {
        try {
            if(con == null){
                Class.forName("com.mysql.cj.jdbc.Driver");

       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1", "root", "root");
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;

    }
}
