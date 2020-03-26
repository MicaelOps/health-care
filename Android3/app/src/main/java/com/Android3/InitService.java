
package com.mypackage;

import android.content.Intent;
import android.os.Binder;
import android.app.NotificationManager;
import android.util.Log;
import android.app.Service;
import android.os.IBinder;
import android.app.Notification;
import android.app.PendingIntent;
import android.widget.Toast;

public class InitService extends Service
{
	private NotificationManager mNM =null;

    // Unique Identification Number for the Notification.
    // We use it on Notification start, and to cancel it.
    private int NOTIFICATION = 1;

    /**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
  
    @Override
    public void onCreate() {
        mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        // Display a notification about us starting.  We put an icon in the status bar.
        showNotification();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        // Cancel the persistent notification.
        mNM.cancel(NOTIFICATION);

        // Tell the user we stopped.
        Toast.makeText(this, "ICollector stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Show a notification while this service is running.
     */
    private void showNotification() {

        // The PendingIntent to launch our activity if the user selects this notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, com.Android3.Init.class), 0);

        // Set the info for the views that show in the notification panel.
        Notification notification = new Notification.Builder(this)
                .setTicker("ICollector")  // the status text
                .setWhen(System.currentTimeMillis())  // the time stamp
                .setContentTitle("ICollector")  // the label of the entry
                .setContentText("We are establish connection with the server...")  // the contents of the entry
                .setContentIntent(contentIntent)  // The intent to send when the entry is clicked
                .build();
		startForeground(NOTIFICATION, notification);
        // Send the notification.
        mNM.notify(NOTIFICATION, notification);
    }

}
