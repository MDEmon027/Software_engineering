// Step 1: Define the Strategy Interface
interface TrafficControlStrategy {
    void adjustSignalTiming();
}

// Step 2: Implement Concrete Strategies

// Normal Traffic: Standard timing
class NormalTrafficStrategy implements TrafficControlStrategy {
    @Override
    public void adjustSignalTiming() {
        System.out.println("Normal Traffic: Green - 60s, Yellow - 5s, Red - 60s.");
    }
}

// Heavy Traffic: Longer green light to reduce congestion
class HeavyTrafficStrategy implements TrafficControlStrategy {
    @Override
    public void adjustSignalTiming() {
        System.out.println("Heavy Traffic: Green - 90s, Yellow - 5s, Red - 45s.");
    }
}

// Rainy Weather: Shorter green light to ensure safety
class RainyWeatherStrategy implements TrafficControlStrategy {
    @Override
    public void adjustSignalTiming() {
        System.out.println("Rainy Weather: Green - 40s, Yellow - 5s, Red - 70s.");
    }
}

// Step 3: Context Class to Use Strategy
class TrafficSignalController {
    private TrafficControlStrategy strategy;

    // Set the strategy at runtime
    public void setTrafficControlStrategy(TrafficControlStrategy strategy) {
        this.strategy = strategy;
    }

    public void controlTraffic() {
        if (strategy == null) {
            System.out.println("No traffic strategy selected!");
        } else {
            strategy.adjustSignalTiming();
        }
    }
}

// Step 4: Client Code to Demonstrate Strategy Pattern
public class StrategyPatternTraffic {
    public static void main(String[] args) {
        TrafficSignalController controller = new TrafficSignalController();

        // Normal Traffic
        controller.setTrafficControlStrategy(new NormalTrafficStrategy());
        controller.controlTraffic();

        // Heavy Traffic
        controller.setTrafficControlStrategy(new HeavyTrafficStrategy());
        controller.controlTraffic();

        // Rainy Weather
        controller.setTrafficControlStrategy(new RainyWeatherStrategy());
        controller.controlTraffic();
    }
}
