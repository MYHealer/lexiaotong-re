package com.byazt.fb;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1053, 20})
public abstract class c extends uj implements LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onAppBackground();

    public abstract void onAppForeground();

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 0) {
            onAppBackground();
            return null;
        }
        if (i != 1) {
            return null;
        }
        onAppForeground();
        return null;
    }
}
