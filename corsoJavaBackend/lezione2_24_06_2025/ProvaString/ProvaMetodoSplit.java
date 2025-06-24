package ProvaString;

import java.util.Arrays;

public class ProvaMetodoSplit {
    // Classe dedicata per testare il metodo split()
    public static void main(String[] args) {
        String str = "Hello World";
        // Splittiamo una Stringa usando una regez che divide la stringa ad ogni spazio
        String[] words = str.split("\\s");
        // Stampia l'array creato dalla funzione plit() utilizzando la utils Arrays e il
        // metodo .toString()
        System.out.println(Arrays.toString(words));
    }
}
