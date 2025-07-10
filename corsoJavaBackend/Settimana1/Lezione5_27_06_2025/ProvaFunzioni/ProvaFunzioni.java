package corsoJavaBackend.Settimana1.Lezione5_27_06_2025.ProvaFunzioni;

public class ProvaFunzioni {
    public static void main(String[] args) {
        // richiamo il metodo saluta
        saluta();
        // richiamo il metodo somma() passando valori reali
        System.out.println(somma(3, 6));
        // richiamo il metodo somma() Overlodato
        System.out.println(somma(3.99, 10.29));
        // richiamo il metodo mostra passando una stringa /
        mostra("ciao");
        // richiamo il metodo mostra passando un intero / Overloading
        mostra(99);
    }

    // metodo statico della classe ProvaFunzioni nome saluta()
    // metodo senza parametri
    static void saluta() {
        System.out.println("Ciao , Java");
    }

    // metodo statico della classe ProvaFunzioni nome somma()
    // metodo con parametri
    static int somma(int a, int b) {
        return a + b;
    }

    // Overload del metodo somma, cambio firma ritorna un double e accetta due
    // double
    static double somma(double a, double b) {
        return (double) a + b;
    }

    static void mostra(String s) {
        System.out.println(s);
    }

    static void mostra(int n) {
        System.out.println(n);
    }
}