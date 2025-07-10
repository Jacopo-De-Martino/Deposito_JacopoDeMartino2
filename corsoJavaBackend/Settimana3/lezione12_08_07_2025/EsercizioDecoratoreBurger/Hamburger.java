package corsoJavaBackend.lezione12_08_07_2025.EsercizioDecoratoreBurger;

// Interfaccia base per hamburger (Component)
interface Hamburger {
    String getDescrizione();

    double getPrezzo();
}

// Classe base concreta
class BaseBurger implements Hamburger {
    public String getDescrizione() {
        return "Hamburger base";
    }

    public double getPrezzo() {
        return 3.50;
    }
}
