package com.byazt.ocd;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1536, 20})
public class c {
    public final Function<SparseArray<Object>, Object> c;

    public c(Object obj) {
        this.c = obj != null ? (Function) obj : com.byazt.rl.c.tt;
    }

    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 223101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
