package corsoJavaBackend.Settimana3.lezione13_09_07_2025.EserciziFacade;

class AccendiLuceA {// Sottosistema A
    void accendiLuceA() {
        System.out.println("Luce A accesa");
    }
}

class AccendiLuceB {// Sottosistema B
    void accendiLuceB() {
        System.out.println("Luce B accesa");
    }
}

class Facade { // Macrosistema che comunica con il Client
    // Wrapper e inizializzazione sotto sistemi
    private AccendiLuceA interruttoreA = new AccendiLuceA();
    private AccendiLuceB interruttoreB = new AccendiLuceB();

    public void accendi() {// Metodo che raggruppa i metodi necessari dei sotto sistemi per svolgere ciò
                           // che interessa a l'utente accendere le luci
        // Incapsulamento-astrazione
        System.out.println("Luce accese con successo");
        interruttoreA.accendiLuceA();
        interruttoreB.accendiLuceB();
    }
}

// Programma molto basilare
public class MainFacadeEsBase {
    public static void main(String[] args) {
        Facade facade = new Facade();// Istanzio un Oggetto Facade
        facade.accendi(); // Utilizzo il metodo accendi() dell'oggetto Facade --- vedere commenti metodo
    }

}
