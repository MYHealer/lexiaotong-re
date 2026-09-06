package com.byazt.yxi;

import android.util.SparseArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1133, 15})
public class uj {
    public final SparseArray<Object> c;

    public SparseArray<Object> tt() {
        return this.c;
    }

    private uj() {
        this.c = new SparseArray<>();
    }

    public uj(SparseArray<Object> sparseArray) {
        this.c = com.byazt.mta.c.c().tt() < 6803 ? new c(sparseArray) : sparseArray;
    }

    public static uj c() {
        return new uj();
    }

    public static uj c(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new uj(sparseArray);
    }

    public uj c(int i) {
        this.c.put(-99999987, Integer.valueOf(i));
        return this;
    }

    public uj c(Class<?> cls) {
        this.c.put(-99999985, cls);
        return this;
    }

    public uj c(int i, Object obj) {
        this.c.put(i, obj);
        return this;
    }
}
