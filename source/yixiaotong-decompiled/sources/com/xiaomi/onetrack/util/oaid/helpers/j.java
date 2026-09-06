package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class j {
    private static final String d = s.d(new byte[]{44, 70, 69, 95, 119, 84, Ascii.ETB, 13, 5, 7, 120, 33, 43, 83, 89, SignedBytes.MAX_POWER_OF_TWO, 86, 67}, "c65031");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.xiaomi.onetrack.util.oaid.a.e f9547a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.xiaomi.onetrack.util.oaid.helpers.OppoDeviceIDHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9533a.b.offer(iBinder, 1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                p.a(s.d(new byte[]{119, 17, Ascii.SYN, 95, 33, 82, Ascii.ETB, 13, 5, 7, 120, 33, 112, 4, 10, SignedBytes.MAX_POWER_OF_TWO, 0, 69}, "8af0e7"), e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f9533a.f9547a = null;
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
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(s.d(new byte[]{99, 124, 116, 1}, "0450f5"));
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.e = string;
        }
        return ((com.xiaomi.onetrack.util.oaid.a.e.a.C1166a) this.f9547a).a(packageName, this.e, str);
    }

    private boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(s.d(new byte[]{80, 95, 11, 75, 91, 85, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, 67, 85, 8, 12, 87}, "30fe30"), 0);
            return packageInfo != null && ((long) packageInfo.versionCode) >= 1;
        } catch (Exception e) {
            p.a(d, e.getMessage());
            return true;
        }
    }

    public String a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s.d(new byte[]{90, 14, 92, Ascii.FS, 92, 7, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, 73, 4, 95, 91, 80}, "9a124b"), s.d(new byte[]{91, 93, 95, 26, 9, 92, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, 72, 87, 92, 93, 5, Ascii.ETB, 40, 0, 3, 12, 69, 12, 94, 75, 97, 81, 19, 79, 8, 7, 3}, "8224a9")));
        intent.setAction(s.d(new byte[]{2, 85, Ascii.NAK, 93, 88, 13, 79, 7, 9, 15, Ascii.US, 13, 6, 79, Ascii.NAK, 85, 71, 77, 14, Ascii.DC4, 3, 12, 88, 1, 77, 121, 49, 113, 121, 60, 40, 32, 57, 49, 116, 55, 53, 127, 34, 113}, "c6a47c"));
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
                        com.xiaomi.onetrack.util.oaid.a.e eVarA = com.xiaomi.onetrack.util.oaid.a.e.a.a(iBinderPoll);
                        this.f9547a = eVarA;
                        strA = eVarA != null ? a(s.d(new byte[]{41, 102, 120, 117}, "f311e0"), context) : "";
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
