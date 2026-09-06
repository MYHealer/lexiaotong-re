package com.miui.zeus.mimo.sdk.ad.interstitial.view;

import android.content.Context;
import android.util.AttributeSet;
import com.miui.zeus.mimo.sdk.a0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InterstitalBottom5 extends InterstitialBottomFull {
    public InterstitalBottom5(Context context) {
        super(context);
    }

    public InterstitalBottom5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterstitalBottom5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.miui.zeus.mimo.sdk.ad.interstitial.view.InterstitialBottomFull, com.miui.zeus.mimo.sdk.i0
    public boolean a() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.ad.interstitial.view.InterstitialBottomFull, com.miui.zeus.mimo.sdk.i0
    public int getLayoutId() {
        return a0.b5;
    }
}
