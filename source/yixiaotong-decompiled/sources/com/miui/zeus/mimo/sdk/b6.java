package com.miui.zeus.mimo.sdk;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b6 extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5374a;

    public b6(int i) {
        this.f5374a = i;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        int i6 = this.f5374a;
        if (i6 != -1) {
            textPaint.setTextSize(i6 * textPaint.density);
        }
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        canvas.drawText(charSequence, i, i2, f, i4 - (((((fontMetricsInt.ascent + i4) + i4) + fontMetricsInt.descent) / 2) - ((i3 + i5) / 2)), textPaint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        TextPaint textPaint = new TextPaint(paint);
        int i3 = this.f5374a;
        if (i3 != -1) {
            textPaint.setTextSize(i3 * textPaint.density);
        }
        return (int) textPaint.measureText(charSequence, i, i2);
    }
}
