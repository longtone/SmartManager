package com.app.carrot.smartmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.carrot.smartmanager.R;

public class LoginActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWindows(this,findViewById(R.id.hide));
        Button btn= (Button) findViewById(R.id.toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(LoginActivity.this,"ceshi"+System.currentTimeMillis(), Toast.LENGTH_LONG);
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }
}
