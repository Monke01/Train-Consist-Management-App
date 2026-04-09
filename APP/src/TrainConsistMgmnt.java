import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmnt {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Safety validation method
    public static boolean validateSafety(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream().allMatch(bogie ->
                !bogie.type.equalsIgnoreCase("Cylindrical")
                        || bogie.cargo.equalsIgnoreCase("Petroleum")
        );
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("======================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // invalid

        // Display bogies
        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie bogie : goodsBogies) {
            System.out.println(bogie.type + " -> " + bogie.cargo);
        }

        // Safety check
        boolean safe = validateSafety(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + safe);

        if (safe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}