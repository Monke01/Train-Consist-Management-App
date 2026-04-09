import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmtTest {

    // ================= UC12 TESTS =================

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainConsistMgmt.GoodsBogie("Open", "Coal"));

        assertTrue(TrainConsistMgmt.validateSafety(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistMgmt.validateSafety(list));
    }

    // ================= UC13 TESTS =================

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistMgmt.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmt.Bogie("A", 50));
        list.add(new TrainConsistMgmt.Bogie("B", 70));

        List<TrainConsistMgmt.Bogie> result = TrainConsistMgmt.filterWithLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistMgmt.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmt.Bogie("A", 50));
        list.add(new TrainConsistMgmt.Bogie("B", 70));

        List<TrainConsistMgmt.Bogie> result = TrainConsistMgmt.filterWithStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistMgmt.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmt.Bogie("A", 50));
        list.add(new TrainConsistMgmt.Bogie("B", 70));
        list.add(new TrainConsistMgmt.Bogie("C", 80));

        List<TrainConsistMgmt.Bogie> loopResult = TrainConsistMgmt.filterWithLoop(list);
        List<TrainConsistMgmt.Bogie> streamResult = TrainConsistMgmt.filterWithStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistMgmt.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new TrainConsistMgmt.Bogie("A", i));
        }

        long start = System.nanoTime();
        TrainConsistMgmt.filterWithLoop(list);
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistMgmt.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            list.add(new TrainConsistMgmt.Bogie("A", i % 100));
        }

        List<TrainConsistMgmt.Bogie> result = TrainConsistMgmt.filterWithStream(list);

        assertNotNull(result);
    }
}