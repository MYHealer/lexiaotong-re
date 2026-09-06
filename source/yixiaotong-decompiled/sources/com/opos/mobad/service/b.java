package com.opos.mobad.service;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f7329a = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f7329a.compareAndSet(true, false)) {
                com.opos.cmn.an.f.a.a("LocationTool", "unregister");
                com.opos.mobad.d.b.b.a().b();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("LocationTool", "", e);
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                if (f7329a.compareAndSet(false, true)) {
                    com.opos.cmn.an.f.a.a("LocationTool", "register");
                    com.opos.mobad.d.b.b.a().a(context);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("LocationTool", "", e);
            }
        }
    }

    public static boolean b() {
        return f7329a.get();
    }

    public static double[] c() {
        try {
            return com.opos.mobad.d.b.b.a().c();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("LocationTool", "", e);
            return new double[]{0.0d, 0.0d};
        }
    }
}
