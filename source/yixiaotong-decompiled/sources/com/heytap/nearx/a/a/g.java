package com.heytap.nearx.a.a;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSink f3490a;

    public g(BufferedSink bufferedSink) {
        this.f3490a = bufferedSink;
    }

    static int a(int i) {
        return c(b(i, a.VARINT));
    }

    static int a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    static int a(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                i3++;
            } else if (cCharAt < 2048) {
                i3 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i3 += 3;
            } else if (cCharAt > 56319 || (i = i2 + 1) >= length || str.charAt(i) < 56320 || str.charAt(i) > 57343) {
                i3++;
            } else {
                i3 += 4;
                i2 = i;
            }
            i2++;
        }
        return i3;
    }

    static int b(int i) {
        if (i >= 0) {
            return c(i);
        }
        return 10;
    }

    private static int b(int i, a aVar) {
        return (i << 3) | aVar.e;
    }

    static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    static int c(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static int d(int i) {
        return (i >> 31) ^ (i << 1);
    }

    static int e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public void a(int i, a aVar) throws IOException {
        g(b(i, aVar));
    }

    public void a(ByteString byteString) throws IOException {
        this.f3490a.write(byteString);
    }

    public void b(String str) throws IOException {
        this.f3490a.writeUtf8(str);
    }

    public void d(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.f3490a.writeByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.f3490a.writeByte((int) j);
    }

    public void e(long j) throws IOException {
        this.f3490a.writeLongLe(j);
    }

    void f(int i) throws IOException {
        if (i >= 0) {
            g(i);
        } else {
            d(i);
        }
    }

    public void g(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.f3490a.writeByte((i & 127) | 128);
            i >>>= 7;
        }
        this.f3490a.writeByte(i);
    }

    public void h(int i) throws IOException {
        this.f3490a.writeIntLe(i);
    }
}
