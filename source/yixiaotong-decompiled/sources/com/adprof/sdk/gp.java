package com.adprof.sdk;

import android.content.Context;
import android.view.TextureView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class gp extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f323a;
    public int b;
    public int c;

    public gp(Context context) {
        super(context);
        this.c = 0;
        this.f1198a = 0;
        this.b = 0;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int iB;
        int iM641a;
        int i4 = this.f1198a;
        if (i4 <= 0 || (i3 = this.b) <= 0 || this.c <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        d dVar = this.f323a;
        if (dVar == null || !dVar.m606g() || i3 <= i4 || i4 <= 0 || i3 / i4 != 1) {
            iB = this.c;
            iM641a = (this.b * iB) / this.f1198a;
        } else {
            iB = h8.b();
            iM641a = h8.m641a();
        }
        setMeasuredDimension(iB, iM641a);
    }

    public void setAdUnit(d dVar) {
        this.f323a = dVar;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    public void setTargetWidth(int i) {
        if (i > 0) {
            this.c = i;
        }
    }
}
