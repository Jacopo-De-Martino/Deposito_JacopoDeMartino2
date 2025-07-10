package corsoJavaBackend.Settimana2.Lezione8_02_2027.GestioneException.EsempiTryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDivisione2 {

    // Classe chiamante
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserisci un numero");
            int numero = scanner.nextInt();
            int risultato = EsempioDivisioneThrow.divisioneChecked(numero, 0);
            System.out.println(risultato);
        } catch (InputMismatchException | ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Errore input");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore generico");
        }
        System.out.println("fine programma");
    }
}
