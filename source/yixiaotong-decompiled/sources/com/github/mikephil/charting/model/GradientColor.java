package com.github.mikephil.charting.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class GradientColor {
    private int endColor;
    private int startColor;

    public int getEndColor() {
        return this.endColor;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public void setEndColor(int i) {
        this.endColor = i;
    }

    public void setStartColor(int i) {
        this.startColor = i;
    }

    public GradientColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
    }
}
