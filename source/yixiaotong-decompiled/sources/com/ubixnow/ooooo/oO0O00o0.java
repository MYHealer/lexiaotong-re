package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O00o0 extends oOo0000O {
    private static volatile oO0O00o0[] OooO0O0;
    public boolean OooO;
    public String OooO0OO;
    public ooOOOOoo.OooO00o OooO0Oo;
    public int OooO0o;
    public ooOOOOoo.OooO0O0 OooO0o0;
    public String OooO0oO;
    public ooOOOOoo.OooO0OO[] OooO0oo;
    public String[] OooOO0;
    public ooOOOOoo.OooOO0 OooOO0O;
    public String OooOO0o;
    public String OooOOO0;

    public oO0O00o0() {
        OooO0o0();
    }

    public static oO0O00o0 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0O00o0) oOo0000O.OooO00o(new oO0O00o0(), bArr);
    }

    public static oO0O00o0 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0O00o0().OooO00o(oo00o000);
    }

    public static oO0O00o0[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0O00o0[0];
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
        ooOOOOoo.OooO00o oooO00o = this.OooO0Oo;
        if (oooO00o != null) {
            oo00o00.OooO0Oo(2, oooO00o);
        }
        ooOOOOoo.OooO0O0 oooO0O0 = this.OooO0o0;
        if (oooO0O0 != null) {
            oo00o00.OooO0Oo(3, oooO0O0);
        }
        int i = this.OooO0o;
        if (i != 0) {
            oo00o00.OooO(4, i);
        }
        if (!this.OooO0oO.equals("")) {
            oo00o00.OooO0O0(5, this.OooO0oO);
        }
        ooOOOOoo.OooO0OO[] oooO0OOArr = this.OooO0oo;
        int i2 = 0;
        if (oooO0OOArr != null && oooO0OOArr.length > 0) {
            int i3 = 0;
            while (true) {
                ooOOOOoo.OooO0OO[] oooO0OOArr2 = this.OooO0oo;
                if (i3 >= oooO0OOArr2.length) {
                    break;
                }
                ooOOOOoo.OooO0OO oooO0OO = oooO0OOArr2[i3];
                if (oooO0OO != null) {
                    oo00o00.OooO0Oo(6, oooO0OO);
                }
                i3++;
            }
        }
        boolean z = this.OooO;
        if (z) {
            oo00o00.OooO0O0(7, z);
        }
        String[] strArr = this.OooOO0;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.OooOO0;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    oo00o00.OooO0O0(8, str);
                }
                i2++;
            }
        }
        ooOOOOoo.OooOO0 oooOO0 = this.OooOO0O;
        if (oooOO0 != null) {
            oo00o00.OooO0Oo(9, oooOO0);
        }
        if (!this.OooOO0o.equals("")) {
            oo00o00.OooO0O0(10, this.OooOO0o);
        }
        if (!this.OooOOO0.equals("")) {
            oo00o00.OooO0O0(11, this.OooOOO0);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        if (!this.OooO0OO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
        }
        ooOOOOoo.OooO00o oooO00o = this.OooO0Oo;
        if (oooO00o != null) {
            iOooO0O0 += oO00o00.OooO0O0(2, oooO00o);
        }
        ooOOOOoo.OooO0O0 oooO0O0 = this.OooO0o0;
        if (oooO0O0 != null) {
            iOooO0O0 += oO00o00.OooO0O0(3, oooO0O0);
        }
        int i = this.OooO0o;
        if (i != 0) {
            iOooO0O0 += oO00o00.OooO0OO(4, i);
        }
        if (!this.OooO0oO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(5, this.OooO0oO);
        }
        ooOOOOoo.OooO0OO[] oooO0OOArr = this.OooO0oo;
        int i2 = 0;
        if (oooO0OOArr != null && oooO0OOArr.length > 0) {
            int i3 = 0;
            while (true) {
                ooOOOOoo.OooO0OO[] oooO0OOArr2 = this.OooO0oo;
                if (i3 >= oooO0OOArr2.length) {
                    break;
                }
                ooOOOOoo.OooO0OO oooO0OO = oooO0OOArr2[i3];
                if (oooO0OO != null) {
                    iOooO0O0 += oO00o00.OooO0O0(6, oooO0OO);
                }
                i3++;
            }
        }
        boolean z = this.OooO;
        if (z) {
            iOooO0O0 += oO00o00.OooO00o(7, z);
        }
        String[] strArr = this.OooOO0;
        if (strArr != null && strArr.length > 0) {
            int iOooO00o = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.OooOO0;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i4++;
                    iOooO00o += oO00o00.OooO00o(str);
                }
                i2++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o + i4;
        }
        ooOOOOoo.OooOO0 oooOO0 = this.OooOO0O;
        if (oooOO0 != null) {
            iOooO0O0 += oO00o00.OooO0O0(9, oooOO0);
        }
        if (!this.OooOO0o.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(10, this.OooOO0o);
        }
        return !this.OooOOO0.equals("") ? iOooO0O0 + oO00o00.OooO00o(11, this.OooOOO0) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0O00o0 OooO00o(oO00o000 oo00o000) throws IOException {
        oOo0000O ooo0000o;
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            switch (iOooOo0o) {
                case 0:
                    return this;
                case 10:
                    this.OooO0OO = oo00o000.OooOo0O();
                    continue;
                case 18:
                    if (this.OooO0Oo == null) {
                        this.OooO0Oo = new ooOOOOoo.OooO00o();
                    }
                    ooo0000o = this.OooO0Oo;
                    break;
                case 26:
                    if (this.OooO0o0 == null) {
                        this.OooO0o0 = new ooOOOOoo.OooO0O0();
                    }
                    ooo0000o = this.OooO0o0;
                    break;
                case 32:
                    this.OooO0o = oo00o000.OooOO0O();
                    continue;
                case 42:
                    this.OooO0oO = oo00o000.OooOo0O();
                    continue;
                case 50:
                    int iOooO00o = oO0O000.OooO00o(oo00o000, 50);
                    ooOOOOoo.OooO0OO[] oooO0OOArr = this.OooO0oo;
                    int length = oooO0OOArr == null ? 0 : oooO0OOArr.length;
                    int i = iOooO00o + length;
                    ooOOOOoo.OooO0OO[] oooO0OOArr2 = new ooOOOOoo.OooO0OO[i];
                    if (length != 0) {
                        System.arraycopy(oooO0OOArr, 0, oooO0OOArr2, 0, length);
                    }
                    while (length < i - 1) {
                        ooOOOOoo.OooO0OO oooO0OO = new ooOOOOoo.OooO0OO();
                        oooO0OOArr2[length] = oooO0OO;
                        oo00o000.OooO00o(oooO0OO);
                        oo00o000.OooOo0o();
                        length++;
                    }
                    ooOOOOoo.OooO0OO oooO0OO2 = new ooOOOOoo.OooO0OO();
                    oooO0OOArr2[length] = oooO0OO2;
                    oo00o000.OooO00o(oooO0OO2);
                    this.OooO0oo = oooO0OOArr2;
                    continue;
                case 56:
                    this.OooO = oo00o000.OooO0Oo();
                    continue;
                case 66:
                    int iOooO00o2 = oO0O000.OooO00o(oo00o000, 66);
                    String[] strArr = this.OooOO0;
                    int length2 = strArr == null ? 0 : strArr.length;
                    int i2 = iOooO00o2 + length2;
                    String[] strArr2 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr2[length2] = oo00o000.OooOo0O();
                        oo00o000.OooOo0o();
                        length2++;
                    }
                    strArr2[length2] = oo00o000.OooOo0O();
                    this.OooOO0 = strArr2;
                    continue;
                case 74:
                    if (this.OooOO0O == null) {
                        this.OooOO0O = new ooOOOOoo.OooOO0();
                    }
                    ooo0000o = this.OooOO0O;
                    break;
                case 82:
                    this.OooOO0o = oo00o000.OooOo0O();
                    continue;
                case 90:
                    this.OooOOO0 = oo00o000.OooOo0O();
                    continue;
                default:
                    if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                        return this;
                    }
                    continue;
                    break;
            }
            oo00o000.OooO00o(ooo0000o);
        }
    }

    public oO0O00o0 OooO0o0() {
        this.OooO0OO = "";
        this.OooO0Oo = null;
        this.OooO0o0 = null;
        this.OooO0o = 0;
        this.OooO0oO = "";
        this.OooO0oo = ooOOOOoo.OooO0OO.OooO0o();
        this.OooO = false;
        this.OooOO0 = oO0O000.OooOOO;
        this.OooOO0O = null;
        this.OooOO0o = "";
        this.OooOOO0 = "";
        this.OooO00o = -1;
        return this;
    }
}
