package com.app.carrot.smartmanager.activity;

import android.os.Bundle;

import com.app.carrot.smartmanager.R;

public class LoginActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWindows(this,findViewById(R.id.hide));
    }
}
