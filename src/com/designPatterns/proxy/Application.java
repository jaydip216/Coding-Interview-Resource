package com.designPatterns.proxy;

public class Application {

    public static void main(String[] args) {
        ATM accountProxy = new ATM();
        accountProxy.withdraw(100);
        System.out.println("Account Number: " + accountProxy.getAccountNumber());
    }
}
