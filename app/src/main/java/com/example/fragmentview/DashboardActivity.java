package com.example.fragmentview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.fragmentview.Fragment_db.HomeFragment_db;
import com.example.fragmentview.Fragment_db.NotificationFragment_db;
import com.example.fragmentview.Fragment_db.ProfileFragment_db;
import com.example.fragmentview.Fragment_db.SettingsFragment_db;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView btm_nav_view_db;
    NavigationView navigation_Drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btm_nav_view_db = findViewById(R.id.btm_nav_view_db);
        btm_nav_view_db.setOnNavigationItemSelectedListener(this);
        btm_nav_view_db.setSelectedItemId(R.id.db_home);


    }

    // creating instance for dashbboard fragments
    HomeFragment_db dbHomeFragment = new HomeFragment_db();
    ProfileFragment_db dbProfileFragment = new ProfileFragment_db();
    SettingsFragment_db dbSettingsFragment = new SettingsFragment_db();
    NotificationFragment_db dbNotificationFragments = new NotificationFragment_db();



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //switch case to perform action for each selected menu of bottom navigation view in dashboard
        switch (menuItem.getItemId()){
            case R.id.db_home:
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_db,dbHomeFragment).commit();
            return true;

            case R.id.db_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_db,dbProfileFragment).commit();
                return true;

            case R.id.db_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_db,dbSettingsFragment).commit();
                return true;

            case R.id.db_notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_db,dbNotificationFragments).commit();
                return true;

        }

        return false;
    }
}
