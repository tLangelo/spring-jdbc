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

    private static Connection getConnection(){
        if(conn != null){
            return conn;
        }

        Connection conn = null;
        try(InputStream stream = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.url");
            password = properties.getProperty("db.url");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "dean", "hej");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
