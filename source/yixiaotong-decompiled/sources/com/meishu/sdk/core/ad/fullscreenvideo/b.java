package com.meishu.sdk.core.ad.fullscreenvideo;

import android.app.Activity;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: compiled from: FullScreenVideoAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b extends com.meishu.sdk.core.ad.a implements IFullScreenVideoAd {
    private com.meishu.sdk.core.loader.d adWrapper;

    public b(com.meishu.sdk.core.loader.d dVar, String str) {
        super(dVar, str);
        this.adWrapper = dVar;
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd() {
        com.meishu.sdk.core.loader.d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.meishu.sdk.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        com.meishu.sdk.core.loader.d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}
