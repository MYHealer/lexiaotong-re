package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.alipay.sdk.app.EnvUtils;
import com.byazt.hv.TTDownloadField;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f1666a = "com.eg.android.AlipayGphone";
    static final int b = 125;
    private static final String c = "com.alipay.android.app";
    private static final String d = "com.eg.android.AlipayGphoneRC";
    private static final int e = 99;
    private static final String[] f = {"10.1.5.1013151", "10.1.5.1013148"};

    public static String g(Context context) {
        return "-1;-1";
    }

    static String a() {
        if (EnvUtils.isSandBox()) {
            return d;
        }
        try {
            return com.alipay.sdk.app.i.f1624a.get(0).f1634a;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    static String a(String str) {
        return (EnvUtils.isSandBox() && TextUtils.equals(str, d)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static Map<String, String> b(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf("=", 1);
            if (-1 != iIndexOf) {
                map.put(str2.substring(0, iIndexOf), URLDecoder.decode(str2.substring(iIndexOf + 1)));
            }
        }
        return map;
    }

    public static Map<String, String> c(String str) {
        HashMap map = new HashMap(4);
        int iIndexOf = str.indexOf(63);
        if (iIndexOf != -1 && iIndexOf < str.length() - 1) {
            for (String str2 : str.substring(iIndexOf + 1).split("&")) {
                int iIndexOf2 = str2.indexOf(61, 1);
                if (iIndexOf2 != -1 && iIndexOf2 < str2.length() - 1) {
                    map.put(str2.substring(0, iIndexOf2), e(str2.substring(iIndexOf2 + 1)));
                }
            }
        }
        return map;
    }

    public static JSONObject d(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, e2);
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            int iIndexOf = str3.indexOf(str) + str.length();
            if (iIndexOf <= str.length()) {
                return "";
            }
            int iIndexOf2 = !TextUtils.isEmpty(str2) ? str3.indexOf(str2, iIndexOf) : 0;
            if (iIndexOf2 < 1) {
                return str3.substring(iIndexOf);
            }
            return str3.substring(iIndexOf, iIndexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.d, com.alipay.sdk.app.statistic.c.o, e2);
            return null;
        }
    }

    public static a a(Context context, List<com.alipay.sdk.data.a.C0082a> list) {
        a aVarA;
        if (list == null) {
            return null;
        }
        for (com.alipay.sdk.data.a.C0082a c0082a : list) {
            if (c0082a != null && (aVarA = a(context, c0082a.f1634a, c0082a.b, c0082a.c)) != null && !aVarA.a() && !aVarA.b()) {
                return aVarA;
            }
        }
        return null;
    }

    private static a a(Context context, String str, int i, String str2) {
        PackageInfo packageInfoB;
        if (EnvUtils.isSandBox() && "com.eg.android.AlipayGphone".equals(str)) {
            str = d;
        }
        try {
            packageInfoB = b(context, str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.d, com.alipay.sdk.app.statistic.c.l, th);
            packageInfoB = null;
        }
        if (b(packageInfoB)) {
            return a(packageInfoB, i, str2);
        }
        return null;
    }

    private static boolean b(PackageInfo packageInfo) {
        String str;
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else if (packageInfo.signatures == null) {
            str = "info.signatures == null";
        } else if (packageInfo.signatures.length <= 0) {
            str = "info.signatures.length <= 0";
        } else {
            str = "";
            z = true;
        }
        if (!z) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.d, com.alipay.sdk.app.statistic.c.m, str);
        }
        return z;
    }

    private static PackageInfo b(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    private static a a(PackageInfo packageInfo, int i, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new a(packageInfo, i, str);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PackageInfo f1667a;
        public final int b;
        public final String c;

        public a(PackageInfo packageInfo, int i, String str) {
            this.f1667a = packageInfo;
            this.b = i;
            this.c = str;
        }

        public boolean a() {
            Signature[] signatureArr = this.f1667a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String strB = n.b(signature.toByteArray());
                if (strB != null && !TextUtils.equals(strB, this.c)) {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.w, String.format("Got %s, expected %s", strB, this.c));
                    return true;
                }
            }
            return false;
        }

        public boolean b() {
            return this.f1667a.versionCode < this.b;
        }
    }

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(c, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(Context context, List<com.alipay.sdk.data.a.C0082a> list) {
        try {
            for (com.alipay.sdk.data.a.C0082a c0082a : list) {
                if (c0082a != null) {
                    String str = c0082a.f1634a;
                    if (EnvUtils.isSandBox() && "com.eg.android.AlipayGphone".equals(str)) {
                        str = d;
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.K, th);
            return false;
        }
    }

    static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = f;
            return TextUtils.equals(str, strArr[0]) || TextUtils.equals(str, strArr[1]);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a(), 128);
            return packageInfo != null && packageInfo.versionCode < 99;
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static String c(Context context) {
        return " (" + b() + ";" + c() + ";" + d(context) + ";;" + e(context) + ")(sdk android)";
    }

    public static String b() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String c() {
        String strD = d();
        int iIndexOf = strD.indexOf(x.A);
        if (iIndexOf != -1) {
            strD = strD.substring(0, iIndexOf);
        }
        int iIndexOf2 = strD.indexOf(IOUtils.LINE_SEPARATOR_UNIX);
        if (iIndexOf2 != -1) {
            strD = strD.substring(0, iIndexOf2);
        }
        return "Linux " + strD;
    }

    private static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(line);
                return (matcher.matches() && matcher.groupCount() >= 4) ? matcher.group(1) + IOUtils.LINE_SEPARATOR_UNIX + matcher.group(2) + PPSLabelView.Code + matcher.group(3) + IOUtils.LINE_SEPARATOR_UNIX + matcher.group(4) : "Unavailable";
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String d(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String e(Context context) {
        DisplayMetrics displayMetricsI = i(context);
        return displayMetricsI.widthPixels + "*" + displayMetricsI.heightPixels;
    }

    private static DisplayMetrics i(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String f(Context context) {
        String strA = m.a(context);
        return strA.substring(0, strA.indexOf("://"));
    }

    public static String a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = random.nextInt(3);
            if (iNextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (iNextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (iNextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static boolean f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    static String a(Context context, String str) {
        String strSubstring = "";
        try {
            String str2 = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    str2 = str2 + "#M";
                } else if (runningAppProcessInfo.processName.startsWith(str + x.bQ)) {
                    str2 = str2 + "#" + runningAppProcessInfo.processName.replace(str + x.bQ, "");
                }
            }
            strSubstring = str2;
        } catch (Throwable unused) {
        }
        if (strSubstring.length() > 0) {
            strSubstring = strSubstring.substring(1);
        }
        return strSubstring.length() == 0 ? "N" : strSubstring;
    }

    public static boolean a(WebView webView, String str, Activity activity) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith(com.alipay.sdk.cons.a.j.toLowerCase()) || str.toLowerCase().startsWith(com.alipay.sdk.cons.a.k.toLowerCase())) {
            try {
                a aVarA = a(activity, com.alipay.sdk.app.i.f1624a);
                if (aVarA != null && !aVarA.b() && !aVarA.a()) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.cons.a.j);
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        if (TextUtils.equals(str, com.alipay.sdk.cons.a.m) || TextUtils.equals(str, com.alipay.sdk.cons.a.n)) {
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
            activity.finish();
            return true;
        }
        if (!str.startsWith(com.alipay.sdk.cons.a.l)) {
            return false;
        }
        try {
            String strSubstring2 = str.substring(str.indexOf(com.alipay.sdk.cons.a.l) + 24);
            int i = Integer.parseInt(strSubstring2.substring(strSubstring2.lastIndexOf(com.alipay.sdk.cons.a.o) + 10));
            if (i == com.alipay.sdk.app.k.SUCCEEDED.a() || i == com.alipay.sdk.app.k.PAY_WAITTING.a()) {
                if (com.alipay.sdk.cons.a.s) {
                    StringBuilder sb = new StringBuilder();
                    String strDecode = URLDecoder.decode(str);
                    String strDecode2 = URLDecoder.decode(strDecode);
                    String str2 = strDecode2.substring(strDecode2.indexOf(com.alipay.sdk.cons.a.l) + 24, strDecode2.lastIndexOf(com.alipay.sdk.cons.a.o)).split(com.alipay.sdk.cons.a.q)[0];
                    int iIndexOf = strDecode.indexOf(com.alipay.sdk.cons.a.q) + 12;
                    sb.append(str2).append(com.alipay.sdk.cons.a.q).append(strDecode.substring(iIndexOf, strDecode.indexOf("&", iIndexOf))).append(strDecode.substring(strDecode.indexOf("&", iIndexOf)));
                    strSubstring = sb.toString();
                } else {
                    String strDecode3 = URLDecoder.decode(str);
                    strSubstring = strDecode3.substring(strDecode3.indexOf(com.alipay.sdk.cons.a.l) + 24, strDecode3.lastIndexOf(com.alipay.sdk.cons.a.o));
                }
                com.alipay.sdk.app.k kVarB = com.alipay.sdk.app.k.b(i);
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(kVarB.a(), kVarB.b(), strSubstring));
            } else {
                com.alipay.sdk.app.k kVarB2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.FAILED.a());
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(kVarB2.a(), kVarB2.b(), ""));
            }
        } catch (Exception unused2) {
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.e());
        }
        activity.runOnUiThread(new o(activity));
        return true;
    }

    public static String h(Context context) throws PackageManager.NameNotFoundException {
        return c(context, context.getPackageName());
    }

    private static String c(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.l, th);
            return "";
        }
    }
}
