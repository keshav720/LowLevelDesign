package models.payments;

public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        // process of payment
        return true;
    }
}
