package com.example.ggeur;

import android.view.View;
import java.util.ArrayList;
import java.util.List;


public class EggPresenter implements IObserver, IObserverable{
    private List<IObserver> observers;
    private timeLeft timeleft;
    private Timer timer;
    private View countdown;
    public EggPresenter(){
        timer = new Timer(timeleft = new timeLeft());
        timeleft.addObserver(this);
        observers = new ArrayList<IObserver>();
    }
    public void startTimer(int time){
        timer.countDownStart(time);
    }

    @Override
    public void onChange(long newValue) {
        notifyObservers();
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
            observer.onChange(this.timeleft.getTimeleft());
        }
    }
}
