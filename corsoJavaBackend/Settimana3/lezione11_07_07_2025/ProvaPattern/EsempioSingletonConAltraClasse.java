package corsoJavaBackend.Settimana3.lezione11_07_07_2025.ProvaPattern;

// La classe Fattoria, che sarà utilizzata dal nostro Singleton Pippo
class Fattoria {
    private String nomeFattoria;

    public String getNomeFattoria() {
        return nomeFattoria;
    }

    public void setNomeFattoria(String nomeFattoria) {
        this.nomeFattoria = nomeFattoria;
    }

    public Fattoria(String nomeFattoria) {
        this.nomeFattoria = nomeFattoria;
        System.out.println("Fattoria '" + nomeFattoria + "' creata.");
    }

    public void mostraAnimali() {
        System.out.println("Nella fattoria '" + nomeFattoria + "' ci sono animali felici!");
        // Logica per mostrare animali specifici, es. dalla lista interna
    }

    public void produciLatte() {
        System.out.println("La fattoria '" + nomeFattoria + "' sta producendo latte.");
    }
}

// La classe Pippo è il nostro Singleton
class Pippo {
    private static Pippo instance;
    private String nome;
    private int eta;
    // NUOVO: Riferimento a un'istanza di Fattoria
    private Fattoria fattoriaVisitata;

    // Costruttore privato
    private Pippo(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
        System.out.println("Pippo instance created with name: " + nome + ", age: " + eta);
        // NUOVO: Inizializza l'oggetto Fattoria all'interno del costruttore del
        // Singleton.
        // Questo significa che ogni volta che ottieni l'istanza di Pippo, essa "porterà
        // con sé"
        // anche l'istanza della Fattoria.
        this.fattoriaVisitata = new Fattoria("Fattoria Del Sole");
    }

    public static Pippo getInstance() {
        if (instance == null) {
            instance = new Pippo("Pippo-Singleton", 30);
        }
        return instance;
    }

    // Metodo di esempio di Pippo
    public void salta() {
        System.out.println(nome + " salta!");
    }

    public void dormi() {
        System.out.println(nome + " dorme.");
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    // NUOVO: Metodo che usa l'istanza di Fattoria posseduta dal Singleton Pippo
    public void visitaFattoria() {
        System.out.println(nome + " sta visitando la fattoria: " + fattoriaVisitata.getNomeFattoria());
        fattoriaVisitata.mostraAnimali(); // Richiama un metodo della classe Fattoria
    }

    // NUOVO: Un altro metodo che usa la Fattoria
    public void aiutaInFattoria() {
        System.out.println(nome + " sta aiutando in fattoria...");
        fattoriaVisitata.produciLatte(); // Richiama un altro metodo della classe Fattoria
    }
}

// Classe principale per testare il Singleton Pippo e la sua interazione con
// Fattoria
public class EsempioSingletonConAltraClasse {

    public static void main(String[] args) {
        System.out.println("--- Otteniamo la prima istanza di Pippo ---");
        Pippo pippoUno = Pippo.getInstance(); // Qui Pippo e la sua Fattoria vengono creati
        pippoUno.salta();
        pippoUno.visitaFattoria(); // Chiamiamo il metodo che interagisce con Fattoria

        System.out.println("\n--- Otteniamo la seconda istanza di Pippo (che è la stessa) ---");
        Pippo pippoDue = Pippo.getInstance(); // Questa è la stessa istanza di pippoUno
        pippoDue.dormi();
        pippoDue.aiutaInFattoria(); // Chiamiamo un altro metodo che interagisce con Fattoria

        System.out.println("\n--- Verifica dell'istanza del Singleton Pippo ---");
        if (pippoUno == pippoDue) {
            System.out.println("pippoUno e pippoDue sono la stessa istanza di Pippo.");
        } else {
            System.out.println("Errore: Pippo non è un Singleton!");
        }

        // Output previsto: "Fattoria 'Fattoria Del Sole' creata." apparirà una sola
        // volta,
        // dimostrando che la Fattoria è creata solo quando Pippo (il Singleton) viene
        // istanziato per la prima volta.
    }
}
