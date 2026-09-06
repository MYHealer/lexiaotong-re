package com.yfanads.android.libs.thirdpart.lottie.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DocumentData {
    public final double baselineShift;
    public final int color;
    public final String fontName;
    final int justification;
    final double lineHeight;
    public final double size;
    public final int strokeColor;
    public final boolean strokeOverFill;
    public final double strokeWidth;
    public final String text;
    public final int tracking;

    public DocumentData(String str, String str2, double d, int i, int i2, double d2, double d3, int i3, int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.size = d;
        this.justification = i;
        this.tracking = i2;
        this.lineHeight = d2;
        this.baselineShift = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.strokeWidth = d4;
        this.strokeOverFill = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) (((double) ((this.fontName.hashCode() + (this.text.hashCode() * 31)) * 31)) + this.size)) * 31) + this.justification) * 31) + this.tracking;
        long jDoubleToLongBits = Double.doubleToLongBits(this.lineHeight);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
