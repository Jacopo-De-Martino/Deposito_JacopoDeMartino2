package corsoJavaBackend.Settimana2.lezione6_30_06_2025.ProvaClassiOggetti;

import java.util.ArrayList;

class Libro {
    // Attributi
    String titolo;
    String autore;
    float prezzo;
    int codice_numerico_autoincrementante;
    // Attributo statico che conta il numero totale di libri, viene incrementato
    // alla creazione di ogni oggetto libro
    static int totale_libri = 0;

    // Metodo costruttore con parametri
    public Libro(String titolo, String autore, float prezzo) {
        totale_libri++;// incremento il counter alla creazione dell'oggetto (Utilizzo questo
                       // costruttore)
        // utilizzo il totale libri per assegnare il codice numeri ai libri in modo che
        // sia unico e autoincrementato
        this.codice_numerico_autoincrementante = totale_libri;
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }

    public void stampaLibro() {
        System.out.println(" Titolo " + titolo + " Autore: " + autore + " Titolo " + prezzo + " Codice Numerico "
                + codice_numerico_autoincrementante);
    }

    static public int totaleLibri() {
        return Libro.totale_libri;
    }
}

public class PrimoEsercizioClassiOggettiInJava {
    public static void main(String[] args) {
        // instanzio 2 oggetti libro
        Libro libro1 = new Libro("Il di dei pazzi", "De Martino", 12.99f);
        Libro libro2 = new Libro("Il mostro degli abbissi", "Paolo Rossi", 22.39f);
        // richiamo il metodo per stampare i dettagli dei libri
        libro1.stampaLibro();
        libro2.stampaLibro();
        // stampo il numero totale dei libi utilizzando il metodo statico totaleLibri
        System.out.println("Numero totale oggetti libro creati " + Libro.totaleLibri());

        // Creo una lista,(ARRAYLIST) di libri
        ArrayList<Libro> libri = new ArrayList<>();
        // Aggiungo a l'ArrayList i libri che ho creato
        libri.add(libro1);
        libri.add(libro2);
        // ciclo e stampa usando il metodo stampaLibro
        for (Libro libro : libri) {
            libro.stampaLibro();
        }

    }
}
