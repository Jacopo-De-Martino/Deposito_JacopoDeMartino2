package ProvaOperatori;

public class ProvaOperatori {
    public static void main(String[] args) {
        // ! Prova operatori matematici + , - , * , / , %
        int somma = 3 + 3; // 6
        int sottrazione = 4 - 3; // 1
        int moltiplicazione = 4 * 3; // 12
        int divisione = 9 / 3; // 3
        int resto = 9 % 3; // 0
        // ! Prova operatori incremento ++ e decremento --
        int num = 5;
        num--;
        System.out.println(num); // 4
        num++;
        num++;
        System.out.println(num); // 6

        // ! Prova operatori Assegnazione = , += , -= , */= , /= , %=
        int x = 0;
        x += 5;
        System.out.println(x); // 5
        x -= 3;
        System.out.println(x); // 2
        x *= 2;
        System.out.println(x); // 4
        x /= 2;
        System.out.println(x); // 2
        x %= 2;
        System.out.println(x); // 0

        // ! Prova operatori di Confronto , RITORNANO SEMPRE UN BOOLEANO TRUE || FALSE ,
        // ! == , != , < , > , <= , >= , equals()
        boolean èMaggiore = 6 > 3; // true
        boolean èMinore = 3 < 6; // true
        boolean èDiverso = 3 != 3; // false
        boolean èUguale = 3 == 3; // treu
        boolean èUgualeOMaggiore = 3 >= 1; // true
        boolean èUgualeOMinore = 3 <= 1; // false
        boolean sonoUguali = "ciao".equals("ciao"); // true equals() operatore ugualianza String/oggeti

        // ! Prova operatori Logici , "and" && , "or" || , "not" !
        boolean sonoVeri = (3 < 10) && (4 < 1); // false
        boolean unoDeiDueETrue = (3 > 10) || (4 > 1); // true
        x = 4;
        boolean nonEVero = !(x < 5 && x < 10); // false

    }
}
