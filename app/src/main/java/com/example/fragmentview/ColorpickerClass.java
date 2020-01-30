package com.example.fragmentview;


import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorpickerClass {
    Context context;
    int currentColor;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    Activity activity;
    public void ColorPicker(Context context, RelativeLayout relativeLayout){
        this.context=context;
        this.relativeLayout = relativeLayout;
        this.linearLayout = linearLayout;
        OpenColorPicker(false);
    }

    public void OpenColorPicker(boolean supportAlpha){
        AmbilWarnaDialog dialog_colorPicker = new AmbilWarnaDialog(context, currentColor, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                currentColor = color;
                relativeLayout.setBackgroundColor(color);
//                linearLayout.setBackgroundColor(color);
//                win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                win.setStatusBarColor(color);
            }
        });
        dialog_colorPicker.show();
    }

}

