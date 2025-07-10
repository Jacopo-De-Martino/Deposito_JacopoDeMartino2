package corsoJavaBackend.Settimana1.lezione4_26_06_2025.ProvaArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProvaArrayList {
    public static void main(String[] args) {
        // utilizzo array list per collezionare dei numeri
        List<Integer> numeri = new ArrayList<>();
        // aggiungo numeri al mio ArrayList numeri utilizzando il metodo .add()
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);
        numeri.add(40);
        for (int numero : numeri) {
            System.out.println(numero);
        }

        // esempio string
        List<String> nomi = new ArrayList<>();
        nomi.add("Luca");
        nomi.add("Jacopo");
        // stampo la lunghezza dell'arraylist usando il .size()
        System.out.println(nomi.size());// 2
        // tampo i singoli nomi della lista
        for (String nome : nomi) {
            System.out.println(nome);
        }

        // Array list con Math.random
        List<Integer> numeriRandom = new ArrayList<>();
        // aggiunta 10 numeri random
        for (int i = 0; i < 10; i++) {
            numeriRandom.add((int) (Math.random() * 100) + 1);
        }
        System.out.println("Lista originale : " + numeriRandom);
        // Ordinamento in modo crescente classe Collections metodo .sort(Collezione c)
        Collections.sort(numeriRandom);
        // utilizzo il metodo reversed per sortarli in modo decrescente
        System.out.println("Lista ordinata " + numeriRandom.reversed());

    }
}
