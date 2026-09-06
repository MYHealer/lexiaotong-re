package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO00OOOo extends oOo0000O {
    private static volatile oO00OOOo[] OooO0O0;
    public String OooO0OO;
    public String OooO0Oo;
    public int OooO0o;
    public int OooO0o0;
    public oO00OOo0 OooO0oO;

    public oO00OOOo() {
        OooO0o0();
    }

    public static oO00OOOo OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO00OOOo) oOo0000O.OooO00o(new oO00OOOo(), bArr);
    }

    public static oO00OOOo OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO00OOOo().OooO00o(oo00o000);
    }

    public static oO00OOOo[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO00OOOo[0];
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
        if (!this.OooO0Oo.equals("")) {
            oo00o00.OooO0O0(2, this.OooO0Oo);
        }
        int i = this.OooO0o0;
        if (i != 0) {
            oo00o00.OooO(3, i);
        }
        int i2 = this.OooO0o;
        if (i2 != 0) {
            oo00o00.OooO(4, i2);
        }
        oO00OOo0 oo00ooo0 = this.OooO0oO;
        if (oo00ooo0 != null) {
            oo00o00.OooO0Oo(5, oo00ooo0);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        if (!this.OooO0OO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
        }
        if (!this.OooO0Oo.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(2, this.OooO0Oo);
        }
        int i = this.OooO0o0;
        if (i != 0) {
            iOooO0O0 += oO00o00.OooO0OO(3, i);
        }
        int i2 = this.OooO0o;
        if (i2 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(4, i2);
        }
        oO00OOo0 oo00ooo0 = this.OooO0oO;
        return oo00ooo0 != null ? iOooO0O0 + oO00o00.OooO0O0(5, oo00ooo0) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO00OOOo OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 10) {
                this.OooO0OO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 18) {
                this.OooO0Oo = oo00o000.OooOo0O();
            } else if (iOooOo0o == 24) {
                this.OooO0o0 = oo00o000.OooOO0O();
            } else if (iOooOo0o == 32) {
                this.OooO0o = oo00o000.OooOO0O();
            } else if (iOooOo0o == 42) {
                if (this.OooO0oO == null) {
                    this.OooO0oO = new oO00OOo0();
                }
                oo00o000.OooO00o(this.OooO0oO);
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO00OOOo OooO0o0() {
        this.OooO0OO = "";
        this.OooO0Oo = "";
        this.OooO0o0 = 0;
        this.OooO0o = 0;
        this.OooO0oO = null;
        this.OooO00o = -1;
        return this;
    }
}
