package com.example.swip_navigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

public class pageAdapter extends FragmentPagerAdapter {
    int mCountNumberOfTabs;
        public pageAdapter(FragmentManager supportFragmentManager, int tabCount) {
            super(supportFragmentManager,tabCount);

        }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Tab1();
            case 1: return new tab2();
            case 2: return new tab3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mCountNumberOfTabs;
    }
}
