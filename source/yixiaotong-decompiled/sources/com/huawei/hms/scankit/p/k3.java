package com.huawei.hms.scankit.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: HiAnalyticsLogUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4293a;
    public static String b;

    public static String b() {
        return "";
    }

    public static String b(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException | InvocationTargetException | Exception unused2) {
            return "";
        }
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return "Unknown";
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3G" : subtypeName;
        }
    }

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static String a(Context context, boolean z) {
        return new w0(context, z).a();
    }
}
