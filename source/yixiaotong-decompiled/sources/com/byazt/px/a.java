package com.byazt.px;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 34})
public class a extends com.byazt.fb.uj implements Supplier<SparseArray<Object>> {
    public com.byazt.dj.ve c;

    public a(com.byazt.dj.ve veVar) {
        this.c = veVar;
    }

    public PluginValueSet values() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        com.byazt.dj.ve veVar = this.c;
        cVarC.c(8481, veVar != null ? veVar.c() : 0.0d);
        com.byazt.dj.ve veVar2 = this.c;
        cVarC.c(8482, veVar2 != null ? veVar2.tt() : 0.0d);
        return cVarC.tt();
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values().sparseArray();
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Supplier
    public SparseArray<Object> get() {
        PluginValueSet pluginValueSetValues = values();
        if (pluginValueSetValues != null) {
            return pluginValueSetValues.sparseArray();
        }
        return null;
    }
}
