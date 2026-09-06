package com.baidu.oauth.sdkbqt.auth;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1865a = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    private static final String b = "https://";

    public String a(Context context) {
        return a(context, com.baidu.oauth.sdkbqt.a.c.g(), "BDUSS");
    }

    boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap<String, String> map = new HashMap<>(3);
                for (String str2 : com.baidu.oauth.sdkbqt.a.c.d()) {
                    map.put(b + str2, a(str2, str));
                }
                a(context, map);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    boolean b(Context context, String str) {
        if (context == null) {
            return false;
        }
        HashMap<String, String> map = new HashMap<>(2);
        try {
            for (String str2 : com.baidu.oauth.sdkbqt.a.c.f()) {
                map.put(b + str2, b(str2, "BDUSS", str));
            }
            a(context, map);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        HashMap<String, String> map = new HashMap<>(2);
        try {
            for (String str2 : com.baidu.oauth.sdkbqt.a.c.e()) {
                map.put(b + str2, c(str2, "PTOKEN", str));
            }
            a(context, map);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    boolean d(Context context, String str) {
        if (context == null) {
            return false;
        }
        HashMap<String, String> map = new HashMap<>(2);
        try {
            for (String str2 : com.baidu.oauth.sdkbqt.a.c.f()) {
                map.put(b + str2, a(str2, "BDUSS_BFESS", str));
            }
            a(context, map);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private String a(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), true);
    }

    private String a(String str, String str2) {
        return "cuid=" + str2 + ";domain=" + str + ";path=/;httponly";
    }

    private String b(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), true);
    }

    private String c(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), true);
    }

    private String a(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f1865a, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(date) + ";httponly" + (z ? ";secure" : "");
    }

    private void a(Context context, HashMap<String, String> map) {
        com.baidu.oauth.sdkbqt.a.h.a((Object) context, "context is null");
        if (map == null || map.size() == 0) {
            return;
        }
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(map.get(str))) {
                cookieManager.setCookie(str, map.get(str));
            }
        }
        cookieManager.flush();
    }

    private String a(Context context, String str, String str2) {
        try {
            CookieSyncManager.createInstance(context);
            String cookie = CookieManager.getInstance().getCookie(str);
            if (TextUtils.isEmpty(cookie)) {
                return "";
            }
            for (String str3 : cookie.split(";")) {
                String strTrim = str3.trim();
                if (!TextUtils.isEmpty(strTrim)) {
                    String[] strArrSplit = strTrim.split("=");
                    if (strArrSplit.length == 2 && strArrSplit[0].equals(str2)) {
                        return strArrSplit[1];
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            com.baidu.oauth.sdkbqt.a.d.a(th);
            return "";
        }
    }
}
