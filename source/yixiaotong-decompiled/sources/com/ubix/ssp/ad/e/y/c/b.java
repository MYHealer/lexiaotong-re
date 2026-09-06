package com.ubix.ssp.ad.e.y.c;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f8936a;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private b(ByteBuffer byteBuffer) {
        this.f8936a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private b(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int a(double d) {
        return 8;
    }

    public static int a(float f) {
        return 4;
    }

    public static int a(int i) {
        return d(i);
    }

    public static int a(int i, double d) {
        return g(i) + a(d);
    }

    public static int a(int i, float f) {
        return g(i) + a(f);
    }

    public static int a(int i, int i2) {
        return g(i) + a(i2);
    }

    static int a(int i, int i2, Object obj) {
        switch (i2) {
            case 1:
                return a(i, ((Double) obj).doubleValue());
            case 2:
                return a(i, ((Float) obj).floatValue());
            case 3:
                return b(i, ((Long) obj).longValue());
            case 4:
                return e(i, ((Long) obj).longValue());
            case 5:
                return c(i, ((Integer) obj).intValue());
            case 6:
                return a(i, ((Long) obj).longValue());
            case 7:
                return b(i, ((Integer) obj).intValue());
            case 8:
                return a(i, ((Boolean) obj).booleanValue());
            case 9:
                return a(i, (String) obj);
            case 10:
                return a(i, (f) obj);
            case 11:
                return b(i, (f) obj);
            case 12:
                return a(i, (byte[]) obj);
            case 13:
                return f(i, ((Integer) obj).intValue());
            case 14:
                return a(i, ((Integer) obj).intValue());
            case 15:
                return d(i, ((Integer) obj).intValue());
            case 16:
                return c(i, ((Long) obj).longValue());
            case 17:
                return e(i, ((Integer) obj).intValue());
            case 18:
                return d(i, ((Long) obj).longValue());
            default:
                throw new IllegalArgumentException("Unknown type: " + i2);
        }
    }

    public static int a(int i, long j) {
        return g(i) + a(j);
    }

    public static int a(int i, f fVar) {
        return (g(i) * 2) + a(fVar);
    }

    public static int a(int i, String str) {
        return g(i) + a(str);
    }

    public static int a(int i, boolean z) {
        return g(i) + a(z);
    }

    public static int a(int i, byte[] bArr) {
        return g(i) + a(bArr);
    }

    public static int a(long j) {
        return 8;
    }

    public static int a(f fVar) {
        return fVar.d();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iA = length;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= 2048) {
                iA += a(charSequence, i);
                break;
            }
            iA += (127 - cCharAt) >>> 31;
            i++;
        }
        if (iA >= length) {
            return iA;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iA) + 4294967296L));
    }

    private static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    private static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        char cCharAt;
        int length = charSequence.length();
        int i4 = i2 + i;
        int i5 = 0;
        while (i5 < length && (i3 = i5 + i) < i4 && (cCharAt = charSequence.charAt(i5)) < 128) {
            bArr[i3] = (byte) cCharAt;
            i5++;
        }
        if (i5 == length) {
            return i + length;
        }
        int i6 = i + i5;
        while (i5 < length) {
            char cCharAt2 = charSequence.charAt(i5);
            if (cCharAt2 < 128 && i6 < i4) {
                bArr[i6] = (byte) cCharAt2;
                i6++;
            } else if (cCharAt2 < 2048 && i6 <= i4 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((cCharAt2 >>> 6) | 960);
                i6 += 2;
                bArr[i7] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i6 > i4 - 3) {
                    if (i6 > i4 - 4) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i6);
                    }
                    int i8 = i5 + 1;
                    if (i8 != charSequence.length()) {
                        char cCharAt3 = charSequence.charAt(i8);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i6 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i9 = i6 + 3;
                            bArr[i6 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i6 += 4;
                            bArr[i9] = (byte) ((codePoint & 63) | 128);
                            i5 = i8;
                        } else {
                            i5 = i8;
                        }
                    }
                    throw new IllegalArgumentException("Unpaired surrogate at index " + (i5 - 1));
                }
                bArr[i6] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i10 = i6 + 2;
                bArr[i6 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i6 += 3;
                bArr[i10] = (byte) ((cCharAt2 & '?') | 128);
            }
            i5++;
        }
        return i6;
    }

    public static int a(String str) {
        int iA = a((CharSequence) str);
        return d(iA) + iA;
    }

    public static int a(boolean z) {
        return 1;
    }

    public static int a(byte[] bArr) {
        return d(bArr.length) + bArr.length;
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            b(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int b(int i) {
        return 4;
    }

    public static int b(int i, int i2) {
        return g(i) + b(i2);
    }

    public static int b(int i, long j) {
        return g(i) + b(j);
    }

    public static int b(int i, f fVar) {
        return g(i) + b(fVar);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int b(f fVar) {
        int iD = fVar.d();
        return d(iD) + iD;
    }

    private static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt >= 128) {
                if (cCharAt < 2048) {
                    i2 = cCharAt;
                    i = (cCharAt >>> 6) | 960;
                } else {
                    if (cCharAt >= 55296 && 57343 >= cCharAt) {
                        int i4 = i3 + 1;
                        if (i4 != charSequence.length()) {
                            char cCharAt2 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                                i2 = cCharAt;
                                int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                                byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint & 63) | 128));
                                i3 = i4;
                            } else {
                                i2 = cCharAt;
                                i3 = i4;
                            }
                        } else {
                            i2 = cCharAt;
                        }
                        throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
                    }
                    i2 = cCharAt;
                    i2 = cCharAt;
                    byteBuffer.put((byte) ((cCharAt >>> '\f') | 480));
                    i = ((cCharAt >>> 6) & 63) | 128;
                }
                byteBuffer.put((byte) i);
                i2 = (cCharAt & '?') | 128;
                i2 = cCharAt;
                byteBuffer.put((byte) i2);
            } else {
                i2 = cCharAt;
                byteBuffer.put((byte) i2);
            }
            i3++;
        }
    }

    public static int c(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int c(int i, int i2) {
        return g(i) + c(i2);
    }

    public static int c(int i, long j) {
        return g(i) + d(j);
    }

    public static int c(long j) {
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

    public static int d(int i) {
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

    public static int d(int i, int i2) {
        return g(i) + e(i2);
    }

    public static int d(int i, long j) {
        return g(i) + e(j);
    }

    public static int d(long j) {
        return 8;
    }

    public static int e(int i) {
        return 4;
    }

    public static int e(int i, int i2) {
        return g(i) + f(i2);
    }

    public static int e(int i, long j) {
        return g(i) + f(j);
    }

    public static int e(long j) {
        return c(g(j));
    }

    public static int f(int i) {
        return d(i(i));
    }

    public static int f(int i, int i2) {
        return g(i) + h(i2);
    }

    public static int f(long j) {
        return c(j);
    }

    public static int g(int i) {
        return d(h.a(i, 0));
    }

    public static long g(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int h(int i) {
        return d(i);
    }

    public static int i(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public void a() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void a(byte b) throws a {
        if (!this.f8936a.hasRemaining()) {
            throw new a(this.f8936a.position(), this.f8936a.limit());
        }
        this.f8936a.put(b);
    }

    public int b() {
        return this.f8936a.remaining();
    }

    public void b(double d) throws a {
        j(Double.doubleToLongBits(d));
    }

    public void b(float f) throws a {
        n(Float.floatToIntBits(f));
    }

    public void b(int i, double d) throws a {
        l(i, 1);
        b(d);
    }

    public void b(int i, float f) throws a {
        l(i, 5);
        b(f);
    }

    void b(int i, int i2, Object obj) throws IOException {
        switch (i2) {
            case 1:
                b(i, ((Double) obj).doubleValue());
                return;
            case 2:
                b(i, ((Float) obj).floatValue());
                return;
            case 3:
                g(i, ((Long) obj).longValue());
                return;
            case 4:
                j(i, ((Long) obj).longValue());
                return;
            case 5:
                i(i, ((Integer) obj).intValue());
                return;
            case 6:
                f(i, ((Long) obj).longValue());
                return;
            case 7:
                h(i, ((Integer) obj).intValue());
                return;
            case 8:
                b(i, ((Boolean) obj).booleanValue());
                return;
            case 9:
                b(i, (String) obj);
                return;
            case 10:
                c(i, (f) obj);
                return;
            case 11:
                d(i, (f) obj);
                return;
            case 12:
                b(i, (byte[]) obj);
                return;
            case 13:
                m(i, ((Integer) obj).intValue());
                return;
            case 14:
                g(i, ((Integer) obj).intValue());
                return;
            case 15:
                j(i, ((Integer) obj).intValue());
                return;
            case 16:
                h(i, ((Long) obj).longValue());
                return;
            case 17:
                k(i, ((Integer) obj).intValue());
                return;
            case 18:
                i(i, ((Long) obj).longValue());
                return;
            default:
                throw new IOException("Unknown type: " + i2);
        }
    }

    public void b(int i, String str) throws a {
        l(i, 2);
        b(str);
    }

    public void b(int i, boolean z) throws a {
        l(i, 0);
        b(z);
    }

    public void b(int i, byte[] bArr) throws a {
        l(i, 2);
        b(bArr);
    }

    public void b(String str) throws a {
        try {
            int iD = d(str.length());
            if (iD != d(str.length() * 3)) {
                o(a((CharSequence) str));
                a(str, this.f8936a);
                return;
            }
            int iPosition = this.f8936a.position();
            if (this.f8936a.remaining() < iD) {
                throw new a(iPosition + iD, this.f8936a.limit());
            }
            this.f8936a.position(iPosition + iD);
            a(str, this.f8936a);
            int iPosition2 = this.f8936a.position();
            this.f8936a.position(iPosition);
            o((iPosition2 - iPosition) - iD);
            this.f8936a.position(iPosition2);
        } catch (BufferOverflowException e) {
            a aVar = new a(this.f8936a.position(), this.f8936a.limit());
            aVar.initCause(e);
            throw aVar;
        }
    }

    public void b(boolean z) throws a {
        m(z ? 1 : 0);
    }

    public void b(byte[] bArr) throws a {
        o(bArr.length);
        c(bArr);
    }

    public void b(byte[] bArr, int i, int i2) throws a {
        if (this.f8936a.remaining() < i2) {
            throw new a(this.f8936a.position(), this.f8936a.limit());
        }
        this.f8936a.put(bArr, i, i2);
    }

    public void c(int i, f fVar) throws a {
        l(i, 3);
        c(fVar);
        l(i, 4);
    }

    public void c(f fVar) {
        fVar.a(this);
    }

    public void c(byte[] bArr) throws a {
        b(bArr, 0, bArr.length);
    }

    public void d(int i, f fVar) throws a {
        l(i, 2);
        d(fVar);
    }

    public void d(f fVar) throws a {
        o(fVar.c());
        fVar.a(this);
    }

    public void f(int i, long j) throws a {
        l(i, 1);
        h(j);
    }

    public void g(int i, int i2) throws a {
        l(i, 0);
        j(i2);
    }

    public void g(int i, long j) throws a {
        l(i, 0);
        i(j);
    }

    public void h(int i, int i2) throws a {
        l(i, 5);
        k(i2);
    }

    public void h(int i, long j) throws a {
        l(i, 1);
        l(j);
    }

    public void h(long j) throws a {
        j(j);
    }

    public void i(int i, int i2) throws a {
        l(i, 0);
        l(i2);
    }

    public void i(int i, long j) throws a {
        l(i, 0);
        m(j);
    }

    public void i(long j) throws a {
        k(j);
    }

    public void j(int i) throws a {
        o(i);
    }

    public void j(int i, int i2) throws a {
        l(i, 5);
        p(i2);
    }

    public void j(int i, long j) throws a {
        l(i, 0);
        n(j);
    }

    public void j(long j) throws a {
        if (this.f8936a.remaining() < 8) {
            throw new a(this.f8936a.position(), this.f8936a.limit());
        }
        this.f8936a.putLong(j);
    }

    public void k(int i) throws a {
        n(i);
    }

    public void k(int i, int i2) throws a {
        l(i, 0);
        q(i2);
    }

    public void k(long j) throws a {
        while (((-128) & j) != 0) {
            m((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m((int) j);
    }

    public void l(int i) throws a {
        if (i >= 0) {
            o(i);
        } else {
            k(i);
        }
    }

    public void l(int i, int i2) throws a {
        o(h.a(i, i2));
    }

    public void l(long j) throws a {
        j(j);
    }

    public void m(int i) throws a {
        a((byte) i);
    }

    public void m(int i, int i2) throws a {
        l(i, 0);
        r(i2);
    }

    public void m(long j) throws a {
        k(g(j));
    }

    public void n(int i) throws a {
        if (this.f8936a.remaining() < 4) {
            throw new a(this.f8936a.position(), this.f8936a.limit());
        }
        this.f8936a.putInt(i);
    }

    public void n(long j) throws a {
        k(j);
    }

    public void o(int i) throws a {
        while ((i & (-128)) != 0) {
            m((i & 127) | 128);
            i >>>= 7;
        }
        m(i);
    }

    public void p(int i) throws a {
        n(i);
    }

    public void q(int i) throws a {
        o(i(i));
    }

    public void r(int i) throws a {
        o(i);
    }
}
