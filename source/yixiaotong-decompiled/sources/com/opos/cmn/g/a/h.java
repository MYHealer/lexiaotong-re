package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6160a = "d";
    private static final byte[] b = new byte[0];
    private static final byte[] c = new byte[0];
    private static volatile long d = 0;
    private static volatile String e = "";
    private static volatile String f = "";
    private static volatile boolean g;
    private static volatile boolean h;

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6161a;

        a(Context context) {
            this.f6161a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (h.b) {
                    String strA = g.a(this.f6161a);
                    String strB = g.b(this.f6161a);
                    if (!TextUtils.isEmpty(strA)) {
                        String unused = h.e = strA;
                        i.a(this.f6161a, h.e);
                    }
                    if (!TextUtils.isEmpty(strB)) {
                        String unused2 = h.f = strB;
                        i.b(this.f6161a, h.f);
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(h.f6160a, "", e);
            }
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6162a;

        b(Context context) {
            this.f6162a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (h.c) {
                    try {
                        boolean unused = h.g = g.d(this.f6162a);
                        i.a(this.f6162a, h.g);
                        long unused2 = h.d = System.currentTimeMillis();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(h.f6160a, "", e);
            }
        }
    }

    public static synchronized void a(Context context) {
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            h = true;
            new Thread(new a(origApplicationContext)).start();
        }
    }

    public static void b(Context context) {
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (System.currentTimeMillis() >= d + 5000) {
                new Thread(new b(origApplicationContext)).start();
            }
        }
    }

    public static String c(Context context) {
        if (context != null && TextUtils.isEmpty(e)) {
            e = i.a(context);
        }
        if (!h) {
            a(context);
        }
        return e;
    }

    public static String d(Context context) {
        if (context != null && TextUtils.isEmpty(f)) {
            f = i.b(context);
        }
        if (!h) {
            a(context);
        }
        return f;
    }

    public static String e(Context context) {
        return "";
    }

    public static boolean f(Context context) {
        if (context != null) {
            g = i.d(context);
        }
        return g;
    }
}
