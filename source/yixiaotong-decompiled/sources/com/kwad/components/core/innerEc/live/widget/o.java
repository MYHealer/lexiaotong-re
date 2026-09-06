package com.kwad.components.core.innerEc.live.widget;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class o extends CharacterStyle {
    private int Fx;
    private boolean aaD;
    private float mRadius = 3.0f;
    private float aaB = 0.0f;
    private float aaC = 3.0f;

    public final void aO(boolean z) {
        this.aaD = true;
    }

    public o(float f, float f2, float f3, int i) {
        this.Fx = i;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        if (this.aaD) {
            textPaint.setShadowLayer(this.mRadius, this.aaB, this.aaC, this.Fx);
        }
    }
}
