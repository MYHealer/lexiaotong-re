package com.byazt.ed;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2070, 20})
public abstract class c implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    public abstract void onConditionReturn(Bundle bundle);

    private PluginValueSet c() {
        return com.byazt.rl.c.c().tt();
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            if (iIntValue == 123101) {
                onConditionReturn((Bundle) pluginValueSetTt.objectValue(0, Bundle.class));
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC.sparseArray();
    }
}
