package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String companySuffix = "ausy.be";
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private int departmentChoice;

    // Constructor to receive the first name and last name
    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+this.password);

        // Combine elements to generate email STEPS: CREATE PRIVATE INT departmentChoice - LINK IT FROM SETDEPARTMENT
        if(departmentChoice <1 || departmentChoice > 3) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        } else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        }
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New Employee: "+firstName + "\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if(departmentChoice==1) {this.departmentChoice = departmentChoice; return "sales"; }
        else if(departmentChoice == 2) { this.departmentChoice = departmentChoice; return "development"; }
        else if(departmentChoice == 3) { this.departmentChoice = departmentChoice; return "accounting"; }
        else { this.departmentChoice = departmentChoice; return ""; }
    }

    // Generate a random password

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789&é'(§è!çà)-'";
        char [] password = new char[length];
        for (int i=0; i<length;i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String (password);
    }
    // Set the mailbox capacity
    public void setMailboxCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail (String alias) {
        this.alternateEmail = alias;
    }

    // Change the password
    public void changePassword (String password) {
        this.password = password;
    }

    public int getMailboxCapacity () { return mailboxCapacity; }
    public String getAlternateEmail () { return alternateEmail; }
    public String getPassword () { return password; }

    public String showInfo() {
        return "DISPLAY NAME: "+firstName + " " + lastName +
                "\nCOMPANY EMAIL: "+email +
                "\nMAILBOX CAPACITY: "+mailboxCapacity + "mb";
    }
}