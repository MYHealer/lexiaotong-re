package com.opos.cmn.i;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    public static boolean a(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
