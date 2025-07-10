package corsoJavaBackend.Settimana2.Lezione10_04_07_2025.EsercizioDelivery;

import java.util.ArrayList;
import java.util.Scanner;

//Classe Astatta VeicoloConsegna --> rappresenta il blueprint generico di tutti i veicoli di consegna
abstract class VeicoloConsegna {
    protected String targa;
    protected float caricoMassimo;
    protected String destinazione;

    @Override
    public String toString() {
        return "VeicoloConsegna [targa=" + targa + ", caricoMassimo=" + caricoMassimo + ", destinazione=" + destinazione
                + "]";
    }

    protected VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    public abstract void consegnaPacco();

    public void stampaInfo() {
        System.out.println("Veico consegna\n Targa: " + targa + "\n Carico Massimo: " + caricoMassimo);
    }

}

// intefaccia Tracciabile
interface Tracciabile {
    // Metodo per simuolare la tracciabilita della spedizione
    void tracciaConsegna();

}

// Classi concrete figlie di VeicoloConsegna che implementeranno l'interfaccia
// Tracciabile e specializzeranno i metodi tracciConsegna() e consegnaPacco();
class Furgone extends VeicoloConsegna implements Tracciabile {
    protected Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override // Specializzo il metodo dell'interfaccia tracciabile
    public void tracciaConsegna() {
        this.consegnaPacco();// richiamo al suo interno il metodo della classe padre consegnaPacco
        // specializzato nella classe furgone
        System.out.println("Impossibile tracciare la consegna");
    }

    @Override
    public void consegnaPacco() {// Metodo specializzato per classe furgone
        System.out.println("Furgone " + targa + " : \nsta consegnando via strada " + "Destinazione : "
                + (destinazione != null
                        ? destinazione
                        : "Destinazione non specificata"));
    }
}

class Drone extends VeicoloConsegna implements Tracciabile {
    protected Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override
    public void tracciaConsegna() {
        this.consegnaPacco();
        System.out.println("Consegna in arrivo tra " + Math.floor(Math.random() * 10 + 1) + "minuti");
    }

    @Override
    public void consegnaPacco() {
        System.out.println("Drone sta volando verso destinazione : " + (destinazione != null ? destinazione
                : "Destinazione non specificata"));
    }
}

public class ConsegnaManager {
    public static void main(String[] args) {
        ArrayList<VeicoloConsegna> veicoliConsegne = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String scelta;

        do {
            System.out.println("\n== Menu ==");
            System.out.println("1 - Inserisci un Veicolo Consegna");
            System.out.println("2 - Richiedi consegna");
            System.out.println("3 - Traccia consegna");
            System.out.println("fine - Uscita");
            System.out.print("Scelta: ");
            scelta = scanner.nextLine();

            if (scelta.equalsIgnoreCase("fine")) {
                System.out.println("Arrivederci");
                break;
            }

            switch (scelta) {
                case "1":// inserimento dei veicoli nell'ArrayList veicoliConsegne
                    System.out.print("Che veicolo vuoi inserire ('DRONE' o 'FURGONE')? ");// Controllo che tipo di
                                                                                          // Instanza a richiesta
                                                                                          // 'Drone' o 'Furgone'
                    String tipoVeicolo = scanner.nextLine().toLowerCase();
                    VeicoloConsegna nuovoVeicolo;

                    if (tipoVeicolo.equals("drone")) {// A seconda della scelta faccio inserire i dati per il drone
                        System.out.print("Inserisci codice identificativo drone: ");
                        String cdDrone = scanner.nextLine();
                        System.out.print("Inserisci carico massimo (in kg): ");
                        float kgDrone = scanner.nextFloat(); // Uso sicuro
                        scanner.nextLine();
                        nuovoVeicolo = new Drone(cdDrone, kgDrone);
                        veicoliConsegne.add(nuovoVeicolo);
                        System.out.println("Drone aggiunto!");
                    } else if (tipoVeicolo.equals("furgone")) {// A seconda della scelta faccio inserire i dati per il
                                                               // furgone
                        System.out.print("Inserisci targa: ");
                        String trFurgone = scanner.nextLine();
                        System.out.print("Inserisci carico massimo (in kg): ");
                        float kgFurgone = scanner.nextFloat(); // Uso sicuro
                        scanner.nextLine();
                        nuovoVeicolo = new Furgone(trFurgone, kgFurgone);
                        veicoliConsegne.add(nuovoVeicolo);
                        System.out.println("Furgone aggiunto!");
                    } else {
                        System.out.println("Tipo di veicolo non valido.");// messaggio di 'errore'
                    }
                    System.out.println("Lista veicoli attuale: " + veicoliConsegne);// Stampo la lista
                    break;

                case "2": // Richiedi consegna
                    if (veicoliConsegne.isEmpty()) {// Controllo che la lista non sia vuota prima di richiedere una
                                                    // consegna
                        System.out.println("Nessun veicolo disponibile. Aggiungine uno prima.");
                        break;
                    }

                    System.out.println("Seleziona il veicolo per la consegna (inserisci la targa/ID):");
                    for (VeicoloConsegna v : veicoliConsegne) {
                        System.out.println("- " + v.targa);
                    }
                    System.out.print("Targa/ID: ");
                    String idSelezionato = scanner.nextLine();

                    VeicoloConsegna veicoloScelto = null;
                    for (VeicoloConsegna v : veicoliConsegne) {
                        if (v.targa.equalsIgnoreCase(idSelezionato)) {
                            veicoloScelto = v;
                            break;
                        }
                    }

                    if (veicoloScelto != null) {
                        System.out.print("Inserisci la destinazione della consegna: ");
                        String destinazione = scanner.nextLine();
                        veicoloScelto.destinazione = destinazione; // Imposto la destinazione
                        veicoloScelto.consegnaPacco(); // Avvio la consegna
                    } else {
                        System.out.println("Veicolo non trovato.");
                    }
                    break;

                case "3": // Traccia consegna
                    if (veicoliConsegne.isEmpty()) {
                        System.out.println("Nessun veicolo da tracciare.");
                        break;
                    }

                    System.out.println("Seleziona il veicolo da tracciare (inserisci la targa/ID):");
                    for (VeicoloConsegna v : veicoliConsegne) {
                        System.out.println("- " + v.targa);
                    }
                    System.out.print("Targa/ID: ");
                    String idDaTracciare = scanner.nextLine();

                    VeicoloConsegna veicoloDaTracciare = null;
                    for (VeicoloConsegna v : veicoliConsegne) {
                        if (v.targa.equalsIgnoreCase(idDaTracciare)) {
                            veicoloDaTracciare = v;
                            break;
                        }
                    }

                    if (veicoloDaTracciare != null) {
                        // Controllo se l'oggetto è un'istanza dell'interfaccia Tracciabile
                        if (veicoloDaTracciare instanceof Tracciabile) {
                            // Se lo è, posso fare il "cast" a Tracciabile e chiamare il metodo
                            Tracciabile veicoloTracciabile = (Tracciabile) veicoloDaTracciare;
                            veicoloTracciabile.tracciaConsegna();
                        } else {
                            // Questo caso non dovrebbe verificarsi con le classi attuali,
                            // ma è una buona pratica gestirlo.
                            System.out.println("Questo veicolo non supporta il tracciamento.");
                        }
                    } else {
                        System.out.println("Veicolo non trovato.");
                    }
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        } while (true);

        scanner.close();
    }
}