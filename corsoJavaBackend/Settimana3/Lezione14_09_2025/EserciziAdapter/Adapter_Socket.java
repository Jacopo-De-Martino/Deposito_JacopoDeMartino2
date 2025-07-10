package corsoJavaBackend.Settimana3.Lezione14_09_2025.EserciziAdapter;

// Classe Adapter che permette di usare una presa americana come se fosse europea
public class Adapter_Socket implements EuropeanSocket {
    // Riferimento alla presa americana da adattare
    private AmericanSocket americanSocket;

    // Implementazione del metodo dell'interfaccia EuropeanSocket
    @Override
    public void giveElectricity() {
        // Quando viene richiesta elettricità "all'europea", la fornisce tramite la
        // presa americana
        americanSocket.provideElectricity();
    }

    // Costruttore: riceve la presa americana da adattare
    public Adapter_Socket(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }
}