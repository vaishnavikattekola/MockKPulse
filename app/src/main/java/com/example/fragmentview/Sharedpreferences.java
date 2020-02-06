package com.example.fragmentview;

import android.content.Context;

public class Sharedpreferences {
    Sharedpreferences mysharedpref;
    public  Sharedpreferences(Context context){
        mysharedpref = (Sharedpreferences) context.getSharedPreferences("Fragmentview",Context.MODE_PRIVATE);
    }
    //saving nightmode
public void setNightModeState(Boolean state){
        Sharedpreferences editor = mysharedpref;

}


}
