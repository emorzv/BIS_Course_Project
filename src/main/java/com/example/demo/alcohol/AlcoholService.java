package com.example.demo.alcohol;

import org.springframework.stereotype.Service;

@Service
public class AlcoholService {
    public Alcohol searchByCipher(String cipher) {
        String sql = "SELECT * FROM Alcohol WHERE Cipher = ?";
        Alcohol alcohol = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cipher);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    alcohol = new Alcohol(
                            rs.getInt("AlcoholID"),
                            rs.getString("Cipher"),
                            rs.getString("Name"),
                            rs.getString("Type"),
                            rs.getString("Brand"),
                            rs.getDouble("Volume"),
                            rs.getDouble("Price"),
                            rs.getInt("StockQuantity"),
                            rs.getString("Description"),
                            rs.getInt("SupplierID")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alcohol;
    }
}
