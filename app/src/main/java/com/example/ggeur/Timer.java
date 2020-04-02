package com.example.ggeur;

import android.os.CountDownTimer;

public class Timer{
    private CountDownTimer counttimer;
    private TimeLeft timeLeft;
    private ITimerState currentState;

    public Timer(TimeLeft timeLeft){
        this.timeLeft = timeLeft;
        currentState = new TimerStoppedState(this);
    }
    TimeLeft getTimeLeft(){
        return timeLeft;
    }
    void setCounttimer(CountDownTimer countDownTimer){
        counttimer = countDownTimer;
    }
    void counttimerCancel(){
        counttimer.cancel();
    }
    public void Start(int time) {
        currentState.Start(time);
    }

    public void stop() {
        currentState.stop();
    }

    void changeState(ITimerState state){
        currentState = state;
    }

}
