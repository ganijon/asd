package bank.extensions;

public class State {
    public long accountNumber;
    public String accountHolder;
    public double accountBalance;

    public State(long accNo, String accHolder, double accBalance) {
        accountNumber = accNo;
        accountHolder = accHolder;
        accountBalance = accBalance;
    }

    @Override
    public String toString() {
        return "| Account No.: " + accountNumber
                + " | Customer: " + accountHolder
                + " | Balance: $" + accountBalance;
    }
}
