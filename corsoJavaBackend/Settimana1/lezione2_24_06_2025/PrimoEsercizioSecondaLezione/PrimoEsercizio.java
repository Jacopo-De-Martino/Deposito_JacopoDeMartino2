package corsoJavaBackend.Settimana1.lezione2_24_06_2025.PrimoEsercizioSecondaLezione;

import java.util.Scanner;

public class PrimoEsercizio {
    public static void main(String[] args) {
        // Inizializzo 2 oggetti Scanner
        // lo utilizzo per Stringhe , Caratteri e bool.
        Scanner myCharScann = new Scanner(System.in);
        // lo utilizzo per numeri int, double, float.
        Scanner myNumScann = new Scanner(System.in);

        // Serie di metodi dello scanner per assegnare i valori alle variabili
        System.out.println("inserisci una Stringa");
        // ! Metodo x String .nextLine
        String myImputString = myCharScann.nextLine();
        System.out.println("Inserisci un booleano (true || false)");
        // ! Metodo x Boolean .nextBoolean
        boolean myImputBoolean = myCharScann.nextBoolean();
        System.out.println("Inserisci un numero decimale con massimo 14 cifre dopo la virgola");
        // ! Metodo x double .nextDouble()
        double myImputDouble = myNumScann.nextDouble();
        System.out.println("Inserisci un numero decimale con massimo 7 cifre dopo la virgola");
        // ! Metodo x float .nextFloat()
        float myImputFloat = myNumScann.nextFloat();
        System.out.println("Inserisci un numero intero");
        // ! Metodo x int .nextInt()
        int myImputInt = myNumScann.nextInt();
        System.out.println("Inserisci un numero intero (LONG)");
        // ! Metodo x long .nextLong()
        long myImputLong = myNumScann.nextLong();
        System.out.println("Inserisci un numero intero (SHORT)");
        // ! Metodo x short .nextShort
        short myImputShort = myNumScann.nextShort();

        // Stampo i valori degli imput con un piccola descrizione
        System.out.println("Stringa in imput : " + myImputString);
        System.out.println("Boolean in imput : " + myImputBoolean);
        System.out.println("Double in imput : " + myImputDouble);
        System.out.println("Float in imput : " + myImputFloat);
        System.out.println("Int in imput : " + myImputInt);
        System.out.println("Long in imput : " + myImputLong);
        System.out.println("Short in imput : " + myImputShort);

        myNumScann.close();
        myCharScann.close();

        // ! Castiamo il double in int --- ESPLICITO
        int doubleToInt = (int) myImputDouble;
        // ! Castiamo l'int in double --- IMPLICITO
        double intToDouble = myImputInt;

        System.out.println(myImputDouble + " Dopo il casting(esplcito)  = " + doubleToInt);
        System.out.println(myImputInt + " Dopo il casting(implicito) = " + intToDouble);
    }

}
