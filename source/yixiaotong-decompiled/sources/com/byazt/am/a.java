package com.byazt.am;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1210, 34})
public class a {
    public final Function<SparseArray<Object>, Object> c;

    public a(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270012);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
