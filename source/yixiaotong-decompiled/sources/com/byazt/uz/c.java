package com.byazt.uz;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1091, 20})
public class c {
    public final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 171102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 171101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
