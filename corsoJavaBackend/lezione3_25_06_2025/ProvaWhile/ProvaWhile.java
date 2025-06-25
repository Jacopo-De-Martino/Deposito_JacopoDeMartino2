package ProvaWhile;

import java.util.Scanner;

public class ProvaWhile {
    public static void main(String[] args) {
        // Inizializzazione della variabile di controllo
        int i = 0;
        // Ciclo while che continua finché i è minore o uguale a 5
        while (i < 5) {
            i++;
            // blocco di codice da eseguire ad ogni iterazione
            System.out.println("Valore i: " + i);
        }

        Scanner input = new Scanner(System.in);
        int numero;
        do {
            System.out.println("Inserisci un numero (0 per terminare): ");
            numero = input.nextInt();
            if (numero != 0) {
                System.out.println("Hai inserito: " + numero);
            }
        } while (numero != 0);
        System.out.println("Hai inserito 0, il programma termina.");

    }
}
