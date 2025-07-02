package corsoJavaBackend.Lezione8_02_2027.EserciziEreditarieta;

import java.util.ArrayList; // Importa ArrayList per liste dinamiche
import java.util.Scanner; // Importa la classe Scanner per leggere l'input dell'utente

// Classe padre: Camera
class Camera {
    protected int nCamera; // identificativo camera
    protected float prezzo; // prezzo

    // Costruttore della classe Camera
    public Camera(int nCamerai, float prezzoi) {
        this.nCamera = nCamerai;
        this.prezzo = prezzoi;
    }

    // Metodo per stampare le informazioni di base della camera
    public void info() {
        System.out.println("Camera : " + nCamera + " Prezzo : " + prezzo + "€");
    }

    // Metodo info sovraccaricato (overload)
    public void info(boolean mostraPrezzo) {
        if (mostraPrezzo) {
            this.info(); // Chiama il metodo info() senza parametri
        } else {
            System.out.println("Camera : " + nCamera);
        }
    }
}

// Classe figlia di Camera: Suite
class Suite extends Camera {
    private String serviziExtra; // attributo privato proprietario della classe Suite

    // Costruttore della classe Suite
    public Suite(int nCamerai, float prezzoi, String serviziExtrai) {
        super(nCamerai, prezzoi); // Chiama il costruttore della classe padre Camera
        this.serviziExtra = serviziExtrai;
    }

    // Metodo info sovrascritto (override) per le Suite
    @Override
    public void info() {
        System.out.println("Suite : " + nCamera + " Prezzo : " + prezzo + "€" + " Servizi extra : " + serviziExtra);
    }
}

// Classe Hotel per gestire le camere
class Hotel {
    private String nome; // Nome dell'hotel
    private ArrayList<Camera> listaCamere; // Lista di tutte le camere (Camera e Suite)
    private int contatoreSuite = 0; // Contatore per le suite
    private int contatoreCamereStandard = 0; // Contatore per le camere standard

    // Costruttore della classe Hotel
    public Hotel(String nome) {
        this.nome = nome;
        this.listaCamere = new ArrayList<>(); // Inizializza la lista delle camere
    }

    // Metodo per aggiungere una camera (o suite) alla lista
    public void aggiungiCamera(Camera camera) {
        if (camera instanceof Suite) {
            contatoreSuite++; // Incrementa il contatore delle suite
        } else { // Se non è una Suite, è una Camera standard
            contatoreCamereStandard++; // Incrementa il contatore delle camere standard
        }
        listaCamere.add(camera); // Aggiunge la camera alla lista
        System.out.println("Camera " + camera.nCamera + " aggiunta all'hotel.");
    }

    // Metodo per stampare le informazioni di tutte le camere e i totali
    public void stampaInformazioniHotel() {
        System.out.println("\n--- Informazioni Hotel: " + nome + " ---");
        if (listaCamere.isEmpty()) {
            System.out.println("Nessuna camera presente in questo hotel.");
        } else {
            System.out.println("Dettagli delle camere:");
            for (Camera c : listaCamere) {
                c.info(); // Utilizza il polimorfismo per chiamare il metodo info() corretto
            }
        }
        System.out.println("\nTotale Suite: " + contatoreSuite);
        System.out.println("Totale Camere Standard: " + contatoreCamereStandard);
        System.out.println("Totale Camere nell'Hotel: " + listaCamere.size());
        System.out.println("------------------------------------");
    }
}

// Classe principale per la gestione dell'hotel
public class GestoreHotel {

    // Scanner per la lettura dell'input da console
    private static final Scanner scanner = new Scanner(System.in);
    // Istanza dell'Hotel che verrà gestito dall'applicazione
    private static final Hotel hotel = new Hotel("Grand Hotel Bellavista"); // Puoi cambiare il nome dell'hotel

    /**
     * Metodo principale dell'applicazione.
     * Contiene il ciclo del menu e la gestione delle scelte.
     * 
     * @param args Argomenti della riga di comando (non usati in questo esempio)
     */
    public static void main(String[] args) {
        int scelta; // Variabile per memorizzare la scelta dell'utente
        do {
            mostraMenu(); // Mostra il menu all'utente
            scelta = leggiIntero("Inserisci la tua scelta: "); // Legge la scelta dell'utente
            gestisciScelta(scelta); // Gestisce la scelta
        } while (scelta != 0); // Continua finché l'utente non sceglie di uscire (0)
        scanner.close(); // Chiude lo scanner per rilasciare le risorse
        System.out.println("Applicazione terminata. Arrivederci!"); // Messaggio di uscita
    }

    /**
     * Mostra le opzioni del menu all'utente.
     * Questo metodo è personalizzato per l'applicazione di gestione hotel.
     */
    private static void mostraMenu() {
        System.out.println("\n--- MENU GESTIONE HOTEL ---");
        System.out.println("1 - Aggiungi una Camera Standard");
        System.out.println("2 - Aggiungi una Suite");
        System.out.println("3 - Stampa Informazioni Hotel");
        System.out.println("0 - Esci");
    }

    /**
     * Gestisce la scelta dell'utente.
     * Questo metodo contiene la logica per ogni opzione del menu.
     * 
     * @param scelta La scelta numerica fatta dall'utente
     */
    private static void gestisciScelta(int scelta) {
        switch (scelta) {
            case 1:
                aggiungiCameraStandard(); // Chiama il metodo per aggiungere una camera standard
                break;
            case 2:
                aggiungiSuite(); // Chiama il metodo per aggiungere una suite
                break;
            case 3:
                hotel.stampaInformazioniHotel(); // Chiama il metodo dell'hotel per stampare le info
                break;
            case 0:
                // L'uscita è gestita dal ciclo do-while nel main
                break;
            default:
                System.out.println("Scelta non valida. Per favore riprova."); // Messaggio per scelta non valida
        }
    }

    /**
     * Permette all'utente di inserire i dettagli per una nuova Camera Standard e la
     * aggiunge all'hotel.
     */
    private static void aggiungiCameraStandard() {
        int numeroCamera = leggiIntero("Inserisci il numero della camera: ");
        float prezzoCamera = leggiFloat("Inserisci il prezzo della camera: ");
        Camera nuovaCamera = new Camera(numeroCamera, prezzoCamera);
        hotel.aggiungiCamera(nuovaCamera);
    }

    /**
     * Permette all'utente di inserire i dettagli per una nuova Suite e la aggiunge
     * all'hotel.
     */
    private static void aggiungiSuite() {
        int numeroCamera = leggiIntero("Inserisci il numero della suite: ");
        float prezzoCamera = leggiFloat("Inserisci il prezzo della suite: ");
        String serviziExtra = leggiStringa("Inserisci i servizi extra della suite: ");
        Suite nuovaSuite = new Suite(numeroCamera, prezzoCamera, serviziExtra);
        hotel.aggiungiCamera(nuovaSuite);
    }

    /**
     * Legge una stringa dall'input dell'utente.
     * 
     * @param messaggio Il messaggio da mostrare all'utente prima di leggere
     *                  l'input.
     * @return La stringa letta dall'utente.
     */
    public static String leggiStringa(String messaggio) {
        System.out.print(messaggio); // Mostra il messaggio all'utente
        return scanner.nextLine(); // Legge l'intera riga di input
    }

    /**
     * Legge un numero intero dall'input dell'utente.
     * Gestisce gli errori se l'input non è un numero valido.
     * 
     * @param messaggio Il messaggio da mostrare all'utente prima di leggere
     *                  l'input.
     * @return L'intero letto dall'utente.
     */
    public static int leggiIntero(String messaggio) {
        System.out.print(messaggio); // Mostra il messaggio all'utente
        while (!scanner.hasNextInt()) { // Continua a chiedere finché l'input non è un intero
            System.out.print("Input non valido. Per favore inserisci un numero intero valido: "); // Messaggio di errore
            scanner.next(); // Scarta l'input non valido
        }
        int valore = scanner.nextInt(); // Legge l'intero
        scanner.nextLine(); // Consuma il resto della riga (il carattere di nuova riga)
        return valore; // Restituisce il valore letto
    }

    /**
     * Legge un numero float dall'input dell'utente.
     * Gestisce gli errori se l'input non è un numero float valido.
     * 
     * @param messaggio Il messaggio da mostrare all'utente prima di leggere
     *                  l'input.
     * @return Il float letto dall'utente.
     */
    public static float leggiFloat(String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextFloat()) {
            System.out.print("Input non valido. Per favore inserisci un numero decimale valido: ");
            scanner.next();
        }
        float valore = scanner.nextFloat();
        scanner.nextLine(); // Consuma il resto della riga
        return valore;
    }
}
