/**
 * GradeCalculator.java
 * Contains the calculation rules: average and letter grade.
 */
public class GradeCalculator {

    // Calculates the average of all marks of a student
    public static double calculateAverage(Student student) {
        double sum = 0;
        for (int i = 0; i < Student.SUBJECT_COUNT; i++) {
            sum += student.getMark(i);
        }
        return sum / Student.SUBJECT_COUNT;
    }

    // Converts an average (0-100) into a letter grade using if/else
    public static char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Returns a short text: Pass if average is 60 or more, otherwise Fail
    public static String getStatus(double average) {
        if (average >= 60) {
            return "Pass";
        }
        return "Fail";
    }
}
