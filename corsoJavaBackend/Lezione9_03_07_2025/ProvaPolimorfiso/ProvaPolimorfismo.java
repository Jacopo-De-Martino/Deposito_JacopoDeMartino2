package corsoJavaBackend.Lezione9_03_07_2025.ProvaPolimorfiso;

import java.util.ArrayList;

class Forma {
    public void stampa() {
        System.out.println("Sono forma,l'oggetto padre");
    }
}

class Forma1 extends Forma {
    public void stampa() {
        System.out.println("Sono forma1,un figlio di forma");
    }
}

class Forma2 extends Forma {
    public void stampa() {
        System.out.println("Sono forma2,un figlio di forma");
    }
}

public class ProvaPolimorfismo {
    static ArrayList<Forma> forme = new ArrayList<Forma>();

    static void azionatore(Forma f) {
        f.stampa();
    }

    public static void main(String[] args) {
        Forma forma = new Forma();
        Forma forma1 = new Forma1();
        Forma forma2 = new Forma2();
        forme.add(forma);
        forme.add(forma1);
        forme.add(forma2);
        for (Forma f : forme) {
            azionatore(f);
        }

    }

}
