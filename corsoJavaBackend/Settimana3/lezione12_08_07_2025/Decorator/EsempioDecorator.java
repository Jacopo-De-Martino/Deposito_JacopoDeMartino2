// File: Component.java
// 1. Interfaccia Componente: Definisce il comportamento comune per l'oggetto base e i decoratori.
interface Component {
    void operation(); // Il metodo che verrà esteso o modificato.
}

// File: ConcreteComponent.java
// 2. Componente Concreto: L'implementazione base del Componente.
// È l'oggetto "originale" a cui verranno aggiunte funzionalità.
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Operazione base del ConcreteComponent.");
    }
}

/*
 * ------------------------------------------------
 * Parti del Design Pattern Decorator
 * ------------------------------------------------
 */

// File: Decorator.java
// 3. Decoratore Astratto: La classe base per tutti i decoratori concreti.
// È sia un Componente (implementa Component) sia un contenitore per un altro
// Componente.
abstract class Decorator implements Component {
    protected Component component; // Riferimento all'oggetto Componente incapsulato/decorato.

    // Costruttore: riceve l'oggetto Componente da decorare.
    public Decorator(Component component) {
        this.component = component;
    }

    // L'implementazione predefinita passa l'operazione all'oggetto incapsulato.
    // Le sottoclassi lo estenderanno per aggiungere la propria logica.
    @Override
    public void operation() {
        component.operation();
    }
}

// File: ConcreteDecorator.java
// 4. Decoratore Concreto: Aggiunge una specifica funzionalità all'oggetto
// Componente.
class ConcreteDecorator extends Decorator {
    // Costruttore: passa il Componente da decorare al Decoratore astratto.
    public ConcreteDecorator(Component component) {
        super(component);
    }

    // Estende il comportamento chiamando l'operazione del Componente incapsulato
    // e poi aggiungendo la propria logica.
    @Override
    public void operation() {
        super.operation(); // Esegue l'operazione del Componente sottostante (base o altro decoratore).
        System.out.println("Aggiunta funzionalità A dal ConcreteDecorator."); // Aggiunge la nuova funzionalità.
    }
}

public class EsempioDecorator {
    public static void main(String[] args) {
        Component base = new ConcreteComponent();
        base.operation();
        Decorator dec = new ConcreteDecorator(new ConcreteComponent());
        dec.operation();
    }
}