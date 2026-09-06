package com.yfanads.android.core.nat;

import com.yfanads.android.callback.BaseAdapterNativeSetting;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.SdkSupplier;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFNativeExpressSetting extends BaseAdapterNativeSetting {
    void adapterRenderSuccess(SdkSupplier sdkSupplier, List<ExpView> list);

    int getAdsNumbers();

    int getReadyIndex();
}
