package corsoJavaBackend.lezione4_26_06_2025.ProvaArray;

import java.util.Scanner;

public class PrimoEsercizioArrayPasticceriaExtra {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        int[] quantita = new int[10];
        String[] nomeDolce = new String[10];
        double costiGiornalieri = Math.random() * 200 + 100;
        double denaro = Math.random() * 100 + 20; // da 20 a 120
        double denaroCliente = Math.random() * 70 + 20; // range da 20 a 90
        double denaroIniziale = denaroCliente;
        double costoTot = 0;

        System.out.printf("denaro pasticceri: %.2f%n", denaro);
        System.out.printf("costi giornalieri: %.2f%n", costiGiornalieri);
        System.out.printf("denaro cliente: %.2f%n", denaroCliente);

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
            System.out.println("Inserisci nome del " + (i + 1)
                    + "° dolce \ndolci disponibili :\n1) \"Torta\" 12 euro\n2) \"Cornetto\" 2 euro\n3) \"Crostata\" 5 euro\n4) \"Millefoglie\" 12 euro");
            nomeDolce[i] = stringScanner.nextLine().toLowerCase(); // normalizzo subito

            // faccio inserire la quantità e la salvo nell'array a l'indece in chiave i
            System.out.println("Inserisci quantità x " + nomeDolce[i]);
            quantita[i] = intScanner.nextInt();

            double prezzoUnitario = 0;
            // utilizzo uno switch per il calcolo del prezzo unitario
            switch (nomeDolce[i]) {
                case "millefoglie":
                case "torta":
                    prezzoUnitario = 12;
                    break;
                case "cornetto":
                    prezzoUnitario = 2;
                    break;
                case "crostata":
                    prezzoUnitario = 5;
                    break;
                default:
                    System.out.println("dolce non disponibile");
                    quantita[i] = 0; // azzero quantità per non stamparlo dopo
                    nomeDolce[i] = "non valido";
                    continue;
            }
            // calcolo la spesa e eseguo le operazione di assegnazione per denaro
            // pasticceria, denaro cliente e costoTot
            double spesa = prezzoUnitario * quantita[i];
            denaro += spesa;
            denaroCliente -= spesa;
            costoTot += spesa;

            if (denaroCliente <= 0) {
                System.out.printf("Denaro insufficiente! Chiusura programma. Costo totale parziale: %.2f%n", costoTot);
                return;
            } else {
                System.out.printf("Ordine effettuato con successo. Costo totale parziale: %.2f%n", costoTot);
            }

        }

    }
}