package corsoJavaBackend.lezione11_07_07_2025.EserciziPattern;

//Singleton per logger
class Logger {
    // campo privato statico per l'istanza del logger
    private static Logger instance;

    private Logger() {
        // inizializzazione del logger, ad esempio apertura di un file di log
        System.out.println("Logger instance created");
    }

    public static Logger getInstance() { // Metodo per ottenere l'istanza del logger
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        // metodo per registrare un messaggio di log
        System.out.println("[LOG] " + message);
    }

    @Override
    public boolean equals(Object obj) {
        // Override del metodo equals per confrontare le istanze del logger
        if (this == obj) {
            return true; // se sono la stessa istanza
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // se l'oggetto è null o di un'altra classe
        }
        return true; // altrimenti, sono considerati uguali
    }
}

// Classe GestoreLog per testare il logger singleton
public class GestoreLog {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance(); // Ottieni l'istanza del logger
        logger1.log("Singleton creato con successo"); // Log di un messaggio
        Logger logger2 = Logger.getInstance(); // Ottieni di nuovo l'istanza del logger
        logger2.log("Singleton cambia puntamento"); // Log di un altro messaggio

        if (logger1.equals(logger2)) {
            System.out.println("logger1 e logger2 sono la stessa istanza.");
        } else {
            System.out.println("logger1 e logger2 sono istanze diverse.");
        }
    }

}
