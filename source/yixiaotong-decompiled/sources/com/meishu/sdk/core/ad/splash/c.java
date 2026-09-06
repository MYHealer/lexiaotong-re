package com.meishu.sdk.core.ad.splash;

import android.view.ViewGroup;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: compiled from: SplashAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class c extends com.meishu.sdk.core.ad.a implements ISplashAd {
    public ViewGroup adContainer;
    private com.meishu.sdk.core.loader.d adWrapper;
    public a downloadDialogListener;
    private b finishingTouchListener;
    public Integer height;
    private boolean isFinishingTouch;
    public Integer width;

    public c(com.meishu.sdk.core.loader.d dVar, String str) {
        super(dVar, str);
        this.adWrapper = dVar;
    }

    public Integer getHeight() {
        return this.height;
    }

    public boolean getIsFinishingTouch() {
        return this.isFinishingTouch;
    }

    public b getSplashFinishingTouchListener() {
        return this.finishingTouchListener;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setAdContainer(ViewGroup viewGroup) {
        this.adContainer = viewGroup;
    }

    @Override // com.meishu.sdk.core.ad.splash.ISplashAd
    public void setDownloadDialogListener(a aVar) {
        this.downloadDialogListener = aVar;
    }

    public void setHeight(Integer num) {
        this.height = num;
    }

    public void setIsFinishingTouch(boolean z) {
        this.isFinishingTouch = z;
    }

    @Override // com.meishu.sdk.core.ad.splash.ISplashAd
    public void setSplashFinishingTouchListener(b bVar) {
        this.finishingTouchListener = bVar;
    }

    public void setWidth(Integer num) {
        this.width = num;
    }

    @Override // com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        com.meishu.sdk.core.loader.d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.meishu.sdk.core.ad.splash.ISplashAd
    public void splashAnimationFinish() {
    }
}
