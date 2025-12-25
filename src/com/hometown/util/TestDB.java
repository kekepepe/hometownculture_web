package com.hometown.util;

import com.hometown.dao.UserDAO;
import com.hometown.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {
    public static void main(String[] args) {
        System.out.println("=== Starting Database Diagnostic Tool ===");

        // 1. Test Connection
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("[PASS] Database Connection Successful!");

            // 2. Test Users Table Content
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users");
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("[INFO] Total users in database: " + count);
            }

            rs = stmt.executeQuery("SELECT id, username, password FROM users");
            System.out.println("--- Listing Users ---");
            while (rs.next()) {
                System.out.println("User: ID=" + rs.getInt("id") +
                        ", Username='" + rs.getString("username") + "'" +
                        ", Password='" + rs.getString("password") + "'");
            }
            System.out.println("---------------------");

        } catch (Exception e) {
            System.out.println("[FAIL] Database Connection or Query Failed:");
            e.printStackTrace();
            return;
        }

        // 3. Test UserDAO Login Logic
        UserDAO dao = new UserDAO();
        System.out.println("\n=== Testing UserDAO Login ===");
        // Replace these with the credentials the user is trying
        testLogin(dao, "testuser", "password"); // Example
    }

    private static void testLogin(UserDAO dao, String username, String password) {
        System.out.println("Attempting login with: " + username + " / " + password);
        User user = dao.login(username, password);
        if (user != null) {
            System.out.println("[PASS] Login Successful for user: " + user.getUsername());
        } else {
            System.out.println("[FAIL] Login Failed (User not found or password incorrect)");
        }
    }
}
