package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.hihonor.hianalytics.util.SystemUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class u0 {
    public static String a() {
        Bundle bundle;
        Object obj;
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.b("DeviceIdUtils", "getChannel context null");
            return "Unknown";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String string = obj.toString();
            return string.length() > 256 ? "Unknown" : string;
        } catch (PackageManager.NameNotFoundException unused) {
            j2.g("DeviceIdUtils", "getChannel The packageName is not correct!");
            return "Unknown";
        }
    }

    public static String b() {
        return com.hihonor.hianalytics.util.j.b("ro.build.version.magic", "");
    }

    public static String c() {
        String str;
        String str2 = "";
        try {
            String str3 = (String) Class.forName("com.hihonor.android.os.Build").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            try {
                j2.c("DeviceIdUtils", "getUDID success");
                return str3;
            } catch (AndroidRuntimeException unused) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                j2.g("DeviceIdUtils", str);
                return str2;
            } catch (ClassNotFoundException unused2) {
                str2 = str3;
                str = "getUDID method invoke failed";
                j2.g("DeviceIdUtils", str);
                return str2;
            } catch (IllegalAccessException unused3) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                j2.g("DeviceIdUtils", str);
                return str2;
            } catch (IllegalArgumentException unused4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                j2.g("DeviceIdUtils", str);
                return str2;
            } catch (NoSuchMethodException unused5) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                j2.g("DeviceIdUtils", str);
                return str2;
            } catch (InvocationTargetException unused6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                j2.g("DeviceIdUtils", str);
                return str2;
            }
        } catch (AndroidRuntimeException unused7) {
        } catch (ClassNotFoundException unused8) {
        } catch (IllegalAccessException unused9) {
        } catch (IllegalArgumentException unused10) {
        } catch (NoSuchMethodException unused11) {
        } catch (InvocationTargetException unused12) {
        }
    }

    public static String d() throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        String str = "";
        if (context == null) {
            j2.b("DeviceIdUtils", "getVersion context is null!");
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(SystemUtils.f(), 0);
            if (packageInfo != null) {
                str = packageInfo.versionName;
            } else {
                j2.b("DeviceIdUtils", "getVersion PackageInfo is null!");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            j2.g("DeviceIdUtils", "getVersion The package name is not correct!");
        }
        return str;
    }
}
