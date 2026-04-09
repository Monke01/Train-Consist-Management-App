import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UseCase14TrainConsistMgmtTest {

    // ✅ Valid capacity
    @Test
    void testException_ValidCapacityCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b =
                new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);

        assertNotNull(b);
    }

    // ❌ Negative capacity
    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", -10)
        );

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // ❌ Zero capacity
    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 0)
        );

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // ✅ Message validation
    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 0)
        );

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // ✅ Object integrity
    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b =
                new UseCase14TrainConsistMgmt.PassengerBogie("AC Chair", 50);

        assertEquals("AC Chair", b.type);
        assertEquals(50, b.capacity);
    }

    // ✅ Multiple valid bogies
    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        List<UseCase14TrainConsistMgmt.PassengerBogie> list = new ArrayList<>();

        list.add(new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72));
        list.add(new UseCase14TrainConsistMgmt.PassengerBogie("AC Chair", 50));

        assertEquals(2, list.size());
    }
}