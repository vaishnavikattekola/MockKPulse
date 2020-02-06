package com.example.fragmentview.Fragment_db;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.example.fragmentview.ColorpickerClass;
import com.example.fragmentview.DashboardActivity;
import com.example.fragmentview.R;

import yuku.ambilwarna.AmbilWarnaDialog;


public class SettingsFragment_db extends Fragment {
    Button btn_color_picker;
    Switch aSwitch;
    int currentColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings_db, container, false);
       btn_color_picker = view.findViewById(R.id.btn_color_picker);
       aSwitch=view.findViewById(R.id.switch_night);
        final RelativeLayout layout_relative = view.findViewById(R.id.layout_relative);
        final LinearLayout layout_linear_db_top = view.findViewById(R.id.layout_linear_db_top);
        final Window win = getActivity().getWindow();
        btn_color_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorpickerClass colorpickerClass = new ColorpickerClass();
                colorpickerClass.ColorPicker(v.getContext(),layout_relative, win);
            }
        });

        return view;
    }

}
