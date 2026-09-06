package com.byazt.ch;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1054, 34})
public class a {
    public final Function<SparseArray<Object>, Object> c;

    public a(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270032);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(ve veVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, veVar);
        sparseArray.put(-99999987, 270033);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
