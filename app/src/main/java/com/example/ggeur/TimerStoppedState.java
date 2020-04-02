package com.example.ggeur;

import android.os.CountDownTimer;

public class TimerStoppedState implements ITimerState {
    private Timer timer;
    TimerStoppedState(Timer timer){
        this.timer = timer;
    }

    @Override
    public void Start(int time) {
        timer.setCounttimer( new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished){
                timer.getTimeLeft().setTimeleft(millisUntilFinished / 1000);
            }
            public void onFinish() {
                timer.stop();
            }
        }.start());
        timer.changeState(new TimerRunningState(timer));
    }

    @Override
    public void stop() { }
}
