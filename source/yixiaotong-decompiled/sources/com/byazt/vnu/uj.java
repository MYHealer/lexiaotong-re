package com.byazt.vnu;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 699, 15})
public final class uj {
    public static <T> T c(T t) {
        t.getClass();
        return t;
    }

    public static void c(InputStream inputStream, byte[] bArr) throws IOException {
        c(inputStream, bArr, 0, bArr.length);
    }

    public static void c(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iTt = tt(inputStream, bArr, i, i2);
        if (iTt != i2) {
            throw new EOFException("reached end of stream after reading " + iTt + " bytes; " + i2 + " bytes expected");
        }
    }

    public static int tt(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        c(inputStream);
        c(bArr);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        c(i, i + i2, bArr.length);
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void c(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(new StringBuilder().append(i).append(i2).append(i3).toString());
        }
    }
}
