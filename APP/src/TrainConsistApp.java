import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistApp {

    public List<Bogie> filterBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        TrainConsistApp app = new TrainConsistApp();

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("===========================================\n");

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }

        List<Bogie> filtered = app.filterBogies(bogies);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
    }
}