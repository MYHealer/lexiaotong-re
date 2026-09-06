package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4559a = "h";

    public static String a(String str) {
        Context contextA = c.a();
        if (contextA == null) {
            return "";
        }
        try {
            return contextA.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            g.b(f4559a, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            g.b(f4559a, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            g.b(f4559a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context contextA = c.a();
        if (contextA == null) {
            return 0;
        }
        try {
            return contextA.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            g.b(f4559a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            g.b(f4559a, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
