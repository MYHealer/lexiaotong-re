package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w0 extends u0 {
    public w0(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.u0
    public i0 a() {
        return new o0(getContext());
    }

    @Override // com.miui.zeus.mimo.sdk.u0
    public FrameLayout.LayoutParams b(Activity activity, MimoAdInfo mimoAdInfo) {
        int iD = f9.d(getContext());
        int iC = f9.c(getContext());
        if (iD == 0 || iC == 0) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        float f = iD;
        int i = (int) (0.7777778f * f);
        float f2 = iC;
        int i2 = (int) (0.6122951f * f2);
        if (f / f2 > 0.5625f) {
            i = (i2 * 9) / 16;
        } else {
            i2 = (i * 16) / 9;
        }
        FrameLayout.LayoutParams layoutParams = activity.getResources().getConfiguration().orientation == 1 ? new FrameLayout.LayoutParams(i, i2) : new FrameLayout.LayoutParams(i2, i);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // com.miui.zeus.mimo.sdk.u0
    public j0 b() {
        return new y0(getContext(), null);
    }

    @Override // com.miui.zeus.mimo.sdk.u0
    public RelativeLayout.LayoutParams getBottomLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        return layoutParams;
    }
}
