package com.example.fragmentview.Fragment_db;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.fragmentview.R;
import com.example.fragmentview.YourTasks;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class HomeFragment_db extends Fragment {
    CardView cardView_kpulse_db;
    DrawerLayout nav_drawer;
    ImageView img_db_profile_image;
    TextView txt_db_profile_name;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_db, container, false);

        cardView_kpulse_db = view.findViewById(R.id.cardview_KPULSE);
        nav_drawer = view.findViewById(R.id.nav_drawer);
        img_db_profile_image = view.findViewById(R.id.img_db_profile_image);
        txt_db_profile_name = view.findViewById(R.id.txt_db_profile_name);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();
            txt_db_profile_name.setText(personName);
            if(personPhoto!=null)
                Glide.with(this).load(String.valueOf(personPhoto)).into(img_db_profile_image);
            else
                img_db_profile_image.setImageResource(R.drawable.ic_no_user_profile);
        }
        else{
            txt_db_profile_name.setText("Username Not Found");
            img_db_profile_image.setImageResource(R.drawable.ic_launcher_background);
        }

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

