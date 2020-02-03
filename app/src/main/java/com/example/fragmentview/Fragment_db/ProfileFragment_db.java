package com.example.fragmentview.Fragment_db;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fragmentview.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment_db extends Fragment {
    TextView txt_name, txt_email, txt_profile_fullname;
    ImageView img_profile_pic;
    Button btn_signout;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_db, container, false);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);
        img_profile_pic = view.findViewById(R.id.img_id_profile);
        txt_name = view.findViewById(R.id.txt_profile_name);
        txt_profile_fullname = view.findViewById(R.id.txt_profile_fullname);
        txt_email = view.findViewById(R.id.txt_profile_email);
        btn_signout = view.findViewById(R.id.btn_sign_out);
        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_sign_out:
                        signOut();
                        break;
                }

            }
        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();
            String personEmail = acct.getEmail();
            txt_name.setText(personName);
            txt_email.setText(personEmail);
            txt_profile_fullname.setText(personName);
            if(personPhoto!=null)
                Glide.with(this).load(String.valueOf(personPhoto)).into(img_profile_pic);
            else
                img_profile_pic.setImageResource(R.drawable.ic_no_user_profile);
        }
        return view;

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(),"Signed out Successfully",Toast.LENGTH_LONG).show();
                        getActivity().finish();
                    }
                });
    }
}

