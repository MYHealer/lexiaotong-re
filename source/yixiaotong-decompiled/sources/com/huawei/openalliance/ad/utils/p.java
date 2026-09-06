package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.stub.StubApp;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class p {
    private static final String B = "com.huawei.software.features.mobiletv";
    private static final String C = "com.huawei.software.features.watch";
    private static final String Code = "DeviceTypeUtil";
    private static final String D = "com.hihonor.software.features.pad";
    private static final String F = "com.hihonor.software.features.handset";
    private static final String I = "com.huawei.software.features.pad";
    private static final String L = "com.hihonor.software.features.tv";
    private static final String S = "com.huawei.software.features.kidwatch";
    private static final String V = "com.huawei.software.features.handset";
    private static final String Z = "com.huawei.software.features.tv";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4479a = "com.hihonor.software.features.mobiletv";
    private static final String b = "com.hihonor.software.features.watch";
    private static final String c = "com.hihonor.software.features.kidwatch";
    private static final String d = "default";
    private static final String e = "tablet";
    private static final String f = "tv";
    private static p g;
    private static final byte[] h = new byte[0];
    private Context i;
    private String j = "0";

    private p(Context context) {
        this.i = StubApp.getOrigApplicationContext(context.getApplicationContext());
        Z();
    }

    public static p Code(Context context) {
        return V(context);
    }

    private static p V(Context context) {
        p pVar;
        synchronized (h) {
            if (g == null) {
                g = new p(context);
            }
            pVar = g;
        }
        return pVar;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00da A[Catch: all -> 0x00fe, TryCatch #0 {all -> 0x00fe, blocks: (B:6:0x0010, B:8:0x001d, B:10:0x0027, B:11:0x0044, B:12:0x0047, B:15:0x0051, B:18:0x005b, B:21:0x0065, B:24:0x006f, B:26:0x0077, B:29:0x0081, B:32:0x008b, B:35:0x0094, B:37:0x009c, B:40:0x00a5, B:42:0x00ad, B:45:0x00b6, B:48:0x00dd, B:51:0x00e8, B:55:0x00f5, B:53:0x00f0, B:50:0x00e5, B:47:0x00da), top: B:63:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e5 A[Catch: all -> 0x00fe, TryCatch #0 {all -> 0x00fe, blocks: (B:6:0x0010, B:8:0x001d, B:10:0x0027, B:11:0x0044, B:12:0x0047, B:15:0x0051, B:18:0x005b, B:21:0x0065, B:24:0x006f, B:26:0x0077, B:29:0x0081, B:32:0x008b, B:35:0x0094, B:37:0x009c, B:40:0x00a5, B:42:0x00ad, B:45:0x00b6, B:48:0x00dd, B:51:0x00e8, B:55:0x00f5, B:53:0x00f0, B:50:0x00e5, B:47:0x00da), top: B:63:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00f0 A[Catch: all -> 0x00fe, TryCatch #0 {all -> 0x00fe, blocks: (B:6:0x0010, B:8:0x001d, B:10:0x0027, B:11:0x0044, B:12:0x0047, B:15:0x0051, B:18:0x005b, B:21:0x0065, B:24:0x006f, B:26:0x0077, B:29:0x0081, B:32:0x008b, B:35:0x0094, B:37:0x009c, B:40:0x00a5, B:42:0x00ad, B:45:0x00b6, B:48:0x00dd, B:51:0x00e8, B:55:0x00f5, B:53:0x00f0, B:50:0x00e5, B:47:0x00da), top: B:63:0x0010 }] */
    private void Z() {
        String str;
        PackageManager packageManager = this.i.getPackageManager();
        if (packageManager == null) {
            fh.Z(Code, "packageManager is null.");
            return;
        }
        try {
            FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
            HashSet hashSet = new HashSet();
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (!TextUtils.isEmpty(featureInfo.name)) {
                    fh.Code(Code, "add feature:" + featureInfo.name);
                    hashSet.add(featureInfo.name);
                }
            }
            if (hashSet.contains(V) || hashSet.contains(F)) {
                this.j = "0";
            } else if (hashSet.contains(I) || hashSet.contains(D)) {
                this.j = "1";
            } else {
                if (hashSet.contains(B) || hashSet.contains(f4479a)) {
                    str = "5";
                } else if (hashSet.contains(Z) || hashSet.contains(L)) {
                    this.j = "4";
                } else if (hashSet.contains(S) || hashSet.contains(c)) {
                    str = "3";
                } else if (hashSet.contains(C) || hashSet.contains(b)) {
                    str = "2";
                } else {
                    String strCode = bg.Code("ro.build.characteristics");
                    fh.V(Code, "characteristics:" + strCode);
                    if (strCode.equals(d)) {
                        this.j = "0";
                    } else if (strCode.equals("tablet")) {
                        this.j = "1";
                    } else if (strCode.equals(f)) {
                        this.j = "4";
                    }
                }
                this.j = str;
            }
        } catch (Throwable th) {
            fh.I(Code, "get device type error:" + th.getClass().getSimpleName());
        }
        fh.V(Code, "type is:" + this.j);
    }

    public String Code() {
        return this.j;
    }

    public int I() {
        if ("4".equalsIgnoreCase(this.j)) {
            return 8;
        }
        return "1".equalsIgnoreCase(this.j) ? 5 : 4;
    }

    public boolean V() {
        return "4".equalsIgnoreCase(Code(this.i).Code());
    }
}
