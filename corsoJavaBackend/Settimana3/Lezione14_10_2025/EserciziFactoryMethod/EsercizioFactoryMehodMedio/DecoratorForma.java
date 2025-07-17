package corsoJavaBackend.Settimana3.Lezione14_10_2025.EserciziFactoryMethod.EsercizioFactoryMehodMedio;
// --- PATTERN DECORATOR: Implementazione dei Decoratori per i Colori ---

// Decoratore astratto Estende Forma e mantiene un riferimento al Componente Concreto
abstract class DecoratoreForma implements Forma {
    protected Forma formaDecorata; // Il riferimento alla forma che stiamo decorando

    public DecoratoreForma(Forma formaDecorata) {
        this.formaDecorata = formaDecorata;
    }

    @Override
    public void disegna() {
        formaDecorata.disegna(); // Delega il disegno alla forma sottostante
    }

    @Override
    public String ottieniDescrizione() {
        return formaDecorata.ottieniDescrizione(); // Delega la descrizione alla forma sottostante
    }
}

// Decoratori Concreti: Aggiungono la funzionalità specifica (colore)
class DecoratoreFormaRossa extends DecoratoreForma {
    public DecoratoreFormaRossa(Forma formaDecorata) {
        super(formaDecorata);
    }

    @Override
    public void disegna() {
        formaDecorata.disegna(); // Disegna prima la forma di base
        impostaBordoRosso(formaDecorata); // Poi aggiunge la sua funzionalità (bordo rosso)
    }

    @Override
    public String ottieniDescrizione() {
        return super.ottieniDescrizione() + " con Bordo Rosso"; // Modifica la descrizione
    }

    private void impostaBordoRosso(Forma formaDecorata) {
        System.out.println("Colore del bordo: Rosso.");
    }
}

class DecoratoreFormaBlu extends DecoratoreForma {
    public DecoratoreFormaBlu(Forma formaDecorata) {
        super(formaDecorata);
    }

    @Override
    public void disegna() {
        formaDecorata.disegna();
        impostaRiempimentoBlu(formaDecorata);
    }

    @Override
    public String ottieniDescrizione() {
        return super.ottieniDescrizione() + " con Riempimento Blu";
    }

    private void impostaRiempimentoBlu(Forma formaDecorata) {
        System.out.println("Colore del riempimento: Blu.");
    }
}
