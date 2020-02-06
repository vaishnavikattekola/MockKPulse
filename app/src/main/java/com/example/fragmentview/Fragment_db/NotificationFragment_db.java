package com.example.fragmentview.Fragment_db;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fragmentview.R;

public class NotificationFragment_db extends Fragment {
    Button btn_notification;
    RemainderBroadcast remainderBroadcast;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_notification_db, container, false);

        btn_notification = view.findViewById(R.id.btn_notification);
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Remainder Set!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),RemainderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(v.getContext(),0, intent,0);
                AlarmManager alarmManager = (AlarmManager) v.getContext().getSystemService(Context.ALARM_SERVICE);

                long timeAtButtonClick =  System.currentTimeMillis();
                long tenSecondsInMillis = 1000 * 10;

                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        timeAtButtonClick + tenSecondsInMillis,
                        pendingIntent);
            }
        });
        return view;
    }

}
