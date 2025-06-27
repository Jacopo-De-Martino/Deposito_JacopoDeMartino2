package corsoJavaBackend.Lezione5_27_06_2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioArrayLis {
    public static void main(String[] args) {
        // Inizializzo un ArrayList per contenere i nomi degli studenti
        ArrayList<String> nomiStudenti = new ArrayList<>();

        // Inizializzo lo scanner per poter leggere i dati inseriti dall’utente
        Scanner scanner = new Scanner(System.in);

        // Variabile che conterrà la scelta dell’utente nel menù
        String scelta;

        // Inizio il ciclo do-while per mostrare il menù finché l’utente non digita
        // "fine"
        do {
            // Stampo il menù con le opzioni disponibili per l’utente
            System.out.println("== Menu ==");
            System.out.println("1 - Inserisci studente");
            System.out.println("2 - Rimuovi studente");
            System.out.println("fine - Uscita");

            // Leggo la scelta dell’utente
            scelta = scanner.nextLine();

            // Se l’utente inserisce "fine", esco dal ciclo e termino il programma
            if (scelta.equalsIgnoreCase("fine")) {
                System.out.println("Arrivederci");
                break; // Esce dal ciclo
            }

            // Utilizzo uno switch per gestire le diverse opzioni inserite dall’utente
            switch (scelta) {
                case "1":
                    // Caso 1: l’utente vuole inserire un nuovo studente
                    System.out.print("Nome studente da inserire: ");
                    String nomeInserito = scanner.nextLine(); // Leggo il nome dello studente
                    nomiStudenti.add(nomeInserito); // Aggiungo il nome alla lista
                    System.out.println("Studente aggiunto. Lista: " + nomiStudenti); // Mostro la lista aggiornata
                    break;

                case "2":
                    // Caso 2: l’utente vuole rimuovere uno studente dalla lista
                    System.out.print("Nome studente da rimuovere: ");
                    String nomeRimosso = scanner.nextLine(); // Leggo il nome dello studente da rimuovere

                    // Provo a rimuovere il nome dalla lista; restituisce true se trovato, false
                    // altrimenti
                    if (nomiStudenti.remove(nomeRimosso)) {
                        System.out.println(
                                "Hai rimosso lo studente : " + nomeRimosso + " . Lista aggiornata: " + nomiStudenti); // Conferma
                        // rimozione
                    } else {
                        System.out.println("Studente non trovato."); // Messaggio se lo studente non è presente
                    }
                    break;

                default:
                    // Caso in cui l’utente inserisce un’opzione non valida
                    System.out.println("Scelta non valida.");
            }

        } while (true); // Il ciclo continua finché non viene digitato "fine"

        // Ordino alfabeticamente la lista degli studenti utilizzando Collections.sort()
        Collections.sort(nomiStudenti);

        // Stampo la lista ordinata degli studenti
        System.out.println("Lista studenti ordinata:");
        for (String nome : nomiStudenti) {
            System.out.println(nome); // Stampo ogni nome della lista
        }

        // Stampo il numero totale degli studenti nella lista
        System.out.println("Totale studenti: " + nomiStudenti.size());

        // Chiudo lo scanner per liberare risorse
        scanner.close();
    }
}
