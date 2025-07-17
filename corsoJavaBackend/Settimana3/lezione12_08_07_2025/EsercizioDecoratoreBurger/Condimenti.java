package corsoJavaBackend.Settimana3.lezione12_08_07_2025.EsercizioDecoratoreBurger;

// Classe astratta Decorator
abstract class HamburgerDecorator implements Hamburger {
    protected Hamburger hamburger;

    public HamburgerDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }
}

// Decoratore Formaggio
class FormaggioDecorator extends HamburgerDecorator {
    public FormaggioDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String getDescrizione() {
        return hamburger.getDescrizione() + ", Formaggio";
    }

    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.50;
    }
}

// Decoratore Bacon
class BaconDecorator extends HamburgerDecorator {
    public BaconDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String getDescrizione() {
        return hamburger.getDescrizione() + ", Bacon";
    }

    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.80;
    }
}