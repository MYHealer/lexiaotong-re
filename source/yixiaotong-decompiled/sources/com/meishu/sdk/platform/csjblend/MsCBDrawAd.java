package com.meishu.sdk.platform.csjblend;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.draw.MediationCustomDrawAd;
import com.meishu.sdk.core.ad.draw.IDrawAd;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBDrawAd extends MediationCustomDrawAd {
    private static final String TAG = "MsCBDrawAd";
    private IDrawAd iDrawAd;

    public MsCBDrawAd(IDrawAd iDrawAd) {
        this.iDrawAd = iDrawAd;
        setInteractionType(getInteractionType());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        View adView = this.iDrawAd.getAdView();
        Log.e(TAG, "getExpressView: " + adView);
        if (adView instanceof NormalMediaView) {
            ((NormalMediaView) adView).start();
        }
        return adView;
    }

    public int getInteractionType() {
        return this.iDrawAd.getInteractionType() == 1 ? 4 : 2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        IDrawAd iDrawAd = this.iDrawAd;
        return (iDrawAd == null || !iDrawAd.isAdValid()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
        super.render();
        View adView = this.iDrawAd.getAdView();
        callRenderSuccess(adView.getMeasuredWidth(), adView.getMeasuredHeight());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        IDrawAd iDrawAd = this.iDrawAd;
        if (iDrawAd != null) {
            iDrawAd.showAd(viewGroup);
        }
    }
}
