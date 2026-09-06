package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.yfanads.android.libs.net.UrlConst;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile cs f1791a;
    private boolean b;

    public void a(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }

    private cs() {
    }

    public static cs a() {
        if (f1791a == null) {
            synchronized (cs.class) {
                if (f1791a == null) {
                    f1791a = new cs();
                }
            }
        }
        return f1791a;
    }

    public Boolean a(String str) {
        return a(str, UrlConst.HTTP);
    }

    public Boolean b(String str) {
        return a(str, UrlConst.HTTPS);
    }

    public String c(String str) {
        return a(str).booleanValue() ? str.replaceFirst("(?i)http", "https") : str;
    }

    public Boolean d(String str) {
        return Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    private Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public HttpURLConnection a(URL url) throws IOException {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public boolean f(String str) {
        return TextUtils.isEmpty(str) || !str.contains("/thefatherofsalmon.com");
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        return (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public String h(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        if (strArrSplit == null || strArrSplit.length < 2) {
            return null;
        }
        return strArrSplit[1];
    }

    public void i(String str) {
        new an(str).b();
    }

    public String a(String str, HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        if (map == null || map.isEmpty()) {
            return sb.toString();
        }
        sb.append("?");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            } catch (Exception e) {
                bv.a().c(e);
            }
        }
        String string = sb.toString();
        return string.substring(0, string.length() - 1);
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }
}
