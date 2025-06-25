package ProvaMath;
public class ProvaMath {
public static void main(String[] args) {
        // Esempio di utilizzo di Math
        double numero = 9.0;
        double radiceQuadrata = Math.sqrt(numero);
        System.out.println("La radice quadrata di " + numero + " è: " + radiceQuadrata);

        double base = 2.0;
        double esponente = 3.0;
        double potenza = Math.pow(base, esponente);
        System.out.println(base + " elevato a " + esponente + " è: " + potenza);

        double valoreAssoluto = Math.abs(-5.5);
        System.out.println("Il valore assoluto di -5.5 è: " + valoreAssoluto);
    }
}
