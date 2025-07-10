package corsoJavaBackend.Settimana1.lezione3_25_06_2025.EsempiCondizioniSwitch;

public class EsempiSwitch {
    public static void main(String[] args) {
        // faccio alcuni esempi utilizzando il blocco condizionale switch
        // il blocco switch è un'alternativa al blocco if-else if-
        // che permette di verificare il valore di una variabile
        // e di eseguire un blocco di codice specifico in base al valore della variabile
        // o dell'espressione
        // il blocco switch è utile quando si ha un numero limitato di casi da gestire
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Numero del giorno non valido, inserisci un numero da 1 a 7");
                break;
        }
    }
}
