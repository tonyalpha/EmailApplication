package studentdatabaseapplication;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costPerCourse = 600;
    private static int id = 1000;
    // Constructor: prompt user to enter student's name and year
    public Student () {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = keyboard.nextLine();
        System.out.print("Enter student last name: ");
        this.lastName = keyboard.nextLine();
        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.year = keyboard.nextInt();

        setStudentID();
    }
    // Generate ID
    private void setStudentID() {
        id++;
        this.studentID = year + "" + id;
    }

    // Enroll in courses
    public void enroll () {
            // Get inside a loop, user hits 0
            while (true) {
                System.out.print("Enter a course to enroll (Q to quit): ");
                Scanner keyboard = new Scanner(System.in);
                String course = keyboard.nextLine();
                if (!course.equalsIgnoreCase("q")) {
                    courses += "\n     " + course;
                    tuitionBalance += costPerCourse;
                }
                else {
                    break;
                }
            }
    }
    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: " +tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner keyboard = new Scanner(System.in);
        int payment = keyboard.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $"+payment);
        viewBalance();
    }

    // Show status
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nStudent ID: " + studentID +
                "\nGrade level: " + year +
                "\nCourses enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
