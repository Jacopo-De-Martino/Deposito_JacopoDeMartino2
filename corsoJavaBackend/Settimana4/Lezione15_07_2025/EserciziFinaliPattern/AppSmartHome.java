package corsoJavaBackend.Settimana4.Lezione15_07_2025.EserciziFinaliPattern;

import java.util.ArrayList;
import java.util.List;

// 
// OBSERVER: Notifica cambiamenti ai dispositivi
// 

// Interfaccia Observer: ogni dispositivo che vuole ricevere notifiche implementa questo
interface Observer {
    void update(String messaggio);
}

// Interfaccia Subject: che gestisce la lista di dispositivi e invia notifiche
// in base agli eventi/cambiamenti
// che avvengono nella smart home
interface Subject {
    void addObserver(Observer o); // Metodo per aggiungere un osservatore

    void removeObserver(Observer o); // Metodo per rimuovere un osservatore

    void notifyObservers(String messaggio); // Metodo per notificare tutti gli osservatori
}

// Centrale Smart Home (Subject): gestisce i dispositivi e notifica i
// cambiamenti
// implementa l'interfaccia Subject
class SmartHomeCentral implements Subject {
    private List<Observer> observers = new ArrayList<>(); // Lista degli Osservatori -> Oggetti che implementano
                                                          // l'interfaccia Observer interfaccia Observer

    @Override
    public void addObserver(Observer o) { // Metodo per aggiungere un Osservatore alla lista observers
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) { // Metodo per rimuovere un Osservatore dalla lista observers
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String messaggio) { // Metodo per stampare le notifiche ricevute dagli observers viene
                                                    // richiamato dal metodo evento() -> Metodo
                                                    // effettivo per inviare i cambiamenti
                                                    // della SmartHome
        for (Observer o : observers) {
            o.update(messaggio);
        }
    }

    // Metodo che "registra" e notifica i cambiamenti nella casa
    public void evento(String messaggio) {
        System.out.println("SmartHome Evento: " + messaggio);
        notifyObservers(messaggio);
    }
}

// Dispositivi compatibili -> Implementano Observer
// Sensore di movimento
class SensoreMovimento implements Observer {
    private String nome; // Attributo nome

    public SensoreMovimento(String nome) { // Costruttore
        this.nome = nome;
    }

    @Override
    public void update(String messaggio) { // Metodo update per "notificare" il sensore se scatta il metodo Evento della
                                           // SmartHome viene richiamato
        System.out.println(nome + " riceve notifica: " + messaggio);
    }
}

// Luce smart -> Rifarsi ai commenti di sensore di movimento
class LuceSmart implements Observer {
    private String nome;

    public LuceSmart(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String messaggio) {
        System.out.println(nome + " riceve notifica: " + messaggio);
    }
}

// ADAPTER: Adatta dispositivi di produttori diversi
// Dispositivo di terze parti con interfaccia diversa
class NoNativeAlarm {
    private String id;

    public NoNativeAlarm(String id) {
        this.id = id;
    }

    // Metodo diverso da Observer
    public void riceviSegnale(String msg) { // Equivale al metodo update -> va adattato attraverso al AllarmAdapter
        System.out.println("Allarme esterno " + id + " riceve segnale: " + msg);
    }
}

// Adapter: permette a NoNativeAlarm di funzionare come Observer -> Observer
// Funge da "Interfaccia Target"
class AlarmAdapter implements Observer {
    private NoNativeAlarm alarm;

    public AlarmAdapter(NoNativeAlarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void update(String messaggio) {
        alarm.riceviSegnale(messaggio);
    }
}

//
// MAIN: Demo Smart Home Observer + Adapter
//
public class AppSmartHome {
    public static void main(String[] args) {
        // Creo la centrale smart home (Subject)
        SmartHomeCentral centralina = new SmartHomeCentral();

        // Creo dispositivi nativi
        SensoreMovimento sensore = new SensoreMovimento("Sensore Movimento 1");
        LuceSmart luce = new LuceSmart("Luce Soggiorno");

        // Creo un dispositivo di terze parti e lo adatto
        NoNativeAlarm allarmeEsterno = new NoNativeAlarm("AlarmX");
        AlarmAdapter allarmeAdattato = new AlarmAdapter(allarmeEsterno);

        // Registro i dispositivi alla centrale
        centralina.addObserver(sensore);
        centralina.addObserver(luce);
        centralina.addObserver(allarmeAdattato);

        // Simulo eventi nella smart home tramite sensori
        centralina.evento("Movimento rilevato in soggiorno");
        centralina.evento("Luce accesa in cucina");
        centralina.evento("Allarme attivato");
    }
}