package com.yfanads.android.core.roll;

import android.view.View;
import com.yfanads.android.callback.BaseAdapterNativeSetting;
import com.yfanads.android.model.SdkSupplier;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFRollAdsSetting extends BaseAdapterNativeSetting {
    void adapterRenderSuccess(SdkSupplier sdkSupplier, List<View> list);

    int getAdsNumbers();

    int getReadyIndex();
}
