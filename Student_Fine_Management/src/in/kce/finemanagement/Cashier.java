package in.kce.finemanagement;

import java.util.Iterator;
import java.util.List;

public class Cashier extends User {

    public Cashier(String userId, String name, String email, String password) {
        super(userId, name, email, password, "CASHIER");
    }

    public void addPayment(List<Payment> payments, Payment payment) {
        payments.add(payment);
        System.out.println("Payment Added Successfully by Cashier!");
    }

    public void updatePayment(List<Payment> payments,
                              String paymentId,
                              String newFineType,
                              double newAmount) {

        for (Payment p : payments) {
            if (p.getPaymentId().equals(paymentId)) {
                p.setFineType(newFineType);
                p.setAmount(newAmount);
                System.out.println("Payment Updated Successfully by Cashier!");
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
                System.out.println("Payment Deleted Successfully by Cashier!");
                return;
            }
        }

        System.out.println("Payment Not Found!");
    }
}