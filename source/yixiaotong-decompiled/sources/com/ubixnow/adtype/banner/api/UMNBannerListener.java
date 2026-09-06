package com.ubixnow.adtype.banner.api;

import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.bean.UMNAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UMNBannerListener {
    void onAdClicked();

    void onAdDismiss();

    void onAdExposure();

    void onAdLoadSuccess(UMNAdInfo uMNAdInfo);

    void onError(UMNError uMNError);

    void showError(UMNError uMNError);
}
