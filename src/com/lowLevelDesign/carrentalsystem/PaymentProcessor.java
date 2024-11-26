package com.lowLevelDesign.carrentalsystem;

import java.math.BigDecimal;

public interface PaymentProcessor {
    boolean processPayment(BigDecimal amount);
}
