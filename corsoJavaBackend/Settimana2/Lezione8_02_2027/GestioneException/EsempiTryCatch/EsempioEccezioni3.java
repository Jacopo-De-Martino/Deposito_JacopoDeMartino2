package corsoJavaBackend.Settimana2.Lezione8_02_2027.GestioneException.EsempiTryCatch;

import java.util.Scanner;

public class EsempioEccezioni3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {// Chiude automaticamente una risorsa che ha un metodo close
                                                        // terminata l'esecuzione del blocco
            System.out.println("Inserisci un numero");
            int input = scanner.nextInt();
            System.out.println("Inserito " + input);
            int x = input / 0;
            System.out.println("x = " + x);
        } catch (Exception ex) { // Scatta a riga 11,intercettando l'anomalia
            ex.printStackTrace();
        }
    }
}
