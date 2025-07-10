package corsoJavaBackend.Settimana1.Lezione5_27_06_2025.ProvaFunzioni;

import java.util.Scanner;

public class Esercizio1ExtraMetodi {

    // Esercizio fattoriale
    // Metodo per calcolare il fattoriale in modo ricorsivo
    static int fattoriale(int n) {
        int risultato = 1;
        for (int i = 1; i <= n; i++) {
            risultato *= i; // risultato = risultato * i
        }
        return risultato;
    }

    // Overload metodo fattoriale
    static int fattoriale(String str) {
        int lunghezzaString = str.length();
        return lunghezzaString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // CORRETTO: uso System.in

        System.out.print("Inserisci un numero intero per calcolare il fattoriale: ");
        // VERIFICO CHE IL SUCCESSIVO IMPUT IL MIO OGGETTO SCANNER HA IN IMPUT UN NUMERO
        // INTERO VALIDO
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            // controllo se l'utente ha inserito un valore positivo minore di 0 e stampo il
            // messaggio di errore
            if (n < 0) {
                System.out.println("Il fattoriale non è definito per numeri negativi.");
                // se ha inserito un numero positivo calcolo il fattoriale e lo stampo
            } else {
                int risultato = fattoriale(n);
                System.out.println("Il fattoriale di " + n + " è: " + risultato);
            }
        } else if (scanner.hasNextLine()) {
            String stringatest = scanner.nextLine();
            System.out.println("Hai inserito  \"" + stringatest + "\" che contiene : " + fattoriale(stringatest)
                    + " caratteri");
        }
        // Gestione se in l'imput in ingresso è una String

        scanner.close(); // buona pratica
    }
}
