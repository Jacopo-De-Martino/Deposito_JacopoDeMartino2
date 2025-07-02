package corsoJavaBackend.Lezione8_02_2027.ProvaEreditarietà;

// Classe base
class Persona {
    protected String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public void saluta() {
        System.out.println("Ciao, sono " + nome);
    }
}

// Classe derivata
class Studente1 extends Persona {
    private String scuola;

    // Costruttore: usa super per chiamare il costruttore della classe madre
    public Studente1(String nome, String scuola) {
        super(nome); // chiama il costruttore di Persona
        this.scuola = scuola;
    }

    // Metodo: usa super per richiamare il metodo saluta della superclasse
    public void saluta() {
        super.saluta(); // chiama saluta() da Persona
        System.out.println("Vado alla scuola " + scuola);
    }
}

// Classe principale con il main
public class MainEreditarietaUtilizzoSuper {
    public static void main(String[] args) {
        Studente1 s = new Studente1("Luca", "ITIS Informatico");
        s.saluta();
    }
}
