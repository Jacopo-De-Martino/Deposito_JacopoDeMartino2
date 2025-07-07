package corsoJavaBackend.lezione11_07_07_2025.ProvaPattern;

// Definizione della classe Logger come singleton
class Logger {
    // Istanza privata statica della classe Logger
    private static Logger instance;

    // Costruttore privato per impedire l'istanziazione diretta
    private Logger() {
    }

    // Metodo pubblico statico per ottenere l'unica istanza di Logger
    public static Logger getInstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
            instance = new Logger();
        }
        // Restituisce l'istanza esistente
        return instance;
    }

    // Metodo per stampare un messaggio di log
    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

public class EsempioLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance(); // Otteniamo l'istanza del logger
        logger1.log("Questo è un messaggio di log."); // Log di un messaggio
    }

}
