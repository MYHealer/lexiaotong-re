package com.kwad.components.core.t;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class r {
    public static float a(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 0.0f;
        }
    }

    public static int m(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 0;
        }
    }
}
