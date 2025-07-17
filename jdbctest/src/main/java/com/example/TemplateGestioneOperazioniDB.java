package com.example;

import java.sql.*;
import java.util.Scanner;

public class TemplateGestioneOperazioniDB {

    // Costanti statiche per la connessione al db
    private static final String url = "jdbc:mysql://localhost:3306/sakila";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nMenu Noleggi Film");
            System.out.println("1. Stampa la lista dei clienti il cui nome inizia con la lettera A");
            System.out.println("2. Conta quanti clienti sono registrati in ogni city");
            System.out.println("3. Mostra i 5 clienti piu recenti in ordine di creazione");
            System.out.println("4. Ordina dal piu vecchio al piu recente stampando nome e data creazione");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            choice = scanner.nextInt();

            // Se scelgo 1 mi richiama il metodo con all interno la query
            switch (choice) {
                case 1:
                    // stampaClientiConLetteraA();// metodo statico per case 1
                    break;
                case 2:
                    // contaClinetiPerCitta(); metodo statico per case 2
                    break;
                case 3:
                    primi5UtentiCreati(); // metodo statico per case 3
                    break;
                case 4:
                    // stampaUtentiDESC(); metodo statico case 4
                    break;
                case 0:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void primi5UtentiCreati() { // template metodo statico da richiamare nel menu
        String query = "SELECT * FROM customer ORDER BY create_date DESC LIMIT 5 "; // query

        // Utilizzo un try with resource per provare la creazione della connessione
        try (Connection conn = DriverManager.getConnection(url, user, password); // Connessione , Statement, ResultSet
                Statement stmt = conn.createStatement(); // Inizializazzione Statment
                ResultSet rs = stmt.executeQuery(query)) { // Salvataggio dati nel ResultSet, stmt.executeQuery(query)

            System.out.println("\nQuesti sono gli ultimi 5 clienti creati!"); // informazioni in merito allo statement

            while (rs.next()) { // ciclo utilizzando il metodo next() per il result set cicla finche trova una
                                // nuova "row"
                String first_name = rs.getString("first_name"); // utilizzo rs.getString(nome_colonna) per salvare i
                                                                // dati in una String

                System.out.println("Nome utente = " + first_name); // Stampo le singole "row"
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dei customer: " + e.getMessage());
        }

    }
}