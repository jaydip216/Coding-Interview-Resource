package com.designPatterns.proxy;

public class BankAccount implements Account{
    private String accountNumber;

    public BankAccount() {
        this.accountNumber = "123456789";
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("Withdrawn " + amount + " from account " + accountNumber);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

}
