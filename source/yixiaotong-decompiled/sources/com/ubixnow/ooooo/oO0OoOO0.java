package com.ubixnow.ooooo;

import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0OoOO0 extends oOo0000O {
    private static volatile oO0OoOO0[] OooO0O0;
    public String OooO;
    public String OooO0OO;
    public OooO0O0 OooO0Oo;
    public String OooO0o;
    public OooO0OO OooO0o0;
    public OooO00o[] OooO0oO;
    public String[] OooO0oo;
    public OooO OooOO0;
    public int OooOO0O;
    public int OooOO0o;
    public String OooOOO;
    public String OooOOO0;
    public String OooOOOO;
    public String OooOOOo;
    public int OooOOo;
    public int OooOOo0;
    public String OooOOoo;
    public int OooOo0;
    public String OooOo00;

    public static final class OooO extends oOo0000O {
        private static volatile OooO[] OooO0O0;
        public String OooO0OO;
        public String OooO0Oo;
        public int OooO0o;
        public String OooO0o0;
        public String OooO0oO;
        public String OooO0oo;

        public OooO() {
            OooO0o0();
        }

        public static OooO OooO00o(byte[] bArr) throws oO0OO00o {
            return (OooO) oOo0000O.OooO00o(new OooO(), bArr);
        }

        public static OooO OooO0OO(oO00o000 oo00o000) throws IOException {
            return new OooO().OooO00o(oo00o000);
        }

        public static OooO[] OooO0o() {
            if (OooO0O0 == null) {
                synchronized (oOo00ooO.OooOo0) {
                    if (OooO0O0 == null) {
                        OooO0O0 = new OooO[0];
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
            if (!this.OooO0o0.equals("")) {
                oo00o00.OooO0O0(3, this.OooO0o0);
            }
            int i = this.OooO0o;
            if (i != 0) {
                oo00o00.OooO(6, i);
            }
            if (!this.OooO0oO.equals("")) {
                oo00o00.OooO0O0(7, this.OooO0oO);
            }
            if (!this.OooO0oo.equals("")) {
                oo00o00.OooO0O0(8, this.OooO0oo);
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
            if (!this.OooO0o0.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(3, this.OooO0o0);
            }
            int i = this.OooO0o;
            if (i != 0) {
                iOooO0O0 += oO00o00.OooO0OO(6, i);
            }
            if (!this.OooO0oO.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(7, this.OooO0oO);
            }
            return !this.OooO0oo.equals("") ? iOooO0O0 + oO00o00.OooO00o(8, this.OooO0oo) : iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
        public OooO OooO00o(oO00o000 oo00o000) throws IOException {
            while (true) {
                int iOooOo0o = oo00o000.OooOo0o();
                if (iOooOo0o == 0) {
                    return this;
                }
                if (iOooOo0o == 10) {
                    this.OooO0OO = oo00o000.OooOo0O();
                } else if (iOooOo0o == 18) {
                    this.OooO0Oo = oo00o000.OooOo0O();
                } else if (iOooOo0o == 26) {
                    this.OooO0o0 = oo00o000.OooOo0O();
                } else if (iOooOo0o == 48) {
                    this.OooO0o = oo00o000.OooOO0O();
                } else if (iOooOo0o == 58) {
                    this.OooO0oO = oo00o000.OooOo0O();
                } else if (iOooOo0o == 66) {
                    this.OooO0oo = oo00o000.OooOo0O();
                } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                    return this;
                }
            }
        }

        public OooO OooO0o0() {
            this.OooO0OO = "";
            this.OooO0Oo = "";
            this.OooO0o0 = "";
            this.OooO0o = 0;
            this.OooO0oO = "";
            this.OooO0oo = "";
            this.OooO00o = -1;
            return this;
        }
    }

    public static final class OooO00o extends oOo0000O {
        private static volatile OooO00o[] OooO0O0;
        public String OooO;
        public String OooO0OO;
        public int OooO0Oo;
        public String OooO0o;
        public long OooO0o0;
        public String OooO0oO;
        public int OooO0oo;
        public int OooOO0;
        public int OooOO0O;

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
            if (!this.OooO0oO.equals("")) {
                oo00o00.OooO0O0(5, this.OooO0oO);
            }
            int i2 = this.OooO0oo;
            if (i2 != 0) {
                oo00o00.OooO(6, i2);
            }
            if (!this.OooO.equals("")) {
                oo00o00.OooO0O0(7, this.OooO);
            }
            int i3 = this.OooOO0;
            if (i3 != 0) {
                oo00o00.OooO(8, i3);
            }
            int i4 = this.OooOO0O;
            if (i4 != 0) {
                oo00o00.OooO(9, i4);
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
            if (!this.OooO0oO.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(5, this.OooO0oO);
            }
            int i2 = this.OooO0oo;
            if (i2 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(6, i2);
            }
            if (!this.OooO.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(7, this.OooO);
            }
            int i3 = this.OooOO0;
            if (i3 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(8, i3);
            }
            int i4 = this.OooOO0O;
            return i4 != 0 ? iOooO0O0 + oO00o00.OooO0OO(9, i4) : iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
        public OooO00o OooO00o(oO00o000 oo00o000) throws IOException {
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
                } else if (iOooOo0o == 42) {
                    this.OooO0oO = oo00o000.OooOo0O();
                } else if (iOooOo0o == 48) {
                    this.OooO0oo = oo00o000.OooOO0O();
                } else if (iOooOo0o == 58) {
                    this.OooO = oo00o000.OooOo0O();
                } else if (iOooOo0o == 64) {
                    this.OooOO0 = oo00o000.OooOO0O();
                } else if (iOooOo0o == 72) {
                    this.OooOO0O = oo00o000.OooOO0O();
                } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                    return this;
                }
            }
        }

        public OooO00o OooO0o0() {
            this.OooO0OO = "";
            this.OooO0Oo = 0;
            this.OooO0o0 = 0L;
            this.OooO0o = "";
            this.OooO0oO = "";
            this.OooO0oo = 0;
            this.OooO = "";
            this.OooOO0 = 0;
            this.OooOO0O = 0;
            this.OooO00o = -1;
            return this;
        }
    }

    public static final class OooO0O0 extends oOo0000O {
        private static volatile OooO0O0[] OooO0O0;
        public String OooO0OO;
        public String OooO0Oo;
        public String OooO0o;
        public String OooO0o0;
        public String OooO0oO;

        public OooO0O0() {
            OooO0o0();
        }

        public static OooO0O0 OooO00o(byte[] bArr) throws oO0OO00o {
            return (OooO0O0) oOo0000O.OooO00o(new OooO0O0(), bArr);
        }

        public static OooO0O0 OooO0OO(oO00o000 oo00o000) throws IOException {
            return new OooO0O0().OooO00o(oo00o000);
        }

        public static OooO0O0[] OooO0o() {
            if (OooO0O0 == null) {
                synchronized (oOo00ooO.OooOo0) {
                    if (OooO0O0 == null) {
                        OooO0O0 = new OooO0O0[0];
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
            if (!this.OooO0o0.equals("")) {
                oo00o00.OooO0O0(3, this.OooO0o0);
            }
            if (!this.OooO0o.equals("")) {
                oo00o00.OooO0O0(4, this.OooO0o);
            }
            if (!this.OooO0oO.equals("")) {
                oo00o00.OooO0O0(5, this.OooO0oO);
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
            if (!this.OooO0o0.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(3, this.OooO0o0);
            }
            if (!this.OooO0o.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(4, this.OooO0o);
            }
            return !this.OooO0oO.equals("") ? iOooO0O0 + oO00o00.OooO00o(5, this.OooO0oO) : iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
        public OooO0O0 OooO00o(oO00o000 oo00o000) throws IOException {
            while (true) {
                int iOooOo0o = oo00o000.OooOo0o();
                if (iOooOo0o == 0) {
                    return this;
                }
                if (iOooOo0o == 10) {
                    this.OooO0OO = oo00o000.OooOo0O();
                } else if (iOooOo0o == 18) {
                    this.OooO0Oo = oo00o000.OooOo0O();
                } else if (iOooOo0o == 26) {
                    this.OooO0o0 = oo00o000.OooOo0O();
                } else if (iOooOo0o == 34) {
                    this.OooO0o = oo00o000.OooOo0O();
                } else if (iOooOo0o == 42) {
                    this.OooO0oO = oo00o000.OooOo0O();
                } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                    return this;
                }
            }
        }

        public OooO0O0 OooO0o0() {
            this.OooO0OO = "";
            this.OooO0Oo = "";
            this.OooO0o0 = "";
            this.OooO0o = "";
            this.OooO0oO = "";
            this.OooO00o = -1;
            return this;
        }
    }

    public static final class OooO0OO extends oOo0000O {
        private static volatile OooO0OO[] OooO0O0;
        public String OooO;
        public OooO0O0 OooO0OO;
        public int OooO0Oo;
        public String OooO0o;
        public int OooO0o0;
        public String OooO0oO;
        public String OooO0oo;
        public String OooOO0;
        public String OooOO0O;
        public int OooOO0o;
        public float OooOOO;
        public OooO0o OooOOO0;
        public String OooOOOO;
        public int OooOOOo;
        public int OooOOo;
        public String OooOOo0;
        public String OooOOoo;
        public int OooOo;
        public int OooOo0;
        public String OooOo00;
        public long OooOo0O;
        public long OooOo0o;
        public OooO00o OooOoO;
        public int OooOoO0;
        public String OooOoOO;
        public String OooOoo0;

        public static final class OooO00o extends oOo0000O {
            private static volatile OooO00o[] OooO0O0;
            public String OooO;
            public double OooO0OO;
            public double OooO0Oo;
            public String OooO0o;
            public String OooO0o0;
            public String OooO0oO;
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
                if (Double.doubleToLongBits(this.OooO0OO) != Double.doubleToLongBits(0.0d)) {
                    oo00o00.OooO0O0(1, this.OooO0OO);
                }
                if (Double.doubleToLongBits(this.OooO0Oo) != Double.doubleToLongBits(0.0d)) {
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
                super.OooO00o(oo00o00);
            }

            @Override // com.ubixnow.ooooo.oOo0000O
            public int OooO0O0() {
                int iOooO0O0 = super.OooO0O0();
                if (Double.doubleToLongBits(this.OooO0OO) != Double.doubleToLongBits(0.0d)) {
                    iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
                }
                if (Double.doubleToLongBits(this.OooO0Oo) != Double.doubleToLongBits(0.0d)) {
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
                return !this.OooO.equals("") ? iOooO0O0 + oO00o00.OooO00o(7, this.OooO) : iOooO0O0;
            }

            @Override // com.ubixnow.ooooo.oOo0000O
            /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
            public OooO00o OooO00o(oO00o000 oo00o000) throws IOException {
                while (true) {
                    int iOooOo0o = oo00o000.OooOo0o();
                    if (iOooOo0o == 0) {
                        return this;
                    }
                    if (iOooOo0o == 9) {
                        this.OooO0OO = oo00o000.OooO0o();
                    } else if (iOooOo0o == 17) {
                        this.OooO0Oo = oo00o000.OooO0o();
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
                    } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                        return this;
                    }
                }
            }

            public OooO00o OooO0o0() {
                this.OooO0OO = 0.0d;
                this.OooO0Oo = 0.0d;
                this.OooO0o0 = "";
                this.OooO0o = "";
                this.OooO0oO = "";
                this.OooO0oo = "";
                this.OooO = "";
                this.OooO00o = -1;
                return this;
            }
        }

        public static final class OooO0O0 extends oOo0000O {
            private static volatile OooO0O0[] OooO0O0;
            public String OooO;
            public String OooO0OO;
            public String OooO0Oo;
            public String OooO0o;
            public String OooO0o0;
            public String OooO0oO;
            public String OooO0oo;
            public String OooOO0;
            public String OooOO0O;

            public OooO0O0() {
                OooO0o0();
            }

            public static OooO0O0 OooO00o(byte[] bArr) throws oO0OO00o {
                return (OooO0O0) oOo0000O.OooO00o(new OooO0O0(), bArr);
            }

            public static OooO0O0 OooO0OO(oO00o000 oo00o000) throws IOException {
                return new OooO0O0().OooO00o(oo00o000);
            }

            public static OooO0O0[] OooO0o() {
                if (OooO0O0 == null) {
                    synchronized (oOo00ooO.OooOo0) {
                        if (OooO0O0 == null) {
                            OooO0O0 = new OooO0O0[0];
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
                if (!this.OooO0OO.equals("")) {
                    iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
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
            public OooO0O0 OooO00o(oO00o000 oo00o000) throws IOException {
                while (true) {
                    int iOooOo0o = oo00o000.OooOo0o();
                    if (iOooOo0o == 0) {
                        return this;
                    }
                    if (iOooOo0o == 10) {
                        this.OooO0OO = oo00o000.OooOo0O();
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

            public OooO0O0 OooO0o0() {
                this.OooO0OO = "";
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

        public OooO0OO() {
            OooO0o0();
        }

        public static OooO0OO OooO00o(byte[] bArr) throws oO0OO00o {
            return (OooO0OO) oOo0000O.OooO00o(new OooO0OO(), bArr);
        }

        public static OooO0OO OooO0OO(oO00o000 oo00o000) throws IOException {
            return new OooO0OO().OooO00o(oo00o000);
        }

        public static OooO0OO[] OooO0o() {
            if (OooO0O0 == null) {
                synchronized (oOo00ooO.OooOo0) {
                    if (OooO0O0 == null) {
                        OooO0O0 = new OooO0OO[0];
                    }
                }
            }
            return OooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        public void OooO00o(oO00o00 oo00o00) throws IOException {
            OooO0O0 oooO0O0 = this.OooO0OO;
            if (oooO0O0 != null) {
                oo00o00.OooO0Oo(1, oooO0O0);
            }
            int i = this.OooO0Oo;
            if (i != 0) {
                oo00o00.OooO(2, i);
            }
            int i2 = this.OooO0o0;
            if (i2 != 0) {
                oo00o00.OooO(3, i2);
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
            int i3 = this.OooOO0o;
            if (i3 != 0) {
                oo00o00.OooO(10, i3);
            }
            OooO0o oooO0o = this.OooOOO0;
            if (oooO0o != null) {
                oo00o00.OooO0Oo(11, oooO0o);
            }
            if (Float.floatToIntBits(this.OooOOO) != Float.floatToIntBits(0.0f)) {
                oo00o00.OooO0O0(12, this.OooOOO);
            }
            if (!this.OooOOOO.equals("")) {
                oo00o00.OooO0O0(13, this.OooOOOO);
            }
            int i4 = this.OooOOOo;
            if (i4 != 0) {
                oo00o00.OooO(14, i4);
            }
            if (!this.OooOOo0.equals("")) {
                oo00o00.OooO0O0(15, this.OooOOo0);
            }
            int i5 = this.OooOOo;
            if (i5 != 0) {
                oo00o00.OooO(16, i5);
            }
            if (!this.OooOOoo.equals("")) {
                oo00o00.OooO0O0(18, this.OooOOoo);
            }
            if (!this.OooOo00.equals("")) {
                oo00o00.OooO0O0(19, this.OooOo00);
            }
            int i6 = this.OooOo0;
            if (i6 != 0) {
                oo00o00.OooO(20, i6);
            }
            long j = this.OooOo0O;
            if (j != 0) {
                oo00o00.OooO0oO(21, j);
            }
            long j2 = this.OooOo0o;
            if (j2 != 0) {
                oo00o00.OooO0oO(22, j2);
            }
            int i7 = this.OooOo;
            if (i7 != 0) {
                oo00o00.OooO(23, i7);
            }
            int i8 = this.OooOoO0;
            if (i8 != 0) {
                oo00o00.OooO(24, i8);
            }
            OooO00o oooO00o = this.OooOoO;
            if (oooO00o != null) {
                oo00o00.OooO0Oo(25, oooO00o);
            }
            if (!this.OooOoOO.equals("")) {
                oo00o00.OooO0O0(26, this.OooOoOO);
            }
            if (!this.OooOoo0.equals("")) {
                oo00o00.OooO0O0(27, this.OooOoo0);
            }
            super.OooO00o(oo00o00);
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        public int OooO0O0() {
            int iOooO0O0 = super.OooO0O0();
            OooO0O0 oooO0O0 = this.OooO0OO;
            if (oooO0O0 != null) {
                iOooO0O0 += oO00o00.OooO0O0(1, oooO0O0);
            }
            int i = this.OooO0Oo;
            if (i != 0) {
                iOooO0O0 += oO00o00.OooO0OO(2, i);
            }
            int i2 = this.OooO0o0;
            if (i2 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(3, i2);
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
            if (!this.OooOO0O.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(9, this.OooOO0O);
            }
            int i3 = this.OooOO0o;
            if (i3 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(10, i3);
            }
            OooO0o oooO0o = this.OooOOO0;
            if (oooO0o != null) {
                iOooO0O0 += oO00o00.OooO0O0(11, oooO0o);
            }
            if (Float.floatToIntBits(this.OooOOO) != Float.floatToIntBits(0.0f)) {
                iOooO0O0 += oO00o00.OooO00o(12, this.OooOOO);
            }
            if (!this.OooOOOO.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(13, this.OooOOOO);
            }
            int i4 = this.OooOOOo;
            if (i4 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(14, i4);
            }
            if (!this.OooOOo0.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(15, this.OooOOo0);
            }
            int i5 = this.OooOOo;
            if (i5 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(16, i5);
            }
            if (!this.OooOOoo.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(18, this.OooOOoo);
            }
            if (!this.OooOo00.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(19, this.OooOo00);
            }
            int i6 = this.OooOo0;
            if (i6 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(20, i6);
            }
            long j = this.OooOo0O;
            if (j != 0) {
                iOooO0O0 += oO00o00.OooO0O0(21, j);
            }
            long j2 = this.OooOo0o;
            if (j2 != 0) {
                iOooO0O0 += oO00o00.OooO0O0(22, j2);
            }
            int i7 = this.OooOo;
            if (i7 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(23, i7);
            }
            int i8 = this.OooOoO0;
            if (i8 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(24, i8);
            }
            OooO00o oooO00o = this.OooOoO;
            if (oooO00o != null) {
                iOooO0O0 += oO00o00.OooO0O0(25, oooO00o);
            }
            if (!this.OooOoOO.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(26, this.OooOoOO);
            }
            return !this.OooOoo0.equals("") ? iOooO0O0 + oO00o00.OooO00o(27, this.OooOoo0) : iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
        public OooO0OO OooO00o(oO00o000 oo00o000) throws IOException {
            oOo0000O ooo0000o;
            while (true) {
                int iOooOo0o = oo00o000.OooOo0o();
                switch (iOooOo0o) {
                    case 0:
                        return this;
                    case 10:
                        if (this.OooO0OO == null) {
                            this.OooO0OO = new OooO0O0();
                        }
                        ooo0000o = this.OooO0OO;
                        break;
                    case 16:
                        this.OooO0Oo = oo00o000.OooOO0O();
                        continue;
                    case 24:
                        this.OooO0o0 = oo00o000.OooOO0O();
                        continue;
                    case 34:
                        this.OooO0o = oo00o000.OooOo0O();
                        continue;
                    case 42:
                        this.OooO0oO = oo00o000.OooOo0O();
                        continue;
                    case 50:
                        this.OooO0oo = oo00o000.OooOo0O();
                        continue;
                    case 58:
                        this.OooO = oo00o000.OooOo0O();
                        continue;
                    case 66:
                        this.OooOO0 = oo00o000.OooOo0O();
                        continue;
                    case 74:
                        this.OooOO0O = oo00o000.OooOo0O();
                        continue;
                    case 80:
                        this.OooOO0o = oo00o000.OooOO0O();
                        continue;
                    case 90:
                        if (this.OooOOO0 == null) {
                            this.OooOOO0 = new OooO0o();
                        }
                        ooo0000o = this.OooOOO0;
                        break;
                    case 101:
                        this.OooOOO = oo00o000.OooOO0();
                        continue;
                    case 106:
                        this.OooOOOO = oo00o000.OooOo0O();
                        continue;
                    case 112:
                        this.OooOOOo = oo00o000.OooOO0O();
                        continue;
                    case 122:
                        this.OooOOo0 = oo00o000.OooOo0O();
                        continue;
                    case 128:
                        this.OooOOo = oo00o000.OooOO0O();
                        continue;
                    case 146:
                        this.OooOOoo = oo00o000.OooOo0O();
                        continue;
                    case 154:
                        this.OooOo00 = oo00o000.OooOo0O();
                        continue;
                    case 160:
                        this.OooOo0 = oo00o000.OooOO0O();
                        continue;
                    case Opcodes.JSR /* 168 */:
                        this.OooOo0O = oo00o000.OooOO0o();
                        continue;
                    case 176:
                        this.OooOo0o = oo00o000.OooOO0o();
                        continue;
                    case 184:
                        this.OooOo = oo00o000.OooOO0O();
                        continue;
                    case 192:
                        this.OooOoO0 = oo00o000.OooOO0O();
                        continue;
                    case 202:
                        if (this.OooOoO == null) {
                            this.OooOoO = new OooO00o();
                        }
                        ooo0000o = this.OooOoO;
                        break;
                    case 210:
                        this.OooOoOO = oo00o000.OooOo0O();
                        continue;
                    case JfifUtil.MARKER_SOS /* 218 */:
                        this.OooOoo0 = oo00o000.OooOo0O();
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

        public OooO0OO OooO0o0() {
            this.OooO0OO = null;
            this.OooO0Oo = 0;
            this.OooO0o0 = 0;
            this.OooO0o = "";
            this.OooO0oO = "";
            this.OooO0oo = "";
            this.OooO = "";
            this.OooOO0 = "";
            this.OooOO0O = "";
            this.OooOO0o = 0;
            this.OooOOO0 = null;
            this.OooOOO = 0.0f;
            this.OooOOOO = "";
            this.OooOOOo = 0;
            this.OooOOo0 = "";
            this.OooOOo = 0;
            this.OooOOoo = "";
            this.OooOo00 = "";
            this.OooOo0 = 0;
            this.OooOo0O = 0L;
            this.OooOo0o = 0L;
            this.OooOo = 0;
            this.OooOoO0 = 0;
            this.OooOoO = null;
            this.OooOoOO = "";
            this.OooOoo0 = "";
            this.OooO00o = -1;
            return this;
        }
    }

    public static final class OooO0o extends oOo0000O {
        private static volatile OooO0o[] OooO0O0;
        public int OooO0OO;
        public int OooO0Oo;

        public OooO0o() {
            OooO0o0();
        }

        public static OooO0o OooO00o(byte[] bArr) throws oO0OO00o {
            return (OooO0o) oOo0000O.OooO00o(new OooO0o(), bArr);
        }

        public static OooO0o OooO0OO(oO00o000 oo00o000) throws IOException {
            return new OooO0o().OooO00o(oo00o000);
        }

        public static OooO0o[] OooO0o() {
            if (OooO0O0 == null) {
                synchronized (oOo00ooO.OooOo0) {
                    if (OooO0O0 == null) {
                        OooO0O0 = new OooO0o[0];
                    }
                }
            }
            return OooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        public void OooO00o(oO00o00 oo00o00) throws IOException {
            int i = this.OooO0OO;
            if (i != 0) {
                oo00o00.OooOOO0(1, i);
            }
            int i2 = this.OooO0Oo;
            if (i2 != 0) {
                oo00o00.OooOOO0(2, i2);
            }
            super.OooO00o(oo00o00);
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        public int OooO0O0() {
            int iOooO0O0 = super.OooO0O0();
            int i = this.OooO0OO;
            if (i != 0) {
                iOooO0O0 += oO00o00.OooO0o(1, i);
            }
            int i2 = this.OooO0Oo;
            return i2 != 0 ? iOooO0O0 + oO00o00.OooO0o(2, i2) : iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
        public OooO0o OooO00o(oO00o000 oo00o000) throws IOException {
            while (true) {
                int iOooOo0o = oo00o000.OooOo0o();
                if (iOooOo0o == 0) {
                    return this;
                }
                if (iOooOo0o == 8) {
                    this.OooO0OO = oo00o000.OooOo();
                } else if (iOooOo0o == 16) {
                    this.OooO0Oo = oo00o000.OooOo();
                } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                    return this;
                }
            }
        }

        public OooO0o OooO0o0() {
            this.OooO0OO = 0;
            this.OooO0Oo = 0;
            this.OooO00o = -1;
            return this;
        }
    }

    public oO0OoOO0() {
        OooO0o0();
    }

    public static oO0OoOO0 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0OoOO0) oOo0000O.OooO00o(new oO0OoOO0(), bArr);
    }

    public static oO0OoOO0 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0OoOO0().OooO00o(oo00o000);
    }

    public static oO0OoOO0[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0OoOO0[0];
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
        OooO0O0 oooO0O0 = this.OooO0Oo;
        if (oooO0O0 != null) {
            oo00o00.OooO0Oo(2, oooO0O0);
        }
        OooO0OO oooO0OO = this.OooO0o0;
        if (oooO0OO != null) {
            oo00o00.OooO0Oo(3, oooO0OO);
        }
        if (!this.OooO0o.equals("")) {
            oo00o00.OooO0O0(4, this.OooO0o);
        }
        OooO00o[] oooO00oArr = this.OooO0oO;
        int i = 0;
        if (oooO00oArr != null && oooO00oArr.length > 0) {
            int i2 = 0;
            while (true) {
                OooO00o[] oooO00oArr2 = this.OooO0oO;
                if (i2 >= oooO00oArr2.length) {
                    break;
                }
                OooO00o oooO00o = oooO00oArr2[i2];
                if (oooO00o != null) {
                    oo00o00.OooO0Oo(5, oooO00o);
                }
                i2++;
            }
        }
        String[] strArr = this.OooO0oo;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.OooO0oo;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    oo00o00.OooO0O0(6, str);
                }
                i++;
            }
        }
        if (!this.OooO.equals("")) {
            oo00o00.OooO0O0(7, this.OooO);
        }
        OooO oooO = this.OooOO0;
        if (oooO != null) {
            oo00o00.OooO0Oo(8, oooO);
        }
        int i3 = this.OooOO0O;
        if (i3 != 0) {
            oo00o00.OooO(9, i3);
        }
        int i4 = this.OooOO0o;
        if (i4 != 0) {
            oo00o00.OooO(10, i4);
        }
        if (!this.OooOOO0.equals("")) {
            oo00o00.OooO0O0(11, this.OooOOO0);
        }
        if (!this.OooOOO.equals("")) {
            oo00o00.OooO0O0(12, this.OooOOO);
        }
        if (!this.OooOOOO.equals("")) {
            oo00o00.OooO0O0(13, this.OooOOOO);
        }
        if (!this.OooOOOo.equals("")) {
            oo00o00.OooO0O0(14, this.OooOOOo);
        }
        int i5 = this.OooOOo0;
        if (i5 != 0) {
            oo00o00.OooO(15, i5);
        }
        int i6 = this.OooOOo;
        if (i6 != 0) {
            oo00o00.OooO(16, i6);
        }
        if (!this.OooOOoo.equals("")) {
            oo00o00.OooO0O0(17, this.OooOOoo);
        }
        if (!this.OooOo00.equals("")) {
            oo00o00.OooO0O0(18, this.OooOo00);
        }
        int i7 = this.OooOo0;
        if (i7 != 0) {
            oo00o00.OooO(19, i7);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        if (!this.OooO0OO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
        }
        OooO0O0 oooO0O0 = this.OooO0Oo;
        if (oooO0O0 != null) {
            iOooO0O0 += oO00o00.OooO0O0(2, oooO0O0);
        }
        OooO0OO oooO0OO = this.OooO0o0;
        if (oooO0OO != null) {
            iOooO0O0 += oO00o00.OooO0O0(3, oooO0OO);
        }
        if (!this.OooO0o.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(4, this.OooO0o);
        }
        OooO00o[] oooO00oArr = this.OooO0oO;
        int i = 0;
        if (oooO00oArr != null && oooO00oArr.length > 0) {
            int i2 = 0;
            while (true) {
                OooO00o[] oooO00oArr2 = this.OooO0oO;
                if (i2 >= oooO00oArr2.length) {
                    break;
                }
                OooO00o oooO00o = oooO00oArr2[i2];
                if (oooO00o != null) {
                    iOooO0O0 += oO00o00.OooO0O0(5, oooO00o);
                }
                i2++;
            }
        }
        String[] strArr = this.OooO0oo;
        if (strArr != null && strArr.length > 0) {
            int iOooO00o = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.OooO0oo;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    i3++;
                    iOooO00o += oO00o00.OooO00o(str);
                }
                i++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o + i3;
        }
        if (!this.OooO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(7, this.OooO);
        }
        OooO oooO = this.OooOO0;
        if (oooO != null) {
            iOooO0O0 += oO00o00.OooO0O0(8, oooO);
        }
        int i4 = this.OooOO0O;
        if (i4 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(9, i4);
        }
        int i5 = this.OooOO0o;
        if (i5 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(10, i5);
        }
        if (!this.OooOOO0.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(11, this.OooOOO0);
        }
        if (!this.OooOOO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(12, this.OooOOO);
        }
        if (!this.OooOOOO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(13, this.OooOOOO);
        }
        if (!this.OooOOOo.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(14, this.OooOOOo);
        }
        int i6 = this.OooOOo0;
        if (i6 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(15, i6);
        }
        int i7 = this.OooOOo;
        if (i7 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(16, i7);
        }
        if (!this.OooOOoo.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(17, this.OooOOoo);
        }
        if (!this.OooOo00.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(18, this.OooOo00);
        }
        int i8 = this.OooOo0;
        return i8 != 0 ? iOooO0O0 + oO00o00.OooO0OO(19, i8) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0OoOO0 OooO00o(oO00o000 oo00o000) throws IOException {
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
                        this.OooO0Oo = new OooO0O0();
                    }
                    ooo0000o = this.OooO0Oo;
                    break;
                case 26:
                    if (this.OooO0o0 == null) {
                        this.OooO0o0 = new OooO0OO();
                    }
                    ooo0000o = this.OooO0o0;
                    break;
                case 34:
                    this.OooO0o = oo00o000.OooOo0O();
                    continue;
                case 42:
                    int iOooO00o = oO0O000.OooO00o(oo00o000, 42);
                    OooO00o[] oooO00oArr = this.OooO0oO;
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
                    this.OooO0oO = oooO00oArr2;
                    continue;
                case 50:
                    int iOooO00o2 = oO0O000.OooO00o(oo00o000, 50);
                    String[] strArr = this.OooO0oo;
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
                    this.OooO0oo = strArr2;
                    continue;
                case 58:
                    this.OooO = oo00o000.OooOo0O();
                    continue;
                case 66:
                    if (this.OooOO0 == null) {
                        this.OooOO0 = new OooO();
                    }
                    ooo0000o = this.OooOO0;
                    break;
                case 72:
                    this.OooOO0O = oo00o000.OooOO0O();
                    continue;
                case 80:
                    this.OooOO0o = oo00o000.OooOO0O();
                    continue;
                case 90:
                    this.OooOOO0 = oo00o000.OooOo0O();
                    continue;
                case 98:
                    this.OooOOO = oo00o000.OooOo0O();
                    continue;
                case 106:
                    this.OooOOOO = oo00o000.OooOo0O();
                    continue;
                case 114:
                    this.OooOOOo = oo00o000.OooOo0O();
                    continue;
                case 120:
                    this.OooOOo0 = oo00o000.OooOO0O();
                    continue;
                case 128:
                    this.OooOOo = oo00o000.OooOO0O();
                    continue;
                case 138:
                    this.OooOOoo = oo00o000.OooOo0O();
                    continue;
                case 146:
                    this.OooOo00 = oo00o000.OooOo0O();
                    continue;
                case 152:
                    this.OooOo0 = oo00o000.OooOO0O();
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

    public oO0OoOO0 OooO0o0() {
        this.OooO0OO = "";
        this.OooO0Oo = null;
        this.OooO0o0 = null;
        this.OooO0o = "";
        this.OooO0oO = OooO00o.OooO0o();
        this.OooO0oo = oO0O000.OooOOO;
        this.OooO = "";
        this.OooOO0 = null;
        this.OooOO0O = 0;
        this.OooOO0o = 0;
        this.OooOOO0 = "";
        this.OooOOO = "";
        this.OooOOOO = "";
        this.OooOOOo = "";
        this.OooOOo0 = 0;
        this.OooOOo = 0;
        this.OooOOoo = "";
        this.OooOo00 = "";
        this.OooOo0 = 0;
        this.OooO00o = -1;
        return this;
    }
}
