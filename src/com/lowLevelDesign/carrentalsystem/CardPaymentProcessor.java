package com.lowLevelDesign.carrentalsystem;

import java.math.BigDecimal;

public class CardPaymentProcessor implements PaymentProcessor{

    @Override
    public boolean processPayment(BigDecimal amount) {
        //payment processing
        return true;
    }
}
