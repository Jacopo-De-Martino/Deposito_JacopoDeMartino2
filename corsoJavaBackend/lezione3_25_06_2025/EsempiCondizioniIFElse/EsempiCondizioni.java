package EsempiCondizioniIFElse;

public class EsempiCondizioni {
    public static void main(String[] args) {
        // faccio alcuni esempi utilizzando gli operatori di confronto o condizionali
        // ricordiamoci che il risultato di queste operazioni ritornano SEMPRE un tipo
        // di dato BOOLEANO
        // true o false

        // ! ES
        int maggiore = 10;
        int minore = 8;
        // utilizzo operatore maggioranza
        System.out.println(maggiore > minore);// true
        // utilizzo operatore ugualianza
        System.out.println(maggiore == minore);// false
        // utilizzo operatore disugualianza
        System.out.println(maggiore != minore);// true

        if (maggiore > minore) {
            System.out.println(maggiore + " è maggiore di " + minore);
        } else {
            System.out.println(maggiore + " è minore di " + minore);
        }

        int eta = 25;
        int etaPerVotare = 18;
        boolean puoVotare = eta > etaPerVotare; // true

        if (puoVotare) {
            System.out.println("Puoi votare");
        } else {
            System.out.println("Non puoi votare");
        }

        // vediamo il "primo" blocco condizionale if
        // ! Es.
        if (20 < 18) {// sempre false il blocco di codice interno a l'if non verrà mai eseguito
            System.out.println("20 è maggiore di 18");
        }

        int x = 20;
        int y = 18;
        if (x > y) {// true
            System.out.println("x è maggiore di y");
        }

        // vediamo il "secondo" blocco condizionale if-else
        // ! Es.
        int time = 20;
        if (time < 18) {
            System.out.println("buon giorno");
        } else {
            System.out.println("buon pomeriggio");
        }

        // vediamo il "terzo" blocco condizionale if-else if-else
        // ! Es.
        // controllo se time è minore di 10
        if (time < 10) {
            // time < 10 = true ---> stampa good morning
            System.out.println("good morning");
            // successivamente se non entro nel primo if controllo se time < 18
        } else if (time < 18) {
            // time < 18 = true --> good day
            System.out.println("good day");
            // altrimenti
        } else {
            // stampa good evening
            System.out.println("good evenign");
        }

        // Vediamo l'operatore ternario, è un blocco condizionale applicabile quando ci
        // sono solo 2 possibilità o true o false
        // sintassi String result = (time<18) ? "Good day." : "Good evening." ;
        // -------------condizione----- //true--------- //false
        String result = (time < 18) ? "Good day." : "Good evening."; // essendo time 20 la condizione è falsa e la
                                                                     // variabile result verrà inizializzata con "Good
                                                                     // evening"
        System.out.println(result);

    }
}
