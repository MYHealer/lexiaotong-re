package com.ubix.ssp.ad.e.a0.y.e;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Rect f8745a;

    public static Rect a(Context context) {
        DisplayMetrics displayMetrics;
        try {
            if (f8745a == null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                f8745a = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f8745a;
    }

    public static Rect a(View view) {
        int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static boolean b(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return ((Boolean) powerManager.getClass().getMethod("isScreenOn", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static boolean b(View view) {
        try {
            PowerManager powerManager = (PowerManager) view.getContext().getSystemService("power");
            return ((Boolean) powerManager.getClass().getMethod("isScreenOn", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }
}
