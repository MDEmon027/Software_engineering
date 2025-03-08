import java.util.Scanner;// Step 1: Define Smart Home Device Interface
interface SmartHomeDevice {
    void activate();
}

// Step 2: Concrete Smart Home Devices

class SmartLight implements SmartHomeDevice {
    @Override
    public void activate() {
        System.out.println("💡 Smart Light is now ON. Adjusting brightness and color.");
    }
}

class SmartThermostat implements SmartHomeDevice {
    @Override
    public void activate() {
        System.out.println("🌡️ Smart Thermostat is adjusting the temperature.");
    }
}

class SmartCamera implements SmartHomeDevice {
    @Override
    public void activate() {
        System.out.println("📹 Smart Camera is now monitoring the security of your home.");
    }
}

class SmartSpeaker implements SmartHomeDevice {
    @Override
    public void activate() {
        System.out.println("🎶 Smart Speaker is now playing your favorite music.");
    }
}

// Step 3: Device Factory
class DeviceFactory {
    public static SmartHomeDevice createDevice(String deviceType) {
        switch (deviceType.toLowerCase()) {
            case "light":
                return new SmartLight();
            case "thermostat":
                return new SmartThermostat();
            case "camera":
                return new SmartCamera();
            case "speaker":
                return new SmartSpeaker();
            default:
                throw new IllegalArgumentException("❌ Unknown device type: " + deviceType);
        }
    }
}

// Step 4: Client Code
import java.util.Scanner;

public class SmartHomeDeviceFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🏠 Welcome to the Smart Home Device Factory!");
        System.out.println("Select a device type (Light, Thermostat, Camera, Speaker):");
        String deviceType = scanner.nextLine();

        try {
            SmartHomeDevice device = DeviceFactory.createDevice(deviceType);
            device.activate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
