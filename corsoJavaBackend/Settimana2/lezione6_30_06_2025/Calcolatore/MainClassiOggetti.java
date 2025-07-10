package corsoJavaBackend.Settimana2.lezione6_30_06_2025.Calcolatore;

import java.util.ArrayList;

// class Calcolatrice main di utilizzo di Calcolatore
public class MainClassiOggetti {
    public static void main(String[] args) {
        Calcolatore calcolatore = new Calcolatore();
        System.out.println(calcolatore.somma(3, 6));

        ArrayList<Auto> automobili = new ArrayList<>();
        Auto auto1 = new Auto("Bmw", 2004);
        Auto auto2 = new Auto("Fiat", 1998);
        Auto auto3 = new Auto("Mercedes", 2020);
        Auto auto4 = new Auto("Volvo", 2000);
        automobili.add(auto1);
        automobili.add(auto2);
        automobili.add(auto3);
        automobili.add(auto4);
        for (Auto auto : automobili) {
            System.out.println(auto.marca + " - " + auto.anno);
        }
    }

}

// classe e metodi calcolatore
class Calcolatore {
    int somma(int a, int b) {
        return a + b;
    }
}

class Auto {
    String marca;
    int anno;

    Auto(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

}