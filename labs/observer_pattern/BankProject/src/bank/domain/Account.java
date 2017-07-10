package bank.domain;

import bank.extensions.Observable;
import bank.extensions.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Account extends Observable {
    private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
    private long accountnumber;
    private Customer customer;

    public Account(long accountnr) {
        this.accountnumber = accountnr;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, "" + toAccount.getAccountnumber(), toAccount.getCustomer().getName());
        AccountEntry toEntry = new AccountEntry(new Date(), amount, description, "" + toAccount.getAccountnumber(), toAccount.getCustomer().getName());
        entryList.add(fromEntry);
        toAccount.addEntry(toEntry);
        toAccount.deposit(amount);
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    // Observable members

    private State observableState;

    public State getState() {
        return observableState;
    }

    public void setState(State currentState) {
        observableState = currentState;
        notifyObservers();
    }

}