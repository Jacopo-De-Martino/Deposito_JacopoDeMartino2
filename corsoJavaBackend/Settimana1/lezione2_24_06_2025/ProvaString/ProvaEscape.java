package corsoJavaBackend.Settimana1.lezione2_24_06_2025.ProvaString;

public class ProvaEscape {

    public static void main(String[] args) {
        // \n: Line Feed (a capo). Va a capo, come premere "Invio" su una nuova riga.
        System.out.println("1. Line feed (\\n):");
        System.out.println("Hello\nWorld"); // Stampa "Hello", poi va a capo e stampa "World"

        // \r: Carriage Return. Riporta il cursore all'inizio della riga corrente.
        // Su molti terminali, sovrascrive la parte precedente della riga.
        System.out.println("\n2. Carriage return (\\r):");
        System.out.println("Hello\rWorld"); // "World" sovrascrive "Hello" (risultato visivo dipende dal terminale)

        // \t: Tabulazione orizzontale. Inserisce uno spazio di tabulazione (come
        // premere "Tab").
        System.out.println("\n3. Tab (\\t):");
        System.out.println("Hello\tWorld"); // Inserisce uno spazio di tab tra "Hello" e "World"

        // \b: Backspace. Cancella il carattere precedente (se il terminale lo
        // supporta).
        System.out.println("\n4. Backspace (\\b):");
        System.out.println("Helloo\bWorld"); // Cancella l'ultima 'o', quindi stampa "HelloWorld"

        // \f: Form Feed. Avanza alla pagina successiva (usato nelle stampanti), spesso
        // non visibile nei terminali moderni.
        System.out.println("\n5. Form feed (\\f):");
        System.out.println("Hello\fWorld"); // Effetto visivo dipende dal terminale, spesso nessun effetto
    }
}
