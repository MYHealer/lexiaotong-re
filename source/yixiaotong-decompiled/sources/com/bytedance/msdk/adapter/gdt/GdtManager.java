package com.bytedance.msdk.adapter.gdt;

import android.util.SparseArray;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class GdtManager extends AdnAdapterBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 10000) {
            return (T) new GdtAdapterConfiguration();
        }
        if (i == 20001) {
            return (T) new GdtBannerLoader();
        }
        if (i == 20002) {
            return (T) new GdtDrawLoader();
        }
        if (i == 20003) {
            return (T) new GdtFullVideoLoader();
        }
        if (i == 20004) {
            return (T) new GdtInterstitialLoader();
        }
        if (i == 20005) {
            return (T) new GdtNativeLoader();
        }
        if (i == 20006) {
            return (T) new GdtRewardLoader();
        }
        if (i == 20007) {
            return (T) new GdtSplashLoader();
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        return null;
    }
}
