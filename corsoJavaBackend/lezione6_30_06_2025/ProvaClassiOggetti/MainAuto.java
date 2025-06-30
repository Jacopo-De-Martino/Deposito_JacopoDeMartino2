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

}

public class MainAuto {
    public static void main(String[] args) {
        Auto myAuto = new Auto("Fiat", 1998, 2000.00);
        myAuto.mostraInfo();

    }
}
