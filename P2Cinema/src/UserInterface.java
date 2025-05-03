import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private List<Show> showList;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        showList = new ArrayList<>();
        loadMovies();
    }

    public void start() {
        while(true) {
            System.out.print("Hello - please select an option:\n"+
                    "0 -- End the program\n" +
                    "1 -- List all movies by date\n" +
                    "2 -- Start booking process\n");
            int input = askForInt();

            switch(input) {
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                case 1 -> listMovies();
                case 2 -> startBooking();
                case 4711 -> enterAdmin();
                default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    private void listMovies() {
        LocalDate date = askForDate();
        LocalTime time = askForTime();
        showMovies(date, time);
    }

    private LocalDate askForDate() {
        while (true) {
            try {
                System.out.println("Please type a date in the following format YYYY-MM-DD:");
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }
    }

    private LocalTime askForTime() {
        while (true) {
            try {
                System.out.println("Please type the earliest time you can come (format HH:MM):");
                return LocalTime.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid time format. Try again.");
            }
        }

    }

    private int askForInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid number. Please enter a valid number.");
            }
        }
    }

    public void showMovies(LocalDate date, LocalTime time) {
        System.out.println("\nAvailable movies:");
        for(Show show : showList) {
            if(show.getDate().equals(date) && show.getStartTime().isAfter(time)){
                System.out.println(show);
            }
        }
        System.out.println();
    }
    public void enterAdmin() {
        System.out.println("Work in progress");
    }

    public Tarif whichTarif(){
        System.out.printf("Which Tarif are you paying? Discounted or Normal\n");
            String wantedTarif = scanner.nextLine();


                Tarif tarif = TarifFactory.createTarif(wantedTarif,1);
                return tarif;
    }

    public void startBooking() {


        System.out.println("Which movie would you like to watch?");

        String input = scanner.nextLine();

        for(Show a : showList){
            if(a.getMovie().getShortName().equals(input)){
               Tarif tarif = whichTarif();
            Ticket ticket = new Ticket(a,1,tarif);
            System.out.println(ticket);
            break;
            }

        }





    }
    public void loadMovies() {
        Movie matrix = new Movie("The Matrix: Return of the Sith", " Matrix", 123);
        Movie inception = new Movie("Inception: Tough Time Never Last", "Inception", 250);
        Movie avatar = new Movie("Avatar: The Last Airbender", "Avatar", 162);
        showList.add(new Show (LocalDate.of(2025, 5, 1), LocalTime.of(18, 30), matrix));
        showList.add(new Show (LocalDate.of(2025, 5, 1), LocalTime.of(20, 0), inception));
        showList.add(new Show (LocalDate.of(2025, 5, 2), LocalTime.of(17, 0), avatar));
    }

}
