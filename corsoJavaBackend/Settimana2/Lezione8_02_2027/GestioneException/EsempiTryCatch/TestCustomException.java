package corsoJavaBackend.Settimana2.Lezione8_02_2027.GestioneException.EsempiTryCatch;

import java.util.Scanner;

public class TestCustomException {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserisci una Stringa");
            String nome = scanner.nextLine();
            StringValidator.check(nome);
            System.out.println("Check supertato " + nome);
        } catch (TooShortStringException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore generico");
        }
        System.out.println("fine programma");
    }
}