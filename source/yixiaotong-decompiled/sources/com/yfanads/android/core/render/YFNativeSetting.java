package com.yfanads.android.core.render;

import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.render.api.YFNativeAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFNativeSetting extends BaseAdapterEvent {
    int getAdsNumbers();

    void onAdSuccess(List<YFNativeAd> list);
}
