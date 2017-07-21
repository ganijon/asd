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

    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);

        // subscribe observers
        account.attachObserver(new Logger(account));
        account.attachObserver(new SmsSender(account));
        account.attachObserver(new EmailSender(account));

        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);

        updateObservableState(account);
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

        updateObservableState(account);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);

        updateObservableState(fromAccount);
        updateObservableState(toAccount);
    }

    private void updateObservableState(Account account) {
        account.setState(new State(
                account.getAccountnumber(),
                account.getCustomer().getName(),
                account.getBalance()));
    }
}
