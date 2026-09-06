package com.ubixnow.ooooo;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O0OoO extends oOo0000O {
    private static volatile oO0O0OoO[] OooO0O0;
    public long OooO;
    public int OooO0OO;
    public String OooO0Oo;
    public String OooO0o;
    public String OooO0o0;
    public String OooO0oO;
    public String OooO0oo;
    public int OooOO0;
    public int OooOO0O;
    public long OooOO0o;
    public int OooOOO;
    public String OooOOO0;
    public boolean OooOOOO;
    public int OooOOOo;
    public int OooOOo;
    public int OooOOo0;
    public OooO00o OooOOoo;

    public static final class OooO00o extends oOo0000O {
        private static volatile OooO00o[] OooO0O0;
        public boolean OooO0OO;
        public int OooO0Oo;
        public int OooO0o0;

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
            boolean z = this.OooO0OO;
            if (z) {
                oo00o00.OooO0O0(1, z);
            }
            int i = this.OooO0Oo;
            if (i != 0) {
                oo00o00.OooOOO0(2, i);
            }
            int i2 = this.OooO0o0;
            if (i2 != 0) {
                oo00o00.OooOOO0(3, i2);
            }
            super.OooO00o(oo00o00);
        }

        @Override // com.ubixnow.ooooo.oOo0000O
        public int OooO0O0() {
            int iOooO0O0 = super.OooO0O0();
            boolean z = this.OooO0OO;
            if (z) {
                iOooO0O0 += oO00o00.OooO00o(1, z);
            }
            int i = this.OooO0Oo;
            if (i != 0) {
                iOooO0O0 += oO00o00.OooO0o(2, i);
            }
            int i2 = this.OooO0o0;
            return i2 != 0 ? iOooO0O0 + oO00o00.OooO0o(3, i2) : iOooO0O0;
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
                    this.OooO0OO = oo00o000.OooO0Oo();
                } else if (iOooOo0o == 16) {
                    this.OooO0Oo = oo00o000.OooOo();
                } else if (iOooOo0o == 24) {
                    this.OooO0o0 = oo00o000.OooOo();
                } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                    return this;
                }
            }
        }

        public OooO00o OooO0o0() {
            this.OooO0OO = false;
            this.OooO0Oo = 0;
            this.OooO0o0 = 0;
            this.OooO00o = -1;
            return this;
        }
    }

    public oO0O0OoO() {
        OooO0o0();
    }

    public static oO0O0OoO OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0O0OoO) oOo0000O.OooO00o(new oO0O0OoO(), bArr);
    }

    public static oO0O0OoO OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0O0OoO().OooO00o(oo00o000);
    }

    public static oO0O0OoO[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0O0OoO[0];
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
        if (!this.OooO0o.equals("")) {
            oo00o00.OooO0O0(4, this.OooO0o);
        }
        if (!this.OooO0oO.equals("")) {
            oo00o00.OooO0O0(5, this.OooO0oO);
        }
        if (!this.OooO0oo.equals("")) {
            oo00o00.OooO0O0(6, this.OooO0oo);
        }
        long j = this.OooO;
        if (j != 0) {
            oo00o00.OooO0oO(8, j);
        }
        int i2 = this.OooOO0;
        if (i2 != 0) {
            oo00o00.OooO(9, i2);
        }
        int i3 = this.OooOO0O;
        if (i3 != 0) {
            oo00o00.OooO(10, i3);
        }
        long j2 = this.OooOO0o;
        if (j2 != 0) {
            oo00o00.OooO0oO(11, j2);
        }
        if (!this.OooOOO0.equals("")) {
            oo00o00.OooO0O0(12, this.OooOOO0);
        }
        int i4 = this.OooOOO;
        if (i4 != 0) {
            oo00o00.OooO(13, i4);
        }
        boolean z = this.OooOOOO;
        if (z) {
            oo00o00.OooO0O0(14, z);
        }
        int i5 = this.OooOOOo;
        if (i5 != 0) {
            oo00o00.OooO(15, i5);
        }
        int i6 = this.OooOOo0;
        if (i6 != 0) {
            oo00o00.OooO(16, i6);
        }
        int i7 = this.OooOOo;
        if (i7 != 0) {
            oo00o00.OooO(17, i7);
        }
        OooO00o oooO00o = this.OooOOoo;
        if (oooO00o != null) {
            oo00o00.OooO0Oo(18, oooO00o);
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
        if (!this.OooO0o.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(4, this.OooO0o);
        }
        if (!this.OooO0oO.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(5, this.OooO0oO);
        }
        if (!this.OooO0oo.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(6, this.OooO0oo);
        }
        long j = this.OooO;
        if (j != 0) {
            iOooO0O0 += oO00o00.OooO0O0(8, j);
        }
        int i2 = this.OooOO0;
        if (i2 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(9, i2);
        }
        int i3 = this.OooOO0O;
        if (i3 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(10, i3);
        }
        long j2 = this.OooOO0o;
        if (j2 != 0) {
            iOooO0O0 += oO00o00.OooO0O0(11, j2);
        }
        if (!this.OooOOO0.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(12, this.OooOOO0);
        }
        int i4 = this.OooOOO;
        if (i4 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(13, i4);
        }
        boolean z = this.OooOOOO;
        if (z) {
            iOooO0O0 += oO00o00.OooO00o(14, z);
        }
        int i5 = this.OooOOOo;
        if (i5 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(15, i5);
        }
        int i6 = this.OooOOo0;
        if (i6 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(16, i6);
        }
        int i7 = this.OooOOo;
        if (i7 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(17, i7);
        }
        OooO00o oooO00o = this.OooOOoo;
        return oooO00o != null ? iOooO0O0 + oO00o00.OooO0O0(18, oooO00o) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0O0OoO OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            switch (iOooOo0o) {
                case 0:
                    return this;
                case 8:
                    this.OooO0OO = oo00o000.OooOO0O();
                    break;
                case 18:
                    this.OooO0Oo = oo00o000.OooOo0O();
                    break;
                case 26:
                    this.OooO0o0 = oo00o000.OooOo0O();
                    break;
                case 34:
                    this.OooO0o = oo00o000.OooOo0O();
                    break;
                case 42:
                    this.OooO0oO = oo00o000.OooOo0O();
                    break;
                case 50:
                    this.OooO0oo = oo00o000.OooOo0O();
                    break;
                case 64:
                    this.OooO = oo00o000.OooOO0o();
                    break;
                case 72:
                    this.OooOO0 = oo00o000.OooOO0O();
                    break;
                case 80:
                    this.OooOO0O = oo00o000.OooOO0O();
                    break;
                case 88:
                    this.OooOO0o = oo00o000.OooOO0o();
                    break;
                case 98:
                    this.OooOOO0 = oo00o000.OooOo0O();
                    break;
                case 104:
                    this.OooOOO = oo00o000.OooOO0O();
                    break;
                case 112:
                    this.OooOOOO = oo00o000.OooO0Oo();
                    break;
                case 120:
                    this.OooOOOo = oo00o000.OooOO0O();
                    break;
                case 128:
                    this.OooOOo0 = oo00o000.OooOO0O();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                    this.OooOOo = oo00o000.OooOO0O();
                    break;
                case 146:
                    if (this.OooOOoo == null) {
                        this.OooOOoo = new OooO00o();
                    }
                    oo00o000.OooO00o(this.OooOOoo);
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

    public oO0O0OoO OooO0o0() {
        this.OooO0OO = 0;
        this.OooO0Oo = "";
        this.OooO0o0 = "";
        this.OooO0o = "";
        this.OooO0oO = "";
        this.OooO0oo = "";
        this.OooO = 0L;
        this.OooOO0 = 0;
        this.OooOO0O = 0;
        this.OooOO0o = 0L;
        this.OooOOO0 = "";
        this.OooOOO = 0;
        this.OooOOOO = false;
        this.OooOOOo = 0;
        this.OooOOo0 = 0;
        this.OooOOo = 0;
        this.OooOOoo = null;
        this.OooO00o = -1;
        return this;
    }
}
