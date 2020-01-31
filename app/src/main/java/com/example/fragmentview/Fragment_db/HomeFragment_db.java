package com.example.fragmentview.Fragment_db;


import android.app.Activity;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.fragmentview.R;
import com.example.fragmentview.YourTasks;

public class HomeFragment_db extends Fragment {
    CardView cardView_kpulse_db;
    DrawerLayout nav_drawer;
    ImageView btn_nav_drawer;
    LinearLayout layout_linear_db_top;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_db, container, false);

        cardView_kpulse_db = view.findViewById(R.id.cardview_KPULSE);
        nav_drawer = view.findViewById(R.id.nav_drawer);
        layout_linear_db_top = view.findViewById(R.id.layout_linear_db_top);

        //click function for KPULSE cardview
        cardView_kpulse_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_KPUlSE = new Intent(view.getContext(), YourTasks.class);
                startActivity(call_KPUlSE);
            }
        });


        return view;
    }

}

