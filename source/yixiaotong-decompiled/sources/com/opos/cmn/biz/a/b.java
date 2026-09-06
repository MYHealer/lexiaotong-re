package com.opos.cmn.biz.a;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f5960a = "";

    public static String a(Context context) {
        if (a(f5960a)) {
            return f5960a;
        }
        if (context != null) {
            f5960a = f.a(context);
        }
        if (!a(f5960a)) {
            f5960a = com.opos.cmn.an.c.c.d();
            if (!a(f5960a)) {
                f5960a = a.c;
            }
        }
        return f5960a;
    }

    public static synchronized void a(Context context, String str) {
        if (com.opos.cmn.an.d.a.a(str)) {
            com.opos.cmn.an.f.a.c("BrandTool", "init, set Brand = null");
            return;
        }
        try {
            String upperCase = str.toUpperCase();
            if (a(upperCase) && !upperCase.contentEquals(f5960a)) {
                f5960a = upperCase;
                if (context != null) {
                    final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.a(origApplicationContext, b.f5960a);
                        }
                    }).start();
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("BrandTool", "setBrand", e);
        }
        com.opos.cmn.an.f.a.a("BrandTool", "init, set Brand = " + str);
    }

    private static boolean a(String str) {
        Boolean bool = true;
        if (com.opos.cmn.an.d.a.a(str) || (!a.c.equalsIgnoreCase(str) && !a.f5959a.equalsIgnoreCase(str) && !a.b.equalsIgnoreCase(str))) {
            bool = false;
        }
        return bool.booleanValue();
    }
}
