package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4622a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";
    private final String b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";
    private final String c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";
    private final String d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";
    private final String e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(JSONObject jSONObject, int i) {
        Object objA;
        try {
            String str = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2));
            new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2));
            Object objA2 = df.a(str, "IActivityManagerSingleton");
            if (objA2 == null || (objA = df.a("android.util.Singleton", objA2, "get", new Object[0])) == null) {
                return;
            }
            a(objA, jSONObject, i);
        } catch (Exception unused) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            try {
                boolean zIsProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                if (zIsProxyClass) {
                    jSONObject.put(new StringBuilder().append(i).toString(), zIsProxyClass ? 1 : 0);
                    jSONObject.put(i + "-c", name);
                } else if (i == 3 && !name.contains("Instrumentation")) {
                    jSONObject.put(new StringBuilder().append(i).toString(), zIsProxyClass ? 1 : 0);
                    jSONObject.put(i + "-c", name);
                }
                return zIsProxyClass;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void b(JSONObject jSONObject, int i) {
        try {
            Object objA = df.a(new String(c.a(f4622a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (objA != null) {
                a(objA, jSONObject, i);
            }
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, int i) {
        Object objA;
        Object objA2;
        try {
            if (Build.VERSION.SDK_INT < 29 || (objA = df.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (objA2 = df.a("android.util.Singleton", objA, "get", new Object[0])) == null) {
                return;
            }
            a(objA2, jSONObject, i);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i) {
        Object objA;
        try {
            Object objA2 = df.a(new String(c.a(f4622a.getBytes(), 2)), (Object) null, Val.CAT, new Object[0]);
            if (objA2 == null || (objA = df.a(objA2.getClass(), objA2, Val.IN)) == null) {
                return;
            }
            a(objA, jSONObject, i);
        } catch (Exception unused) {
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object objA = df.a(packageManager.getClass(), packageManager, "mPM");
            if (objA == null || !a(objA, jSONObject, 0)) {
                return null;
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
