package com.ubixnow.adtype.reward.api;

import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.bean.UMNAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UMNRewardListener {
    void onAdClicked();

    void onAdDismiss();

    void onAdLoadSuccess(UMNAdInfo uMNAdInfo);

    void onAdShow();

    void onError(UMNError uMNError);

    void onRewardVerify();

    void onVideoPlayComplete();

    void onVideoPlayError(UMNError uMNError);

    void onVideoPlayStart();

    void onVideoSkip();
}
