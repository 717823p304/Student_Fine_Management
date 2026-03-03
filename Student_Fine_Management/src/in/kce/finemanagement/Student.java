package in.kce.finemanagement;

import java.util.List;
import java.util.Scanner;

public class Student extends User {

    private double balance;

    public Student(String userId, String name, String email,
                   String password, double balance) {
        super(userId, name, email, password, "STUDENT");
        this.balance = balance;
    }

    public void viewProfile() {
        System.out.println("ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Balance: " + balance);
    }

    public void editProfile() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter New Name: ");
        this.name = sc.nextLine();

        System.out.print("Enter New Email: ");
        this.email = sc.nextLine();

        System.out.print("Enter New Password: ");
        this.password = sc.nextLine();
        sc.close();
        System.out.println("Profile Updated Successfully!");
    }

    public void viewTransactions(List<Payment> payments) {
        for (Payment p : payments) {
            if (p.getStudentId().equals(this.userId)) {
                p.displayPayment();
            }
        }
    }

    public void viewBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void reduceBalance(double amount) {
        this.balance -= amount;
    }

}