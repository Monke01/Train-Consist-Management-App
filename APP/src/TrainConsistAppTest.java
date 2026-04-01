import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    TrainConsistApp app = new TrainConsistApp();

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        List<Bogie> result = app.filterBogies(bogies);

        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Special", 60));

        List<Bogie> result = app.filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = app.filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));

        List<Bogie> result = app.filterBogies(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = app.filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));

        List<Bogie> result = app.filterBogies(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = app.filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        app.filterBogies(bogies);

        assertEquals(2, bogies.size());
    }
}