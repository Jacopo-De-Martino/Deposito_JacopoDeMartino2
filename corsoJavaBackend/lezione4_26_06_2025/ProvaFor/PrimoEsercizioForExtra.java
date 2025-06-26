package corsoJavaBackend.lezione4_26_06_2025.ProvaFor;

import java.util.Scanner;

public class PrimoEsercizioForExtra {
    public static void main(String[] args) {
        // inizializzo un oggetto scanner per leggere gli imput dell'utente
        Scanner scanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        // inserisci il numero di studenti a cui vuoi assegnare i voti
        System.out.println("inserisci il numero di studenti a cui vuoi assegnare i voti");
        int numeroStudenti = scanner.nextInt();

        for (int i = 1; i <= numeroStudenti; i++) {
            System.out.println("Inserisci il nome del " + i + "° Studente");
            String nomeStudente = stringScanner.nextLine();
            int sommaVoti = 0;
            int media;
            // chiedo a l'utente quanti voti vuole inserire
            System.out.println("Quanti voti vuoi inserire?");
            int numeroVotiDaInserire = scanner.nextInt();
            // controllo che il numero di voti sia maggiore di 0
            // se il numero di voti è minore o uguale a 0, richiedo nuovamente il numero di
            // voti
            while (numeroVotiDaInserire <= 0) {
                System.out.println("Il numero di voti deve essere maggiore di 0. Riprova:");
                numeroVotiDaInserire = scanner.nextInt();
            }
            // Ciclo for per l'assegnazione dei voti
            for (int j = 1; j <= numeroVotiDaInserire; j++) {
                // inserimento voto tramite scanner
                System.out.println(" Inserisci il " + i + "° voto x studente " + nomeStudente);
                int voto = scanner.nextInt();
                // variabile booleana per la validazione
                boolean nonValido = voto < 0 || voto > 30;
                // controllo inserimento voto non valido
                if (nonValido) {
                    while (nonValido) {
                        System.out.println(voto + " Non valido, inserisci un voto valido range (0/30)");
                        voto = scanner.nextInt();
                        if (voto >= 0 && voto <= 30) {
                            nonValido = false;
                        }
                    }
                }
                // variabili "condizionali"
                boolean sufficente = voto >= 18 && voto < 24;
                boolean ottimo = voto >= 24;
                boolean insufficente = voto < 18;
                // blocco condizionale che stampa il voto e
                if (sufficente) {
                    System.out.println(voto + " = Sufficente");
                } else if (ottimo) {
                    System.out.println(voto + " = Ottimo");
                } else if (insufficente) {
                    System.out.println(voto + " = Insufficente");
                }

                sommaVoti += voto;
            }
            media = sommaVoti / numeroVotiDaInserire;
            System.out.println("La media dei voti di " + nomeStudente + " è uguale a " + media);
        }

    }

}
