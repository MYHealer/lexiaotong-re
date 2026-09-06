package com.byazt.wrq;

import android.util.SparseArray;
import com.byazt.omf.p;
import com.byazt.ou.IDownloadButtonClickListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1557, 20})
public abstract class c extends com.byazt.fb.uj implements IDownloadButtonClickListener, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (i == 223100) {
            if (!com.byazt.lq.uj.c(p.uj)) {
                pluginValueSet = com.byazt.rl.c.c((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).tt();
            }
            handleComplianceDialog(com.byazt.rl.c.c((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).tt().booleanValue(223101));
        } else if (i == 223110) {
            handleMarketFailedComplianceDialog();
        }
        return null;
    }
}
