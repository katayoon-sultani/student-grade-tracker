import java.util.ArrayList;
import java.util.Scanner;

/**
 * StudentDisplay.java
 * Displays the student records in a table and searches students by name.
 */
public class StudentDisplay {

    private static final String LINE = "-".repeat(67);

    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentDisplay(ArrayList<Student> students, Scanner scanner) {
        this.students = students;
        this.scanner = scanner;
    }

    // Displays all students in a table
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No student records yet.");
            return;
        }

        printHeader();
        for (Student s : students) {
            printRow(s);
        }
        printClassSummary();
    }

    // Searches for students by name (not case sensitive, partial match allowed)
    public void searchByName() {
        System.out.print("Enter the name to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword)) {
                if (!found) {
                    printHeader();
                    found = true;
                }
                printRow(s);
            }
        }

        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    // Prints the table header
    private void printHeader() {
        System.out.println();
        System.out.printf("%-15s %7s %9s %9s %9s %6s %6s%n",
                "Name", "Math", "Science", "English", "Average", "Grade", "Status");
        System.out.println(LINE);
    }

    // Prints one row of the table
    private void printRow(Student s) {
        double average = GradeCalculator.calculateAverage(s);
        char grade = GradeCalculator.calculateGrade(average);
        String status = GradeCalculator.getStatus(average);

        System.out.printf("%-15s %7.1f %9.1f %9.1f %9.2f %6c %6s%n",
                s.getName(), s.getMark(0), s.getMark(1), s.getMark(2),
                average, grade, status);
    }

    // Prints the class average and the best student
    private void printClassSummary() {
        double total = 0;
        Student best = students.get(0);
        double bestAverage = GradeCalculator.calculateAverage(best);

        for (Student s : students) {
            double avg = GradeCalculator.calculateAverage(s);
            total += avg;
            if (avg > bestAverage) {
                bestAverage = avg;
                best = s;
            }
        }

        System.out.println(LINE);
        System.out.printf("Number of students: %d | Class average: %.2f%n",
                students.size(), total / students.size());
        System.out.printf("Top student: %s (%.2f)%n", best.getName(), bestAverage);
    }
}
