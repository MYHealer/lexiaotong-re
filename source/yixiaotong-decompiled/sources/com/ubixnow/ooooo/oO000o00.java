package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO000o00 extends oOo0000O {
    private static volatile oO000o00[] OooO0O0;
    public oO0OOo0o[] OooO0OO;

    public oO000o00() {
        OooO0o0();
    }

    public static oO000o00 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO000o00) oOo0000O.OooO00o(new oO000o00(), bArr);
    }

    public static oO000o00 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO000o00().OooO00o(oo00o000);
    }

    public static oO000o00[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO000o00[0];
                }
            }
        }
        return OooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        oO0OOo0o[] oo0ooo0oArr = this.OooO0OO;
        if (oo0ooo0oArr != null && oo0ooo0oArr.length > 0) {
            int i = 0;
            while (true) {
                oO0OOo0o[] oo0ooo0oArr2 = this.OooO0OO;
                if (i >= oo0ooo0oArr2.length) {
                    break;
                }
                oO0OOo0o oo0ooo0o = oo0ooo0oArr2[i];
                if (oo0ooo0o != null) {
                    oo00o00.OooO0Oo(1, oo0ooo0o);
                }
                i++;
            }
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        oO0OOo0o[] oo0ooo0oArr = this.OooO0OO;
        if (oo0ooo0oArr != null && oo0ooo0oArr.length > 0) {
            int i = 0;
            while (true) {
                oO0OOo0o[] oo0ooo0oArr2 = this.OooO0OO;
                if (i >= oo0ooo0oArr2.length) {
                    break;
                }
                oO0OOo0o oo0ooo0o = oo0ooo0oArr2[i];
                if (oo0ooo0o != null) {
                    iOooO0O0 += oO00o00.OooO0O0(1, oo0ooo0o);
                }
                i++;
            }
        }
        return iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO000o00 OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 10) {
                int iOooO00o = oO0O000.OooO00o(oo00o000, 10);
                oO0OOo0o[] oo0ooo0oArr = this.OooO0OO;
                int length = oo0ooo0oArr == null ? 0 : oo0ooo0oArr.length;
                int i = iOooO00o + length;
                oO0OOo0o[] oo0ooo0oArr2 = new oO0OOo0o[i];
                if (length != 0) {
                    System.arraycopy(oo0ooo0oArr, 0, oo0ooo0oArr2, 0, length);
                }
                while (length < i - 1) {
                    oO0OOo0o oo0ooo0o = new oO0OOo0o();
                    oo0ooo0oArr2[length] = oo0ooo0o;
                    oo00o000.OooO00o(oo0ooo0o);
                    oo00o000.OooOo0o();
                    length++;
                }
                oO0OOo0o oo0ooo0o2 = new oO0OOo0o();
                oo0ooo0oArr2[length] = oo0ooo0o2;
                oo00o000.OooO00o(oo0ooo0o2);
                this.OooO0OO = oo0ooo0oArr2;
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO000o00 OooO0o0() {
        this.OooO0OO = oO0OOo0o.OooO0o();
        this.OooO00o = -1;
        return this;
    }
}
