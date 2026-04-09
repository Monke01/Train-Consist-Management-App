import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmntTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistMgmnt.GoodsBogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainConsistMgmnt.GoodsBogie("Open", "Coal"));

        assertTrue(TrainConsistMgmnt.validateSafety(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistMgmnt.GoodsBogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistMgmnt.validateSafety(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistMgmnt.GoodsBogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmnt.GoodsBogie("Open", "Coal"));
        list.add(new TrainConsistMgmnt.GoodsBogie("Box", "Grain"));

        assertTrue(TrainConsistMgmnt.validateSafety(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistMgmnt.GoodsBogie> list = new ArrayList<>();

        list.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistMgmnt.validateSafety(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistMgmnt.GoodsBogie> list = new ArrayList<>();

        assertTrue(TrainConsistMgmnt.validateSafety(list));
    }
}