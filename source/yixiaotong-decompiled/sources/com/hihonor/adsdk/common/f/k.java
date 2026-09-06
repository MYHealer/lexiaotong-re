package com.hihonor.adsdk.common.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class k {
    private static final String hnadsa = "DrawableUtils";

    public static Drawable hnadsa(Context context, int i) {
        try {
            return AppCompatResources.getDrawable(context, i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getDrawable: " + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
