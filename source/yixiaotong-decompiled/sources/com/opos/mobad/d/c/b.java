package com.opos.mobad.d.c;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6874a = "FoldUtil";
    private static int b = -1;

    public static boolean a(Context context) {
        if (b == -1) {
            int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
            if (identifier <= 0 || !context.getResources().getBoolean(identifier)) {
                b = 0;
            } else {
                b = 1;
            }
        }
        return b == 1;
    }
}
