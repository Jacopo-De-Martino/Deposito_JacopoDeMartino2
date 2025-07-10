package corsoJavaBackend.Settimana1.lezione3_25_06_2025.EsercizioWhileEDoWhile;

import java.util.Scanner;

public class EsercizioWhile {

    public static void main(String[] args) {
        // instanzio un oggetto Scanner per leggere l'input dell'utente
        Scanner stringScanner = new Scanner(System.in);
        // variabili per la gestione dell'accesso
        // password di accesso predefinita
        // * String passwordAccesso = "Java123";
        // password di accesso dinamica
        System.out.println("Inserisci la password di accesso:");
        String passwordAccesso = stringScanner.nextLine();
        // numero di tentativi consentiti
        int tentativi = 3;
        // variabili per il nome utente e la password inserita
        String nomeUtente = "";
        String password;
        // variabile per verificare se l'accesso è consentito
        boolean accessoConsentito = false;

        while (tentativi != 0) {
            System.out.println("Benvenuto nel sistema di accesso. Inserisci il nome utente.");
            if (nomeUtente.isEmpty()) {
                nomeUtente = stringScanner.nextLine();
            }
            if (nomeUtente.isBlank()) {
                System.out.println("Il nome utente non può essere vuoto. Riprova.");
                continue; // salta il resto del ciclo e richiede nuovamente il nome utente
            }

            System.out.println("Inserisci la password per l'utente " + nomeUtente + ":");
            password = stringScanner.nextLine();
            // verifica se la password inserita corrisponde a quella di accesso
            if (password.equals(passwordAccesso)) {
                accessoConsentito = true;
                System.out.println("Accesso consentito. Benvenuto " + nomeUtente + "!");
                break; // esce dal ciclo se la password è corretta

            } else { // se la password non è corretta scla il numero di tentativi (Operatore di
                     // decremento)
                tentativi--;
                System.out.println("Password errata. Hai ancora " + tentativi + " tentativi.");
            }
        }
        // se i tentativi sono esauriti, l'accesso non è consentito
        if (tentativi == 0) {
            System.out.println("Accesso negato. Hai esaurito i tentativi.");
            accessoConsentito = false; // l'accesso non è consentito
        }

        // se l'accesso è consentito, entra nel sistema
        if (accessoConsentito) {
            do {
                System.out.println("Sei all'interno del sistema. Vuoi continuare? (s/n)");
                String risposta = stringScanner.nextLine();
                if (risposta.equalsIgnoreCase("n")) {
                    accessoConsentito = false;
                    System.out.println("Uscita dal sistema. Arrivederci " + nomeUtente + "!");
                } else if (risposta.equalsIgnoreCase("s")) {
                    System.out.println("Continuando nel sistema...");
                    break; // esce dal ciclo se l'utente vuole continuare
                } else {
                    System.out.println("Risposta non valida. Riprova.");
                }
            } while (accessoConsentito); // continua a chiedere finché l'utente non decide di uscire
        }

    }
}
