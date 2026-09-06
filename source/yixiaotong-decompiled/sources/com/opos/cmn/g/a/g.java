package com.opos.cmn.g.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f6159a;
    private static volatile com.opos.cmn.g.a.a b;

    static /* synthetic */ class a {
    }

    private static class b extends com.opos.cmn.g.a.a {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.opos.cmn.g.a.a
        public String a(Context context) {
            return com.oplus.stdid.sdk.a.d(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean a() {
            return com.oplus.stdid.sdk.a.a();
        }

        @Override // com.opos.cmn.g.a.a
        public String b(Context context) {
            return com.oplus.stdid.sdk.a.e(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean c(Context context) {
            return com.oplus.stdid.sdk.a.c(context);
        }

        @Override // com.opos.cmn.g.a.a
        public void d(Context context) {
            com.oplus.stdid.sdk.a.b(context);
        }
    }

    private static synchronized com.opos.cmn.g.a.a a() {
        if (b == null) {
            b = new b(null);
        }
        return b;
    }

    public static String a(Context context) {
        Exception e;
        String strA;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            e(context);
            strA = a().a() ? a().a(context) : "";
            try {
                com.opos.cmn.an.f.a.a("IdentifierManager", "getOUID costTime=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result=" + strA);
            } catch (Exception e2) {
                e = e2;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
            }
        } catch (Exception e3) {
            e = e3;
            strA = "";
        }
        return strA;
    }

    public static String b(Context context) {
        Exception e;
        String strB;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            e(context);
            strB = a().a() ? a().b(context) : "";
            try {
                com.opos.cmn.an.f.a.a("IdentifierManager", "getDUID costTime=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result=" + strB);
            } catch (Exception e2) {
                e = e2;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
            }
        } catch (Exception e3) {
            e = e3;
            strB = "";
        }
        return strB;
    }

    public static boolean c(Context context) {
        boolean zA;
        try {
            e(context);
            zA = a().a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
            zA = false;
        }
        com.opos.cmn.an.f.a.a("IdentifierManager", "isSupportedOpenId " + zA);
        return zA;
    }

    public static boolean d(Context context) {
        boolean zC;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            e(context);
            zC = a().c(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
            zC = false;
        }
        com.opos.cmn.an.f.a.a("IdentifierManager", "getOUIDStatus costTime=" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result=" + zC);
        return zC;
    }

    private static void e(Context context) {
        if (f6159a) {
            return;
        }
        a().d(context);
        f6159a = true;
    }
}
