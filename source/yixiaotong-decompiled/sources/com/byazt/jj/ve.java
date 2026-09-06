package com.byazt.jj;

import android.util.SparseArray;
import com.byazt.omf.x;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 292, 54})
public class ve {
    public static Function<SparseArray<Object>, Object> c;

    public static void c(Function<SparseArray<Object>, Object> function) {
        c = function;
    }

    public static void c(com.byazt.ng.c cVar, boolean z) {
        if (cVar != null && x.m().lr()) {
            tt(cVar, z);
        }
    }

    private static void tt(com.byazt.ng.c cVar, boolean z) {
        if (c != null) {
            com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
            if (z) {
                ujVarC.c(10002).c(Void.class);
                ujVarC.c(20003, cVar.ve());
                c.apply(ujVarC.tt());
            } else {
                ujVarC.c(10002).c(Void.class);
                ujVarC.c(20002, cVar.ve());
                c.apply(ujVarC.tt());
            }
        }
    }
}
