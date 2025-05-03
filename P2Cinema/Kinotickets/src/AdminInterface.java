import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

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
                    "0 -- To return to start\n" +
                    "1 -- to add Movies\n" +
                    "2 -- to add Show\n"+
                    "3 -- to change prices\n");

            int input = HelpMethods.askForInt(scanner);

            switch (input){
                case 0 -> {
                    System.out.println("returning to start");
                    return;
                }
                case 1 -> addMovie();
                case 2 -> addShow();
                case 3 -> setPrice();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void addMovie(){

        System.out.println("Movie title?");
        String title = scanner.nextLine();;

        System.out.println("Shortname?");
        String shortname = scanner.nextLine().toLowerCase();

        System.out.println("Duration?");
        int duration = HelpMethods.askForInt(scanner);

        System.out.println("Price?");
        int price = HelpMethods.askForInt(scanner);

        Movie movie = new Movie(title, shortname, duration, price);
        data.addMovie(movie);


    }
    public void listMovieList(){
        System.out.println("These are the films:\n"+"please select the film with the Number:\n");
        for (int i = 0; i < data.getMovieList().size();i++){
            System.out.println(i + " " + data.getMovieList().get(i).toString());

        }
    }
    public void addShow(){
        listMovieList();

        System.out.println("Which film would you like to add?");
        int index = HelpMethods.askForInt(scanner);
        Movie movie = data.getMovieList().get(index);

        System.out.println("On which date?");
        LocalDate date = HelpMethods.askForDate(scanner);

        System.out.println("On which time does the movie Start?");
        LocalTime time = HelpMethods.askForTime(scanner);

        System.out.println("Which room?");
        int roomNumber = HelpMethods.askForInt(scanner);
        Room room = new Room(roomNumber);

        Show show = new Show(date,time,movie,room);
        boolean notEnoughPause= false;
        for(Show a : data.getShowList()){
            if(checkPause(show,a)||checkPause(a,show)){

                return;
            }
        }
        data.addShow(show);
        System.out.println("Show was added");
    }
    public void setPrice(){
        listMovieList();

        System.out.println("For which movie would you like to change the Price? Use index please");
        int index = HelpMethods.askForInt(scanner);
        Movie movie = data.getMovieList().get(index);

        System.out.println("Which Price would you like to set for the Movie?");
        int newPrice = HelpMethods.askForInt(scanner);
        movie.setPrice(newPrice);

    }
    public boolean checkPause(Show show1, Show show2){

        if (show1.getRoom().getRoomNumber() == show2.getRoom().getRoomNumber() && show1.getStartTime().plusMinutes(show1.getMovie().getDuration()+15).isAfter(show2.getStartTime())){
            System.out.println("There need to be  at least 15 minutes between the end of a Movie and the Start of the next one in the Same room");
            return true;
        }
    return false;
    }
}

