package com.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila"; // sostituire con il nome del DB
        String user = "root"; // utente del DB
        String password = "root"; // password del DB

        try (Connection conn = DriverManager.getConnection(url, user, password);

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT title FROM film LIMIT 5")) {

            while (rs.next()) {

                System.out.println("Film: " + rs.getString("title"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
