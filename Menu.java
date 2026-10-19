import java.util.Scanner;

/**
 * Menu.java
 * Shows the menu in a loop (switch) until the user chooses Exit.
 */
public class Menu {

    private Scanner scanner;
    private StudentManager manager;
    private StudentDisplay display;

    public Menu(Scanner scanner, StudentManager manager, StudentDisplay display) {
        this.scanner = scanner;
        this.manager = manager;
        this.display = display;
    }

    // Runs the menu until the user chooses option 4 (Exit)
    public void run() {
        boolean running = true;
        System.out.println("=== Student Grade Tracker ===");

        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    manager.addStudent();
                    break;
                case "2":
                    display.displayAll();
                    break;
                case "3":
                    display.searchByName();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3 or 4.");
            }
        }
    }

    // Prints the menu options
    private void showMenu() {
        System.out.println();
        System.out.println("1. Add a student");
        System.out.println("2. Display all students");
        System.out.println("3. Search a student by name");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
}
