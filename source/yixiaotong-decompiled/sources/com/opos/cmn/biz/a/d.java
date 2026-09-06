package com.opos.cmn.biz.a;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f5963a = "";

    public static String a(Context context) {
        if (!com.opos.cmn.an.d.a.a(f5963a)) {
            return f5963a;
        }
        if (context != null) {
            f5963a = f.b(context);
        }
        if (com.opos.cmn.an.d.a.a(f5963a)) {
            f5963a = com.opos.cmn.an.c.d.d();
            if (com.opos.cmn.an.d.a.a(f5963a)) {
                f5963a = "CN";
            }
        }
        return f5963a;
    }

    public static synchronized void a(Context context, String str) {
        if (com.opos.cmn.an.d.a.a(str)) {
            com.opos.cmn.an.f.a.c("RegionTool", "init, setRegion= null");
            return;
        }
        try {
            String upperCase = str.toUpperCase();
            if (!com.opos.cmn.an.d.a.a(upperCase) && !upperCase.contentEquals(f5963a)) {
                f5963a = upperCase;
                if (context != null) {
                    final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.b(origApplicationContext, d.f5963a);
                        }
                    }).start();
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RegionTool", "setRegion", e);
        }
        com.opos.cmn.an.f.a.a("RegionTool", "init, setRegion=" + str);
    }
}
