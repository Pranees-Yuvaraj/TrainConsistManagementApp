import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

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
        System.out.println();

        System.out.println("--- UC4: Maintain Ordered Bogie Consist (LinkedList) ---");
        LinkedList<String> consist = new LinkedList<>();
        consist.addLast("Engine");
        consist.addLast("Sleeper");
        consist.addLast("AC");
        consist.addLast("Cargo");
        consist.addLast("Guard");
        System.out.println("Initial Train Consist: " + consist);
        System.out.println();
        consist.add(2, "Pantry Car");
        System.out.println("After inserting 'Pantry Car' at position 2: " + consist);
        System.out.println();
        String removedFirst = consist.removeFirst();
        System.out.println("Removed from front: " + removedFirst);
        System.out.println("Consist after removeFirst(): " + consist);
        System.out.println();
        String removedLast = consist.removeLast();
        System.out.println("Removed from end: " + removedLast);
        System.out.println("Consist after removeLast(): " + consist);
        System.out.println();
        System.out.println("First bogie (peekFirst): " + consist.peekFirst());
        System.out.println("Last bogie  (peekLast) : " + consist.peekLast());
        System.out.println();
        System.out.println("Final Ordered Train Consist: " + consist);
        System.out.println("Total Bogies in Consist: " + consist.size());
        System.out.println();

        System.out.println("--- UC5: Preserve Insertion Order of Bogies (LinkedHashSet) ---");
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");
        System.out.println("Train Formation (insertion order preserved): " + formation);
        System.out.println("Total Bogies in Formation: " + formation.size());
        System.out.println();
        boolean duplicateAdded = formation.add("Sleeper");
        System.out.println("Trying to attach 'Sleeper' again...");
        System.out.println("Was duplicate 'Sleeper' attached? " + duplicateAdded);
        System.out.println();
        System.out.println("Final Train Formation: " + formation);
        System.out.println();

        System.out.println("--- UC6: Map Bogie to Capacity (HashMap) ---");
        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 64);
        bogieCapacity.put("First Class", 18);
        bogieCapacity.put("Pantry Car", 0);
        bogieCapacity.put("Cargo", 100);
        System.out.println("Bogie Capacity Map: " + bogieCapacity);
        System.out.println();
        System.out.println("Bogie-wise Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("  Bogie: " + entry.getKey() + "  -->  Capacity: " + entry.getValue());
        }
        System.out.println();
        System.out.println("Capacity of 'Sleeper'  : " + bogieCapacity.get("Sleeper"));
        System.out.println("Capacity of 'AC Chair' : " + bogieCapacity.get("AC Chair"));
        System.out.println();
        bogieCapacity.put("Sleeper", 80);
        System.out.println("Updated 'Sleeper' capacity to 80.");
        System.out.println("New Capacity of 'Sleeper': " + bogieCapacity.get("Sleeper"));
        System.out.println();
        System.out.println("Does 'First Class' exist in map? " + bogieCapacity.containsKey("First Class"));
        System.out.println("Does 'Luxury' exist in map?    " + bogieCapacity.containsKey("Luxury"));
        System.out.println();
        System.out.println("Final Bogie Capacity Map:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("  " + entry.getKey() + " : " + entry.getValue() + " seats");
        }
        System.out.println();

        System.out.println("--- UC7: Sort Bogies by Capacity (Comparator) ---");
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 64));
        passengerBogies.add(new Bogie("First Class", 18));
        passengerBogies.add(new Bogie("General", 120));
        passengerBogies.add(new Bogie("Pantry Car", 10));

        System.out.println("Bogies before sorting:");
        for (Bogie b : passengerBogies) {
            System.out.println("  " + b);
        }
        System.out.println();

        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("Bogies sorted by capacity (ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println("  " + b);
        }
        System.out.println();

        passengerBogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("Bogies sorted by capacity (descending):");
        for (Bogie b : passengerBogies) {
            System.out.println("  " + b);
        }
        System.out.println();

        System.out.println("Highest capacity bogie: " + passengerBogies.get(0));
        System.out.println("Lowest  capacity bogie: " + passengerBogies.get(passengerBogies.size() - 1));
        System.out.println();

        System.out.println("Program continues...");
    }
}