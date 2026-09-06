package com.miui.zeus.mimo.sdk.ad.interstitial.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.m0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InterstitalBottom7 extends m0 {
    public InterstitalBottom7(Context context) {
        super(context);
    }

    public InterstitalBottom7(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterstitalBottom7(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.miui.zeus.mimo.sdk.m0, com.miui.zeus.mimo.sdk.i0
    public void a(View view) {
        super.a(view);
        b.a((LinearLayout) view.findViewById(a0.W2), this.c, this.b);
        this.g = false;
    }

    @Override // com.miui.zeus.mimo.sdk.i0
    public boolean a() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.m0, com.miui.zeus.mimo.sdk.i0
    public int getLayoutId() {
        return a0.d4;
    }
}
