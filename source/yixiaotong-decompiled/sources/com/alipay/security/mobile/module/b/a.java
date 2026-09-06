package com.alipay.security.mobile.module.b;

import android.content.Context;
import com.kuaishou.weapon.p0.bo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f1691a = new a();

    private a() {
    }

    public static a a() {
        return f1691a;
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return bo.e;
        }
    }
}
