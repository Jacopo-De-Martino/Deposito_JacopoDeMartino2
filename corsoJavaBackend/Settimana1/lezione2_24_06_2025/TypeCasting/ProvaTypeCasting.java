package corsoJavaBackend.Settimana1.lezione2_24_06_2025.TypeCasting;

public class ProvaTypeCasting {
    // Metodo main
    public static void main(String[] args) {
        // PROVA CASTING IMPLICITO ED ESPLICITO
        // ! Casting IMPLICITO
        // (conversione implicità)
        int myInt = 19;
        System.out.println(myInt);
        double myDouble = myInt;
        System.out.printf("%.2f%n", myDouble);

        // ! Casting ESPLICITO
        // (conversione utilizzo di casting)
        myInt = (int) myDouble;
        // myInt = myDouble; ERRORE NON POSSO PERDERE DATI IN MODO IMPLICTO devo
        // necessariamente ESPLICITARLO UTILIZZANDO UN CASTING
        System.out.println(myInt);
    }

}
