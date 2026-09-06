package com.ubixnow.ooooo;

import com.ubixnow.ooooo.oO0OOO00;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class oO0OOO00<M extends oO0OOO00<M>> extends oOo0000O {
    public oO00o0 OooO0O0;

    public final <T> M OooO00o(oO00o00O<M, T> oo00o00o, T t) {
        int iOooO00o = oO0O000.OooO00o(oo00o00o.OooOo0);
        oOo00o0o ooo00o0oOooO0OO = null;
        if (t == null) {
            oO00o0 oo00o0 = this.OooO0O0;
            if (oo00o0 != null) {
                oo00o0.OooO0o(iOooO00o);
                if (this.OooO0O0.OooO0OO()) {
                    this.OooO0O0 = null;
                }
            }
        } else {
            oO00o0 oo00o1 = this.OooO0O0;
            if (oo00o1 == null) {
                this.OooO0O0 = new oO00o0();
            } else {
                ooo00o0oOooO0OO = oo00o1.OooO0OO(iOooO00o);
            }
            if (ooo00o0oOooO0OO == null) {
                this.OooO0O0.OooO00o(iOooO00o, new oOo00o0o(oo00o00o, t));
            } else {
                ooo00o0oOooO0OO.OooO00o(oo00o00o, t);
            }
        }
        return this;
    }

    public final <T> T OooO00o(oO00o00O<M, T> oo00o00o) {
        oOo00o0o ooo00o0oOooO0OO;
        oO00o0 oo00o0 = this.OooO0O0;
        if (oo00o0 == null || (ooo00o0oOooO0OO = oo00o0.OooO0OO(oO0O000.OooO00o(oo00o00o.OooOo0))) == null) {
            return null;
        }
        return (T) ooo00o0oOooO0OO.OooO00o(oo00o00o);
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public void OooO00o(oO00o00 oo00o00) throws IOException {
        if (this.OooO0O0 == null) {
            return;
        }
        for (int i = 0; i < this.OooO0O0.OooO0Oo(); i++) {
            this.OooO0O0.OooO0O0(i).OooO00o(oo00o00);
        }
    }

    public final boolean OooO00o(oO00o000 oo00o000, int i) throws IOException {
        oOo00o0o ooo00o0oOooO0OO;
        int iOooO0O0 = oo00o000.OooO0O0();
        if (!oo00o000.OooOO0(i)) {
            return false;
        }
        int iOooO00o = oO0O000.OooO00o(i);
        oO0 oo0 = new oO0(i, oo00o000.OooO00o(iOooO0O0, oo00o000.OooO0O0() - iOooO0O0));
        oO00o0 oo00o0 = this.OooO0O0;
        if (oo00o0 == null) {
            this.OooO0O0 = new oO00o0();
            ooo00o0oOooO0OO = null;
        } else {
            ooo00o0oOooO0OO = oo00o0.OooO0OO(iOooO00o);
        }
        if (ooo00o0oOooO0OO == null) {
            ooo00o0oOooO0OO = new oOo00o0o();
            this.OooO0O0.OooO00o(iOooO00o, ooo00o0oOooO0OO);
        }
        ooo00o0oOooO0OO.OooO00o(oo0);
        return true;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    public int OooO0O0() {
        if (this.OooO0O0 == null) {
            return 0;
        }
        int iOooO0O0 = 0;
        for (int i = 0; i < this.OooO0O0.OooO0Oo(); i++) {
            iOooO0O0 += this.OooO0O0.OooO0O0(i).OooO0O0();
        }
        return iOooO0O0;
    }

    public final boolean OooO0O0(oO00o00O<M, ?> oo00o00o) {
        oO00o0 oo00o0 = this.OooO0O0;
        return (oo00o0 == null || oo00o0.OooO0OO(oO0O000.OooO00o(oo00o00o.OooOo0)) == null) ? false : true;
    }

    @Override // com.ubixnow.ooooo.oOo0000O
    /* JADX INFO: renamed from: OooO0o0, reason: merged with bridge method [inline-methods] */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        oOo00ooO.OooO00o((oO0OOO00) this, (oO0OOO00) m);
        return m;
    }
}
