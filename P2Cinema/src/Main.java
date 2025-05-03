import java.util.Scanner;

public class Main {
    private UserInterface ui;
    private Scanner scanner;

    public Main() {
        scanner = new Scanner(System.in);
        ui = new UserInterface(scanner);
    }
    public static void main(String[] args) {
        Main program = new Main();
        program.ui.start();
    }
}
