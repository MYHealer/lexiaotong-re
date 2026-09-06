package com.ubix.ssp.ad.e.a0.y;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ubix.ssp.ad.e.a0.h;
import com.ubix.ssp.ad.e.a0.n;
import com.ubix.ssp.ad.e.a0.y.d.d;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8735a = "ZEdsMGJHVT0=";
    private String b = "WVdSa1JteGhaM009";
    private String c = "YzNSaGNuUkJZM1JwZG1sMGFXVno=";
    private String d = "WTNKbFlYUmxRMmh2YjNObGNnPT0=";
    private String e = "YzNSaGNuUkJZM1JwZG1sMGVRPT0=";
    private String f = "b09207f5c299c42708e1badb72c04025";
    private String g = "ff5e66b76340c5636aa40e7c6a46628f";
    private String h = "9b6bf0057c19bd94df69372d48ec7149";
    private String i = "c892ba238c98835d4d53a3faed43ee52";
    private String j = "b2f39f17253fa5e90a05d637249c53e1";
    private String k = "c1aafc7e23f24ba11aae492f5caa2d97";

    private int a() {
        try {
            String str = (String) Class.forName(a("WVc1a2NtOXBaQzV2Y3k1Q2RXbHNaQT09")).getField(a("UWxKQlRrUT0=")).get(null);
            if (TextUtils.isEmpty(str) || this.f.equals(h.a(str.toLowerCase())) || this.i.equals(h.a(str.toLowerCase())) || this.k.equals(h.a(str.toLowerCase())) || this.j.equals(h.a(str.toLowerCase()))) {
                return 0;
            }
            return (this.g.equals(h.a(str.toLowerCase())) || this.h.equals(h.a(str.toLowerCase()))) ? 1 : 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private String a(String str) {
        return new String(n.a().a(n.a().a(str)));
    }

    private boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            int iB = b();
            if (iB != 0) {
                if (iB != 1) {
                    return false;
                }
                try {
                    Method method = Intent.class.getMethod(a(this.b), Integer.TYPE);
                    method.invoke(intent, 268468224);
                    if (context instanceof Application) {
                        method.invoke(intent, 268435456);
                    }
                    Method method2 = Context.class.getMethod(a(this.c), Intent[].class);
                    Object objNewInstance = Array.newInstance((Class<?>) Intent.class, 1);
                    Array.set(objNewInstance, 0, intent);
                    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    d.e().a(true);
                    d.e().a(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName());
                    method2.invoke(context, objNewInstance);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            try {
                Intent intent2 = (Intent) Intent.class.getMethod(a(this.d), Intent.class, CharSequence.class).invoke(null, intent, a(this.f8735a));
                Method method3 = Intent.class.getMethod(a(this.b), Integer.TYPE);
                method3.invoke(intent2, 268468224);
                if (context instanceof Application) {
                    method3.invoke(intent2, 268435456);
                }
                Method method4 = Context.class.getMethod(a(this.e), Intent.class);
                StackTraceElement[] stackTrace2 = new Throwable().getStackTrace();
                d.e().a(true);
                d.e().a(stackTrace2[0].getClassName() + "." + stackTrace2[0].getMethodName());
                method4.invoke(context, intent2);
                return true;
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    private int b() {
        return a();
    }

    public boolean a(Context context, String str, boolean z) {
        if (!z) {
            return false;
        }
        try {
            return a(context, new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable unused) {
            return false;
        }
    }
}
