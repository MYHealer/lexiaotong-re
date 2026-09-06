package com.meishu.sdk.core.ad.banner;

import android.app.Activity;
import android.view.ViewGroup;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: compiled from: BannerAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a extends com.meishu.sdk.core.ad.a implements IBannerAd {
    private com.meishu.sdk.core.loader.d adWrapper;

    public a(com.meishu.sdk.core.loader.d dVar, String str) {
        super(dVar, str);
        this.adWrapper = dVar;
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void setCloseButtonVisible(boolean z) {
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void setWidthAndHeight(int i, int i2) {
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        com.meishu.sdk.core.loader.d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        com.meishu.sdk.core.loader.d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}
