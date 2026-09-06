package com.opos.cmn.g.a;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {
    public static String a(Context context) {
        String strC;
        if (context != null) {
            try {
                strC = h.c(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strC = "";
            }
        } else {
            strC = "";
        }
        return strC != null ? strC : "";
    }

    public static String b(Context context) {
        String strD;
        if (context != null) {
            try {
                strD = h.d(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strD = "";
            }
        } else {
            strD = "";
        }
        return strD != null ? strD : "";
    }

    public static String c(Context context) {
        String strE;
        if (context != null) {
            try {
                strE = h.e(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strE = "";
            }
        } else {
            strE = "";
        }
        return strE != null ? strE : "";
    }

    public static void d(Context context) {
        try {
            h.a(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdTool", "", e);
        }
    }

    public static boolean e(Context context) {
        if (context != null) {
            try {
                return g.c(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
            }
        }
        return false;
    }

    public static String f(Context context) {
        String strA;
        if (context != null) {
            try {
                strA = e.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strA = "";
            }
        } else {
            strA = "";
        }
        return strA != null ? strA : "";
    }

    public static boolean g(Context context) {
        boolean zF = false;
        if (context == null) {
            return false;
        }
        try {
            zF = h.f(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            h.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            return zF;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdTool", "", e);
            return zF;
        }
    }
}
