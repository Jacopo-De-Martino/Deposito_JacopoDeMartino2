package corsoJavaBackend.lezione11_07_07_2025.EserciziPattern;

import java.util.Scanner;

class DatabaseManager {// Classe DatabaseManager Singleton per effettuare conessioni col db.
    private static DatabaseManager instance;// Attributo che verrà valorizzato con l'instanza stessa dell'oggetto nel
                                            // metodo getInstance
    static int connectionCount = 0;

    public static int getConnectioCount() {
        return connectionCount;
    }

    private DatabaseManager() {
        connectionCount++;
    }// Costruttore privato

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void connect() {
        if (instance != null) {
            System.out.println("Connessione stabilita. Connessioni attive : " + connectionCount);
        }
    }

    public void selectUser() {
        // Simulazione dei dati come array bidimensionale: [ID, Nome]
        if (instance != null) {
            String[][] users = {
                    { "1", "Alice" },
                    { "2", "Bob" },
                    { "3", "Charlie" },
                    { "4", "Diana" }
            };

            // Visualizzazione dei dati
            System.out.println("Lista utenti dal 'database':");
            for (int i = 0; i < users.length; i++) {
                System.out.println("ID: " + users[i][0] + ", Nome: " + users[i][1]);
            }
        }
    }

    // Metodo di reset
    public void resetInstance() {
        instance = null;
        connectionCount = 0; // Resetta anche il conteggio delle connessioni
        System.out.println("Istanza DatabaseManager resettata.");
    }
}

public class CollegamentoDb {
    public static void main(String[] args) {
        // DatabaseManager instance1 = DatabaseManager.getInstance(); // Creo un istanza
        // // Singleton di Database Manager
        // // utilizzando il metodo statico getInstance
        // instance1.connect();
        // instance1.connect();
        // instance1.connect();
        // instance1.selectUser();
        // System.out.println(DatabaseManager.getConnectioCount());
        // DatabaseManager instance2 = DatabaseManager.getInstance();
        // instance2.connect();
        // instance2.connect();
        // instance2.connect();
        // System.out.println(DatabaseManager.getConnectioCount());
        // instance2.resetInstance();
        // instance2.connect();
        // instance2.selectUser();
        // instance1.selectUser();
        // instance1 = DatabaseManager.getInstance();
        // instance1.selectUser();

        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = DatabaseManager.getInstance();
        boolean running = true;

        System.out.println("Benvenuto nel sistema di gestione Database!");

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Connetti al DB");
            System.out.println("2. Stampa utenti");
            System.out.println("3. Stampa numero connessioni attive");
            System.out.println("4. Resetta istanza DB (Solo per test)");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta;
            try {
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                continue; // Torna all'inizio del loop
            }

            switch (scelta) {
                case 1:
                    dbManager = DatabaseManager.getInstance();
                    dbManager.connect();
                    break;
                case 2:
                    dbManager.selectUser();
                    break;
                case 3:
                    System.out.println("Connessioni attive: " + DatabaseManager.getConnectioCount());
                    break;
                case 4:
                    dbManager.resetInstance();
                    // Dopo il reset, recupera una nuova "istanza" (che sarà la stessa in un
                    // Singleton reale,
                    // ma qui ci permette di vedere l'effetto del reset per testing).
                    // dbManager = DatabaseManager.getInstance();
                    break;
                case 0:
                    running = false;
                    System.out.println("Uscita dal programma. Arrivederci!");
                    break;
                default:
                    System.out.println("Opzione non valida. Per favore, scegli un numero dal menu.");
                    break;
            }
        }
        scanner.close(); // È buona pratica chiudere lo scanner quando non serve più.
    }

}
