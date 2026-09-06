package com.xiaomi.onetrack.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f9425a;

    public e(c cVar) {
        this.f9425a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f9425a.d != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            Message messageObtain = Message.obtain();
            messageObtain.what = 10;
            messageObtain.obj = intent2;
            this.f9425a.d.sendMessage(messageObtain);
            com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{36, Ascii.SYN, 94, 5, 85, 90, 0, Ascii.ETB, Ascii.DC2, 47, 80, 11, 7, 3, 84, Ascii.SYN}, "fd1d19"), ijiami_1011.s.s.s.d(new byte[]{10, 87, 76, 106, 93, 6, 4, 13, 16, 7, 67}, "d2888e"));
        }
    }
}
