
import java.util.Scanner;

// Classe annidata
class UtilitaMatematica {
    int quadrato(int num) {
        return num * num;
    }

    int cubo(int num) {
        return num * num * num;
    }
}

public class ApprofondimentoMetodi {

    // test metodo ricorsivo calcolo fattoriale
    static int fattoriale(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fattoriale(n - 1);
    }

    static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Scrivi un'opzione (scrivi 'fine' per uscire): ");
        String scelta = scanner.nextLine();

        if (scelta.equalsIgnoreCase("fine")) {
            System.out.println("Grazie per aver testato i metodi ricorsivi.");
            return; // 🔚 esce dalla ricorsione
        }

        System.out.println("Hai scelto: " + scelta);
        // Puoi aggiungere azioni diverse in base alla scelta

        menu(); // chiamata ricorsiva con nuovo input
    }

    // Passaggio per riferimento
    static void modificaRif(int[] arr) {

        arr[0] = 99; // Questa modifica sarà visibile all'esterno

    }

    // Passaggio per valore
    static void modificaVal(int x) {

        x = x + 10; // Questa modifica non sarà visibile all'esterno

    }

    public static void main(String[] args) {
        // richiamo il metodo passando un parametro e lo stampo
        System.out.println(fattoriale(5));

        menu();

        // Test passaggio per riferimento:
        int[] numeri = { 1, 2, 3 };

        modificaRif(numeri);

        System.out.println(numeri[0]); // Output: 99
        int num = 5;

        modificaVal(num);// 5

        System.out.println(num); // Output: 5

        // creo un oggetto di tipo UtilitàMatematica
        UtilitaMatematica utilsMathObj = new UtilitaMatematica();
        // Stamo i risultati dei metodi della classe utilitàMatematica passando come
        // parametri reali 6 e 6
        System.out.println(utilsMathObj.quadrato(6));// 36
        System.out.println(utilsMathObj.cubo(6));// 216

    }
}
