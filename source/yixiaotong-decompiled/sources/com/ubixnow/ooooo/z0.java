package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class z0 implements c1 {
    private OooO0O0 OooO00o = OooO0O0.REQUESTAD;
    private f1 OooO0O0 = null;

    public static /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            OooO0O0.values();
            int[] iArr = new int[3];
            OooO00o = iArr;
            try {
                iArr[OooO0O0.REQUESTAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[OooO0O0.INIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum OooO0O0 {
        REQUESTAD,
        TRACKING,
        INIT
    }

    public abstract a1 OooO00o();

    public void OooO00o(f1 f1Var) {
        this.OooO0O0 = f1Var;
    }

    public void OooO0O0() {
        g1.OooO0O0 oooO0O0OooO0OO;
        a1 a1VarOooO00o = OooO00o();
        this.OooO00o = OooO0OO();
        a1VarOooO00o.OooO00o(this);
        f1 f1Var = this.OooO0O0;
        if (f1Var != null) {
            f1Var.OooO00o(a1VarOooO00o);
            return;
        }
        int iOrdinal = this.OooO00o.ordinal();
        if (iOrdinal != 0) {
            oooO0O0OooO0OO = iOrdinal != 2 ? g1.OooO00o() : g1.OooO0o0();
        } else {
            oooO0O0OooO0OO = g1.OooO0OO();
        }
        oooO0O0OooO0OO.OooO0OO(a1VarOooO00o);
    }

    public abstract OooO0O0 OooO0OO();
}
