package com.hihonor.hianalytics.util;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.hihonor.hianalytics.hnha.j2;
import com.yfanads.android.libs.net.UrlConst;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f3718a = {"4e48ff7f9b45b65bffd4e273652c864f458cc756f28895c17658144b7324f68e"};

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            j2.c("UriUtil", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str) && !str.toLowerCase(Locale.US).startsWith(UrlConst.HTTP)) {
                return new URI(str).getHost();
            }
            j2.b("UriUtil", "url don't starts with https");
            return null;
        } catch (URISyntaxException e) {
            j2.b("UriUtil", "getHostByURI error : " + SystemUtils.getDesensitizedException(e));
            return null;
        }
    }

    private static String a(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            j2.c("UriUtil", "url is null");
            return str;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < i) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArrSplit[strArrSplit.length - i]);
        for (int i2 = 1; i2 < i; i2++) {
            stringBuffer = stringBuffer.append(".").append(strArrSplit[(strArrSplit.length - i) + i2]);
        }
        return stringBuffer.toString();
    }

    public static boolean a(String str, String str2, int i) {
        String string;
        StringBuilder sb;
        String strA = a(str);
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(str2)) {
            string = "url or whitelistHash is null";
        } else {
            String strA2 = a(strA, i);
            if (!TextUtils.isEmpty(strA2)) {
                if (str2.equals(i.a(strA))) {
                    return true;
                }
                if (!str2.equals(i.a(strA2))) {
                    return false;
                }
                try {
                    String strSubstring = strA.substring(0, strA.length() - strA2.length());
                    if (strSubstring.endsWith(".")) {
                        return strSubstring.matches("^[A-Za-z0-9.-]+$");
                    }
                    return false;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    sb = new StringBuilder("IndexOutOfBoundsException");
                    string = sb.append(SystemUtils.getDesensitizedException(e)).toString();
                    j2.b("UriUtil", string);
                    return false;
                } catch (Exception e2) {
                    e = e2;
                    sb = new StringBuilder("Exception : ");
                    string = sb.append(SystemUtils.getDesensitizedException(e)).toString();
                    j2.b("UriUtil", string);
                    return false;
                }
            }
            string = "get urlLastNStr is null";
        }
        j2.b("UriUtil", string);
        return false;
    }

    public static boolean b(String str) {
        for (String str2 : f3718a) {
            if (a(str, str2, 2)) {
                return true;
            }
        }
        return false;
    }
}
