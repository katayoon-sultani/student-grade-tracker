/**
 * Student.java
 * Represents one student: a name and a fixed number of subject marks.
 */
public class Student {

    // Number of subjects every student has marks for
    public static final int SUBJECT_COUNT = 3;

    // Names of the subjects (used when displaying results)
    public static final String[] SUBJECT_NAMES = {"Math", "Science", "English"};

    private String name;
    private double[] marks;

    // Constructor: creates a student with a name and an array of marks
    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }

    // Returns the mark of one subject (index 0 to SUBJECT_COUNT - 1)
    public double getMark(int index) {
        return marks[index];
    }
}
