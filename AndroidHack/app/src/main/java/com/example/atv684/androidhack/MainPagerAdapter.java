package com.example.atv684.androidhack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by atv684 on 8/27/16.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}