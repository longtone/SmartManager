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
import android.widget.TextView;
import android.widget.Toast;

import com.app.carrot.smartmanager.R;

public class BasicActivity extends AppCompatActivity{

    private  static Toast mToast;
    private long mExitTime=0;
    private Activity mActivity;
    final  initActivity initActivity=new initActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    public  void setFullScreen(Activity activity){
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


    public class initActivity{
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
        public void initWindows(){
            if (mActivity == null)
                return;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Window window = mActivity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            View titleViewGroup=(View)mActivity.findViewById(R.id.hide);
            if ( titleViewGroup== null)
                return;
            // 设置头部控件ViewGroup的PaddingTop,防止界面与状态栏重叠
            int statusBarHeight = getStatusBarHeight(mActivity);
            titleViewGroup.setPadding(0, statusBarHeight, 0, 0);
        }

        public void setContxt(Activity activity){
            mActivity=activity;
        }

        public void setTitle(String string){
            TextView title=(TextView)mActivity.findViewById(R.id.title);
            if(title!=null)
                title.setText(string);
        }
    }
    public initActivity initActivity(){
        return initActivity;
    }


}
