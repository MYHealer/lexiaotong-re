package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0o0o extends oOo0000O {
    private static volatile oO0o0o[] OooO0O0;
    public boolean OooO;
    public String OooO0OO;
    public int OooO0Oo;
    public String OooO0o;
    public long OooO0o0;
    public int OooO0oO;
    public long OooO0oo;
    public String OooOO0;
    public long OooOO0O;

    public oO0o0o() {
        OooO0o0();
    }

    public static oO0o0o OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0o0o) oOo0000O.OooO00o(new oO0o0o(), bArr);
    }

    public static oO0o0o OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0o0o().OooO00o(oo00o000);
    }

    public static oO0o0o[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0o0o[0];
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
        int i = this.OooO0Oo;
        if (i != 0) {
            oo00o00.OooO(2, i);
        }
        long j = this.OooO0o0;
        if (j != 0) {
            oo00o00.OooOO0(3, j);
        }
        if (!this.OooO0o.equals("")) {
            oo00o00.OooO0O0(4, this.OooO0o);
        }
        int i2 = this.OooO0oO;
        if (i2 != 0) {
            oo00o00.OooO(5, i2);
        }
        long j2 = this.OooO0oo;
        if (j2 != 0) {
            oo00o00.OooO0oO(6, j2);
        }
        boolean z = this.OooO;
        if (z) {
            oo00o00.OooO0O0(7, z);
        }
        if (!this.OooOO0.equals("")) {
            oo00o00.OooO0O0(8, this.OooOO0);
        }
        long j3 = this.OooOO0O;
        if (j3 != 0) {
            oo00o00.OooOO0(9, j3);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        if (!this.OooO0OO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
        }
        int i = this.OooO0Oo;
        if (i != 0) {
            iOooO0O0 += oO00o00.OooO0OO(2, i);
        }
        long j = this.OooO0o0;
        if (j != 0) {
            iOooO0O0 += oO00o00.OooO0o0(3, j);
        }
        if (!this.OooO0o.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(4, this.OooO0o);
        }
        int i2 = this.OooO0oO;
        if (i2 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(5, i2);
        }
        long j2 = this.OooO0oo;
        if (j2 != 0) {
            iOooO0O0 += oO00o00.OooO0O0(6, j2);
        }
        boolean z = this.OooO;
        if (z) {
            iOooO0O0 += oO00o00.OooO00o(7, z);
        }
        if (!this.OooOO0.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(8, this.OooOO0);
        }
        long j3 = this.OooOO0O;
        return j3 != 0 ? iOooO0O0 + oO00o00.OooO0o0(9, j3) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0o0o OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 10) {
                this.OooO0OO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 16) {
                this.OooO0Oo = oo00o000.OooOO0O();
            } else if (iOooOo0o == 24) {
                this.OooO0o0 = oo00o000.OooOoO0();
            } else if (iOooOo0o == 34) {
                this.OooO0o = oo00o000.OooOo0O();
            } else if (iOooOo0o == 40) {
                this.OooO0oO = oo00o000.OooOO0O();
            } else if (iOooOo0o == 48) {
                this.OooO0oo = oo00o000.OooOO0o();
            } else if (iOooOo0o == 56) {
                this.OooO = oo00o000.OooO0Oo();
            } else if (iOooOo0o == 66) {
                this.OooOO0 = oo00o000.OooOo0O();
            } else if (iOooOo0o == 72) {
                this.OooOO0O = oo00o000.OooOoO0();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO0o0o OooO0o0() {
        this.OooO0OO = "";
        this.OooO0Oo = 0;
        this.OooO0o0 = 0L;
        this.OooO0o = "";
        this.OooO0oO = 0;
        this.OooO0oo = 0L;
        this.OooO = false;
        this.OooOO0 = "";
        this.OooOO0O = 0L;
        this.OooO00o = -1;
        return this;
    }
}
