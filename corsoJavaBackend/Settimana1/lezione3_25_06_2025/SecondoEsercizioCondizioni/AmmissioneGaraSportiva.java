package corsoJavaBackend.Settimana1.lezione3_25_06_2025.SecondoEsercizioCondizioni;

import java.util.Scanner;

public class AmmissioneGaraSportiva {
    public static void main(String[] args) {
        // importazione della classe Scanner per l'input da tastiera
        Scanner numScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        // dichiarazione delle variabili necessarie per svolgere l'esercizio
        int etaPartecipante;
        float peso, altezza, migliorTempo100Metri, bmi, limiteBmi = 25.0f, limiteTempoCentoMetri = 12.0f;

        System.out.println("Benvenuto alla gara sportiva!");
        System.out.println("inserisci la tua età:");
        // acquisizione dell'età del partecipante
        etaPartecipante = numScanner.nextInt();

        if (etaPartecipante <= 0) {
            System.out.println("Età non valida. Per favore, inserisci un'età positiva.");
            System.out.println("Rinserisci la tua età:");
            etaPartecipante = numScanner.nextInt();
        }
        System.out.println("inserisci il tuo peso in kg:");
        // acquisizione del peso del partecipante
        peso = numScanner.nextFloat();
        System.out.println("inserisci la tua altezza in cm:");
        // acquisizione dell'altezza del partecipante
        altezza = numScanner.nextFloat();
        System.out.println("inserisci il tuo miglior tempo sui 100 metri in secondi:");
        // acquisizione del miglior tempo sui 100 metri del partecipante
        migliorTempo100Metri = numScanner.nextFloat();

        // calcolo del BMI (Body Mass Index)
        bmi = (float) (peso / Math.pow(altezza, 2));
        // inizializzazione della variabile booleana per verificare l'ammissibilità
        // alla gara sportiva
        boolean ammissibile = false;
        // verifica delle condizioni per l'ammissione alla gara sportiva
        if (etaPartecipante >= 18 && etaPartecipante <= 40
                && Math.min(migliorTempo100Metri, limiteTempoCentoMetri) == migliorTempo100Metri && bmi <= limiteBmi) {
            ammissibile = true;
        }

        // stampa del risultato dell'ammissione alla gara sportiva
        if (!ammissibile) {
            System.out.println("Spiacente, non sei ammesso alla gara sportiva.");
            if (etaPartecipante < 18) {
                System.out.println("Motivo: Età inferiore a 18 anni.");
            } else if (etaPartecipante > 40) {
                System.out.println("Motivo: Età superiore a 40 anni.");
            }
            if (migliorTempo100Metri > limiteTempoCentoMetri) {
                System.out.println("Motivo: Tempo sui 100 metri superiore a " + limiteTempoCentoMetri + " secondi.");
            }
            if (bmi > limiteBmi) {
                System.out.println("Motivo: BMI superiore a " + limiteBmi + ".");
            }
            System.out.println("Riprova a partecipare in futuro!");
        }

        // se il partecipante è ammesso, stampa un messaggio di congratulazioni
        // e termina il programma
        if (ammissibile) {
            System.out.println("Congratulazioni! Sei ammesso alla gara sportiva.");
            System.out.println("Età: " + etaPartecipante + " anni");
            System.out.printf("Peso: %.2f kg  \n", peso);
            System.out.printf("Altezza: %.2f cm \n", altezza);
            System.out.printf("Miglior tempo sui 100 metri: %.2f secondi \n", migliorTempo100Metri);
            System.out.printf("BMI: %.2f ", bmi);
        }

        // chiusura degli scanner per evitare perdite di memoria
        numScanner.close();
        stringScanner.close();

    }
}
