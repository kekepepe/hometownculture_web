package com.hometown.dao;

import com.hometown.model.User;
import com.hometown.util.DBUtil;
import java.sql.*;

public class UserDAO {

    public boolean register(User user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User login(String username, String password) {
        // Use simpler query first to debug
        String sql = "SELECT id, username, password, email, created_at FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // TRIM inputs!
            if (username != null)
                username = username.trim();
            if (password != null)
                password = password.trim();

            System.out.println("DEBUG: UserDAO.login checking for user: [" + username + "]");

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));

                    // Robust timestamp handling
                    try {
                        user.setCreatedAt(rs.getTimestamp("created_at"));
                    } catch (SQLException e) {
                        System.err.println("WARN: Could not parse created_at timestamp: " + e.getMessage());
                        // Continue even if timestamp fails
                    }

                    System.out.println("DEBUG: UserDAO found user ID: " + user.getId());
                    return user;
                } else {
                    System.out.println("DEBUG: UserDAO returned no results for query.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR: UserDAO login exception: " + e.getMessage());
        }
        return null;
    }
}
