package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class k {
    private static final String c = s.d(new byte[]{102, 84, 9, 67, Ascii.DC4, 87, 6, 32, 3, Ascii.DC4, 88, 6, 80, 124, 32, 120, 4, 85, 17, 1, Ascii.DC4}, "55d0a9");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9548a = new LinkedBlockingQueue<>(1);
    public ServiceConnection b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.SamsungDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9534a.f9548a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a(s.d(new byte[]{50, 2, 11, 67, 68, 15, 6, 32, 3, Ascii.DC4, 88, 6, 4, 42, 34, 120, 84, 13, 17, 1, Ascii.DC4}, "acf01a"), e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public String a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(s.d(new byte[]{80, 9, 91, Ascii.EM, 16, 84, 12, Ascii.ETB, 19, 12, 86, 75, 82, 8, 82, 69, 12, 92, 5, 74, 2, 7, 71, 12, 80, 3, 95, 83, 16, 80, 19, Ascii.DC2, 15, 1, 84}, "3f67c5"), s.d(new byte[]{86, 87, 9, Ascii.SYN, Ascii.SYN, 82, 12, Ascii.ETB, 19, 12, 86, 75, 84, 86, 0, 74, 10, 90, 5, 74, 2, 7, 71, 12, 86, 93, 13, 92, Ascii.SYN, 86, 19, Ascii.DC2, 15, 1, 84, 75, 113, 93, Ascii.DC2, 81, 6, 86, 40, 0, 53, 7, 67, 19, 92, 91, 1}, "58d8e3"));
        String strA = "";
        try {
            try {
                if (context.bindService(intent, this.b, 1)) {
                    try {
                        IBinder iBinderPoll = this.f9548a.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            try {
                                context.unbindService(this.b);
                            } catch (Exception e) {
                                p.a(c, e.getMessage());
                            }
                            return "";
                        }
                        strA = new com.xiaomi.onetrack.util.oaid.a.f.a(iBinderPoll).a();
                        context.unbindService(this.b);
                    } catch (Exception e2) {
                        p.a(c, e2.getMessage());
                        context.unbindService(this.b);
                    }
                }
            } catch (Exception e3) {
                context = e3.getMessage();
                p.a(c, context);
            }
            return strA;
        } catch (Throwable th) {
            try {
                context.unbindService(this.b);
            } catch (Exception e4) {
                p.a(c, e4.getMessage());
            }
            throw th;
        }
    }
}
