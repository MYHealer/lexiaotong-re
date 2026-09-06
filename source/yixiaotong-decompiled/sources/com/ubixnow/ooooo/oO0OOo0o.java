package com.ubixnow.ooooo;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0OOo0o extends oOo0000O {
    private static volatile oO0OOo0o[] OooO0O0;
    public String OooO;
    public int OooO0OO;
    public boolean OooO0Oo;
    public boolean OooO0o;
    public OooO00o[] OooO0o0;
    public String OooO0oO;
    public long OooO0oo;

    public static final class OooO00o extends oOo0000O {
        private static volatile OooO00o[] OooO0O0;
        public int OooO;
        public String OooO0OO;
        public oO0O0OoO[] OooO0Oo;
        public int OooO0o;
        public int OooO0o0;
        public int OooO0oO;
        public int OooO0oo;
        public int OooOO0;
        public long OooOO0O;
        public long OooOO0o;
        public C1140OooO00o OooOOO;
        public String OooOOO0;
        public int OooOOOO;
        public int OooOOOo;
        public int OooOOo;
        public int OooOOo0;
        public int OooOOoo;
        public boolean OooOo;
        public String OooOo0;
        public int OooOo00;
        public String OooOo0O;
        public String OooOo0o;
        public String OooOoO;
        public int OooOoO0;
        public long OooOoOO;
        public boolean OooOoo;
        public String OooOoo0;
        public int OooOooO;

        public static final class OooO extends oOo0000O {
            private static volatile OooO[] OooO0O0;

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
            /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
            public OooO OooO00o(oO00o000 oo00o000) throws IOException {
                int iOooOo0o;
                do {
                    iOooOo0o = oo00o000.OooOo0o();
                    if (iOooOo0o == 0) {
                        break;
                    }
                } while (oO0O000.OooO0O0(oo00o000, iOooOo0o));
                return this;
            }

            public OooO OooO0o0() {
                this.OooO00o = -1;
                return this;
            }
        }

        /* JADX INFO: renamed from: com.ubixnow.ooooo.oO0OOo0o$OooO00o$OooO00o, reason: collision with other inner class name */
        public static final class C1140OooO00o extends oOo0000O {
            private static volatile C1140OooO00o[] OooO0O0;
            public int OooO0OO;
            public int OooO0Oo;
            public int OooO0o;
            public int OooO0o0;

            public C1140OooO00o() {
                OooO0o0();
            }

            public static C1140OooO00o OooO00o(byte[] bArr) throws oO0OO00o {
                return (C1140OooO00o) oOo0000O.OooO00o(new C1140OooO00o(), bArr);
            }

            public static C1140OooO00o OooO0OO(oO00o000 oo00o000) throws IOException {
                return new C1140OooO00o().OooO00o(oo00o000);
            }

            public static C1140OooO00o[] OooO0o() {
                if (OooO0O0 == null) {
                    synchronized (oOo00ooO.OooOo0) {
                        if (OooO0O0 == null) {
                            OooO0O0 = new C1140OooO00o[0];
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
                    oo00o00.OooO(3, i2);
                }
                int i3 = this.OooO0o0;
                if (i3 != 0) {
                    oo00o00.OooO(4, i3);
                }
                int i4 = this.OooO0o;
                if (i4 != 0) {
                    oo00o00.OooO(5, i4);
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
                if (i2 != 0) {
                    iOooO0O0 += oO00o00.OooO0OO(3, i2);
                }
                int i3 = this.OooO0o0;
                if (i3 != 0) {
                    iOooO0O0 += oO00o00.OooO0OO(4, i3);
                }
                int i4 = this.OooO0o;
                return i4 != 0 ? iOooO0O0 + oO00o00.OooO0OO(5, i4) : iOooO0O0;
            }

            @Override // com.ubixnow.ooooo.oOo0000O
            /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
            public C1140OooO00o OooO00o(oO00o000 oo00o000) throws IOException {
                while (true) {
                    int iOooOo0o = oo00o000.OooOo0o();
                    if (iOooOo0o == 0) {
                        return this;
                    }
                    if (iOooOo0o == 8) {
                        this.OooO0OO = oo00o000.OooOO0O();
                    } else if (iOooOo0o == 24) {
                        this.OooO0Oo = oo00o000.OooOO0O();
                    } else if (iOooOo0o == 32) {
                        this.OooO0o0 = oo00o000.OooOO0O();
                    } else if (iOooOo0o == 40) {
                        this.OooO0o = oo00o000.OooOO0O();
                    } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                        return this;
                    }
                }
            }

            public C1140OooO00o OooO0o0() {
                this.OooO0OO = 0;
                this.OooO0Oo = 0;
                this.OooO0o0 = 0;
                this.OooO0o = 0;
                this.OooO00o = -1;
                return this;
            }
        }

        public static final class OooO0O0 extends oOo0000O {
            private static volatile OooO0O0[] OooO0O0;
            public int OooO0OO;

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
            public OooO0O0 OooO00o(oO00o000 oo00o000) throws IOException {
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

            public OooO0O0 OooO0o0() {
                this.OooO0OO = 0;
                this.OooO00o = -1;
                return this;
            }
        }

        public static final class OooO0OO extends oOo0000O {
            private static volatile OooO0OO[] OooO0O0;

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
            /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
            public OooO0OO OooO00o(oO00o000 oo00o000) throws IOException {
                int iOooOo0o;
                do {
                    iOooOo0o = oo00o000.OooOo0o();
                    if (iOooOo0o == 0) {
                        break;
                    }
                } while (oO0O000.OooO0O0(oo00o000, iOooOo0o));
                return this;
            }

            public OooO0OO OooO0o0() {
                this.OooO00o = -1;
                return this;
            }
        }

        public static final class OooO0o extends oOo0000O {
            private static volatile OooO0o[] OooO0O0;

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
            /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
            public OooO0o OooO00o(oO00o000 oo00o000) throws IOException {
                int iOooOo0o;
                do {
                    iOooOo0o = oo00o000.OooOo0o();
                    if (iOooOo0o == 0) {
                        break;
                    }
                } while (oO0O000.OooO0O0(oo00o000, iOooOo0o));
                return this;
            }

            public OooO0o OooO0o0() {
                this.OooO00o = -1;
                return this;
            }
        }

        public static final class OooOO0 extends oOo0000O {
            private static volatile OooOO0[] OooO0O0;

            public OooOO0() {
                OooO0o0();
            }

            public static OooOO0 OooO00o(byte[] bArr) throws oO0OO00o {
                return (OooOO0) oOo0000O.OooO00o(new OooOO0(), bArr);
            }

            public static OooOO0 OooO0OO(oO00o000 oo00o000) throws IOException {
                return new OooOO0().OooO00o(oo00o000);
            }

            public static OooOO0[] OooO0o() {
                if (OooO0O0 == null) {
                    synchronized (oOo00ooO.OooOo0) {
                        if (OooO0O0 == null) {
                            OooO0O0 = new OooOO0[0];
                        }
                    }
                }
                return OooO0O0;
            }

            @Override // com.ubixnow.ooooo.oOo0000O
            /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
            public OooOO0 OooO00o(oO00o000 oo00o000) throws IOException {
                int iOooOo0o;
                do {
                    iOooOo0o = oo00o000.OooOo0o();
                    if (iOooOo0o == 0) {
                        break;
                    }
                } while (oO0O000.OooO0O0(oo00o000, iOooOo0o));
                return this;
            }

            public OooOO0 OooO0o0() {
                this.OooO00o = -1;
                return this;
            }
        }

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
            oO0O0OoO[] oo0o0oooArr = this.OooO0Oo;
            if (oo0o0oooArr != null && oo0o0oooArr.length > 0) {
                int i = 0;
                while (true) {
                    oO0O0OoO[] oo0o0oooArr2 = this.OooO0Oo;
                    if (i >= oo0o0oooArr2.length) {
                        break;
                    }
                    oO0O0OoO oo0o0ooo = oo0o0oooArr2[i];
                    if (oo0o0ooo != null) {
                        oo00o00.OooO0Oo(2, oo0o0ooo);
                    }
                    i++;
                }
            }
            int i2 = this.OooO0o0;
            if (i2 != 0) {
                oo00o00.OooO(4, i2);
            }
            int i3 = this.OooO0o;
            if (i3 != 0) {
                oo00o00.OooO(5, i3);
            }
            int i4 = this.OooO0oO;
            if (i4 != 0) {
                oo00o00.OooO(12, i4);
            }
            int i5 = this.OooO0oo;
            if (i5 != 0) {
                oo00o00.OooO(13, i5);
            }
            int i6 = this.OooO;
            if (i6 != 0) {
                oo00o00.OooO(14, i6);
            }
            int i7 = this.OooOO0;
            if (i7 != 0) {
                oo00o00.OooO(15, i7);
            }
            long j = this.OooOO0O;
            if (j != 0) {
                oo00o00.OooO0oO(16, j);
            }
            long j2 = this.OooOO0o;
            if (j2 != 0) {
                oo00o00.OooO0oO(17, j2);
            }
            if (!this.OooOOO0.equals("")) {
                oo00o00.OooO0O0(18, this.OooOOO0);
            }
            C1140OooO00o c1140OooO00o = this.OooOOO;
            if (c1140OooO00o != null) {
                oo00o00.OooO0Oo(19, c1140OooO00o);
            }
            int i8 = this.OooOOOO;
            if (i8 != 0) {
                oo00o00.OooO(20, i8);
            }
            int i9 = this.OooOOOo;
            if (i9 != 0) {
                oo00o00.OooO(21, i9);
            }
            int i10 = this.OooOOo0;
            if (i10 != 0) {
                oo00o00.OooO(22, i10);
            }
            int i11 = this.OooOOo;
            if (i11 != 0) {
                oo00o00.OooO(23, i11);
            }
            int i12 = this.OooOOoo;
            if (i12 != 0) {
                oo00o00.OooO(24, i12);
            }
            int i13 = this.OooOo00;
            if (i13 != 0) {
                oo00o00.OooO(25, i13);
            }
            if (!this.OooOo0.equals("")) {
                oo00o00.OooO0O0(26, this.OooOo0);
            }
            if (!this.OooOo0O.equals("")) {
                oo00o00.OooO0O0(27, this.OooOo0O);
            }
            if (!this.OooOo0o.equals("")) {
                oo00o00.OooO0O0(28, this.OooOo0o);
            }
            boolean z = this.OooOo;
            if (z) {
                oo00o00.OooO0O0(29, z);
            }
            int i14 = this.OooOoO0;
            if (i14 != 0) {
                oo00o00.OooO(30, i14);
            }
            if (!this.OooOoO.equals("")) {
                oo00o00.OooO0O0(31, this.OooOoO);
            }
            long j3 = this.OooOoOO;
            if (j3 != 0) {
                oo00o00.OooO0oO(32, j3);
            }
            if (!this.OooOoo0.equals("")) {
                oo00o00.OooO0O0(33, this.OooOoo0);
            }
            boolean z2 = this.OooOoo;
            if (z2) {
                oo00o00.OooO0O0(34, z2);
            }
            int i15 = this.OooOooO;
            if (i15 != 0) {
                oo00o00.OooO(35, i15);
            }
            super.OooO00o(oo00o00);
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        public int OooO0O0() {
            int iOooO0O0 = super.OooO0O0();
            if (!this.OooO0OO.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(1, this.OooO0OO);
            }
            oO0O0OoO[] oo0o0oooArr = this.OooO0Oo;
            if (oo0o0oooArr != null && oo0o0oooArr.length > 0) {
                int i = 0;
                while (true) {
                    oO0O0OoO[] oo0o0oooArr2 = this.OooO0Oo;
                    if (i >= oo0o0oooArr2.length) {
                        break;
                    }
                    oO0O0OoO oo0o0ooo = oo0o0oooArr2[i];
                    if (oo0o0ooo != null) {
                        iOooO0O0 += oO00o00.OooO0O0(2, oo0o0ooo);
                    }
                    i++;
                }
            }
            int i2 = this.OooO0o0;
            if (i2 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(4, i2);
            }
            int i3 = this.OooO0o;
            if (i3 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(5, i3);
            }
            int i4 = this.OooO0oO;
            if (i4 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(12, i4);
            }
            int i5 = this.OooO0oo;
            if (i5 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(13, i5);
            }
            int i6 = this.OooO;
            if (i6 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(14, i6);
            }
            int i7 = this.OooOO0;
            if (i7 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(15, i7);
            }
            long j = this.OooOO0O;
            if (j != 0) {
                iOooO0O0 += oO00o00.OooO0O0(16, j);
            }
            long j2 = this.OooOO0o;
            if (j2 != 0) {
                iOooO0O0 += oO00o00.OooO0O0(17, j2);
            }
            if (!this.OooOOO0.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(18, this.OooOOO0);
            }
            C1140OooO00o c1140OooO00o = this.OooOOO;
            if (c1140OooO00o != null) {
                iOooO0O0 += oO00o00.OooO0O0(19, c1140OooO00o);
            }
            int i8 = this.OooOOOO;
            if (i8 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(20, i8);
            }
            int i9 = this.OooOOOo;
            if (i9 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(21, i9);
            }
            int i10 = this.OooOOo0;
            if (i10 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(22, i10);
            }
            int i11 = this.OooOOo;
            if (i11 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(23, i11);
            }
            int i12 = this.OooOOoo;
            if (i12 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(24, i12);
            }
            int i13 = this.OooOo00;
            if (i13 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(25, i13);
            }
            if (!this.OooOo0.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(26, this.OooOo0);
            }
            if (!this.OooOo0O.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(27, this.OooOo0O);
            }
            if (!this.OooOo0o.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(28, this.OooOo0o);
            }
            boolean z = this.OooOo;
            if (z) {
                iOooO0O0 += oO00o00.OooO00o(29, z);
            }
            int i14 = this.OooOoO0;
            if (i14 != 0) {
                iOooO0O0 += oO00o00.OooO0OO(30, i14);
            }
            if (!this.OooOoO.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(31, this.OooOoO);
            }
            long j3 = this.OooOoOO;
            if (j3 != 0) {
                iOooO0O0 += oO00o00.OooO0O0(32, j3);
            }
            if (!this.OooOoo0.equals("")) {
                iOooO0O0 += oO00o00.OooO00o(33, this.OooOoo0);
            }
            boolean z2 = this.OooOoo;
            if (z2) {
                iOooO0O0 += oO00o00.OooO00o(34, z2);
            }
            int i15 = this.OooOooO;
            return i15 != 0 ? iOooO0O0 + oO00o00.OooO0OO(35, i15) : iOooO0O0;
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
        public OooO00o OooO00o(oO00o000 oo00o000) throws IOException {
            while (true) {
                int iOooOo0o = oo00o000.OooOo0o();
                switch (iOooOo0o) {
                    case 0:
                        return this;
                    case 10:
                        this.OooO0OO = oo00o000.OooOo0O();
                        break;
                    case 18:
                        int iOooO00o = oO0O000.OooO00o(oo00o000, 18);
                        oO0O0OoO[] oo0o0oooArr = this.OooO0Oo;
                        int length = oo0o0oooArr == null ? 0 : oo0o0oooArr.length;
                        int i = iOooO00o + length;
                        oO0O0OoO[] oo0o0oooArr2 = new oO0O0OoO[i];
                        if (length != 0) {
                            System.arraycopy(oo0o0oooArr, 0, oo0o0oooArr2, 0, length);
                        }
                        while (length < i - 1) {
                            oO0O0OoO oo0o0ooo = new oO0O0OoO();
                            oo0o0oooArr2[length] = oo0o0ooo;
                            oo00o000.OooO00o(oo0o0ooo);
                            oo00o000.OooOo0o();
                            length++;
                        }
                        oO0O0OoO oo0o0ooo2 = new oO0O0OoO();
                        oo0o0oooArr2[length] = oo0o0ooo2;
                        oo00o000.OooO00o(oo0o0ooo2);
                        this.OooO0Oo = oo0o0oooArr2;
                        break;
                    case 32:
                        this.OooO0o0 = oo00o000.OooOO0O();
                        break;
                    case 40:
                        this.OooO0o = oo00o000.OooOO0O();
                        break;
                    case 96:
                        this.OooO0oO = oo00o000.OooOO0O();
                        break;
                    case 104:
                        this.OooO0oo = oo00o000.OooOO0O();
                        break;
                    case 112:
                        this.OooO = oo00o000.OooOO0O();
                        break;
                    case 120:
                        this.OooOO0 = oo00o000.OooOO0O();
                        break;
                    case 128:
                        this.OooOO0O = oo00o000.OooOO0o();
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                        this.OooOO0o = oo00o000.OooOO0o();
                        break;
                    case 146:
                        this.OooOOO0 = oo00o000.OooOo0O();
                        break;
                    case 154:
                        if (this.OooOOO == null) {
                            this.OooOOO = new C1140OooO00o();
                        }
                        oo00o000.OooO00o(this.OooOOO);
                        break;
                    case 160:
                        this.OooOOOO = oo00o000.OooOO0O();
                        break;
                    case Opcodes.JSR /* 168 */:
                        this.OooOOOo = oo00o000.OooOO0O();
                        break;
                    case 176:
                        this.OooOOo0 = oo00o000.OooOO0O();
                        break;
                    case 184:
                        this.OooOOo = oo00o000.OooOO0O();
                        break;
                    case 192:
                        this.OooOOoo = oo00o000.OooOO0O();
                        break;
                    case 200:
                        this.OooOo00 = oo00o000.OooOO0O();
                        break;
                    case 210:
                        this.OooOo0 = oo00o000.OooOo0O();
                        break;
                    case JfifUtil.MARKER_SOS /* 218 */:
                        this.OooOo0O = oo00o000.OooOo0O();
                        break;
                    case 226:
                        this.OooOo0o = oo00o000.OooOo0O();
                        break;
                    case 232:
                        this.OooOo = oo00o000.OooO0Oo();
                        break;
                    case 240:
                        this.OooOoO0 = oo00o000.OooOO0O();
                        break;
                    case 250:
                        this.OooOoO = oo00o000.OooOo0O();
                        break;
                    case 256:
                        this.OooOoOO = oo00o000.OooOO0o();
                        break;
                    case 266:
                        this.OooOoo0 = oo00o000.OooOo0O();
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME /* 272 */:
                        this.OooOoo = oo00o000.OooO0Oo();
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
                        this.OooOooO = oo00o000.OooOO0O();
                        break;
                    default:
                        if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }

        public OooO00o OooO0o0() {
            this.OooO0OO = "";
            this.OooO0Oo = oO0O0OoO.OooO0o();
            this.OooO0o0 = 0;
            this.OooO0o = 0;
            this.OooO0oO = 0;
            this.OooO0oo = 0;
            this.OooO = 0;
            this.OooOO0 = 0;
            this.OooOO0O = 0L;
            this.OooOO0o = 0L;
            this.OooOOO0 = "";
            this.OooOOO = null;
            this.OooOOOO = 0;
            this.OooOOOo = 0;
            this.OooOOo0 = 0;
            this.OooOOo = 0;
            this.OooOOoo = 0;
            this.OooOo00 = 0;
            this.OooOo0 = "";
            this.OooOo0O = "";
            this.OooOo0o = "";
            this.OooOo = false;
            this.OooOoO0 = 0;
            this.OooOoO = "";
            this.OooOoOO = 0L;
            this.OooOoo0 = "";
            this.OooOoo = false;
            this.OooOooO = 0;
            this.OooO00o = -1;
            return this;
        }
    }

    public oO0OOo0o() {
        OooO0o0();
    }

    public static oO0OOo0o OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0OOo0o) oOo0000O.OooO00o(new oO0OOo0o(), bArr);
    }

    public static oO0OOo0o OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0OOo0o().OooO00o(oo00o000);
    }

    public static oO0OOo0o[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0OOo0o[0];
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
        boolean z = this.OooO0Oo;
        if (z) {
            oo00o00.OooO0O0(2, z);
        }
        OooO00o[] oooO00oArr = this.OooO0o0;
        if (oooO00oArr != null && oooO00oArr.length > 0) {
            int i2 = 0;
            while (true) {
                OooO00o[] oooO00oArr2 = this.OooO0o0;
                if (i2 >= oooO00oArr2.length) {
                    break;
                }
                OooO00o oooO00o = oooO00oArr2[i2];
                if (oooO00o != null) {
                    oo00o00.OooO0Oo(3, oooO00o);
                }
                i2++;
            }
        }
        boolean z2 = this.OooO0o;
        if (z2) {
            oo00o00.OooO0O0(4, z2);
        }
        if (!this.OooO0oO.equals("")) {
            oo00o00.OooO0O0(5, this.OooO0oO);
        }
        long j = this.OooO0oo;
        if (j != 0) {
            oo00o00.OooO0oO(6, j);
        }
        if (!this.OooO.equals("")) {
            oo00o00.OooO0O0(7, this.OooO);
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
        boolean z = this.OooO0Oo;
        if (z) {
            iOooO0O0 += oO00o00.OooO00o(2, z);
        }
        OooO00o[] oooO00oArr = this.OooO0o0;
        if (oooO00oArr != null && oooO00oArr.length > 0) {
            int i2 = 0;
            while (true) {
                OooO00o[] oooO00oArr2 = this.OooO0o0;
                if (i2 >= oooO00oArr2.length) {
                    break;
                }
                OooO00o oooO00o = oooO00oArr2[i2];
                if (oooO00o != null) {
                    iOooO0O0 += oO00o00.OooO0O0(3, oooO00o);
                }
                i2++;
            }
        }
        boolean z2 = this.OooO0o;
        if (z2) {
            iOooO0O0 += oO00o00.OooO00o(4, z2);
        }
        if (!this.OooO0oO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(5, this.OooO0oO);
        }
        long j = this.OooO0oo;
        if (j != 0) {
            iOooO0O0 += oO00o00.OooO0O0(6, j);
        }
        return !this.OooO.equals("") ? iOooO0O0 + oO00o00.OooO00o(7, this.OooO) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0OOo0o OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 8) {
                this.OooO0OO = oo00o000.OooOO0O();
            } else if (iOooOo0o == 16) {
                this.OooO0Oo = oo00o000.OooO0Oo();
            } else if (iOooOo0o == 26) {
                int iOooO00o = oO0O000.OooO00o(oo00o000, 26);
                OooO00o[] oooO00oArr = this.OooO0o0;
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
                this.OooO0o0 = oooO00oArr2;
            } else if (iOooOo0o == 32) {
                this.OooO0o = oo00o000.OooO0Oo();
            } else if (iOooOo0o == 42) {
                this.OooO0oO = oo00o000.OooOo0O();
            } else if (iOooOo0o == 48) {
                this.OooO0oo = oo00o000.OooOO0o();
            } else if (iOooOo0o == 58) {
                this.OooO = oo00o000.OooOo0O();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO0OOo0o OooO0o0() {
        this.OooO0OO = 0;
        this.OooO0Oo = false;
        this.OooO0o0 = OooO00o.OooO0o();
        this.OooO0o = false;
        this.OooO0oO = "";
        this.OooO0oo = 0L;
        this.OooO = "";
        this.OooO00o = -1;
        return this;
    }
}
