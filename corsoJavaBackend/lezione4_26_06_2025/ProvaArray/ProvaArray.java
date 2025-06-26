package corsoJavaBackend.lezione4_26_06_2025.ProvaArray;

import java.util.Arrays;

public class ProvaArray {
    public static void main(String[] args) {
        int[] numeri = new int[5];// Array di dimensione 5
        int[] valori = { 1, 2, 3, 4, 5 };
        // numeri = valori;

        // Esempio stampa un elemento + assegnazione
        numeri[0] = 10;
        numeri[1] = 20;
        numeri[2] = 30;
        numeri[3] = 40;
        System.out.println("Stampo l'elemento in indice 0 : " + numeri[0]);
        // stampa Array completo
        System.out.println(Arrays.toString(numeri));

        // Creo un altro array con valori da 1 a 5 usando un ciclo
        int[] numeriDa1A5 = new int[5];
        // riempio l'array con i valori da 1 a 5
        for (int i = 0; i < numeriDa1A5.length; i++) {
            numeriDa1A5[i] = i + 1;
        }

        // Stampo tutti gli elementi di numeriDa1A5
        System.out.print("Valori dell'array numeriDa1A5: ");
        for (int i = 0; i < numeriDa1A5.length; i++) {
            System.out.print(numeriDa1A5[i] + " ");
        }

        // Prova Matrice
        int[][] matrice = new int[3][3];
        int[][] matricePredefinita = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // Stampa un elemento della matrice
        System.out.println("\nElemento centrale " + matricePredefinita[1][1]);
        // stampa matrice
        System.out.println("\n====MATRICE====");
        for (int i = 0; i < matricePredefinita.length; i++) {
            for (int j = 0; j < matricePredefinita[i].length; j++) {
                System.out.print(matricePredefinita[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

}
