package les.projeto.quebra_galho;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;

import les.projeto.quebra_galho.view.ListaServicosActivity;

public class NotifyService extends Service {

    public final static String ACTION = "NotifyServiceAction";
    public final static String STOP_SERVICE = "";
    final static int RQS_STOP_SERVICE = 1;

    NotifyServiceReceiver notifyServiceReceiver;

    private static final int MY_NOTIFICATION_ID = 1;
    private NotificationManager notificationManager;
    private Notification myNotification;
    private final String myBlog = "http://android-er.blogspot.com/";

    @Override
    public void onCreate() {
// TODO Auto-generated method stub
        notifyServiceReceiver = new NotifyServiceReceiver();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
// TODO Auto-generated method stub

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION);
        registerReceiver(notifyServiceReceiver, intentFilter);

        Intent intent2 = new Intent(this, ListaServicosActivity.class);
// Send Notification
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.android_blue_icon)
                        .setContentTitle("Nova proposta de Trabalho")
                        .setContentText("Você possui uma nova proposta");
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ListaServicosActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(intent2);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // Id allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
// TODO Auto-generated method stub
        this.unregisterReceiver(notifyServiceReceiver);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {
// TODO Auto-generated method stub
        return null;
    }

    public class NotifyServiceReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, Intent arg1) {
            // TODO Auto-generated method stub
            int rqs = arg1.getIntExtra("RQS", 0);
            if (rqs == RQS_STOP_SERVICE) {
                stopSelf();
            }
        }
    }

}