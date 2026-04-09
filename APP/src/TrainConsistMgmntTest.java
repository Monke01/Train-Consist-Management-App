import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistMgmntTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistMgmnt.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistMgmnt.validateTrainID("TRAIN12"));
        assertFalse(TrainConsistMgmnt.validateTrainID("TRN12A"));
        assertFalse(TrainConsistMgmnt.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistMgmnt.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistMgmnt.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistMgmnt.validateCargoCode("PET123"));
        assertFalse(TrainConsistMgmnt.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistMgmnt.validateTrainID("TRN-123"));
        assertFalse(TrainConsistMgmnt.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistMgmnt.validateCargoCode("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistMgmnt.validateTrainID(""));
        assertFalse(TrainConsistMgmnt.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistMgmnt.validateTrainID("TRN-1234XYZ"));
        assertFalse(TrainConsistMgmnt.validateCargoCode("PET-ABCD"));
    }
}