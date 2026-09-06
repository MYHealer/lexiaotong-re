package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f6154a = new byte[0];
    private static volatile boolean b;
    private static volatile f.b c;

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6155a;

        a(Context context) {
            this.f6155a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (e.f6154a) {
                    try {
                        f.b bVarA = f.a(this.f6155a);
                        if (bVarA != null) {
                            f.b unused = e.c = bVarA;
                            com.opos.cmn.an.f.a.a("GAIDUtils", "updateGAID gaid:" + e.c.a() + " gaidStatus:" + (!e.c.b()));
                        }
                        if (e.c != null) {
                            if (!TextUtils.isEmpty(e.c.a())) {
                                i.c(this.f6155a, e.c.a());
                            }
                            i.b(this.f6155a, !bVarA.b());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0027, code lost:
    
        r1 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String strC;
        try {
            if (c == null || TextUtils.isEmpty(c.a())) {
                strC = context != null ? i.c(context) : "";
            } else {
                strC = c.a();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
        }
        if (!b) {
            b(context);
        }
        return strC != null ? strC : "";
    }

    public static synchronized void b(Context context) {
        if (context != null) {
            try {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                b = true;
                new Thread(new a(origApplicationContext)).start();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
            }
        }
    }
}
