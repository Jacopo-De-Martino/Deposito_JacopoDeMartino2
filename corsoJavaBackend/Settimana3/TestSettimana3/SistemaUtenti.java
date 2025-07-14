package corsoJavaBackend.Settimana3.TestSettimana3;

import java.util.List;

interface Osservatore {
    void update(Notifica notifica);
}

// Classe Utente con Attributi e Metodi di Base -> Ossservatore
class Utente implements Osservatore {
    // Attributi dell'utente
    private String name;
    private String password;
    private int id;
    private static int idCounter = 0;

    @Override
    public String toString() {
        return "Utente [name=" + name + ", password=" + password + ", id=" + id + "]";
    }

    public Utente(String name, String password) {
        this.name = name;
        this.password = password;
        idCounter++;
        this.id = idCounter;
    }

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

    @Override
    public void update(Notifica notifica) {
        System.out.println("Notifica per " + name + ": " + notifica.getMessaggio());
    }
}

// Interfaccia Notifica
interface Notifica {
    String getMessaggio();
}

/*
 * Oggetti NOTIFICA
 */
// Classe concreta per Notifica di Login
class MessaggioLogin implements Notifica {
    @Override
    public String getMessaggio() {
        return "Notifica di Login:";
    }
}

// Classe concreta per Notifica di Logout
class MessaggioLogout implements Notifica {
    @Override
    public String getMessaggio() {
        return " Notifica di Logout ";
    }
}

// Classe concreta per Notifica di Registrazione
class MessaggioRegister implements Notifica {
    @Override
    public String getMessaggio() {
        return " Notifica di registrazione : ";
    }
}

/*
 * Factory per le notifiche
 */
// 3. Il Creator (astratto) dichiara il factory method
abstract class Creator {
    // Questo è il Factory Method. Le sottoclassi lo implementeranno.
    protected abstract Notifica factoryMethod();

    public void anOperation() {
        // Usa il veicolo creato dalla sottoclasse
        Notifica n = factoryMethod();
        System.out.println("Creazione di una notifica...");
        n.getMessaggio();
    }
}

// ConcreteCreator implementano il factory method
class CreatorNotificaLogin extends Creator {
    @Override
    protected Notifica factoryMethod() {
        // Questa fabbrica crea solo Auto
        return new MessaggioLogin();
    }
}

// ConcreteCreator implementano il factory method
class CreatorNotificaLogout extends Creator {
    @Override
    protected Notifica factoryMethod() {
        // Questa fabbrica crea solo Auto
        return new MessaggioLogout();
    }
}

// I ConcreteCreator implementano il factory method
class CreatorNotificaRegister extends Creator {
    @Override
    protected Notifica factoryMethod() {
        // Questa fabbrica crea solo Auto
        return new MessaggioRegister();
    }
}

/*
 * Decoratore
 */
// Decorator astratto
abstract class Decorator implements Notifica {
    protected Notifica component;

    public Decorator(Notifica component) {
        this.component = component;
    }

    @Override
    public String getMessaggio() {
        return component.getMessaggio();
    }
}

// Decoratore Concreto
class DecoratorLogin extends Decorator {
    public DecoratorLogin(Notifica component) {
        super(component);
    }

    @Override
    public String getMessaggio() {
        return super.getMessaggio() + "+";
    }
}

// Decoratore Concreto
class DecoratorLogout extends Decorator {
    public DecoratorLogout(Notifica component) {
        super(component);
    }

    @Override
    public String getMessaggio() {
        return super.getMessaggio() + " + " + component.getMessaggio();
    }
}

// Observer[Pattern] Subject
interface Subject {
    void inserisciUtente(Osservatore observer);

    void rimuoviUtente(Osservatore observer);

    void notifyObserversLogin();

    void notifyRegister();

    void notifyLogout();
}

class SocialNetwork implements Subject {
    private List<Osservatore> utenti;

    public List<Osservatore> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Osservatore> utenti) {
        this.utenti = utenti;
    }

    @Override
    public void rimuoviUtente(Osservatore observer) {
        for (Osservatore utente : utenti) {
            if (utenti.contains(observer)) {
                System.out.println("Rimozione utente: " + observer);
                utenti.remove(observer);
            } else {
                System.out.println("Utente non trovato: ");
            }
        }
    }

    @Override
    public void notifyObserversLogin() {
        for (Osservatore observer : utenti) {
            observer.update(new MessaggioLogin());
        }
    }

    @Override
    public void notifyRegister() {
        for (Osservatore observer : utenti) {
            observer.update(new MessaggioRegister());
        }
    }

    @Override
    public void notifyLogout() {
        for (Osservatore observer : utenti) {
            observer.update(new MessaggioLogout());
        }
    }

    @Override
    public void inserisciUtente(Osservatore observer) {
        for (Osservatore utente : utenti) {
            if (!utenti.contains(observer)) {
                System.out.println("Rimozione utente: " + observer);
                utenti.add(observer);
            } else {
                System.out.println("Utente gia registrato: ");
            }
        }
    }
}

// Sistema Utenti con Funzionalità Modulari e Notifiche
public class SistemaUtenti {
    public static void main(String[] args) {

        Utente user1 = new Utente("Alice", "password123");
        System.out.println(user1);

        Creator creatorLogin = new CreatorNotificaLogin();
        creatorLogin.anOperation();
        creatorLogin = new CreatorNotificaLogout();
        creatorLogin.anOperation();
    }

}
