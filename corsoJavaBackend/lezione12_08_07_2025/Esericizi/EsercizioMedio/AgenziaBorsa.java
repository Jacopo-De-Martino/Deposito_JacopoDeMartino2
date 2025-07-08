package corsoJavaBackend.lezione12_08_07_2025.Esericizi.EsercizioMedio;

import java.util.ArrayList;
import java.util.List;

// Il Subject "AgenziaBorsa" (Potenzialmente Singleton)
public class AgenziaBorsa { // Non implementa Subject per ora, lo gestiamo internamente
    // Singleton
    private static AgenziaBorsa instance;

    private AgenziaBorsa() {
        // Costruttore privato per il Singleton
    }

    public static AgenziaBorsa getInstance() {
        if (instance == null) {
            instance = new AgenziaBorsa();
        }
        return instance;
    }

    // Lista di investitori registrati (sono gli Observer!)
    private List<Investitore> investitoriRegistrati = new ArrayList<>();
    // Attributi per lo stato che cambia
    private String azioneCorrente;
    private double valoreCorrente;

    // Metodi per la gestione degli investitori (Observer)
    public void aggiungiInvestitore(Investitore inv) {
        investitoriRegistrati.add(inv);
        System.out.println(inv.getNome() + " registrato all'agenzia.");
    }

    public void rimuoviInvestitore(Investitore inv) {
        investitoriRegistrati.remove(inv);
        System.out.println(inv.getNome() + " rimosso dall'agenzia.");
    }

    // Metodo per notificare gli investitori (Il notifyObservers)
    public void notificaInvestitori() { // Nome cambiato per chiarezza con la traccia
        System.out.println("\n--- NOTIFICA AGENZIA BORSA ---");
        for (Investitore inv : investitoriRegistrati) {
            inv.notifica(azioneCorrente, valoreCorrente); // Chiama il metodo notifica dell'Investitore
        }
        System.out.println("-------------------------------\n");
    }

    // Metodo per aggiornare il valore dell'azione e notificare
    public void aggiornaValoreAzione(String nomeAzione, double nuovoValore) {
        this.azioneCorrente = nomeAzione;
        this.valoreCorrente = nuovoValore;
        System.out.println("\n*** AGENZIA BORSA: Valore " + nomeAzione + " aggiornato a " + nuovoValore + " ***");
        notificaInvestitori(); // Notifica gli investitori dopo l'aggiornamento
    }
}