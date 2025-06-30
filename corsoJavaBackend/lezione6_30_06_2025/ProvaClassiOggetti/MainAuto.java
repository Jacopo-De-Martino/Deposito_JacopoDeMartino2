package corsoJavaBackend.lezione6_30_06_2025.ProvaClassiOggetti;

class Auto {
    String marca;
    int anno;
    double prezzo;

    void mostraInfo() {
        System.out.println(marca + " - " + anno + " - Euro :" + prezzo);
    }

    public Auto(String marca, int anno, double prezzo) {
        this.marca = marca;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    public Auto() {
    }

}

class Studente {
    int id;
    String nome;
    static int totaleStudenti = 0;

    public Studente(String nome) {
        this.nome = nome;
        totaleStudenti++;
        this.id = totaleStudenti;
    }

    static int stampaContatore() {
        return Studente.totaleStudenti;
    }
}

public class MainAuto {
    public static void main(String[] args) {
        Auto myAuto = new Auto("Fiat", 1998, 2000.00);
        myAuto.mostraInfo();
        Auto auto2 = new Auto();
        auto2.marca = "Tesla";
        auto2.anno = 2016;
        auto2.prezzo = 25_000.99;
        System.out.println(auto2.marca + " - " + auto2.prezzo);

        Studente stud1 = new Studente("Luca");
        System.out
                .println("Nome : " + stud1.nome + " id :" + stud1.id + " Totale studenti :"
                        + Studente.stampaContatore());
        Studente stud2 = new Studente("Jacopo");
        System.out
                .println("Nome : " + stud2.nome + " id :" + stud2.id + " Totale studenti :"
                        + Studente.stampaContatore());

    }
}
