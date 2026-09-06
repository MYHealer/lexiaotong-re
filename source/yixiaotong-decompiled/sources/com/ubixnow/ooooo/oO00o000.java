package com.ubixnow.ooooo;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO00o000 {
    private static final int OooO00o = 64;
    private static final int OooO0O0 = 67108864;
    private final byte[] OooO0OO;
    private int OooO0Oo;
    private int OooO0o;
    private int OooO0o0;
    private int OooO0oO;
    private int OooO0oo;
    private int OooOO0;
    private int OooO = Integer.MAX_VALUE;
    private int OooOO0O = 64;
    private int OooOO0o = 67108864;

    private oO00o000(byte[] bArr, int i, int i2) {
        this.OooO0OO = bArr;
        this.OooO0Oo = i;
        this.OooO0o0 = i2 + i;
        this.OooO0oO = i;
    }

    public static long OooO00o(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static oO00o000 OooO00o(byte[] bArr) {
        return OooO00o(bArr, 0, bArr.length);
    }

    public static oO00o000 OooO00o(byte[] bArr, int i, int i2) {
        return new oO00o000(bArr, i, i2);
    }

    public static int OooO0O0(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    private void OooOoO() {
        int i = this.OooO0o0 + this.OooO0o;
        this.OooO0o0 = i;
        int i2 = this.OooO;
        if (i <= i2) {
            this.OooO0o = 0;
            return;
        }
        int i3 = i - i2;
        this.OooO0o = i3;
        this.OooO0o0 = i - i3;
    }

    public int OooO(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + i);
        }
        int i2 = this.OooOO0o;
        this.OooOO0o = i;
        return i2;
    }

    public long OooO() throws IOException {
        return OooOOOO();
    }

    public int OooO00o() {
        int i = this.OooO;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.OooO0oO;
    }

    public void OooO00o(int i) throws oO0OO00o {
        if (this.OooO0oo != i) {
            throw oO0OO00o.OooO00o();
        }
    }

    public void OooO00o(oOo0000O ooo0000o) throws IOException {
        int iOooOOOo = OooOOOo();
        if (this.OooOO0 >= this.OooOO0O) {
            throw oO0OO00o.OooO0o();
        }
        int iOooO0Oo = OooO0Oo(iOooOOOo);
        this.OooOO0++;
        ooo0000o.OooO00o(this);
        OooO00o(0);
        this.OooOO0--;
        OooO0OO(iOooO0Oo);
    }

    public void OooO00o(oOo0000O ooo0000o, int i) throws IOException {
        int i2 = this.OooOO0;
        if (i2 >= this.OooOO0O) {
            throw oO0OO00o.OooO0o();
        }
        this.OooOO0 = i2 + 1;
        ooo0000o.OooO00o(this);
        OooO00o(oO0O000.OooO00o(i, 4));
        this.OooOO0--;
    }

    public byte[] OooO00o(int i, int i2) {
        if (i2 == 0) {
            return oO0O000.OooOOOo;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.OooO0OO, this.OooO0Oo + i, bArr, 0, i2);
        return bArr;
    }

    public int OooO0O0() {
        return this.OooO0oO - this.OooO0Oo;
    }

    public void OooO0OO(int i) {
        this.OooO = i;
        OooOoO();
    }

    public boolean OooO0OO() {
        return this.OooO0oO == this.OooO0o0;
    }

    public int OooO0Oo(int i) throws oO0OO00o {
        if (i < 0) {
            throw oO0OO00o.OooO0o0();
        }
        int i2 = i + this.OooO0oO;
        int i3 = this.OooO;
        if (i2 > i3) {
            throw oO0OO00o.OooO0oo();
        }
        this.OooO = i2;
        OooOoO();
        return i3;
    }

    public boolean OooO0Oo() throws IOException {
        return OooOOOo() != 0;
    }

    public double OooO0o() throws IOException {
        return Double.longBitsToDouble(OooOOOO());
    }

    public byte[] OooO0o(int i) throws IOException {
        if (i < 0) {
            throw oO0OO00o.OooO0o0();
        }
        int i2 = this.OooO0oO;
        int i3 = i2 + i;
        int i4 = this.OooO;
        if (i3 > i4) {
            OooOO0O(i4 - i2);
            throw oO0OO00o.OooO0oo();
        }
        if (i > this.OooO0o0 - i2) {
            throw oO0OO00o.OooO0oo();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.OooO0OO, i2, bArr, 0, i);
        this.OooO0oO += i;
        return bArr;
    }

    public Object OooO0o0(int i) throws IOException {
        switch (i) {
            case 1:
                return Double.valueOf(OooO0o());
            case 2:
                return Float.valueOf(OooOO0());
            case 3:
                return Long.valueOf(OooOO0o());
            case 4:
                return Long.valueOf(OooOoO0());
            case 5:
                return Integer.valueOf(OooOO0O());
            case 6:
                return Long.valueOf(OooO());
            case 7:
                return Integer.valueOf(OooO0oo());
            case 8:
                return Boolean.valueOf(OooO0Oo());
            case 9:
                return OooOo0O();
            case 10:
            case 11:
            default:
                throw new IllegalArgumentException("Unknown type " + i);
            case 12:
                return OooO0o0();
            case 13:
                return Integer.valueOf(OooOo());
            case 14:
                return Integer.valueOf(OooO0oO());
            case 15:
                return Integer.valueOf(OooOOo());
            case 16:
                return Long.valueOf(OooOOoo());
            case 17:
                return Integer.valueOf(OooOo00());
            case 18:
                return Long.valueOf(OooOo0());
        }
    }

    public byte[] OooO0o0() throws IOException {
        int iOooOOOo = OooOOOo();
        int i = this.OooO0o0;
        int i2 = this.OooO0oO;
        if (iOooOOOo > i - i2 || iOooOOOo <= 0) {
            return iOooOOOo == 0 ? oO0O000.OooOOOo : OooO0o(iOooOOOo);
        }
        byte[] bArr = new byte[iOooOOOo];
        System.arraycopy(this.OooO0OO, i2, bArr, 0, iOooOOOo);
        this.OooO0oO += iOooOOOo;
        return bArr;
    }

    public int OooO0oO() throws IOException {
        return OooOOOo();
    }

    public void OooO0oO(int i) {
        int i2 = this.OooO0oO;
        int i3 = this.OooO0Oo;
        if (i > i2 - i3) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.OooO0oO - this.OooO0Oo));
        }
        if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        }
        this.OooO0oO = i3 + i;
    }

    public int OooO0oo() throws IOException {
        return OooOOO();
    }

    public int OooO0oo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
        }
        int i2 = this.OooOO0O;
        this.OooOO0O = i;
        return i2;
    }

    public float OooOO0() throws IOException {
        return Float.intBitsToFloat(OooOOO());
    }

    public boolean OooOO0(int i) throws IOException {
        int iOooO0O0 = oO0O000.OooO0O0(i);
        if (iOooO0O0 == 0) {
            OooOO0O();
            return true;
        }
        if (iOooO0O0 == 1) {
            OooOOOO();
            return true;
        }
        if (iOooO0O0 == 2) {
            OooOO0O(OooOOOo());
            return true;
        }
        if (iOooO0O0 == 3) {
            OooOoo0();
            OooO00o(oO0O000.OooO00o(oO0O000.OooO00o(i), 4));
            return true;
        }
        if (iOooO0O0 == 4) {
            return false;
        }
        if (iOooO0O0 != 5) {
            throw oO0OO00o.OooO0OO();
        }
        OooOOO();
        return true;
    }

    public int OooOO0O() throws IOException {
        return OooOOOo();
    }

    public void OooOO0O(int i) throws IOException {
        if (i < 0) {
            throw oO0OO00o.OooO0o0();
        }
        int i2 = this.OooO0oO;
        int i3 = i2 + i;
        int i4 = this.OooO;
        if (i3 > i4) {
            OooOO0O(i4 - i2);
            throw oO0OO00o.OooO0oo();
        }
        if (i > this.OooO0o0 - i2) {
            throw oO0OO00o.OooO0oo();
        }
        this.OooO0oO = i3;
    }

    public long OooOO0o() throws IOException {
        return OooOOo0();
    }

    public int OooOOO() throws IOException {
        return (OooOOO0() & 255) | ((OooOOO0() & 255) << 8) | ((OooOOO0() & 255) << 16) | ((OooOOO0() & 255) << 24);
    }

    public byte OooOOO0() throws IOException {
        int i = this.OooO0oO;
        if (i == this.OooO0o0) {
            throw oO0OO00o.OooO0oo();
        }
        byte[] bArr = this.OooO0OO;
        this.OooO0oO = i + 1;
        return bArr[i];
    }

    public long OooOOOO() throws IOException {
        byte bOooOOO0 = OooOOO0();
        return ((((long) OooOOO0()) & 255) << 8) | (((long) bOooOOO0) & 255) | ((((long) OooOOO0()) & 255) << 16) | ((((long) OooOOO0()) & 255) << 24) | ((((long) OooOOO0()) & 255) << 32) | ((((long) OooOOO0()) & 255) << 40) | ((((long) OooOOO0()) & 255) << 48) | ((((long) OooOOO0()) & 255) << 56);
    }

    public int OooOOOo() throws IOException {
        int i;
        byte bOooOOO0 = OooOOO0();
        if (bOooOOO0 >= 0) {
            return bOooOOO0;
        }
        int i2 = bOooOOO0 & 127;
        byte bOooOOO1 = OooOOO0();
        if (bOooOOO1 >= 0) {
            i = bOooOOO1 << 7;
        } else {
            i2 |= (bOooOOO1 & 127) << 7;
            byte bOooOOO2 = OooOOO0();
            if (bOooOOO2 >= 0) {
                i = bOooOOO2 << 14;
            } else {
                i2 |= (bOooOOO2 & 127) << 14;
                byte bOooOOO3 = OooOOO0();
                if (bOooOOO3 < 0) {
                    int i3 = i2 | ((bOooOOO3 & 127) << 21);
                    byte bOooOOO4 = OooOOO0();
                    int i4 = i3 | (bOooOOO4 << Ascii.FS);
                    if (bOooOOO4 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (OooOOO0() >= 0) {
                            return i4;
                        }
                    }
                    throw oO0OO00o.OooO0Oo();
                }
                i = bOooOOO3 << Ascii.NAK;
            }
        }
        return i2 | i;
    }

    public int OooOOo() throws IOException {
        return OooOOO();
    }

    public long OooOOo0() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bOooOOO0 = OooOOO0();
            j |= ((long) (bOooOOO0 & 127)) << i;
            if ((bOooOOO0 & 128) == 0) {
                return j;
            }
        }
        throw oO0OO00o.OooO0Oo();
    }

    public long OooOOoo() throws IOException {
        return OooOOOO();
    }

    public int OooOo() throws IOException {
        return OooOOOo();
    }

    public long OooOo0() throws IOException {
        return OooO00o(OooOOo0());
    }

    public int OooOo00() throws IOException {
        return OooO0O0(OooOOOo());
    }

    public String OooOo0O() throws IOException {
        int iOooOOOo = OooOOOo();
        if (iOooOOOo > this.OooO0o0 - this.OooO0oO || iOooOOOo <= 0) {
            return new String(OooO0o(iOooOOOo), oOo00ooO.OooOOoo);
        }
        String str = new String(this.OooO0OO, this.OooO0oO, iOooOOOo, oOo00ooO.OooOOoo);
        this.OooO0oO += iOooOOOo;
        return str;
    }

    public int OooOo0o() throws IOException {
        if (OooO0OO()) {
            this.OooO0oo = 0;
            return 0;
        }
        int iOooOOOo = OooOOOo();
        this.OooO0oo = iOooOOOo;
        if (iOooOOOo != 0) {
            return iOooOOOo;
        }
        throw oO0OO00o.OooO0O0();
    }

    public long OooOoO0() throws IOException {
        return OooOOo0();
    }

    public void OooOoOO() {
    }

    public void OooOoo0() throws IOException {
        int iOooOo0o;
        do {
            iOooOo0o = OooOo0o();
            if (iOooOo0o == 0) {
                return;
            }
        } while (OooOO0(iOooOo0o));
    }
}
