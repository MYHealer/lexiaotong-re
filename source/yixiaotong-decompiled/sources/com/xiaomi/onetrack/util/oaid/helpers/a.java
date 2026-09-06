package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {
    private static final String c = s.d(new byte[]{116, 99, 55, 101, 34, 6, Ascii.ETB, 13, 5, 7, 120, 33, 125, 85, 14, 70, 3, 17}, "50b6fc");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9536a = new LinkedBlockingQueue<>(1);
    public ServiceConnection b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.ASUSDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9529a.f9536a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a(s.d(new byte[]{117, 107, 52, 55, 125, 3, Ascii.ETB, 13, 5, 7, 120, 33, 124, 93, 13, Ascii.DC4, 92, Ascii.DC4}, "48ad9f"), e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public String a(Context context) {
        Intent intent = new Intent();
        intent.setAction(s.d(new byte[]{1, 14, 12, 74, 2, 66, Ascii.DC4, Ascii.ETB, 72, 15, 66, 4, 76, 0, 2, 16, 10, 94, 15, 74, 39, 33, 114, 32, 49, 50, 62, 32, 42, 117}, "baadc1"));
        intent.setComponent(new ComponentName(s.d(new byte[]{81, 87, 95, Ascii.SYN, 3, 74, Ascii.DC4, Ascii.ETB, 72, 15, 66, 4, Ascii.FS, 107, 71, 72, Ascii.DC2, 85, 4, 9, 3, 12, 69, 4, SignedBytes.MAX_POWER_OF_TWO, 65, 118, 113, 38}, "2828b9"), s.d(new byte[]{5, 95, 93, 75, 82, Ascii.SYN, Ascii.DC4, Ascii.ETB, 72, 15, 66, 4, 72, 99, 69, Ascii.NAK, 67, 9, 4, 9, 3, 12, 69, 4, Ascii.DC4, 73, 116, 44, 119, 75, 50, 17, Ascii.SYN, Ascii.DC2, 93, 0, 11, 85, 94, 17, 82, Ascii.ETB, Ascii.CAN, 32, 47, 38, 98, 0, Ascii.DC4, 70, 89, 6, 86}, "f00e3e")));
        String strA = "";
        try {
            if (context.bindService(intent, this.b, 1)) {
                try {
                    try {
                        IBinder iBinderPoll = this.f9536a.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            try {
                                context.unbindService(this.b);
                            } catch (Exception e) {
                                p.a(c, e.getMessage());
                            }
                            return "";
                        }
                        strA = new com.xiaomi.onetrack.util.oaid.a.a.C1163a(iBinderPoll).a();
                        context.unbindService(this.b);
                    } catch (Exception e2) {
                        p.a(c, e2.getMessage());
                        context.unbindService(this.b);
                    }
                } catch (Throwable th) {
                    try {
                        context.unbindService(this.b);
                    } catch (Exception e3) {
                        p.a(c, e3.getMessage());
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            p.a(c, e4.getMessage());
        }
        return strA;
    }
}
