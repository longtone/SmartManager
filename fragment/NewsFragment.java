package com.app.carrot.smartmanager.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.app.carrot.smartmanager.R;
import com.app.carrot.smartmanager.activity.LoginActivity;
import com.app.carrot.smartmanager.activity.MainActivity;
import com.app.carrot.smartmanager.activity.SlideShowView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    public Button btn;
    private SlideShowView slideshow=null;
    public MainActivity mainActivity;
    public NewsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mainActivity= (MainActivity) getActivity();
        btn = (Button) view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        slideshow= (SlideShowView) view.findViewById(R.id.slideshow);
        if(slideshow !=null){
            WindowManager wm = mainActivity.getWindowManager();
            int width = wm.getDefaultDisplay().getWidth();
            int height = wm.getDefaultDisplay().getHeight();
            double i=width*0.5;
            int a= (int) i;
            ViewGroup.LayoutParams lp =slideshow.getLayoutParams();
            lp.width=lp.MATCH_PARENT;
            lp.height=a;
            slideshow.setLayoutParams(lp);
            Log.e("pic","初始化slides");
        }
        Log.e("pic","new的onCrst方法执行");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static void getcon(Context context){
         context.startActivity(new Intent(context, LoginActivity.class));
    }
    public static void destoryBitmaps() {
        Log.e("pic","被销毁！！！！！！");

    }
}
