package com.hometown.dao;

import com.hometown.model.CultureItem;
import com.hometown.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CultureItemDAO {

    public List<CultureItem> getAllItems() {
        List<CultureItem> list = new ArrayList<>();
        String sql = "SELECT * FROM culture_items ORDER BY created_at DESC";
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CultureItem item = new CultureItem();
                item.setId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setImageUrl(rs.getString("image_url"));
                item.setCategory(rs.getString("category"));
                item.setType(rs.getString("type"));
                item.setLocation(rs.getString("location"));
                item.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
