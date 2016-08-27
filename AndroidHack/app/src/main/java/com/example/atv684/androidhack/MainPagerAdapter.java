package com.example.atv684.androidhack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by atv684 on 8/27/16.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                // Top Rated fragment activity
                return new Fragment();
        }

    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
