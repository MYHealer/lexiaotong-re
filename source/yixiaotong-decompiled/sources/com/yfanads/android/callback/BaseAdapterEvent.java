package com.yfanads.android.callback;

import com.yfanads.android.model.SdkSupplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface BaseAdapterEvent {
    void adapterDidClicked(SdkSupplier sdkSupplier, boolean z);

    void adapterDidClosed(SdkSupplier sdkSupplier);

    void adapterDidExposure(SdkSupplier sdkSupplier);

    void adapterRenderFailed(SdkSupplier sdkSupplier);
}
