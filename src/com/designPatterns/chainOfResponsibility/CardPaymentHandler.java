package com.designPatterns.chainOfResponsibility;

public class CardPaymentHandler extends PaymentHandler {
    @Override
    public void handlePayment(int amount) {
        if (amount <= 500) {
            System.out.println("Card Payment Handler is handling the payment");
        } else {
            successor.handlePayment(amount);
        }
    }
}
