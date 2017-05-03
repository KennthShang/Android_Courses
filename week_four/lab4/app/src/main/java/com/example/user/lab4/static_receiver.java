package com.example.user.lab4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;


public class static_receiver extends BroadcastReceiver {
    private static final String STATICATION = "com.example.user.lab4.static_receiver";
    @Override
    public void onReceive(Context context, Intent intent){
         if(intent.getAction().equals(STATICATION)){
             Bundle bundle = intent.getExtras();
             String name = bundle.getString("name");
             int image = bundle.getInt("image");

             NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
             Notification.Builder builder = new Notification.Builder(context);
             Bitmap bm = BitmapFactory.decodeResource(context.getResources(), image);

             builder.setContentTitle("静态广播").setContentText(name).setSmallIcon(image)
                     .setTicker("您有一条新广播").setLargeIcon(bm)
                     .setWhen(System.currentTimeMillis())
                     .setVibrate(new long[] {0, 500, 0, 0})
                     .setAutoCancel(true);

             Intent mIntent = new Intent(context, MainActivity.class);
             PendingIntent mPendingIntent = PendingIntent.getActivity(context, 0, mIntent, 0);
             builder.setContentIntent(mPendingIntent);

             Notification notify = builder.build();
             manager.notify(0, notify);
         }
    }

}
