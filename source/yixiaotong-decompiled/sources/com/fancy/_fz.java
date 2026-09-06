package com.fancy;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fz {
    public static int _a(int i, byte[] bArr) {
        int i2 = i << 2;
        return (bArr[i2 + 3] & 255) | (bArr[i2] << Ascii.CAN) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
