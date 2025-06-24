package BubbleSortExample;

import java.util.Arrays;

public class BubbleSortExample {

    // Esempio semplice di ordinamento Bubble Sort

    public static int[] bubbleSort(int[] mioArray) {

        int temp = 0; // elemento temporaneo per lo scambio
        int contatore = 0; // contatore per il numero di passi

        // Ciclo esterno: si ripete per ogni elemento dell'array
        for (int i = 0; i < mioArray.length; i++) {
            contatore = i + 1;
            // Ciclo interno: confronto e scambio tra coppie adiacenti
            for (int j = 1; j < (mioArray.length - i); j++) {
                // Se l'elemento precedente è maggiore, scambiali
                if (mioArray[j - 1] > mioArray[j]) {
                    temp = mioArray[j - 1];
                    mioArray[j - 1] = mioArray[j];
                    mioArray[j] = temp;
                }
            }
        }
        System.out.println("Numero di passi, non ottimizzato = " + contatore);
        return mioArray;
    }

    // Versione ottimizzata dell'ordinamento Bubble Sort

    static int[] bubbleSortOttimizzato(int mioArray[]) {
        int temp;
        boolean scambiato;
        int contatore = 0; // contatore per il numero di passi

        // Ciclo esterno
        for (int i = 0; i < mioArray.length - 1; i++) {
            contatore = i + 1;
            scambiato = false; // indica se è avvenuto uno scambio

            // Ciclo interno
            for (int j = 0; j < mioArray.length - i - 1; j++) {
                if (mioArray[j] > mioArray[j + 1]) {
                    // Scambia gli elementi se non sono in ordine
                    temp = mioArray[j];
                    mioArray[j] = mioArray[j + 1];
                    mioArray[j + 1] = temp;
                    scambiato = true;
                }
            }

            // Se nessun elemento è stato scambiato, l'array è già ordinato
            if (!scambiato) {
                break;
            }
        }
        System.out.println("Numero di passi, ottimizzato = " + contatore);
        return mioArray;
    }

    public static void main(String[] args) {
        int arr[] = { 8, 7, 1, 2, 5 };
        int arr1[] = { 8, 7, 1, 2, 5 };

        System.out.println("Array arr prima del Bubble Sort:");
        // Usiamo il metodo toString di java.util.Arrays per stampare l'array
        System.out.println(Arrays.toString(arr));

        System.out.println("Array arr dopo il Bubble Sort:");
        System.out.println(Arrays.toString(bubbleSort(arr)));

        System.out.println("Array arr1 prima del Bubble Sort ottimizzato:");
        System.out.println(Arrays.toString(arr1));

        System.out.println("Array arr1 dopo il Bubble Sort ottimizzato:");
        System.out.println(Arrays.toString(bubbleSortOttimizzato(arr1)));
    }
}
