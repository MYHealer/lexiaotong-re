package com.hihonor.adsdk.common.f;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j {
    private static final String hnadsa = "DensityUtil";
    public static final float hnadsb = 0.5f;

    private j() {
    }

    public static int hnadsa(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int hnadsb(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int hnadsc(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int hnadsd(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? 1 : 0;
    }

    public static int hnadse(Context context) {
        if (context == null) {
            return 0;
        }
        return hnadsb(context).widthPixels;
    }

    public static int hnadsa(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private static DisplayMetrics hnadsb(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getMetricsFull error  " + e.getMessage(), new Object[0]);
        }
        return displayMetrics;
    }

    public static int hnadsc(Context context) {
        if (context == null) {
            return 0;
        }
        return hnadsb(context).heightPixels;
    }

    public static boolean hnadsa(float f, float f2) {
        return Math.abs((f - f2) * 100.0f) < 5.0f;
    }

    public static int hnadsa(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }
}
