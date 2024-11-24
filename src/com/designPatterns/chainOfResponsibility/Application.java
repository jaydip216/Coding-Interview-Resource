package com.designPatterns.chainOfResponsibility;

public class Application {

    public static void main(String[] args) {
        PaymentHandler paypalHandler = new PaypalPaymentHandler();
        PaymentHandler bankPaymentHandler = new BankPaymentHandler();
        PaymentHandler cardPaymentHandler = new CardPaymentHandler();

        cardPaymentHandler.setSuccessor(bankPaymentHandler);
        bankPaymentHandler.setSuccessor(paypalHandler);

        cardPaymentHandler.handlePayment(500);
        cardPaymentHandler.handlePayment(1000);
        cardPaymentHandler.handlePayment(2000);
    }
}
