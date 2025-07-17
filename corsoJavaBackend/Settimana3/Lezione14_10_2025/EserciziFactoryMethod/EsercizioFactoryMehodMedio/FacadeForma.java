package corsoJavaBackend.Settimana3.Lezione14_10_2025.EserciziFactoryMethod.EsercizioFactoryMehodMedio;

// --- PATTERN FACADE (aggiornato per usare i Decoratori e Factory Method) ---
class DisegnatoreFacciata {

    public void disegnaCerchioSemplice() {
        System.out.println("Richiesta di disegnare un cerchio semplice.");
        CreatoreForma creatoreCerchio = new CreatoreCerchioConcreto();
        creatoreCerchio.eseguiOperazione(); // Questo metodo già chiama disegna() e ottieniDescrizione()
    }

    public void disegnaQuadratoSemplice() {
        System.out.println("Richiesta di disegnare un quadreto semplice.");
        CreatoreForma creatoreQuadrato = new CreatoreQuadratoConcreto();
        creatoreQuadrato.eseguiOperazione(); // Questo metodo già chiama disegna() e ottieniDescrizione()
    }

    public void disegnaCerchioRosso() {
        System.out.println("Richiesta di disegnare un cerchio ROSSO.");
        // Creiamo la forma base con il Factory Method
        Forma cerchioBase = new CreatoreCerchioConcreto().creaForma();
        // Applichiamo il decoratore sulla forma base
        Forma cerchioRosso = new DecoratoreFormaRossa(cerchioBase);
        cerchioRosso.disegna();
        System.out.println("Descrizione: " + cerchioRosso.ottieniDescrizione());
    }

    public void disegnaQuadratoBlu() {
        System.out.println("Richiesta di disegnare un quadrato BLU.");
        Forma quadratoBase = new CreatoreQuadratoConcreto().creaForma();
        Forma quadratoBlu = new DecoratoreFormaBlu(quadratoBase);
        quadratoBlu.disegna();
        System.out.println("Descrizione: " + quadratoBlu.ottieniDescrizione());
    }

    public void disegnaCerchioRossoBlu() {
        System.out.println("Richiesta di disegnare un cerchio ROSSO e BLU.");
        Forma cerchioBase = new CreatoreCerchioConcreto().creaForma();
        // Applichiamo più decoratori in sequenza: prima rosso, poi blu
        Forma cerchioRosso = new DecoratoreFormaRossa(cerchioBase);
        Forma cerchioRossoBlu = new DecoratoreFormaBlu(cerchioRosso);
        cerchioRossoBlu.disegna();
        System.out.println("Descrizione: " + cerchioRossoBlu.ottieniDescrizione());
    }

    public void disegnaTutteLeForme() {
        System.out.println("\n--- Disegno tutte le forme disponibili ---");
        disegnaCerchioSemplice();
        System.out.println("---");
        disegnaCerchioRosso();
        System.out.println("---");
        disegnaQuadratoBlu();
        System.out.println("---");
        disegnaCerchioRossoBlu();
        System.out.println("--- Facciata: Tutte le forme disegnate. ---");
    }
}