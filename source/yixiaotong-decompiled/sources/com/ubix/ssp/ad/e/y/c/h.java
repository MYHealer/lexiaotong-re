package com.ubix.ssp.ad.e.y.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8940a = new int[0];
    public static final long[] b = new long[0];
    public static final float[] c = new float[0];
    public static final double[] d = new double[0];
    public static final boolean[] e = new boolean[0];
    public static final String[] f = new String[0];
    public static final byte[][] g = new byte[0][];
    public static final byte[] h = new byte[0];

    private h() {
    }

    public static int a(int i) {
        return i >>> 3;
    }

    static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int a(a aVar, int i) throws d {
        int iB = aVar.b();
        aVar.h(i);
        int i2 = 1;
        while (aVar.w() == i) {
            aVar.h(i);
            i2++;
        }
        aVar.g(iB);
        return i2;
    }

    static int b(int i) {
        return i & 7;
    }

    public static boolean b(a aVar, int i) {
        return aVar.h(i);
    }
}
