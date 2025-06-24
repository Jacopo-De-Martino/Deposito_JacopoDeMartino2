package ProvaString;

public class ProvaString {
    public static void main(String[] args) {
        // ! Variabile type String con la quale lavoreremo con i metodi
        // ! della classe String.
        String provaStringa = "Sei bella vera";

        // ! Salvo la lunghezza della Stringa provaStringa in una variabile di tipo
        // ! lunghezzaString utilizzando il metodo .length() nativo delle stringhe che
        // ! restituisce un numero intero che corrisponde alla lunghezza della stringa
        int lunghezzaString = provaStringa.length();
        System.out.println("La lunghezza della Stringa provaStringa :" + provaStringa + " è " + lunghezzaString);

        // ! Utilizziamo le fuzioni toUpperCase() e toLowerCase().

        System.out.println(
                "Strampo la mia Stringa dopo aver richiamato il metodo toUpperCase " + provaStringa.toUpperCase());

        System.out.println(
                "Strampo la mia Stringa dopo aver richiamato il metodo toLoweCase " + provaStringa.toLowerCase());

        // ! Utilizziamo la funzione indexOf(String) restituisce un intero che
        // ! rappresenta la posizione del primo char della String/char passata/o come
        // ! parametro è 0 based;

        System.out.println(
                "La prima lette 'b' della substring bella si trova in indice : " + provaStringa.indexOf("bella"));

        // ! Utilizziamo la funzione concat(String) restituisce una String che
        // ! rappresenta la concatenazione di due Stringhe.
        String firstPart = "Ciao ";
        String secondPart = "a tutti";
        // utilizzo il metodo delle Stringhe concat();
        String fullString = firstPart.concat(secondPart);
        System.out.println("Stampa della Stringa utilizzando il metodo concat, new String : " + fullString);
        // utilizzo l'operatore di concatenzaione +
        System.out
                .println("Stampa della Stringa utilizzando l'operatore di concatenazione : " + firstPart + secondPart);

        // ! Esempi ed errori operatore di concatenazione + (valido solo per le String)
        int x = 10, y = 20, z = x + y; // z = 30
        String numString1 = "10";
        String numString2 = "20";
        String cocnat = numString1 + numString2; // 1020

        // Gestione caratteri speciali("", '' , \) tramite barra rovesciata
        String txt = "We are the so-called \"Vikings\" from the north. ";
        System.out.println(txt);

        // ! Prova utilizzo il metodo .leght()
        String descrizione = "Articolo sulle stringhe ...";
        String vuota = "";
        int leght = descrizione.length(); // 27
        // leght = vuota.length(); // 0
        System.out.println("Lunghezza : " + leght);

    }

}
