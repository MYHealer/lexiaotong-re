package com.adprof.sdk;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z1 f1547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f889a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f890a = new y1(this);

    public z1() {
        xn.f1525a.a(180);
    }

    public static z1 a() {
        if (f1547a == null) {
            synchronized (z1.class) {
                if (f1547a == null) {
                    f1547a = new z1();
                }
            }
        }
        return f1547a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m734a() {
        AdprofSdk adprofSdk = AdprofSdk.getInstance();
        return ((adprofSdk == null || adprofSdk.getSdkConfig() == null || adprofSdk.getSdkConfig().useHttps) ? "https://" : "http://") + "bid.buluken.com/bid?mid=" + AdprofSdk.getInstance().getAppId();
    }
}
