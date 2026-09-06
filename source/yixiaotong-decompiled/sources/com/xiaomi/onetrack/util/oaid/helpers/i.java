package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class i {
    private static final String d = s.d(new byte[]{120, 94, 1, 53, 95, 65, Ascii.DC2, 32, 3, Ascii.DC4, 88, 6, 82, 121, 32, 45, 86, 88, 17, 1, Ascii.DC4}, "70de34");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.xiaomi.onetrack.util.oaid.a.d f9546a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.OnePlusDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9532a.b.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a(s.d(new byte[]{44, 11, 0, 100, 85, 16, Ascii.DC2, 32, 3, Ascii.DC4, 88, 6, 6, 44, 33, 124, 92, 9, 17, 1, Ascii.DC4}, "cee49e"), e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f9532a.f9546a = null;
        }
    };
    private String e;

    private String a(String str, Context context) {
        Signature[] signatureArr;
        String packageName = context.getPackageName();
        if (this.e == null) {
            String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
                p.a(d, e.getMessage());
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(s.d(new byte[]{103, 120, 113, 84}, "400e63"));
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (Exception e2) {
                    p.a(d, e2.getMessage());
                }
            }
            this.e = string;
        }
        return ((com.xiaomi.onetrack.util.oaid.a.d.a.C1165a) this.f9546a).a(packageName, this.e, str);
    }

    private boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(s.d(new byte[]{6, 89, 8, Ascii.FS, 90, 82, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, Ascii.NAK, 83, 11, 91, 86}, "e6e227"), 0);
            return packageInfo != null && ((long) packageInfo.versionCode) >= 1;
        } catch (Exception e) {
            p.a(d, e.getMessage());
            return true;
        }
    }

    public String a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s.d(new byte[]{87, 86, 93, Ascii.CAN, 9, 86, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, 68, 92, 94, 95, 5}, "4906a3"), s.d(new byte[]{81, 10, 84, Ascii.SYN, 12, 7, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, 66, 0, 87, 81, 0, 76, 40, 0, 3, 12, 69, 12, 84, Ascii.FS, 106, 93, Ascii.SYN, Ascii.DC4, 8, 7, 3}, "2e98db")));
        intent.setAction(s.d(new byte[]{7, 82, 17, 10, 91, 91, 79, 7, 9, 15, Ascii.US, 13, 3, 72, 17, 2, 68, Ascii.ESC, 14, Ascii.DC4, 3, 12, 88, 1, 72, 126, 53, 38, 122, 106, 40, 32, 57, 49, 116, 55, 48, 120, 38, 38}, "f1ec45"));
        String strA = "";
        try {
            if (context.bindService(intent, this.c, 1)) {
                try {
                    try {
                        IBinder iBinderPoll = this.b.poll(1L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            try {
                                context.unbindService(this.c);
                            } catch (Exception e) {
                                p.a(d, e.getMessage());
                            }
                            return "";
                        }
                        com.xiaomi.onetrack.util.oaid.a.d dVarA = com.xiaomi.onetrack.util.oaid.a.d.a.a(iBinderPoll);
                        this.f9546a = dVarA;
                        strA = dVarA != null ? a(s.d(new byte[]{118, 108, 121, 114}, "99062f"), context) : "";
                        context.unbindService(this.c);
                    } catch (Exception e2) {
                        p.a(d, e2.getMessage());
                        context.unbindService(this.c);
                    }
                } catch (Throwable th) {
                    try {
                        context.unbindService(this.c);
                    } catch (Exception e3) {
                        p.a(d, e3.getMessage());
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            p.a(d, e4.getMessage());
        }
        return strA;
    }
}
