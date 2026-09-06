package com.yfanads.android.core.reward;

import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.model.SdkSupplier;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFRewardVideoSetting extends BaseAdapterEvent {
    void adapterVideoCacheFailed(SdkSupplier sdkSupplier);

    void adapterVideoCached(SdkSupplier sdkSupplier);

    void adapterVideoComplete(SdkSupplier sdkSupplier);

    void adapterVideoSkipped(SdkSupplier sdkSupplier);

    Map<String, Object> getAppExtra();

    int getOrientation();

    void postRewardServerInf(YFRewardServerCallBackInf yFRewardServerCallBackInf, SdkSupplier sdkSupplier);
}
