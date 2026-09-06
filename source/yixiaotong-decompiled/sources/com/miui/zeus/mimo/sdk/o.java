package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5540a;
    public int b;

    public o(int i, int i2) {
        this.b = i;
        this.f5540a = i2;
    }

    public String toString() {
        return ijiami_1011.s.s.s.d(new byte[]{26, SignedBytes.MAX_POWER_OF_TWO, 92, 91, Ascii.DC4, 93, 13, 11, 7, 6, 97, Ascii.ETB, 14, 5, 74, 81, 16, SignedBytes.MAX_POWER_OF_TWO, 67, 94}, "ab84c3") + this.f5540a + ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, Ascii.SYN, 26, 2, 65, 72, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 92, 83, 92, 65, 11}, "068c18") + true + ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, Ascii.NAK, Ascii.SYN, 86, 13, 19, 15, 8, 9, 3, 85, 54, 67, 84, SignedBytes.MAX_POWER_OF_TWO, 71, 17, 70, 91}, "7542bd") + this.b + '}';
    }
}
