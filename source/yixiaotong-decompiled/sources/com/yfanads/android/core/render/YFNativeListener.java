package com.yfanads.android.core.render;

import com.yfanads.android.callback.BaseAdListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.model.YFAdError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class YFNativeListener implements BaseAdListener {
    @Override // com.yfanads.android.callback.BaseAdListener
    public void onAdClicked() {
    }

    @Override // com.yfanads.android.callback.BaseAdListener
    public void onAdClosed() {
    }

    @Override // com.yfanads.android.callback.BaseAdListener
    public void onAdExposure() {
    }

    @Override // com.yfanads.android.callback.BaseAdListener
    public void onAdFailed(YFAdError yFAdError) {
    }

    @Override // com.yfanads.android.callback.BaseAdListener
    public void onAdSuccess() {
    }

    public abstract void onAdSuccess(List<YFNativeAd> list);
}
