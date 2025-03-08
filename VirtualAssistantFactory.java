import java.util.Scanner;
// Step 1: Define Virtual Assistant Interface
interface VirtualAssistant {
    void assist();
}

// Step 2: Concrete Virtual Assistant Implementations
class PersonalAssistant implements VirtualAssistant {
    @Override
    public void assist() {
        System.out.println("📅 Managing your schedule, setting reminders, and organizing tasks.");
    }
}

class CustomerSupportBot implements VirtualAssistant {
    @Override
    public void assist() {
        System.out.println("💬 Answering FAQs and assisting customers with their inquiries.");
    }
}

class HealthAdvisorAI implements VirtualAssistant {
    @Override
    public void assist() {
        System.out.println("🏋️ Tracking your fitness, giving medical advice, and reminding you to stay healthy.");
    }
}

class FinancialConsultantAI implements VirtualAssistant {
    @Override
    public void assist() {
        System.out.println("💰 Providing financial insights, budgeting help, and investment advice.");
    }
}

// Step 3: Assistant Factory
class AssistantFactory {
    public static VirtualAssistant createAssistant(String type) {
        switch (type.toLowerCase()) {
            case "personal":
                return new PersonalAssistant();
            case "customer":
                return new CustomerSupportBot();
            case "health":
                return new HealthAdvisorAI();
            case "finance":
                return new FinancialConsultantAI();
            default:
                throw new IllegalArgumentException("❌ Unknown assistant type: " + type);
        }
    }
}

// Step 4: Client Code
import java.util.Scanner;  // Import statement should be at the top.

public class VirtualAssistantFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🤖 Welcome to the AI-Powered Virtual Assistant Factory!");
        System.out.println("Select your assistant type (Personal, Customer, Health, Finance):");
        String assistantType = scanner.nextLine();

        try {
            VirtualAssistant assistant = AssistantFactory.createAssistant(assistantType);
            assistant.assist();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
