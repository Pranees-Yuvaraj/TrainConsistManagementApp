import java.util.ArrayList;
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        ArrayList<String> bogies = new ArrayList<>();
        System.out.println("Train Consist Initialized.");
        System.out.println("Initial Bogie Count: " + bogies.size());
        System.out.println();
        System.out.println("--- UC2: Add Passenger Bogies ---");
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");
        System.out.println("Bogies after addition: " + bogies);
        System.out.println("Total Bogie Count: " + bogies.size());
        System.out.println();
        bogies.remove("AC Chair");
        System.out.println("After removing 'AC Chair': " + bogies);
        System.out.println();
        boolean hasSleeperCoach = bogies.contains("Sleeper");
        System.out.println("Does 'Sleeper' bogie exist? " + hasSleeperCoach);
        System.out.println();
        System.out.println("Final Bogie List: " + bogies);
        System.out.println("Final Bogie Count: " + bogies.size());
        System.out.println();
        System.out.println("Program continues...");
    }
}