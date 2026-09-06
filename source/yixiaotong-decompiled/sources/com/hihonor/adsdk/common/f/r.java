package com.hihonor.adsdk.common.f;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class r {
    private static final String hnadsa = "PermissionUtil";

    public static boolean hnadsa(Context context, String str) {
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkPermission context is null", new Object[0]);
            return false;
        }
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkPermission fail msg = " + th.getMessage(), new Object[0]);
            return false;
        }
    }
}
