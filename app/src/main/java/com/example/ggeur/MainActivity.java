package com.example.ggeur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IObserver{
    private TextView countDown;
    private int time;
    private EggPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDown = findViewById(R.id.countDown);
        presenter = new EggPresenter();
        presenter.addObserver(this);
    }

    public void onButtonEggSelectedClicked(View view){
        switch (view.getId()) {
            case R.id.button:
                time = 5;
                break;
            case R.id.button2:
                time = 7;
                break;
            case R.id.button3:
                time = 9;
                break;
        }
        countDown.setText(String.valueOf(time));
        findViewById(R.id.buttonStart).setEnabled(true);
    }

    public void onButtonStartClicked() {
        findViewById(R.id.buttonStart).setEnabled(false);
        presenter.startTimer(time * 1000);
    }

    @Override
    public void onChange(long newValue) {
        countDown.setText(String.valueOf(newValue));
    }
}
