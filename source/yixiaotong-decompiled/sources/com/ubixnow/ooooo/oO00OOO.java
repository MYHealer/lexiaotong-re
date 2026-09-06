package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO00OOO extends oOo0000O {
    private static volatile oO00OOO[] OooO0O0;
    public String OooO0OO;
    public String OooO0Oo;
    public String OooO0o;
    public int OooO0o0;

    public oO00OOO() {
        OooO0o0();
    }

    public static oO00OOO OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO00OOO) oOo0000O.OooO00o(new oO00OOO(), bArr);
    }

    public static oO00OOO OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO00OOO().OooO00o(oo00o000);
    }

    public static oO00OOO[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO00OOO[0];
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
        if (!this.OooO0o.equals("")) {
            oo00o00.OooO0O0(4, this.OooO0o);
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
        return !this.OooO0o.equals("") ? iOooO0O0 + oO00o00.OooO00o(4, this.OooO0o) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO00OOO OooO00o(oO00o000 oo00o000) throws IOException {
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
            } else if (iOooOo0o == 34) {
                this.OooO0o = oo00o000.OooOo0O();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO00OOO OooO0o0() {
        this.OooO0OO = "";
        this.OooO0Oo = "";
        this.OooO0o0 = 0;
        this.OooO0o = "";
        this.OooO00o = -1;
        return this;
    }
}
