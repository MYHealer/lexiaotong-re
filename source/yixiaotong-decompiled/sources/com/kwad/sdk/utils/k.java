package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.byazt.bv.BaseConstants;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.unionpay.tsmservice.mi.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class k {
    private static String boz = Build.BRAND;
    private static String boA = BaseConstants.ROM_OPPO_UPPER_CONSTANT;
    private static String boB = "vivo";
    private static String boC = Constant.DEVICE_XIAOMI;
    private static String boD = "Meizu";
    private static String boE = "HUAWEI";
    private static String boF = "HONOR";

    public static void cV(Context context) {
        Intent intentCW;
        if (context == null || (intentCW = cW(context)) == null) {
            return;
        }
        try {
            context.startActivity(intentCW);
        } catch (Exception unused) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    private static Intent cW(Context context) {
        Intent intent;
        if (Ux()) {
            return R(context, UC());
        }
        if (Uy() || Uz()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        } else if (Uv()) {
            intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
        } else if (UA() || UB()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        } else if (Uw()) {
            intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
        } else {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        }
        return intent;
    }

    private static Intent R(Context context, String str) {
        if ("V5".equals(str)) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
        if ("V6".equals(str) || "V7".equals(str)) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        return intent2;
    }

    private static boolean Uv() {
        String str = "";
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.display.id", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toLowerCase().contains("flyme");
    }

    private static boolean Uw() {
        return "QIKU".equals(Build.MANUFACTURER.toUpperCase()) || "360".equals(Build.MANUFACTURER.toUpperCase());
    }

    private static boolean Ux() {
        return boz.equalsIgnoreCase(boC);
    }

    public static boolean Uy() {
        return boz.equalsIgnoreCase(boE);
    }

    public static boolean Uz() {
        return boz.equalsIgnoreCase(boF);
    }

    private static boolean UA() {
        return boz.equalsIgnoreCase(boA);
    }

    private static boolean UB() {
        return boz.equalsIgnoreCase(boB);
    }

    private static String UC() {
        return as("ro.miui.ui.version.name", "");
    }

    private static String as(String str, String str2) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
