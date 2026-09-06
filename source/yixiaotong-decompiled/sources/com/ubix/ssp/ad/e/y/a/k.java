package com.ubix.ssp.ad.e.y.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k extends com.ubix.ssp.ad.e.y.c.f {
    public String b;
    public String[] c;
    public String d;
    public String[] e;
    public String[] f;
    public String[] g;
    public int h;
    public int i;

    public k() {
        e();
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    public void a(com.ubix.ssp.ad.e.y.c.b bVar) throws com.ubix.ssp.ad.e.y.c.b.a {
        if (!this.b.equals("")) {
            bVar.b(1, this.b);
        }
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    bVar.b(4, str);
                }
                i2++;
            }
        }
        String[] strArr3 = this.e;
        if (strArr3 != null && strArr3.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.e;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    bVar.b(5, str2);
                }
                i3++;
            }
        }
        if (!this.d.equals("")) {
            bVar.b(6, this.d);
        }
        String[] strArr5 = this.f;
        if (strArr5 != null && strArr5.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr6 = this.f;
                if (i4 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i4];
                if (str3 != null) {
                    bVar.b(7, str3);
                }
                i4++;
            }
        }
        String[] strArr7 = this.g;
        if (strArr7 != null && strArr7.length > 0) {
            while (true) {
                String[] strArr8 = this.g;
                if (i >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i];
                if (str4 != null) {
                    bVar.b(8, str4);
                }
                i++;
            }
        }
        int i5 = this.h;
        if (i5 != 0) {
            bVar.m(9, i5);
        }
        int i6 = this.i;
        if (i6 != 0) {
            bVar.m(10, i6);
        }
        super.a(bVar);
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    protected int b() {
        int iB = super.b();
        if (!this.b.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(1, this.b);
        }
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iA = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iA += com.ubix.ssp.ad.e.y.c.b.a(str);
                }
                i2++;
            }
            iB = iB + iA + i3;
        }
        String[] strArr3 = this.e;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            int iA2 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr4 = this.e;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    i5++;
                    iA2 += com.ubix.ssp.ad.e.y.c.b.a(str2);
                }
                i4++;
            }
            iB = iB + iA2 + i5;
        }
        if (!this.d.equals("")) {
            iB += com.ubix.ssp.ad.e.y.c.b.a(6, this.d);
        }
        String[] strArr5 = this.f;
        if (strArr5 != null && strArr5.length > 0) {
            int i6 = 0;
            int iA3 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr6 = this.f;
                if (i6 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i6];
                if (str3 != null) {
                    i7++;
                    iA3 += com.ubix.ssp.ad.e.y.c.b.a(str3);
                }
                i6++;
            }
            iB = iB + iA3 + i7;
        }
        String[] strArr7 = this.g;
        if (strArr7 != null && strArr7.length > 0) {
            int iA4 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr8 = this.g;
                if (i >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i];
                if (str4 != null) {
                    i8++;
                    iA4 += com.ubix.ssp.ad.e.y.c.b.a(str4);
                }
                i++;
            }
            iB = iB + iA4 + i8;
        }
        int i9 = this.h;
        if (i9 != 0) {
            iB += com.ubix.ssp.ad.e.y.c.b.f(9, i9);
        }
        int i10 = this.i;
        return i10 != 0 ? iB + com.ubix.ssp.ad.e.y.c.b.f(10, i10) : iB;
    }

    @Override // com.ubix.ssp.ad.e.y.c.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k a(com.ubix.ssp.ad.e.y.c.a aVar) throws com.ubix.ssp.ad.e.y.c.d {
        while (true) {
            int iW = aVar.w();
            if (iW == 0) {
                return this;
            }
            if (iW == 10) {
                this.b = aVar.v();
            } else if (iW == 34) {
                int iA = com.ubix.ssp.ad.e.y.c.h.a(aVar, 34);
                String[] strArr = this.c;
                int length = strArr == null ? 0 : strArr.length;
                int i = iA + length;
                String[] strArr2 = new String[i];
                if (length != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length);
                }
                while (length < i - 1) {
                    strArr2[length] = aVar.v();
                    aVar.w();
                    length++;
                }
                strArr2[length] = aVar.v();
                this.c = strArr2;
            } else if (iW == 42) {
                int iA2 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 42);
                String[] strArr3 = this.e;
                int length2 = strArr3 == null ? 0 : strArr3.length;
                int i2 = iA2 + length2;
                String[] strArr4 = new String[i2];
                if (length2 != 0) {
                    System.arraycopy(strArr3, 0, strArr4, 0, length2);
                }
                while (length2 < i2 - 1) {
                    strArr4[length2] = aVar.v();
                    aVar.w();
                    length2++;
                }
                strArr4[length2] = aVar.v();
                this.e = strArr4;
            } else if (iW == 50) {
                this.d = aVar.v();
            } else if (iW == 58) {
                int iA3 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 58);
                String[] strArr5 = this.f;
                int length3 = strArr5 == null ? 0 : strArr5.length;
                int i3 = iA3 + length3;
                String[] strArr6 = new String[i3];
                if (length3 != 0) {
                    System.arraycopy(strArr5, 0, strArr6, 0, length3);
                }
                while (length3 < i3 - 1) {
                    strArr6[length3] = aVar.v();
                    aVar.w();
                    length3++;
                }
                strArr6[length3] = aVar.v();
                this.f = strArr6;
            } else if (iW == 66) {
                int iA4 = com.ubix.ssp.ad.e.y.c.h.a(aVar, 66);
                String[] strArr7 = this.g;
                int length4 = strArr7 == null ? 0 : strArr7.length;
                int i4 = iA4 + length4;
                String[] strArr8 = new String[i4];
                if (length4 != 0) {
                    System.arraycopy(strArr7, 0, strArr8, 0, length4);
                }
                while (length4 < i4 - 1) {
                    strArr8[length4] = aVar.v();
                    aVar.w();
                    length4++;
                }
                strArr8[length4] = aVar.v();
                this.g = strArr8;
            } else if (iW == 72) {
                this.h = aVar.x();
            } else if (iW == 80) {
                this.i = aVar.x();
            } else if (!com.ubix.ssp.ad.e.y.c.h.b(aVar, iW)) {
                return this;
            }
        }
    }

    public k e() {
        this.b = "";
        String[] strArr = com.ubix.ssp.ad.e.y.c.h.f;
        this.c = strArr;
        this.d = "";
        this.e = strArr;
        this.f = strArr;
        this.g = strArr;
        this.h = 0;
        this.i = 0;
        this.f8939a = -1;
        return this;
    }
}
