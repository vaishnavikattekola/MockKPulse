package com.example.fragmentview.Fragment_db;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.fragmentview.R;

public class RemainderBroadcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "KpulseRemainderChannel";
            String description = "Channel for Kpulse Daily Update Status";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("Kpulse Notification", name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"Kpulse Notification")
                .setContentTitle("KNOWLEDGE LENS")
                .setSmallIcon(R.drawable.ic_menu_notification)
                .setAutoCancel(true)
                .setContentText("This is a notification from KPULSE for Daily Update Status")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(999,builder.build());
    }
}
