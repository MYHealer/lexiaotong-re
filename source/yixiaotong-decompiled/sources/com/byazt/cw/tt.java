package com.byazt.cw;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 209, 13})
public class tt extends com.byazt.gl.c {
    public final Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 131106);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131107);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void a() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131108);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void sp() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131109);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, bundle);
        sparseArray.put(-99999987, 131110);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
