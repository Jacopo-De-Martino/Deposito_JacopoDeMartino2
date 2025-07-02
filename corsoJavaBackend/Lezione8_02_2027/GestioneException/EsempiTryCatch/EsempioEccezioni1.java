
public class EsempioEccezioni1 {
    public static void main(String[] args) {
        try {
            int a = 5;
            int b = 0;
            int c = a / b;
            System.out.println(c);

        } catch (ArithmeticException ex) {
            ex.printStackTrace();
            int d = 3 / 0;
            System.out.println(d);
        } finally {
            System.out.println("finally");
        }
        System.out.println("Programma terminato");

    }

}
