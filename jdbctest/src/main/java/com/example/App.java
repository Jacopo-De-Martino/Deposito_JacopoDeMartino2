package com.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila"; // (jdbc:rdbms)jdbc:mysql://(port)localhost:3306/nomedatabase
        String user = ""; // utente del DB
        String password = ""; // password del DB
        // try catch per testare la connessione col db
        // Classe Conn rappresenta la conessione e viene valorizzata da
        // DriverManager.getConnectio(url,user,password)
        try (Connection conn = DriverManager.getConnection(url, user, password);
                // inizializzazione di uno Statement attraverso la Connection
                // conn.createStatement()
                Statement stmt = conn.createStatement();
                // utilizziamo lo Statement per ottenere un ResultSet
                ResultSet rs = stmt.executeQuery("SELECT title FROM film LIMIT 5")) {
            // cicliamo il ResultSet con u while utilizzando il metodo next() questo metodo
            // ritorna true se ci sono elementi successivi nel ResultSet
            while (rs.next()) {

                System.out.println("Film: " + rs.getString("title")); // stamp il titolo dal ResultSet utilizzando
                                                                      // getString(nomecolonna)

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
