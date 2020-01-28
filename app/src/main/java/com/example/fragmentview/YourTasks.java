package com.example.fragmentview;

import android.net.Uri;
import android.os.Bundle;

import com.example.fragmentview.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

public class YourTasks extends AppCompatActivity implements Tasks.OnFragmentInteractionListener,Goals.OnFragmentInteractionListener,Overview.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_tasks);


        TabLayout tabs= findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Tasks"));
        tabs.addTab(tabs.newTab().setText("Goals"));
        tabs.addTab(tabs.newTab().setText("Overview"));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       final  ViewPager viewPager = findViewById(R.id.view_pager);
       final PagerAdapter adapter;
        adapter = new PagerAdapter(YourTasks.this,getSupportFragmentManager(),tabs.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
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


//        tabs.setupWithViewPager(viewPager);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

//        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
