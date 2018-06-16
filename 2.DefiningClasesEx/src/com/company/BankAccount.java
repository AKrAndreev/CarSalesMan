package com.company;

public class BankAccount {
    private int id;
    private  double balance;

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }


    public void deposit(double amount){
        if (amount<0){
            throw new IllegalArgumentException("Negative value not possible");
        }else {
            this.balance+=amount;
        }

    }

    public void withdraw(double amount){
        if (amount>this.balance){
            throw new IllegalArgumentException("Not enough money!");
        }else {
            this.balance-=amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f",this.id,this.balance);
    }
}
