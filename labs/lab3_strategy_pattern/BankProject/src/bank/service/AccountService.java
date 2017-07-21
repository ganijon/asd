package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.extensions.*;

public class AccountService implements IAccountService {
    private IAccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public Account createAccount(long accountNumber, String customerName, AccountType accountType) {
        Account account = new Account(accountNumber, accountType);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    public Account getAccount(long accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }

    public void addInterest() {
        InterestCalculation checkingsInterestCalculation = new CheckingsInterestCalculation();
        InterestCalculation savingsInterestCalculation = new SavingsInterestCalculation();

        Collection<Account> accounts = accountDAO.getAccounts();

        for(Account account : accounts) {
            double interest = 0.0;

            switch (account.getAccountType()) {
                case SAVINGS:
                    interest = savingsInterestCalculation.calculate(account.getBalance());
                case CHECKINGS:
                    interest = checkingsInterestCalculation.calculate(account.getBalance());
            }

            account.deposit(interest);
        }
    }

}
