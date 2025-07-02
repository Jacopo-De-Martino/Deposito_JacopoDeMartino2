package corsoJavaBackend.Lezione8_02_2027.ProvaEreditarietà;

class Vehicle {
    protected String brand = "Ford";

    public void honk() {
        System.out.println("Tuut,tuut");
    }
}

class Car extends Vehicle {
    private String modelName = "Fiat";

    public String getModelName() {
        return modelName;
    }
}

public class ProvaEreditarieta {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.honk();
        System.out.println(myCar.brand + " " + myCar.getModelName());
    }
}
