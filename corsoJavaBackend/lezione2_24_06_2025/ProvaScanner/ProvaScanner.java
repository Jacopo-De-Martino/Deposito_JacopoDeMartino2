package ProvaScanner;

import java.util.Scanner;

// Classe per provare l'ogetto Scanner fornito da java utils e i suo metodi
public class ProvaScanner {
    public static void main(String[] args) {
        // ! Inizializzo la classe Scanner
        Scanner scanner = new Scanner(System.in); // Create Scanner Object
        System.out.println("Inserisci il tuo nome");
        // utilizzo il metodo dell'oggetto scanner nextLine() per passsare una stringa
        // in imput e salvarla nella variabile nome
        String nome = scanner.nextLine();
        System.out.println("piacere di conoscerti " + nome);
        scanner.close();
    }

}
