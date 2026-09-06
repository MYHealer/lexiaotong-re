package com.byazt.yf;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 215})
public class yp {
    public boolean c() {
        return true;
    }

    public i tt() {
        return null;
    }

    public boolean ve() {
        return true;
    }

    public static yp c(final com.byazt.xf.ve veVar) {
        return new yp() { // from class: com.byazt.yf.yp.1
            @Override // com.byazt.yf.yp
            public boolean c() {
                com.byazt.xf.ve veVar2 = veVar;
                if (veVar2 != null) {
                    return veVar2.i();
                }
                return super.c();
            }

            @Override // com.byazt.yf.yp
            public i tt() {
                com.byazt.xf.uj ujVarZ;
                com.byazt.xf.ve veVar2 = veVar;
                if (veVar2 != null && (ujVarZ = veVar2.z()) != null && ujVarZ.c() != 0.0d && ujVarZ.tt() != 0.0d) {
                    return new i(ujVarZ.c(), ujVarZ.tt());
                }
                return super.tt();
            }

            @Override // com.byazt.yf.yp
            public boolean ve() {
                com.byazt.xf.ve veVar2 = veVar;
                if (veVar2 != null) {
                    return veVar2.x();
                }
                return super.ve();
            }
        };
    }
}
