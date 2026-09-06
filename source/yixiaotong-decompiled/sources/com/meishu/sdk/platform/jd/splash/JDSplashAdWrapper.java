package com.meishu.sdk.platform.jd.splash;

import android.view.View;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.splash.JADSplash;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.platform.BasePlatformLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDSplashAdWrapper extends BasePlatformLoader<SplashAdLoader, d> {
    private MeishuAdInfo meishuAdInfo;
    private JADSplash splashAd;

    public JDSplashAdWrapper(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(splashAdLoader, sdkAdInfo);
        this.meishuAdInfo = meishuAdInfo;
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        JADSplash jADSplash = this.splashAd;
        if (jADSplash == null || jADSplash == null) {
            return;
        }
        this.splashAd = null;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        a.a(((SplashAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()));
        try {
            SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.jd.splash.JDSplashAdWrapper.1
                @Override // com.meishu.sdk.core.safe.l
                public void safeRun() {
                    Object obj = JDSplashAdWrapper.this.localParams.get(SplashAdLoader.KEY_SKIP_BUTTON);
                    if (obj == null || !(obj instanceof View)) {
                        return;
                    }
                    ((View) obj).setVisibility(4);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
        float fIntValue = 1080.0f;
        float fIntValue2 = 0.0f;
        try {
            if (getAdLoader().getAccept_ad_width() == null || getAdLoader().getAccept_ad_width().intValue() <= 0 || getAdLoader().getAccept_ad_height() == null || getAdLoader().getAccept_ad_height().intValue() <= 0) {
                int i = ((SplashAdLoader) this.adLoader).getContext().getResources().getDisplayMetrics().widthPixels;
                if (i > 0) {
                    fIntValue = i;
                }
            } else {
                fIntValue = getAdLoader().getAccept_ad_width().intValue();
                fIntValue2 = getAdLoader().getAccept_ad_height().intValue();
            }
        } catch (Exception unused) {
        }
        boolean zBooleanValue = ((Boolean) this.localParams.get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue();
        JADSlot jADSlotBuild = new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setSize(m.b(((SplashAdLoader) this.adLoader).getContext(), fIntValue), m.b(((SplashAdLoader) this.adLoader).getContext(), fIntValue2)).setTolerateTime(3.5f).build();
        JDSplashAd jDSplashAd = new JDSplashAd(this, getAdLoader().getAdContainer());
        JADSplash jADSplash = new JADSplash(getContext(), jADSlotBuild);
        this.splashAd = jADSplash;
        jDSplashAd.setSplashAD(jADSplash);
        this.splashAd.loadAd(new JDSplashAdListenerImpl(this, (d) this.loadListener, jDSplashAd, zBooleanValue));
    }
}
