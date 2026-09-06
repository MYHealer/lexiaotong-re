package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0Oo0oo extends oOo0000O {
    private static volatile oO0Oo0oo[] OooO0O0;
    public String OooO;
    public String OooO0OO;
    public oO0o0o[] OooO0Oo;
    public long OooO0o;
    public long OooO0o0;
    public String OooO0oO;
    public int OooO0oo;
    public String OooOO0;

    public oO0Oo0oo() {
        OooO0o0();
    }

    public static oO0Oo0oo OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0Oo0oo) oOo0000O.OooO00o(new oO0Oo0oo(), bArr);
    }

    public static oO0Oo0oo OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0Oo0oo().OooO00o(oo00o000);
    }

    public static oO0Oo0oo[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0Oo0oo[0];
                }
            }
        }
        return OooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        if (!this.OooO0OO.equals("")) {
            oo00o00.OooO0O0(1, this.OooO0OO);
        }
        oO0o0o[] oo0o0oArr = this.OooO0Oo;
        if (oo0o0oArr != null && oo0o0oArr.length > 0) {
            int i = 0;
            while (true) {
                oO0o0o[] oo0o0oArr2 = this.OooO0Oo;
                if (i >= oo0o0oArr2.length) {
                    break;
                }
                oO0o0o oo0o0o = oo0o0oArr2[i];
                if (oo0o0o != null) {
                    oo00o00.OooO0Oo(2, oo0o0o);
                }
                i++;
            }
        }
        long j = this.OooO0o0;
        if (j != 0) {
            oo00o00.OooO0oO(3, j);
        }
        long j2 = this.OooO0o;
        if (j2 != 0) {
            oo00o00.OooO0oO(4, j2);
        }
        if (!this.OooO0oO.equals("")) {
            oo00o00.OooO0O0(6, this.OooO0oO);
        }
        int i2 = this.OooO0oo;
        if (i2 != 0) {
            oo00o00.OooO(7, i2);
        }
        if (!this.OooO.equals("")) {
            oo00o00.OooO0O0(8, this.OooO);
        }
        if (!this.OooOO0.equals("")) {
            oo00o00.OooO0O0(9, this.OooOO0);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        if (!this.OooO0OO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
        }
        oO0o0o[] oo0o0oArr = this.OooO0Oo;
        if (oo0o0oArr != null && oo0o0oArr.length > 0) {
            int i = 0;
            while (true) {
                oO0o0o[] oo0o0oArr2 = this.OooO0Oo;
                if (i >= oo0o0oArr2.length) {
                    break;
                }
                oO0o0o oo0o0o = oo0o0oArr2[i];
                if (oo0o0o != null) {
                    iOooO0O0 += oO00o00.OooO0O0(2, oo0o0o);
                }
                i++;
            }
        }
        long j = this.OooO0o0;
        if (j != 0) {
            iOooO0O0 += oO00o00.OooO0O0(3, j);
        }
        long j2 = this.OooO0o;
        if (j2 != 0) {
            iOooO0O0 += oO00o00.OooO0O0(4, j2);
        }
        if (!this.OooO0oO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(6, this.OooO0oO);
        }
        int i2 = this.OooO0oo;
        if (i2 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(7, i2);
        }
        if (!this.OooO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(8, this.OooO);
        }
        return !this.OooOO0.equals("") ? iOooO0O0 + oO00o00.OooO00o(9, this.OooOO0) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0Oo0oo OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 10) {
                this.OooO0OO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 18) {
                int iOooO00o = oO0O000.OooO00o(oo00o000, 18);
                oO0o0o[] oo0o0oArr = this.OooO0Oo;
                int length = oo0o0oArr == null ? 0 : oo0o0oArr.length;
                int i = iOooO00o + length;
                oO0o0o[] oo0o0oArr2 = new oO0o0o[i];
                if (length != 0) {
                    System.arraycopy(oo0o0oArr, 0, oo0o0oArr2, 0, length);
                }
                while (length < i - 1) {
                    oO0o0o oo0o0o = new oO0o0o();
                    oo0o0oArr2[length] = oo0o0o;
                    oo00o000.OooO00o(oo0o0o);
                    oo00o000.OooOo0o();
                    length++;
                }
                oO0o0o oo0o0o2 = new oO0o0o();
                oo0o0oArr2[length] = oo0o0o2;
                oo00o000.OooO00o(oo0o0o2);
                this.OooO0Oo = oo0o0oArr2;
            } else if (iOooOo0o == 24) {
                this.OooO0o0 = oo00o000.OooOO0o();
            } else if (iOooOo0o == 32) {
                this.OooO0o = oo00o000.OooOO0o();
            } else if (iOooOo0o == 50) {
                this.OooO0oO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 56) {
                this.OooO0oo = oo00o000.OooOO0O();
            } else if (iOooOo0o == 66) {
                this.OooO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 74) {
                this.OooOO0 = oo00o000.OooOo0O();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO0Oo0oo OooO0o0() {
        this.OooO0OO = "";
        this.OooO0Oo = oO0o0o.OooO0o();
        this.OooO0o0 = 0L;
        this.OooO0o = 0L;
        this.OooO0oO = "";
        this.OooO0oo = 0;
        this.OooO = "";
        this.OooOO0 = "";
        this.OooO00o = -1;
        return this;
    }
}
