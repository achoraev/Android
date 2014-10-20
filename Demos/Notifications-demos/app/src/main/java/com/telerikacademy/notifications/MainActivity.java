package com.telerikacademy.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.telerikacademy.notifications.examples.SimpleNotification;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.important).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createImportantNotification();
            }
        });

        findViewById(R.id.simple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSimpleNotification();
            }
        });

        findViewById(R.id.simple_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAnotherSimpleNotification();
            }
        });

        findViewById(R.id.big).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBigNotification();
            }
        });
    }

    public void createImportantNotification() {
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.girlfriend_small);

        Notification.Builder builder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.girlfriend_small)
                        .setLargeIcon(Bitmap.createScaledBitmap(largeIcon, 256, 256, false))
                        .setContentTitle("It's been a while...")
                        .setContentText("What's up, cause I am down :)");

        Intent resultIntent = new Intent(this, SimpleNotification.class);

        /*The stack builder object will contain an artificial back stack for the
        started Activity.
        This ensures that navigating backward from the Activity leads out of
        your application to the Home screen.*/
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(SimpleNotification.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        builder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.FLAG_NO_CLEAR |
                Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS | Notification.PRIORITY_HIGH;

        // important_notification_id allows you to update the notification later on.
        notificationManager.notify(R.id.important_notification_id, notification);
    }

    public void createBigNotification() {
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.girlfriend_small);

        Notification.Builder builder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.girlfriend_small)
                        .setLargeIcon(Bitmap.createScaledBitmap(largeIcon, 256, 256, false))
                        .setContentTitle("It's been a while...")
                        .setContentText("What's up, cause I am down :)");

        Notification.InboxStyle inboxStyle =
                new Notification.InboxStyle();
        String[] events = {"Girlfriend hacked your account", "Girlfriend left you a message", "Girlfriend sent you a new photo"};
// Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Event tracker details:");
// Moves events into the big view
        for (int i=0; i < events.length; i++) {

            inboxStyle.addLine(events[i]);
        }
// Moves the big view style object into the notification object.
        builder.setStyle(inboxStyle);

        Intent resultIntent = new Intent(this, SimpleNotification.class);

        /*The stack builder object will contain an artificial back stack for the
        started Activity.
        This ensures that navigating backward from the Activity leads out of
        your application to the Home screen.*/
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(SimpleNotification.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        builder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.FLAG_NO_CLEAR |
                Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS | Notification.PRIORITY_HIGH;

        // important_notification_id allows you to update the notification later on.
        notificationManager.notify(R.id.big_notification_id, notification);
    }

    public void createSimpleNotification() {
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.notification_icon);

        Notification.Builder builder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(Bitmap.createScaledBitmap(largeIcon, 256, 256, false))
                        .setContentTitle("Stuff happened")
                        .setContentText("What do we do?");

        Notification notification = builder.build();

        ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(R.id.simple_notification_id, notification);
    }

    public void createAnotherSimpleNotification() {
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.notification_icon);

        Notification.Builder builder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setLargeIcon(Bitmap.createScaledBitmap(largeIcon, 256, 256, false))
                        .setContentTitle("Stuff happened again")
                        .setContentText("What do we do now?");

        Notification notification = builder.build();

        ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(R.id.another_simple_notification_id, notification);
    }
}
