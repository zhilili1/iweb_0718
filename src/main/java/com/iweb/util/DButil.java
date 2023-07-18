package com.iweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
   static {
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
   }
   private static String URL="jdbc:mysql://47.113.196.69:3306/shop?characterEncoding=utf8";
   private static String USERNAME="song";
   private static String PASSWORD="a12345";
   public static Connection getConnection()
   {
       try {
           return DriverManager.getConnection(URL,USERNAME,PASSWORD);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
   }
}
