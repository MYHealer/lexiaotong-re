package com.heytap.mspsdk.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3459a;
    private final String b;
    private final String c;

    b(String str, String str2, int i) {
        this.c = str;
        this.b = str2;
        this.f3459a = i;
    }

    public static b a(Context context) {
        if (!h()) {
            PackageInfo packageInfoA = com.heytap.mspsdk.util.a.a(context);
            return packageInfoA != null ? new b(packageInfoA.packageName, packageInfoA.versionName, packageInfoA.versionCode) : i();
        }
        ApplicationInfo applicationInfoB = com.heytap.mspsdk.util.a.b(context);
        if (applicationInfoB == null) {
            return i();
        }
        String string = applicationInfoB.metaData.getString("mspCoreName");
        if (string == null) {
            string = "";
        }
        return new b(applicationInfoB.packageName, string, applicationInfoB.metaData.getInt("mspCoreCode"));
    }

    public static boolean g() {
        if (com.heytap.mspsdk.util.c.b()) {
            return (com.heytap.mspsdk.util.c.a() || com.heytap.mspsdk.util.b.b()) ? false : true;
        }
        return true;
    }

    private static boolean h() {
        return com.heytap.mspsdk.util.c.b() && com.heytap.mspsdk.util.c.a() && !com.heytap.mspsdk.util.b.b();
    }

    private static b i() {
        return new b("", "", 0);
    }

    public boolean a() {
        return this.f3459a >= 2000000;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.c);
    }

    public boolean c() {
        return b() ? "com.heytap.htms".equals(this.c) : !h();
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.f3459a;
    }

    public String f() {
        return this.c;
    }
}
