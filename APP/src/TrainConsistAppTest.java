import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    TrainConsistApp app = new TrainConsistApp();

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(1, result.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("AC Chair", 60));

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        app.groupBogiesByType(bogies);

        assertEquals(1, bogies.size());
    }
}