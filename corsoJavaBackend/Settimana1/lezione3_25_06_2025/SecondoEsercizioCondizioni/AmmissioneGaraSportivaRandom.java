package corsoJavaBackend.Settimana1.lezione3_25_06_2025.SecondoEsercizioCondizioni;

import java.util.Scanner;

public class AmmissioneGaraSportivaRandom {
    public static void main(String[] args) {

        // importazione della classe Scanner per l'input da tastiera
        Scanner numScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        // dichiarazione delle variabili necessarie per svolgere l'esercizio
        int etaPartecipante;
        float peso, altezza, migliorTempo100Metri, bmi, limiteBmi = 25.0f, limiteTempoCentoMetri = 12.0f;

        System.out.println("Benvenuto alla gara sportiva!");
        System.out.println("inserisci il tuo nome:");
        String nomePartecipante = stringScanner.nextLine();
        System.out.println("inserisci il tuo cognome:");
        String cognomePartecipante = stringScanner.nextLine();

        // acquisizione dell'età del randomizzata con math.random()
        etaPartecipante = (int) (Math.random() * 80) + 1; // età tra 1 e 80 anni;

        // acquisizione del peso del partecipante randomizzato con math.random()
        peso = (float) (Math.random() * 100) + 40; // peso tra 40 e 140 kg;

        // acquisizione dell'altezza del partecipante randomizzato con math.random()
        altezza = (float) (Math.random() * 70) + 130; // altezza tra 130 e 200 cm;
        // acquisizione del miglior tempo sui 100 metri del partecipante
        migliorTempo100Metri = (float) (Math.random() * 15) + 8; // tempo tra 8 e 23 secondi;

        // calcolo del BMI (Body Mass Index)
        bmi = (float) (peso / Math.pow(altezza, 2));

        // stampa dei dati del partecipante
        System.out.println("\n===Dati del partecipante:===\n");
        System.out.println("Nome: " + nomePartecipante);
        System.out.println("Cognome: " + cognomePartecipante);
        System.out.println("Età: " + etaPartecipante + " anni");
        System.out.printf("Peso: %.2f kg  \n", peso);
        System.out.printf("Altezza: %.2f cm \n", altezza);
        System.out.printf("Miglior tempo sui 100 metri: %.2f secondi \n", migliorTempo100Metri);
        System.out.printf("BMI: %.2f ", bmi);

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
            System.out.println("Il tuo BMI è: " + bmi);
            System.out.println("Il tuo miglior tempo sui 100 metri è: " + migliorTempo100Metri + " secondi.");
            System.out.println("In bocca al lupo per la gara!");

        }

        // chiusura degli scanner per evitare perdite di memoria
        numScanner.close();
        stringScanner.close();

    }

}
