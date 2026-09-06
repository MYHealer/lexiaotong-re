package org.repackage.com.heytap.openid.sdk;

import android.content.Context;
import com.stub.StubApp;
import org.repackage.a.a.a.a.a;
import org.repackage.a.a.a.a.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class OpenIDSDK {
    public static void a(Context context) {
        a.b = c.a.f9721a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        a.f9718a = true;
    }

    public static boolean a() {
        if (a.f9718a) {
            return a.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (a.f9718a) {
            return c.a.f9721a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.f9718a) {
            return c.a.f9721a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.f9718a) {
            return c.a.f9721a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (a.f9718a) {
            return c.a.f9721a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
