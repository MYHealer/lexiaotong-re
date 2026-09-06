package com.jd.ad.sdk.jad_dq;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_bo {

    public static class jad_an {
        public int jad_an;
        public int jad_bo;

        public final String toString() {
            return this.jad_bo + "*" + this.jad_an;
        }
    }

    public static jad_an jad_an(Context context) {
        int i;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        int i2 = -1;
        if (defaultDisplay != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i3 = displayMetrics.widthPixels;
            int i4 = displayMetrics.heightPixels;
            if (i3 == -1 || i4 == -1) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                i = displayMetrics2.widthPixels;
                i2 = displayMetrics2.heightPixels;
            } else {
                i2 = i4;
                i = i3;
            }
        } else {
            i = -1;
        }
        jad_an jad_anVar = new jad_an();
        jad_anVar.jad_bo = i2;
        jad_anVar.jad_an = i;
        return jad_anVar;
    }
}
