package com.example;

import java.sql.*; // Importa le classi SQL necessarie per l'interazione con il database
import java.util.Scanner; // Importa Scanner per acquisire input dall'utente

/**
 * Questa classe si connette al database Sakila e permette all'utente di
 * interrogare la tabella 'customer' (clienti) in vari modi tramite un menu
 * interattivo.
 */
public class GestoreCustomers {

    public static void main(String[] args) {
        // Parametri di connessione al database MySQL
        String url = "jdbc:mysql://localhost:3306/sakila"; // URL di connessione al database
        String user = ""; // Nome utente del database
        String password = ""; // Password dell'utente del database

        // Blocco try-with-resources per gestire automaticamente la chiusura di
        // Connection e Statement.
        // La Classe Connection rappresenta la connessione e viene valorizzata da
        // DriverManager.getConnection()
        try (Connection conn = DriverManager.getConnection(url, user, password);
                // Inizializzazione di uno Statement attraverso la Connection
                // conn.createStatement().
                // Lo Statement permette di eseguire query SQL.
                Statement stmt = conn.createStatement()) {

            System.out.println("Connessione al database Sakila stabilita con successo.");

            Scanner scanner = new Scanner(System.in); // Inizializzazione dello Scanner per l'input utente
            int choice; // Variabile per memorizzare la scelta dell'utente

            // Ciclo do-while per presentare il menu all'utente fino a quando non sceglie di
            // uscire
            do {
                System.out.println("\n--- Menu Gestione Clienti Sakila ---");
                System.out.println("1. Recuperare tutti i clienti con nome che inizia per 'A'");
                System.out.println("2. Contare quanti clienti sono registrati in ogni città");
                System.out.println("3. Mostrare i 5 clienti più recenti");
                System.out.println("4. Ordinare tutti i clienti dal più vecchio al più recente (nome e data)");
                System.out.println("0. Esci");
                System.out.print("Seleziona un'opzione: ");

                // Validazione dell'input: assicura che l'utente inserisca un numero intero
                while (!scanner.hasNextInt()) {
                    System.out.println("Input non valido. Inserisci un numero.");
                    scanner.next(); // Consuma l'input non valido
                    System.out.print("Seleziona un'opzione: ");
                }
                choice = scanner.nextInt(); // Legge la scelta dell'utente
                scanner.nextLine(); // Consuma il carattere newline rimasto

                // Struttura switch per gestire le diverse opzioni del menu
                switch (choice) {
                    case 1:
                        getCustomersStartingWithA(stmt);
                        break;
                    case 2:
                        countCustomersByCity(stmt);
                        break;
                    case 3:
                        getFiveMostRecentCustomers(stmt);
                        break;
                    case 4:
                        getAllCustomersOrderedByCreationDate(stmt);
                        break;
                    case 0:
                        System.out.println("Uscita dal programma. Arrivederci!");
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprova.");
                }
            } while (choice != 0); // Il ciclo continua finché l'utente non sceglie di uscire

            scanner.close(); // Chiude lo scanner per rilasciare le risorse

        } catch (SQLException e) {
            // Cattura e gestisce le eccezioni relative all'accesso al database
            System.err.println("Errore SQL: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace completo per debug
        } catch (Exception e) {
            // Cattura qualsiasi altra eccezione inattesa
            System.err.println("Si è verificato un errore inatteso: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace completo per debug
        }
    }

    /**
     * Recupera e visualizza tutti i clienti il cui nome inizia con la lettera 'A'.
     *
     * @param stmt Lo Statement object per eseguire la query.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    private static void getCustomersStartingWithA(Statement stmt) throws SQLException {
        System.out.println("\n--- Clienti con nome che inizia per 'A' ---");
        // Query SQL: seleziona ID, nome, cognome ed email dalla tabella customer,
        // filtrando i nomi che iniziano con 'A'.
        // Nota: 'LIKE 'A%'' è case-insensitive di default in MySQL per VARCHAR/TEXT.
        String query = "SELECT customer_id, first_name, last_name, email FROM customer WHERE first_name LIKE 'A%';";

        // Blocco try-with-resources per la gestione automatica del ResultSet
        try (ResultSet rs = stmt.executeQuery(query)) {
            // Verifica se il ResultSet è vuoto
            if (!rs.isBeforeFirst()) {
                System.out.println("Nessun cliente trovato con nome che inizia per 'A'.");
            } else {
                // Stampa l'intestazione delle colonne formattata
                System.out.printf("%-5s %-20s %-20s %-30s%n", "ID", "Nome", "Cognome", "Email");
                System.out
                        .println("----------------------------------------------------------------------------------");
                // Itera attraverso i risultati
                while (rs.next()) {
                    int id = rs.getInt("customer_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    // Stampa i dettagli del cliente formattati
                    System.out.printf("%-5d %-20s %-20s %-30s%n", id, firstName, lastName, email);
                }
            }
        }
    }

    /**
     * Conta e visualizza il numero di clienti registrati in ogni città.
     */
    private static void countCustomersByCity(Statement stmt) throws SQLException {
        System.out.println("\n--- Conteggio clienti per città ---");
        // Query SQL: unisce le tabelle city, address e customer per contare i clienti
        // per ogni città.
        // I risultati sono raggruppati per nome della città e ordinati alfabeticamente
        // per città.
        String query = "SELECT " +
                "    c.city, " +
                "    COUNT(co.customer_id) AS numero_customer_per_city " +
                "FROM " +
                "    city AS c " +
                "JOIN " +
                "    address AS a ON c.city_id = a.city_id " +
                "JOIN " +
                "    customer AS co ON co.address_id = a.address_id " +
                "GROUP BY " +
                "    c.city " +
                "ORDER BY " +
                "    c.city ASC;"; // Ordina per nome della città

        try (ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                System.out.println("Nessuna città trovata con clienti.");
            } else {
                System.out.printf("%-30s %-10s%n", "Città", "N. Clienti");
                System.out.println("------------------------------------------");
                while (rs.next()) {
                    String city = rs.getString("city");
                    long numberOfCustomers = rs.getLong("numero_customer_per_city");
                    System.out.printf("%-30s %-10d%n", city, numberOfCustomers);
                }
            }
        }
    }

    /**
     * Recupera e visualizza i 5 clienti più recenti in base alla data di creazione.
     *
     * @param stmt Lo Statement object per eseguire la query.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    private static void getFiveMostRecentCustomers(Statement stmt) throws SQLException {
        System.out.println("\n--- I 5 clienti più recenti ---");
        // Query SQL: seleziona ID, nome, cognome e data di creazione dalla tabella
        // customer,
        // ordinando per data di creazione in modo decrescente e limitando a 5
        // risultati.
        String query = "SELECT customer_id, first_name, last_name, create_date FROM customer ORDER BY create_date DESC LIMIT 5;";

        try (ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                System.out.println("Nessun cliente trovato.");
            } else {
                System.out.printf("%-5s %-20s %-20s %-25s%n", "ID", "Nome", "Cognome", "Data Creazione");
                System.out.println("--------------------------------------------------------------------------");
                while (rs.next()) {
                    int id = rs.getInt("customer_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    // Per le date, è meglio recuperarle come Timestamp o String a seconda dell'uso.
                    // getString è spesso sufficiente per la visualizzazione.
                    String createDate = rs.getString("create_date");
                    System.out.printf("%-5d %-20s %-20s %-25s%n", id, firstName, lastName, createDate);
                }
            }
        }
    }

    /**
     * Recupera e visualizza tutti i clienti, ordinati dal più vecchio al più
     * recente,
     * mostrando nome e data di creazione.
     *
     * @param stmt Lo Statement object per eseguire la query.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    private static void getAllCustomersOrderedByCreationDate(Statement stmt) throws SQLException {
        System.out.println("\n--- Tutti i clienti (dal più vecchio al più recente) ---");
        // Query SQL: seleziona ID, nome, cognome e data di creazione dalla tabella
        // customer,
        // ordinando per data di creazione in modo crescente.
        String query = "SELECT customer_id, first_name, last_name, create_date FROM customer ORDER BY create_date ASC;";

        try (ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                System.out.println("Nessun cliente trovato.");
            } else {
                System.out.printf("%-5s %-20s %-20s %-25s%n", "ID", "Nome", "Cognome", "Data Creazione");
                System.out.println("--------------------------------------------------------------------------");
                while (rs.next()) {
                    int id = rs.getInt("customer_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String createDate = rs.getString("create_date");
                    System.out.printf("%-5d %-20s %-20s %-25s%n", id, firstName, lastName, createDate);
                }
            }
        }
    }
}