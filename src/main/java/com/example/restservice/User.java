package com.example.restservice;

public class User {
    private int ID;
    private BankAccount bankAccount;

    public User(int id) {
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
