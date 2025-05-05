import com.sun.jdi.IntegerValue;

import java.util.Scanner;

public class Main {
    private UserInterface ui;
    private Scanner scanner;
    private AdminInterface ai;
    private Database data;
    public Main() {
        scanner = new Scanner(System.in);
        data = new Database();
        data.loadMovies();
        data.loadTarifs();
        ui = new UserInterface(scanner,data);
        ai = new AdminInterface(scanner,data);

    }

    public static void main(String[] args) {
        Main program = new Main();
        program.whichUser();
    }

    public void whichUser() {
        while(true){
        System.out.print("1 -- User Interface\n" +
                        "2 -- Admin Interface\n" +
                        " 0 -- Stop programm\n");

        int input = HelpMethods.askForInt(scanner);

        switch (input) {
            case 0 -> {
                System.out.println("Program ends");
                return;
            }
            case 1 -> ui.start();
            case 2 -> ai.start();
            default -> System.out.println("Please enter either 0,1 or 2");
            }
        }
    }
}
