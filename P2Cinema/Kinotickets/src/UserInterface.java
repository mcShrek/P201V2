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
                    "1 -- List movies by date\n" +
                    "2 --  List movies by month\n" +
                    "3 -- List movies by room\n" +
                    "4 -- List movies for time frame\n" +
                    "5 -- Start booking process\n");
            int input = HelpMethods.askForInt(scanner);

            switch(input) {
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                case 1 -> listMovies();
                case 2 -> listByMonth();
                case 3 -> listByRoom();
                case 4 -> listByIntervall();
                case 5 -> startBooking();
                default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    private void listMovies() {
        System.out.println("Please enter the desired date:");
        LocalDate date = HelpMethods.askForDate(scanner);
        if(checkDate(date)) return;
        System.out.println("Please enter the earliest time you can come to the cinema today:");
        LocalTime time = HelpMethods.askForTime(scanner);
        if(checkTime(time)) return;
        showMovies(date, time);
    }

    public void showMovies(LocalDate date, LocalTime time) {
        System.out.println("\nAvailable movies:\n");
        for(Show show : data.getShowList()) {
            if(show.getDate().equals(date) && (show.getStartTime().isAfter(time) || show.getStartTime().equals(time))){
                System.out.println(show);
            }
        }
        System.out.println();
    }

    public Tarif whichTarif(Show s) {
        System.out.println("Available tariffs:\n");

        List<Tarif> tarifList = data.getTarifList();

        for(int i = 0; i < tarifList.size(); i++) {
            Tarif t = tarifList.get(i);
            System.out.println(i + " -- " + t.getName());
        }
        System.out.println();

        System.out.println("Please select a tariff by number:");
        int choice = HelpMethods.askForInt(scanner);

        if (choice < 0 || choice >= tarifList.size()) {
            System.out.println("Invalid choice. Please select an existing tariff");
            return null;
        }
        return tarifList.get(choice);
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
        System.out.println("Please enter the desired date for your visit:");
        LocalDate ld = HelpMethods.askForDate(scanner);
        System.out.println("Please enter the starting time of the desired show:");
        LocalTime lt = HelpMethods.askForTime(scanner);

        boolean found = false;
        for(Show a : data.getShowList()) {
            if (a.getMovie().getShortName().equals(input)
                    && lt.equals(a.getStartTime())
                    && ld.equals(a.getDate())) {

                Tarif tarif = whichTarif(a);
                if(tarif == null) return;
                Ticket ticket = new Ticket(a, a.getRoom(), tarif);
                System.out.println(ticket + "\n");
                System.out.println("Ticket purchase successful!\n");

                found = true;
                break;
            }
        }
            if(!found) {
                System.out.println("We do not have a show Matching your wishes. Please check our program again");
            }
            return;

        }
    }

    public void listByRoom() {
        Map<Room, List<Show>> sortedShows = new TreeMap<>();
        for(Show a : data.getShowList()){
            sortedShows.putIfAbsent(a.getRoom(),new ArrayList<>());
            sortedShows.get(a.getRoom()).add(a);
        }
        for(Room a : sortedShows.keySet()){
            System.out.println(a + ":");
            for(Show b : sortedShows.get(a)) {
               System.out.println(b.toString());
            }
        }
    }

    public void listByMonth(){
        int month;
        while (true) {
            System.out.println("For which month would you like to see the program? (Please enter 1–12)");
             month = HelpMethods.askForInt(scanner);

            if (month >= 1 && month <= 12) {
                break;
            }

            System.out.println("Invalid input. Please enter a number between 1 and 12.");
        }
        int counter = 0;
        for(Show a : data.getShowList()){
            if(a.getDate().getMonthValue() == month){
                counter++;
                System.out.println(a);
            }
        }
        if(counter == 0) {
            System.out.println("Sorry, there are no movies available in the selected month.");
        }
    }
    public void listByIntervall(){

        System.out.println("Please enter the start date (YYYY-MM-DD):");
        LocalDate startDate = HelpMethods.askForDate(scanner);

        System.out.println("Please enter the end date(YYYY-MM-DD)");
        LocalDate endDate = HelpMethods.askForDate(scanner);

        System.out.println("Available movies in the selected time frame:\n");
        for(Show a : data.getShowList()){
            if(startDate.isBefore(a.getDate()) && a.getDate().isBefore(endDate)||(a.getDate().isEqual(startDate)||(a.getDate().isEqual(endDate)))){
                System.out.print(a);
            }
        }
        System.out.println();

    }

    public boolean checkDate(LocalDate date) {
        for(Show s : data.getShowList()) {
            if(s.getDate().equals(date)) return false;
        }
        System.out.println("Unfortunately, the cinema is closed on the selected date. Please select a different date");
        return true;
    }

    public boolean checkTime(LocalTime time) {
        for(Show s : data.getShowList()) {
            if(s.getStartTime().isAfter(time) || s.getStartTime().equals(time)) return false;
        }
        System.out.println("No movies are playing at this hour.");
        return true;
    }
}
