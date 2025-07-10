package corsoJavaBackend.Settimana1.lezione3_25_06_2025.EsercizioAssicurazione;

import java.util.Scanner;

public class Assicurazione {
    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);
        Scanner numScanner = new Scanner(System.in);
        // dichiaro le variabili necessarie
        int anni, anniEsperienza, numeroIncidenti, prezzoBase = 500;
        double prezzoFinale = prezzoBase;
        String nomePacchetto;

        // chiedo a l'utente di inserire eta e se è in possesso della patente
        System.out.println("Inserisci la tua età:");
        anni = numScanner.nextInt();
        if (anni <= 0) {
            System.out.println("L'età non può essere un valore negativo o uguale a 0");
            System.out.println("Rinserisci l'età corretta:");
            anni = numScanner.nextInt();
        }
        System.out.println("Hai la patente? (true/false):");
        // chiedo se l'utente ha la patente
        boolean patenteValida = stringScanner.nextBoolean();
        // creo una variabile booleana per verificare se l'utente è idoneo
        // a stipulare l'assicurazione
        boolean idoneo = (anni >= 18 && patenteValida);
        if (idoneo) {
            if (anni > 18 && anni <= 25) {
                prezzoFinale += prezzoBase * 0.20; // aumento del 20% per età compresa tra 18 e 25 anni
            }
            if (anni > 26 && anni <= 50) {
                prezzoFinale += 0; // nessun aumento per età compresa tra 26 e 50 anni
            }
            if (anni > 50 && anni <= 90) {
                prezzoFinale -= prezzoBase * 0.10; // sconto del 10% per età compresa tra 50 e 90 anni
            }
            // chiedo all'utente di inserire gli anni di esperienza alla guida
            System.out.println("Inserisci gli anni di esperienza alla guida:");
            anniEsperienza = numScanner.nextInt();

            if (anniEsperienza < 2) {
                prezzoFinale += prezzoBase * 0.50; // aumento del 50% per meno di 2 anni
            } else {
                // nessuna maggiorazione per più di 2 anni
                prezzoFinale += 0; // nessun aumento
            }

            // chiedo all'utente di inserire il numero di incidenti
            System.out.println("Inserisci il numero di incidenti negli ultimi 5 anni:");
            numeroIncidenti = numScanner.nextInt();
            stringScanner.nextLine(); // pulisco il buffer
            if (numeroIncidenti == 0) {
                prezzoFinale += 0; // nessun aumento se nessun incidente
            } else if (numeroIncidenti == 1) {
                prezzoFinale += prezzoBase * 0.15; // aumento del 15% se un incidenti
            } else if (numeroIncidenti >= 2 && numeroIncidenti <= 4) {
                prezzoFinale += prezzoBase * 0.30; // aumento del 30% incidenti comprensi tra 2 e 4
            } else {
                System.out.println("Numero di incidenti troppo elevato, assicurazione non disponibile.");
                numScanner.close();
                stringScanner.close();
                return; // esco dal programma se il numero di incidenti è troppo elevato
            }

            // chiedo all'utente di inserire il nome del pacchetto assicurativo
            System.out.println("Inserisci il nome del pacchetto assicurativo (base, premium, gold):");
            nomePacchetto = stringScanner.nextLine();
            switch (nomePacchetto.toLowerCase()) {
                case "base":
                    prezzoFinale += 0; // nessun aumento per il pacchetto base
                    System.out.println("Hai scelto il pacchetto base. Il prezzo finale è: " + prezzoFinale + " euro.");
                    break;
                case "premium":
                    prezzoFinale += prezzoBase * 0.20; // aumento del 20%
                    System.out
                            .println("Hai scelto il pacchetto premium. Il prezzo finale è: " + prezzoFinale + " euro.");
                    break;
                case "gold":
                    prezzoFinale += prezzoBase * 0.50; // aumento del 50%
                    System.out.println("Hai scelto il pacchetto gold. Il prezzo finale è: " + prezzoFinale + " euro.");
                    break;

                default:
                    System.out.println("Pacchetto assicurativo non riconosciuto. Riprova con base, premium o gold.");
                    break;
            }

            numScanner.close();
            stringScanner.close();

        } else {
            System.out.println(
                    "Non sei idoneo a stipulare l'assicurazione. Devi avere almeno 18 anni e una patente valida.");
        }
    }

}
