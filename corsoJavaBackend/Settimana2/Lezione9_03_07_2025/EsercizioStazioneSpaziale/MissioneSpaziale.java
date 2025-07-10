package corsoJavaBackend.Settimana2.Lezione9_03_07_2025.EsercizioStazioneSpaziale;

//codice correzzione
// Import necessari
import java.util.*;

// Super Classe Astronauta
class Astronauta {
    // Attributi super classe(condivisi da tutte le sottoclassi)
    protected String nome;
    protected String email;
    protected float creditoOssigeno;

    // costruttore parametrico
    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
        rigeneraOssigeno(); // richiamo il metodo rigenera Ossigeno
    }

    // Metodo per valorizzare l'ossigeno alla creazione
    public void rigeneraOssigeno() {
        this.creditoOssigeno = (float) (Math.random() * 100 + 100); // Tra 100 e 200
    }

    public void infoAstronauta() {// stampa informazioni Astronauta
        System.out.printf("Nome: %s | Email: %s | Ossigeno: %.2f\n", nome, email, creditoOssigeno);// utilizzo printf %s
                                                                                                   // Stringa %.2f float
                                                                                                   // formattato a 2
                                                                                                   // cifre dopo la
                                                                                                   // virgola
    }
}

// Classe contenitore
class StazioneSpaziale {
    public static ArrayList<String> esperimenti = new ArrayList<>();// collezione di esperimenti
    public static ArrayList<Integer> valutazioni = new ArrayList<>();// collezione di valutazioni
}

// Classe derivata Scienziato "extends Astronauta"
class Scienziato extends Astronauta {
    private int esperimentiInseriti = 0; // variabile "counter" degli esperimenti inseriti

    public Scienziato(String nome, String email) {
        super(nome, email);// utilizzo super ccostruttore riferimento a classe Astronauta
    }

    // Metodo per aggiungere un esperimento alla lista degli esperimenti, il nome
    // dell'esperimento entra in ingresso come parametro
    public void aggiungiEsperimento(String titolo) {
        StazioneSpaziale.esperimenti.add(titolo);
        esperimentiInseriti++;// aumento il contatore degli esperimenti inseriti
        System.out.println("Esperimento aggiunto.");
        if (esperimentiInseriti == 3) {// Se esperimenti è uguale a 3 stampo hai raggiunto il ruolo Scienziato capo
            System.out.println("Hai raggiunto il ruolo di Scienziato Capo.");
        }
    }

    public boolean isCapo() {// metodo per verificare se uno scienziato ha aquisito il ruolo capo
        return esperimentiInseriti >= 3;// esperimenti maggiore=3 == true
    }

    // metodo per stampare tutti gli esperimenti presenti nella stazione spaziale
    public void stampaEsperimenti() {
        System.out.println("Lista degli esperimenti:");
        for (String esp : StazioneSpaziale.esperimenti) {
            System.out.println("- " + esp);
        }
    }
}

// Classe derivata Ispettore //Molto simile a la classe Scienziato
class Ispettore extends Astronauta {
    private int valutazioniInserite = 0; // numero valutazioni inserite inizializzato a 0

    public Ispettore(String nome, String email) {
        super(nome, email);// Utilizzo il costruttore della classe padre per valorizzare gli attributi
                           // comuni
    }

    public void aggiungiValutazione(int voto) {// metodo per aggiungere una valutazione alla stazione spaziale
        if (voto < 1 || voto > 5) {// verifico il range della valutazione
            System.out.println("Valutazione non valida. Inserire un numero da 1 a 5.");// stampo errore valutazione
            return;// esco dal metodo
        }
        // se il voto rispetta il range richiesto aggiungo il voto alle valutazioni
        // della StazioneSpaziale
        StazioneSpaziale.valutazioni.add(voto);
        valutazioniInserite++;// incremento il numero di valutazioni inserite inizializzato a 0
        System.out.println("Valutazione inserita.");
        if (valutazioniInserite == 3) {// se valutazione inserite == 3 , l'ispettore raggiunge il ruolo Esperto
            System.out.println("Hai raggiunto il ruolo di Ispettore Esperto.");
        }
    }

    public boolean isEsperto() {// check per ruolo esperto
        return valutazioniInserite >= 3;// valutazioni maggiore=3 == true
    }

    // stampa della lista di valutazioni presenti nella stazione spaziale
    public void stampaValutazioni() {
        System.out.println("Lista delle valutazioni:");
        for (int val : StazioneSpaziale.valutazioni) {
            System.out.println("- " + val);
        }
    }
}

// Classe principale
public class MissioneSpaziale {
    public static void main(String[] args) {
        // Utilizzo di uno scanner per ricevere
        Scanner input = new Scanner(System.in);
        boolean continua = true;// utilizzo un boolean per il flusso del ciclo del menu
        // finche continua è true fai:
        while (continua) {
            // stampa menu
            System.out.println("\n=== Menu ===");
            // faccio inserire nome ed email e pianeta preferito per creare il mio
            // astronauta e specializzarlo
            System.out.print("Inserisci il tuo nome: ");
            String nome = input.nextLine();
            System.out.print("Inserisci la tua email: ");
            String email = input.nextLine();
            System.out.print("Qual è il tuo pianeta preferito? ");
            String pianeta = input.nextLine().toLowerCase();
            Astronauta user;// utilizzo una variabile di appoggio che valorizzo dopo il controllo sul
                            // pianeta scelto
            boolean isScienziato = pianeta.contains("marte") || pianeta.contains("terra");// uso una variabile booleana
                                                                                          // per specializzare
                                                                                          // l'astronauta
            if (isScienziato) {
                user = new Scienziato(nome, email);
            } else {
                user = new Ispettore(nome, email);
            }
            boolean sessione = true;// utilizzo una seconda variabile booleana per entrare nel menu dopo aver
                                    // effettuato "l'accesso"
            while (sessione) {
                // stampa menu Astronauta
                System.out.println("\n1. Visualizza dati\n2. Rigenera ossigeno\n3. Interagisci con profilo\n4. Esci");
                System.out.print("Scelta: ");
                int scelta = Integer.parseInt(input.nextLine());// prendo input la scelta per le operazioni
                switch (scelta) {
                    case 1:// stampo le informazioni dell'astronauta richiamo il metodo infoAstronauta();
                        user.infoAstronauta();
                        break;
                    case 2:// Rigenere l'ossigeno dell'astronauta richiamo il metodo rigeneraOssigene
                        user.rigeneraOssigeno();
                        System.out.println("Ossigeno rigenerato.");
                        break;
                    case 3:// controllo se user(Astronauta) è un istanza di Scenziato o Ispettore e se è
                           // capo o esperto
                        if (user instanceof Scienziato) {// se è scenziato può inserire un esperimento
                            Scienziato s = (Scienziato) user; // eseguo un casting esplicito x accedere ai metodi di
                                                              // Scenziato
                            System.out.print("Titolo esperimento da aggiungere: ");
                            String exp = input.nextLine(); // faccio inserire il titolo dell'esperimento
                            s.aggiungiEsperimento(exp); // salvo l'esperimento nella stazione spaziale utilizzo il
                                                        // metodo aggiungiEsperimento(String titolo)
                            if (s.isCapo()) {// inoltre verifico se è capo , in questo caso lo Scenziato può tramite
                                             // input richiedere di stampare tutta la lista di esperimenti presenti
                                System.out.print("Stampare tutti gli esperimenti? (s/n): ");
                                if (input.nextLine().equalsIgnoreCase("s")) {
                                    s.stampaEsperimenti();
                                }
                            }
                            // Stessi controlli e logiche viste in precedenza ma per Ispettore, inserimento
                            // e stampa valutazioni
                        } else if (user instanceof Ispettore) {
                            Ispettore i = (Ispettore) user;
                            System.out.print("Inserisci una valutazione (1-5): ");
                            int voto = Integer.parseInt(input.nextLine());
                            i.aggiungiValutazione(voto);
                            if (i.isEsperto()) {
                                System.out.print("Stampare tutte le valutazioni? (s/n): ");
                                if (input.nextLine().equalsIgnoreCase("s")) {
                                    i.stampaValutazioni();
                                }
                            }
                        }
                        break;
                    case 4:// caso di uscita setto sessione a false
                        sessione = false;
                        break;
                    default:// caso default scelta non valida
                        System.out.println("Scelta non valida.");
                }
            }

            System.out.print("Vuoi ripetere con un nuovo astronauta? (s/n): ");
            if (!input.nextLine().equalsIgnoreCase("s")) {
                continua = false;
            }
        }
        input.close();
        System.out.println("Programma terminato.");
    }
}