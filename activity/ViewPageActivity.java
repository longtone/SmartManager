package com.app.carrot.smartmanager.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.carrot.smartmanager.R;
import com.app.carrot.smartmanager.fragment.MainFragment;

public class ViewPageActivity extends AppCompatActivity{
    private  final String ARG_SECTION_NUMBER = "section_number";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static Fragment f0=new MainFragment();
    private static Fragment f1=new MainFragment();
    private static Fragment f2=new MainFragment();


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);



        Bundle args0 = new Bundle();
        args0.putInt(ARG_SECTION_NUMBER,0);
        f0.setArguments(args0);
        Bundle args1 = new Bundle();
        args1.putInt(ARG_SECTION_NUMBER,1);
        f1.setArguments(args1);
        Bundle args2 = new Bundle();
        args2.putInt(ARG_SECTION_NUMBER,2);
        f2.setArguments(args2);

        mSectionsPagerAdapter = new SectionsPagerAdapter(this.getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return f0;
                case  1:
                    return  f1;
                case 2:
                    return  f2;
            }
            return  null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
