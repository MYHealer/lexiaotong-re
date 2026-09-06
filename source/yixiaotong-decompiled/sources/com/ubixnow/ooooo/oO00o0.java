package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO00o0 implements Cloneable {
    private static final oOo00o0o OooO00o = new oOo00o0o();
    private boolean OooO0O0;
    private int[] OooO0OO;
    private oOo00o0o[] OooO0Oo;
    private int OooO0o0;

    public oO00o0() {
        this(10);
    }

    public oO00o0(int i) {
        this.OooO0O0 = false;
        int iOooO0o0 = OooO0o0(i);
        this.OooO0OO = new int[iOooO0o0];
        this.OooO0Oo = new oOo00o0o[iOooO0o0];
        this.OooO0o0 = 0;
    }

    private int OooO00o(int i) {
        int i2 = this.OooO0o0 - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.OooO0OO[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    private boolean OooO00o(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean OooO00o(oOo00o0o[] ooo00o0oArr, oOo00o0o[] ooo00o0oArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!ooo00o0oArr[i2].equals(ooo00o0oArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private void OooO0O0() {
        int i = this.OooO0o0;
        int[] iArr = this.OooO0OO;
        oOo00o0o[] ooo00o0oArr = this.OooO0Oo;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            oOo00o0o ooo00o0o = ooo00o0oArr[i3];
            if (ooo00o0o != OooO00o) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    ooo00o0oArr[i2] = ooo00o0o;
                    ooo00o0oArr[i3] = null;
                }
                i2++;
            }
        }
        this.OooO0O0 = false;
        this.OooO0o0 = i2;
    }

    private int OooO0Oo(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private int OooO0o0(int i) {
        return OooO0Oo(i * 4) / 4;
    }

    /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
    public final oO00o0 clone() {
        int iOooO0Oo = OooO0Oo();
        oO00o0 oo00o0 = new oO00o0(iOooO0Oo);
        System.arraycopy(this.OooO0OO, 0, oo00o0.OooO0OO, 0, iOooO0Oo);
        for (int i = 0; i < iOooO0Oo; i++) {
            oOo00o0o ooo00o0o = this.OooO0Oo[i];
            if (ooo00o0o != null) {
                oo00o0.OooO0Oo[i] = ooo00o0o.clone();
            }
        }
        oo00o0.OooO0o0 = iOooO0Oo;
        return oo00o0;
    }

    public void OooO00o(int i, oOo00o0o ooo00o0o) {
        int iOooO00o = OooO00o(i);
        if (iOooO00o >= 0) {
            this.OooO0Oo[iOooO00o] = ooo00o0o;
            return;
        }
        int i2 = ~iOooO00o;
        int i3 = this.OooO0o0;
        if (i2 < i3) {
            oOo00o0o[] ooo00o0oArr = this.OooO0Oo;
            if (ooo00o0oArr[i2] == OooO00o) {
                this.OooO0OO[i2] = i;
                ooo00o0oArr[i2] = ooo00o0o;
                return;
            }
        }
        if (this.OooO0O0 && i3 >= this.OooO0OO.length) {
            OooO0O0();
            i2 = ~OooO00o(i);
        }
        int i4 = this.OooO0o0;
        if (i4 >= this.OooO0OO.length) {
            int iOooO0o0 = OooO0o0(i4 + 1);
            int[] iArr = new int[iOooO0o0];
            oOo00o0o[] ooo00o0oArr2 = new oOo00o0o[iOooO0o0];
            int[] iArr2 = this.OooO0OO;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            oOo00o0o[] ooo00o0oArr3 = this.OooO0Oo;
            System.arraycopy(ooo00o0oArr3, 0, ooo00o0oArr2, 0, ooo00o0oArr3.length);
            this.OooO0OO = iArr;
            this.OooO0Oo = ooo00o0oArr2;
        }
        int i5 = this.OooO0o0 - i2;
        if (i5 != 0) {
            int[] iArr3 = this.OooO0OO;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5);
            oOo00o0o[] ooo00o0oArr4 = this.OooO0Oo;
            System.arraycopy(ooo00o0oArr4, i2, ooo00o0oArr4, i6, this.OooO0o0 - i2);
        }
        this.OooO0OO[i2] = i;
        this.OooO0Oo[i2] = ooo00o0o;
        this.OooO0o0++;
    }

    public oOo00o0o OooO0O0(int i) {
        if (this.OooO0O0) {
            OooO0O0();
        }
        return this.OooO0Oo[i];
    }

    public oOo00o0o OooO0OO(int i) {
        oOo00o0o ooo00o0o;
        int iOooO00o = OooO00o(i);
        if (iOooO00o < 0 || (ooo00o0o = this.OooO0Oo[iOooO00o]) == OooO00o) {
            return null;
        }
        return ooo00o0o;
    }

    public boolean OooO0OO() {
        return OooO0Oo() == 0;
    }

    public int OooO0Oo() {
        if (this.OooO0O0) {
            OooO0O0();
        }
        return this.OooO0o0;
    }

    public void OooO0o(int i) {
        int iOooO00o = OooO00o(i);
        if (iOooO00o >= 0) {
            oOo00o0o[] ooo00o0oArr = this.OooO0Oo;
            oOo00o0o ooo00o0o = ooo00o0oArr[iOooO00o];
            oOo00o0o ooo00o0o2 = OooO00o;
            if (ooo00o0o != ooo00o0o2) {
                ooo00o0oArr[iOooO00o] = ooo00o0o2;
                this.OooO0O0 = true;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oO00o0)) {
            return false;
        }
        oO00o0 oo00o0 = (oO00o0) obj;
        if (OooO0Oo() != oo00o0.OooO0Oo()) {
            return false;
        }
        return OooO00o(this.OooO0OO, oo00o0.OooO0OO, this.OooO0o0) && OooO00o(this.OooO0Oo, oo00o0.OooO0Oo, this.OooO0o0);
    }

    public int hashCode() {
        if (this.OooO0O0) {
            OooO0O0();
        }
        int iHashCode = 17;
        for (int i = 0; i < this.OooO0o0; i++) {
            iHashCode = (((iHashCode * 31) + this.OooO0OO[i]) * 31) + this.OooO0Oo[i].hashCode();
        }
        return iHashCode;
    }
}
