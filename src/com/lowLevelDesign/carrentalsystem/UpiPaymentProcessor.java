package com.lowLevelDesign.carrentalsystem;

import java.math.BigDecimal;

public class UpiPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(BigDecimal amount) {
        //process upi payment
        return true;
    }
}
