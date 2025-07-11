package corsoJavaBackend.Lezione14_09_2025.EserciziFactoryMethod.EsercizioFactoryMehodMedio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DisegnatoreFacciata facciata = new DisegnatoreFacciata();
        Scanner scanner = new Scanner(System.in);
        boolean menuAttivo = true;

        System.out.println("Benvenuto nel Disegnatore di Forme!");
        System.out.println("Scegli un'opzione: ");
        System.out.println("'cerchio semplice'");
        System.out.println("'cerchio rosso'");
        System.out.println("'quadrato semplice'");
        System.out.println("'cerchio blu'");
        System.out.println("'tutte' (Disegna tutte le forme)");
        System.out.println("'esci' (Esci)");

        while (menuAttivo) {
            System.out.print("\nLa tua scelta: ");
            String scelta = scanner.nextLine().toLowerCase().trim();

            switch (scelta.toLowerCase()) {
                case "cerchio semplice":
                    facciata.disegnaCerchioSemplice();
                    break;
                case "cerchio rosso":
                    facciata.disegnaCerchioRosso();
                    break;
                case "quadrato semplice":
                    facciata.disegnaQuadratoSemplice();
                    break;
                case "quadrato blu":
                    facciata.disegnaQuadratoBlu();
                    break;
                case "tutte":
                    facciata.disegnaTutteLeForme();
                    break;
                case "esci":
                    System.out.println("Grazie per aver disegnato. Arrivederci!");
                    menuAttivo = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
        scanner.close();
    }
}