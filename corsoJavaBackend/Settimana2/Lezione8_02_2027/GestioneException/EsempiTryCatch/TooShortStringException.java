package corsoJavaBackend.Settimana2.Lezione8_02_2027.GestioneException.EsempiTryCatch;

public class TooShortStringException extends Exception {
    public TooShortStringException() {
    };

    // Costruttore paramentrico per messaggio e causa
    public TooShortStringException(String message, Throwable cause) {
        super(message, cause);
    }
}
