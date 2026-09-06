package com.opos.mobad.f.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f6886a;
    private NotificationCompat.Builder b;
    private Notification c;
    private Notification d;
    private RemoteViews e;
    private Context f;
    private f g;
    private HashSet<Integer> h = new HashSet<>();

    public a(Context context, e eVar) {
        this.f = context;
        this.f6886a = (NotificationManager) context.getSystemService("notification");
        this.c = a(eVar, eVar.b, true, false);
        this.d = a(eVar, true, false, true);
        this.g = new f(this.f);
    }

    private Notification a(e eVar, boolean z, boolean z2, boolean z3) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f);
        this.b = builder;
        builder.setSmallIcon(eVar.f6891a);
        this.b.setAutoCancel(z);
        this.b.setOngoing(z2);
        this.b.setOnlyAlertOnce(true);
        this.b.setContentTitle(z3 ? "应用下载完成" : "应用下载");
        NotificationChannel notificationChannel = new NotificationChannel(eVar.c, eVar.d, eVar.e);
        notificationChannel.enableVibration(false);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setSound(null, null);
        notificationChannel.setShowBadge(false);
        if (Build.VERSION.SDK_INT >= 29) {
            notificationChannel.setImportance(2);
        }
        this.b.setChannelId(eVar.c);
        this.f6886a.createNotificationChannel(notificationChannel);
        return this.b.build();
    }

    private void a(int i, PendingIntent pendingIntent) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "show showNotificationCancelable:" + i + ",intent:" + pendingIntent);
        if (pendingIntent != null) {
            this.d.deleteIntent = pendingIntent;
        }
        this.d.contentView = this.e;
        this.f6886a.notify(i, this.d);
    }

    private void b(int i) {
        this.c.contentView = this.e;
        this.f6886a.notify(i, this.c);
    }

    @Override // com.opos.mobad.f.a.c
    public void a() {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelAllNotification");
        HashSet<Integer> hashSet = this.h;
        if (hashSet != null) {
            hashSet.clear();
        }
        NotificationManager notificationManager = this.f6886a;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        this.g.a();
    }

    @Override // com.opos.mobad.f.a.c
    public void a(int i) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelNotification");
        HashSet<Integer> hashSet = this.h;
        if (hashSet != null) {
            hashSet.remove(Integer.valueOf(i));
        }
        NotificationManager notificationManager = this.f6886a;
        if (notificationManager != null) {
            notificationManager.cancel(i);
        }
        f fVar = this.g;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // com.opos.mobad.f.a.c
    public void a(int i, c.a aVar) {
        if (aVar.c == 105) {
            a(aVar.f6888a, aVar.b, aVar.c, aVar.e, aVar.f, aVar.g, i, aVar.d);
        } else {
            a(aVar.f6888a, aVar.b, aVar.c, aVar.e, aVar.f, i, aVar.d);
        }
    }

    public void a(String str, String str2, int i, Intent intent, Intent intent2, int i2, int i3) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i);
        RemoteViews remoteViewsA = this.g.a(str, str2, i, i3, i2);
        if (this.h.contains(Integer.valueOf(i2))) {
            int i4 = 134217728 | 67108864;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f, i2, intent, i4));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i4));
        } else {
            int i5 = 268435456 | 67108864;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f, i2, intent, i5));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i5));
            this.h.add(Integer.valueOf(i2));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        }
        this.e = remoteViewsA;
        b(i2);
    }

    public void a(String str, String str2, int i, Intent intent, Intent intent2, Intent intent3, int i2, int i3) {
        PendingIntent service;
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i);
        RemoteViews remoteViewsA = this.g.a(str, str2, i, i3, i2);
        if (this.h.contains(Integer.valueOf(i2))) {
            int i4 = 134217728 | 67108864;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f, i2, intent, i4));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i4));
            service = PendingIntent.getService(this.f, i2, intent3, i4);
        } else {
            int i5 = 268435456 | 67108864;
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f, i2, intent, i5));
            remoteViewsA.setOnClickPendingIntent(com.opos.mobad.f.b.c.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i5));
            service = PendingIntent.getService(this.f, i2, intent3, i5);
            this.h.add(Integer.valueOf(i2));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        }
        this.e = remoteViewsA;
        a(i2, service);
    }
}
