package com.meishu.sdk.core.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: DimensionUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m {
    public static float a(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static float b(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static int a(Context context) {
        try {
            DisplayMetrics displayMetricsL = x0.l(context);
            return (int) Math.min(((double) displayMetricsL.widthPixels) / 0.46d, displayMetricsL.heightPixels);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
