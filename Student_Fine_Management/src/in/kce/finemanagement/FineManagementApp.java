package in.kce.finemanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FineManagementApp {

    static List<User> users = new ArrayList<>();
    static List<Payment> payments = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT FINE MANAGEMENT SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerUser(sc);
                    break;

                case 2:
                    loginUser(sc);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= REGISTER =================
    public static void registerUser(Scanner sc) {

        System.out.println("Select Role:");
        System.out.println("1. Admin");
        System.out.println("2. Cashier");
        System.out.println("3. Student");

        int roleChoice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (roleChoice == 1) {
            users.add(new Admin(id, name, email, password));
        } 
        else if (roleChoice == 2) {
            users.add(new Cashier(id, name, email, password));
        } 
        else if (roleChoice == 3) {
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            users.add(new Student(id, name, email, password, balance));
        }

        System.out.println("Registration Successful!");
    }

    // ================= LOGIN =================
    public static void loginUser(Scanner sc) {

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        for (User user : users) {

            if (user.login(email, password)) {

                if (user instanceof Admin) {
                    adminMenu((Admin) user, sc);
                } 
                else if (user instanceof Cashier) {
                    cashierMenu((Cashier) user, sc);
                } 
                else if (user instanceof Student) {
                    studentMenu((Student) user, sc);
                }
                return;
            }
        }

        System.out.println("Invalid Credentials!");
    }

    // ================= ADMIN MENU =================
    public static void adminMenu(Admin admin, Scanner sc) {

        while (true) {

            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Payment ID: ");
                    String pid = sc.nextLine();

                    System.out.print("Enter Fine Type: ");
                    String fineType = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();

                    Payment p = new Payment(pid, fineType, amount,
                            LocalDate.now(), sid);

                    admin.addPayment(payments, p);
                    break;

                case 2:
                    admin.viewAllPayments(payments);
                    break;

                case 3:
                    return;
            }
        }
    }

    // ================= CASHIER MENU =================
    public static void cashierMenu(Cashier cashier, Scanner sc) {

        while (true) {

            System.out.println("\n--- CASHIER MENU ---");
            System.out.println("1. Add Payment");
            System.out.println("2. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Payment ID: ");
                    String pid = sc.nextLine();

                    System.out.print("Enter Fine Type: ");
                    String fineType = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();

                    Payment p = new Payment(pid, fineType, amount,
                            LocalDate.now(), sid);

                    cashier.addPayment(payments, p);
                    break;

                case 2:
                    return;
            }
        }
    }

    // ================= STUDENT MENU =================
    public static void studentMenu(Student student, Scanner sc) {

        while (true) {

            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. View Profile");
            System.out.println("2. View Transactions");
            System.out.println("3. View Balance");
            System.out.println("4. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    student.viewProfile();
                    break;

                case 2:
                    student.viewTransactions(payments);
                    break;

                case 3:
                    student.viewBalance();
                    break;

                case 4:
                    return;
            }
        }
    }
}