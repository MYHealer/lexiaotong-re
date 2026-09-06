package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class OpenIdHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9723a = "OpenIdHelper";
    private static Method b;

    public static String a(Context context) {
        b bVarA = b.a();
        return bVarA.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), bVarA.f9726a);
    }

    public static void a(boolean z) {
        b.a();
        b.a(z);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (b == null) {
                Method method = Class.forName(Val.AT).getMethod("currentApplication", new Class[0]);
                b = method;
                method.setAccessible(true);
            }
            context = (Context) b.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e(f9723a, "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }

    public static String b(Context context) {
        b bVarA = b.a();
        return bVarA.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), bVarA.b);
    }

    public static String c(Context context) {
        b bVarA = b.a();
        return bVarA.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), bVarA.d);
    }

    public static String d(Context context) {
        b bVarA = b.a();
        return bVarA.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), bVarA.c);
    }
}
