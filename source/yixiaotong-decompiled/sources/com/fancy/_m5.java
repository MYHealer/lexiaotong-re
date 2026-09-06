package com.fancy;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m5 {
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    public static _i9 _a(_f _fVar, int i, int i2) {
        double d;
        double d2;
        int i3;
        boolean z;
        if (_fVar == null) {
            return null;
        }
        _i9 _i9Var = new _i9();
        int i_p = _fVar._p();
        int i_g = _fVar._g();
        int i4 = i2;
        double d3 = i4;
        double d4 = i;
        double d5 = d3 / d4;
        double d6 = _fVar._S;
        if (d5 > 1.0d) {
            double d7 = ((double) i_g) / ((double) i_p);
            double d8 = d5 - d7;
            if (d8 > d6) {
                d = d4 * d7;
                i4 = (int) d;
                i3 = i;
                z = true;
            } else if (d8 < (-d6)) {
                d2 = d3 / d7;
                i3 = (int) d2;
                z = true;
            } else {
                i3 = -1;
                z = false;
                i4 = -1;
            }
        } else {
            double d9 = ((double) i_p) / ((double) i_g);
            double d10 = (d4 / d3) - d9;
            if (d10 > d6) {
                d2 = d3 * d9;
                i3 = (int) d2;
                z = true;
            } else if (d10 < (-d6)) {
                d = d4 / d9;
                i4 = (int) d;
                i3 = i;
                z = true;
            } else {
                i3 = -1;
                z = false;
                i4 = -1;
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.gravity = 17;
        _i9Var._b = z;
        _i9Var._a = layoutParams;
        return _i9Var;
    }

    public static boolean _a(View view, float f) {
        Rect rect = new Rect();
        if (view == null || !view.getGlobalVisibleRect(rect)) {
            return false;
        }
        return ((float) (rect.height() * rect.width())) >= ((float) (view.getHeight() * view.getWidth())) * f;
    }
}
