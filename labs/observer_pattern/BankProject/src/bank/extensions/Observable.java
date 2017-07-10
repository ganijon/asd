package bank.extensions;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    List<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void attachObserver(Observer o) {
        if (observers.contains(o)) return;
        observers.add(o);
    }

    public void detachObserver(Observer o) {
        if (observers.contains(o))
            observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers)
            o.update();
    }
}
