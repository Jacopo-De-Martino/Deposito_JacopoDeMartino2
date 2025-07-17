package corsoJavaBackend.Settimana3.Lezione14_10_2025.EserciziFactoryMethod.EsercizioMedioFacade;

/**
 * Interfaccia che definisce le fasi generiche di avvio per qualsiasi componente
 * avviabile.
 * Ogni componente che può essere "avviato" dovrebbe implementare questi metodi.
 */
interface Avvio {
    /**
     * Esegue l'inizializzazione del componente.
     */
    void inizializza();

    /**
     * Carica le risorse necessarie al componente.
     */
    void carica();

    /**
     * Avvia il funzionamento del componente.
     */
    void avvia();
}

// --- Pattern Strategy per l'Avvio ---
/**
 * Interfaccia che definisce l'algoritmo (strategia) per la sequenza di avvio
 * del sistema.
 * Permette di cambiare dinamicamente il modo in cui i componenti vengono
 * avviati.
 */
interface AvvioStrategy {
    /**
     * Definisce la sequenza specifica di avvio dei componenti principali del
     * sistema.
     */
    void sequenzaDiAvvio(Bios bios, HardDisk hardDisk, SistemaOperativo os);
}

/**
 * Implementazione della strategia per un avvio normale del sistema.
 * Tutti i componenti essenziali vengono avviati nella sequenza tipica.
 */
class AvvioNormaleStrategy implements AvvioStrategy {
    @Override
    public void sequenzaDiAvvio(Bios bios, HardDisk hardDisk, SistemaOperativo os) {
        System.out.println("--- ESEGUO AVVIO NORMALE ---");
        // Esegue le operazioni di avvio per ogni componente
        bios.avvia();
        hardDisk.avvia();
        os.avvia();
    }
}

/**
 * Implementazione della strategia per un avvio in modalità provvisoria.
 * Questa modalità carica solo i componenti essenziali per il funzionamento
 * minimo del sistema.
 */
class AvvioProvvisorioStrategy implements AvvioStrategy {
    @Override
    public void sequenzaDiAvvio(Bios bios, HardDisk hardDisk, SistemaOperativo os) {
        System.out.println("--- ESEGUO AVVIO IN MODALITÀ PROVVISORIA ---");
        System.out.println("Carico solo i componenti essenziali...");
        // In modalità provvisoria, alcune fasi o componenti possono essere saltati
        bios.avvia(); // Il BIOS è sempre fondamentale
        os.inizializza(); // Solo l'inizializzazione del SO
        os.avvia(); // E l'avvio essenziale del SO
        // L'Hard Disk completo potrebbe non essere avviato o solo parzialmente
    }
}