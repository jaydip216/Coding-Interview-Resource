package com.designPatterns.chainOfResponsibility;

public class BankPaymentHandler extends PaymentHandler {
    @Override
    public void handlePayment(int amount) {
        if (amount <= 1000) {
            System.out.println("Bank Payment Handler is handling the payment");
        } else {
            successor.handlePayment(amount);
        }
    }
}
