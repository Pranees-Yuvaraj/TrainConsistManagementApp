public class TrainConsistManagementApp {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("==============================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity");
        System.out.println("==============================================");
        System.out.println();

        // Valid bogie — capacity > 0
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Invalid bogie — capacity = 0
        try {
            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Invalid bogie — capacity < 0
        try {
            PassengerBogie negative = new PassengerBogie("First Class", -10);
            System.out.println("Created Bogie: " + negative);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("UC14 exception handling completed...");
    }
}