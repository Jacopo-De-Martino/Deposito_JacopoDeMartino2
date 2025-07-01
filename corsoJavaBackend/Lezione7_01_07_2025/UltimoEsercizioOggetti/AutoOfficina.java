package corsoJavaBackend.Lezione7_01_07_2025.UltimoEsercizioOggetti;

import java.util.ArrayList;
import java.util.Scanner;

class Auto {
    // Attributi
    private String marca;
    private String modello;
    private int anno;
    private String targa;

    // Costruttore con parametri
    public Auto(String marca, String modello, int anno, String targa) {
        // Validazione dei parametri con il metodo setter
        // Utilizza i metodi setter per garantire che le validazioni siano applicate
        setMarca(marca);
        setAnno(anno);
        setTarga(targa);
        this.modello = modello;
    }

    // Inzio Metodi getter e setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        // Validazione della marca
        // La marca non può essere vuota e non può superare i 20 caratteri
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca non può essere vuota");
        } else if (marca.length() > 20) {
            throw new IllegalArgumentException("La marca non può superare i 20 caratteri");
        } else {
            this.marca = marca;
        }
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        // Validazione dell'anno
        // L'anno deve essere compreso tra 1886 (primo veicolo a motore) e 2025
        if (anno < 1886 || anno > 2025) {
            throw new IllegalArgumentException("Anno non valido. Deve essere tra 1886 e 2025.");
        } else {
            this.anno = anno;
        }
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        // Validazione della targa
        // La targa non può essere vuota e non può superare i 10 caratter
        if (targa == null || targa.isEmpty()) {
            throw new IllegalArgumentException("La targa non può essere vuota");
        } else if (targa.length() > 10) {
            throw new IllegalArgumentException("La targa non può superare i 10 caratteri");
        } else {
            this.targa = targa;
        }
    }
    // Fine Metodi getter e setter

    // Metodo per visualizzare i dettagli dell'auto
    public void visualizzaDettagli() {
        System.out.println("Marca: " + marca);
        System.out.println("Modello: " + modello);
        System.out.println("Anno: " + anno);
        System.out.println("Targa: " + targa);
    }
}

public class AutoOfficina {
    ArrayList<Auto> autoList = new ArrayList<>();

    // Metodo per aggiungere un'auto
    public void aggiungiAuto(Auto auto) { // riceve un oggetto Auto come parametro
        // Validazione dell'auto
        if (auto == null) {
            throw new IllegalArgumentException("L'auto non può essere null");
        }
        autoList.add(auto);
    }

    // Metodo per rimuovere un'auto
    public void rimuoviAuto(Auto auto) { // riceve un oggetto Auto come parametro
        // Validazione dell'auto
        if (auto == null) {
            throw new IllegalArgumentException("L'auto da rimuovere non può essere null");
        }
        autoList.remove(auto);
    }

    // Metodo per visualizzare tutte le auto
    public void visualizzaAuto() {
        // Controlla se la lista di auto è vuota
        if (autoList.isEmpty()) {
            System.out.println("Nessuna auto presente nell'officina.");
            return;
        }
        System.out.println("Elenco delle auto nell'officina:");
        // Itera attraverso la lista di auto e stampa i dettagli
        for (Auto auto : autoList) {
            auto.visualizzaDettagli(); // Stampa i dettagli dell'auto
            System.out.println("-------------------------"); // Separatore tra le auto
        }
    }

    // Getter e setter per la lista di auto
    public ArrayList<Auto> getAutoList() {
        return autoList;
    }

    public void setAutoList(ArrayList<Auto> autoList) {
        this.autoList = autoList;
    }

    public static void main(String[] args) {
        // Creazione di un'istanza di AutoOfficina e avvio del menu
        AutoOfficina officina = new AutoOfficina();
        // Scanner per l'input dell'utente
        Scanner scanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        System.out.println("Benvenuto nell'Auto Officina!");
        // Ciclo per il menu
        // Il ciclo continua finché l'utente non sceglie di uscire
        do {
            // Stampa del menu
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi un'auto");
            System.out.println("2. Rimuovi un'auto");
            System.out.println("3. Visualizza tutte le auto");
            System.out.println("4. Esci");
            // Lettura della scelta dell'utente
            int scelta = intScanner.nextInt();

            switch (scelta) {
                case 1:
                    // Aggiunta di un'auto
                    System.out.println("Inserisci la marca dell'auto:");
                    String marca = scanner.nextLine();
                    System.out.println("Inserisci il modello dell'auto:");
                    String modello = scanner.nextLine();
                    System.out.println("Inserisci l'anno dell'auto:");
                    int anno = intScanner.nextInt();
                    System.out.println("Inserisci la targa dell'auto:");
                    String targa = scanner.nextLine();
                    Auto nuovaAuto = new Auto(marca, modello, anno, targa);
                    officina.aggiungiAuto(nuovaAuto);
                    System.out.println("Auto aggiunta con successo!");
                    break;
                case 2:
                    // Rimozione di un'auto
                    System.out.println("Inserisci la targa dell'auto da rimuovere:");
                    String targaDaRimuovere = scanner.nextLine(); // Lettura della targa da rimuovere
                    Auto autoDaRimuovere = null; // Variabile per tenere traccia dell'auto da rimuovere
                    // Itera attraverso la lista di auto per trovare quella con la targa specificata
                    for (Auto auto : officina.getAutoList()) {
                        if (auto.getTarga().equals(targaDaRimuovere)) {
                            autoDaRimuovere = auto;
                            break;
                        }
                    }
                    if (autoDaRimuovere != null) { // Se l'auto è stata trovata
                        officina.rimuoviAuto(autoDaRimuovere); // Rimuove l'auto dalla lista
                        System.out.println("Auto rimossa con successo!");
                    } else {
                        System.out.println("Auto non trovata.");
                    }
                    break;
                case 3:
                    // Visualizzazione di tutte le auto
                    if (officina.getAutoList().isEmpty()) {
                        System.out.println("Nessuna auto presente nell'officina.");
                        break;
                    }
                    // Stampa delle auto presenti nell'officina
                    System.out.println("Ecco tutte le auto nell'officina:");
                    officina.visualizzaAuto(); // Chiama il metodo per visualizzare le auto
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }

        } while (true);
    }
}
