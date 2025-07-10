package corsoJavaBackend.Settimana2.lezione6_30_06_2025.EsercizioBanckAccount;

class AccountBank {
    // Atttributi
    String accountHolderName;
    String password;
    double balance;

    public AccountBank(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.balance = (int) (Math.random() * 10_000_000) + 1;
    }

    void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Operazione non consentita");
            System.out.println("Disponibilità insufficiente");
            System.out.println("Saldo attuale " + this.balance + " - richiesta di prelievo : " + amount);
        } else {
            balance -= amount;
            System.out.println("Prelievo effettuato con successo");
            System.out.println("Hai prelevato : " + amount);
            System.out.println("Bilancio attuale " + this.balance);
        }
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Hai versato " + amount + " bilancio attuale " + (amount + this.balance));
    }

    void displayBalance() {
        System.out.println("Bilancio attuale : " + this.balance);
    }
}

public class BanckAccount {
    public static void main(String[] args) {

        AccountBank accountBank1 = new AccountBank("Jacopo");
        accountBank1.deposit(1000);
        accountBank1.displayBalance();
        accountBank1.withdraw(1000000);

    }
}
