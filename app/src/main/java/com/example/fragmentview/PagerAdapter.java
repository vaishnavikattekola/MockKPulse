package com.example.fragmentview;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public int mNoofTabs;
    Activity activity;

    public PagerAdapter(Activity activity,FragmentManager fn, int NumberOfTabs) {
        super(fn);
        this.mNoofTabs = NumberOfTabs;
        this.activity = activity;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tasks tab1 = new Tasks();
                return tab1;
            case 1:
                Goals tab2 = new Goals();
                return tab2;
            case 2:
                Overview tab3 = new Overview();
                return tab3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
