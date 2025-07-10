package corsoJavaBackend.Settimana2.Lezione7_01_07_2025.EserciziIncapsulamento;

import java.util.ArrayList;
import java.util.Scanner;

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codiceId;
    private Pilota pilota;

    public Pilota getPilota() {
        return pilota;
    }

    public void setPilota(Pilota pilota) {
        this.pilota = pilota;
    }

    public String getModello() {
        return modello;
    }

    // ! Inizio getter e setter Class Aereo
    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        if (validitaPosti(numeroPosti)) {
            System.out.println("range posti 1 - 200");
            return;
        }
        this.numeroPosti = numeroPosti;
    }

    public String getCodiceId() {
        return codiceId;
    }

    public void setCodiceId(String codiceId) {
        this.codiceId = codiceId;
    }

    // ! Metodi
    // Validazione valori x setter
    public boolean validitaPosti(int posti) {
        return posti <= 0 || posti > 200;
    }

    private void stampaInfoAereo() {
        String pilotaInfo = (this.pilota != null) ? this.pilota.getNome() : "Nessun pilota assegnato";
        System.out
                .println("Codice ID: " + this.codiceId + ", Modello: " + this.modello + ", Posti: " + this.numeroPosti +
                        ", Pilota: " + pilotaInfo);
    }

    public void print() {
        this.stampaInfoAereo();
    }
}

class Pilota {
    private String nome;
    private int numeroBrevetto;
    private int oreVolo;

    // ! Inizio getter e setter classe Pilota
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroBrevetto() {
        return numeroBrevetto;
    }

    public void setNumeroBrevetto(int numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    public void setOreVolo(int oreVolo) {
        this.oreVolo = oreVolo;
    }

    // fine getter e setter classe pilota
    public void stampaInfo() {
        System.out.println(
                "Nome : " + this.nome + " N° brevetto : " + this.numeroBrevetto + " Ore di volo " + this.oreVolo);
    }
}

class Flotta {
    private String nome;
    private ArrayList<Aereo> aerei = new ArrayList<>();
    private ArrayList<Pilota> piloti = new ArrayList<>();

    // ! Inizio getter e setter Flotta
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aereo> getAerei() {
        return aerei;
    }

    public void setAerei(ArrayList<Aereo> aerei) {
        this.aerei = aerei;
    }

    public ArrayList<Pilota> getPiloti() {
        return piloti;
    }

    public void setPiloti(ArrayList<Pilota> piloti) {
        this.piloti = piloti;
    }
    // fine getter e setter flotta

    // Metodi privati per aggiungere e rimuovere un aereo dalla flotta
    private void aggiungiAereo(Aereo aereo) {
        if (aereo != null && !aereo.validitaPosti(aereo.getNumeroPosti())) {
            aerei.add(aereo);
            System.out.println("Aereo aggiunto con successo");
        } else {
            System.out.println("Impossibile aggiungere l'aereo , dati non validi");
        }
    }

    private void rimuoviAereo(Aereo aereo) {
        if (aereo != null) {
            if (aerei.contains(aereo)) {
                aerei.remove(aereo);
            } else {
                System.out.println("Aereo non presente nella flotta");
            }
        }
    }

    private void stampaInformazioniFlotta() {
        System.out.println("Lista Aerei");
        for (Aereo aereo : this.aerei) {
            aereo.print();
        }
        System.out.println("Lista piloti");
        for (Pilota pilota : piloti) {
            pilota.stampaInfo();
        }

    }

    // metodo privato per il menu
    private void menu() {
        // Instanze scanner utilizzo imput dati inseriti da l'utente
        Scanner scanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        // variabile gestione flusso operazioni
        int scelta;
        do {
            // Stampa del menu
            System.out.println("\n--- MENU GESTIONE FLOTTA ---");
            System.out.println("1. Aggiungi Aereo");
            System.out.println("2. Rimuovi Aereo (tramite codice ID)");
            System.out.println("3. Visualizza Flotta");
            System.out.println("4. Crea nuovo pilota");
            System.out.println("5. Assegna pilota a un aereo");
            System.out.println("6. Esci");
            System.out.print("Inserisci la tua scelta: ");
            // selezione della scelta, utilizzo scanner per imput utente
            scelta = intScanner.nextInt();
            switch (scelta) {// scelta == 1
                case 1:
                    Aereo nuovoAereo = new Aereo(); // Instanza nuovo Aereo

                    System.out.print("Inserisci codice identificativo: ");// Inserimento codice identificatico
                    nuovoAereo.setCodiceId(scanner.nextLine()); // inserimento dati per valorizzare gli attributi
                                                                // dell'aereo

                    System.out.print("Inserisci modello: "); // Inserimento MODELLO
                    nuovoAereo.setModello(scanner.nextLine());// inserimento dati per valorizzare gli attributi
                                                              // dell'aereo

                    System.out.print("Inserisci numero di posti: ");// Inserimento numero posti
                    nuovoAereo.setNumeroPosti(scanner.nextInt());// inserimento dati per valorizzare gli attributi
                                                                 // dell'aereo
                    scanner.nextLine();

                    aggiungiAereo(nuovoAereo); // Aggiunta aereo alla flotta utilizzo metodo privato aggiungi aereo
                    break;

                case 2: // scelta == 2
                    System.out.print("Inserisci codice ID dell'aereo da rimuovere: ");
                    String codiceId = scanner.nextLine();// imput utente per eliminare un aere tramite codice
                                                         // identificativo
                    Aereo daRimuovere = null; // variabile di appoggio inizializzata a null
                    for (Aereo aereo : aerei) {// ciclo gli aerei della flotta
                        if (aereo.getCodiceId().equalsIgnoreCase(codiceId)) {
                            daRimuovere = aereo; // se negli aere della flotta trovo il codice identificativo passato
                                                 // come imput valorizzo la variabile di appoggio con quell'aereo
                            break;
                        }
                    }
                    // Verifico se l'aereo effettivamente esiste e lo rimuovo
                    if (daRimuovere != null) { // sa rimuovere diverso da null
                        rimuoviAereo(daRimuovere);
                    } else {// se rimane null quindi non trovo nessun aereo durante il ciclo stampo nessun
                            // aereo trovato
                        System.out.println("Nessun aereo trovato con quel codice ID.");
                    }
                    break;
                case 3: // scelta == 3 Stampa le informazioni della flotta
                    // Utilizzo il metodo privato stampa informazioni per stampare Aerei e se ci
                    // sono piloti nella flotta
                    stampaInformazioniFlotta();
                    break;
                case 4: // scelta == 4 aggiunta di un pilota alla flotta
                    Pilota nuovoPilota = new Pilota(); // instanzio un oggetto di tipo pilota
                    System.out.print("Nome pilota: ");
                    nuovoPilota.setNome(scanner.nextLine());// Inserimento nome tramite setNome(scanner.nextLine())

                    System.out.print("Numero brevetto: ");
                    nuovoPilota.setNumeroBrevetto(intScanner.nextInt());// Inserimento n°brevetto tramite
                                                                        // setNumeroBrevetto(scanner.nextInt())

                    System.out.print("Ore di volo: ");
                    nuovoPilota.setOreVolo(intScanner.nextInt());// Inserimento ore volo tramite
                                                                 // setOreVolo(scanner.nextInt())

                    piloti.add(nuovoPilota); // Aggiungo il piloto alla lista di piloti della flotta
                    System.out.println("Pilota aggiunto con successo.");
                    break;
                case 5: // scelta == 5: assegnare un pilota a un aereo

                    // Controllo se la lista degli aerei o dei piloti è vuota
                    if (aerei.isEmpty() || piloti.isEmpty()) {
                        System.out.println("Assicurati di avere almeno un aereo e un pilota nella flotta.");
                        break; // Esco dal case perché non posso procedere senza aerei o piloti
                    }

                    System.out.println("Elenco aerei disponibili:");
                    // Ciclo per stampare tutti gli aerei con indice, codice ID e modello
                    for (int i = 0; i < aerei.size(); i++) {
                        System.out.println(i + ". " + aerei.get(i).getCodiceId() + " - " + aerei.get(i).getModello());
                    }

                    System.out.print("Scegli l'indice dell'aereo a cui assegnare un pilota: ");
                    int indiceAereo = scanner.nextInt(); // Leggo l'indice dell'aereo scelto dall'utente
                    scanner.nextLine(); // Pulisco il buffer di input dopo nextInt()

                    System.out.println("Elenco piloti disponibili:");
                    // Ciclo per stampare tutti i piloti con indice e nome
                    for (int i = 0; i < piloti.size(); i++) {
                        System.out.println(i + ". " + piloti.get(i).getNome());
                    }

                    System.out.print("Scegli l'indice del pilota da assegnare: ");
                    int indicePilota = scanner.nextInt(); // Leggo l'indice del pilota scelto
                    scanner.nextLine(); // Pulisco il buffer di input dopo nextInt()

                    // Controllo che gli indici inseriti siano validi, cioè rientrino nei limiti
                    // delle liste
                    if (indiceAereo >= 0 && indiceAereo < aerei.size() && indicePilota >= 0
                            && indicePilota < piloti.size()) {
                        Aereo aereoDaAssegnare = aerei.get(indiceAereo); // Prendo l'aereo selezionato dalla lista
                        Pilota pilotaDaAssegnare = piloti.get(indicePilota); // Prendo il pilota selezionato dalla lista

                        aereoDaAssegnare.setPilota(pilotaDaAssegnare); // Associo il pilota all'aereo
                        System.out.println("Pilota assegnato con successo all'aereo."); // Messaggio di conferma
                    } else {
                        System.out.println("Indice non valido."); // Messaggio di errore se uno degli indici è fuori
                                                                  // range
                    }
                    break;
                case 6:
                    System.out.println("Uscita dal menu.");
                    break;

                default:
                    System.out.println("Scelta non valida, riprova.");
            }

        } while (scelta != 6);
    }

    public void usaMenu() {
        menu();
    }
}

public class GestioneCompagniaAerea {
    public static void main(String[] args) {
        Flotta flotta = new Flotta();
        flotta.setNome("Compagnia Aerea X");
        flotta.usaMenu();
    }
}
