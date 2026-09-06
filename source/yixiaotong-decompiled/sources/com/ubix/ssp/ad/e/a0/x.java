package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f8733a;

    public static boolean a() {
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, com.ubix.ssp.ad.e.y.a.a.b.m mVar) {
        if (mVar == null) {
            return false;
        }
        return a(context, mVar.c, mVar.b, mVar.d, mVar.e);
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !c()) {
            u.b("lanchWXMiniProgram", "暂时不支持小程序 ");
            return false;
        }
        u.b("lanchWXMiniProgram", "isCanSend: false");
        u.b("mp_appid", str);
        u.b("mp_userName", str2);
        u.b("mp_path", str3);
        u.b("mp_ext", str4);
        try {
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            Method method = cls.getMethod("createWXAPI", Context.class, String.class, Boolean.TYPE);
            Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objNewInstance = cls2.newInstance();
            cls2.getField("userName").set(objNewInstance, str2);
            if (str3 != null) {
                cls2.getField("path").set(objNewInstance, str3);
            }
            if (str4 != null) {
                cls2.getField("extData").set(objNewInstance, str4);
            }
            f8733a = method.invoke(cls, context, str, Boolean.TRUE);
            boolean zBooleanValue = false;
            for (int i = 0; i < f8733a.getClass().getMethods().length; i++) {
                try {
                    Method method2 = f8733a.getClass().getMethods()[i];
                    if (method2.getName().contains("sendReq")) {
                        zBooleanValue = ((Boolean) method2.invoke(f8733a, objNewInstance)).booleanValue();
                        u.b("lanchWXMiniProgram", "sendReq: " + zBooleanValue);
                    }
                } catch (Exception e) {
                    z = zBooleanValue;
                    e = e;
                    e.printStackTrace();
                    return z;
                }
            }
            return zBooleanValue;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static int b() {
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            return p.b("com.tencent.mm") ? 1 : 2;
        } catch (Exception unused) {
            return 2;
        }
    }

    public static boolean c() {
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            return c.g("com.tencent.mm");
        } catch (Exception unused) {
            return false;
        }
    }
}
