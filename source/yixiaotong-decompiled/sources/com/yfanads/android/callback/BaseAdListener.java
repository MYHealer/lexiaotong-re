package com.yfanads.android.callback;

import com.yfanads.android.model.YFAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface BaseAdListener {
    void onAdClicked();

    void onAdClosed();

    void onAdExposure();

    void onAdFailed(YFAdError yFAdError);

    void onAdRenderFailed();

    void onAdSuccess();
}
