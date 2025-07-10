package corsoJavaBackend.Settimana2.Lezione8_02_2027.GestioneException.EsempiTryCatch;

public class EsempioDivisioneThrow {
    // metodi statici classe chiamata
    public static int divisioneChecked(int a, int b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("Il secondo operando non puo essere 0");
        }
        return a / b;
    }

    public static int divisioneUnchecked(int a, int b) throws RuntimeException {
        if (b == 0) {
            throw new RuntimeException("Il secondo operando non può essere 0");
        }
        return a / b;
    }

    public static int divisione(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            throw new RuntimeException("Il secondo operando non può essere 0", e);
        }
    }
}
