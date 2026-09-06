package com.byazt.sbm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.huawei.openalliance.ad.constant.ai;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, ai.af, 54})
public abstract class ve implements Function<SparseArray<Object>, Object> {
    public PluginValueSet c;

    public abstract List<tt> getAdLoadInfo();

    public abstract c getBestEcpm();

    public abstract List<c> getCacheList();

    public abstract List<c> getMultiBiddingEcpm();

    public abstract c getShowEcpm();

    public abstract boolean isReady();

    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC;
    }

    private PluginValueSet c() {
        return com.byazt.rl.c.c().tt();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 270001:
                    return Boolean.class.cast(Boolean.valueOf(isReady()));
                case 270002:
                    return getAdLoadInfo();
                case 270003:
                    return getMultiBiddingEcpm();
                case 270004:
                    return getBestEcpm();
                case 270005:
                    return getCacheList();
                case 270006:
                    return getShowEcpm();
                default:
                    return null;
            }
        }
        return values().sparseArray();
    }
}
