package com.example.ggeur;


import java.util.ArrayList;
import java.util.List;

public class TimeLeft implements IObserverable{

    private List<IObserver> observers;
    private long timeleft = 0;
    TimeLeft(){
        observers = new ArrayList<>();
    }
    long getTimeleft(){
        return timeleft;
    }
    void setTimeleft(long value){
        this.timeleft = value;
        this.notifyObservers();
    }

    @Override
    public void addObserver(IObserver iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        observers.remove(iObserver);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers){
            observer.onChange(this.timeleft);
        }
    }
}
