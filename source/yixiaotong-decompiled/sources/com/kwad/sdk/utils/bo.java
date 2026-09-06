package com.kwad.sdk.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class bo {
    protected final int mHeight;
    protected final int mWidth;

    public final float Ww() {
        return this.mWidth;
    }

    public final float Wx() {
        return this.mHeight;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public bo(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bo) {
            bo boVar = (bo) obj;
            if (this.mWidth == boVar.mWidth && this.mHeight == boVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
