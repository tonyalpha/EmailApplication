package studentdatabaseapplication;

import java.util.Scanner;

public class StudentDataBaseApplication {
    public static void main (String[] args) {
        // Ask how many users we want to add
        System.out.print("Enter number of new students to enroll: ");
        Scanner keyboard = new Scanner(System.in);
        int numberOfStudents = keyboard.nextInt();
        Student[] students = new Student[numberOfStudents];

        // Create n number of new students
        for (int n = 0; n < numberOfStudents; n++) {
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
            System.out.println(students[n].toString());
        }
    }
}
