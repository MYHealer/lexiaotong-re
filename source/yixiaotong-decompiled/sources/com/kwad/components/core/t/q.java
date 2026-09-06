package com.kwad.components.core.t;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class q {
    public static boolean isInMultiWindowMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return activity.isInMultiWindowMode();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean e(Activity activity) {
        int iG = com.kwad.sdk.c.a.a.g(activity);
        if (isInMultiWindowMode(activity) && com.kwad.sdk.c.a.a.bA(activity) - iG < com.kwad.sdk.c.a.a.a(activity, 100.0f)) {
            iG = com.kwad.sdk.c.a.a.k(activity);
        }
        return ((float) iG) / ((float) com.kwad.sdk.c.a.a.h(activity)) < 1.2f;
    }
}
