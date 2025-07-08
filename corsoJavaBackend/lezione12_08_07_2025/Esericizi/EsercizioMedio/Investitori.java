package corsoJavaBackend.lezione12_08_07_2025.Esericizi.EsercizioMedio;

// Investitori sono gli Observer
interface Investitore { // Interfaccia
    String getNome(); // getter per il nome

    void notifica(String azione, double valore); // Questo è il metodo update per gli investitori
}

// InvestitorePrivato e InvestitoreBancario
// Implementeranno questa interfaccia
class InvestitorePrivato implements Investitore {
    // Attributi
    private String nome;
    private double capitale;

    // construttore
    public InvestitorePrivato(String nome, double capitale) {
        this.nome = nome;
        this.capitale = capitale;
    }

    // getter interfaccia
    @Override
    public String getNome() {
        return nome;
    }

    // notifica
    @Override
    public void notifica(String azione, double valore) {
        System.out.println(
                "Investitore Privato " + nome + ": L'azione " + azione + " ha un nuovo valore: " + valore + ".");
    }
}

class InvestitoreBancario implements Investitore {
    // Attributi
    private String nome;
    private double capitale;

    public InvestitoreBancario(String nome, double capitale) {
        this.nome = nome;
        this.capitale = capitale;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Investitore Bancario " + nome + ": Rilevato cambiamento nell'azione " + azione
                + ", nuovo valore: " + valore + ". Valutazione strategica in corso.");

    }
}