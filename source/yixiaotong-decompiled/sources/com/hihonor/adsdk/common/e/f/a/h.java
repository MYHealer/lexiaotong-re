package com.hihonor.adsdk.common.e.f.a;

import android.graphics.Color;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static final String hnadsa = "Utils";

    public static int hnadsa(int[] iArr) {
        int[] iArr2 = new int[4];
        for (int i : iArr) {
            iArr2[0] = iArr2[0] + Color.red(i);
            iArr2[1] = iArr2[1] + Color.green(i);
            iArr2[2] = iArr2[2] + Color.blue(i);
            iArr2[3] = iArr2[3] + Color.alpha(i);
        }
        int length = iArr2[0] / iArr.length;
        iArr2[0] = length;
        int length2 = iArr2[1] / iArr.length;
        iArr2[1] = length2;
        int length3 = iArr2[2] / iArr.length;
        iArr2[2] = length3;
        int length4 = iArr2[3] / iArr.length;
        iArr2[3] = length4;
        return Color.argb(length4, length, length2, length3);
    }
}
