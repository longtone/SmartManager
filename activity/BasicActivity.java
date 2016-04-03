package com.app.carrot.smartmanager.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class BasicActivity extends AppCompatActivity{

    private  static Toast mToast;
    private long mExitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void initWindows(Activity activity, View titleViewGroup) {
        if (activity == null)
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (titleViewGroup == null)
            return;
        // 设置头部控件ViewGroup的PaddingTop,防止界面与状态栏重叠
        int statusBarHeight = getStatusBarHeight(activity);
        titleViewGroup.setPadding(0, statusBarHeight, 0, 0);
        }

    private static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier(
                "status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    public  void setFull(Activity activity){
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
    }


    public void showToast(Context context,String string ,int length){
        if (null != mToast) {
            mToast.setText(string);
            mToast.setDuration(length);
        } else {
            mToast = Toast.makeText(context, string, length);
        }
        mToast.show();

    }
    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        }
        else {
            finish();
            System.exit(0);
        }
    }


}
