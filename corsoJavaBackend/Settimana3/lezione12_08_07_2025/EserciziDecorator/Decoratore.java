package corsoJavaBackend.lezione12_08_07_2025.EserciziDecorator;

//Classe astratta del nostro Decoratore
abstract class Decoratore implements Messaggio {
    protected Messaggio messaggio;// Utilizzo il tipo funzionale(Interfacce) degli oggetti che vogliamo decorare
    // Super costruttore che utilizzeremo per i nostri decoratori di Messaggio
    // Concreti

    Decoratore(Messaggio messaggio) {// Accetta come parametro un oggetto "reale" che implementa l'interfaccia
                                     // messaggio
        this.messaggio = messaggio;// ignettiamo cosi l'oggetto reale nel nostro decoratore accesso diretto a
                                   // metodi e attributi
    }

    @Override
    public String getContenuto() {// metodo che sfrutteremo nei nostri decoratori reali per effettuare operazioni
                                  // di modifica su la String restituita dal metodo get contenuto
        return this.messaggio.getContenuto();
    }
}

class DecoratoreMaiuscolo extends Decoratore {// Classe reale del nostro decoratore

    DecoratoreMaiuscolo(Messaggio messaggio) {// Creazione dell'oggetto Decoratore Maiuscolo
        super(messaggio);
    }

    @Override
    public String getContenuto() {// Specializzazione richiamo super.getContenuto()/*Accesso a la String in uscita
                                  // da messaggio.getContenuto() */.toUpperCase() /*Metodo per trasformare una
                                  // String in Maiuscolo */
        return super.getContenuto().toUpperCase();
    }

}
