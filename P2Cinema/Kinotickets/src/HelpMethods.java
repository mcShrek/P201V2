import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HelpMethods {


    public static int askForInt(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid number. Please enter a valid number.");
            }
        }
    }

    public static double askForDouble(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Invalid number. Please enter a valid number.");
            }
        }
    }

    public static LocalDate askForDate(Scanner scanner) {
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }
    }
    public static LocalTime askForTime(Scanner scanner) {
        while (true) {
            try {
                return LocalTime.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid time format. Try again.");
            }
        }

    }
}
