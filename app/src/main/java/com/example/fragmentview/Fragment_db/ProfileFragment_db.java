package com.example.fragmentview.Fragment_db;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentview.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment_db extends Fragment {


    public ProfileFragment_db() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_db, container, false);
    }

}
