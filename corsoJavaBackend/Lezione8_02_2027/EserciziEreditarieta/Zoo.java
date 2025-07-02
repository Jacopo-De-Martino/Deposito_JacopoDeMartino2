package corsoJavaBackend.Lezione8_02_2027.EserciziEreditarieta;

import java.util.ArrayList;
import java.util.Scanner;

//Obbiettivo comprendere il concetto di ereditarietà in java
//Classe astratta padre o super classe Animale
abstract class Animale {
    // attributi super classe
    protected String nome;
    protected int eta;

    // costruttore vuoto super classe
    public Animale() {

    }

    // costruttore con parametri super classe
    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Metodi super classe
    public void faiVerso() {
        System.out.println("Animale fa verso");
    }

    public void info() {
        System.out.println("Nome " + this.nome + " Eta " + this.eta);
    }
}

// Sotto classe Gatto extends Animale ereditando metodi e attributi della
// superclasse
class Gatto extends Animale {
    // Costruttore vuoto gatto
    public Gatto() {
    }

    // Costruttore parametri gatto
    Gatto(String nome, int eta) {
        super(nome, eta);// super keyword per fare riferimento al costruttore della classe padre
    }

    // Metodi "Overraidati" specializzati per la classe gatto ereditati dalla classe
    // padre
    public void faiVerso() {
        System.out.println(this.nome + " fa meuww");
    }

    public void info() {
        System.out.println("Nome " + this.nome + " Eta " + this.eta + " Sono un Gatto");
    }
}

class Cane extends Animale {
    public Cane() {
    }

    Cane(String nome, int eta) {
        super(nome, eta);
    }

    // Metodi "Overraidati" specializzati per la classe cane ereditati dalla classe
    // padre
    public void faiVerso() {
        System.out.println(this.nome + " fa bau");
    }

    public void info() {
        System.out.println("Nome " + this.nome + " Eta " + this.eta + " Sono un Cane");
    }
}

// Gestione zoo
public class Zoo {
    public static void main(String[] args) {// Punto di accesso al programma
        ArrayList<Gatto> gatti = new ArrayList<>();// Lista in cui salvero i gatti
        ArrayList<Cane> cani = new ArrayList<>();// Lista in cui salvero i cani
        ArrayList<Animale> zoo = new ArrayList<>();// Lista in cui salvero gli animnali

        Scanner inputIntScanner = new Scanner(System.in);// Oggetto scanner per numeri
        Scanner inputStringScanner = new Scanner(System.in);// Oggetto scanner per stringhe

        int scelta = 0; // variabile per navigare il menu e condizione di uscita dal ciclo
        do {
            System.out.println("\nMENU");
            System.out.println("1 - Inserisci un gatto");
            System.out.println("2 - Inserisci un cane");
            System.out.println("3 - Stampa info gatti");
            System.out.println("4 - Stampa info cani");
            System.out.println("5 - Stampa info zoo completo");
            System.out.println("6 - Esci");

            scelta = inputIntScanner.nextInt(); // faccio fare a l'utente una scelta dopo la stampa delle possibili
                                                // opzioni

            switch (scelta) {
                case 1:
                    // ricevo in input nome e eta di un gatto
                    System.out.print("Inserisci nome del gatto: ");
                    String nomeGatto = inputStringScanner.nextLine();
                    System.out.print("Inserisci età del gatto: ");
                    int etaGatto = inputIntScanner.nextInt();
                    Gatto nuovoGatto = new Gatto(nomeGatto, etaGatto);// uso gli imput dell'utente per creare un Oggetto
                                                                      // di tipo Gatto
                    gatti.add(nuovoGatto);// salvo l'oggetto di tipo Gatto nella lista gatti
                    zoo.add(nuovoGatto);// salvo l'oggetto di tipo Gatto nella lista zoo
                    break;

                case 2:
                    System.out.print("Inserisci nome del cane: ");
                    String nomeCane = inputStringScanner.nextLine();
                    System.out.print("Inserisci età del cane: ");
                    int etaCane = inputIntScanner.nextInt();
                    Cane nuovoCane = new Cane(nomeCane, etaCane);// uso gli imput dell'utente per creare un Oggetto
                                                                 // di tipo Cane
                    cani.add(nuovoCane);// salvo l'oggetto di tipo Cane nella lista gatti
                    zoo.add(nuovoCane);// salvo l'oggetto di tipo Cane nella lista zoo
                    break;

                case 3:
                    System.out.println("\n--- GATTI ---");
                    for (Gatto gatto : gatti) {// ciclo la lista gatti e per ogni Gatto richiamo i metodi info e fai
                                               // verso
                        gatto.info();
                        gatto.faiVerso();
                    }
                    break;

                case 4:
                    System.out.println("\n--- CANI ---");
                    for (Cane cane : cani) {// ciclo la lista cani e per ogni Gatto richiamo i metodi info e fai
                                            // verso
                        cane.info();
                        cane.faiVerso();
                    }
                    break;

                case 5:
                    System.out.println("\n--- ZOO COMPLETO ---");
                    for (Animale animale : zoo) {// ciclo la lista zoo/Animali e per ogni Gatto richiamo i metodi info e
                                                 // fai
                                                 // verso
                        animale.info();
                        animale.faiVerso();
                    }
                    break;

                case 6:
                    System.out.println("Uscita menu");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 6);

        inputIntScanner.close();
        inputStringScanner.close();
    }
}