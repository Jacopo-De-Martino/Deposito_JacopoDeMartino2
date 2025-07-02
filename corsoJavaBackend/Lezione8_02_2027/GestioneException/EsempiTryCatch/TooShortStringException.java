public class TooShortStringException extends Exception {
    public TooShortStringException() {
    };

    // Costruttore paramentrico per messaggio e causa
    public TooShortStringException(String message, Throwable cause) {
        super(message, cause);
    }
}
