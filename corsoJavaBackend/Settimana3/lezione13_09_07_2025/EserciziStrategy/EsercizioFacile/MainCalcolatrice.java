package corsoJavaBackend.lezione13_09_07_2025.EserciziStrategy.EsercizioFacile;

public class MainCalcolatrice {
    public static void main(String[] args) {
        Calcolatore calcolatore1 = new Calcolatore(new Operazione_Addizione()); // Costruisco un oggetto calcolatore
                                                                                // passandogli come Operazione
                                                                                // Addizione(Classe concreta
                                                                                // dell'interfaccia Operazione che
                                                                                // specializza il metodo esegui
                                                                                // ritornando la somma dei 2 parametri
                                                                                // int passati)
        int addizzione = calcolatore1.eseguiOperazione(10, 4);// richiamo il metodo esegui del Calcolatore e salvo il
                                                              // risultato in
        // una variabile
        System.out.println(addizzione);// stampo il risultato
        // Utilizzando il principio OOP del polimorfismo setto il mio Calcolatore su una
        // nuova "Strategia di Operazione" utilizzando il metodo setter dell'attributo
        calcolatore1.setOperazione(new Operazione_Moltiplicazione());
        int moltiplicazione = calcolatore1.eseguiOperazione(10, 4);// eseguo l'operazione in questo caso
        // Operazione_Moltiplicazione effettuera la moltiplicazione dei
        // 2 int passati come paramentri
        System.out.println(moltiplicazione);// Stampo il risultato
    }
}
