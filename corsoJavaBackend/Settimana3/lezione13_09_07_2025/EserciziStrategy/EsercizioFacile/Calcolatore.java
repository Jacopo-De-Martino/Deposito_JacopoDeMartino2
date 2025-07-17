package corsoJavaBackend.Settimana3.lezione13_09_07_2025.EserciziStrategy.EsercizioFacile;

public class Calcolatore {
    private Operazione classeConcretaOperazione;// Operazione interfaccia che è estesa dalle mie Strategie di Calcolo

    public Calcolatore(Operazione classeConcretaOperazione) {
        this.classeConcretaOperazione = classeConcretaOperazione;
    }

    public void setOperazione(Operazione classeConcretaOperazione) {// permette di variare il tipo di operazioni durante
                                                                    // il runtime modificando lo stesso Oggetto
        this.classeConcretaOperazione = classeConcretaOperazione;
    }

    // metodo dell'oggetto Calcolatore che richiama il metodo esegui dell'oggetto
    // concreto che estende l'interfaccia Operatore
    public int eseguiOperazione(int a, int b) {
        return classeConcretaOperazione.esegui(a, b);
    }
}
