package com.byazt.we;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.callback.Callback;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 916, 20})
public class c implements Callback<Object> {
    public final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.c != null) {
            this.c.apply(com.byazt.rl.ve.c().c(0, obj).c(-99999987, 1).tt().sparseArray());
        }
    }
}
