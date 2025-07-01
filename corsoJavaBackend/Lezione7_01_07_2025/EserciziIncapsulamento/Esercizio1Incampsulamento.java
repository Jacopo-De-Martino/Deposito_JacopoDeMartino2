package corsoJavaBackend.Lezione7_01_07_2025.EserciziIncapsulamento;

import java.util.ArrayList;
import java.util.Scanner;

class Studente {
    // Attributi privati
    private String nome;
    private int voto;
    private int id;
    private static int counter = 0;

    public Studente(String nome, int voto) {
        counter++;
        setNome(nome);
        setVoto(voto);
        this.id = counter;
    }

    // ! Metodi privati validazione
    private boolean votoValido(int voto) {
        return voto >= 0 && voto <= 10;
    }

    private boolean nomeValido(String nome) {
        return nome != null && !nome.isBlank();
    }

    // ! Inizio metodi getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nomeValido(nome)) {
            System.out.println("Errore nome vuoto");
        } else {
            this.nome = nome;
        }
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        if (!votoValido(voto)) {
            System.out.println("Errore, il voto non è valido");
        } else {
            this.voto = voto;
        }
    }

    public int getId() {
        return id;
    }

    // public void setId(int id) {
    // this.id = id;
    // }

    public static int getCounter() {
        return counter;
    }

    // public static void setCounter(int counter) {
    // Studente.counter = counter;
    // }

    // fine metodi getter e setter
    public void stampaStudente() {
        System.out.println("ID : " + this.id + " Nome : " + this.nome + " Voto : " + this.voto);

    }

    // static Studente cercaStudente(ArrayList<Studente> studenti, String nome) {
    // for (Studente studente : studenti) {
    // if (studente.getNome().equalsIgnoreCase(nome)) {
    // return studente; // Appena trovato, lo restituiamo
    // }
    // }
    // return null; // Nessuno trovato
    // }

}

public class Esercizio1Incampsulamento {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);// Instanzio scanner per imput utente
        Scanner myIntScanner = new Scanner(System.in);// Instanzio scanner per imput utente
        ArrayList<Studente> studenti = new ArrayList<>();// Instanzio arrayList dove salverò i miei studenti
        boolean menu = true;

        // Base
        Studente studente1 = new Studente("Luca", 10);
        // Stampo lo studente
        // provo a stampare i valori utilizzando il . per raggiungere il dato che mi
        // interessa
        // ! System.out.println("Nome : " + studente1.nome); "ERRORE IL CAMPO NOME NON
        // ! E\' VISIBILE");
        // provo a modificare i valori utilizzando il . per raggiungere il dato che mi
        // interessa
        // ! studente1.nome = "Simone"; ERRORE IL CAMPO NOME NON E' VISIBILE
        // utilizzo i metodi getter e setter
        System.out.println(// Metodo getter per ricevere i dati e in questo caso per stamparli
                "Nome " + studente1.getNome() + " Voto : " + studente1.getVoto() + " ID : " + studente1.getId());
        studente1.setNome("Simone");
        studente1.setVoto(7);
        // Stampo dopo la modifica lo stesso oggetto
        System.out.println(// Metodo getter per ricevere i dati e in questo caso per stamparli
                "Nome " + studente1.getNome() + " Voto : " + studente1.getVoto() + " ID : " + studente1.getId());

        do {
            System.out.println("Menu\n\"1\" per aggiungere uno studente\n\"2\" ricerca studente\n\"EXIT\" per uscire");
            String scelta = myScanner.nextLine(); // Variabile per la navigazione del menu/ flusso del programma
            switch (scelta.toLowerCase()) {
                case "1":
                    // blocco di codice per aggiungere uno studente
                    System.out.println("Aggiugni uno studente");
                    System.out.println("Inserisci il nome");
                    String nomei = myScanner.nextLine();
                    System.out.println("Inserisci voto");
                    int votoi = myIntScanner.nextInt();
                    Studente nuovoStudente = new Studente(nomei, votoi); // Salvo i dati ricevuti in imput in un oggetto
                                                                         // di tipo studente
                    studenti.add(nuovoStudente);// Salvo l'oggetto di tipo studente nella mia ArrayList studententi
                    break;
                case "2":
                    // Richiesta all’utente
                    System.out.print("Inserisci il nome dello studente da cercare: ");
                    String nomeDaCercare = myScanner.nextLine();
                    Studente trovato = Ricerca.cercaStudente(studenti, nomeDaCercare); // Utilizzo il metodo statico
                                                                                       // della mia utility class che
                                                                                       // accetta una ArrayList e una
                                                                                       // Stringa e restituisce un
                                                                                       // oggetto di tipo persona
                    if (trovato != null) {// Se torna uno studente lo stampa
                        System.out.println("Studente trovato:");
                        trovato.stampaStudente();
                    } else {// Se non trova nulla stampa un messaggio di errore
                        System.out.println("Nessuno studente trovato con quel nome.");
                    }
                    break;
                case "exit":
                    System.out.println("Uscita dal menu");
                    menu = false;
                    break;
                default:
                    break;
            }

        } while (menu);

        // Stampo lista studenti
        System.out.println("Lista studenti");
        for (Studente studete : studenti) {
            studete.stampaStudente();
        }

        myScanner.close();
    }

    class Ricerca {
        static Studente cercaStudente(ArrayList<Studente> studenti, String nome) {
            for (Studente studente : studenti) {
                if (studente.getNome().equalsIgnoreCase(nome)) {
                    return studente;
                }
            }
            return null;
        }
    }
}