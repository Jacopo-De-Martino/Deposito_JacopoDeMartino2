package corsoJavaBackend.Settimana3.Lezione15_11_07_2025;

// =====================
// MAIN: Uso dei pattern insieme
// =====================
public class MainAdapterGestoreUtenti {
    public static void main(String[] args) {
        // Uso Factory per creare utenti
        Factory factory = new UserFactoryImpl();
        User user1 = factory.createUser("Mario Rossi");
        User user2 = factory.createUser("Luca Bianchi");

        // Adapter e Facade
        LegacyUserSystem legacySystem = new LegacyUserSystem();
        UserManagement userManagement = new UserManagementAdapter(legacySystem);

        // Decorator per logging
        userManagement = new LoggingUserManagementDecorator(userManagement);

        // Facade per semplificare l'accesso al sottosistema
        Facade_GestoreUtenti gestore = new Facade_GestoreUtenti(userManagement);

        // Uso del Facade
        gestore.facadeAddUser(user1.getName());
        gestore.facadeAddUser(user2.getName());
        gestore.facadeSearchUser(user1.getName());
        gestore.facadeRemoveUser(user1);
    }
}