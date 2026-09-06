package com.meishu.sdk.platform.huawei.splash;

import android.view.ViewGroup;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWSplashAd extends c {
    private HWSplashAdWrapper adWrapper;
    private IAdShowListener listener;
    private boolean showed;

    public interface IAdShowListener {
        void onShow();
    }

    public HWSplashAd(HWSplashAdWrapper hWSplashAdWrapper) {
        super(hWSplashAdWrapper, "HW");
        this.adWrapper = hWSplashAdWrapper;
    }

    public void setOnAdShowListener(IAdShowListener iAdShowListener) {
        this.listener = iAdShowListener;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        if (this.showed || this.adView == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.adView, -1, -1);
        this.showed = true;
        IAdShowListener iAdShowListener = this.listener;
        if (iAdShowListener != null) {
            iAdShowListener.onShow();
        }
        if (this.adWrapper.getLoaderListener() != null) {
            this.adWrapper.getLoaderListener().onAdExposure();
        }
        if (getInteractionListener() != null) {
            getInteractionListener().onAdExposure();
        }
        super.showAd(viewGroup);
        o1.a(viewGroup, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
    }
}
