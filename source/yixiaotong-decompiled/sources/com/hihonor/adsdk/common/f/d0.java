package com.hihonor.adsdk.common.f;

import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class d0 {
    private static final String hnadsa = "WindowUtils";

    public static void hnadsa(Window window) {
        if (window == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "setOnePx, window is null", new Object[0]);
            return;
        }
        window.setGravity(BadgeDrawable.TOP_START);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }
}
