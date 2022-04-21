package com.example.demo.utility;

import com.example.demo.models.Employee;
import com.mysql.cj.protocol.Resultset;

import java.io.*;
import java.rmi.server.ExportException;
import java.sql.*;
import java.util.ArrayList;
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
            url = "jdbc:mysql://localhost:3306/employees_departments";
            username = "root";
            password = "hejsa";
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException e){
            System.out.println("in dbConnectionManager");
            e.printStackTrace();
        }
        return conn;
    }

}

