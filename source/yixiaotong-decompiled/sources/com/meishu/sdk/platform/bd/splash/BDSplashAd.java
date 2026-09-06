package com.meishu.sdk.platform.bd.splash;

import android.content.Intent;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.SplashAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDSplashAd extends c {
    private static final String TAG = "BDSplashAd";
    private ViewGroup adContainer;
    private boolean autoShow;
    private BDSplashAdLoader bdSplashAdLoader;
    private SdkAdInfo sdkAdInfo;
    private boolean showed;
    private SplashAd splashAd;

    public interface OnFinishJumpListener {
        void onFinish();
    }

    public BDSplashAd(boolean z, ViewGroup viewGroup, BDSplashAdLoader bDSplashAdLoader) {
        super(bDSplashAdLoader, MSAdConfig.PLATFORM_BD);
        this.autoShow = z;
        this.adContainer = viewGroup;
        this.bdSplashAdLoader = bDSplashAdLoader;
    }

    public void finishAndJump(Intent intent, final OnFinishJumpListener onFinishJumpListener) {
        try {
            this.splashAd.finishAndJump(intent, new SplashAd.OnFinishListener() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAd.1
                @Override // com.baidu.mobads.sdk.api.SplashAd.OnFinishListener
                public void onFinishActivity() {
                    OnFinishJumpListener onFinishJumpListener2 = onFinishJumpListener;
                    if (onFinishJumpListener2 != null) {
                        onFinishJumpListener2.onFinish();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public SplashAd getSplashAd() {
        return this.splashAd;
    }

    public void setSplashAD(SplashAd splashAd) {
        this.splashAd = splashAd;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        try {
            if (this.showed) {
                return;
            }
            this.splashAd.show(viewGroup);
            this.showed = true;
            o1.a(viewGroup, this.bdSplashAdLoader.getAdLoader().getPosId(), this.bdSplashAdLoader.getSdkAdInfo().getMsLoadedTime());
            super.showAd(viewGroup);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
