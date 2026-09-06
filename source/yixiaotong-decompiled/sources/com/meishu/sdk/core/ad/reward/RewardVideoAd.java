package com.meishu.sdk.core.ad.reward;

import android.app.Activity;
import com.meishu.sdk.core.ad.IAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface RewardVideoAd extends IAd {
    void destroy();

    void setMediaListener(RewardAdMediaListener rewardAdMediaListener);

    void showAd();

    void showAd(Activity activity);
}
