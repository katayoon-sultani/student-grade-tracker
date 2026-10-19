import java.util.ArrayList;
import java.util.Scanner;

/**
 * StudentManager.java
 * Handles user input and stores the student records in an ArrayList.
 * Checks that every mark is a number between 0 and 100.
 */
public class StudentManager {

    private static final double MIN_MARK = 0;
    private static final double MAX_MARK = 100;

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner;

    public StudentManager(Scanner scanner) {
        this.scanner = scanner;
    }

    // Asks the user for a name and the marks, then stores the new student
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        // Name must not be empty
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter student name: ");
            name = scanner.nextLine().trim();
        }

        double[] marks = new double[Student.SUBJECT_COUNT];
        for (int i = 0; i < Student.SUBJECT_COUNT; i++) {
            marks[i] = readMark(Student.SUBJECT_NAMES[i]);
        }

        students.add(new Student(name, marks));
        System.out.println("Student \"" + name + "\" was added successfully.");
    }

    // Reads one mark and repeats until it is a number between 0 and 100
    private double readMark(String subject) {
        double mark = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter " + subject + " mark (0-100): ");
            String input = scanner.nextLine().trim();
            try {
                mark = Double.parseDouble(input);
                if (mark >= MIN_MARK && mark <= MAX_MARK) {
                    valid = true;
                } else {
                    System.out.println("Invalid mark. It must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return mark;
    }

    // Gives the list of students to the other classes (for display and search)
    public ArrayList<Student> getStudents() {
        return students;
    }
}
