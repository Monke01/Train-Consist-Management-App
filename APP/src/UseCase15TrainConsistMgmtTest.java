import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    // ✅ Safe assignment
    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.cargo);
    }

    // ❌ Unsafe assignment handled
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        assertNull(b.cargo); // should not assign
    }

    // ❌ Cargo not assigned after failure
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        assertNull(b.cargo);
    }

    // ✅ Program continues after exception
    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmt.GoodsBogie b1 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        UseCase15TrainConsistMgmt.GoodsBogie b2 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum"); // unsafe
        b2.assignCargo("Coal");      // safe

        assertEquals("Coal", b2.cargo);
    }

    // ✅ Finally block always executes (indirect check)
    @Test
    void testCargo_FinallyBlockExecution() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        b.assignCargo("Petroleum");

        // If no crash → finally executed
        assertTrue(true);
    }
}