package com.app.carrot.smartmanager.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.carrot.smartmanager.R;
import com.app.carrot.smartmanager.activity.LoginActivity;
import com.app.carrot.smartmanager.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    public Button btn;
    public NewsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        btn = (Button) view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.gotoLogin();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static void getcon(Context context){
         context.startActivity(new Intent(context, LoginActivity.class));
    }

}
