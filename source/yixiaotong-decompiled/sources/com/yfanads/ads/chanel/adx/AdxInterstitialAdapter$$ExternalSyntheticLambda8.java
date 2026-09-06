package com.yfanads.ads.chanel.adx;

import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.libs.utils.YFOptional;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final /* synthetic */ class AdxInterstitialAdapter$$ExternalSyntheticLambda8 implements YFOptional.Consumer {
    @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
    public final void accept(Object obj) {
        ((AbstractNativeAd) obj).unRegisterViewAction();
    }
}
