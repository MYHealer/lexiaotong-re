package com.jg.ids;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class j implements com.jg.ids.m.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4610a;
    private Class<?> b;
    private Object c;

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            str3 = null;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.coloros.mcs", 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public j(Context context) {
        this.f4610a = context;
        try {
            this.b = Class.forName("android.app.ZteDeviceIdentifyManager");
            Constructor<?> declaredConstructor = this.b.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            this.c = declaredConstructor.newInstance(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.jg.ids.m.a
    public boolean a() {
        return this.c != null;
    }

    @Override // com.jg.ids.m.a
    public String b() {
        if (this.f4610a == null || this.b == null || this.c == null) {
            return "";
        }
        try {
            String str = (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f4610a);
            if (str == null || str.length() == 0) {
                return "";
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
