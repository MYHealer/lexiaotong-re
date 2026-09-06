package com.yfanads.android.callback;

import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.model.YFAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface UnionSdkResultListener {
    void onResultFailed(BaseChanelAdapter baseChanelAdapter, YFAdError yFAdError);

    void onResultSuccess(BaseChanelAdapter baseChanelAdapter);

    void onTimeoutSuccess(BaseChanelAdapter baseChanelAdapter);
}
