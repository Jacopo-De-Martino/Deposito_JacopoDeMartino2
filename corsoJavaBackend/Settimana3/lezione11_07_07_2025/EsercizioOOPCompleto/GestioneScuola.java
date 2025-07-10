
//Es OOP Completo
//Classe astratta Persona
import java.util.ArrayList;
import java.util.Scanner;

// Classe astratta Persona: rappresenta una persona generica con nome ed età
abstract class Persona {
    // Campi della classe Persona
    // Useremo protected per permettere l'accesso diretto alle classi figlie
    protected String nome;
    protected int eta;

    // Metodi getter (per ottenere il valore) e setter (per impostare il valore) per
    // i campi nome ed eta
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    // Metodo costruttore: inizializza una nuova Persona con un nome e un'età
    // specificati
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Metodo astratto che dovrà essere implementato da tutte le classi figlie
    public abstract String descriviRuolo();

}

// Interfaccia Registrabile: definisce un contratto per gli oggetti che possono
// essere registrati
interface Registrabile {
    // Metodo per registrare una persona; le classi che implementano questa
    // interfaccia devono fornire la loro logica di registrazione
    void registraPersona();
}

// Classe Studente: estende Persona e implementa Registrabile, aggiungendo
// attributi e comportamenti specifici dello studente
class Studente extends Persona implements Registrabile {
    private String matricola; // Campo specifico per la matricola dello studente

    // Getter e setter per la matricola
    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    // Costruttore della classe Studente: richiama il costruttore della classe padre
    // (Persona) e inizializza la matricola
    public Studente(String nome, int eta, String matricola) {
        super(nome, eta);
        this.matricola = matricola;
    }

    @Override
    // Implementazione del metodo registraPersona dall'interfaccia Registrabile
    public void registraPersona() {
        // Qui viene simulata la registrazione stampando un messaggio
        // In un'applicazione reale, qui ci sarebbe la logica per salvare i dati in un
        // database o un'altra persistenza
        System.out.println("Registrazione dello studente tramite modulo online: " + nome);

    }

    @Override
    // Implementazione del metodo descriviRuolo dalla classe astratta Persona
    // Questo metodo fornisce una descrizione dettagliata del ruolo dello studente
    public String descriviRuolo() {
        return "Descrizione del ruolo dello studente: " + nome + ", Età: " + eta + ", Matricola: " + matricola;
    }
}

// Classe Docente: estende Persona e implementa Registrabile, aggiungendo
// attributi e comportamenti specifici del docente
class Docente extends Persona implements Registrabile {
    // Campi specifici per la classe Docente
    private String codiceFiscale;
    private String materia;

    // Getter e setter per materia e codiceFiscale
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    // Costruttore della classe Docente: richiama il costruttore della classe padre
    // (Persona) e inizializza i campi specifici
    public Docente(String nome, int eta, String codiceFiscale, String materia) {
        super(nome, eta);
        this.codiceFiscale = codiceFiscale;
        this.materia = materia;
    }

    @Override
    // Implementazione del metodo registraPersona dall'interfaccia Registrabile
    public void registraPersona() {
        // Qui viene simulata la registrazione del docente
        System.out.println("Registrazione del docente tramite segreteria : " + nome);

    }

    @Override
    // Implementazione del metodo descriviRuolo dalla classe astratta Persona
    // Questo metodo fornisce una descrizione dettagliata del ruolo del docente
    public String descriviRuolo() {
        return "Descrizione del ruolo del docente: " + nome + ", Età: " + eta + ", Codice Fiscale: "
                + codiceFiscale + ", Materia: " + materia;
    }
}

// Classe contenitore
class Scuola {
    private String nome;
    private ArrayList<Persona> persone; // Lista generale di tutte le persone
    private ArrayList<Studente> studenti; // lista per gli studenti
    private ArrayList<Docente> docenti;// lista per i docenti

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter per la lista generale (potrebbe comunque essere utile)
    public ArrayList<Persona> getPersone() {
        return persone;
    }

    // Setter (usalo con cautela, potrebbe sovrascrivere le liste specifiche)
    public void setPersone(ArrayList<Persona> persone) {
        this.persone = persone;
    }

    // Nuovi getter per le liste specifiche
    public ArrayList<Studente> getStudenti() {
        return studenti;
    }

    public ArrayList<Docente> getDocenti() {
        return docenti;
    }

    public Scuola(String nome) {
        this.nome = nome;
        persone = new ArrayList<>(); // Inizializza la lista generale di persone
        studenti = new ArrayList<>(); // Inizializza studenti
        docenti = new ArrayList<>(); // Inizializza docenti
    }

    // Metodo modificato per aggiungere una persona a tutte le liste appropriate
    public void aggiungiPersona(Persona persona) {
        persone.add(persona); // Aggiunge sempre alla lista generale

        // Usa instanceof per aggiungere alla lista specifica
        if (persona instanceof Studente) {
            studenti.add((Studente) persona); // Cast sicuro grazie a instanceof
        } else if (persona instanceof Docente) {
            docenti.add((Docente) persona); // Cast sicuro
        }
    }

    // Questo metodo ora utilizza direttamente le liste specifiche
    public void stampaPersone() {
        if (persone.isEmpty()) { // Controlla la lista generale per il messaggio iniziale
            System.out.println("Nessuna persona registrata in questa scuola.");
            return;
        }

        // Stampa gli studenti dalla lista specifica
        System.out.println("\n--- Elenco Studenti ---");
        if (studenti.isEmpty()) {
            System.out.println("Nessuno studente registrato.");
        } else {
            for (Studente s : studenti) {
                System.out.println(s.descriviRuolo());
            }
        }

        // Stampa i docenti dalla lista specifica
        System.out.println("\n--- Elenco Docenti ---");
        if (docenti.isEmpty()) {
            System.out.println("Nessun docente registrato.");
        } else {
            for (Docente d : docenti) {
                System.out.println(d.descriviRuolo());
            }
        }
    }

    // checkRegistrazione
    public boolean checkRegistrazione(Persona persona) {
        for (Persona p : persone) {
            if (p.getNome().equals(persona.getNome()) && p.getEta() == persona.getEta()) {
                return true;
            }
        }
        return false;
    }
}

public class GestioneScuola {
    public static void main(String[] args) {
        // Inizializza gli scanner per l'input dell'utente dalla console
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        // Crea un'istanza della classe Scuola con un nome specifico
        Scuola scuola = new Scuola("Liceo Classico Statale");
        int scelta; // Variabile per memorizzare la scelta dell'utente nel menu

        // Messaggio di benvenuto all'utente
        System.out.println("Benvenuto nel sistema di gestione della " + scuola.getNome());

        // Ciclo do-while per mostrare il menu delle opzioni e gestire le scelte
        // dell'utente
        do {
            // Stampa il menu delle opzioni disponibili all'utente
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi Studente");
            System.out.println("2. Aggiungi Docente");
            System.out.println("3. Visualizza tutte le persone");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            // Validazione dell'input dell'utente per la scelta del menu
            // Continua a chiedere finché l'utente non inserisce un numero intero
            while (!intScanner.hasNextInt()) {
                System.out.println("Input non valido. Per favore, inserisci un numero.");
                intScanner.next(); // Consuma l'input non valido per evitare un ciclo infinito
                System.out.print("Scegli un'opzione: ");
            }
            scelta = intScanner.nextInt(); // Legge la scelta numerica dell'utente
            // Utilizza uno switch per eseguire azioni diverse in base alla scelta
            // dell'utente
            switch (scelta) {
                case 1: // Caso per aggiungere un nuovo studente
                    System.out.println("\n--- Aggiungi Studente ---");
                    System.out.print("Inserisci nome studente: ");
                    String nomeStudente = stringScanner.nextLine(); // Legge il nome dello studente
                    System.out.print("Inserisci età studente: ");
                    // Validazione dell'età dello studente: assicura che sia un numero intero
                    while (!intScanner.hasNextInt()) {
                        System.out.println("Input non valido. Per favore, inserisci un numero per l'età.");
                        intScanner.next(); // Consuma l'input non valido
                        System.out.print("Inserisci età studente: ");
                    }
                    int etaStudente = intScanner.nextInt(); // Legge l'età come intero
                    System.out.print("Inserisci matricola studente: ");
                    String matricolaStudente = stringScanner.nextLine(); // Legge la matricola dello studente

                    // Crea una nuova istanza di Studente con i dati forniti
                    Studente nuovoStudente = new Studente(nomeStudente, etaStudente, matricolaStudente);
                    // Controlla se lo studente è già registrato nella scuola
                    if (!scuola.checkRegistrazione(nuovoStudente)) {
                        nuovoStudente.registraPersona(); // Chiama il metodo di registrazione dello
                                                         // studente
                        scuola.aggiungiPersona(nuovoStudente); // Aggiunge lo studente alla lista della scuola
                        System.out.println("Studente aggiunto con successo."); // Messaggio di successo
                    } else {
                        System.out.println("Errore: Studente già registrato."); // Messaggio di errore se già registrato
                    }
                    break; // Termina il case 1
                case 2: // Caso per aggiungere un nuovo docente
                    System.out.println("\n--- Aggiungi Docente ---");
                    System.out.print("Inserisci nome docente: ");
                    String nomeDocente = stringScanner.nextLine(); // Legge il nome del docente
                    System.out.print("Inserisci età docente: ");
                    // Validazione dell'età del docente
                    while (!intScanner.hasNextInt()) {
                        System.out.println("Input non valido. Per favor, inserisci un numero per l'età.");
                        intScanner.next();
                        System.out.print("Inserisci età docente: ");
                    }
                    int etaDocente = intScanner.nextInt(); // Legge l'età

                    System.out.print("Inserisci codice fiscale docente: ");
                    String codiceFiscaleDocente = stringScanner.nextLine(); // Legge il codice fiscale
                    System.out.print("Inserisci materia docente: ");
                    String materiaDocente = stringScanner.nextLine(); // Legge la materia

                    // Crea una nuova istanza di Docente
                    Docente nuovoDocente = new Docente(nomeDocente, etaDocente, codiceFiscaleDocente, materiaDocente);
                    // Controlla se il docente è già registrato
                    if (!scuola.checkRegistrazione(nuovoDocente)) {
                        nuovoDocente.registraPersona(); // Chiama il metodo di registrazione del docente
                        scuola.aggiungiPersona(nuovoDocente); // Aggiunge il docente alla lista della scuola
                        System.out.println("Docente aggiunto con successo."); // Messaggio di successo
                    } else {
                        System.out.println("Errore: Docente già registrato."); // Messaggio di errore
                    }
                    break; // Termina il case 2
                case 3: // Caso per visualizzare tutte le persone registrate
                    System.out.println("\n--- Elenco Persone Registrate ---");
                    scuola.stampaPersone(); // Chiama il metodo per stampare la lista delle persone
                    break; // Termina il case 3
                case 0: // Caso per uscire dal programma
                    System.out.println("Uscita dal programma. Arrivederci!"); // Messaggio di uscita
                    break; // Termina il case 0
                default: // Caso per opzioni non valide (numeri diversi da 0, 1, 2, 3)
                    System.out.println("Opzione non valida. Riprova."); // Messaggio di errore per scelta non valida
            }
        } while (scelta != 0); // Il ciclo continua finché l'utente non sceglie l'opzione 0 (Esci)
        // chiude gli scanner per evitare perdite di risorse
        intScanner.close();
        stringScanner.close();
    }
}