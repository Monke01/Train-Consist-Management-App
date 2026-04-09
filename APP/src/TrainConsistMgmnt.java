import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistMgmnt {

    // Regex patterns
    private static final String TRAIN_REGEX = "TRN-\\d{4}";
    private static final String CARGO_REGEX = "PET-[A-Z]{2}";

    // Validate Train ID
    public static boolean validateTrainID(String trainId) {
        Pattern pattern = Pattern.compile(TRAIN_REGEX);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    // Validate Cargo Code
    public static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("======================================");

        // Input Train ID
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        // Input Cargo Code
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validation
        boolean trainValid = validateTrainID(trainId);
        boolean cargoValid = validateCargoCode(cargoCode);

        // Output
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + trainValid);
        System.out.println("Cargo Code Valid: " + cargoValid);

        // Detailed messages
        if (!trainValid) {
            System.out.println("Invalid Train ID! Must follow format TRN-1234");
        }

        if (!cargoValid) {
            System.out.println("Invalid Cargo Code! Must follow format PET-AB");
        }

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}