package com.designPatterns.proxy;

public class ATM implements Account {


    @Override
    public void withdraw(int amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(amount);
    }

    @Override
    public String getAccountNumber() {
        return null;
    }
}
