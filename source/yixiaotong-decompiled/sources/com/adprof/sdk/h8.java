package com.adprof.sdk;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f1206a = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static int f332a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f333a = null;
    public static int b = -1;

    public static float a() {
        float f = f1206a;
        if (f > 0.0f) {
            return f;
        }
        Context context = AdprofSdk.getInstance().getContext();
        if (context == null) {
            return 1.0f;
        }
        String packageName = context.getPackageName();
        if (f1206a < 0.0f || !packageName.equals(f333a)) {
            f1206a = context.getResources().getDisplayMetrics().density;
            f333a = packageName;
        }
        return f1206a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static int m641a() {
        if (b < 0) {
            Context context = AdprofSdk.getInstance().getContext();
            if (context == null) {
                pk.d("sScreenHeightPixels context == null ");
                return 2190;
            }
            b = context.getResources().getDisplayMetrics().heightPixels;
            pk.d("sScreenHeightPixels = " + b + "   dp = " + b(b));
        }
        return b;
    }

    public static int a(float f) {
        if (f == 0.0f) {
            return 0;
        }
        return (int) ((f * a()) + 0.5f);
    }

    public static int b() {
        if (f332a < 0) {
            Context context = AdprofSdk.getInstance().getContext();
            if (context == null) {
                pk.d("sScreenWidthPixels context == null ");
                return 1080;
            }
            f332a = context.getResources().getDisplayMetrics().widthPixels;
            pk.d("sScreenWidthPixels = " + f332a + "   dp = " + b(f332a));
        }
        return f332a;
    }

    public static int b(float f) {
        if (f == 0.0f || AdprofSdk.getInstance().getContext() == null) {
            return 0;
        }
        return (int) ((f / a()) + 0.5f);
    }
}
