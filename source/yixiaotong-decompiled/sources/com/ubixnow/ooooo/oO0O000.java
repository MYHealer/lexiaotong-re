package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O000 {
    public static final int OooO00o = 0;
    public static final int OooO0O0 = 1;
    public static final int OooO0OO = 2;
    public static final int OooO0Oo = 3;
    public static final int OooO0o = 5;
    public static final int OooO0o0 = 4;
    public static final int OooO0oO = 3;
    public static final int OooO0oo = 7;
    public static final int[] OooO = new int[0];
    public static final long[] OooOO0 = new long[0];
    public static final float[] OooOO0O = new float[0];
    public static final double[] OooOO0o = new double[0];
    public static final boolean[] OooOOO0 = new boolean[0];
    public static final String[] OooOOO = new String[0];
    public static final byte[][] OooOOOO = new byte[0][];
    public static final byte[] OooOOOo = new byte[0];

    private oO0O000() {
    }

    public static int OooO00o(int i) {
        return i >>> 3;
    }

    public static int OooO00o(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int OooO00o(oO00o000 oo00o000, int i) throws IOException {
        int iOooO0O0 = oo00o000.OooO0O0();
        oo00o000.OooOO0(i);
        int i2 = 1;
        while (oo00o000.OooOo0o() == i) {
            oo00o000.OooOO0(i);
            i2++;
        }
        oo00o000.OooO0oO(iOooO0O0);
        return i2;
    }

    public static int OooO0O0(int i) {
        return i & 7;
    }

    public static boolean OooO0O0(oO00o000 oo00o000, int i) throws IOException {
        return oo00o000.OooOO0(i);
    }
}
