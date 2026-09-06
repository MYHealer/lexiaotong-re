package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IMediationInterstitialFullAdListener extends TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialFullShowFail(int i, String str);

    void onRewardVerify(Bundle bundle);

    void onVideoError();
}
