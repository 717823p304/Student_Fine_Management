package in.kce.finemanagement;

import java.time.LocalDate;

public class Payment {

    private String paymentId;
    private String fineType;
    private double amount;
    private LocalDate paymentDate;
    private String studentId;

    public Payment(String paymentId, String fineType, double amount,
                   LocalDate paymentDate, String studentId) {
        this.paymentId = paymentId;
        this.fineType = fineType;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFineType() {
        return fineType;
    }

    public void displayPayment() {
        System.out.println(paymentId + " | " + fineType + " | " +
                amount + " | " + paymentDate + " | " + studentId);
    }
    
    public String getPaymentId() {
        return paymentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setFineType(String fineType) {
        this.fineType = fineType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}