package corsoJavaBackend.lezione12_08_07_2025.Esericizi.EsercizioFacile;

import java.util.ArrayList;
import java.util.List;

// Interfaccia Display
interface Display {
    void update(float temp); // update temp

    void update(String nome); // update nome
}

// Interfaccia Subject
interface Subject {
    void registerDisplay(Display observer); // metodo per aggiungere Display(Observer) nella stazione meteo

    void removeDisplay(Display observer); // metodo per rimuove Display(Observer) nella stazione meteo

    void notifyDisplays();// Metodo per stampare tutti i cambi di stato durante il corso del programma
}

// Subject
class StazioneMeteo implements Subject {// Classe concreta che implementa l'interfaccia Subject
    private List<Display> displayTemps = new ArrayList<>();// ArrayList di Display(Observer)
    private float temp;// Attributo privato temp osservato dagli observer(Display)
    private String nome;// Attributo privato nome osservato dagli observer(Display)

    public StazioneMeteo(String nome) {// Costruttore
        this.nome = nome;
    }

    // getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        notifyDisplays();// metodo per che stampa le modifiche intercettate durante il corso del
                         // programma
    }

    public List<Display> getDisplayTemps() {
        return displayTemps;
    }

    public void setDisplayTemps(List<Display> displayTemps) {
        this.displayTemps = displayTemps;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
        notifyDisplays();// Metodo che stampa le modifiche intercettate durante il corso del programma
    }

    @Override // Metodo de l'interfaccia Subject specializzato per aggiungere alla lista
    // displayTemps uno o più observer
    public void registerDisplay(Display observer) {
        displayTemps.add(observer);
    }

    @Override // Metodo de l'interfaccia Subject specializzato per rimuovere dalla lista
    // displayTemps uno o più observer
    public void removeDisplay(Display observer) {
        displayTemps.remove(observer);
    }

    @Override
    public void notifyDisplays() {// Metodo per stampare gli aggiornamenti
        System.out.println("Aggiornamenti Stazione meteo : " + nome);
        for (Display observer : displayTemps) {
            observer.update(temp); // Chiama il metodo update() di ogni osservatore registrato
            // observer.update(nome); // Chiama il metodo update() di ogni osservatore
            // registrato
        }
    }

}

// Display
class TempDisplay implements Display {// Oggetto concreto TempDisplay
    private String name; // Un nome per identificare l'osservatore

    public TempDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float temp) { // stampa la notifica di aggiornamento per la temp
        // Questa è l'azione specifica che l'osservatore intraprende quando riceve una
        // notifica
        System.out.println(name + " temperatura aggiornata : " + temp);
    }

    public void update(String nome) {// stampa la notifica di aggiornamento per il nome
        // Questa è l'azione specifica che l'osservatore intraprende quando riceve una
        // notifica
        System.out.println(name + " nome aggiornato : " + nome);
    }
}
