package com.example.swip_navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewPager;
    Toolbar toolbar;
    pageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);


        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Top Stories"));
        tabLayout.addTab(tabLayout.newTab().setText("Tech News"));
        tabLayout.addTab(tabLayout.newTab().setText("Cooking"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        ViewPager viewPager = findViewById(R.id.viewPager);
        PagerAdapter adapter = new pageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}