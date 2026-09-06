package com.opos.mobad.f.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.heytap.msp.mobad.api.R;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f6894a;
    private e b;
    private Context c;

    public g(Context context, e eVar) {
        this.c = context;
        this.f6894a = (NotificationManager) context.getSystemService("notification");
        this.b = eVar;
    }

    private Notification a(int i, e eVar, c.a aVar) {
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.c).setSmallIcon(eVar.f6891a).setAutoCancel(false).setOnlyAlertOnce(true).setSmallIcon(eVar.f6891a).setContentTitle(aVar.f6888a);
        a(i, contentTitle, aVar);
        NotificationChannel notificationChannel = new NotificationChannel(eVar.c, eVar.d, eVar.e);
        notificationChannel.enableVibration(false);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setSound(null, null);
        notificationChannel.setShowBadge(false);
        if (Build.VERSION.SDK_INT >= 29) {
            notificationChannel.setImportance(2);
        }
        contentTitle.setChannelId(eVar.c);
        this.f6894a.createNotificationChannel(notificationChannel);
        return contentTitle.build();
    }

    private void a(int i, NotificationCompat.Builder builder, c.a aVar) {
        Resources resources;
        int i2;
        StringBuilder sb = new StringBuilder();
        int i3 = 134217728 | 67108864;
        PendingIntent activity = aVar.c == 105 ? PendingIntent.getActivity(this.c, i, aVar.e, i3) : PendingIntent.getService(this.c, i, aVar.e, i3);
        PendingIntent service = PendingIntent.getService(this.c, i, aVar.g, i3);
        switch (aVar.c) {
            case 102:
                sb.append(this.c.getResources().getString(R.string.download_status_new_downloading_txt));
                sb.append(PPSLabelView.Code);
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setOngoing(true);
                builder.setProgress(100, aVar.d, false);
                break;
            case 103:
                sb.append(this.c.getResources().getString(R.string.download_status_new_pause_txt));
                sb.append(PPSLabelView.Code);
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 105:
                resources = this.c.getResources();
                i2 = R.string.download_status_new_complete_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 106:
                resources = this.c.getResources();
                i2 = R.string.download_status_new_fail_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 107:
                sb.append(this.c.getResources().getString(R.string.download_status_waiting_txt));
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
        }
        builder.setContentText(sb);
    }

    @Override // com.opos.mobad.f.a.c
    public void a() {
        this.f6894a.cancelAll();
    }

    @Override // com.opos.mobad.f.a.c
    public void a(int i) {
        this.f6894a.cancel(i);
    }

    @Override // com.opos.mobad.f.a.c
    public void a(int i, c.a aVar) {
        this.f6894a.notify(i, a(i, this.b, aVar));
    }
}
