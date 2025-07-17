package com.example;

import java.sql.*; // Import necessary SQL classes for database interaction
import java.util.Scanner; // Import Scanner for user input

/**
 * Questa classe si connette al database Sakila per recuperare e visualizzare
 * informazioni sui film più noleggiati, offrendo un menu interattivo
 * all'utente.
 */
public class Film {

    public static void main(String[] args) {
        // Parametri di connessione al database MySQL
        String url = "jdbc:mysql://localhost:3306/sakila"; // URL di connessione al database (DBMS:MySQL,
                                                           // host:localhost, porta:3306, nomeDB:sakila)
        String user = ""; // Nome utente del database
        String password = ""; // Password dell'utente del database

        // Blocco try-with-resources per gestire automaticamente la chiusura di
        // Connection e Statement.
        // Classe Connection rappresenta la connessione e viene valorizzata da
        // DriverManager.getConnection(url, user, password)
        try (Connection conn = DriverManager.getConnection(url, user, password);
                // Inizializzazione di uno Statement attraverso la Connection
                // conn.createStatement().
                // Lo Statement permette di eseguire query SQL.
                Statement stmt = conn.createStatement()) {

            System.out.println("Connessione al database Sakila stabilita con successo.");

            // Sezione per la creazione o verifica della vista 'film_piu_visti'.
            // Questa parte gestisce la compatibilità con versioni di MySQL che potrebbero
            // non supportare
            // "CREATE VIEW IF NOT EXISTS".
            try {
                // Tentativo di eliminare la vista se esiste già.
                // "DROP VIEW IF EXISTS" è un comando SQL per rimuovere una vista solo se
                // esiste,
                // prevenendo errori se la vista non è presente.
                stmt.executeUpdate("DROP VIEW IF EXISTS film_piu_visti;");
                System.out.println("Vista 'film_piu_visti' esistente eliminata (se presente).");
            } catch (SQLException e) {
                // Cattura l'eccezione se "DROP VIEW IF EXISTS" fallisce, ad esempio a causa di
                // versioni molto vecchie di MySQL che non supportano "IF EXISTS" anche per
                // DROP.
                System.err.println("Attenzione: Impossibile eliminare la vista 'film_piu_visti' in modo sicuro. " +
                        "Potrebbe non esistere o la tua versione MySQL ha un supporto limitato per 'IF EXISTS'. " +
                        "Procedo con la creazione della vista.");
                // Per un'applicazione robusta, qui si potrebbe ispezionare e.getSQLState() o
                // e.getErrorCode()
                // per distinguere tra un errore di "vista non trovata" e altri problemi gravi.
            }

            // Definizione della query SQL per creare la vista 'film_piu_visti'.
            // Questa vista calcola il numero di noleggi per ogni film.
            String createViewSql = "CREATE VIEW film_piu_visti AS " + // Creazione della vista (senza IF NOT EXISTS per
                                                                      // maggiore compatibilità)
                    "SELECT " +
                    "    f.film_id, " + // ID del film
                    "    f.title, " + // Titolo del film
                    "    COUNT(r.rental_id) AS numero_noleggi " + // Conteggio dei noleggi, aliased come
                                                                  // 'numero_noleggi'
                    "FROM " +
                    "    film AS f " + // Tabella film, aliased come 'f'
                    "JOIN " +
                    "    inventory AS i ON f.film_id = i.film_id " + // Join con inventory per collegare film a copie
                                                                     // disponibili
                    "JOIN " +
                    "    rental AS r ON i.inventory_id = r.inventory_id " + // Join con rental per collegare copie a
                                                                            // transazioni di noleggio
                    "GROUP BY " +
                    "    f.film_id, f.title " + // Raggruppa i risultati per film per contare i noleggi
                    "ORDER BY " +
                    "    numero_noleggi DESC;"; // Ordina i risultati dal film più noleggiato al meno noleggiato
            // Esecuzione della query DDL (Data Definition Language) per creare la vista.
            // Si usa executeUpdate() per comandi che modificano lo schema del DB e non
            // ritornano un ResultSet.
            stmt.executeUpdate(createViewSql);
            System.out.println("Vista 'film_piu_visti' creata con successo.");

            // Inizializzazione dello Scanner per acquisire input dall'utente
            Scanner scanner = new Scanner(System.in);
            int choice; // Variabile per memorizzare la scelta dell'utente

            // Ciclo do-while per presentare il menu all'utente fino a quando non sceglie di
            // uscire (opzione 0)
            do {
                System.out.println("\n--- Menu Film Noleggiati ---");
                System.out.println("1. Visualizza i 10 film più noleggiati (dal meno al più noleggiato)");
                System.out.println("2. Visualizza tutti i film (dal meno al più noleggiato)");
                System.out.println("0. Esci");
                System.out.print("Seleziona un'opzione: ");

                // Validazione dell'input: assicura che l'utente inserisca un numero intero
                while (!scanner.hasNextInt()) {
                    System.out.println("Input non valido. Inserisci un numero.");
                    scanner.next(); // Consuma l'input non valido per evitare un loop infinito
                    System.out.print("Seleziona un'opzione: ");
                }
                choice = scanner.nextInt(); // Legge la scelta numerica dell'utente
                scanner.nextLine(); // Consuma il carattere newline rimasto dopo nextInt()

                // Struttura switch per gestire le diverse opzioni del menu
                switch (choice) {
                    case 1:
                        displayFilms(stmt, true); // Chiama il metodo per visualizzare i 10 film più noleggiati
                        break;
                    case 2:
                        displayFilms(stmt, false); // Chiama il metodo per visualizzare tutti i film
                        break;
                    case 0:
                        System.out.println("Uscita dal programma."); // Messaggio di uscita
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprova."); // Messaggio per opzioni non riconosciute
                }
            } while (choice != 0); // Continua il ciclo finché la scelta non è 0

            scanner.close(); // Chiude lo scanner per rilasciare le risorse

        } catch (SQLException e) {
            // Cattura eccezioni relative all'accesso al database (es. problemi di
            // connessione, errori SQL)
            System.err.println("Errore SQL: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace completo per debug
        } catch (Exception e) {
            // Cattura qualsiasi altra eccezione inattesa
            System.err.println("Si è verificato un errore inatteso: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace completo per debug
        }
    }

    /**
     * Metodo helper per recuperare e visualizzare i film dal database.
     * La visualizzazione può essere limitata ai 10 film più noleggiati
     * o includere tutti i film, sempre ordinati dal meno al più noleggiato.
     */
    private static void displayFilms(Statement stmt, boolean isTop10) throws SQLException {
        String query; // Variabile per memorizzare la query SQL da eseguire

        if (isTop10) {
            // Query per ottenere i 10 film più noleggiati dalla vista 'film_piu_visti',
            // e poi ordinarli dal meno al più noleggiato tra questi 10.
            query = "SELECT film_id, title, numero_noleggi " +
                    "FROM ( " +
                    "    SELECT film_id, title, numero_noleggi " +
                    "    FROM film_piu_visti " +
                    "    LIMIT 10 " + // Limita ai primi 10 dalla vista (che sono i più noleggiati)
                    ") AS top_films_subset " + // Sottoquery per i top 10
                    "ORDER BY numero_noleggi ASC;"; // Ordina questi 10 dal meno al più noleggiato
            System.out.println("\n--- I 10 Film più noleggiati (dal meno al più noleggiato tra i 10) ---");
        } else {
            // Query per ottenere tutti i film dalla vista 'film_piu_visti',
            // ordinati dal meno al più noleggiato.
            query = "SELECT film_id, title, numero_noleggi " +
                    "FROM film_piu_visti " +
                    "ORDER BY numero_noleggi ASC;"; // Ordina tutti i film dal meno al più noleggiato
            System.out.println("\n--- Tutti i Film (dal meno al più noleggiato) ---");
        }

        // Blocco try-with-resources per gestire automaticamente la chiusura del
        // ResultSet
        // Utilizziamo lo Statement per ottenere un ResultSet (il risultato della query
        // SELECT)
        try (ResultSet rs = stmt.executeQuery(query)) {
            // Verifica se il ResultSet è vuoto (non ci sono righe).
            // rs.isBeforeFirst() restituisce false se il cursore è già alla fine o se non
            // ci sono righe.
            if (!rs.isBeforeFirst()) {
                System.out.println("Nessun film trovato.");
            } else {
                // Stampa l'intestazione delle colonne formattata
                System.out.printf("%-5s %-50s %-15s%n", "ID", "Titolo", "Noleggi");
                System.out.println("----------------------------------------------------------------------");
                // Cicliamo il ResultSet con un while utilizzando il metodo next().
                // Questo metodo sposta il cursore alla riga successiva e ritorna true se ci
                // sono elementi successivi nel ResultSet,
                // false altrimenti.
                while (rs.next()) {
                    int filmId = rs.getInt("film_id"); // Ottiene il valore della colonna 'film_id' come intero
                    String title = rs.getString("title"); // Ottiene il valore della colonna 'title' come stringa
                    long numRentals = rs.getLong("numero_noleggi"); // Ottiene il valore della colonna 'numero_noleggi'
                                                                    // come long
                    // Stampa i dettagli del film formattati
                    System.out.printf("%-5d %-50s %-15d%n", filmId, title, numRentals);
                }
            }
        }
    }
}