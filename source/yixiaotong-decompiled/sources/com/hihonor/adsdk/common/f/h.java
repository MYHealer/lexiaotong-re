package com.hihonor.adsdk.common.f;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    public static boolean hnadsa(Activity activity) {
        return (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static boolean hnadsa(View view) {
        return (view == null || view.getWindowToken() == null) ? false : true;
    }
}
