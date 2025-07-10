package corsoJavaBackend.Lezione14_09_2025.EserciziFactoryMethod.EsercizioMedioFacade;

// --- Interfacce del Pattern Strategy ---
/**
 * Interfaccia base per il pattern Facade.
 * Definisce un metodo generico per l'esecuzione.
 */
interface Facade {
    /**
     * Esegue l'operazione principale definita dalla Facade.
     */
    void esegui();
}

/**
 * Interfaccia che definisce la strategia di avvio del sistema.
 * Permette di cambiare il comportamento di avvio dinamicamente (Pattern
 * Strategy).
 */
interface AvvioStrategy {
    /**
     * Definisce la sequenza di avvio dei componenti.
     *
     * @param bios             Il componente Bios.
     * @param hardDisk         Il componente HardDisk.
     * @param sistemaOperativo Il componente SistemaOperativo.
     */
    void sequenzaDiAvvio(Bios bios, HardDisk hardDisk, SistemaOperativo sistemaOperativo);
}

/**
 * Implementazione di una strategia di avvio normale.
 * I componenti vengono inizializzati, caricati e avviati in un ordine standard.
 */
class AvvioNormaleStrategy implements AvvioStrategy {
    @Override
    public void sequenzaDiAvvio(Bios bios, HardDisk hardDisk, SistemaOperativo sistemaOperativo) {
        System.out.println("--- Avvio Normale in corso ---");
        bios.inizializza();
        bios.carica();
        bios.avvia();

        hardDisk.inizializza();
        hardDisk.carica();
        hardDisk.avvia();

        sistemaOperativo.inizializza();
        sistemaOperativo.carica();
        sistemaOperativo.avvia();
        System.out.println("--- Avvio Normale completato ---");
    }
}

// --- Implementazione della Facade ---
/**
 * Implementa il pattern Facade per semplificare l'interazione con il
 * sottosistema di avvio del computer.
 * Nasconde la complessità delle operazioni di avvio dei singoli componenti
 * (BIOS, Hard Disk, Sistema Operativo).
 * Utilizza il pattern Singleton per garantire un'unica istanza.
 * Incorpora il pattern Strategy per permettere diverse sequenze di avvio.
 */
class AvvioFacade implements Facade {
    private static AvvioFacade avvioFacade; // Istanza Singleton della Facade
    private AvvioStrategy strategiaDiAvvio; // Strategia di avvio corrente

    // Istanzia i componenti del sottosistema
    HardDisk hardDisk = new HardDisk();
    SistemaOperativo sistemaOperativo = SistemaOperativo.getSistemaOperativo(); // Ottiene l'istanza Singleton del SO
    Bios bios = new Bios();

    /**
     * Metodo statico per ottenere l'unica istanza di AvvioFacade (Singleton).
     *
     * @return L'istanza di AvvioFacade.
     */
    public static AvvioFacade getAvvioFacade() {
        if (avvioFacade == null) {
            return avvioFacade = new AvvioFacade();
        }
        return avvioFacade;
    }

    /**
     * Aggiorna la versione del Sistema Operativo.
     * Questa operazione è esposta dalla Facade per un accesso semplificato.
     *
     * @param versione La nuova versione del Sistema Operativo.
     */
    public void aggiornaSistemaOperativo(String versione) {
        sistemaOperativo.setVersione(versione);
    }

    /**
     * Configura le relazioni di osservazione tra il Sistema Operativo e altri
     * componenti.
     * Il BIOS e l'Hard Disk si registrano come osservatori del Sistema Operativo.
     */
    public void configura() {
        sistemaOperativo.registerObservator(bios);
        sistemaOperativo.registerObservator(hardDisk);
    }

    /**
     * Costruttore privato per il pattern Singleton.
     * Inizializza la strategia di avvio di default.
     */
    private AvvioFacade() {
        // Imposta una strategia di default per l'avvio normale
        this.strategiaDiAvvio = new AvvioNormaleStrategy();
    }

    /**
     * Imposta dinamicamente la strategia di avvio.
     * Permette di cambiare il comportamento di avvio del sistema.
     *
     * @param strategia La strategia di avvio da utilizzare.
     */
    public void setStrategiaDiAvvio(AvvioStrategy strategia) {
        this.strategiaDiAvvio = strategia;
    }

    /**
     * Esegue la sequenza di avvio delegando alla strategia di avvio configurata.
     * La Facade non si preoccupa dei dettagli dell'avvio, ma delega alla strategia.
     */
    @Override
    public void esegui() {
        // La facade non conosce i dettagli, delega alla strategia!
        strategiaDiAvvio.sequenzaDiAvvio(bios, hardDisk, sistemaOperativo);
    }
}