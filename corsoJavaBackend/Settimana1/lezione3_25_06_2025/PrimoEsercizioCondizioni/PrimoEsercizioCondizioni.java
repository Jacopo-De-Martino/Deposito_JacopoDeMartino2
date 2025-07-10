package corsoJavaBackend.Settimana1.lezione3_25_06_2025.PrimoEsercizioCondizioni;

import java.util.Scanner;

public class PrimoEsercizioCondizioni {
    public static void main(String[] args) {
        // Istanzio 2 oggetti scanner
        // numScanner per numeri
        Scanner numScanner = new Scanner(System.in);
        // stringScanner per stringhe e boolean
        Scanner stringScanner = new Scanner(System.in);
        // dichiaro le variabili necessarie
        int eta;
        String bigliettoValido, accompagnatoAdulto, saltaFila;
        // creo degli autput per aiutere l'utende ad inserire i dati
        System.out.println("Inserici età");
        eta = numScanner.nextInt();
        if (eta <= 0) {
            System.out.println("l'età non puo essere un valore negativo o uguale a 0");
            System.out.println("rinserisci l'età corretta");
            eta = numScanner.nextInt();
        }
        String codiceBigliettoValido = "123abc";
        System.out.println("Inserisci codice biglietto");
        bigliettoValido = stringScanner.nextLine();
        System.out.println("Sei accompagnato da un adulto? si / no");
        accompagnatoAdulto = stringScanner.nextLine();
        System.out.println("Hai il salta fila? si / no");
        saltaFila = stringScanner.nextLine();

        System.out.println(
                "scegli il mezzo che vuoi prendere . Inserisci 1 per il taxi o un qualsiasi numero per il bus");
        int scelta = numScanner.nextInt();

        String mezzo = scelta == 1 ? "taxi" : "bus";

        // verifico se il cliente ha più di 18 anni, ha il biglietto valido e ha
        // l'opzione salta fila
        if (eta > 18 && bigliettoValido.equals(codiceBigliettoValido) && saltaFila.equalsIgnoreCase("si")) {
            System.out.println("Puoi prendere il " + mezzo + " senza fare la fila ");
            // verifico se il cliente ha più di 18 anni, ha il biglietto valido
        } else if (eta > 18 && bigliettoValido.equalsIgnoreCase(codiceBigliettoValido)
                && saltaFila.equalsIgnoreCase("no")) {
            System.out.println("Puoi prendere il " + mezzo + "  ma devi fare la fila ");
            // verifico se il cliente ha meno di 18 anni, ha il biglietto valido è
            // accompagnato da un adulto e ha il saltafila
        } else if (eta < 18 && bigliettoValido.equalsIgnoreCase(codiceBigliettoValido)
                && accompagnatoAdulto.equalsIgnoreCase("si") && saltaFila.equalsIgnoreCase("si")) {
            System.out.println("puoi prendere il " + mezzo + " senza fare la fila");
            // verifico se il cliente ha meno di 18 anni è accompagnato da un adulto
        } else if (eta < 18 && bigliettoValido.equalsIgnoreCase(codiceBigliettoValido)
                && accompagnatoAdulto.equalsIgnoreCase("si") && saltaFila.equalsIgnoreCase("no")) {
            System.out.println("puoi puoi prendere il " + mezzo + " ma devi fare la fila");
            // verifico se il cliente ha meno di 18 anni non è accompagnato da un adulto
        } else if (eta < 18 && bigliettoValido.equalsIgnoreCase(codiceBigliettoValido)
                && accompagnatoAdulto.equalsIgnoreCase("no")) {
            System.out.println("non puoi prendere il " + mezzo + " devi essere accompagnato da un adulto");
        } else {
            System.out.println("Problemi nella compilazione dei dati");
        }

        numScanner.close();
        stringScanner.close();

        // ! CORREZIONE MIRKO
        // Scanner input = new Scanner(System.in);

        // Richiesta dei dati all'utente
        // System.out.print("Inserisci la tua età: ");
        // int eta = input.nextInt();

        // System.out.print("Hai un biglietto valido? (true/false): ");
        // boolean bigliettoValido = input.nextBoolean();

        // System.out.print("Sei accompagnato da un adulto? (true/false): ");
        // boolean accompagnato = input.nextBoolean();

        // System.out.print("Hai l'opzione 'Salta la fila'? (true/false): ");
        // boolean saltaFila = input.nextBoolean();

        // // Verifica delle condizioni di accesso
        // boolean accessoConsentito = (eta >= 14 && bigliettoValido) || (eta < 14 &&
        // accompagnato && bigliettoValido);

        // if (accessoConsentito) {
        // if (saltaFila) {
        // System.out.println("Accesso consentito con priorità");
        // } else {
        // System.out.println("Accesso consentito");
        // }
        // } else {
        // System.out.println("Accesso negato");
        // }

        // input.close();

    }
}
