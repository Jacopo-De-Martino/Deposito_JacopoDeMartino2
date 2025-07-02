package corsoJavaBackend.Lezione8_02_2027.ProvaEreditarietà;

class Studente {
    private String nome;
    private int eta;

    // Costruttore
    public Studente(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Override del metodo toString()
    @Override
    public String toString() {
        return "Studente [nome=" + nome + ", eta=" + eta + "]";
    }

}

public class ProvaOverride {
    public static void main(String[] args) {
        Studente s1 = new Studente("Luca", 20);// inizializzo un oggetto di tipo Studente
        System.out.println(s1.toString());// utilizzo il metodo overraidato to String per stampare gli attributi e i
                                          // valori degli attributi di quell'oggetto
    }

}
