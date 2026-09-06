package com.yfanads.android.core.full;

import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.model.SdkSupplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFFullScreenVideoSetting extends BaseAdapterEvent {
    void adapterVideoCached(SdkSupplier sdkSupplier);

    void adapterVideoComplete(SdkSupplier sdkSupplier);

    void adapterVideoSkipped(SdkSupplier sdkSupplier);
}
