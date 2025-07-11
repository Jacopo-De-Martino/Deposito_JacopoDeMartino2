package corsoJavaBackend.Settimana3.Lezione15_11_07_2025;

// =====================
// PATTERN: FACTORY
// =====================

// Classe User semplice, rappresenta il dominio utente
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "'}";
    }
}

// Interfaccia Factory: definisce la creazione di utenti
interface Factory {
    User createUser(String name);

    void anOperation();
}

// Factory astratta: implementa un metodo generico e delega la creazione
// concreta
abstract class UserFactory implements Factory {
    public abstract User createUser(String name);

    @Override
    public void anOperation() {
        User user = createUser("DefaultName");
        System.out.println("User created: " + user);
    }
}

// Factory concreta: crea effettivamente un oggetto User
class UserFactoryImpl extends UserFactory {
    @Override
    public User createUser(String name) {
        return new User(name);
    }
}