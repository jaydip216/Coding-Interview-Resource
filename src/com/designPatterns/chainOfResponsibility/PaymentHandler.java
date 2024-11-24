package com.designPatterns.chainOfResponsibility;

public abstract class PaymentHandler {
    protected PaymentHandler successor;

    public void setSuccessor(PaymentHandler successor) {
        this.successor = successor;
    }

    public abstract void handlePayment(int amount);
}
