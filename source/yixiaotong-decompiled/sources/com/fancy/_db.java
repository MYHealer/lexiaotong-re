package com.fancy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _db {
    public static final HashMap _a = new HashMap();

    public static void _a(TextView textView) {
        _dc _dcVar = _dc.PTG_AD_HOT_AREA_BG;
        if (textView != null) {
            Context context = textView.getContext();
            HashMap map = _a;
            Drawable drawable = map.containsKey(_dcVar) ? (Drawable) ((WeakReference) map.get(_dcVar)).get() : null;
            if (drawable == null) {
                _d9 _d9Var = (_d9) _da._a.get(_dcVar);
                GradientDrawable gradientDrawable_a = _d9Var != null ? _d9Var._a(context) : null;
                map.put(_dcVar, new WeakReference(gradientDrawable_a));
                drawable = gradientDrawable_a;
            }
            if (drawable != null) {
                textView.setBackground(drawable);
            }
        }
    }
}
