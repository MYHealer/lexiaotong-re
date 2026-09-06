package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O0 extends oOo0000O {
    private static volatile oO0O0[] OooO0O0;
    public int OooO0OO;
    public OooO00o OooO0Oo;
    public String[] OooO0o0;

    public static final class OooO00o extends oOo0000O {
        private static volatile OooO00o[] OooO0O0;
        public int OooO0OO;
        public int OooO0Oo;

        public OooO00o() {
            OooO0o0();
        }

        public static OooO00o OooO00o(byte[] bArr) throws oO0OO00o {
            return (OooO00o) oOo0000O.OooO00o(new OooO00o(), bArr);
        }

        public static OooO00o OooO0OO(oO00o000 oo00o000) throws IOException {
            return new OooO00o().OooO00o(oo00o000);
        }

        public static OooO00o[] OooO0o() {
            if (OooO0O0 == null) {
                synchronized (oOo00ooO.OooOo0) {
                    if (OooO0O0 == null) {
                        OooO0O0 = new OooO00o[0];
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
            int i2 = this.OooO0Oo;
            if (i2 != 0) {
                oo00o00.OooO(2, i2);
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
            int i2 = this.OooO0Oo;
            return i2 != 0 ? iOooO0O0 + oO00o00.OooO0OO(2, i2) : iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
        public OooO00o OooO00o(oO00o000 oo00o000) throws IOException {
            while (true) {
                int iOooOo0o = oo00o000.OooOo0o();
                if (iOooOo0o == 0) {
                    return this;
                }
                if (iOooOo0o == 8) {
                    this.OooO0OO = oo00o000.OooOO0O();
                } else if (iOooOo0o == 16) {
                    this.OooO0Oo = oo00o000.OooOO0O();
                } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                    return this;
                }
            }
        }

        public OooO00o OooO0o0() {
            this.OooO0OO = 0;
            this.OooO0Oo = 0;
            this.OooO00o = -1;
            return this;
        }
    }

    public oO0O0() {
        OooO0o0();
    }

    public static oO0O0 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0O0) oOo0000O.OooO00o(new oO0O0(), bArr);
    }

    public static oO0O0 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0O0().OooO00o(oo00o000);
    }

    public static oO0O0[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0O0[0];
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
        OooO00o oooO00o = this.OooO0Oo;
        if (oooO00o != null) {
            oo00o00.OooO0Oo(2, oooO00o);
        }
        String[] strArr = this.OooO0o0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.OooO0o0;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    oo00o00.OooO0O0(3, str);
                }
                i2++;
            }
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
        OooO00o oooO00o = this.OooO0Oo;
        if (oooO00o != null) {
            iOooO0O0 += oO00o00.OooO0O0(2, oooO00o);
        }
        String[] strArr = this.OooO0o0;
        if (strArr == null || strArr.length <= 0) {
            return iOooO0O0;
        }
        int i2 = 0;
        int iOooO00o = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.OooO0o0;
            if (i2 >= strArr2.length) {
                return iOooO0O0 + iOooO00o + i3;
            }
            String str = strArr2[i2];
            if (str != null) {
                i3++;
                iOooO00o += oO00o00.OooO00o(str);
            }
            i2++;
        }
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0O0 OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 8) {
                this.OooO0OO = oo00o000.OooOO0O();
            } else if (iOooOo0o == 18) {
                if (this.OooO0Oo == null) {
                    this.OooO0Oo = new OooO00o();
                }
                oo00o000.OooO00o(this.OooO0Oo);
            } else if (iOooOo0o == 26) {
                int iOooO00o = oO0O000.OooO00o(oo00o000, 26);
                String[] strArr = this.OooO0o0;
                int length = strArr == null ? 0 : strArr.length;
                int i = iOooO00o + length;
                String[] strArr2 = new String[i];
                if (length != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length);
                }
                while (length < i - 1) {
                    strArr2[length] = oo00o000.OooOo0O();
                    oo00o000.OooOo0o();
                    length++;
                }
                strArr2[length] = oo00o000.OooOo0O();
                this.OooO0o0 = strArr2;
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO0O0 OooO0o0() {
        this.OooO0OO = 0;
        this.OooO0Oo = null;
        this.OooO0o0 = oO0O000.OooOOO;
        this.OooO00o = -1;
        return this;
    }
}
