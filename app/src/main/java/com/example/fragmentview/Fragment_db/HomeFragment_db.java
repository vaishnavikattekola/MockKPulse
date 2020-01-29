package com.example.fragmentview.Fragment_db;


import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.fragmentview.R;

public class HomeFragment_db extends Fragment {
    CardView cardView_kpulse_db;
    DrawerLayout nav_drawer;
    ImageView btn_nav_drawer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_db, container, false);

        cardView_kpulse_db = view.findViewById(R.id.cardview_KPULSE);
        nav_drawer = view.findViewById(R.id.nav_drawer);
//        btn_nav_drawer = view.findViewById(R.id.btn_nav_drawer);
//        btn_nav_drawer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!nav_drawer.isDrawerOpen(GravityCompat.START))
//                    nav_drawer.openDrawer(GravityCompat.END);
//                else
//                    nav_drawer.closeDrawer(GravityCompat.END);
//            }
//        });


        //click function for KPULSE cardview
        cardView_kpulse_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"You clicked Kpulse",Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}

