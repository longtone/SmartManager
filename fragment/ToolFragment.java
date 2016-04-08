package com.app.carrot.smartmanager.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.carrot.smartmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolFragment extends Fragment {


    public ToolFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_tool, container, false);
        View title1=(View)view.findViewById(R.id.title1);
        View title2=(View)view.findViewById(R.id.title2);
        ImageView title1_pic= (ImageView) title1.findViewById(R.id.title_pic);
        ImageView title2_pic= (ImageView) title2.findViewById(R.id.title_pic);
        TextView title1_tv= (TextView) title1.findViewById(R.id.title_text);
        TextView title2_tv= (TextView) title2.findViewById(R.id.title_text);
        title1_tv.setText("物业报修");
        title2_tv.setText("费用管理");
        title1_pic.setImageResource(R.drawable.repair);
        title2_pic.setImageResource(R.drawable.pay);
        return view;
    }
}
