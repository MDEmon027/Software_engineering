import java.util.Scanner;

// Step 1: Define Dream Interface
interface Dream {
    void experience();
}

// Step 2: Concrete Dream Implementations
class AdventureDream implements Dream {
    @Override
    public void experience() {
        System.out.println("🏔️ You are climbing a mystical mountain, searching for the lost city of gold!");
    }
}

class RomanticDream implements Dream {
    @Override
    public void experience() {
        System.out.println("💖 You are walking along a moonlit beach with your soulmate.");
    }
}

class SciFiDream implements Dream {
    @Override
    public void experience() {
        System.out.println("🚀 You are piloting a spaceship through a wormhole to a new galaxy!");
    }
}

class HorrorDream implements Dream {
    @Override
    public void experience() {
        System.out.println("👻 You are trapped in a haunted mansion where whispers echo in the dark...");
    }
}

// Step 3: Dream Factory
class DreamFactory {
    public static Dream createDream(String type) {
        switch (type.toLowerCase()) {
            case "adventure":
                return new AdventureDream();
            case "romance":
                return new RomanticDream();
            case "scifi":
                return new SciFiDream();
            case "horror":
                return new HorrorDream();
            default:
                throw new IllegalArgumentException("❌ Unknown dream type: " + type);
        }
    }
}

// Step 4: Client Code
public class PersonalizedDreamSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("💤 Welcome to the Personalized Dream Simulator!");
        System.out.println("Select your dream type (Adventure, Romance, SciFi, Horror):");
        String dreamType = scanner.nextLine();

        try {
            Dream dream = DreamFactory.createDream(dreamType);
            dream.experience();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
