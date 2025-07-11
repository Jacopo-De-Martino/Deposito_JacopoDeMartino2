package corsoJavaBackend.Settimana3.Lezione15_11_07_2025;

// =====================
// PATTERN: FACADE
// =====================
// Il Facade semplifica l'accesso al sottosistema di gestione utenti.
// Espone metodi semplici per il client e delega le operazioni all'interfaccia UserManagement.
class Facade_GestoreUtenti {
    // Dipendenza dal sottosistema (UserManagement, che può essere un Adapter o
    // Decorator)
    private UserManagement userManagement;

    // Costruttore: riceve una strategia/concretezza di UserManagement (es. Adapter,
    // Decorator)
    public Facade_GestoreUtenti(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    // Metodo semplificato per aggiungere un utente
    public User facadeAddUser(String name) {
        return userManagement.createUser(name);
    }

    // Metodo semplificato per rimuovere un utente
    public boolean facadeRemoveUser(User user) {
        return userManagement.deleteUser(user);
    }

    // Metodo semplificato per cercare un utente
    public User facadeSearchUser(String name) {
        return userManagement.findUser(name);
    }
}