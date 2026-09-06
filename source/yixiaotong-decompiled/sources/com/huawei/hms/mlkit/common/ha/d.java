package com.huawei.hms.mlkit.common.ha;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: HianalyticsLogUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d {
    public static String a() {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            Method declaredMethod = cls.getDeclaredMethod("get", String.class);
            return "HONOR".equals(Build.BRAND) ? (String) declaredMethod.invoke(cls, "ro.build.version.magic") : (String) declaredMethod.invoke(cls, "ro.build.version.emui");
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException | Exception unused2) {
            return "";
        }
    }

    public static String b(Context context) {
        return context == null ? "" : ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || context.getPackageManager().checkPermission(g.b, context.getPackageName()) != 0) {
            return "Unknown";
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            b.c(t.t, "can not get android.permission.ACCESS_NETWORK_STATE.");
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) ? "Unknown" : "mobile network";
        }
        return "wifi";
    }

    public static LinkedHashMap<String, String> a(HianalyticsLog hianalyticsLog) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("package", hianalyticsLog.p());
        linkedHashMap.put("appid", hianalyticsLog.e());
        linkedHashMap.put("version", hianalyticsLog.t());
        linkedHashMap.put("service", hianalyticsLog.r());
        linkedHashMap.put("apiName", hianalyticsLog.b());
        linkedHashMap.put("result", hianalyticsLog.q());
        linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, hianalyticsLog.g());
        linkedHashMap.put("callTime", hianalyticsLog.f());
        linkedHashMap.put("transId", hianalyticsLog.s());
        linkedHashMap.put("operator", hianalyticsLog.o());
        linkedHashMap.put("networkType", hianalyticsLog.n());
        linkedHashMap.put("apkVersion", hianalyticsLog.c());
        linkedHashMap.put("appName", hianalyticsLog.d());
        linkedHashMap.put("countryCode", hianalyticsLog.h());
        linkedHashMap.put("deviceType", hianalyticsLog.j());
        linkedHashMap.put("emuiVersion", hianalyticsLog.k());
        linkedHashMap.put("androidVersion", hianalyticsLog.a());
        linkedHashMap.put("moduleName", hianalyticsLog.l());
        linkedHashMap.put("moduleVersion", hianalyticsLog.m());
        linkedHashMap.put("deviceCategory", hianalyticsLog.i());
        return linkedHashMap;
    }

    public static a a(Context context, Bundle bundle) {
        if (bundle == null) {
            return new a();
        }
        String string = bundle.getString("packageName");
        if (string == null || string.equals("")) {
            b.c(t.t, "packageName from bundle is null.");
            string = context.getPackageName();
        }
        String string2 = bundle.getString("appid");
        String string3 = bundle.getString("com.huawei.hms.client.service.name:ml-computer-vision");
        String string4 = bundle.getString("appName");
        Boolean boolValueOf = Boolean.valueOf(bundle.getBoolean("openHa"));
        return new a(string, string2, string3, string4, boolValueOf.booleanValue(), bundle.getString("countryCode"));
    }
}
