package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class PayResultActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1611a = "{\"isLogin\":\"false\"}";
    public static final HashMap<String, Object> b;
    public static final String c = "hk.alipay.wallet";
    public static final String d = "phonecashier.pay.hash";
    public static final String e = "orderSuffix";
    public static final String f = "externalPkgName";
    public static final String g = "phonecashier.pay.result";
    public static final String h = "phonecashier.pay.resultOrderHash";
    private static String i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile String f1612a;
        public static volatile String b;
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(12890);
        b = new HashMap<>();
    }

    private static void a(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(c);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            com.alipay.sdk.util.c.b("msp", "PayTask:payReuslt: UnsupportedEncodingException:" + e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    private static void a(String str) {
        a.b = j.c();
        a(b, str);
    }

    private static void a(String str, String str2) {
        a.b = str;
        a(b, str2);
    }

    private static void a(Activity activity, int i2) {
        new Handler().postDelayed(new f(activity), i2);
    }

    private static boolean a(HashMap<String, Object> map, String str) {
        Object obj;
        if (map == null || str == null || (obj = map.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }
}
