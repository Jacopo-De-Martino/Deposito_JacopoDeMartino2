package com.example;

import java.sql.*;

// import com.mysql.cj.xdevapi.Statement; // Removed incorrect import
import java.sql.Statement;

public class ProvaPreparedStatement {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/world";

        String user = "root";

        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String sql = "INSERT INTO utenti (nome) VALUES (?)";

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, "Mario Rossi");

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {

                ResultSet generatedKeys = stmt.getGeneratedKeys();

                if (generatedKeys.next()) {

                    int nuovoId = generatedKeys.getInt(1);

                    System.out.println("ID generato: " + nuovoId);

                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
}
