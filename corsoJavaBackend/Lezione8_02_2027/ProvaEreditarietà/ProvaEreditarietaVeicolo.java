package corsoJavaBackend.Lezione8_02_2027.ProvaEreditarietà;

//Classe genitore
class Veicolo {
    // metodo che verrà ereditato da tutte le classi figlie
    void run() {
        System.out.println("Il veicolo è in marcia");
    }
}

class Bike1 extends Veicolo {
    // Eredita il metodo del padre se non specifichiamo comportamenti differenti
    // gli oggetti di tipo Bike1 utilizzeranno il metodo run() definito nella classe
    // padre se non sovrascritto
}

class Bike2 extends Veicolo {
    // Specializziamo il metodo del padre per gli oggetti di tipo Bike2
    void run() {
        System.out.println("Bike 2 è in marcia");
    }
}

public class ProvaEreditarietaVeicolo {
    public static void main(String[] args) {
        // Instanzio 3 oggetti veicolo di tipi diversi Bike1, Bike2 , Veicolo
        Veicolo bici1 = new Bike1();
        Veicolo bici2 = new Bike2();
        Veicolo veicolo = new Veicolo();
        // Testo il metodo run su questi Oggetti
        bici1.run();
        bici2.run();
        veicolo.run();
    }
}
