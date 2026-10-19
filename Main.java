import java.util.Scanner;

/**
 * Main.java
 * Entry point of the Student Grade Tracker.
 * Creates the objects, connects all parts of the program and starts the menu.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager(scanner);
        StudentDisplay display = new StudentDisplay(manager.getStudents(), scanner);
        Menu menu = new Menu(scanner, manager, display);

        menu.run();

        scanner.close();
    }
}
