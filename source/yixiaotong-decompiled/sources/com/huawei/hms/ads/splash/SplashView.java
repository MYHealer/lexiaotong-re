package com.huawei.hms.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.h;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.views.PPSSplashView;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SplashView extends PPSSplashView {
    private SplashAdDisplayListener D;
    private SplashAdLoadListener F;

    public static abstract class SplashAdLoadListener {
        public void onAdDismissed() {
        }

        public void onAdFailedToLoad(int i) {
        }

        public void onAdLoaded() {
        }
    }

    public SplashView(Context context) {
        super(context);
    }

    public SplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void S() {
        Integer numF;
        if (isLoading()) {
            SplashAdLoadListener splashAdLoadListener = this.F;
            if (splashAdLoadListener != null) {
                splashAdLoadListener.onAdFailedToLoad(4);
                return;
            }
            return;
        }
        jc splashPresenter = getSplashPresenter();
        if (splashPresenter.V()) {
            AdSlotParam adSlotParam = getAdSlotParam();
            if (!splashPresenter.S() || adSlotParam == null || (numF = adSlotParam.F()) == null || numF.intValue() != 0) {
                if (adSlotParam != null) {
                    ai.Code(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), adSlotParam.B());
                }
                getSplashPresenter().Code();
            } else {
                List<String> listCode = adSlotParam.Code();
                splashPresenter.Code(!ag.Code(listCode) ? listCode.get(0) : null, 1);
                splashPresenter.F();
            }
        }
    }

    private void setAdLoadListener(SplashAdLoadListener splashAdLoadListener) {
        this.F = splashAdLoadListener;
        getSplashPresenter().Code(splashAdLoadListener);
        if (getAdMediator() != null) {
            getAdMediator().Code(splashAdLoadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.lt
    public void Code(int i) {
        super.Code(i);
        getAdMediator().Code(this.F);
        getAdMediator().Code(this.D);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.me
    public void destroyView() {
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public boolean isLoaded() {
        return super.isLoaded();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public boolean isLoading() {
        return super.isLoading();
    }

    public void load(String str, int i, AdParam adParam, SplashAdLoadListener splashAdLoadListener) {
        this.C = System.currentTimeMillis();
        fh.V("SplashView", h.Code);
        setAdLoadListener(splashAdLoadListener);
        AdSlotParam.a aVar = new AdSlotParam.a();
        SplashAd.Code(getContext(), str, i, adParam, aVar);
        super.setAdSlotParam(aVar.S());
        S();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.me
    public void pauseView() {
        super.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.me
    public void resumeView() {
        super.resumeView();
    }

    public void setAdDisplayListener(SplashAdDisplayListener splashAdDisplayListener) {
        this.D = splashAdDisplayListener;
        if (getAdMediator() != null) {
            getAdMediator().Code(this.D);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setAudioFocusType(int i) {
        super.setAudioFocusType(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogo(View view) {
        super.setLogo(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogo(View view, int i) {
        super.setLogo(view, i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogoBitmap(Bitmap bitmap) {
        super.setLogoBitmap(bitmap);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setLogoResId(int i) {
        super.setLogoResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setMediaNameResId(int i) {
        super.setMediaNameResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setMediaNameString(String str) {
        super.setMediaNameString(str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        super.setRewardVerifyConfig(rewardVerifyConfig);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setSloganResId(int i) {
        super.setSloganResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setSloganView(View view) {
        super.setSloganView(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    public void setWideSloganResId(int i) {
        super.setWideSloganResId(i);
    }
}
