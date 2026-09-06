package com.kwad.sdk.core.view;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends ViewOutlineProvider {
    private int baY = 0;
    private int baZ;
    private int bba;
    private int bbb;
    private float mRadius;

    public a(float f, int i, int i2, int i3, int i4) {
        this.mRadius = f;
        this.baZ = i2;
        this.bba = i3;
        this.bbb = i4;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(new Rect(this.baY, this.baZ, this.bba, this.bbb), this.mRadius);
    }
}
