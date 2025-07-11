package corsoJavaBackend.Settimana3.Lezione15_11_07_2025;

// =====================
// PATTERN: ADAPTER & DECORATOR
// =====================

// Interfaccia Target: definisce le operazioni che il client si aspetta
interface UserManagement {
    User createUser(String name);

    boolean deleteUser(User user);

    User findUser(String name);
}

// Classe legacy (Adaptee): implementazione esistente che vogliamo adattare
class LegacyUserSystem {
    User addUser(String name) {
        System.out.println("User aggiunto nel sistema : " + name);
        return new User(name);
    }

    boolean removeUser(User user) {
        System.out.println("User rimosso dal sistema : " + user.getName());
        return true;
    }

    User searchUser(String name) {
        System.out.println("User trovato in legacy system: " + name);
        return new User(name);
    }
}

// Adapter: adatta LegacyUserSystem all'interfaccia UserManagement
class UserManagementAdapter implements UserManagement {
    private LegacyUserSystem legacyUserSystem;

    public UserManagementAdapter(LegacyUserSystem legacyUserSystem) {
        this.legacyUserSystem = legacyUserSystem;
    }

    @Override
    public User createUser(String name) {
        return legacyUserSystem.addUser(name);
    }

    @Override
    public boolean deleteUser(User user) {
        return legacyUserSystem.removeUser(user);
    }

    @Override
    public User findUser(String name) {
        return legacyUserSystem.searchUser(name);
    }
}

// Decorator astratto: permette di estendere UserManagement senza modificarlo
abstract class UserManagementDecorator implements UserManagement {
    protected UserManagement userManagement;

    public UserManagementDecorator(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    @Override
    public User createUser(String name) {
        return userManagement.createUser(name);
    }

    @Override
    public boolean deleteUser(User user) {
        return userManagement.deleteUser(user);
    }

    @Override
    public User findUser(String name) {
        return userManagement.findUser(name);
    }
}

// Decorator concreto: aggiunge logging alle operazioni di UserManagement
class LoggingUserManagementDecorator extends UserManagementDecorator {
    public LoggingUserManagementDecorator(UserManagement userManagement) {
        super(userManagement);
    }

    @Override
    public User createUser(String name) {
        System.out.println("Logging: Creating user with name: " + name);
        return super.createUser(name);
    }

    @Override
    public boolean deleteUser(User user) {
        System.out.println("Logging: Deleting user with name: " + user.getName());
        return super.deleteUser(user);
    }

    @Override
    public User findUser(String name) {
        System.out.println("Logging: Finding user with name: " + name);
        return super.findUser(name);
    }
}
