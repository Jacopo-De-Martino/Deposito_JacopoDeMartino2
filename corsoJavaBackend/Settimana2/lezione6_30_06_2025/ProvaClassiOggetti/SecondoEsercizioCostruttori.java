package corsoJavaBackend.Settimana2.lezione6_30_06_2025.ProvaClassiOggetti;

import java.util.Scanner;

class Persona {
    int eta;
    String citta;
    String nome;
    static int totPersone = 0;

    // costruttore con parametri
    public Persona(String citta, String nome) {
        this.citta = citta;
        this.eta = 21; // 21 valore standard per questi oggetti di tipo persona
        this.nome = nome;
        totPersone++;
    }

    public void stampaPersona() {
        System.out.println("Nome : " + nome + " Citta : " + citta + " Eta : " + eta);
    }

    public void saluta() {
        System.err.println("Ciao a tutti sono " + nome);

    }
}

public class SecondoEsercizioCostruttori {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il tuo nome");
        String nome = scanner.nextLine();
        System.out.println("Inserisci la tua città");
        String citta = scanner.nextLine();
        Persona p1 = new Persona(citta, nome);
        p1.stampaPersona();
        p1.saluta();

        System.out.println("Inserisci il tuo nome");
        nome = scanner.nextLine();
        System.out.println("Inserisci la tua città");
        citta = scanner.nextLine();
        Persona p2 = new Persona(citta, nome);
        p2.stampaPersona();
        p2.saluta();
    }

}
