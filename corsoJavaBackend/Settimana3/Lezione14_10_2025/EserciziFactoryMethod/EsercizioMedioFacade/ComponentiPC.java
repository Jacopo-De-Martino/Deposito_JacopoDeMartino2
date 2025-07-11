package corsoJavaBackend.Lezione14_09_2025.EserciziFactoryMethod.EsercizioMedioFacade;

import java.util.ArrayList;
import java.util.List;

// --- Interfacce Base ---
/**
 * Interfaccia base per tutti i componenti del sistema.
 */
interface Componente {
}

/**
 * Interfaccia marker per componenti hardware.
 */
interface Hardware {
}

/**
 * Interfaccia marker per componenti software.
 */
interface Software {
}

/**
 * Interfaccia marker per componenti firmware.
 */
interface Firmware {
}

/**
 * Interfaccia che definisce il comportamento di un osservatore nel pattern
 * Observer.
 * I componenti che implementano questa interfaccia possono ricevere
 * aggiornamenti.
 */
interface Osservatore {
    /**
     * Metodo chiamato dal Subject per notificare un aggiornamento.
     *
     * @param messaggio Il messaggio di aggiornamento.
     */
    void update(String messaggio);
}

/**
 * Interfaccia che definisce il comportamento di un Subject nel pattern
 * Observer.
 * I componenti che implementano questa interfaccia possono registrare,
 * rimuovere e notificare osservatori.
 */
interface Subject {
    /**
     * Registra un osservatore al Subject.
     *
     * @param o L'osservatore da registrare.
     */
    void registerObservator(Osservatore o);

    /**
     * Rimuove un osservatore dal Subject.
     *
     * @param o L'osservatore da rimuovere.
     */
    void removeObservator(Osservatore o);

    /**
     * Notifica tutti gli osservatori registrati con un messaggio di aggiornamento.
     *
     * @param aggiornamenti Il messaggio di aggiornamento.
     */
    void notificaOsservatori(String aggiornamenti);
}

/**
 * Interfaccia che definisce le fasi di avvio per i componenti avviabili.
 */
interface Avvio {
    /**
     * Inizializza il componente.
     */
    void inizializza();

    /**
     * Carica il componente.
     */
    void carica();

    /**
     * Avvia il componente.
     */
    void avvia();
}

// --- Implementazioni dei Componenti ---
/**
 * Rappresenta il BIOS (Basic Input/Output System).
 * Implementa Firmware, Avvio, Osservatore e Componente.
 */
class Bios implements Firmware, Avvio, Osservatore, Componente {
    /**
     * Inizializza il BIOS.
     */
    @Override
    public void inizializza() {
        System.out.println("Inizializzazione Bios");
    }

    /**
     * Carica il BIOS.
     */
    @Override
    public void carica() {
        System.out.println("Caricamento Bios");
    }

    /**
     * Avvia il BIOS.
     */
    @Override
    public void avvia() {
        System.out.println("Avvio Bios");
    }

    /**
     * Riceve un messaggio di aggiornamento come osservatore.
     *
     * @param messaggio Il messaggio di aggiornamento.
     */
    @Override
    public void update(String messaggio) {
        System.out.println("Bios da aggiornare " + messaggio);
    }
}

/**
 * Rappresenta il Sistema Operativo.
 * Implementa Software, Avvio, Subject (per notificare altri componenti) e
 * Componente.
 * Utilizza il pattern Singleton per garantire un'unica istanza.
 */
class SistemaOperativo implements Software, Avvio, Subject, Componente {
    private static SistemaOperativo sistemaOperativo; // Istanza Singleton del Sistema Operativo
    private List<Osservatore> componenti; // Lista di osservatori registrati
    private String versione = "12.12.25"; // Versione attuale del Sistema Operativo

    /**
     * Metodo statico per ottenere l'unica istanza del Sistema Operativo
     * (Singleton).
     *
     * @return L'istanza del Sistema Operativo.
     */
    public static SistemaOperativo getSistemaOperativo() {
        if (sistemaOperativo == null) {
            return sistemaOperativo = new SistemaOperativo();
        }
        return sistemaOperativo;
    }

    /**
     * Restituisce la lista dei componenti (osservatori) registrati.
     *
     * @return La lista di Osservatore.
     */
    public List<Osservatore> getComponenti() {
        return componenti;
    }

    /**
     * Imposta la lista dei componenti (osservatori).
     *
     * @param componenti La nuova lista di Osservatore.
     */
    public void setComponenti(List<Osservatore> componenti) {
        this.componenti = componenti;
    }

    /**
     * Restituisce la versione attuale del Sistema Operativo.
     *
     * @return La stringa della versione.
     */
    public String getVersione() {
        return versione;
    }

    /**
     * Imposta la versione del Sistema Operativo e notifica gli osservatori.
     *
     * @param versione La nuova versione.
     */
    public void setVersione(String versione) {
        this.versione = versione;
        notificaOsservatori("Sistema operativo aggiornato : " + versione);
    }

    /**
     * Costruttore privato per il pattern Singleton.
     * Inizializza la lista dei componenti.
     */
    private SistemaOperativo() {
        componenti = new ArrayList<>();
    }

    /**
     * Inizializza il Sistema Operativo.
     */
    @Override
    public void inizializza() {
        System.out.println("Inizializzazione Sistema operativo");
    }

    /**
     * Carica il Sistema Operativo.
     */
    @Override
    public void carica() {
        System.out.println("Caricamento Sistema operativo");
    }

    /**
     * Avvia il Sistema Operativo.
     */
    @Override
    public void avvia() {
        System.out.println("Avvio Sistema operativo");
    }

    /**
     * Registra un osservatore alla lista dei componenti.
     *
     * @param o L'osservatore da registrare.
     */
    @Override
    public void registerObservator(Osservatore o) {
        componenti.add(o);
    }

    /**
     * Rimuove un osservatore dalla lista dei componenti (attualmente non
     * implementato).
     *
     * @param o L'osservatore da rimuovere.
     */
    @Override
    public void removeObservator(Osservatore o) {
        // Implementazione per rimuovere un osservatore se necessario
    }

    /**
     * Notifica tutti gli osservatori registrati con il messaggio di aggiornamento.
     *
     * @param aggiornamenti Il messaggio di aggiornamento.
     */
    @Override
    public void notificaOsservatori(String aggiornamenti) {
        for (Osservatore o : componenti) {
            o.update(aggiornamenti);
        }
    }
}

/**
 * Rappresenta l'Hard Disk.
 * Implementa Hardware, Avvio, Osservatore e Componente.
 */
class HardDisk implements Hardware, Avvio, Osservatore, Componente {
    /**
     * Inizializza l'Hard Disk.
     */
    @Override
    public void inizializza() {
        System.out.println("Inizializzazione Hard disk");
    }

    /**
     * Carica l'Hard Disk.
     */
    @Override
    public void carica() {
        System.out.println("Caricamento Hard disk");
    }

    /**
     * Avvia l'Hard Disk.
     */
    @Override
    public void avvia() {
        System.out.println("Avvio Hard disk");
    }

    /**
     * Riceve un messaggio di aggiornamento come osservatore.
     *
     * @param messaggio Il messaggio di aggiornamento.
     */
    @Override
    public void update(String messaggio) {
        System.out.println("Hard disk da aggiornare " + messaggio);
    }
}