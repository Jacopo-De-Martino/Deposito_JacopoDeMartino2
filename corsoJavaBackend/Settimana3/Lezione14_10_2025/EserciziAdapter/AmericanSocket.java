package corsoJavaBackend.Settimana3.Lezione14_09_2025.EserciziAdapter;

// Classe che rappresenta una presa americana
public class AmericanSocket implements Socket {
    // Metodo che fornisce elettricità (specifico della presa americana)
    void provideElectricity() {
        System.out.println("American Socket : fornisce elettricità");
    }

    // Implementazione del metodo dell'interfaccia Socket
    @Override
    public void insertSocket() {
        System.out.println("Hai inserito American Socket");
    }
}