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
public class d {
    private static final String c = s.d(new byte[]{42, 103, 117, 4, Ascii.NAK, 8, 2, 1, 47, 38, 121, 0, 14, SignedBytes.MAX_POWER_OF_TWO, 84, 19}, "b01aca");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9540a = new LinkedBlockingQueue<>(1);
    public ServiceConnection b = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.HWDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9530a.f9540a.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a(s.d(new byte[]{46, 103, 37, 86, 66, 15, 2, 1, 47, 38, 121, 0, 10, SignedBytes.MAX_POWER_OF_TWO, 4, 65}, "f0a34f"), e.getMessage());
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
        Intent intent = new Intent(s.d(new byte[]{2, 95, 93, 74, 67, 91, 5, 13, Ascii.NAK, 76, 94, Ascii.NAK, 4, 94, 84, 1, SignedBytes.MAX_POWER_OF_TWO, 93, 2, 1, 72, 45, 97, 32, 47, 121, 116, 55, 105, 103, 36, 54, 48, 43, 114, 32}, "a00d64"));
        intent.setPackage(s.d(new byte[]{81, 88, 15, Ascii.GS, 93, 69, 0, 19, 3, 11, Ascii.US, 13, 69, 94, 6}, "27b350"));
        String strA = "";
        try {
            try {
                if (context.bindService(intent, this.b, 1)) {
                    try {
                        IBinder iBinderPoll = this.f9540a.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            try {
                                context.unbindService(this.b);
                            } catch (Exception e) {
                                p.a(c, e.getMessage());
                            }
                            return "";
                        }
                        strA = new com.xiaomi.onetrack.util.oaid.a.b.a(iBinderPoll).a();
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
