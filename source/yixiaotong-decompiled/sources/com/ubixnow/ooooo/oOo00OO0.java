package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oOo00OO0 extends oOo0000O {
    private static volatile oOo00OO0[] OooO0O0;
    public int OooO0OO;

    public oOo00OO0() {
        OooO0o0();
    }

    public static oOo00OO0 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oOo00OO0) oOo0000O.OooO00o(new oOo00OO0(), bArr);
    }

    public static oOo00OO0 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oOo00OO0().OooO00o(oo00o000);
    }

    public static oOo00OO0[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oOo00OO0[0];
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
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        int i = this.OooO0OO;
        return i != 0 ? iOooO0O0 + oO00o00.OooO0OO(1, i) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oOo00OO0 OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 8) {
                this.OooO0OO = oo00o000.OooOO0O();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oOo00OO0 OooO0o0() {
        this.OooO0OO = 0;
        this.OooO00o = -1;
        return this;
    }
}
