// Step 1: Define the Strategy Interface
interface PathfindingStrategy {
    void findPath(String start, String end);
}

// Step 2: Implement Concrete Strategies
class RoadPathfinding implements PathfindingStrategy {
    @Override
    public void findPath(String start, String end) {
        System.out.println("Finding the shortest road route from " + start + " to " + end + " using A* algorithm.");
    }
}

class ForestPathfinding implements PathfindingStrategy {
    @Override
    public void findPath(String start, String end) {
        System.out.println("Finding an optimal forest path from " + start + " to " + end + " using Dijkstra's algorithm.");
    }
}

class WaterPathfinding implements PathfindingStrategy {
    @Override
    public void findPath(String start, String end) {
        System.out.println("Finding the best water route from " + start + " to " + end + " using Best-First Search.");
    }
}

// Step 3: Context Class to Use Strategy
class GameNavigator {
    private PathfindingStrategy strategy;

    // Set the strategy at runtime
    public void setPathfindingStrategy(PathfindingStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String start, String end) {
        if (strategy == null) {
            System.out.println("No pathfinding strategy selected!");
        } else {
            strategy.findPath(start, end);
        }
    }
}

// Step 4: Client Code to Demonstrate Strategy Pattern
public class StrategyPatternGame {
    public static void main(String[] args) {
        GameNavigator navigator = new GameNavigator();

        // Selecting Road Pathfinding Strategy
        navigator.setPathfindingStrategy(new RoadPathfinding());
        navigator.navigate("Town", "Castle");

        // Switching to Forest Pathfinding Strategy
        navigator.setPathfindingStrategy(new ForestPathfinding());
        navigator.navigate("Village", "Cave");

        // Switching to Water Pathfinding Strategy
        navigator.setPathfindingStrategy(new WaterPathfinding());
        navigator.navigate("Island", "Harbor");
    }
}
