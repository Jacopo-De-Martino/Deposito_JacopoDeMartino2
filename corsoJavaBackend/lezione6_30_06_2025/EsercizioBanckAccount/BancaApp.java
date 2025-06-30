package corsoJavaBackend.lezione6_30_06_2025.EsercizioBanckAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class BancaApp {
    // Lista utenti banca di tipo AccountBank
    static ArrayList<AccountBank> utenti = new ArrayList<>();
    // Scanner per inserimento dati
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {// Con true forzo il ciclo per il menu
            System.out.println("\n1. Registrati\n2. Login\n3. Esci");// Opzioni menu
            String scelta = scanner.nextLine();// Variabile per menu, utilizzo l'imput utente nello switch per guidare
                                               // l'utente

            switch (scelta) {// Inizio Menu
                case "1":
                    registraUtente();// richiamo il metodo Statico registraUtente
                    break;
                case "2":
                    loginUtente();// richiamo il metodo Statico loginUtente
                    break;
                case "3":
                    System.out.println("Arrivederci!");// Uscita dal menu
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    static void registraUtente() {// funzione statica per la registrazione
        // Inserimento dati
        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci password: ");
        String password = scanner.nextLine();

        // Controllo utente già esistente
        for (AccountBank u : utenti) {
            if (u.nome.equals(nome)) {// verifico se fra gli utenti esiste gia un utente con lo stesso nome, se
                                      // l'utente è gia reggistrato blocco l'operazione,
                System.out.println("Utente già registrato!");
                return;
            }
        }
        // se il nome non è presente nella lista degli utenti creo e aggiungo l'utente
        // che si è
        // registrato alla lista
        AccountBank nuovo = new AccountBank(nome, password);
        utenti.add(nuovo);
        System.out.println("Registrazione completata!");
    }

    static void loginUtente() {
        // Inserimento dati utente per login
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // se nella lista trovo un utente con nome e password che corrispondono a quelli
        // inseriti richiamo il metodo menuOperazioni passando l'utente come argomento
        // reale
        for (AccountBank utente : utenti) {
            if (utente.nome.equals(nome) && utente.password.equals(password)) {
                System.out.println("Login riuscito! Benvenuto, " + nome);
                menuOperazioni(utente);
                return;
            }
        }

        System.out.println("Nome o password errati.");
    }

    // Menu per le operazioni
    static void menuOperazioni(AccountBank utente) {
        while (true) {// forzo il ciclo
            // richiesta scelta operazione tramite scanner
            System.out.println("\nOperazioni disponibili:");
            System.out.println("1. Saldo\n2. Versa\n3. Preleva\n4. Logout");
            String scelta = scanner.nextLine();
            // inizio menu
            switch (scelta) {
                case "1":
                    utente.showBalance();
                    break;
                case "2":
                    System.out.print("Quanto vuoi versare? ");
                    double versamento = Double.parseDouble(scanner.nextLine());
                    utente.deposit(versamento);
                    break;
                case "3":
                    System.out.print("Quanto vuoi prelevare? ");
                    double prelievo = Double.parseDouble(scanner.nextLine());
                    utente.withdraw(prelievo);
                    break;
                case "4":// Condizione uscita ciclo
                    System.out.println("Logout eseguito.");
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}

// Classe AccountBank
class AccountBank {
    // Atttributi
    String nome;
    String password;
    double balance = 0;

    public AccountBank(String nome, String password) {
        this.nome = nome;
        this.password = password;
        this.balance = (int) (Math.random() * 10_000_000) + 1;
    }

    // Operazioni Bancarie
    void withdraw(double amount) {
        if (balance < amount) {// Verifico se il saldo è sufficiente per il prelievo
            System.out.println("Operazione non consentita");
            System.out.println("Disponibilità insufficiente");
            System.out.println("Saldo attuale " + this.balance + " - richiesta di prelievo : " + amount);
        } else {// se è sufficente l'utente effettua il prelievo
            System.out.println("Prelievo effettuato con successo");
            System.out.println("Hai prelevato : " + amount);
            System.out.println("Bilancio attuale " + this.balance);
        }
    }

    void deposit(double amount) {
        System.out.println("Hai versato " + amount + " bilancio attuale " + (amount + this.balance));
    }

    void showBalance() {
        System.out.println("Bilancio attuale : " + this.balance);
    }

}
