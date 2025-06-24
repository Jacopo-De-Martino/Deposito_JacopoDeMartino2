package ProvaVariabili;

public class ProvaVariabili {
    // Nome , Tipo , Valore
    // = operatore di assegnazzione
    // Metodo main
    public static void main(String[] args) {
        // dichiarazione e assegnazione variabili
        int numeroIntero = 169;
        String provaString = "Testo di prova";
        boolean provaBoolean = true; // false

        // solo dichiarazione, assegnazione successiva alla dichiarazione.
        boolean dichiarazioneBoolean;
        dichiarazioneBoolean = true;
        dichiarazioneBoolean = false;

        // le costanti in JAVA utilizzo della keyword final
        // questa è una variabile intera COSTANTE!
        final int NUMERO_COSTANTE = 120;
        // NUMERO_COSTANTE = 100; errore

        // dichiarazione String costante senza assegnazione
        final String CIAO;
        CIAO = " HELLO ";
        System.out.println(CIAO);
        System.out.println(NUMERO_COSTANTE);

        // Stampa String e concatenazione di Stringhe
        String testo = "Prova";
        System.out.println(testo);

        testo = "Mondo";
        System.out.println("Ciao " + testo);

        // salvo una stringa concatenata(composta dalla concatenazione di 2 variabili di
        // tipo String "firstPart,lastPart") in una variabile concatString e la stampo
        String firstPart = "Ciao ";
        String lastPart = "Mondo";
        String concatString = firstPart + lastPart;
        System.out.println(concatString);

        // dichiaro 3 variabili dello stesso tipo utilizzando un elenco separato da
        // virgola
        int x = 5, y = 6, z = 10;
        System.out.println(x + " " + y + " " + z);
        // asseno lo stesso valore a 3 variabili dello stesso tipo ( UTILIZZO LE STESSE
        // VARIABILI DI PRIMA "x","y","z")
        x = y = z = 50;
        System.out.println(x + " " + y + " " + z);

        // ! SLIDE NOMINATIVI VARIBILI camelCase , denominazione parlante
        // * nota le variabili sono case sensitive
        // * corretto!
        String parole = " Sono una serie di parole";
        // * sbagliato
        String Oa = "Sono una stringa dichiarata in modo poco coerente";

        // Esempio tipo char
        char myChar1 = 'A', myChar2 = 'B', myChar3 = 'C';
        System.out.println(myChar1 + " " + myChar2 + " " + myChar3);

    }
}
