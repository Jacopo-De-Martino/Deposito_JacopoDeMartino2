package corsoJavaBackend.Lezione7_01_07_2025.EserciziIncapsulamento;

import java.util.ArrayList;

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codiceId;

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
        }
        this.numeroPosti = numeroPosti;
    }

    public String getCodiceId() {
        return codiceId;
    }

    public void setCodiceId(String codiceId) {
        this.codiceId = codiceId;
    }

    // ! Metodi privati
    // Validazione valori x setter
    private boolean validitaPosti(int posti) {
        return posti <= 0 || posti > 200;
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
        if (aereo != null) {
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

    private void stampaInformazioniFlotta()
}

public class GestioneCompagniaAerea {
    public static void main(String[] args) {
        Aereo aereo1 = new Aereo();
        aereo1.setNumeroPosti(300);
    }
}
