package com.yfanads.android.dp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DpNative {
    static {
        try {
            System.loadLibrary("yf_ads");
            Log.d("yf_native", "load so success");
        } catch (UnsatisfiedLinkError e) {
            Log.e("yf_native", "load so failed: " + e.getMessage());
        }
    }

    public static native boolean ghr(Context context, String str, String str2);

    public static native boolean ghr2(Intent intent, String str);

    public static native boolean gop(Intent intent);

    public static native void scl(Intent intent);

    public static native boolean txm(Context context, Intent intent);

    public static native boolean txm2(Intent intent, String str);
}
