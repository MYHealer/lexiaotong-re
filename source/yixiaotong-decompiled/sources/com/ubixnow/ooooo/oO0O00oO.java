package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O00oO extends oOo0000O {
    private static volatile oO0O00oO[] OooO0O0;
    public oO0O0O00 OooO0OO;
    public oO0O00O OooO0Oo;
    public oO0O00 OooO0o;
    public long OooO0o0;

    public oO0O00oO() {
        OooO0o0();
    }

    public static oO0O00oO OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0O00oO) oOo0000O.OooO00o(new oO0O00oO(), bArr);
    }

    public static oO0O00oO OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0O00oO().OooO00o(oo00o000);
    }

    public static oO0O00oO[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0O00oO[0];
                }
            }
        }
        return OooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        oO0O0O00 oo0o0o00 = this.OooO0OO;
        if (oo0o0o00 != null) {
            oo00o00.OooO0Oo(1, oo0o0o00);
        }
        oO0O00O oo0o00o = this.OooO0Oo;
        if (oo0o00o != null) {
            oo00o00.OooO0Oo(2, oo0o00o);
        }
        long j = this.OooO0o0;
        if (j != 0) {
            oo00o00.OooO0oO(3, j);
        }
        oO0O00 oo0o00 = this.OooO0o;
        if (oo0o00 != null) {
            oo00o00.OooO0Oo(4, oo0o00);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        oO0O0O00 oo0o0o00 = this.OooO0OO;
        if (oo0o0o00 != null) {
            iOooO0O0 += oO00o00.OooO0O0(1, oo0o0o00);
        }
        oO0O00O oo0o00o = this.OooO0Oo;
        if (oo0o00o != null) {
            iOooO0O0 += oO00o00.OooO0O0(2, oo0o00o);
        }
        long j = this.OooO0o0;
        if (j != 0) {
            iOooO0O0 += oO00o00.OooO0O0(3, j);
        }
        oO0O00 oo0o00 = this.OooO0o;
        return oo0o00 != null ? iOooO0O0 + oO00o00.OooO0O0(4, oo0o00) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0O00oO OooO00o(oO00o000 oo00o000) throws IOException {
        oOo0000O ooo0000o;
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 10) {
                if (this.OooO0OO == null) {
                    this.OooO0OO = new oO0O0O00();
                }
                ooo0000o = this.OooO0OO;
            } else if (iOooOo0o == 18) {
                if (this.OooO0Oo == null) {
                    this.OooO0Oo = new oO0O00O();
                }
                ooo0000o = this.OooO0Oo;
            } else if (iOooOo0o == 24) {
                this.OooO0o0 = oo00o000.OooOO0o();
            } else if (iOooOo0o == 34) {
                if (this.OooO0o == null) {
                    this.OooO0o = new oO0O00();
                }
                ooo0000o = this.OooO0o;
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
            oo00o000.OooO00o(ooo0000o);
        }
    }

    public oO0O00oO OooO0o0() {
        this.OooO0OO = null;
        this.OooO0Oo = null;
        this.OooO0o0 = 0L;
        this.OooO0o = null;
        this.OooO00o = -1;
        return this;
    }
}
