import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmt {

    // ================= UC12: Goods Bogie =================
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Safety validation (UC12)
    public static boolean validateSafety(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream().allMatch(bogie ->
                !bogie.type.equalsIgnoreCase("Cylindrical")
                        || bogie.cargo.equalsIgnoreCase("Petroleum")
        );
    }

    // ================= UC13: Performance Comparison =================

    // Bogie model (for UC13)
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Loop-based filtering
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();
    }

    // Performance comparison
    public static void comparePerformance() {

        System.out.println("===============================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("===============================================\n");

        // Create dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        // Loop timing
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies);
        long endLoop = System.nanoTime();

        // Stream timing
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies);
        long endStream = System.nanoTime();

        // Output
        System.out.println("Loop Execution Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Execution Time (ns): " + (endStream - startStream));

        System.out.println("\nUC13 performance benchmarking completed...");
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        // UC12 Demo
        List<GoodsBogie> goodsList = new ArrayList<>();
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Open", "Coal"));

        System.out.println("Safety Valid: " + validateSafety(goodsList));

        // UC13 Demo
        comparePerformance();
    }
}