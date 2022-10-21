package emailapplication;

public class EmailApplication {
    public static void main(String[] args) {
        Email email1 = new Email("Anton", "Sherri");
        System.out.println(email1.showInfo());
    }
}
