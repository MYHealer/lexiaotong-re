package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0O000o extends oOo0000O {
    private static volatile oO0O000o[] OooO0O0;
    public String[] OooO;
    public String[] OooO0OO;
    public String[] OooO0Oo;
    public String OooO0o;
    public String[] OooO0o0;
    public String[] OooO0oO;
    public String[] OooO0oo;
    public String OooOO0;

    public oO0O000o() {
        OooO0o0();
    }

    public static oO0O000o OooO00o(byte[] bArr) throws oO0OO00o {
        return (oO0O000o) oOo0000O.OooO00o(new oO0O000o(), bArr);
    }

    public static oO0O000o OooO0OO(oO00o000 oo00o000) throws IOException {
        return new oO0O000o().OooO00o(oo00o000);
    }

    public static oO0O000o[] OooO0o() {
        if (OooO0O0 == null) {
            synchronized (oOo00ooO.OooOo0) {
                if (OooO0O0 == null) {
                    OooO0O0 = new oO0O000o[0];
                }
            }
        }
        return OooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        String[] strArr = this.OooO0OO;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.OooO0OO;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    oo00o00.OooO0O0(1, str);
                }
                i2++;
            }
        }
        String[] strArr3 = this.OooO0Oo;
        if (strArr3 != null && strArr3.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.OooO0Oo;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    oo00o00.OooO0O0(2, str2);
                }
                i3++;
            }
        }
        String[] strArr5 = this.OooO0o0;
        if (strArr5 != null && strArr5.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr6 = this.OooO0o0;
                if (i4 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i4];
                if (str3 != null) {
                    oo00o00.OooO0O0(3, str3);
                }
                i4++;
            }
        }
        if (!this.OooO0o.equals("")) {
            oo00o00.OooO0O0(4, this.OooO0o);
        }
        String[] strArr7 = this.OooO0oO;
        if (strArr7 != null && strArr7.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr8 = this.OooO0oO;
                if (i5 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i5];
                if (str4 != null) {
                    oo00o00.OooO0O0(5, str4);
                }
                i5++;
            }
        }
        String[] strArr9 = this.OooO0oo;
        if (strArr9 != null && strArr9.length > 0) {
            int i6 = 0;
            while (true) {
                String[] strArr10 = this.OooO0oo;
                if (i6 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i6];
                if (str5 != null) {
                    oo00o00.OooO0O0(6, str5);
                }
                i6++;
            }
        }
        String[] strArr11 = this.OooO;
        if (strArr11 != null && strArr11.length > 0) {
            while (true) {
                String[] strArr12 = this.OooO;
                if (i >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i];
                if (str6 != null) {
                    oo00o00.OooO0O0(7, str6);
                }
                i++;
            }
        }
        if (!this.OooOO0.equals("")) {
            oo00o00.OooO0O0(8, this.OooOO0);
        }
        super.OooO00o(oo00o00);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        int iOooO0O0 = super.OooO0O0();
        String[] strArr = this.OooO0OO;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iOooO00o = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.OooO0OO;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iOooO00o += oO00o00.OooO00o(str);
                }
                i2++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o + i3;
        }
        String[] strArr3 = this.OooO0Oo;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            int iOooO00o2 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr4 = this.OooO0Oo;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    i5++;
                    iOooO00o2 += oO00o00.OooO00o(str2);
                }
                i4++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o2 + i5;
        }
        String[] strArr5 = this.OooO0o0;
        if (strArr5 != null && strArr5.length > 0) {
            int i6 = 0;
            int iOooO00o3 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr6 = this.OooO0o0;
                if (i6 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i6];
                if (str3 != null) {
                    i7++;
                    iOooO00o3 += oO00o00.OooO00o(str3);
                }
                i6++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o3 + i7;
        }
        if (!this.OooO0o.equals("")) {
            iOooO0O0 += oO00o00.OooO00o(4, this.OooO0o);
        }
        String[] strArr7 = this.OooO0oO;
        if (strArr7 != null && strArr7.length > 0) {
            int i8 = 0;
            int iOooO00o4 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr8 = this.OooO0oO;
                if (i8 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i8];
                if (str4 != null) {
                    i9++;
                    iOooO00o4 += oO00o00.OooO00o(str4);
                }
                i8++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o4 + i9;
        }
        String[] strArr9 = this.OooO0oo;
        if (strArr9 != null && strArr9.length > 0) {
            int i10 = 0;
            int iOooO00o5 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr10 = this.OooO0oo;
                if (i10 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i10];
                if (str5 != null) {
                    i11++;
                    iOooO00o5 += oO00o00.OooO00o(str5);
                }
                i10++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o5 + i11;
        }
        String[] strArr11 = this.OooO;
        if (strArr11 != null && strArr11.length > 0) {
            int iOooO00o6 = 0;
            int i12 = 0;
            while (true) {
                String[] strArr12 = this.OooO;
                if (i >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i];
                if (str6 != null) {
                    i12++;
                    iOooO00o6 += oO00o00.OooO00o(str6);
                }
                i++;
            }
            iOooO0O0 = iOooO0O0 + iOooO00o6 + i12;
        }
        return !this.OooOO0.equals("") ? iOooO0O0 + oO00o00.OooO00o(8, this.OooOO0) : iOooO0O0;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0O0, reason: merged with bridge method [inline-methods] */
    public oO0O000o OooO00o(oO00o000 oo00o000) throws IOException {
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                return this;
            }
            if (iOooOo0o == 10) {
                int iOooO00o = oO0O000.OooO00o(oo00o000, 10);
                String[] strArr = this.OooO0OO;
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
                this.OooO0OO = strArr2;
            } else if (iOooOo0o == 18) {
                int iOooO00o2 = oO0O000.OooO00o(oo00o000, 18);
                String[] strArr3 = this.OooO0Oo;
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
                this.OooO0Oo = strArr4;
            } else if (iOooOo0o == 26) {
                int iOooO00o3 = oO0O000.OooO00o(oo00o000, 26);
                String[] strArr5 = this.OooO0o0;
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
                this.OooO0o0 = strArr6;
            } else if (iOooOo0o == 34) {
                this.OooO0o = oo00o000.OooOo0O();
            } else if (iOooOo0o == 42) {
                int iOooO00o4 = oO0O000.OooO00o(oo00o000, 42);
                String[] strArr7 = this.OooO0oO;
                int length4 = strArr7 == null ? 0 : strArr7.length;
                int i4 = iOooO00o4 + length4;
                String[] strArr8 = new String[i4];
                if (length4 != 0) {
                    System.arraycopy(strArr7, 0, strArr8, 0, length4);
                }
                while (length4 < i4 - 1) {
                    strArr8[length4] = oo00o000.OooOo0O();
                    oo00o000.OooOo0o();
                    length4++;
                }
                strArr8[length4] = oo00o000.OooOo0O();
                this.OooO0oO = strArr8;
            } else if (iOooOo0o == 50) {
                int iOooO00o5 = oO0O000.OooO00o(oo00o000, 50);
                String[] strArr9 = this.OooO0oo;
                int length5 = strArr9 == null ? 0 : strArr9.length;
                int i5 = iOooO00o5 + length5;
                String[] strArr10 = new String[i5];
                if (length5 != 0) {
                    System.arraycopy(strArr9, 0, strArr10, 0, length5);
                }
                while (length5 < i5 - 1) {
                    strArr10[length5] = oo00o000.OooOo0O();
                    oo00o000.OooOo0o();
                    length5++;
                }
                strArr10[length5] = oo00o000.OooOo0O();
                this.OooO0oo = strArr10;
            } else if (iOooOo0o == 58) {
                int iOooO00o6 = oO0O000.OooO00o(oo00o000, 58);
                String[] strArr11 = this.OooO;
                int length6 = strArr11 == null ? 0 : strArr11.length;
                int i6 = iOooO00o6 + length6;
                String[] strArr12 = new String[i6];
                if (length6 != 0) {
                    System.arraycopy(strArr11, 0, strArr12, 0, length6);
                }
                while (length6 < i6 - 1) {
                    strArr12[length6] = oo00o000.OooOo0O();
                    oo00o000.OooOo0o();
                    length6++;
                }
                strArr12[length6] = oo00o000.OooOo0O();
                this.OooO = strArr12;
            } else if (iOooOo0o == 66) {
                this.OooOO0 = oo00o000.OooOo0O();
            } else if (!oO0O000.OooO0O0(oo00o000, iOooOo0o)) {
                return this;
            }
        }
    }

    public oO0O000o OooO0o0() {
        String[] strArr = oO0O000.OooOOO;
        this.OooO0OO = strArr;
        this.OooO0Oo = strArr;
        this.OooO0o0 = strArr;
        this.OooO0o = "";
        this.OooO0oO = strArr;
        this.OooO0oo = strArr;
        this.OooO = strArr;
        this.OooOO0 = "";
        this.OooO00o = -1;
        return this;
    }
}
