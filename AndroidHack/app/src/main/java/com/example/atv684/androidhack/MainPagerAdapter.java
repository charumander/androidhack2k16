package com.example.atv684.androidhack;

import android.app.Fragment;
import android.app.FragmentManager;

/**
 * Created by atv684 on 8/27/16.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            default 0:
                // Top Rated fragment activity
                return new Fragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
