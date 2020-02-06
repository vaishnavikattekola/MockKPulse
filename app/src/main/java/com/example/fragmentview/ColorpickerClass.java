package com.example.fragmentview;


import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorpickerClass {
    Context context;
    int currentColor;
    Window window;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    public void ColorPicker(Context context, RelativeLayout relativeLayout, Window window){
        this.context=context;
        this.window = window;
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
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(color);
            }
        });
        dialog_colorPicker.show();
    }

}

