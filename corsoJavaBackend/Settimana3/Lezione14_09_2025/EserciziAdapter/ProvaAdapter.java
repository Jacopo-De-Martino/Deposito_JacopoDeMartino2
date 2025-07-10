package corsoJavaBackend.Settimana3.Lezione14_09_2025.EserciziAdapter;

// Target interface
interface Target {
    void request();
}

// Adaptee -> Classe da adattare
class Adaptee {
    void specificRequest() {
        System.out.println("Richiesta specifica eseguita.");
    }
}

// Adapter
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

public class ProvaAdapter {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }
}
