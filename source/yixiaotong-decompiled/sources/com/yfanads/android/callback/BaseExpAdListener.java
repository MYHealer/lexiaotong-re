package com.yfanads.android.callback;

import com.yfanads.android.model.YFAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface BaseExpAdListener<T> extends BaseAdListener {
    @Override // com.yfanads.android.callback.BaseAdListener
    default void onAdClicked() {
    }

    void onAdClicked(T t);

    @Override // com.yfanads.android.callback.BaseAdListener
    default void onAdClosed() {
    }

    void onAdClosed(T t);

    @Override // com.yfanads.android.callback.BaseAdListener
    default void onAdExposure() {
    }

    void onAdExposure(T t);

    @Override // com.yfanads.android.callback.BaseAdListener
    void onAdFailed(YFAdError yFAdError);

    void onAdRenderFailed(T t);

    @Override // com.yfanads.android.callback.BaseAdListener
    void onAdSuccess();
}
