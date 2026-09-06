package com.huawei.hms.scankit.p;

import java.util.HashMap;

/* JADX INFO: compiled from: ToneMapping.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class l6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f4304a = 2.51f;
    private static float b = 0.03f;
    private static float c = 2.43f;
    private static float d = 0.59f;
    private static float e = 0.14f;
    private static HashMap<Integer, Integer> f = new HashMap<>(255);

    private static int a(int i, float f2) {
        if (f.containsKey(Integer.valueOf(i))) {
            return f.get(Integer.valueOf(i)).intValue();
        }
        float f3 = i / f2;
        int i2 = (int) ((f2 * (((f4304a * f3) + b) * f3)) / ((f3 * ((c * f3) + d)) + e));
        f.put(Integer.valueOf(i), Integer.valueOf(i2));
        return i2;
    }

    public static y3 b(y3 y3Var) {
        int iA = a(y3Var);
        int iC = y3Var.c();
        int iA2 = y3Var.a();
        byte[] bArrB = y3Var.b();
        byte[] bArr = new byte[iA2 * iC];
        for (int i = 0; i < iA2; i++) {
            for (int i2 = 0; i2 < iC; i2++) {
                int i3 = (i * iC) + i2;
                bArr[i3] = (byte) (a(bArrB[i3] & 255, iA) & 255);
            }
        }
        f = new HashMap<>(255);
        return new j5(bArr, iC, iA2, 0, 0, iC, iA2, false);
    }

    private static int a(y3 y3Var) {
        byte[] bArrB = y3Var.b();
        if (bArrB == null) {
            return 1;
        }
        int iC = y3Var.c();
        int iA = y3Var.a();
        long j = 0;
        for (int i = iA / 4; i < (iA * 3) / 4; i++) {
            for (int i2 = iC / 4; i2 < (iC * 3) / 4; i2++) {
                j += (long) (bArrB[(i * iC) + i2] & 255);
            }
        }
        return (int) ((j / ((long) bArrB.length)) * 4);
    }
}
