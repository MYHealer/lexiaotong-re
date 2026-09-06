package com.baidu.passbqt.http;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class PassHttpCookieUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1936a = "PassHttpCookieUtil";
    private static final String b = "Set-Cookie";
    private static final String c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    private static final String d = "Cookie";
    private static final String e = "https://";

    PassHttpCookieUtil() {
    }

    static void a(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        HttpCookie httpCookie;
        try {
            CookieSyncManager.createInstance(context);
            String cookie = CookieManager.getInstance().getCookie(e + new URI(passHttpParamDTO.f1937a).getHost());
            String str = f1936a;
            PassHttpUtils.a(str, "asyncCookie" + passHttpParamDTO.f);
            PassHttpUtils.a(str, "webviewCookies" + cookie);
            if (!passHttpParamDTO.f) {
                cookie = null;
            }
            List<HttpCookie> list = passHttpParamDTO.b;
            if (TextUtils.isEmpty(cookie) && (list == null || list.isEmpty())) {
                return;
            }
            String str2 = "";
            String[] strArrSplit = TextUtils.isEmpty(cookie) ? null : cookie.split(";");
            if (strArrSplit != null && strArrSplit.length > 0) {
                for (String str3 : strArrSplit) {
                    if (!TextUtils.isEmpty(str3)) {
                        List<HttpCookie> list2 = HttpCookie.parse(str3);
                        if (!list2.isEmpty() && (httpCookie = list2.get(0)) != null && !httpCookie.hasExpired()) {
                            if (list != null) {
                                for (HttpCookie httpCookie2 : list) {
                                    if (httpCookie.getName().equals(httpCookie2.getName()) && a(passHttpParamDTO.f1937a, httpCookie)) {
                                        httpCookie = httpCookie2;
                                    }
                                }
                            }
                            if (!httpCookie.hasExpired()) {
                                str2 = str2 + httpCookie.getName() + "=" + httpCookie.getValue() + ";";
                            }
                            PassHttpUtils.a(f1936a, "httpCookie webview item name:" + httpCookie.getName() + ",value:" + httpCookie.getValue());
                        }
                    }
                }
            }
            if (list != null) {
                for (HttpCookie httpCookie3 : list) {
                    if (a(passHttpParamDTO.f1937a, httpCookie3)) {
                        str2 = str2 + httpCookie3.getName() + "=" + httpCookie3.getValue() + ";";
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String strSubstring = str2.substring(0, str2.length() - 1);
            PassHttpUtils.a(f1936a, "cookieStr" + strSubstring);
            httpURLConnection.setRequestProperty("Cookie", strSubstring);
        } catch (Exception e2) {
            PassHttpUtils.a(f1936a, "asyncWebviewCookie2NA:" + e2.toString());
        }
    }

    static String a(String str, String str2, String str3, long j, boolean z) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(calendar.getTime()) + ";httponly" + (z ? ";secure" : "");
    }

    static void b(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        Map<String, List<String>> headerFields;
        List<String> list;
        try {
            PassHttpUtils.a(f1936a, "asyncCookie" + passHttpParamDTO.f);
            if (passHttpParamDTO.f && (headerFields = httpURLConnection.getHeaderFields()) != null && !headerFields.isEmpty() && (list = headerFields.get("Set-Cookie")) != null && !list.isEmpty()) {
                CookieSyncManager.createInstance(context);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                if (cookieManager.acceptCookie()) {
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str)) {
                            List<HttpCookie> list2 = HttpCookie.parse(str);
                            if (!list2.isEmpty()) {
                                HttpCookie httpCookie = list2.get(0);
                                if (a(passHttpParamDTO.f1937a, httpCookie)) {
                                    String str2 = f1936a;
                                    Log.e(str2, "httpcookie:" + httpCookie.toString());
                                    String strA = a(httpCookie.getDomain(), httpCookie.getName(), httpCookie.getValue(), System.currentTimeMillis() + (httpCookie.getMaxAge() * 1000), httpCookie.getSecure());
                                    Log.e(str2, "httpcookie build:" + strA);
                                    cookieManager.setCookie(e + httpCookie.getDomain(), strA);
                                }
                            }
                        }
                    }
                    cookieManager.flush();
                }
            }
        } catch (Exception e2) {
            PassHttpUtils.a(f1936a, "asyncNaCookie2Webview:" + e2.toString());
        }
    }

    private static boolean a(String str, HttpCookie httpCookie) {
        try {
            URL url = new URL(str);
            return !httpCookie.getDiscard() && !httpCookie.hasExpired() && a(url.getHost(), httpCookie.getDomain()) && b(url.getPath(), httpCookie.getPath()) && a(str, httpCookie.getSecure());
        } catch (Exception unused) {
        }
    }

    private static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !z || str.startsWith(e);
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return (str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !PassHttpUtils.b(str)) || str.endsWith(str2) || str2.startsWith(".") || !PassHttpUtils.b(str);
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (str.startsWith(str2)) {
            return str2.endsWith("/") || str.charAt(str2.length()) == '/';
        }
        return false;
    }
}
