package com.meishu.sdk.platform.gdt.media;

import android.content.Context;
import com.meishu.sdk.core.ad.media.a;
import com.qq.e.ads.nativ.NativeUnifiedAD;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeMediaAdWrapper {
    private NativeUnifiedAD nativeMediaAd;

    public GDTNativeMediaAdWrapper(Context context, String str, String str2, a aVar) {
        this.nativeMediaAd = new NativeUnifiedAD(context, str2, new GDTNativeAdListenerImpl(aVar));
    }

    public void loadAD() {
        this.nativeMediaAd.loadData(1);
    }
}
