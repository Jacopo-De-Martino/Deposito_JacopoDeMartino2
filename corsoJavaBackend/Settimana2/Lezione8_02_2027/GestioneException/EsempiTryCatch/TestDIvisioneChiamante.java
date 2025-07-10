package corsoJavaBackend.Settimana2.Lezione8_02_2027.GestioneException.EsempiTryCatch;

public class TestDIvisioneChiamante {
    // Classe chiamante
    public static void main(String[] args) {

        try {
            EsempioDivisioneThrow.divisioneChecked(10, 2);
            System.out.println("Divisione checked OK!");
            try {
                EsempioDivisioneThrow.divisioneUnchecked(4, 2);
                System.out.println("Divisione Unchecked OK!");
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                System.out.println("Divisione Unchecked FAIL! " + message);
            }
            try {
                EsempioDivisioneThrow.divisione(3, 0);
            } catch (Exception e) {
                String message = e.getMessage();
                System.out.println(message);
                Throwable cause = e.getCause();
                e.printStackTrace();
                cause.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Divisione Checked FAIL!");
        }
        System.out.println("fine programma");
    }
}
