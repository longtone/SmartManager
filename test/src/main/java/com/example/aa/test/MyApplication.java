package com.example.aa.test;

import android.app.Application;
import android.content.Context;

/**
 * Created by 101 on 2016/4/4.
 */
public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate(){
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
