package com.oplus.log.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.oplus.log.f.d f5794a;

    public d(com.oplus.log.f.d dVar) {
        this.f5794a = dVar;
    }

    public final void a(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this, intentFilter);
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        new Thread(new Runnable() { // from class: com.oplus.log.b.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.f5794a != null) {
                    d.this.f5794a.a(new com.oplus.log.b.b("Network_Info", com.oplus.log.d.c.a(), (byte) 4, null, null));
                }
            }
        }).start();
    }
}
