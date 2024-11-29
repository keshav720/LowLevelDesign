package models.payments;

public interface PaymentProcessor {
    boolean processPayment(double amount);
}
