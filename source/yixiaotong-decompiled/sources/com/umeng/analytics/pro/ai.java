package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ai implements z {

    /* JADX INFO: renamed from: com.umeng.analytics.pro.ai$1, reason: invalid class name */
    /* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        a aVar = new a(null);
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return b.a.a(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9098a;
        private final LinkedBlockingQueue<IBinder> b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder a() throws InterruptedException {
            if (this.f9098a) {
                throw new IllegalStateException();
            }
            this.f9098a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        private a() {
            this.f9098a = false;
            this.b = new LinkedBlockingQueue<>();
        }
    }
}
