package com.github.mikephil.charting.highlight;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class Range {
    public float from;
    public float to;

    public boolean contains(float f) {
        return f > this.from && f <= this.to;
    }

    public boolean isLarger(float f) {
        return f > this.to;
    }

    public boolean isSmaller(float f) {
        return f < this.from;
    }

    public Range(float f, float f2) {
        this.from = f;
        this.to = f2;
    }
}
