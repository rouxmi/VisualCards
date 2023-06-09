package eu.telecomnancy.visualcards;

import java.util.List;
import java.util.ArrayList;

public class MyObservable {

    private final List<MyObserver> observers = new ArrayList<>();

    public void addObserver(MyObserver o) {
        this.observers.add(o);
    }

    public void notifyObservers() {
        for (MyObserver o : this.observers) {
            o.update();
        }
    }

}