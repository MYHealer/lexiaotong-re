package com.meishu.sdk.platform.csj.draw;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.draw.DrawAd;
import com.meishu.sdk.core.ad.draw.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJDrawAd extends DrawAd {
    private TTNativeExpressAd ad;
    private CSJDrawAdWrapper adNativeWrapper;
    private a drawAdListener;
    private SdkAdInfo sdkAdInfo;

    public CSJDrawAd(SdkAdInfo sdkAdInfo, a aVar, CSJDrawAdWrapper cSJDrawAdWrapper, TTNativeExpressAd tTNativeExpressAd) {
        super(cSJDrawAdWrapper, MSAdConfig.PLATFORM_CSJ);
        this.sdkAdInfo = sdkAdInfo;
        this.drawAdListener = aVar;
        this.adNativeWrapper = cSJDrawAdWrapper;
        this.ad = tTNativeExpressAd;
    }

    public a getDrawAdListener() {
        return this.drawAdListener;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public int getDrawType() {
        return 2;
    }

    public SdkAdInfo getSdkAdInfo() {
        return this.sdkAdInfo;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(ViewGroup viewGroup) {
        try {
            this.ad.setDislikeCallback((Activity) this.adNativeWrapper.getContext(), new CSJDrawDisLikeCallback(this.adNativeWrapper, this.ad, this));
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                View adView = getAdView();
                if (adView == null) {
                    return;
                }
                if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) adView.getParent()).removeView(adView);
                }
                viewGroup.addView(adView);
            }
            super.showAd(viewGroup);
            o1.a(viewGroup, this.adNativeWrapper.getAdLoader().getPosId(), this.sdkAdInfo.getMsLoadedTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void destroy() {
        try {
            CSJDrawAdWrapper cSJDrawAdWrapper = this.adNativeWrapper;
            if (cSJDrawAdWrapper != null) {
                cSJDrawAdWrapper.destroy();
            }
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            tTNativeExpressAd.setDislikeCallback(activity, new CSJDrawDisLikeCallback(this.adNativeWrapper, tTNativeExpressAd, this));
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                View adView = getAdView();
                if (adView == null) {
                    return;
                }
                if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) adView.getParent()).removeView(adView);
                }
                viewGroup.addView(adView);
            }
            super.showAd(activity, viewGroup);
            o1.a(viewGroup, this.adNativeWrapper.getAdLoader().getPosId(), this.sdkAdInfo.getMsLoadedTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
