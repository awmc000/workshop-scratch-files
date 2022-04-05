package com.company;

public class BankAccount {
    // Private fields
    private String name;
    private double checking;
    private double savings;

    // Constructor
    public BankAccount(String newName, double amt1, double amt2) {
        name = newName;
        checking = amt1;
        savings = amt2;
    }

    // Setter and getter for the name

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    // Setters and getters for account balances

    public void setChecking(double amt) {
        checking = amt;
    }

    public double getChecking() {
        return checking;
    }

    public void setSavings(double amt) {
        savings = amt;
    }

    public double getSavings() {
        return savings;
    }

    public void printInfo() {
        System.out.println("Name, checking, savings: " + name + " " + checking
                          + " " + savings);
    }

    // Deposit methods

    public void depositChecking(double amt) {
        if (amt > 0) {
            checking += amt;
        }
    }

    public void depositSavings(double amt) {
        if (amt > 0) {
            savings += amt;
        }
    }

    // Withdrawal methods

    public void withdrawChecking(double amt) {
        if (amt > 0) {
            checking -= amt;
        }
    }

    public void withdrawSavings(double amt) {
        if (amt > 0) {
            savings -= amt;
        }
    }

    // Transfer

    public void transferToSavings(double amt) {
        if (amt > 0) {
            checking -= amt;
            savings += amt;
        }
    }

    // main
    public static void main(String args[]) {
        BankAccount account = new BankAccount("Mickey", 500.00, 1000.00);
        account.setChecking(500);
        account.setSavings(500);
        account.withdrawSavings(100);
        account.withdrawChecking(100);
        account.transferToSavings(300);

        System.out.println(account.getName()); // Expected Mickey
        System.out.printf("$%.2f\n", account.getChecking()); // Expected 100.0
        System.out.printf("$%.2f\n", account.getSavings()); // Expected 700.0
    }
}
