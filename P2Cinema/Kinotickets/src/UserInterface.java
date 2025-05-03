import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class UserInterface {
    private Scanner scanner;
    private Database data;

    public UserInterface(Scanner scanner, Database data) {
        this.scanner = scanner;
        this.data = data;
    }

    public void start() {
        while(true) {
            System.out.print("Hello - please select an option:\n"+
                    "0 -- To return to start\n" +
                    "1 -- List all movies by date\n" +
                    "2 -- Start booking process\n" +
                    "3 -- List all Movies by room\n" +
                    "4 -- List Movies for time Frame\n" +
                    "5 -- List Movies by Month\n");
            int input = HelpMethods.askForInt(scanner);

            switch(input) {
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                case 1 -> listMovies();
                case 2 -> startBooking();
                case 3 -> showProgram();
                case 4 -> showByIntervall();
                case 5 -> showByMonth();
                default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    private void listMovies() {
        LocalDate date = HelpMethods.askForDate(scanner);
        LocalTime time = HelpMethods.askForTime(scanner);
        showMovies(date, time);
    }

    public void showMovies(LocalDate date, LocalTime time) {
        System.out.println("\nAvailable movies:");
        for(Show show : data.getShowList()) {
            if(show.getDate().equals(date) && show.getStartTime().isAfter(time)){
                System.out.println(show);
            }
        }
        System.out.println();
    }

    public Tarif whichTarif(Show s) {
        while (true) {
            System.out.println("Which tarif are you paying? (normal / discounted)");
            String wantedTarif = scanner.nextLine().trim().toLowerCase();

            try {
                return TarifFactory.createTarif(wantedTarif, s.getMovie().getPrice());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid tarif type. Please enter 'normal' or 'discounted'.");
            }
        }
    }

    public boolean checkMovie(String input){
        for(Show a : data.getShowList()){
            if(a.getMovie().getShortName().equals(input)){
                return true;
            }
        }
        System.out.println("We do not show a Movie  with this name! Please start again");
        return false;
    }

    public void startBooking() {

        while(true){

        System.out.println("Which movie would you like to watch?");

        String input = scanner.nextLine().toLowerCase();
        if(!(checkMovie(input))){
            break;
        }

        LocalDate ld = HelpMethods.askForDate(scanner);
        LocalTime lt = HelpMethods.askForTime(scanner);

        for(Show a : data.getShowList()) {
            if (a.getMovie().getShortName().equals(input) && lt.equals(a.getStartTime())&&ld.equals(a.getDate())) {
                Tarif tarif = whichTarif(a);
                Ticket ticket = new Ticket(a, a.getRoom(), tarif);
                System.out.println(ticket);
                return;
            } else{
                System.out.println("We do not have a show Matching your wishes. Please check our program again");
                return;
            }
        }

        }
    }

    public void showProgram() {
        Map<Room, List<Show>> sortedShows = new TreeMap<>();
        for(Show a : data.getShowList()){
            sortedShows.putIfAbsent(a.getRoom(),new ArrayList<>());
            sortedShows.get(a.getRoom()).add(a);
        }
        for(Room a : sortedShows.keySet()){
            System.out.println("Room " + a );
            for(Show b : sortedShows.get(a)){
               System.out.println(b.toString());
            }
        }
    }

    public void showByMonth(){
        System.out.println("For which Month would you like too see the Program? Please use the numbers 1-12");
        Scanner scanner = new Scanner(System.in);
        int month = HelpMethods.askForInt(scanner);
        if (1 > month || month >= 13) {
            System.out.println("Please define Month with the Numbers(1-12)");
        }
        for(Show a : data.getShowList()){
            if(a.getDate().getMonthValue() == month){
                System.out.println(a);
            }
        }
    }
    public void showByIntervall(){

        System.out.print("Please enter your Start date?");
        LocalDate startDate = HelpMethods.askForDate(scanner);

        System.out.print("Please enter your End date?");
        LocalDate endDate = HelpMethods.askForDate(scanner);

        for(Show a : data.getShowList()){
            if(startDate.isBefore(a.getDate()) && a.getDate().isBefore(endDate)||(a.getDate().isEqual(startDate)||(a.getDate().isEqual(endDate)))){
                System.out.print(a);
            }
        }

    }

    public boolean checkDateF(String input){
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if(!(input.matches(regex))){
            System.out.println("The input is not a date");
            return false;
        }
        return true;
    }

    public boolean checkTimeF(String input){
        String regex = "^([01]\\d|2[0-3]):[0-5]\\d$";
        if(!(input.matches(regex))){
            System.out.println("The input is not a date");
            return false;
        }
        return true;
    }
}
