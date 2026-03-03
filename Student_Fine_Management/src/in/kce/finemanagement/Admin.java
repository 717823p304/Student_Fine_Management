package in.kce.finemanagement;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Admin extends User {

    public Admin(String userId, String name, String email, String password) {
        super(userId, name, email, password, "ADMIN");
    }

    public void viewAllPayments(List<Payment> payments) {
        for (Payment p : payments) {
            p.displayPayment();
        }
    }

    public void filterByFineType(List<Payment> payments, String fineType) {
        for (Payment p : payments) {
            if (p.getFineType().equalsIgnoreCase(fineType)) {
                p.displayPayment();
            }
        }
    }

    public void filterByStudent(List<Payment> payments, String studentId) {
        for (Payment p : payments) {
            if (p.getStudentId().equals(studentId)) {
                p.displayPayment();
            }
        }
    }

    public void filterByDate(List<Payment> payments, LocalDate date) {
        for (Payment p : payments) {
            if (p.getPaymentDate().equals(date)) {
                p.displayPayment();
            }
        }
    }

    public void addPayment(List<Payment> payments, Payment payment) {
        payments.add(payment);
        System.out.println("Payment Added Successfully!");
    }

    public void updatePayment(List<Payment> payments,
                              String paymentId,
                              String newFineType,
                              double newAmount) {

        for (Payment p : payments) {
            if (p.getPaymentId().equals(paymentId)) {
                p.setFineType(newFineType);
                p.setAmount(newAmount);
                System.out.println("Payment Updated Successfully!");
                return;
            }
        }
        System.out.println("Payment Not Found!");
    }

    public void deletePayment(List<Payment> payments, String paymentId) {

        Iterator<Payment> iterator = payments.iterator();

        while (iterator.hasNext()) {
            Payment p = iterator.next();
            if (p.getPaymentId().equals(paymentId)) {
                iterator.remove();
                System.out.println("Payment Deleted Successfully!");
                return;
            }
        }

        System.out.println("Payment Not Found!");
    }
}