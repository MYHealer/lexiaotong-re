package com.bytedance.msdk.adapter.ks;

import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class KsManager extends AdnAdapterBaseFunction {
    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 10000) {
            return (T) new KsAdapterConfiguration();
        }
        if (i == 20001) {
            return (T) new KsBannerLoader();
        }
        if (i == 20002) {
            return (T) new KsDrawLoader();
        }
        if (i == 20003) {
            return (T) new KsFullVideoLoader();
        }
        if (i == 20004) {
            return (T) new KsInterstitialLoader();
        }
        if (i == 20005) {
            return (T) new KsNativeLoader();
        }
        if (i == 20006) {
            return (T) new KsRewardLoader();
        }
        if (i == 20007) {
            return (T) new KsSplashLoader();
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        return null;
    }
}
