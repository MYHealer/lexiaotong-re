package com.ubixnow.ooooo;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class l {
    private static final String OooO00o = "OAID";
    private static boolean OooO0O0;

    private l() {
    }

    public static void OooO00o() {
        OooO0O0 = true;
    }

    public static void OooO00o(Object obj) {
        if (OooO0O0) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d(OooO00o, obj.toString());
        }
    }
}
