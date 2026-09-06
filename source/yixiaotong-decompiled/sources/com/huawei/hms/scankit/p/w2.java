package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: compiled from: FormatInformation.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class w2 {
    private static final int[][] c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{AVMDLDataLoader.KeyIsCacheDirListsStr, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r2 f4366a;
    private final byte b;

    private w2(int i) {
        this.f4366a = r2.a((i >> 3) & 3);
        this.b = (byte) (i & 7);
    }

    static w2 a(int i, int i2) {
        w2 w2VarB = b(i, i2);
        return w2VarB != null ? w2VarB : b(i ^ 21522, i2 ^ 21522);
    }

    private static w2 b(int i, int i2) {
        int iC;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : c) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new w2(iArr[1]);
            }
            int iC2 = c(i, i5);
            if (iC2 < i3) {
                i4 = iArr[1];
                i3 = iC2;
            }
            if (i != i2 && (iC = c(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = iC;
            }
        }
        if (i3 <= 3) {
            return new w2(i4);
        }
        return null;
    }

    static int c(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    byte a() {
        return this.b;
    }

    r2 b() {
        return this.f4366a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w2)) {
            return false;
        }
        w2 w2Var = (w2) obj;
        return this.f4366a == w2Var.f4366a && this.b == w2Var.b;
    }

    public int hashCode() {
        return (this.f4366a.ordinal() << 3) | this.b;
    }
}
