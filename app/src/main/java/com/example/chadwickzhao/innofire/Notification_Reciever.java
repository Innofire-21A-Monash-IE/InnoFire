package com.example.chadwickzhao.innofire;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import java.util.Random;

/**
 * Created by chadwickzhao on 2/09/16.
 */
public class Notification_Reciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context, Repeating_activity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);
        String tip1 = " Good job  your first 2 Hours of work has passed walk for 5 minutes and start fresh";
        String tip2 = "Way to go you completed 4 hours of work , get a healthy  well balanced meal";
        String tip3 = "You are doing great, you are nearly there , Don’t forget to smile";
        String tip4 = "You are here, Congratulation on a productive day";
        String tip5 = " I am well organized and doing well at my work";
        Random r = new Random();
        int i1 = (r.nextInt(5 - 1) + 1);
        String showtips = "";
        if(i1 == 1){
            showtips.equals(tip1);
        }else if(i1 == 2){
            showtips.equals(tip2);
        }else if(i1 == 3){
            showtips.equals(tip3);
        }else if(i1 == 4){
            showtips.equals(tip4);
        }else if(i1 == 5){
            showtips.equals(tip5);
        }
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentTitle("Notification title")
                .setContentText(tip1)
                .setAutoCancel(true);
        notificationManager.notify(100, builder.build());

    }
}
