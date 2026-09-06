package com.bytedance.msdk.adapter.baidu;

import android.util.SparseArray;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduManager extends AdnAdapterBaseFunction {
    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 10000) {
            return (T) new BaiduAdapterConfiguration();
        }
        if (i == 20001) {
            return (T) new BaiduBannerLoader();
        }
        if (i == 20003) {
            return (T) new BaiduFullVideoLoader();
        }
        if (i == 20004) {
            return (T) new BaiduInterstitialLoader();
        }
        if (i == 20005) {
            return (T) new BaiduNativeLoader();
        }
        if (i == 20006) {
            return (T) new BaiduRewardLoader();
        }
        if (i == 20007) {
            return (T) new BaiduSplashLoader();
        }
        if (i == 20002) {
            return (T) new BaiduDrawLoader();
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        return null;
    }
}
