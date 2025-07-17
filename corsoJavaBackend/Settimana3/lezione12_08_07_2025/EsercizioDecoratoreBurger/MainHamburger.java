package corsoJavaBackend.Settimana3.lezione12_08_07_2025.EsercizioDecoratoreBurger;

//Classe main esecuzione del programma
public class MainHamburger {
    public static void main(String[] args) {
        // Creazione hamburger con formaggio e bacon
        Hamburger ordine1 = new BaseBurger();// creo un oggetto di tipo BaseBurger utilizzando il tipo funzionale
                                             // Hamburger dato da l'interfaccia
        ordine1 = new FormaggioDecorator(ordine1);// dopo di che decoro l'oggetto BaseBurger(Hamburger) e lo "Trasformo"
                                                  // in un oggetto FormaggioDecorator
        ordine1 = new BaconDecorator(ordine1);// lo decoro una seconda volta questa volta usando il BaconDecorator

        // Creazione hamburger solo con bacon
        Hamburger ordine2 = new BaseBurger();
        ordine2 = new BaconDecorator(ordine2);

        // Recupero singleton del gestore ordini utilizzo metodo statico getInstance()
        // che a sua volta richiama il costruttore se l'oggetto è null
        GestoreOrdini gestore = GestoreOrdini.getInstance();

        // Notifica (observer)
        gestore.notificaOrdine(ordine1);
        gestore.notificaOrdine(ordine2);

        // Riepilogo
        gestore.stampaRiepilogo();
    }
}