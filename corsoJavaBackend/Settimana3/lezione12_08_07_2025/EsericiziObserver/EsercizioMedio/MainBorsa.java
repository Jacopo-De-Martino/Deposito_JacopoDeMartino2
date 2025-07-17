package corsoJavaBackend.Settimana3.lezione12_08_07_2025.EsericiziObserver.EsercizioMedio;

public class MainBorsa {
    public static void main(String[] args) {
        // Ottieni l'istanza unica dell'AgenziaBorsa (se la rendi Singleton)
        AgenziaBorsa agenzia = AgenziaBorsa.getInstance(); // Se AgenziaBorsa è Singleton
        // Crea gli investitori
        InvestitorePrivato mario = new InvestitorePrivato("Mario Rossi", 50000.0);
        InvestitoreBancario bancaXYZ = new InvestitoreBancario("Banca XYZ", 10000000.0);
        InvestitorePrivato anna = new InvestitorePrivato("Anna Verdi", 25000.0);
        // Registra gli investitori all'agenzia
        agenzia.aggiungiInvestitore(mario);
        agenzia.aggiungiInvestitore(bancaXYZ);
        agenzia.aggiungiInvestitore(anna);
        // Aggiorna il valore di un'azione e vedi le notifiche
        agenzia.aggiornaValoreAzione("AAPL", 180.50);
        // Rimuovi un investitore e aggiorna di nuovo
        agenzia.rimuoviInvestitore(mario); // Errore di battitura nel mio esempio, dovrebbe essere removeInvestitore
        agenzia.aggiornaValoreAzione("GOOGL", 1500.75);
        // Aggiungi di nuovo Mario e cambia un altro valore
        agenzia.aggiungiInvestitore(mario);
        agenzia.aggiornaValoreAzione("TSLA", 250.00);
    }
}