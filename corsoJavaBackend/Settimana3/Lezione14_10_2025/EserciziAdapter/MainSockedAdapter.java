package corsoJavaBackend.Settimana3.Lezione14_10_2025.EserciziAdapter;

public class MainSockedAdapter {
    // Classe principale per testare l'adapter tra prese americane ed europee

    public static void main(String[] args) {
        // Creo una presa americana
        AmericanSocket aSocket = new AmericanSocket();
        // Creo un adattatore che permette di usare la presa americana come se fosse
        // europea
        EuropeanSocket adapterSocket = new Adapter_Socket(aSocket);
        // Uso la presa europea (in realtà è la presa americana adattata)
        adapterSocket.giveElectricity();

    }
}
