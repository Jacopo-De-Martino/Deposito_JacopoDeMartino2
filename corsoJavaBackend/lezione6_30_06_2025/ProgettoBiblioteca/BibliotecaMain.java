import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Classe Libro rappresenta un libro nella biblioteca
class Libro {
    // Attributi del libro
    // titolo, autore, disponibilità e data di prestito
    String titolo;
    String autore;
    boolean disponibile = true;
    LocalDate dataPrestito;

    // Metodo per mostrare le informazioni del libro
    void mostraInfoLibro() {
        System.out.println(
                "Titolo: " + titolo + " | Autore: " + autore + " | Disponibile: " + (disponibile ? "Sì" : "No"));
    }

    // Costruttore per inizializzare gli attributi titolo e autore
    public Libro(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }
}

// Classe Biblioteca rappresenta la biblioteca con i suoi libri e utenti
class Biblioteca {
    ArrayList<Libro> libri = new ArrayList<>();
    Map<String, Utente> utenti = new HashMap<>();

    // Metodo per aggiungere un libro alla biblioteca
    void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    // Metodo per registrare un nuovo utente
    void registraUtente(String nome, String password) {
        // Controlla se l'utente esiste già
        if (utenti.containsKey(nome)) {
            System.out.println("Utente già registrato con questo nome.");
            return;
        }
        // Crea un nuovo utente e lo aggiunge alla mappa degli utenti
        // La mappa associa il nome dell'utente all'oggetto Utente
        utenti.put(nome, new Utente(nome, password));
    }

    // Metodo per effettuare il login di un utente
    Utente login(String nome, String password) {
        Utente utente = utenti.get(nome);
        // Controlla se l'utente esiste e se la password è corretta
        // Se l'utente esiste e la password corrisponde, restituisce l'utente
        // Altrimenti, restituisce null
        if (utente != null && utente.password.equals(password)) {
            return utente;
        }
        return null;
    }

    // Metodo per mostrare tutte le informazioni dei libri nella biblioteca
    void mostraTuttiILibri() {
        for (Libro libro : libri) {
            libro.mostraInfoLibro();
        }
    }

    // Metodo per prendere in prestito un libro
    // Controlla se il libro è disponibile e se l'utente ha già preso in prestito 3
    // libri
    // Se il libro è disponibile, lo marca come non disponibile e lo aggiunge alla
    // lista dei libri in prestito dell'utente
    // Se il libro non è disponibile o non esiste, stampa un messaggio di erro
    void prendiInPrestito(String titolo, Utente utente) {
        for (Libro libro : libri) {
            if (libro.titolo.equalsIgnoreCase(titolo) && libro.disponibile) {
                if (utente.libriInPrestito.size() >= 3) {
                    System.out.println("Hai già preso in prestito 3 libri.");
                    return;
                }
                libro.disponibile = false;
                libro.dataPrestito = LocalDate.now();
                utente.libriInPrestito.add(libro);
                System.out.println(utente.nome + " ha preso in prestito: " + libro.titolo);
                return;
            }
        }
        System.out.println("Libro non disponibile o non trovato.");
    }

    // Metodo per restituire un libro
    // Controlla se il libro è tra quelli presi in prestito dall'utente
    // Se il libro è trovato, lo marca come disponibile, rimuove la data di prestito
    // e lo rimuove dalla lista dei libri in prestito dell'utente
    // Se il libro non è trovato, stampa un messaggio di errore
    void restituisciLibro(String titolo, Utente utente) {
        Iterator<Libro> it = utente.libriInPrestito.iterator();
        while (it.hasNext()) {
            Libro libro = it.next();
            if (libro.titolo.equalsIgnoreCase(titolo)) {
                long giorni = ChronoUnit.DAYS.between(libro.dataPrestito, LocalDate.now());
                libro.disponibile = true;
                libro.dataPrestito = null;
                it.remove();

                System.out.println(utente.nome + " ha restituito: " + libro.titolo);
                if (giorni > 14) {
                    System.out.println("Restituito in ritardo di " + (giorni - 14) + " giorni. Penalità applicata.");
                }
                return;
            }
        }
        System.out.println("Il libro non è stato trovato tra quelli presi in prestito da " + utente.nome);
    }

    // Metodo per cercare un libro per titolo o autore
    // Scorre tutti i libri e verifica se il titolo o l'autore corrispondono alla
    // parola chiave inserita
    // Se trova un libro che corrisponde, mostra le informazioni del libro
    void cerca(String parolaChiave) {
        System.out.println("Risultati della ricerca:");
        boolean trovato = false;
        for (Libro libro : libri) {
            if (libro.titolo.equalsIgnoreCase(parolaChiave) || libro.autore.equalsIgnoreCase(parolaChiave)) {
                libro.mostraInfoLibro();
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato con: " + parolaChiave);
        }
    }
}

// Classe Utente rappresenta un utente della biblioteca
class Utente {
    // Attributi dell'utente: nome, password e lista dei libri in prestito
    // La lista dei libri in prestito è un ArrayList di oggetti Libro
    String nome;
    String password;
    ArrayList<Libro> libriInPrestito = new ArrayList<>();

    // Costruttore per inizializzare gli attributi nome e password
    public Utente(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    // Metodo per mostrare i libri in prestito dell'utente
    // Se l'utente non ha libri in prestito, stampa un messaggio appropriato
    void mostraLibriInPrestito() {
        if (libriInPrestito.isEmpty()) {
            System.out.println(nome + " non ha libri in prestito.");
        } else {
            System.out.println("Libri in prestito da " + nome + ":");
            for (Libro libro : libriInPrestito) {
                libro.mostraInfoLibro();
                System.out.println("   Data prestito: " + libro.dataPrestito);
            }
        }
    }
}

// Classe principale BibliotecaMain per gestire l'interazione con l'utente
// Contiene il metodo main che avvia il programma e gestisce il menu principale
public class BibliotecaMain {
    public static void main(String[] args) {
        // Inizializza lo scanner per l'input dell'utente e la biblioteca
        // Crea un oggetto Biblioteca per gestire i libri e gli utenti
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        // Variabile per tenere traccia dell'utente attualmente loggato
        // Inizializza l'utente come null per indicare che nessun utente è loggato
        // Il ciclo while continuerà finché l'utente non effettua il login o si
        Utente utente = null;

        // Mostra il menu di benvenuto e gestisce le opzioni di login e registrazione
        // Il ciclo continua finché l'utente non effettua il login o si registra
        while (utente == null) {
            System.out.println("\n--- BENVENUTO NELLA BIBLIOTECA ---");
            System.out.println("1. Login");
            System.out.println("2. Registrati");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            String scelta = scanner.nextLine();
            // Gestisce le scelte dell'utente per il login, la registrazione o l'uscita
            // Se l'utente sceglie di uscire, il programma termina
            switch (scelta) {
                case "1":
                    // Chiede all'utente di inserire il nome e la password per il login
                    // Se le credenziali sono corrette, l'utente viene loggato
                    System.out.print("Inserisci nome utente: ");
                    String nomeLogin = scanner.nextLine();
                    System.out.print("Inserisci password: ");
                    String passwordLogin = scanner.nextLine();
                    utente = biblioteca.login(nomeLogin, passwordLogin);
                    if (utente == null) {
                        System.out.println(" Credenziali errate. Riprova.");
                    }
                    break;
                case "2":
                    // Chiede all'utente di inserire un nuovo nome utente e password per la
                    // registrazione
                    // Se il nome utente è già registrato, informa l'utente e chiede
                    // di scegliere un altro nome
                    // Se il nome utente è disponibile, registra il nuovo utente e informa l'utente
                    // che la registrazione è completata
                    System.out.print("Scegli un nome utente: ");
                    String nuovoNome = scanner.nextLine();
                    if (biblioteca.utenti.containsKey(nuovoNome)) {
                        System.out.println(" Questo nome utente è già registrato.");
                        break;
                    }
                    System.out.print("Scegli una password: ");
                    String nuovaPassword = scanner.nextLine();
                    biblioteca.registraUtente(nuovoNome, nuovaPassword);
                    System.out.println(" Registrazione completata. Ora puoi effettuare il login.");
                    break;
                case "0":
                    // Se l'utente sceglie di uscire, stampa un messaggio e termina il programma
                    System.out.println("Uscita dal programma.");
                    System.exit(0);
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        System.out.println(" Login effettuato come " + utente.nome);

        // Aggiunta libri di esempio
        biblioteca.aggiungiLibro(new Libro("Il Signore degli Anelli", "J.R.R. Tolkien"));
        biblioteca.aggiungiLibro(new Libro("1984", "George Orwell"));
        biblioteca.aggiungiLibro(new Libro("Il piccolo principe", "Antoine de Saint-Exupéry"));

        boolean continua = true;

        // Ciclo principale del menu della biblioteca
        // Il ciclo continua finché l'utente non sceglie di uscire
        while (continua) {
            System.out.println("\n--- MENU BIBLIOTECA ---");
            System.out.println("1. Aggiungi un libro");
            System.out.println("2. Mostra tutti i libri");
            System.out.println("3. Cerca un libro");
            System.out.println("4. Prendi in prestito un libro");
            System.out.println("5. Restituisci un libro");
            System.out.println("6. Mostra libri in prestito");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    // Aggiunta di un libro
                    // Chiede all'utente di inserire il titolo e l'autore del libro da aggiungere
                    // Crea un nuovo oggetto Libro e lo aggiunge alla biblioteca
                    System.out.print("Inserisci il titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Inserisci l'autore: ");
                    String autore = scanner.nextLine();
                    biblioteca.aggiungiLibro(new Libro(titolo, autore));
                    System.out.println("Libro aggiunto con successo.");
                    break;
                case 2:
                    // Mostra tutti i libri
                    biblioteca.mostraTuttiILibri();
                    break;
                case 3:
                    // Ricerca di un libro
                    // Chiede all'utente di inserire una parola chiave per cercare un libro
                    System.out.print("Inserisci titolo o autore da cercare: ");
                    String parolaChiave = scanner.nextLine();
                    biblioteca.cerca(parolaChiave);
                    break;
                case 4:
                    // Prendere in prestito un libro
                    // Chiede all'utente di inserire il titolo del libro da prendere in prestito
                    System.out.print("Titolo del libro da prendere in prestito: ");
                    String prestito = scanner.nextLine();
                    biblioteca.prendiInPrestito(prestito, utente);
                    break;
                case 5:
                    // Restituire un libro
                    // Chiede all'utente di inserire il titolo del libro da restituire
                    System.out.print("Titolo del libro da restituire: ");
                    String restituzione = scanner.nextLine();
                    biblioteca.restituisciLibro(restituzione, utente);
                    break;
                case 6:
                    // Mostra i libri presi in prestito dall'utente
                    // Chiama il metodo dell'utente per mostrare i libri in prestito
                    utente.mostraLibriInPrestito();
                    break;
                case 0:
                    // Uscita dal programma
                    continua = false;
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }
}
