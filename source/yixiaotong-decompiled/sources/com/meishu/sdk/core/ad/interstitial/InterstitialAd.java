package com.meishu.sdk.core.ad.interstitial;

import android.app.Activity;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.utils.o1;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class InterstitialAd extends com.meishu.sdk.core.ad.a implements Serializable {
    private d adWrapper;

    public InterstitialAd(d dVar, String str) {
        super(dVar, str);
        this.adWrapper = dVar;
    }

    public void showAd() {
        d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    public void showAd(Activity activity) {
        d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}
