package corsoJavaBackend.lezione4_26_06_2025.ProvaFor;

import java.util.Scanner;

public class PrimoEsercizioFor {
    public static void main(String[] args) {
        // inizializzo un oggetto scanner per leggere gli imput dell'utente
        Scanner scanner = new Scanner(System.in);
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
        for()


    }
}
