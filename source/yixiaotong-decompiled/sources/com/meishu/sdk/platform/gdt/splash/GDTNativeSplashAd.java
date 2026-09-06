package com.meishu.sdk.platform.gdt.splash;

import android.view.ViewGroup;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeSplashAd extends c {
    private static final String TAG = "GDTNativeSplashAd";
    private GDTSplashAdWrapper adWrapper;
    private boolean showed;
    private SplashSkipView skipView;

    public GDTNativeSplashAd(GDTSplashAdWrapper gDTSplashAdWrapper) {
        super(gDTSplashAdWrapper, MSAdConfig.PLATFORM_GDT);
        this.adWrapper = gDTSplashAdWrapper;
    }

    public void setSkipView(SplashSkipView splashSkipView) {
        this.skipView = splashSkipView;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        try {
            if (this.showed) {
                return;
            }
            LogUtil.e(TAG, "adView=" + this.adView);
            if (this.adView != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.adView, -1, -1);
                this.showed = true;
                SplashSkipView splashSkipView = this.skipView;
                if (splashSkipView != null) {
                    splashSkipView.c();
                }
                super.showAd(viewGroup);
                o1.a(viewGroup, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
