package corsoJavaBackend.Lezione14_09_2025.EserciziFactoryMethod.EsercizioMedioFacade;

/**
 * Classe principale per dimostrare l'utilizzo del pattern Facade
 * per l'accensione di un computer e la gestione delle strategie di avvio.
 */
public class MainAccendiComputer {
    /**
     * Metodo principale di esecuzione del programma.
     *
     * @param args Argomenti della riga di comando (non utilizzati).
     */
    public static void main(String[] args) {
        // Ottiene l'unica istanza della Facade di Avvio (Singleton)
        AvvioFacade accendiPc = AvvioFacade.getAvvioFacade();

        // Configura le dipendenze tra i componenti (es. il SO notifica BIOS e Hard
        // Disk)
        accendiPc.configura();

        // Esegue un'operazione complessa attraverso la Facade: aggiorna la versione del
        // Sistema Operativo.
        // Questo a sua volta notificherà gli osservatori registrati (BIOS e Hard Disk).
        accendiPc.aggiornaSistemaOperativo("18.12.33");

        System.out.println("\n--- ESECUZIONE AVVIO NORMALE ---");
        // Esegue la sequenza di avvio predefinita (Avvio NormaleStrategy)
        accendiPc.esegui();

        System.out.println("\nRI-AVVIO IN MODALITÀ PROVVISORIA...");
        // Cambia dinamicamente la strategia di avvio utilizzando setStrategiaDiAvvio.
        // Ora, la prossima volta che eseguiamo la Facade, userà la logica di
        // AvvioProvvisorioStrategy.
        accendiPc.setStrategiaDiAvvio(new AvvioProvvisorioStrategy());

        // Esegue nuovamente la sequenza di avvio, ma questa volta in modalità
        // provvisoria
        accendiPc.esegui();
    }
}