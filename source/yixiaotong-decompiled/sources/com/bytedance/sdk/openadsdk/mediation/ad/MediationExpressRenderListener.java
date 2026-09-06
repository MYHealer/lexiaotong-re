package com.bytedance.sdk.openadsdk.mediation.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface MediationExpressRenderListener extends TTNativeAd.ExpressRenderListener {
    void onAdClick();

    void onAdShow();

    void onRenderFail(View view, String str, int i);
}
