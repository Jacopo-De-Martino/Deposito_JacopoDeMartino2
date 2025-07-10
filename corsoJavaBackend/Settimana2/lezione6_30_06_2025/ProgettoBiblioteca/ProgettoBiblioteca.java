package corsoJavaBackend.Settimana2.lezione6_30_06_2025.ProgettoBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

// todo genstione più utenti e login per accedere alla biblioteca
// todo gestione penalita per tempo di prestito scaduto
class Book {
    // Attributi
    String title;
    String author;
    boolean isAvailable = true;

    // Metodo per stampare le informazioni del libro
    void displayBookInfo() {
        System.out.println("Titolo :" + title + " Autore : " + author + " disponibile : " + isAvailable);
    }

    // costruttore per inizializzare gli attributi title e author
    // e impostare isAvailable a true
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    // Collezione di libri della biblioteca
    ArrayList<Book> books = new ArrayList<>();

    // Metodo per aggiungere un libro alla biblioteca
    void addBook(Book book) {
        books.add(book);
    }

    // Metodo per stampare le informazioni di tutti i libri della biblioteca
    void displayBookInfo() {
        for (Book book : books) {
            System.out.println(
                    "Titolo: " + book.title + " | Autore: " + book.author + " | Disponibile: "
                            + (book.isAvailable ? "Sì" : "No"));
        }
    }

    // Metodo che permette di prendere un prestito un libro ad un utente
    void borrowBook(String title, User user) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isAvailable) {
                if (user.libriPresiInPrestito.size() >= 3) {
                    System.out.println("Hai già preso in prestito 3 libri.");
                    return;
                }
                book.isAvailable = false;
                user.libriPresiInPrestito.add(book);
                System.out.println(user.name + " ha preso in prestito: " + book.title);
                return;
            }
        }
        System.out.println("Libro non disponibile o non trovato.");
    }

    // Metodo che permette di restituire un libro
    void returnBook(String title, User user) {
        for (Book book : user.libriPresiInPrestito) {
            if (book.title.equalsIgnoreCase(title)) {
                book.isAvailable = true;
                user.libriPresiInPrestito.remove(book);
                System.out.println(user.name + " ha restituito: " + book.title);
                return;
            }
        }
        System.out.println("Il libro non è stato trovato tra quelli presi in prestito da " + user.name);
    }

    // Metodo ricerca per titolo o autore
    void search(String keyWord) {
        System.out.println("Risultati della ricerca:");
        boolean found = false;
        for (Book book : books) {// ciclo i libri e verifico se la parola chiave inserita corrisponde al titolo
                                 // o a l'autore di uno o più libri della libreria
            if (book.title.equalsIgnoreCase(keyWord) || book.author.equalsIgnoreCase(keyWord)) {
                book.displayBookInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nessun libro trovato con: " + keyWord);
        }
    }
}

class User {
    String name;
    String password;
    ArrayList<Book> libriPresiInPrestito = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.name = password;
    }

    void mostraLibriPresiInPrestito() {
        if (libriPresiInPrestito.isEmpty()) {
            System.out.println(name + " non ha libri in prestito.");
        } else {
            System.out.println("Libri in prestito da " + name + ":");
            for (Book book : libriPresiInPrestito) {
                book.displayBookInfo();
            }
        }
    }
}

public class ProgettoBiblioteca {
    public static void main(String[] args) {
        // instanzio un oggetto di tipo --> per catturare imput utente.
        Scanner scanner = new Scanner(System.in);
        // istanzio un oggetto di tipo Library per usare i suoi metodi
        Library myLibrary = new Library();
        User utente = new User("Mario", "Password");

        // Aggiunta libri di esempio
        myLibrary.addBook(new Book("Il Signore degli Anelli", "J.R.R. Tolkien"));
        myLibrary.addBook(new Book("1984", "George Orwell"));
        myLibrary.addBook(new Book("Il piccolo principe", "Antoine de Saint-Exupéry"));

        boolean continua = true;

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
                    System.out.print("Inserisci il titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Inserisci l'autore: ");
                    String autore = scanner.nextLine();
                    myLibrary.addBook(new Book(titolo, autore));
                    System.out.println("Libro aggiunto con successo.");
                    break;

                case 2:
                    // Mostra tutti i libri
                    myLibrary.displayBookInfo();
                    break;

                case 3:
                    // Ricerca di un libro
                    System.out.print("Inserisci titolo o autore da cercare: ");
                    String keyword = scanner.nextLine();
                    myLibrary.search(keyword);
                    break;

                case 4:
                    // Prendere in prestito un libro
                    System.out.print("Titolo del libro da prendere in prestito: ");
                    String titoloPrestito = scanner.nextLine();
                    myLibrary.borrowBook(titoloPrestito, utente);
                    break;

                case 5:
                    // Restituire un libro
                    System.out.print("Titolo del libro da restituire: ");
                    String titoloRestituzione = scanner.nextLine();
                    myLibrary.returnBook(titoloRestituzione, utente);
                    break;

                case 6:
                    // Mostra i libri presi in prestito dall'utente
                    utente.mostraLibriPresiInPrestito();
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

    // REQUISITI BASE:
    // Classe book
    // !Attributi:
    /*
     * title String
     * author String
     * isAvailable boolean
     */
    // ! Metodi
    /*
     * void displayBookInfo() -> Mostra info libro
     */

    // Classe Library:
    // ! Attributi
    /*
     * ArrayList<Book> books → Una lista dinamica di libri.
     */

    // ! Metodi
    /*
     * Metodo void addBook(Book book) → Aggiunge un libro alla biblioteca.
     * 
     * Metodo void displayBooks() → Mostra tutti i libri presenti nella biblioteca.
     * 
     * Metodo void borrowBook(String title) → Permette di prendere in prestito un
     * libro
     * (solo se disponibile).
     */
}
