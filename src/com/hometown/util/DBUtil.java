package com.hometown.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/hometown_culture?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String USER = "root"; 
    private static final String PASSWORD = "password"; // REPLACE WITH YOUR PASSWORD

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
