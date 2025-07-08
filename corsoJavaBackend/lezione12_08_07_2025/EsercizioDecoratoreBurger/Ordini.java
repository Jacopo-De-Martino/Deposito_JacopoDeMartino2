package corsoJavaBackend.lezione12_08_07_2025.EsercizioDecoratoreBurger;

import java.util.ArrayList;
import java.util.List;

interface OsservatoreOrdine {// Interfaccia per notificare ordini metodo void parametro di tipo Hamburger
    void notificaOrdine(Hamburger hamburger);
}

// Subject
class GestoreOrdini implements OsservatoreOrdine {
    private static GestoreOrdini istanza;
    private List<Hamburger> ordini;

    private GestoreOrdini() {
        ordini = new ArrayList<>();
    }

    public static GestoreOrdini getInstance() {
        if (istanza == null) {
            istanza = new GestoreOrdini();
        }
        return istanza;
    }

    public void notificaOrdine(Hamburger hamburger) {
        ordini.add(hamburger);
        System.out.println(
                "[GESTORE] Ordine registrato: " + hamburger.getDescrizione() + " - Prezzo: €" + hamburger.getPrezzo());
    }

    public void stampaRiepilogo() {
        System.out.println("\n=== Riepilogo Ordini ===");
        for (Hamburger hamburger : ordini) {
            System.out.println("- " + hamburger.getDescrizione() + " (€" + hamburger.getPrezzo() + ")");
        }
    }

}
