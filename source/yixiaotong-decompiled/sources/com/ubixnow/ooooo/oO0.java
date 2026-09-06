package com.ubixnow.ooooo;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oO0 {
    public final int OooO00o;
    public final byte[] OooO0O0;

    public oO0(int i, byte[] bArr) {
        this.OooO00o = i;
        this.OooO0O0 = bArr;
    }

    public int OooO00o() {
        return oO00o00.OooO0Oo(this.OooO00o) + this.OooO0O0.length;
    }

    public void OooO00o(oO00o00 oo00o00) throws IOException {
        oo00o00.OooOOOO(this.OooO00o);
        oo00o00.OooO0Oo(this.OooO0O0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oO0)) {
            return false;
        }
        oO0 oo0 = (oO0) obj;
        return this.OooO00o == oo0.OooO00o && Arrays.equals(this.OooO0O0, oo0.OooO0O0);
    }

    public int hashCode() {
        return ((this.OooO00o + 527) * 31) + Arrays.hashCode(this.OooO0O0);
    }
}
