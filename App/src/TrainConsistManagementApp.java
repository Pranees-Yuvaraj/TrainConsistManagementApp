import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
        System.out.println("--- UC3: Track Unique Bogie IDs (HashSet) ---");
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("B001");
        bogieIDs.add("B002");
        bogieIDs.add("B003");
        bogieIDs.add("B001");
        bogieIDs.add("B002");
        System.out.println("Unique Bogie IDs: " + bogieIDs);
        System.out.println("Total Unique Bogie Count: " + bogieIDs.size());
        System.out.println();
        boolean wasAdded = bogieIDs.add("B003");
        System.out.println("Trying to add 'B003' again...");
        System.out.println("Was 'B003' added? " + wasAdded);
        System.out.println();
        System.out.println("Does 'B002' exist? " + bogieIDs.contains("B002"));
        System.out.println("Does 'B999' exist? " + bogieIDs.contains("B999"));
        System.out.println();
        System.out.println("Final Unique Bogie IDs: " + bogieIDs);
        System.out.println("Program continues...");
    }
}