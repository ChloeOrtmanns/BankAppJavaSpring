package com.example.restservice;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller {

    HashMap<Integer,BankAccount> DBAccounts = new HashMap<>();
    HashMap<Integer,User> DBUsers = new HashMap<>();

    @GetMapping("/{id}")
    public String index(@PathVariable int id) {
        return "Sup "+id+"! Welcome to the bank. Don't forget to register.";
    }

    @PostMapping("/{id}")
    public String register(@PathVariable int id) {
        if (this.DBUsers.containsKey(id)) {
            return "User ID is already registered";
        } else {
            DBUsers.put(id,new User(id));
            return "User with ID: " + id + " is registered.";
        }
    }

    @PostMapping("/{id}/{account}")
    public String createBankAccount(@PathVariable int id, @PathVariable String account) {
        BankAccount bankAccount = new BankAccount(account);

        if (this.DBAccounts.containsKey(id))  {
            return "This user already has a linked bankaccount.";
        } else {
            DBAccounts.put(id,bankAccount);
            return "User "+id+" associated to bankaccount: "+account;
        }
    }

    @GetMapping("/{id}/balances")
    public String getBalance(@PathVariable int id) {
        if (this.DBAccounts.containsKey(id)) {
            return DBAccounts.get(id).toString();
        } else {
            return "This ID has no associated bankaccount yet";
        }
    }

    @PutMapping("/{id}/balances/{amount}")
    public String addToBalance(@PathVariable int id, @PathVariable double amount) {
        if (amount >= 0) {
            DBAccounts.get(id).setBalance(DBAccounts.get(id).getBalance()+amount);
            return amount + " got added to bankaccount " + DBAccounts.get(id).getBanknumber();
        } else {
            return "please enter a positive amount";
        }
    }

    @DeleteMapping("/{id}/balances/{amount}")
    public String withdrawFromBalance(@PathVariable int id, @PathVariable double amount) {
        if (amount >= 0) {
            DBAccounts.get(id).setBalance(DBAccounts.get(id).getBalance() - amount);
            return amount + " got withdrawn from bankaccount " + DBAccounts.get(id).getBanknumber();
        } else {
            return "please enter a positive amount";
        }
    }

}
