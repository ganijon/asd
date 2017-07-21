package bank.extensions;

import bank.domain.Account;

public class Logger implements Observer {
    private State observerState;
    private Account observable;

    public Logger(Account observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        observerState = observable.getState();
        log();
    }

    public void log() {
        System.out.println("LOG  : Account state changed: " + observerState);
    }
}
