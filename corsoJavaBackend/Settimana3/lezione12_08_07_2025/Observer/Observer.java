package corsoJavaBackend.Settimana3.lezione12_08_07_2025.Observer;

import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
    void update(String message);
}

// Interfaccia Subject
interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers(); // Quando lo stato cambia, notifica!
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state); // Chiama il metodo update() di ogni osservatore registrato
        }
    }
}

// ConcreteObserver
class ConcreteObserver implements Observer {
    private String name; // Un nome per identificare l'osservatore

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        // Questa è l'azione specifica che l'osservatore intraprende quando riceve una
        // notifica
        System.out.println(name + " ha ricevuto aggiornamento: " + message);
    }
}
