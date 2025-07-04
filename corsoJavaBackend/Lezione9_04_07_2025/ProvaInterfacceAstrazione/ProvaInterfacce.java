package corsoJavaBackend.Lezione9_04_07_2025.ProvaInterfacceAstrazione;

//Interfaccia Animale
interface Animale {
    // firme dei metodi dell'interfaccia
    public void animalSound();

    public void sleep();
}

// Classe che implementa l'interfaccia obbligo di implementare i metodi di
// interfaccia
class Pig implements Animale {
    @Override
    public void animalSound() {// Specializzo il metodo animalSound() dell'interfaccia per gli oggetti di Class
                               // Pig
        System.out.println("The pig says:wee wee");
    }

    @Override
    public void sleep() {// Specializzo il metodo sleep() dell'interfaccia per gli oggetti di Class Pig
        System.out.println("Pig : ZZZZ");
    }
}

public class ProvaInterfacce {

    public static void main(String[] args) {
        // Utilizzo l'estensione Animale per instanziare un oggetto di classe Pig
        Animale pig = new Pig();
        pig.sleep();
        pig.animalSound();

    }
}
