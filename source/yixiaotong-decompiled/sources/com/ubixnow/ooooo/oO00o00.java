package com.ubixnow.ooooo;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO00o00 {
    private static final int OooO00o = 3;
    public static final int OooO0O0 = 4;
    public static final int OooO0OO = 8;
    private final ByteBuffer OooO0Oo;

    public static class OooO00o extends IOException {
        private static final long OooO00o = -6947486886997889499L;

        public OooO00o(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private oO00o00(ByteBuffer byteBuffer) {
        this.OooO0Oo = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private oO00o00(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int OooO(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int OooO00o(double d) {
        return 8;
    }

    public static int OooO00o(float f) {
        return 4;
    }

    public static int OooO00o(int i) {
        return OooO0Oo(i);
    }

    public static int OooO00o(int i, double d) {
        return OooO0oO(i) + OooO00o(d);
    }

    public static int OooO00o(int i, float f) {
        return OooO0oO(i) + OooO00o(f);
    }

    public static int OooO00o(int i, int i2) {
        return OooO0oO(i) + OooO00o(i2);
    }

    public static int OooO00o(int i, int i2, Object obj) {
        switch (i2) {
            case 1:
                return OooO00o(i, ((Double) obj).doubleValue());
            case 2:
                return OooO00o(i, ((Float) obj).floatValue());
            case 3:
                return OooO0O0(i, ((Long) obj).longValue());
            case 4:
                return OooO0o0(i, ((Long) obj).longValue());
            case 5:
                return OooO0OO(i, ((Integer) obj).intValue());
            case 6:
                return OooO00o(i, ((Long) obj).longValue());
            case 7:
                return OooO0O0(i, ((Integer) obj).intValue());
            case 8:
                return OooO00o(i, ((Boolean) obj).booleanValue());
            case 9:
                return OooO00o(i, (String) obj);
            case 10:
                return OooO00o(i, (oOo0000O) obj);
            case 11:
                return OooO0O0(i, (oOo0000O) obj);
            case 12:
                return OooO00o(i, (byte[]) obj);
            case 13:
                return OooO0o(i, ((Integer) obj).intValue());
            case 14:
                return OooO00o(i, ((Integer) obj).intValue());
            case 15:
                return OooO0Oo(i, ((Integer) obj).intValue());
            case 16:
                return OooO0OO(i, ((Long) obj).longValue());
            case 17:
                return OooO0o0(i, ((Integer) obj).intValue());
            case 18:
                return OooO0Oo(i, ((Long) obj).longValue());
            default:
                throw new IllegalArgumentException("Unknown type: " + i2);
        }
    }

    public static int OooO00o(int i, long j) {
        return OooO0oO(i) + OooO00o(j);
    }

    public static int OooO00o(int i, oOo0000O ooo0000o) {
        return (OooO0oO(i) * 2) + OooO00o(ooo0000o);
    }

    public static int OooO00o(int i, String str) {
        return OooO0oO(i) + OooO00o(str);
    }

    public static int OooO00o(int i, boolean z) {
        return OooO0oO(i) + OooO00o(z);
    }

    public static int OooO00o(int i, byte[] bArr) {
        return OooO0oO(i) + OooO00o(bArr);
    }

    public static int OooO00o(long j) {
        return 8;
    }

    public static int OooO00o(oOo0000O ooo0000o) {
        return ooo0000o.OooO0Oo();
    }

    private static int OooO00o(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iOooO00o = length;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= 2048) {
                iOooO00o += OooO00o(charSequence, i);
                break;
            }
            iOooO00o += (127 - cCharAt) >>> 31;
            i++;
        }
        if (iOooO00o >= length) {
            return iOooO00o;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iOooO00o) + 4294967296L));
    }

    private static int OooO00o(CharSequence charSequence, int i) {
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

    private static int OooO00o(CharSequence charSequence, byte[] bArr, int i, int i2) {
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

    public static int OooO00o(String str) {
        int iOooO00o = OooO00o((CharSequence) str);
        return OooO0Oo(iOooO00o) + iOooO00o;
    }

    public static int OooO00o(boolean z) {
        return 1;
    }

    public static int OooO00o(byte[] bArr) {
        return OooO0Oo(bArr.length) + bArr.length;
    }

    public static oO00o00 OooO00o(byte[] bArr, int i, int i2) {
        return new oO00o00(bArr, i, i2);
    }

    private static void OooO00o(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            OooO0O0(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(OooO00o(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int OooO0O0(int i) {
        return 4;
    }

    public static int OooO0O0(int i, int i2) {
        return OooO0oO(i) + OooO0O0(i2);
    }

    public static int OooO0O0(int i, long j) {
        return OooO0oO(i) + OooO0O0(j);
    }

    public static int OooO0O0(int i, oOo0000O ooo0000o) {
        return OooO0oO(i) + OooO0O0(ooo0000o);
    }

    public static int OooO0O0(long j) {
        return OooO0OO(j);
    }

    public static int OooO0O0(oOo0000O ooo0000o) {
        int iOooO0Oo = ooo0000o.OooO0Oo();
        return OooO0Oo(iOooO0Oo) + iOooO0Oo;
    }

    public static oO00o00 OooO0O0(byte[] bArr) {
        return OooO00o(bArr, 0, bArr.length);
    }

    private static void OooO0O0(CharSequence charSequence, ByteBuffer byteBuffer) {
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

    public static int OooO0OO(int i) {
        if (i >= 0) {
            return OooO0Oo(i);
        }
        return 10;
    }

    public static int OooO0OO(int i, int i2) {
        return OooO0oO(i) + OooO0OO(i2);
    }

    public static int OooO0OO(int i, long j) {
        return OooO0oO(i) + OooO0Oo(j);
    }

    public static int OooO0OO(long j) {
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

    public static int OooO0Oo(int i) {
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

    public static int OooO0Oo(int i, int i2) {
        return OooO0oO(i) + OooO0o0(i2);
    }

    public static int OooO0Oo(int i, long j) {
        return OooO0oO(i) + OooO0o0(j);
    }

    public static int OooO0Oo(long j) {
        return 8;
    }

    public static int OooO0o(int i) {
        return OooO0Oo(OooO(i));
    }

    public static int OooO0o(int i, int i2) {
        return OooO0oO(i) + OooO0oo(i2);
    }

    public static int OooO0o(long j) {
        return OooO0OO(j);
    }

    public static int OooO0o0(int i) {
        return 4;
    }

    public static int OooO0o0(int i, int i2) {
        return OooO0oO(i) + OooO0o(i2);
    }

    public static int OooO0o0(int i, long j) {
        return OooO0oO(i) + OooO0o(j);
    }

    public static int OooO0o0(long j) {
        return OooO0OO(OooO0oO(j));
    }

    public static int OooO0oO(int i) {
        return OooO0Oo(oO0O000.OooO00o(i, 0));
    }

    public static long OooO0oO(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int OooO0oo(int i) {
        return OooO0Oo(i);
    }

    public void OooO(int i, int i2) throws IOException {
        OooOO0o(i, 0);
        OooOO0o(i2);
    }

    public void OooO(int i, long j) throws IOException {
        OooOO0o(i, 0);
        OooOOO0(j);
    }

    public void OooO(long j) throws IOException {
        OooOO0O(j);
    }

    public void OooO00o() {
        if (OooO0Oo() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void OooO00o(byte b) throws IOException {
        if (!this.OooO0Oo.hasRemaining()) {
            throw new OooO00o(this.OooO0Oo.position(), this.OooO0Oo.limit());
        }
        this.OooO0Oo.put(b);
    }

    public int OooO0O0() {
        return this.OooO0Oo.position();
    }

    public void OooO0O0(double d) throws IOException {
        OooOO0(Double.doubleToLongBits(d));
    }

    public void OooO0O0(float f) throws IOException {
        OooOOO(Float.floatToIntBits(f));
    }

    public void OooO0O0(int i, double d) throws IOException {
        OooOO0o(i, 1);
        OooO0O0(d);
    }

    public void OooO0O0(int i, float f) throws IOException {
        OooOO0o(i, 5);
        OooO0O0(f);
    }

    public void OooO0O0(int i, int i2, Object obj) throws IOException {
        switch (i2) {
            case 1:
                OooO0O0(i, ((Double) obj).doubleValue());
                return;
            case 2:
                OooO0O0(i, ((Float) obj).floatValue());
                return;
            case 3:
                OooO0oO(i, ((Long) obj).longValue());
                return;
            case 4:
                OooOO0(i, ((Long) obj).longValue());
                return;
            case 5:
                OooO(i, ((Integer) obj).intValue());
                return;
            case 6:
                OooO0o(i, ((Long) obj).longValue());
                return;
            case 7:
                OooO0oo(i, ((Integer) obj).intValue());
                return;
            case 8:
                OooO0O0(i, ((Boolean) obj).booleanValue());
                return;
            case 9:
                OooO0O0(i, (String) obj);
                return;
            case 10:
                OooO0OO(i, (oOo0000O) obj);
                return;
            case 11:
                OooO0Oo(i, (oOo0000O) obj);
                return;
            case 12:
                OooO0O0(i, (byte[]) obj);
                return;
            case 13:
                OooOOO0(i, ((Integer) obj).intValue());
                return;
            case 14:
                OooO0oO(i, ((Integer) obj).intValue());
                return;
            case 15:
                OooOO0(i, ((Integer) obj).intValue());
                return;
            case 16:
                OooO0oo(i, ((Long) obj).longValue());
                return;
            case 17:
                OooOO0O(i, ((Integer) obj).intValue());
                return;
            case 18:
                OooO(i, ((Long) obj).longValue());
                return;
            default:
                throw new IOException("Unknown type: " + i2);
        }
    }

    public void OooO0O0(int i, String str) throws IOException {
        OooOO0o(i, 2);
        OooO0O0(str);
    }

    public void OooO0O0(int i, boolean z) throws IOException {
        OooOO0o(i, 0);
        OooO0O0(z);
    }

    public void OooO0O0(int i, byte[] bArr) throws IOException {
        OooOO0o(i, 2);
        OooO0OO(bArr);
    }

    public void OooO0O0(String str) throws IOException {
        try {
            int iOooO0Oo = OooO0Oo(str.length());
            if (iOooO0Oo != OooO0Oo(str.length() * 3)) {
                OooOOOO(OooO00o((CharSequence) str));
                OooO00o(str, this.OooO0Oo);
                return;
            }
            int iPosition = this.OooO0Oo.position();
            if (this.OooO0Oo.remaining() < iOooO0Oo) {
                throw new OooO00o(iPosition + iOooO0Oo, this.OooO0Oo.limit());
            }
            this.OooO0Oo.position(iPosition + iOooO0Oo);
            OooO00o(str, this.OooO0Oo);
            int iPosition2 = this.OooO0Oo.position();
            this.OooO0Oo.position(iPosition);
            OooOOOO((iPosition2 - iPosition) - iOooO0Oo);
            this.OooO0Oo.position(iPosition2);
        } catch (BufferOverflowException e) {
            OooO00o oooO00o = new OooO00o(this.OooO0Oo.position(), this.OooO0Oo.limit());
            oooO00o.initCause(e);
            throw oooO00o;
        }
    }

    public void OooO0O0(boolean z) throws IOException {
        OooOOO0(z ? 1 : 0);
    }

    public void OooO0O0(byte[] bArr, int i, int i2) throws IOException {
        if (this.OooO0Oo.remaining() < i2) {
            throw new OooO00o(this.OooO0Oo.position(), this.OooO0Oo.limit());
        }
        this.OooO0Oo.put(bArr, i, i2);
    }

    public void OooO0OO() {
        this.OooO0Oo.clear();
    }

    public void OooO0OO(int i, oOo0000O ooo0000o) throws IOException {
        OooOO0o(i, 3);
        OooO0OO(ooo0000o);
        OooOO0o(i, 4);
    }

    public void OooO0OO(oOo0000O ooo0000o) throws IOException {
        ooo0000o.OooO00o(this);
    }

    public void OooO0OO(byte[] bArr) throws IOException {
        OooOOOO(bArr.length);
        OooO0Oo(bArr);
    }

    public int OooO0Oo() {
        return this.OooO0Oo.remaining();
    }

    public void OooO0Oo(int i, oOo0000O ooo0000o) throws IOException {
        OooOO0o(i, 2);
        OooO0Oo(ooo0000o);
    }

    public void OooO0Oo(oOo0000O ooo0000o) throws IOException {
        OooOOOO(ooo0000o.OooO0OO());
        ooo0000o.OooO00o(this);
    }

    public void OooO0Oo(byte[] bArr) throws IOException {
        OooO0O0(bArr, 0, bArr.length);
    }

    public void OooO0o(int i, long j) throws IOException {
        OooOO0o(i, 1);
        OooO0oo(j);
    }

    public void OooO0oO(int i, int i2) throws IOException {
        OooOO0o(i, 0);
        OooOO0(i2);
    }

    public void OooO0oO(int i, long j) throws IOException {
        OooOO0o(i, 0);
        OooO(j);
    }

    public void OooO0oo(int i, int i2) throws IOException {
        OooOO0o(i, 5);
        OooOO0O(i2);
    }

    public void OooO0oo(int i, long j) throws IOException {
        OooOO0o(i, 1);
        OooOO0o(j);
    }

    public void OooO0oo(long j) throws IOException {
        OooOO0(j);
    }

    public void OooOO0(int i) throws IOException {
        OooOOOO(i);
    }

    public void OooOO0(int i, int i2) throws IOException {
        OooOO0o(i, 5);
        OooOOOo(i2);
    }

    public void OooOO0(int i, long j) throws IOException {
        OooOO0o(i, 0);
        OooOOO(j);
    }

    public void OooOO0(long j) throws IOException {
        if (this.OooO0Oo.remaining() < 8) {
            throw new OooO00o(this.OooO0Oo.position(), this.OooO0Oo.limit());
        }
        this.OooO0Oo.putLong(j);
    }

    public void OooOO0O(int i) throws IOException {
        OooOOO(i);
    }

    public void OooOO0O(int i, int i2) throws IOException {
        OooOO0o(i, 0);
        OooOOo0(i2);
    }

    public void OooOO0O(long j) throws IOException {
        while (((-128) & j) != 0) {
            OooOOO0((((int) j) & 127) | 128);
            j >>>= 7;
        }
        OooOOO0((int) j);
    }

    public void OooOO0o(int i) throws IOException {
        if (i >= 0) {
            OooOOOO(i);
        } else {
            OooOO0O(i);
        }
    }

    public void OooOO0o(int i, int i2) throws IOException {
        OooOOOO(oO0O000.OooO00o(i, i2));
    }

    public void OooOO0o(long j) throws IOException {
        OooOO0(j);
    }

    public void OooOOO(int i) throws IOException {
        if (this.OooO0Oo.remaining() < 4) {
            throw new OooO00o(this.OooO0Oo.position(), this.OooO0Oo.limit());
        }
        this.OooO0Oo.putInt(i);
    }

    public void OooOOO(long j) throws IOException {
        OooOO0O(j);
    }

    public void OooOOO0(int i) throws IOException {
        OooO00o((byte) i);
    }

    public void OooOOO0(int i, int i2) throws IOException {
        OooOO0o(i, 0);
        OooOOo(i2);
    }

    public void OooOOO0(long j) throws IOException {
        OooOO0O(OooO0oO(j));
    }

    public void OooOOOO(int i) throws IOException {
        while ((i & (-128)) != 0) {
            OooOOO0((i & 127) | 128);
            i >>>= 7;
        }
        OooOOO0(i);
    }

    public void OooOOOo(int i) throws IOException {
        OooOOO(i);
    }

    public void OooOOo(int i) throws IOException {
        OooOOOO(i);
    }

    public void OooOOo0(int i) throws IOException {
        OooOOOO(OooO(i));
    }
}
