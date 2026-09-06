package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9541a = new LinkedBlockingQueue<>(1);
    public ServiceConnection b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.LenovoDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9531a.f9541a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public String a(Context context) {
        ServiceConnection serviceConnection;
        String strA;
        context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName(s.d(new byte[]{2, 87, 92, 75, Ascii.EM, 77, 8, 74, 2, 7, 71, 12, 2, 93, 88, 1, 16, 93, 19, Ascii.DC2, 15, 1, 84}, "a81ec8"), s.d(new byte[]{2, 13, 93, Ascii.FS, 72, 71, 8, 74, 2, 7, 71, 12, 2, 7, 89, 86, 65, 87, 19, Ascii.DC2, 15, 1, 84, 75, 37, 7, 70, 91, 81, 87, 8, 0, 53, 7, 67, 19, 8, 1, 85}, "ab0222"));
        try {
            if (!context.bindService(intent, this.b, 1)) {
                return "";
            }
            try {
                IBinder iBinderPoll = this.f9541a.poll(1L, TimeUnit.SECONDS);
                if (iBinderPoll == null) {
                    try {
                        context.unbindService(this.b);
                    } catch (Exception unused) {
                    }
                    return "";
                }
                strA = new com.xiaomi.onetrack.util.oaid.a.c.a.C1164a(iBinderPoll).a();
                try {
                    serviceConnection = this.b;
                } catch (Exception unused2) {
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    serviceConnection = this.b;
                    strA = "";
                } catch (Exception unused3) {
                    return "";
                }
            }
            context.unbindService(serviceConnection);
            return strA;
        } catch (Throwable th) {
            try {
                context.unbindService(this.b);
            } catch (Exception unused4) {
            }
            throw th;
        }
    }
}
