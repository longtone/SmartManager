package com.app.carrot.smartmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.app.carrot.smartmanager.R;
import com.app.carrot.smartmanager.fragment.SettingFragment;
import com.app.carrot.smartmanager.fragment.NewsFragment;
import com.app.carrot.smartmanager.fragment.ToolFragment;

public class MainActivity extends BasicActivity {

    //标题名
    private String []tabNames={"信息","工具","设置"};
    //一共三个
    private static int mPageNumber=3;
    //实例化三个fragment
    private static Fragment []fragmentList={new NewsFragment(),new ToolFragment(),new SettingFragment()};
    //标记
    private  static String ARG_SECTION_NUMBER = "section_number";

    //view的适配器
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    //初始化fragment的标记为0,1,2，区分三个fragment
    private static void initFragment(){
        for(int i=0;i<mPageNumber;i++){
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER,i);
            fragmentList[i].setArguments(args);
            Log.i("myapp","init");
        }
       
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化标记
        initFragment();
        initActivity.setContxt(this);
        initActivity.initWindows();
        initActivity.setTitle("主界面");
        //实例化适配器
        mSectionsPagerAdapter = new SectionsPagerAdapter(this.getSupportFragmentManager());

        //定义并设置viewpage的适配器
        mViewPager = (ViewPager) findViewById(R.id.viewpage);
        assert mViewPager != null;
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);

        //为tablayout绑定viewpage
        assert tabLayout != null;
        tabLayout.setupWithViewPager(mViewPager);
        //设置tablayout显示方式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        Log.i("myapp","creat");
        ImageView mymenu= (ImageView) findViewById(R.id.mymenu);
        assert mymenu != null;
        mymenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
            }
        });
    }

    public void gotoSetting(){

    }

    /**
     * 适配器
     *
     * 多个重构方法
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.i("myapp","getitem");
            return fragmentList[position];
        }

        @Override
        public int getCount() {
            Log.i("myapp","getcount");
            return mPageNumber;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.i("myapp","getTitle");
            return tabNames[position];
        }
    }
    public void gotoLogin(){
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}
