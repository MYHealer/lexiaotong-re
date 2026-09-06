package com.meishu.sdk.platform.jd.interstitial;

import android.app.Activity;
import android.util.DisplayMetrics;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.interstitial.JADInterstitial;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDInterstitialAdWrapper extends BasePlatformLoader<InterstitialAdLoader, b> {
    private JADInterstitial interstitialAd;
    private MeishuAdInfo meishuAdInfo;

    public JDInterstitialAdWrapper(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
        this.meishuAdInfo = meishuAdInfo;
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        if (this.interstitialAd != null) {
            this.interstitialAd = null;
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        float fFloatValue;
        float fFloatValue2;
        try {
            z.a(StubApp.getOrigApplicationContext(((InterstitialAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
            DisplayMetrics displayMetrics = ((InterstitialAdLoader) this.adLoader).getContext().getResources().getDisplayMetrics();
            Float f = (Float) this.localParams.get("KEY_WIDTH");
            Float f2 = (Float) this.localParams.get("KEY_HEIGHT");
            if (f == null || f2 == null || f.floatValue() == 0.0f) {
                fFloatValue = ((displayMetrics.widthPixels / displayMetrics.density) * 3.0f) / 4.0f;
                fFloatValue2 = fFloatValue / 0.65f;
            } else {
                fFloatValue = f.floatValue();
                fFloatValue2 = f2.floatValue();
            }
            JADSlot jADSlotBuild = new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setSize(fFloatValue, fFloatValue2).build();
            JDIntersititialAd jDIntersititialAd = new JDIntersititialAd(this, (Activity) ((InterstitialAdLoader) this.adLoader).getContext());
            JADInterstitial jADInterstitial = new JADInterstitial(((InterstitialAdLoader) this.adLoader).getContext(), jADSlotBuild);
            this.interstitialAd = jADInterstitial;
            jDIntersititialAd.setInterstitialAd(jADInterstitial);
            this.interstitialAd.loadAd(new JDInterstitialAdListenerImpl(this, (b) this.loadListener, jDIntersititialAd));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
