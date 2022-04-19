package com.example.demo.utility;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnectionManager(){}

    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }
        try{
            url = "jdbc:mysql://localhost:3306/";
            username = "root";
            password = "hejsa";
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
