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
public class m {
    private static final String d = s.d(new byte[]{99, 48, 39, 124, 87, SignedBytes.MAX_POWER_OF_TWO, 8, 7, 3, 43, 117, 45, 92, 8, Ascii.DC2, 93, SignedBytes.MAX_POWER_OF_TWO}, "9db826");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9550a = s.d(new byte[]{84, 93, 89, Ascii.ETB, 85, 84, 8, 0, 72, 15, 66, 4}, "724980");
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.ZTEDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9535a.b.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a(s.d(new byte[]{99, 100, 39, 39, 81, 70, 8, 7, 3, 43, 117, 45, 92, 92, Ascii.DC2, 6, 70}, "90bc40"), e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private void a(String str, Context context) {
        Intent intent = new Intent();
        intent.setClassName(this.f9550a, s.d(new byte[]{81, 86, 11, Ascii.US, 84, 93, 8, 0, 72, 15, 66, 4, Ascii.FS, 74, 3, 67, 79, 80, 2, 1, 72, 47, 66, 4, 121, 85, 53, 84, 75, 79, 8, 7, 3}, "29f199"));
        intent.setAction(s.d(new byte[]{7, 90, 12, Ascii.CAN, 86, Ascii.DC4, 15, 74, 11, 17, 80, 75, 5, 86, Ascii.NAK, 95, 91, 15, 79, Ascii.ETB, Ascii.DC2, 3, 67, 17, 74, 70, 4, 68, 66, 8, 2, 1}, "d5a64a"));
        intent.putExtra(s.d(new byte[]{90, 91, 90, 72, 87, 76, 15, 74, 11, 17, 80, 75, 73, 85, 69, 7, 88, Ascii.ETB, 17, 15, 1, 12, 80, 8, 92}, "947f59"), str);
        try {
            intent.putExtra(s.d(new byte[]{0, 12, 14, Ascii.ETB, 85, Ascii.SYN, 15, 74, 11, 17, 80, 75, 19, 2, 17, 88, 90, 77, 19, 17, 8, 11, 95, Ascii.SYN, 6, Ascii.ETB}, "ccc97c"), true);
            context.startService(intent);
        } catch (Exception e) {
            p.a(d, e.getMessage());
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:42:0x00c3 */
    /* JADX WARN: Multi-variable type inference failed */
    public String a(Context context) {
        try {
            context.getPackageManager().getPackageInfo(this.f9550a, 0);
        } catch (Exception e) {
            p.a(d, e.getMessage());
        }
        String packageName = context.getPackageName();
        a(packageName, context);
        Intent intent = new Intent();
        intent.setClassName(s.d(new byte[]{85, 87, 8, 26, 14, 82, 8, 0, 72, 15, 66, 4}, "68e4c6"), s.d(new byte[]{2, 11, 95, Ascii.GS, 92, 2, 8, 0, 72, 15, 66, 4, 79, Ascii.ETB, 87, 65, 71, 15, 2, 1, 72, 47, 66, 4, 40, 0, 97, 86, 67, 16, 8, 7, 3}, "ad231f"));
        intent.setAction(s.d(new byte[]{84, 95, 92, 26, 82, 19, 15, 74, 11, 17, 80, 75, 86, 83, 69, 93, 95, 8, 79, 6, 15, 12, 85, 17, 88, Ascii.RS, 66, 81, 66, 16, 8, 7, 3}, "70140f"));
        intent.putExtra(s.d(new byte[]{0, 89, 8, 75, 6, 19, 15, 74, 11, 17, 80, 75, 19, 87, Ascii.ETB, 4, 9, 72, 17, 15, 1, 12, 80, 8, 6}, "c6eedf"), packageName);
        boolean zBindService = context.bindService(intent, this.c, 1);
        String strB = "";
        try {
            try {
                if (zBindService) {
                    try {
                        IBinder iBinderPoll = this.b.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            try {
                                context.unbindService(this.c);
                            } catch (Exception e2) {
                                p.a(d, e2.getMessage());
                            }
                            return "";
                        }
                        strB = new com.xiaomi.onetrack.util.oaid.a.g.a.C1167a(iBinderPoll).b();
                        context.unbindService(this.c);
                        context = context;
                    } catch (Exception e3) {
                        p.a(d, e3.getMessage());
                        context.unbindService(this.c);
                        context = context;
                    }
                }
            } catch (Throwable th) {
                try {
                    context.unbindService(this.c);
                } catch (Exception e4) {
                    p.a(d, e4.getMessage());
                }
                throw th;
            }
        } catch (Exception e5) {
            String message = e5.getMessage();
            p.a(d, message);
            context = message;
        }
        return strB;
    }
}
