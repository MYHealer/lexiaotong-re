package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f1586a;

    public static final boolean a(Context context) {
        Boolean bool = f1586a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f1586a = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
