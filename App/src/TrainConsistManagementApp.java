import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String name;
        String type;
        String cargo;

        GoodsBogie(String name, String type, String cargo) {
            this.name = name;
            this.type = type;
            this.cargo = cargo;
        }

        public String toString() {
            return name + " [Type: " + type + " | Cargo: " + cargo + "]";
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        System.out.println("--- UC12: Safety Compliance Check for Goods Bogies ---");
        System.out.println();

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Goods-01", "Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Goods-02", "Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Goods-03", "Flat",        "Steel"));
        goodsBogies.add(new GoodsBogie("Goods-04", "Flat",        "Grain"));

        System.out.println("Goods Bogies in Consist:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println("  " + b);
        }
        System.out.println();

        boolean isSafeCompliant = goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("Safety Rule: Cylindrical bogies must carry Petroleum only.");
        System.out.println("Compliance Check Result: " + (isSafeCompliant ? "PASS" : "FAIL"));
        System.out.println();

        if (isSafeCompliant) {
            System.out.println("======================================");
            System.out.println("  SAFETY COMPLIANCE STATUS : APPROVED");
            System.out.println("  Train is cleared for departure.");
            System.out.println("======================================");
        } else {
            System.out.println("======================================");
            System.out.println("  SAFETY COMPLIANCE STATUS : REJECTED");
            System.out.println("  Train failed safety inspection.");
            System.out.println("======================================");
        }
        System.out.println();

        System.out.println("-- Failure Scenario (Cylindrical bogie carrying Chemicals) --");
        goodsBogies.add(new GoodsBogie("Goods-05", "Cylindrical", "Chemicals"));
        System.out.println("Added: " + goodsBogies.get(goodsBogies.size() - 1));
        System.out.println();

        boolean isSafeCompliantRetry = goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("Safety Rule: Cylindrical bogies must carry Petroleum only.");
        System.out.println("Compliance Check Result: " + (isSafeCompliantRetry ? "PASS" : "FAIL"));
        System.out.println();

        if (isSafeCompliantRetry) {
            System.out.println("======================================");
            System.out.println("  SAFETY COMPLIANCE STATUS : APPROVED");
            System.out.println("  Train is cleared for departure.");
            System.out.println("======================================");
        } else {
            System.out.println("======================================");
            System.out.println("  SAFETY COMPLIANCE STATUS : REJECTED");
            System.out.println("  Train failed safety inspection.");
            System.out.println("======================================");
        }
        System.out.println();

        System.out.println("Program continues...");
    }
}