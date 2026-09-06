package com.opos.mobad.template.cmn;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i {
    public static float[] a(int i, int i2, int i3, float[] fArr) {
        float f;
        if (fArr == null) {
            fArr = new float[3];
        }
        int i4 = i > i2 ? i : i2;
        if (i3 > i4) {
            i4 = i3;
        }
        int i5 = i < i2 ? i : i2;
        if (i3 < i5) {
            i5 = i3;
        }
        float f2 = i4;
        float f3 = f2 / 255.0f;
        float f4 = 0.0f;
        float f5 = i4 != 0 ? (i4 - i5) / f2 : 0.0f;
        if (f5 != 0.0f) {
            float f6 = i4 - i5;
            float f7 = (i4 - i) / f6;
            float f8 = (i4 - i2) / f6;
            float f9 = (i4 - i3) / f6;
            if (i == i4) {
                f = f9 - f8;
            } else {
                f = i2 == i4 ? (f7 + 2.0f) - f9 : (f8 + 4.0f) - f7;
            }
            float f10 = f / 6.0f;
            f4 = f10 < 0.0f ? f10 + 1.0f : f10;
        }
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[2] = f3;
        return fArr;
    }
}
