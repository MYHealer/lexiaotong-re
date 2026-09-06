package com.ubix.ssp.ad.e.a0.c0.h;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8659a;
    private final com.ubix.ssp.ad.e.a0.c0.c b;
    private final a c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    private m(Context context, com.ubix.ssp.ad.e.a0.c0.c cVar, a aVar) {
        this.f8659a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.b = cVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, com.ubix.ssp.ad.e.a0.c0.c cVar, a aVar) {
        new m(context, cVar, aVar).a(intent);
    }

    private void a(Intent intent) {
        try {
            if (!this.f8659a.bindService(intent, this, 1)) {
                throw new com.ubix.ssp.ad.e.a0.c0.e("Service binding failed");
            }
            com.ubix.ssp.ad.e.a0.c0.f.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.ubix.ssp.ad.e.a0.c0.f.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new com.ubix.ssp.ad.e.a0.c0.e("OAID/AAID acquire failed");
                    }
                    com.ubix.ssp.ad.e.a0.c0.f.a("OAID/AAID acquire success: " + strA);
                    this.b.a(strA);
                    this.f8659a.unbindService(this);
                    com.ubix.ssp.ad.e.a0.c0.f.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    com.ubix.ssp.ad.e.a0.c0.f.a(e);
                }
            } catch (Exception e2) {
                com.ubix.ssp.ad.e.a0.c0.f.a(e2);
                this.b.a(e2);
                this.f8659a.unbindService(this);
                com.ubix.ssp.ad.e.a0.c0.f.a("Service has been unbound: " + componentName.getClassName());
            }
        } catch (Throwable th) {
            try {
                this.f8659a.unbindService(this);
                com.ubix.ssp.ad.e.a0.c0.f.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                com.ubix.ssp.ad.e.a0.c0.f.a(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ubix.ssp.ad.e.a0.c0.f.a("Service has been disconnected: " + componentName.getClassName());
    }
}
