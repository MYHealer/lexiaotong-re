package com.byazt.lm;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1949, 13})
public class tt implements c.InterfaceC0210c {
    public Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.byazt.lm.c.InterfaceC0210c
    public void c() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.byazt.lm.c.InterfaceC0210c
    public void tt() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            function.apply(sparseArray);
        }
    }
}
