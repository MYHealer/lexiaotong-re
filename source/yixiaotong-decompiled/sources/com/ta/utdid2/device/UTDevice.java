package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class UTDevice {
    @Deprecated
    public static String getUtdid(Context context) {
        return d(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return e(context);
    }

    private static String d(Context context) {
        a aVarB = b.b(context);
        return (aVarB == null || g.m1003a(aVarB.f())) ? "ffffffffffffffffffffffff" : aVarB.f();
    }

    private static String e(Context context) {
        String strH = c.a(context).h();
        return (strH == null || g.m1003a(strH)) ? "ffffffffffffffffffffffff" : strH;
    }
}
