package bassiouny.ahmed.genericmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by bassiouny on 25/04/18.
 */

public class CustomNotificationManager {


    private static NotificationManager mNotificationManager;
    private static NotificationCompat.Builder mBuilder;
    private static CustomNotificationManager notificationManager;

    private CustomNotificationManager() {
    }

    // init notification manager
    // init notification builder , custom notification manager
    public static CustomNotificationManager getInstance(Context context) {
        if (mBuilder == null || mNotificationManager == null || notificationManager == null) {
            notificationManager = new CustomNotificationManager();
            mBuilder = new NotificationCompat.Builder(context, "channel_id");
            mBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS);
            mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    public void setTitle(String title) {
        mBuilder.setContentTitle(title);
    }

    public void setBody(String message) {
        mBuilder.setContentText(message);
    }

    public void setIcon(int icon) {
        mBuilder.setSmallIcon(icon);
    }

    public void show(int notificationId) {
        mNotificationManager.notify(notificationId, mBuilder.build());
    }
}
