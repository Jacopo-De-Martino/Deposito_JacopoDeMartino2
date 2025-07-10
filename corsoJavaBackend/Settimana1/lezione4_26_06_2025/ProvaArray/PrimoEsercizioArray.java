package corsoJavaBackend.Settimana1.lezione4_26_06_2025.ProvaArray;

import java.util.Scanner;

// ESERCIZIO PASTICCERIA
public class PrimoEsercizioArray {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        int[] quantita = new int[10];
        String[] nomeDolce = new String[10];

        int numDolciDaOrdinare = 0;
        System.out.println("Inserisci quanti tipi di dolci vuoi ordinare");
        numDolciDaOrdinare = intScanner.nextInt();

        // controllo se il numero inserito è maggiore di 0 e minore o uguale a 10
        // altrimenti lo faccio rinserire
        while (numDolciDaOrdinare <= 0 || numDolciDaOrdinare >= 10) {
            System.out.println(
                    "Inserisci un numero positivo per ordinare i nostri dolci, puoi ordinare massimo 10 dolci");
            numDolciDaOrdinare = intScanner.nextInt();
        }

        // itero finchè i è inferiore ad numDolciDaOrdinare dato in imput da l'utente
        for (int i = 0; i < numDolciDaOrdinare; i++) {
            // faccio inserire il nome dolce e la salvo nell'array a l'indece in chiave i
            System.out.println("Inserisci nome del " + (i + 1) + "° dolce");
            nomeDolce[i] = stringScanner.nextLine();
            // faccio inserire la quantità e la salvo nell'array a l'indece in chiave i
            System.out.println("Inserisci quantità x " + nomeDolce[i]);
            quantita[i] = intScanner.nextInt();
        }

        // Stampo dolci e quantità associate
        System.out.println("Hai ordinato:");
        for (int i = 0; i < numDolciDaOrdinare; i++) {
            System.out.println("Nome dolce : " + nomeDolce[i] + " Quantità :" + quantita[i]);
        }

    }

}
