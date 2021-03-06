package com.example.fragmentview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class YourTasks extends AppCompatActivity implements Tasks.OnFragmentInteractionListener, Goals.OnFragmentInteractionListener, Overview.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_tasks);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Your Tasks");
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(R.string.Tasks));
        tabs.addTab(tabs.newTab().setText(R.string.Goals));
        tabs.addTab(tabs.newTab().setText(R.string.Overview));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.view_pager);
        final PagerAdapter adapter;
        adapter = new PagerAdapter(YourTasks.this, getSupportFragmentManager(), tabs.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                //push keyboard down when fragment changes
                InputMethodManager imm = (InputMethodManager) getApplication().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(viewPager.getWindowToken(), 0);
                String string_to_be_converted_to_MD5 = "Vaishnavi";
                String MD5_Hash_String = Utils.CreateMD5(string_to_be_converted_to_MD5);
                Log.e("HASHCODE",MD5_Hash_String);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
