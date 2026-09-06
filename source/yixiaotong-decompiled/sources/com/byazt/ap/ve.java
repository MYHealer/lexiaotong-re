package com.byazt.ap;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 698, 54})
public class ve implements Loader {
    public Function<SparseArray<Object>, Object> c;

    public ve(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null || this.c == null) {
            return;
        }
        com.byazt.mm.c cVar = new com.byazt.mm.c(valueSet);
        cVar.put(-99999987, Integer.valueOf(i));
        cVar.put(-99999982, Integer.valueOf(i));
        this.c.apply(cVar);
    }
}
