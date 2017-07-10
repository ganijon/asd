package bank.extensions;

import bank.domain.Account;

public class SmsSender implements Observer {
    private State observerState;
    private Account observable;

    public SmsSender(Account observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        observerState = observable.getState();
        sendSms();
    }

    public void sendSms() {
        System.out.println("SMS  : Account state changed: " + observerState);
    }
}
