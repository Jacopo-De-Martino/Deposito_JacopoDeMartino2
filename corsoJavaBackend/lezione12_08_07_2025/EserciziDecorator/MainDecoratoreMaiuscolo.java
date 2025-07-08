package corsoJavaBackend.lezione12_08_07_2025.EserciziDecorator;

public class MainDecoratoreMaiuscolo {
    public static void main(String[] args) {
        Messaggio base = new MessaggioBase();
        System.out.println(base.getContenuto());
        Decoratore maiuscolo = new DecoratoreMaiuscolo(base);
        System.out.println(maiuscolo.getContenuto());

    }
}
