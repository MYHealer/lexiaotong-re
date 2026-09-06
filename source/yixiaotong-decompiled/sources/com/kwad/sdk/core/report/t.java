package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class t {
    private static String aWG = Nm();
    private static long aWH = 0;
    private static Context aWI;

    public static String Nj() {
        return aWG;
    }

    public static long Nl() {
        return aWH;
    }

    public static void init(Context context) {
        aWI = context;
    }

    public static String Ni() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateSessionId");
        String strNm = Nm();
        aWG = strNm;
        return strNm;
    }

    public static long Nk() {
        long jBZ = bZ(aWI);
        b(aWI, 1 + jBZ);
        return jBZ;
    }

    private static String Nm() {
        return UUID.randomUUID().toString();
    }

    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        editorEdit.putLong("seq", j);
        return editorEdit.commit();
    }

    private static long bZ(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }
}
