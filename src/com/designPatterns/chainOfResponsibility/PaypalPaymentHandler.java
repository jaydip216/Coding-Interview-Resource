package com.designPatterns.chainOfResponsibility;

public class PaypalPaymentHandler extends PaymentHandler {
    @Override
    public void handlePayment(int amount) {
        if (amount <= 2000) {
            System.out.println("Paypal Payment Handler is handling the payment");
        } else {
            successor.handlePayment(amount);
        }
    }
}
