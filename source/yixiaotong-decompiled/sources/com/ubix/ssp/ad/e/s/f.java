package com.ubix.ssp.ad.e.s;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NotificationManager f8854a;

    public static com.ubix.ssp.ad.e.s.j.a a(Context context, com.ubix.ssp.ad.e.s.g.a aVar) {
        com.ubix.ssp.ad.e.s.j.a aVar2 = new com.ubix.ssp.ad.e.s.j.a();
        try {
            int iD = aVar.d();
            String packageName = context.getPackageName();
            String strB = com.ubix.ssp.ad.e.a0.c.b();
            if (f8854a == null) {
                f8854a = (NotificationManager) context.getSystemService("notification");
            }
            NotificationChannel notificationChannel = new NotificationChannel(packageName, "download", 3);
            notificationChannel.setSound(null, null);
            f8854a.createNotificationChannel(notificationChannel);
            Notification.Builder builder = new Notification.Builder(context, packageName);
            Intent intent = new Intent();
            intent.putExtra("service_intent_notify_id", iD);
            intent.setAction("ACTION_USER_OPERATION");
            intent.setComponent(new ComponentName(context.getPackageName(), "com.ubix.ssp.open.comm.DownloadService"));
            PendingIntent service = PendingIntent.getService(context, iD, intent, C.BUFFER_FLAG_FIRST_SAMPLE);
            String strD = (aVar.b() == null || aVar.b().d() == null) ? "" : aVar.b().d();
            builder.setOnlyAlertOnce(true);
            builder.setOngoing(false);
            builder.setSound(null).setContentTitle(strB).setSubText(strD).setContentIntent(service).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), com.ubix.ssp.ad.e.a0.c.d(context))).setSmallIcon(com.ubix.ssp.ad.e.a0.c.d(context)).setTicker(strB).setProgress(0, 0, true);
            aVar2.b = builder;
            aVar2.f8860a = iD;
            f8854a.notify(iD, builder.build());
        } catch (Throwable unused) {
        }
        return aVar2;
    }

    public static void a(int i) {
        NotificationManager notificationManager = f8854a;
        if (notificationManager != null) {
            notificationManager.cancel(i);
        }
    }

    public static void a(Notification.Builder builder, int i) {
        builder.setContentTitle("下载失败");
        if (f8854a != null) {
            builder.setContentIntent(null);
            builder.setAutoCancel(true);
            f8854a.notify(i, builder.build());
            a(i);
        }
    }

    public static void a(Notification.Builder builder, int i, int i2) {
        builder.setProgress(100, i2, false);
        builder.setContentTitle("正在下载 " + i2 + "%");
        if (i2 == 100) {
            builder.setContentTitle("下载完成");
        }
        NotificationManager notificationManager = f8854a;
        if (notificationManager != null) {
            notificationManager.notify(i, builder.build());
        }
    }

    public static void a(Notification.Builder builder, String str, int i) {
        builder.setSubText(str);
        NotificationManager notificationManager = f8854a;
        if (notificationManager != null) {
            notificationManager.notify(i, builder.build());
        }
    }

    public static void a(Context context, int i, com.ubix.ssp.ad.e.s.g.a aVar) {
        try {
            com.ubix.ssp.ad.e.s.g.b bVarB = aVar.b();
            String strA = com.ubix.ssp.ad.e.a0.c.a(context, aVar.b().e());
            if (!TextUtils.isEmpty(strA)) {
                b.b.put(strA, b.d().get(Integer.valueOf(i)));
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), "com.ubix.ssp.open.comm.AdActivity"));
                intent.addFlags(268435456);
                intent.putExtra(OapsKey.KEY_PKG, strA);
                intent.putExtra("path", bVarB.e());
                aVar.c().b.setContentIntent(PendingIntent.getActivity(context, i, intent, 0));
                aVar.c().b.setAutoCancel(true);
                f8854a.notify(i, aVar.c().b.build());
                return;
            }
            if (aVar.c() == null || aVar.c().b == null) {
                return;
            }
            aVar.c().b.setContentIntent(null);
            aVar.c().b.setAutoCancel(true);
            f8854a.notify(i, aVar.c().b.build());
            f8854a.cancel(i);
            aVar.b().a(0L);
            aVar.b().b(47);
            if (aVar.a().exists()) {
                aVar.a().delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (aVar == null || aVar.c() == null || aVar.c().b == null) {
                return;
            }
            aVar.c().b.setContentIntent(null);
            aVar.c().b.setAutoCancel(true);
            f8854a.notify(i, aVar.c().b.build());
            f8854a.cancel(i);
        }
    }

    public static void a(com.ubix.ssp.ad.e.s.g.a aVar) {
        if (aVar == null || aVar.c() == null || aVar.c().b == null) {
            return;
        }
        int iD = aVar.d();
        aVar.c().b.setContentIntent(null);
        aVar.c().b.setAutoCancel(true);
        f8854a.notify(iD, aVar.c().b.build());
        f8854a.cancel(iD);
    }

    public static boolean a(Context context, String str) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (!notificationManager.areNotificationsEnabled()) {
                return false;
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            return notificationChannel == null || notificationChannel.getImportance() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void b(Notification.Builder builder, int i) {
        builder.setContentTitle("下载暂停");
        NotificationManager notificationManager = f8854a;
        if (notificationManager != null) {
            notificationManager.notify(i, builder.build());
        }
    }
}
