package corsoJavaBackend.Lezione14_09_2025.EserciziFactoryMethod.EsercizioFactoryMehodMedio;

// --- Pattern Factory Method  ---
//Classe astratta che utilizzare il metodo crea Forma per instanziare gli oggetti che implementano l'interfaccia Forma
abstract class CreatoreForma {
    public abstract Forma creaForma(); // Metodo di fabbrica astratto verrà specializzato da le classi Concrete figlie

    public void eseguiOperazione() {
        Forma forma = creaForma(); // Delega la creazione alla sottoclasse utilizza il metodo astratto per
                                   // l'istanzazione dell oggeto
        forma.disegna(); // Stampa il disegno dell'oggetto (Forma Concreta creata)
        System.out.println("Descrizione: " + forma.ottieniDescrizione()); // Stampa con descrizione dell'oggetto Creato
    }
}

// Classi concrete
class CreatoreCerchioConcreto extends CreatoreForma {
    @Override
    public Forma creaForma() {
        return new Cerchio();
    }
}

class CreatoreQuadratoConcreto extends CreatoreForma {
    @Override
    public Forma creaForma() {
        return new Quadrato();
    }
}
