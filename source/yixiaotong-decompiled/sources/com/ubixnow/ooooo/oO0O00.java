package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O00 extends oOo0000O {
    private static volatile oO0O00[] OooO0O0;
    public int OooO0OO;
    public oO0O000o[] OooO0Oo;
    public String OooO0o;
    public boolean OooO0o0;

    public oO0O00() {
        OooO0o0();
    }

    public static oO0O00 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0O00) oOo0000O.OooO00o(new oO0O00(), bArr);
    }

    public static oO0O00 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0O00().OooO00o(oo00o000);
    }

    public static oO0O00[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0O00[0];
                }
            }
        }
        return OooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        int i = this.OooO0OO;
        if (i != 0) {
            oo00o00.OooO(1, i);
        }
        oO0O000o[] oo0o000oArr = this.OooO0Oo;
        if (oo0o000oArr != null && oo0o000oArr.length > 0) {
            int i2 = 0;
            while (true) {
                oO0O000o[] oo0o000oArr2 = this.OooO0Oo;
                if (i2 >= oo0o000oArr2.length) {
                    break;
                }
                oO0O000o oo0o000o = oo0o000oArr2[i2];
                if (oo0o000o != null) {
                    oo00o00.OooO0Oo(2, oo0o000o);
                }
                i2++;
            }
        }
        boolean z = this.OooO0o0;
        if (z) {
            oo00o00.OooO0O0(3, z);
        }
        if (!this.OooO0o.equals("")) {
            oo00o00.OooO0O0(4, this.OooO0o);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        int i = this.OooO0OO;
        if (i != 0) {
            iOooO0O0 += oO00o00.OooO0OO(1, i);
        }
        oO0O000o[] oo0o000oArr = this.OooO0Oo;
        if (oo0o000oArr != null && oo0o000oArr.length > 0) {
            int i2 = 0;
            while (true) {
                oO0O000o[] oo0o000oArr2 = this.OooO0Oo;
                if (i2 >= oo0o000oArr2.length) {
                    break;
                }
                oO0O000o oo0o000o = oo0o000oArr2[i2];
                if (oo0o000o != null) {
                    iOooO0O0 += oO00o00.OooO0O0(2, oo0o000o);
                }
                i2++;
            }
        }
        boolean z = this.OooO0o0;
        if (z) {
            iOooO0O0 += oO00o00.OooO00o(3, z);
        }
        return !this.OooO0o.equals("") ? iOooO0O0 + oO00o00.OooO00o(4, this.OooO0o) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0O00 OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 8) {
                this.OooO0OO = oo00o000.OooOO0O();
            } else if (iOooOo0o == 18) {
                int iOooO00o = oO0O000.OooO00o(oo00o000, 18);
                oO0O000o[] oo0o000oArr = this.OooO0Oo;
                int length = oo0o000oArr == null ? 0 : oo0o000oArr.length;
                int i = iOooO00o + length;
                oO0O000o[] oo0o000oArr2 = new oO0O000o[i];
                if (length != 0) {
                    System.arraycopy(oo0o000oArr, 0, oo0o000oArr2, 0, length);
                }
                while (length < i - 1) {
                    oO0O000o oo0o000o = new oO0O000o();
                    oo0o000oArr2[length] = oo0o000o;
                    oo00o000.OooO00o(oo0o000o);
                    oo00o000.OooOo0o();
                    length++;
                }
                oO0O000o oo0o000o2 = new oO0O000o();
                oo0o000oArr2[length] = oo0o000o2;
                oo00o000.OooO00o(oo0o000o2);
                this.OooO0Oo = oo0o000oArr2;
            } else if (iOooOo0o == 24) {
                this.OooO0o0 = oo00o000.OooO0Oo();
            } else if (iOooOo0o == 34) {
                this.OooO0o = oo00o000.OooOo0O();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO0O00 OooO0o0() {
        this.OooO0OO = 0;
        this.OooO0Oo = oO0O000o.OooO0o();
        this.OooO0o0 = false;
        this.OooO0o = "";
        this.OooO00o = -1;
        return this;
    }
}
