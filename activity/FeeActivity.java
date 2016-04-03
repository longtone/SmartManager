package com.app.carrot.smartmanager.activity;

import android.os.Bundle;

import com.app.carrot.smartmanager.R;

public class FeeActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee);
        initActivity.setContxt(this);
        initActivity.initWindows();
        initActivity.setTitle("费用");

    }
}
