import java.util.Scanner;

// Strategy Interface
interface ParadoxResolutionStrategy {
    void handleParadox();
}

// Concrete Strategy 1: Ignore Paradoxes
class IgnoreParadoxStrategy implements ParadoxResolutionStrategy {
    @Override
    public void handleParadox() {
        System.out.println("Ignoring the paradox... Pretending nothing happened.");
    }
}

// Concrete Strategy 2: Alternate Timeline Creation
class AlternateTimelineStrategy implements ParadoxResolutionStrategy {
    @Override
    public void handleParadox() {
        System.out.println("Creating an alternate timeline... A new universe is born.");
    }
}

// Concrete Strategy 3: Self-Correcting History
class SelfCorrectingHistoryStrategy implements ParadoxResolutionStrategy {
    @Override
    public void handleParadox() {
        System.out.println("Self-correcting history... The time traveler is erased retroactively.");
    }
}

// Context Class
class TimeParadoxContext {
    private ParadoxResolutionStrategy resolutionStrategy;

    public void setResolutionStrategy(ParadoxResolutionStrategy resolutionStrategy) {
        this.resolutionStrategy = resolutionStrategy;
    }

    public void resolveParadox() {
        if (resolutionStrategy != null) {
            resolutionStrategy.handleParadox();
        } else {
            System.out.println("No paradox resolution strategy selected!");
        }
    }
}

// Client Class (Main Program)
public class TimeTravelParadox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeParadoxContext paradoxContext = new TimeParadoxContext();

        System.out.println("Choose a paradox resolution strategy:");
        System.out.println("1. Ignore Paradoxes");
        System.out.println("2. Alternate Timeline Creation");
        System.out.println("3. Self-Correcting History");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                paradoxContext.setResolutionStrategy(new IgnoreParadoxStrategy());
                break;
            case 2:
                paradoxContext.setResolutionStrategy(new AlternateTimelineStrategy());
                break;
            case 3:
                paradoxContext.setResolutionStrategy(new SelfCorrectingHistoryStrategy());
                break;
            default:
                System.out.println("Invalid choice! No resolution applied.");
                return;
        }

        paradoxContext.resolveParadox();
        scanner.close();
    }
}
