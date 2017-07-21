package bank.extensions;

import bank.domain.Account;

public class EmailSender implements Observer {
    private State observerState;
    private Account observable;

    public EmailSender(Account observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        observerState = observable.getState();
        sendEmail();
    }

    public void sendEmail() {
        System.out.println("EMAIL: Account state changed: " + observerState);
    }
}
