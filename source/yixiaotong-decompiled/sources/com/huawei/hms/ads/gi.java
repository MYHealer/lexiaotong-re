package com.huawei.hms.ads;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class gi {
    private static final String I = "BaseNotification";
    private static final String Z = "hwpps";
    protected Context Code;
    NotificationManager V;

    protected gi(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Code = origApplicationContext;
        this.V = (NotificationManager) origApplicationContext.getSystemService("notification");
    }

    private String F() {
        return "hwpps";
    }

    private Notification.Builder V() {
        Notification.Builder builder = new Notification.Builder(this.Code);
        builder.setContentTitle(Z());
        builder.setContentText(C());
        builder.setWhen(System.currentTimeMillis());
        builder.setShowWhen(true);
        builder.setContentIntent(S());
        builder.setAutoCancel(true);
        ApplicationInfo applicationInfo = this.Code.getApplicationInfo();
        if (applicationInfo != null) {
            builder.setSmallIcon(applicationInfo.icon);
        }
        return builder;
    }

    protected String B() {
        return I;
    }

    abstract String C();

    abstract int Code();

    abstract void Code(Notification.Builder builder);

    public void I() {
        Notification.Builder builderV = V();
        Code(builderV);
        NotificationChannel notificationChannel = new NotificationChannel(F(), B(), 3);
        notificationChannel.setShowBadge(false);
        notificationChannel.enableLights(false);
        builderV.setChannelId(F());
        this.V.createNotificationChannel(notificationChannel);
        this.V.notify(Code(), builderV.build());
    }

    abstract PendingIntent S();

    abstract String Z();
}
