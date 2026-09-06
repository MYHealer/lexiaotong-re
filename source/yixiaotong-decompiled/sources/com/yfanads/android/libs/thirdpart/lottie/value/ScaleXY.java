package com.yfanads.android.libs.thirdpart.lottie.value;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ScaleXY {
    private final float scaleX;
    private final float scaleY;

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public ScaleXY(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
