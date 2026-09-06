package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO00Oo0 extends oOo0000O {
    private static volatile oO00Oo0[] OooO0O0;
    public String OooO;
    public OooO00o[] OooO0OO;
    public String OooO0Oo;
    public String OooO0o;
    public String OooO0o0;
    public String OooO0oO;
    public String OooO0oo;
    public String OooOO0;
    public String OooOO0O;

    public static final class OooO00o extends oOo0000O {
        private static volatile OooO00o[] OooO0O0;
        public int OooO;
        public int OooO0OO;
        public String OooO0Oo;
        public int OooO0o;
        public String OooO0o0;
        public int OooO0oO;
        public String OooO0oo;

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
            if (!this.OooO0Oo.equals("")) {
                oo00o00.OooO0O0(2, this.OooO0Oo);
            }
            if (!this.OooO0o0.equals("")) {
                oo00o00.OooO0O0(3, this.OooO0o0);
            }
            int i2 = this.OooO0o;
            if (i2 != 0) {
                oo00o00.OooO(4, i2);
            }
            int i3 = this.OooO0oO;
            if (i3 != 0) {
                oo00o00.OooO(5, i3);
            }
            if (!this.OooO0oo.equals("")) {
                oo00o00.OooO0O0(6, this.OooO0oo);
            }
            int i4 = this.OooO;
            if (i4 != 0) {
                oo00o00.OooO(7, i4);
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
            if (!this.OooO0Oo.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(2, this.OooO0Oo);
            }
            if (!this.OooO0o0.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(3, this.OooO0o0);
            }
            int i2 = this.OooO0o;
            if (i2 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(4, i2);
            }
            int i3 = this.OooO0oO;
            if (i3 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(5, i3);
            }
            if (!this.OooO0oo.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(6, this.OooO0oo);
            }
            int i4 = this.OooO;
            return i4 != 0 ? iOooO0O0 + oO00o00.OooO0OO(7, i4) : iOooO0O0;
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
                } else if (iOooOo0o == 18) {
                    this.OooO0Oo = oo00o000.OooOo0O();
                } else if (iOooOo0o == 26) {
                    this.OooO0o0 = oo00o000.OooOo0O();
                } else if (iOooOo0o == 32) {
                    this.OooO0o = oo00o000.OooOO0O();
                } else if (iOooOo0o == 40) {
                    this.OooO0oO = oo00o000.OooOO0O();
                } else if (iOooOo0o == 50) {
                    this.OooO0oo = oo00o000.OooOo0O();
                } else if (iOooOo0o == 56) {
                    this.OooO = oo00o000.OooOO0O();
                } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                    return this;
                }
            }
        }

        public OooO00o OooO0o0() {
            this.OooO0OO = 0;
            this.OooO0Oo = "";
            this.OooO0o0 = "";
            this.OooO0o = 0;
            this.OooO0oO = 0;
            this.OooO0oo = "";
            this.OooO = 0;
            this.OooO00o = -1;
            return this;
        }
    }

    public oO00Oo0() {
        OooO0o0();
    }

    public static oO00Oo0 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO00Oo0) oOo0000O.OooO00o(new oO00Oo0(), bArr);
    }

    public static oO00Oo0 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO00Oo0().OooO00o(oo00o000);
    }

    public static oO00Oo0[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO00Oo0[0];
                }
            }
        }
        return OooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        OooO00o[] oooO00oArr = this.OooO0OO;
        if (oooO00oArr != null && oooO00oArr.length > 0) {
            int i = 0;
            while (true) {
                OooO00o[] oooO00oArr2 = this.OooO0OO;
                if (i >= oooO00oArr2.length) {
                    break;
                }
                OooO00o oooO00o = oooO00oArr2[i];
                if (oooO00o != null) {
                    oo00o00.OooO0Oo(1, oooO00o);
                }
                i++;
            }
        }
        if (!this.OooO0Oo.equals("")) {
            oo00o00.OooO0O0(2, this.OooO0Oo);
        }
        if (!this.OooO0o0.equals("")) {
            oo00o00.OooO0O0(3, this.OooO0o0);
        }
        if (!this.OooO0o.equals("")) {
            oo00o00.OooO0O0(4, this.OooO0o);
        }
        if (!this.OooO0oO.equals("")) {
            oo00o00.OooO0O0(5, this.OooO0oO);
        }
        if (!this.OooO0oo.equals("")) {
            oo00o00.OooO0O0(6, this.OooO0oo);
        }
        if (!this.OooO.equals("")) {
            oo00o00.OooO0O0(7, this.OooO);
        }
        if (!this.OooOO0.equals("")) {
            oo00o00.OooO0O0(8, this.OooOO0);
        }
        if (!this.OooOO0O.equals("")) {
            oo00o00.OooO0O0(9, this.OooOO0O);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        OooO00o[] oooO00oArr = this.OooO0OO;
        if (oooO00oArr != null && oooO00oArr.length > 0) {
            int i = 0;
            while (true) {
                OooO00o[] oooO00oArr2 = this.OooO0OO;
                if (i >= oooO00oArr2.length) {
                    break;
                }
                OooO00o oooO00o = oooO00oArr2[i];
                if (oooO00o != null) {
                    iOooO0O0 += oO00o00.OooO0O0(1, oooO00o);
                }
                i++;
            }
        }
        if (!this.OooO0Oo.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(2, this.OooO0Oo);
        }
        if (!this.OooO0o0.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(3, this.OooO0o0);
        }
        if (!this.OooO0o.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(4, this.OooO0o);
        }
        if (!this.OooO0oO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(5, this.OooO0oO);
        }
        if (!this.OooO0oo.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(6, this.OooO0oo);
        }
        if (!this.OooO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(7, this.OooO);
        }
        if (!this.OooOO0.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(8, this.OooOO0);
        }
        return !this.OooOO0O.equals("") ? iOooO0O0 + oO00o00.OooO00o(9, this.OooOO0O) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO00Oo0 OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 10) {
                int iOooO00o = oO0O000.OooO00o(oo00o000, 10);
                OooO00o[] oooO00oArr = this.OooO0OO;
                int length = oooO00oArr == null ? 0 : oooO00oArr.length;
                int i = iOooO00o + length;
                OooO00o[] oooO00oArr2 = new OooO00o[i];
                if (length != 0) {
                    System.arraycopy(oooO00oArr, 0, oooO00oArr2, 0, length);
                }
                while (length < i - 1) {
                    OooO00o oooO00o = new OooO00o();
                    oooO00oArr2[length] = oooO00o;
                    oo00o000.OooO00o(oooO00o);
                    oo00o000.OooOo0o();
                    length++;
                }
                OooO00o oooO00o2 = new OooO00o();
                oooO00oArr2[length] = oooO00o2;
                oo00o000.OooO00o(oooO00o2);
                this.OooO0OO = oooO00oArr2;
            } else if (iOooOo0o == 18) {
                this.OooO0Oo = oo00o000.OooOo0O();
            } else if (iOooOo0o == 26) {
                this.OooO0o0 = oo00o000.OooOo0O();
            } else if (iOooOo0o == 34) {
                this.OooO0o = oo00o000.OooOo0O();
            } else if (iOooOo0o == 42) {
                this.OooO0oO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 50) {
                this.OooO0oo = oo00o000.OooOo0O();
            } else if (iOooOo0o == 58) {
                this.OooO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 66) {
                this.OooOO0 = oo00o000.OooOo0O();
            } else if (iOooOo0o == 74) {
                this.OooOO0O = oo00o000.OooOo0O();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO00Oo0 OooO0o0() {
        this.OooO0OO = OooO00o.OooO0o();
        this.OooO0Oo = "";
        this.OooO0o0 = "";
        this.OooO0o = "";
        this.OooO0oO = "";
        this.OooO0oo = "";
        this.OooO = "";
        this.OooOO0 = "";
        this.OooOO0O = "";
        this.OooO00o = -1;
        return this;
    }
}
