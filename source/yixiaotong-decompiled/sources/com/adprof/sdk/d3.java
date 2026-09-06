package com.adprof.sdk;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class d3 {
    public static b3 a(Context context) throws IOException {
        b3 b3VarA;
        try {
            if (TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "pps_oaid_c")) || (b3VarA = tp.a(context)) == null) {
                return null;
            }
            return b3VarA;
        } catch (Throwable th) {
            Log.w("AdIdClient", "get Id err: " + th.getClass().getSimpleName());
            return null;
        }
    }
}
