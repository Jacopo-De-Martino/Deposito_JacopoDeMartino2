package ProvaMath;

public class ProvaMath {
    public static void main(String[] args) {
        // Esempi utilizzo MATH
        int a = 9;
        int b = 16;
        int c = -22;

        // Calcolo della radice quadrata
        double radiceA = Math.sqrt(a);
        double radiceB = Math.sqrt(b);

        // Calcolo del massimo tra due numeri
        int massimo = Math.max(a, b);
        // Calcolo del minimo tra due numeri
        int minimo = Math.min(a, b);
        // Calcolo del valore assoluto (non necessario in questo caso, ma incluso per
        // completezza)
        int valoreAssolutoA = Math.abs(c);

        // Elevamento a potenza (a^2)
        double potenza = Math.pow(a, 2);

        // Generazione di un numero casuale tra 1 e 10
        int casuale = (int) (Math.random() * 10) + 1;

        System.out.println("Radice quadrata di " + a + ": " + radiceA);
        System.out.println("Radice quadrata di " + b + ": " + radiceB);
        System.out.println("Il massimo tra " + a + " e " + b + ": " + massimo);
        System.out.println("Il minimo tra " + a + " e " + b + ": " + minimo);
        System.out.println("Valore assoluto di " + c + ": " + valoreAssolutoA);
        System.out.println(a + " elevato alla seconda: " + potenza);
        System.out.println("Numero casuale: " + casuale);
    }
}
