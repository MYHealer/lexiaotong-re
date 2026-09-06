package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO000Oo extends oOo0000O {
    private static volatile oO000Oo[] OooO0O0;
    public long OooO0OO;
    public String OooO0Oo;
    public long OooO0o0;

    public oO000Oo() {
        OooO0o0();
    }

    public static oO000Oo OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO000Oo) oOo0000O.OooO00o(new oO000Oo(), bArr);
    }

    public static oO000Oo OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO000Oo().OooO00o(oo00o000);
    }

    public static oO000Oo[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO000Oo[0];
                }
            }
        }
        return OooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        long j = this.OooO0OO;
        if (j != 0) {
            oo00o00.OooO0oO(1, j);
        }
        if (!this.OooO0Oo.equals("")) {
            oo00o00.OooO0O0(2, this.OooO0Oo);
        }
        long j2 = this.OooO0o0;
        if (j2 != 0) {
            oo00o00.OooO0oO(3, j2);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        long j = this.OooO0OO;
        if (j != 0) {
            iOooO0O0 += oO00o00.OooO0O0(1, j);
        }
        if (!this.OooO0Oo.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(2, this.OooO0Oo);
        }
        long j2 = this.OooO0o0;
        return j2 != 0 ? iOooO0O0 + oO00o00.OooO0O0(3, j2) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO000Oo OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 8) {
                this.OooO0OO = oo00o000.OooOO0o();
            } else if (iOooOo0o == 18) {
                this.OooO0Oo = oo00o000.OooOo0O();
            } else if (iOooOo0o == 24) {
                this.OooO0o0 = oo00o000.OooOO0o();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO000Oo OooO0o0() {
        this.OooO0OO = 0L;
        this.OooO0Oo = "";
        this.OooO0o0 = 0L;
        this.OooO00o = -1;
        return this;
    }
}
