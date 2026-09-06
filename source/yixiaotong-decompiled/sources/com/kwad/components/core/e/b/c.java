package com.kwad.components.core.e.b;

import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c {
    private final int[] Qu;

    private c(int[] iArr) {
        this.Qu = iArr;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long a(long j, int[] iArr) {
        int i = 0;
        while (i < 8) {
            j = a(i, iArr, j);
            i++;
        }
        while (i < 16) {
            j = b(i, iArr, j);
            i++;
        }
        while (i < 24) {
            j = a(i, iArr, j);
            i++;
        }
        while (i < 32) {
            j = b(i, iArr, j);
            i++;
        }
        return j;
    }

    private static long b(long j, int[] iArr) {
        int i = 31;
        while (i > 23) {
            j = d(i, iArr, j);
            i--;
        }
        while (i > 15) {
            j = c(i, iArr, j);
            i--;
        }
        while (i > 7) {
            j = d(i, iArr, j);
            i--;
        }
        while (i >= 0) {
            j = c(i, iArr, j);
            i--;
        }
        return j;
    }

    private static long a(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jE = ((j & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ e(i, iArr, j2)) ^ ((long) (i + 1));
        return (e(i, iArr, j2) << 32) | (jE << 48) | (j3 << 16) | j4;
    }

    private static long b(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jE = e(i, iArr, j2);
        return ((((long) (i + 1)) ^ (j2 ^ j3)) << 16) | (j5 << 48) | (jE << 32) | j4;
    }

    private static long c(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jF = f(i, iArr, j3);
        return (((long) (i + 1)) ^ (j2 ^ j3)) | (j5 << 16) | (jF << 48) | (j4 << 32);
    }

    private static long d(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jF = f(i, iArr, j3);
        return ((((long) (i + 1)) ^ (f(i, iArr, j3) ^ j4)) << 32) | (jF << 48) | (j5 << 16) | j2;
    }

    private static long e(int i, int[] iArr, long j) {
        int i2 = (int) (j >>> 8);
        int i3 = (int) (j & 255);
        int i4 = i * 4;
        int i5 = iArr[i4 % 10];
        int i6 = iArr[(i4 + 1) % 10];
        int i7 = iArr[(i4 + 2) % 10];
        int i8 = iArr[(i4 + 3) % 10];
        int i9 = b.Qt[i5 ^ i3] ^ i2;
        int i10 = i3 ^ b.Qt[i9 ^ i6];
        int i11 = i9 ^ b.Qt[i10 ^ i7];
        return (((long) i11) << 8) | ((long) (b.Qt[i8 ^ i11] ^ i10));
    }

    private static long f(int i, int[] iArr, long j) {
        int i2 = (int) (255 & j);
        int i3 = (int) (j >>> 8);
        int i4 = i * 4;
        int i5 = iArr[(i4 + 3) % 10];
        int i6 = iArr[(i4 + 2) % 10];
        int i7 = iArr[(i4 + 1) % 10];
        int i8 = iArr[i4 % 10];
        int i9 = b.Qt[i5 ^ i3] ^ i2;
        int i10 = i3 ^ b.Qt[i9 ^ i6];
        int i11 = i9 ^ b.Qt[i10 ^ i7];
        return ((long) i11) | (((long) (b.Qt[i8 ^ i11] ^ i10)) << 8);
    }

    public final String C(long j) {
        return com.kwad.sdk.core.a.c.LO().encodeToString(ByteBuffer.allocate(8).putLong(a(j, this.Qu)).array());
    }

    public final long an(String str) {
        byte[] bArrDecode = com.kwad.sdk.core.a.c.LR().decode(str);
        if (bArrDecode == null || bArrDecode.length != 8) {
            throw new RuntimeException("fail to decode: " + str);
        }
        return b(ByteBuffer.wrap(bArrDecode).getLong(), this.Qu);
    }
}
