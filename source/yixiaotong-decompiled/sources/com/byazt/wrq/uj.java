package com.byazt.wrq;

import android.util.SparseArray;
import com.byazt.omf.p;
import com.byazt.ou.OnItemClickListener;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1557, 15})
public abstract class uj extends com.byazt.fb.uj implements OnItemClickListener, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onItemClick();

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (!com.byazt.lq.uj.c(p.uj)) {
            pluginValueSet = com.byazt.rl.c.c((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).tt();
        }
        if (i == 223200 && pluginValueSet != null) {
            PluginValueSet pluginValueSetTt = com.byazt.rl.c.c((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).tt();
            onItemClick((Function<SparseArray<Object>, Object>) pluginValueSetTt.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetTt.objectValue(223202, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetTt.objectValue(223203, Function.class));
        }
        return null;
    }

    private void onItemClick(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2, Function<SparseArray<Object>, Object> function3) {
        onItemClick();
    }

    @Override // com.byazt.ou.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        onItemClick();
    }
}
