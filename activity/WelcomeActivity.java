package com.app.carrot.smartmanager.activity;

import android.content.Intent;
import android.os.Bundle;

import com.app.carrot.smartmanager.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initWindows(this,null);
        final Intent it = new Intent(this, LoginActivity.class); //你要转向的Activity
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(it); //执行
                WelcomeActivity.this.finish();
            }
        };
        timer.schedule(task, 2000);
    }
}
