import java.util.Scanner;

// Step 1: Define Robot Interface
interface Robot {
    void explore();
}

// Step 2: Concrete Robots for Different Planets
class MarsRobot implements Robot {
    @Override
    public void explore() {
        System.out.println("🚀 Mars Robot activated! Navigating rocky terrain and surviving dust storms.");
    }
}

class MoonRobot implements Robot {
    @Override
    public void explore() {
        System.out.println("🌕 Moon Robot activated! Handling low gravity and high radiation.");
    }
}

class EuropaRobot implements Robot {
    @Override
    public void explore() {
        System.out.println("🧊 Europa Robot activated! Drilling through ice to search for alien life.");
    }
}

// Step 3: Robot Factory
class RobotFactory {
    public static Robot createRobot(String planet) {
        switch (planet.toLowerCase()) {
            case "mars":
                return new MarsRobot();
            case "moon":
                return new MoonRobot();
            case "europa":
                return new EuropaRobot();
            default:
                throw new IllegalArgumentException("❌ Unknown planet! No robot available for " + planet);
        }
    }
}

// Step 4: Client Code
public class SpaceExplorationRobotFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌍 Enter the planet for the mission (Mars, Moon, Europa):");
        String planet = scanner.nextLine();

        try {
            Robot robot = RobotFactory.createRobot(planet);
            robot.explore();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
