package corsoJavaBackend.Settimana3.lezione13_09_07_2025.Strategy;

interface Strategy {
    void execute();
}

// Strategie Concrete
class ConcreteStrategyA implements Strategy {
    public void execute() {
        System.out.println("Strategia A eseguita.");
    }
}

class ConcreteStrategyB implements Strategy {
    public void execute() {
        System.out.println("Strategia B eseguita.");
    }
}

// Context
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask() {
        strategy.execute();
    }
}

// Uso da parte del Client
public class ProvaStrategy {
    public static void main(String[] args) {

        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.performTask(); // Output: Strategia A eseguita.
        context.setStrategy(new ConcreteStrategyB());
        context.performTask(); // Output: Strategia B eseguita.
    }
}