package corsoJavaBackend.Settimana1.lezione4_26_06_2025.ProvaFor;

import java.util.Scanner;

public class ProvaFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // instanza classe Scanner
        // richiedo un numero all'utente
        System.out.println("Inserisci un numero per visualizzare la sua tabellina:");
        int numero = scanner.nextInt();
        // stampo la tabellina del numero inserito
        System.out.println("Tabellina del " + numero + ":");
        // ciclo for per stampare la tabellina
        for (int i = 1; i <= 10; i++) {
            // stampo il risultato
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        scanner.close(); // chiudo lo scanner per evitare perdite di risorse

    }

}
