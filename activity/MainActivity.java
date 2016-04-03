package com.app.carrot.smartmanager.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.app.carrot.smartmanager.R;
import com.app.carrot.smartmanager.fragment.MainFragment;

public class MainActivity extends BasicActivity {

    private String []tabNames={"信息","工具","设置"};
    private static int mPageNumber=3;
    private static Fragment []fragmentList={new MainFragment(),new MainFragment(),new MainFragment()};
    private  static String ARG_SECTION_NUMBER = "section_number";

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private static void initFragment(){
        for(int i=0;i<mPageNumber;i++){
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER,i);
            fragmentList[i].setArguments(args);
            Log.i("myapp","init");
        }
    }

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initWindows(this,findViewById(R.id.hide));
        mSectionsPagerAdapter = new SectionsPagerAdapter(this.getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpage);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        Log.i("myapp","creat");

    }
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
}
