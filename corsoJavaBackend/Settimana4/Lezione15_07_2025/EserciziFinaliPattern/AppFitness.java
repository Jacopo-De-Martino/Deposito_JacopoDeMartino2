package corsoJavaBackend.Settimana4.Lezione16_07_2025.EserciziFinaliPattern;

import java.util.Scanner;

// SINGLETON: Utente loggato -> Pattern Singleton -> Contesto per State -> Pattern State

class Utente {
    // Attributi dell'utente
    private String name;
    private String password;
    private int id;
    private static int idCounter = 0;
    private StatoFisico stato; // Stato attuale -> condizione fisica dell'utente
    // Costruttore utente

    public Utente(String name, String password) {
        this.name = name;
        this.password = password;
        idCounter++;
        this.id = idCounter;
        this.stato = new StatoRiposo(); // creo l'utente impostando lo stato di riposo come default
    }

    /*
     * Inizio getters e setters per gli attributi
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Utente.idCounter = idCounter;
    }

    public void setStato(StatoFisico stato) {
        this.stato = stato;
    }

    public StatoFisico getStato() {
        return stato;
    }

    /*
     * Fine getters e setters per gli attributi
     */
    // Metodo per eseguire l'azione in base allo stato attuale
    public void eseguiAzione() {
        if (stato != null) {// Controllo se lo stato è stato impostato
            stato.azione(this);// richiama il metodo azione dello stato attuale su l'utente stesso
        } else {
            System.out.println("Stato non impostato.");
        }
    }

    // Metodo toString per visualizzare l'utente
    @Override
    public String toString() {
        return "Utente [name=" + name + ", password=" + password + ", id=" + id + "]";
    }
}

// Singleton per la gestione dell'utente loggato
class User_Singleton {
    private static User_Singleton instance; // Istanza unica della classe
    private Utente loggedUser; // Utente attualmente loggato

    private User_Singleton() { // Sovrascrive il costruttore di default per evitare istanziazioni multiple
    }

    public static User_Singleton getInstance() {
        if (instance == null) {
            instance = new User_Singleton();// Crea una nuova istanza se non esiste
        }
        return instance; // Restituisce l'istanza unica
    }

    public Utente getLoggedUser() {
        return loggedUser; // Metodo per ottenere l'utente loggato
    }

    public void setLoggedUser(Utente loggedUser) {
        this.loggedUser = loggedUser; // Metodo per impostare l'utente loggato
    }
}

// STATE: Stato fisico dell'utente -> Pattern State

interface StatoFisico { // Interfaccia per gli stati fisici
    // Metodo che definisce l'azione da eseguire in base allo stato fisico
    void azione(Utente utente);
}

class StatoRiposo implements StatoFisico { // Stato di riposo
    @Override
    public void azione(Utente utente) {
        System.out.println(utente.getName() + " è in riposo. Consigliato: stretching leggero o meditazione.");
    }
}

class StatoAllenamento implements StatoFisico { // Stato di allenamento
    @Override
    public void azione(Utente utente) {
        System.out.println(utente.getName() + " è in allenamento. Consigliato: esercizi intensi!");
    }
}

class StatoRecupero implements StatoFisico { // Stato di recupero
    @Override
    public void azione(Utente utente) {
        System.out.println(utente.getName() + " è in recupero. Consigliato: idratazione e riposo muscolare.");
    }
}

// CORE: Logica di interazione con l'utente

class CoreFitness {
    private Scanner scanner; // Scanner per input utente

    public CoreFitness() {
        this.scanner = new Scanner(System.in); // Inizializza lo scanner
    }

    // Gestisce login/creazione utente e menù per la gestione dello stato fisico
    public void loginUtente() {
        System.out.print("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci la tua password: ");
        String password = scanner.nextLine();
        Utente u = new Utente(nome, password);
        User_Singleton.getInstance().setLoggedUser(u);
        System.out.println("Benvenuto, " + nome + "!");

        boolean continua = true;
        while (continua) {
            System.out.println("\n--- Menu Stato Fisico ---");
            System.out.println("1. Riposo");
            System.out.println("2. Allenamento");
            System.out.println("3. Recupero");
            System.out.println("0. Esci");
            System.out.print("Seleziona lo stato attuale: ");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    u.setStato(new StatoRiposo());
                    u.eseguiAzione();
                    break;
                case "2":
                    u.setStato(new StatoAllenamento());
                    u.eseguiAzione();
                    break;
                case "3":
                    u.setStato(new StatoRecupero());
                    u.eseguiAzione();
                    break;
                case "0":
                    continua = false;
                    System.out.println("Uscita dall'app. Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}

// FACADE: Semplifica l'accesso all'app fitness -> Utilizza il sottosistema
// CoreFitness

class FacadeFitness {
    private CoreFitness coreFitness;

    public FacadeFitness() {
        this.coreFitness = new CoreFitness();
    }

    // Metodo unico per gestire tutta la navigazione dell'app
    public void navigaInAppFitness() {
        coreFitness.loginUtente();
    }
}

// MAIN: Solo richiamo del facade

public class AppFitness {
    public static void main(String[] args) {
        FacadeFitness fitness = new FacadeFitness();
        fitness.navigaInAppFitness();
    }
}