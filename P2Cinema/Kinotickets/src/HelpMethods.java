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
    public static LocalDate askForDate(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Please type a date in the following format YYYY-MM-DD:");
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }
    }
    public static LocalTime askForTime(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Please type the time in following format HH:MM:");
                return LocalTime.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid time format. Try again.");
            }
        }

    }
}
