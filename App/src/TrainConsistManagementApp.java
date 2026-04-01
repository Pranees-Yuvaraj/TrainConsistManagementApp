import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        System.out.println("--- UC13: Performance Comparison (Loops vs Streams) ---");
        System.out.println();

        List<Bogie> bogieList = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogieList.add(new Bogie("Bogie-" + i, i % 150));
        }

        System.out.println("Dataset size: " + bogieList.size() + " bogies");
        System.out.println("Filter condition: capacity > 60");
        System.out.println();

        // ---- Loop-based filtering ----
        long loopStart = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        System.out.println("Loop-Based Filtering:");
        System.out.println("  Bogies matched : " + loopResult.size());
        System.out.println("  Time taken     : " + loopDuration + " ns  (" + loopDuration / 1_000_000 + " ms)");
        System.out.println();

        // ---- Stream-based filtering ----
        long streamStart = System.nanoTime();

        List<Bogie> streamResult = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        System.out.println("Stream-Based Filtering:");
        System.out.println("  Bogies matched : " + streamResult.size());
        System.out.println("  Time taken     : " + streamDuration + " ns  (" + streamDuration / 1_000_000 + " ms)");
        System.out.println();

        // ---- Comparison Summary ----
        System.out.println("======================================");
        System.out.println("  Performance Summary");
        System.out.println("======================================");
        System.out.println("  Loop   duration : " + loopDuration + " ns");
        System.out.println("  Stream duration : " + streamDuration + " ns");
        System.out.println();

        if (loopDuration < streamDuration) {
            System.out.println("  Result: Loop was faster by " + (streamDuration - loopDuration) + " ns");
        } else if (streamDuration < loopDuration) {
            System.out.println("  Result: Stream was faster by " + (loopDuration - streamDuration) + " ns");
        } else {
            System.out.println("  Result: Both performed equally.");
        }
        System.out.println("======================================");
        System.out.println();
        System.out.println("  Note: First stream run may be slower due to JVM warm-up.");
        System.out.println("        Streams offer better readability and scalability.");
        System.out.println("        For large datasets, parallel streams can outperform loops.");
        System.out.println();

        System.out.println("Program continues...");
    }
}