package com.hihonor.adsdk.common.e.d.c;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    public static final int hnadsa = 8;

    public static void hnadsa(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        Drawable background = view.getBackground();
        view.setBackground(null);
        if (background != null) {
            background.setVisible(true, false);
        }
        view.setBackground(new LayerDrawable(background == null ? new Drawable[]{drawable} : new Drawable[]{background, drawable}));
    }

    public static void hnadsa(View view, float f, int i) {
        hnadsa(view, f, i, (Rect) null);
    }

    public static void hnadsa(View view, float f, int i, Rect rect) {
        if (view != null && view.isEnabled() && hnadsa(view)) {
            hnadsa(view, hnadsa(view.getContext(), f, i, rect));
        }
    }

    public static StateListDrawable hnadsa(Context context, float f, int i, Rect rect) {
        return hnadsa(context, f, i, rect, false);
    }

    public static StateListDrawable hnadsa(Context context, float f, int i, Rect rect, boolean z) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        com.hihonor.adsdk.common.e.d.b.a aVar = new com.hihonor.adsdk.common.e.d.b.a(context, f, i);
        aVar.hnadsa(z);
        aVar.hnadsa(rect);
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_hovered}, aVar);
        stateListDrawable.setEnterFadeDuration(100);
        stateListDrawable.setExitFadeDuration(50);
        return stateListDrawable;
    }

    private static boolean hnadsa(View view) {
        Object tag = view.getTag(com.hihonor.adsdk.base.R.id.honorAdsIsHoverEnabled);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            return false;
        }
        view.setTag(com.hihonor.adsdk.base.R.id.honorAdsIsHoverEnabled, Boolean.TRUE);
        return true;
    }
}
