package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import com.byazt.bog.a;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 80, 81, 82, 1297})
public class TTAppContextHolder {
    private static volatile Context c;

    public static Context getContext() {
        if (c == null) {
            setContext(null);
        }
        return c;
    }

    public static synchronized void setContext(Context context) {
        if (c == null) {
            if (context != null) {
                c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } else if (c.c() != null) {
                try {
                    Application applicationC = c.c();
                    c = applicationC;
                    if (applicationC != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 80, 81, 82, 1446})
    private static class c {
        private static volatile Application c;

        public static Application c() {
            return c;
        }

        static {
            try {
                Object objTt = tt();
                c = (Application) objTt.getClass().getMethod("getApplication", new Class[0]).invoke(objTt, new Object[0]);
                a.uj("MyApplication", "application get success");
            } catch (Throwable th) {
                a.n("MyApplication", "application get failed", th);
            }
        }

        private static Object tt() {
            try {
                Method method = Class.forName(Val.AT).getMethod(Val.CAT, new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                a.n("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
