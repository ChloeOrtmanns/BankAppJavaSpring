package com.example.restservice;

public class BankAccount {

    private String banknumber;
    private double balance;

    public BankAccount(String banknumber) {
        this.banknumber = banknumber;
        this.balance = 0;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bankaccount: "+ this.banknumber +"\nSaldo: "+this.balance;
    }
}
