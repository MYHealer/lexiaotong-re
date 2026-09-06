package com.ubixnow.ooooo;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO00OO0O extends oOo0000O {
    private static volatile oO00OO0O[] OooO0O0;
    public int OooO0OO;
    public Map<String, Integer> OooO0Oo;

    public oO00OO0O() {
        OooO0o0();
    }

    public static oO00OO0O OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO00OO0O) oOo0000O.OooO00o(new oO00OO0O(), bArr);
    }

    public static oO00OO0O OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO00OO0O().OooO00o(oo00o000);
    }

    public static oO00OO0O[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO00OO0O[0];
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
        Map<String, Integer> map = this.OooO0Oo;
        if (map != null) {
            oOo00ooO.OooO00o(oo00o00, map, 2, 9, 5);
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
        Map<String, Integer> map = this.OooO0Oo;
        return map != null ? iOooO0O0 + oOo00ooO.OooO00o(map, 2, 9, 5) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO00OO0O OooO00o(oO00o000 oo00o000) throws IOException {
        oOo000Oo.OooO0OO oooO0OOOooO00o = oOo000Oo.OooO00o();
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 8) {
                this.OooO0OO = oo00o000.OooOO0O();
            } else if (iOooOo0o == 18) {
                this.OooO0Oo = oOo00ooO.OooO00o(oo00o000, this.OooO0Oo, oooO0OOOooO00o, 9, 5, null, 10, 16);
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO00OO0O OooO0o0() {
        this.OooO0OO = 0;
        this.OooO0Oo = null;
        this.OooO00o = -1;
        return this;
    }
}
