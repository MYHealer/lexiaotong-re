package com.oplus.instant.router.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f5785a;
    private static String b = "com." + b() + ".instant.platform";
    private static String c = "com." + b() + ".instant.platform.tv";

    public static String a() {
        return "1.4.0_22030b1_230523";
    }

    public static String a(Context context) {
        if (b(context)) {
            int iG = g(context);
            int iH = h(context);
            int i = i(context);
            if (-1 != iG && -1 != iH && -1 != i) {
                StringBuilder sbAppend = new StringBuilder().append(iH).append("/").append(iG).append("/").append(i);
                try {
                    return URLEncoder.encode(sbAppend.toString(), "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    return sbAppend.toString();
                }
            }
        }
        return "-1";
    }

    private static boolean a(Context context, int i) {
        return g(context) >= i;
    }

    public static boolean a(Context context, String str) {
        Uri uri;
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null) {
            String queryParameter = uri.getQueryParameter("min");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    int i = Integer.parseInt(queryParameter);
                    return i >= 100 && a(context, i);
                } catch (NumberFormatException e) {
                    d.a("VersionUtil", e);
                }
            }
        }
        return false;
    }

    private static String b() {
        return a.a("bmVhcm1l");
    }

    public static boolean b(Context context) {
        return !TextUtils.isEmpty(d(context));
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.contains("min")) {
            return true;
        }
        Uri uri = Uri.parse(str);
        return uri != null && (TextUtils.isEmpty(uri.getQueryParameter("min")) || a(context, str));
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(d(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            d.a("VersionUtil", e);
            return -1;
        }
    }

    private static boolean c(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128) != null;
        } catch (Exception e) {
            d.a("VersionUtil", e);
            return false;
        }
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(f5785a)) {
            return f5785a;
        }
        f5785a = j(context);
        return f5785a;
    }

    public static int e(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(d(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get(am.aj)) != null && (obj instanceof Integer)) {
                return Integer.parseInt(String.valueOf(obj).substring(0, 4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String f(Context context) {
        int iE = e(context);
        int iH = h(context);
        int i = i(context);
        if (-1 == iE || -1 == iH || -1 == i) {
            return "-1";
        }
        StringBuilder sbAppend = new StringBuilder().append(iH).append("/").append(iE).append("/").append(i);
        try {
            return URLEncoder.encode(sbAppend.toString(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return sbAppend.toString();
        }
    }

    private static int g(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(d(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("platformVersion")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e) {
            d.a("VersionUtil", e);
        }
        return -1;
    }

    private static int h(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(d(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get(am.aj)) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e) {
            d.a("VersionUtil", e);
        }
        return -1;
    }

    private static int i(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(d(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("biz_version")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e) {
            d.a("VersionUtil", e);
        }
        return -1;
    }

    private static String j(Context context) {
        if (com.oplus.instant.router.a.a()) {
            if (c(context, "com.oplus.instant.platform")) {
                return "com.oplus.instant.platform";
            }
            return c(context, b) ? b : "";
        }
        if (!com.oplus.instant.router.a.b()) {
            return "";
        }
        if (c(context, "com.oplus.instant.platform.tv")) {
            return "com.oplus.instant.platform.tv";
        }
        return c(context, c) ? c : "";
    }
}
