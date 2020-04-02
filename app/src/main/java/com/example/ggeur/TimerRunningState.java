package com.example.ggeur;

public class TimerRunningState implements ITimerState {
    private Timer timer;
    TimerRunningState(Timer timer){
        this.timer = timer;
    }
    @Override
    public void Start(int time) { }

    @Override
    public void stop() {
        timer.counttimerCancel();
        timer.changeState(new TimerStoppedState(timer));
    }

}
