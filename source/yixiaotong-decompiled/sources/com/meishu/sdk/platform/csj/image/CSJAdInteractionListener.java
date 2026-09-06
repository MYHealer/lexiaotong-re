package com.meishu.sdk.platform.csj.image;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.meishu.sdk.core.ad.image.a;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJAdInteractionListener implements TTNativeAd.AdInteractionListener {
    private static final String TAG = "CSJAdInteractionListene";
    private CSJImageAdDataAdapter csjNativeAdDataAdapter;
    private a meishuInteractionListener;

    public CSJAdInteractionListener(CSJImageAdDataAdapter cSJImageAdDataAdapter, a aVar) {
        this.csjNativeAdDataAdapter = cSJImageAdDataAdapter;
        this.meishuInteractionListener = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        this.meishuInteractionListener.onAdClicked();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        LogUtil.d(TAG, "onAdCreativeClick: 创意被点击");
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        if (this.csjNativeAdDataAdapter.getAdListener() != null) {
            this.csjNativeAdDataAdapter.getAdListener().onAdExposure();
        }
    }
}
