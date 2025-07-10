package corsoJavaBackend.Settimana2.lezione6_30_06_2025.ApprofondimentoRiepilogoMetodi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EsercizioParoleChiaveEModificatoriDelleFunzioni {
    // Esercizio 1 : Funzione base
    static int somma(int a, int b) {// ritorna la somma di due numeri e restituisce il risultato
        return a + b;
    }

    // Esercizio 2 : Sfida su ll'overloading
    static float multiply(float n1, float n2, float n3) {// accetta 3 numeri con virgola mobile, ritorna un numero con
                                                         // virgola
        // mobile che è il risultato della moltiplcazione dei due numeri passati
        return n1 * n2 * n3;
    }

    // Overloading del metodo multiply
    static int multiply(int n1, int n2) { // accetta 2 interi ritorna la moltiplicazione tra i due interi passati
        return n1 * n2;
    }

    // Esercizio 3 : Ricorsione - somma dei numeri naturali
    static int sommaNumeriNaturali(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sommaNumeriNaturali(n - 1);
    }// accetta un intero ritorna la somma dei numeri naturali che lo compongono

    // Esercizio 4 :
    // Passaggio per Valore e passaggio per Riferimento
    static void modifica(int n) {
        n += 10;
    }

    // override metodo
    static void modifica(int[] numeri) {
        numeri[0] = 666;
    }

    // Stampa array generico
    static void stampaArrayList(ArrayList<String> arr) {
        for (String elemento : arr) {
            System.out.println(elemento);
        }
    }

    // funzione ricorsiva menu
    static void menu() {
        Scanner scanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        System.out.println("quale esercizio vuoi provare?\n\"ES1\"\n\"ES2\"\n\"ES3\"\n\"ES4\"\n\"EXTRA\"");
        String scelta = scanner.nextLine();
        int n1;
        int n2;

        // switch per il menu
        switch (scelta.toLowerCase()) {
            case "es1":
                // utilizzo la funzione somma es 1
                System.out.println("Inserisci i numeri che vuoi sommare");
                System.out.println("Primo numero");
                n1 = intScanner.nextInt();
                System.out.println("Secondo numero");
                n2 = intScanner.nextInt();
                System.err.println("Risultato operazione somma tra " + n1 + "+" + n2 + "=" + somma(n1, n2));
                break;
            case "es2":
                System.out.println(
                        "moltiplica 3 numeri con la virgola o 2 numeri interi \n inserisci \"INT\" x interi o \"FLOAT\" per virgola mobile , \"BACK\" per tornare al menu ");
                scelta = scanner.nextLine();
                switch (scelta.toLowerCase()) {
                    case "int":
                        System.out.println("Inserisci 2 numeri interi per ottenere il loro prodotto");
                        System.out.println("Inserisci il primo numero");
                        n1 = intScanner.nextInt();
                        System.out.println("Inserisci il secondo numero");
                        n2 = intScanner.nextInt();
                        System.out.println(
                                "Risultato operazione moltiplicazione tra " + n1 + "*" + n2 + "=" + multiply(n1, n2));
                        break;
                    case "float":
                        System.out.println("Inserisci 3 numeri con \"virgola mobile\" per ottenere il loro prodotto");
                        System.out.println("Inserisci il primo numero");
                        float f1 = intScanner.nextFloat();
                        System.out.println("Inserisci il secondo numero");
                        float f2 = intScanner.nextFloat();
                        System.out.println("Inserisci il terzo numero");
                        float f3 = intScanner.nextFloat();
                        System.out.println(
                                "Risultato operazione moltiplicazione tra " + f1 + "*" + f2 + "*" + f3 + "="
                                        + multiply(f1, f2, f3));
                        break;
                    case "back":
                        System.out.println("sei tornato al menu");
                        break;
                    default:
                        System.out.println("Scelta non valida, torni al menu");
                        break;
                }
                break;
            case "es3":
                System.out.println("Inserisci un numero intero per ottenere la somma dei numeri che lo compongono");
                n1 = intScanner.nextInt();
                System.out.println("La somma dei numeri che compongono " + n1 + " è :" + sommaNumeriNaturali(n1));

                break;
            case "es4":
                System.out.println("Testiamo il passaggio per valore e per riferimento");
                System.out.println("Inserisci un numero intero da modificare");
                n1 = intScanner.nextInt();
                // passaggio per valore
                System.out.println("Numero prima della modifica :" + n1);
                modifica(5);
                System.out.println("Numero dopo la modifica :" + n1);

                System.out.println("Testiamo il passaggio per riferimento");
                System.out.println("Inserisci 3 numeri da modificare");
                int[] numeri = new int[3];
                for (int i = 0; i < numeri.length; i++) {
                    numeri[i] = intScanner.nextInt();
                }
                System.out.println("Stampa lista numeri prima della modifica :" + Arrays.toString(numeri));
                modifica(numeri);
                System.out.println(
                        "Stampa array 3 numeri dopo la modifica del primo elemento :" + Arrays.toString(numeri));

                break;
            case "extra":
                // creo un oggetto di tipo arraylist che conterra la lista di parole
                ArrayList<String> myArrayList = new ArrayList<>();
                int counter = 1;
                do {
                    System.out.println("Aggiungi una o più parole, e \"fine\" per stampare");
                    System.out.println("Inserisci la " + counter + "° parola");
                    String parola = scanner.nextLine();

                    // se la parola è fine richiamo la funzione stampaArrayList per stampare la
                    // lista dell'utente altrimenti aggiungo la parola alla lista e auomento il
                    // counter
                    if (parola.equals("fine")) {
                        stampaArrayList(myArrayList);
                        break;
                    } else {
                        myArrayList.add(parola);
                        counter++;
                    }
                } while (true);
                // condizione di uscita scelta."equals"("fine")

            case "fine":
                return;// return esco dal menu -> chiudo la ricorsione
            default:
                break;
        }

        menu();
    }

    public static void main(String[] args) {
        menu();

    }
}
