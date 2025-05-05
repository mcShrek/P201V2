import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class AdminInterface {
    private Scanner scanner;
    private Database data;

    public AdminInterface(Scanner scanner, Database data) {
        this.scanner = scanner;
        this.data = data;

    }
    public void start(){
        while (true){
            System.out.print("What would you like to do?\n" +
                    "0 -- Return to start\n" +
                    "1 -- Add Movie\n" +
                    "2 -- Add Show\n"+
                    "3 -- Adjust prices\n" +
                    "4 -- Adjust tariffs\n");

            int input = HelpMethods.askForInt(scanner);

            switch (input){
                case 0 -> {
                    System.out.println("returning to start");
                    return;
                }
                case 1 -> addMovie();
                case 2 -> addShow();
                case 3 -> adjustPrice();
                case 4 -> adjustTarifs();
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    public void addMovie(){

        System.out.println("Movie title?");
        String title = scanner.nextLine();
        if(checkIfBlank(title)) {
            System.out.println("Title can't be empty. Please try again.");
            return;
        }

        System.out.println("Shortname?");
        String shortName = scanner.nextLine().toLowerCase();
        if(checkIfBlank(shortName)) {
            System.out.println("Shortname can't be empty. Please try again.");
            return;
        }

        System.out.println("Duration?");
        int duration = HelpMethods.askForInt(scanner);
        if(duration < 0 || duration > 500) {
            System.out.println("Duration invalid or too long. Please try again");
            return;
        };


        System.out.println("Price?");
        int price = HelpMethods.askForInt(scanner);
        if(price < 0) {
            System.out.println("Invalid price. Please try again.");
            return;
        };

        Movie movie = new Movie(title, shortName, duration, price);
        data.addMovie(movie);


    }
    public void listMovieList(){
        System.out.println("All the available movies:\n");
        for (int i = 0; i < data.getMovieList().size();i++){
            System.out.println(i + " " + data.getMovieList().get(i).toString());
        }
    }
    public void addShow(){
        listMovieList();
        System.out.println("Which film would you like to add?");
        int index = HelpMethods.askForInt(scanner);
        if(index >= data.getMovieList().size()) {
            System.out.println("Invalid input number. Please try again.");
            return;
        }
        Movie movie = data.getMovieList().get(index);

        System.out.println("Set date of show:");
        LocalDate date = HelpMethods.askForDate(scanner);

        System.out.println("Set movie start time:");
        LocalTime time = HelpMethods.askForTime(scanner);

        System.out.println("Select Room for the show:");

        int roomNumber = HelpMethods.askForInt(scanner);
        Room room = new Room(roomNumber);

        Show show = new Show(date,time,movie,room);
        for(Show a : data.getShowList()){
            if(checkPause(show,a)||checkPause(a,show)){

                return;
            }
        }
        data.addShow(show);
        System.out.println("Show was added!");
    }

    public boolean checkPause(Show show1, Show show2){
        if (show1.getRoom().getRoomNumber() != show2.getRoom().getRoomNumber())
            return false;

        LocalDateTime start1 = LocalDateTime.of(show1.getDate(), show1.getStartTime());
        LocalDateTime end1 = start1.plusMinutes(show1.getMovie().getDuration() + 15);

        LocalDateTime start2 = LocalDateTime.of(show2.getDate(), show2.getStartTime());
        LocalDateTime end2 = start2.plusMinutes(show2.getMovie().getDuration() + 15);

        boolean overlap = !end1.isBefore(start2) && !end2.isBefore(start1);

        if (overlap) {
            System.out.println("Conflict: The show overlaps or violates the required 15-minute break.");
            System.out.println("Existing show: " + show2);
            System.out.println("Conflicting show: " + show1);
            return true;
        }

        return false;
    }


    public void adjustPrice(){
        listMovieList();

        System.out.println("\n Please enter the number of the movie to be selected:\n");
        int index = HelpMethods.askForInt(scanner);
        if(index >= data.getMovieList().size() || index < 0) {
            System.out.println("Invalid input. Please try again.");
            return;
        }
        Movie movie = data.getMovieList().get(index);

        System.out.println("Which Price would you like to set for the Movie?");
        int newPrice = HelpMethods.askForInt(scanner);
        if(newPrice < 0) {
            System.out.println("Invalid input. please try again.");
            return;
        }
        movie.setPrice(newPrice);
        System.out.println("Price successfully adjusted!\n");

    }



    public void adjustTarifs() {
        List<Tarif> tarifList = data.getTarifList();
        System.out.println("Current tarifs:\n ");

        for (int i = 0; i < tarifList.size(); i++) {
            Tarif t = tarifList.get(i);
            System.out.println(i + " -- " + t.getName() + " - Current tarif: " + t.getPricePerc());
        }

        System.out.println("Which tarif would you like to adjust?");
        int input = HelpMethods.askForInt(scanner);
        if (input < 0 || input >= tarifList.size()) {
            System.out.println("Invalid input. Please enter existing Tarifnumber.");
            return;
        }
        Tarif selectedTarif = tarifList.get(input);

        System.out.println("Enter new tarif price:");
        double newTarif = HelpMethods.askForDouble(scanner);
        if(newTarif <= 0 ) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        if (selectedTarif instanceof Normal normalTarif) {
            normalTarif.setPricePerc(newTarif);
        } else if (selectedTarif instanceof Discounted discountedTarif) {
            discountedTarif.setPricePerc(newTarif);
        }
        System.out.println("Tarif updated!");
    }
    public boolean checkIfBlank(String name) {
        if(name.isBlank()) {
            return true;
        }
        return false;
    }
}

