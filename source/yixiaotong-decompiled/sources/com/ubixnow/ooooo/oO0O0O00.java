package com.ubixnow.ooooo;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O0O00 extends oOo0000O {
    private static volatile oO0O0O00[] OooO0O0;
    public int OooO;
    public int OooO0OO;
    public oO0O0 OooO0Oo;
    public int OooO0o;
    public boolean OooO0o0;
    public boolean OooO0oO;
    public int OooO0oo;
    public Map<String, String> OooOO0;
    public Map<String, String> OooOO0O;
    public String[] OooOO0o;
    public boolean OooOOO;
    public String[] OooOOO0;
    public boolean OooOOOO;
    public boolean OooOOOo;
    public boolean OooOOo;
    public boolean OooOOo0;
    public boolean OooOOoo;
    public int OooOo;
    public boolean OooOo0;
    public boolean OooOo00;
    public String OooOo0O;
    public int OooOo0o;
    public int OooOoO;
    public int OooOoO0;
    public int OooOoOO;
    public int OooOoo;
    public int OooOoo0;
    public long OooOooO;
    public int OooOooo;
    public boolean Oooo0;
    public String[] Oooo000;
    public int Oooo00O;
    public String Oooo00o;
    public int Oooo0O0;
    public int Oooo0OO;
    public String Oooo0o0;

    public oO0O0O00() {
        OooO0o0();
    }

    public static oO0O0O00 OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0O0O00) oOo0000O.OooO00o(new oO0O0O00(), bArr);
    }

    public static oO0O0O00 OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0O0O00().OooO00o(oo00o000);
    }

    public static oO0O0O00[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0O0O00[0];
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
        oO0O0 oo0o0 = this.OooO0Oo;
        if (oo0o0 != null) {
            oo00o00.OooO0Oo(2, oo0o0);
        }
        boolean z = this.OooO0o0;
        if (z) {
            oo00o00.OooO0O0(3, z);
        }
        int i2 = this.OooO0o;
        if (i2 != 0) {
            oo00o00.OooO(4, i2);
        }
        boolean z2 = this.OooO0oO;
        if (z2) {
            oo00o00.OooO0O0(5, z2);
        }
        int i3 = this.OooO0oo;
        if (i3 != 0) {
            oo00o00.OooO(6, i3);
        }
        int i4 = this.OooO;
        if (i4 != 0) {
            oo00o00.OooO(7, i4);
        }
        Map<String, String> map = this.OooOO0;
        if (map != null) {
            oOo00ooO.OooO00o(oo00o00, map, 8, 9, 9);
        }
        Map<String, String> map2 = this.OooOO0O;
        if (map2 != null) {
            oOo00ooO.OooO00o(oo00o00, map2, 9, 9, 9);
        }
        String[] strArr = this.OooOO0o;
        int i5 = 0;
        if (strArr != null && strArr.length > 0) {
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.OooOO0o;
                if (i6 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i6];
                if (str != null) {
                    oo00o00.OooO0O0(10, str);
                }
                i6++;
            }
        }
        String[] strArr3 = this.OooOOO0;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            while (true) {
                String[] strArr4 = this.OooOOO0;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i7];
                if (str2 != null) {
                    oo00o00.OooO0O0(11, str2);
                }
                i7++;
            }
        }
        boolean z3 = this.OooOOO;
        if (z3) {
            oo00o00.OooO0O0(12, z3);
        }
        boolean z4 = this.OooOOOO;
        if (z4) {
            oo00o00.OooO0O0(13, z4);
        }
        boolean z5 = this.OooOOOo;
        if (z5) {
            oo00o00.OooO0O0(14, z5);
        }
        boolean z6 = this.OooOOo0;
        if (z6) {
            oo00o00.OooO0O0(15, z6);
        }
        boolean z7 = this.OooOOo;
        if (z7) {
            oo00o00.OooO0O0(16, z7);
        }
        boolean z8 = this.OooOOoo;
        if (z8) {
            oo00o00.OooO0O0(17, z8);
        }
        boolean z9 = this.OooOo00;
        if (z9) {
            oo00o00.OooO0O0(18, z9);
        }
        boolean z10 = this.OooOo0;
        if (z10) {
            oo00o00.OooO0O0(19, z10);
        }
        if (!this.OooOo0O.equals("")) {
            oo00o00.OooO0O0(20, this.OooOo0O);
        }
        int i8 = this.OooOo0o;
        if (i8 != 0) {
            oo00o00.OooO(21, i8);
        }
        int i9 = this.OooOo;
        if (i9 != 0) {
            oo00o00.OooO(22, i9);
        }
        int i10 = this.OooOoO0;
        if (i10 != 0) {
            oo00o00.OooO(23, i10);
        }
        int i11 = this.OooOoO;
        if (i11 != 0) {
            oo00o00.OooO(24, i11);
        }
        int i12 = this.OooOoOO;
        if (i12 != 0) {
            oo00o00.OooO(25, i12);
        }
        int i13 = this.OooOoo0;
        if (i13 != 0) {
            oo00o00.OooO(26, i13);
        }
        int i14 = this.OooOoo;
        if (i14 != 0) {
            oo00o00.OooO(27, i14);
        }
        long j = this.OooOooO;
        if (j != 0) {
            oo00o00.OooO0oO(28, j);
        }
        int i15 = this.OooOooo;
        if (i15 != 0) {
            oo00o00.OooO(29, i15);
        }
        String[] strArr5 = this.Oooo000;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.Oooo000;
                if (i5 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i5];
                if (str3 != null) {
                    oo00o00.OooO0O0(30, str3);
                }
                i5++;
            }
        }
        int i16 = this.Oooo00O;
        if (i16 != 0) {
            oo00o00.OooO(31, i16);
        }
        if (!this.Oooo00o.equals("")) {
            oo00o00.OooO0O0(33, this.Oooo00o);
        }
        boolean z11 = this.Oooo0;
        if (z11) {
            oo00o00.OooO0O0(34, z11);
        }
        int i17 = this.Oooo0O0;
        if (i17 != 0) {
            oo00o00.OooO(35, i17);
        }
        int i18 = this.Oooo0OO;
        if (i18 != 0) {
            oo00o00.OooO(36, i18);
        }
        if (!this.Oooo0o0.equals("")) {
            oo00o00.OooO0O0(37, this.Oooo0o0);
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
        oO0O0 oo0o0 = this.OooO0Oo;
        if (oo0o0 != null) {
            iOooO0O0 += oO00o00.OooO0O0(2, oo0o0);
        }
        boolean z = this.OooO0o0;
        if (z) {
            iOooO0O0 += oO00o00.OooO00o(3, z);
        }
        int i2 = this.OooO0o;
        if (i2 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(4, i2);
        }
        boolean z2 = this.OooO0oO;
        if (z2) {
            iOooO0O0 += oO00o00.OooO00o(5, z2);
        }
        int i3 = this.OooO0oo;
        if (i3 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(6, i3);
        }
        int i4 = this.OooO;
        if (i4 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(7, i4);
        }
        Map<String, String> map = this.OooOO0;
        if (map != null) {
            iOooO0O0 += oOo00ooO.OooO00o(map, 8, 9, 9);
        }
        Map<String, String> map2 = this.OooOO0O;
        if (map2 != null) {
            iOooO0O0 += oOo00ooO.OooO00o(map2, 9, 9, 9);
        }
        String[] strArr = this.OooOO0o;
        int i5 = 0;
        if (strArr != null && strArr.length > 0) {
            int i6 = 0;
            int iOooO00o = 0;
            int i7 = 0;
            while (true) {
                String[] strArr2 = this.OooOO0o;
                if (i6 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i6];
                if (str != null) {
                    i7++;
                    iOooO00o += oO00o00.OooO00o(str);
                }
                i6++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o + i7;
        }
        String[] strArr3 = this.OooOOO0;
        if (strArr3 != null && strArr3.length > 0) {
            int i8 = 0;
            int iOooO00o2 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.OooOOO0;
                if (i8 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i8];
                if (str2 != null) {
                    i9++;
                    iOooO00o2 += oO00o00.OooO00o(str2);
                }
                i8++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o2 + i9;
        }
        boolean z3 = this.OooOOO;
        if (z3) {
            iOooO0O0 += oO00o00.OooO00o(12, z3);
        }
        boolean z4 = this.OooOOOO;
        if (z4) {
            iOooO0O0 += oO00o00.OooO00o(13, z4);
        }
        boolean z5 = this.OooOOOo;
        if (z5) {
            iOooO0O0 += oO00o00.OooO00o(14, z5);
        }
        boolean z6 = this.OooOOo0;
        if (z6) {
            iOooO0O0 += oO00o00.OooO00o(15, z6);
        }
        boolean z7 = this.OooOOo;
        if (z7) {
            iOooO0O0 += oO00o00.OooO00o(16, z7);
        }
        boolean z8 = this.OooOOoo;
        if (z8) {
            iOooO0O0 += oO00o00.OooO00o(17, z8);
        }
        boolean z9 = this.OooOo00;
        if (z9) {
            iOooO0O0 += oO00o00.OooO00o(18, z9);
        }
        boolean z10 = this.OooOo0;
        if (z10) {
            iOooO0O0 += oO00o00.OooO00o(19, z10);
        }
        if (!this.OooOo0O.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(20, this.OooOo0O);
        }
        int i10 = this.OooOo0o;
        if (i10 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(21, i10);
        }
        int i11 = this.OooOo;
        if (i11 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(22, i11);
        }
        int i12 = this.OooOoO0;
        if (i12 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(23, i12);
        }
        int i13 = this.OooOoO;
        if (i13 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(24, i13);
        }
        int i14 = this.OooOoOO;
        if (i14 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(25, i14);
        }
        int i15 = this.OooOoo0;
        if (i15 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(26, i15);
        }
        int i16 = this.OooOoo;
        if (i16 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(27, i16);
        }
        long j = this.OooOooO;
        if (j != 0) {
            iOooO0O0 += oO00o00.OooO0O0(28, j);
        }
        int i17 = this.OooOooo;
        if (i17 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(29, i17);
        }
        String[] strArr5 = this.Oooo000;
        if (strArr5 != null && strArr5.length > 0) {
            int iOooO00o3 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr6 = this.Oooo000;
                if (i5 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i5];
                if (str3 != null) {
                    i18++;
                    iOooO00o3 += oO00o00.OooO00o(str3);
                }
                i5++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o3 + (i18 * 2);
        }
        int i19 = this.Oooo00O;
        if (i19 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(31, i19);
        }
        if (!this.Oooo00o.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(33, this.Oooo00o);
        }
        boolean z11 = this.Oooo0;
        if (z11) {
            iOooO0O0 += oO00o00.OooO00o(34, z11);
        }
        int i20 = this.Oooo0O0;
        if (i20 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(35, i20);
        }
        int i21 = this.Oooo0OO;
        if (i21 != 0) {
            iOooO0O0 += oO00o00.OooO0OO(36, i21);
        }
        return !this.Oooo0o0.equals("") ? iOooO0O0 + oO00o00.OooO00o(37, this.Oooo0o0) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0O0O00 OooO00o(oO00o000 oo00o000) throws IOException {
        oOo000Oo.OooO0OO oooO0OOOooO00o = oOo000Oo.OooO00o();
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            switch (iOooOo0o) {
                case 0:
                    return this;
                case 8:
                    this.OooO0OO = oo00o000.OooOO0O();
                    break;
                case 18:
                    if (this.OooO0Oo == null) {
                        this.OooO0Oo = new oO0O0();
                    }
                    oo00o000.OooO00o(this.OooO0Oo);
                    break;
                case 24:
                    this.OooO0o0 = oo00o000.OooO0Oo();
                    break;
                case 32:
                    this.OooO0o = oo00o000.OooOO0O();
                    break;
                case 40:
                    this.OooO0oO = oo00o000.OooO0Oo();
                    break;
                case 48:
                    this.OooO0oo = oo00o000.OooOO0O();
                    break;
                case 56:
                    this.OooO = oo00o000.OooOO0O();
                    break;
                case 66:
                    this.OooOO0 = oOo00ooO.OooO00o(oo00o000, this.OooOO0, oooO0OOOooO00o, 9, 9, null, 10, 18);
                    break;
                case 74:
                    this.OooOO0O = oOo00ooO.OooO00o(oo00o000, this.OooOO0O, oooO0OOOooO00o, 9, 9, null, 10, 18);
                    break;
                case 82:
                    int iOooO00o = oO0O000.OooO00o(oo00o000, 82);
                    String[] strArr = this.OooOO0o;
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
                    this.OooOO0o = strArr2;
                    break;
                case 90:
                    int iOooO00o2 = oO0O000.OooO00o(oo00o000, 90);
                    String[] strArr3 = this.OooOOO0;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i2 = iOooO00o2 + length2;
                    String[] strArr4 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr4[length2] = oo00o000.OooOo0O();
                        oo00o000.OooOo0o();
                        length2++;
                    }
                    strArr4[length2] = oo00o000.OooOo0O();
                    this.OooOOO0 = strArr4;
                    break;
                case 96:
                    this.OooOOO = oo00o000.OooO0Oo();
                    break;
                case 104:
                    this.OooOOOO = oo00o000.OooO0Oo();
                    break;
                case 112:
                    this.OooOOOo = oo00o000.OooO0Oo();
                    break;
                case 120:
                    this.OooOOo0 = oo00o000.OooO0Oo();
                    break;
                case 128:
                    this.OooOOo = oo00o000.OooO0Oo();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                    this.OooOOoo = oo00o000.OooO0Oo();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                    this.OooOo00 = oo00o000.OooO0Oo();
                    break;
                case 152:
                    this.OooOo0 = oo00o000.OooO0Oo();
                    break;
                case 162:
                    this.OooOo0O = oo00o000.OooOo0O();
                    break;
                case Opcodes.JSR /* 168 */:
                    this.OooOo0o = oo00o000.OooOO0O();
                    break;
                case 176:
                    this.OooOo = oo00o000.OooOO0O();
                    break;
                case 184:
                    this.OooOoO0 = oo00o000.OooOO0O();
                    break;
                case 192:
                    this.OooOoO = oo00o000.OooOO0O();
                    break;
                case 200:
                    this.OooOoOO = oo00o000.OooOO0O();
                    break;
                case 208:
                    this.OooOoo0 = oo00o000.OooOO0O();
                    break;
                case 216:
                    this.OooOoo = oo00o000.OooOO0O();
                    break;
                case 224:
                    this.OooOooO = oo00o000.OooOO0o();
                    break;
                case 232:
                    this.OooOooo = oo00o000.OooOO0O();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                    int iOooO00o3 = oO0O000.OooO00o(oo00o000, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE);
                    String[] strArr5 = this.Oooo000;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    int i3 = iOooO00o3 + length3;
                    String[] strArr6 = new String[i3];
                    if (length3 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        strArr6[length3] = oo00o000.OooOo0O();
                        oo00o000.OooOo0o();
                        length3++;
                    }
                    strArr6[length3] = oo00o000.OooOo0O();
                    this.Oooo000 = strArr6;
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                    this.Oooo00O = oo00o000.OooOO0O();
                    break;
                case 266:
                    this.Oooo00o = oo00o000.OooOo0O();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME /* 272 */:
                    this.Oooo0 = oo00o000.OooO0Oo();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
                    this.Oooo0O0 = oo00o000.OooOO0O();
                    break;
                case 288:
                    this.Oooo0OO = oo00o000.OooOO0O();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX /* 298 */:
                    this.Oooo0o0 = oo00o000.OooOo0O();
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

    public oO0O0O00 OooO0o0() {
        this.OooO0OO = 0;
        this.OooO0Oo = null;
        this.OooO0o0 = false;
        this.OooO0o = 0;
        this.OooO0oO = false;
        this.OooO0oo = 0;
        this.OooO = 0;
        this.OooOO0 = null;
        this.OooOO0O = null;
        String[] strArr = oO0O000.OooOOO;
        this.OooOO0o = strArr;
        this.OooOOO0 = strArr;
        this.OooOOO = false;
        this.OooOOOO = false;
        this.OooOOOo = false;
        this.OooOOo0 = false;
        this.OooOOo = false;
        this.OooOOoo = false;
        this.OooOo00 = false;
        this.OooOo0 = false;
        this.OooOo0O = "";
        this.OooOo0o = 0;
        this.OooOo = 0;
        this.OooOoO0 = 0;
        this.OooOoO = 0;
        this.OooOoOO = 0;
        this.OooOoo0 = 0;
        this.OooOoo = 0;
        this.OooOooO = 0L;
        this.OooOooo = 0;
        this.Oooo000 = strArr;
        this.Oooo00O = 0;
        this.Oooo00o = "";
        this.Oooo0 = false;
        this.Oooo0O0 = 0;
        this.Oooo0OO = 0;
        this.Oooo0o0 = "";
        this.OooO00o = -1;
        return this;
    }
}
