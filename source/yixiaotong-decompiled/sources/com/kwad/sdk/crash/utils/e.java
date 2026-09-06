package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    private static Context aWI;

    public static void init(Context context) {
        aWI = context;
    }

    public static long Nk() {
        long jBZ = bZ(aWI);
        b(aWI, 1 + jBZ);
        return jBZ;
    }

    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        editorEdit.putLong("crashseq", j);
        return editorEdit.commit();
    }

    private static long bZ(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }
}
