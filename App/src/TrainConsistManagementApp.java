import java.util.Scanner;

public class TrainConsistManagementApp {
    public static void assignCargo(Bogie bogie, String cargo) {

        try {
            System.out.println("\nAttempting to assign cargo...");

            // 🚨 Rule Check
            if (cargo.equalsIgnoreCase("petroleum") &&
                bogie.getShape().equalsIgnoreCase("rectangular")) {

                throw new CargoSafetyException(
                    "Unsafe Cargo! Petroleum cannot be loaded in a rectangular bogie."
                );
            }

            // ✅ Safe Assignment
            bogie.setCargo(cargo);
            System.out.println("✅ Cargo '" + cargo + "' assigned successfully to "
                    + bogie.getShape() + " bogie.");

        } catch (CargoSafetyException e) {
            System.out.println("❌ ERROR: " + e.getMessage());

        } finally {
            System.out.println("📋 Logging: Cargo assignment attempt completed.");
        }
    }

    // 🎮 Main Method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("🚆 Train Consist Management System - UC15");

        // Create Bogie
        System.out.print("\nEnter bogie shape (rectangular/cylindrical): ");
        String shape = scanner.nextLine();

        Bogie bogie = new Bogie(shape);

        // Enter Cargo
        System.out.print("Enter cargo type: ");
        String cargo = scanner.nextLine();

        // Assign Cargo
        assignCargo(bogie, cargo);

        // Show Final Status
        if (bogie.getCargo() != null) {
            System.out.println("\n🚃 Final Status: Cargo = " + bogie.getCargo());
        } else {
            System.out.println("\n🚃 Final Status: No cargo assigned due to safety restrictions.");
        }

        System.out.println("\n🚀 Program continues safely...");

        scanner.close();
    }
}