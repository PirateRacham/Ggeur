package com.example.ggeur;

import android.os.CountDownTimer;

public class Timer {
    private CountDownTimer timer = null;
    private timeLeft timeLeft;
    public Timer(timeLeft timeLeft){
        this.timeLeft = timeLeft;
    };
    public void countDownStart(int time) {
        if(timer != null)
            cancelTimer();
        timer = new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished){
                timeLeft.setTimeleft(millisUntilFinished / 1000);
            }
            public void onFinish() {
                cancelTimer();
            }
        }.start();
    }

    void cancelTimer() {
        timer.cancel();
    }
}
