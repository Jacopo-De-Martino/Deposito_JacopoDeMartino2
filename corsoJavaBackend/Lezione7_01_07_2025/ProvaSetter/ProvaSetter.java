package corsoJavaBackend.Lezione7_01_07_2025.ProvaSetter;

class User {
    // Attributo privato per il nome dell'utente
    private String name;

    // Metodo getter per ottenere il nome dell'utente
    public String getName() {
        return name;
    }

    // Metodo setter per impostare il nome dell'utente
    public void setName(String name) {
        this.name = name;
    }
}

class Persona {
    // Attributi privati per nome ed età
    private String nome;
    private int eta;

    // Metodo costruttore pubblico
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Metodo privato utilizzato dalla classe
    private boolean verificaMaggiorenne() {
        return this.eta >= 18; // perchè utilizzo il .this? per evitare ambiguità tra variabili locali e
                               // attributi della classe
        // In questo caso, potresti anche scrivere semplicemente "eta >= 18
    }

    // Metodo pubblico che utilizza il metodo privato
    public String stampaStatus() {
        if (verificaMaggiorenne()) {
            return this.nome + " è maggiorenne.";
        } else {
            return this.nome + " non è maggiorenne.";
        }
    }

}

public class ProvaSetter {
    public static void main(String[] args) {
        // Creazione di un oggetto User e utilizzo del metodo setter per impostare il
        // nome
        User user = new User();
        user.setName("Jacopo");
        // Utilizzo del metodo getter per ottenere il nome e stamparlo
        System.out.println(user.getName());
        /*
         * Fine della parte di codice che utilizza la classe User
         */
        // Creazione di un oggetto Persona
        Persona persona = new Persona("Mario", 20);
        // Utilizzo del metodo pubblico per verificare se la persona è maggiorenne
        System.out.println(persona.stampaStatus());

        // Creazione di un altro oggetto Persona
        Persona persona2 = new Persona("Luca", 16);
        // Utilizzo del metodo pubblico per verificare se la persona è maggiorenne
        System.out.println(persona2.stampaStatus());

    }

}
