package com.ubixnow.ooooo;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class oOo0000O {
    public volatile int OooO00o = -1;

    public static final <T extends oOo0000O> T OooO00o(T t, byte[] bArr) throws oO0OO00o {
        return (T) OooO00o(t, bArr, 0, bArr.length);
    }

    public static final <T extends oOo0000O> T OooO00o(T t, byte[] bArr, int i, int i2) throws oO0OO00o {
        try {
            oO00o000 oo00o000OooO00o = oO00o000.OooO00o(bArr, i, i2);
            t.OooO00o(oo00o000OooO00o);
            oo00o000OooO00o.OooO00o(0);
            return t;
        } catch (oO0OO00o e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean OooO00o(oOo0000O ooo0000o, oOo0000O ooo0000o2) {
        int iOooO0Oo;
        if (ooo0000o == ooo0000o2) {
            return true;
        }
        if (ooo0000o == null || ooo0000o2 == null || ooo0000o.getClass() != ooo0000o2.getClass() || ooo0000o2.OooO0Oo() != (iOooO0Oo = ooo0000o.OooO0Oo())) {
            return false;
        }
        byte[] bArr = new byte[iOooO0Oo];
        byte[] bArr2 = new byte[iOooO0Oo];
        OooO0O0(ooo0000o, bArr, 0, iOooO0Oo);
        OooO0O0(ooo0000o2, bArr2, 0, iOooO0Oo);
        return Arrays.equals(bArr, bArr2);
    }

    public static final byte[] OooO00o(oOo0000O ooo0000o) {
        int iOooO0Oo = ooo0000o.OooO0Oo();
        byte[] bArr = new byte[iOooO0Oo];
        OooO0O0(ooo0000o, bArr, 0, iOooO0Oo);
        return bArr;
    }

    public static final void OooO0O0(oOo0000O ooo0000o, byte[] bArr, int i, int i2) {
        try {
            oO00o00 oo00o00OooO00o = oO00o00.OooO00o(bArr, i, i2);
            ooo0000o.OooO00o(oo00o00OooO00o);
            oo00o00OooO00o.OooO00o();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
    public oOo0000O clone() throws CloneNotSupportedException {
        return (oOo0000O) super.clone();
    }

    public abstract oOo0000O OooO00o(oO00o000 oo00o000) throws IOException;

    public void OooO00o(oO00o00 oo00o00) throws IOException {
    }

    public int OooO0O0() {
        return 0;
    }

    public int OooO0OO() {
        if (this.OooO00o < 0) {
            OooO0Oo();
        }
        return this.OooO00o;
    }

    public int OooO0Oo() {
        int iOooO0O0 = OooO0O0();
        this.OooO00o = iOooO0O0;
        return iOooO0O0;
    }

    public String toString() {
        return oOo000o0.OooO00o(this);
    }
}
