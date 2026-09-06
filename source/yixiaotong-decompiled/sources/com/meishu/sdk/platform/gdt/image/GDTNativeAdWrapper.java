package com.meishu.sdk.platform.gdt.image;

import android.content.Context;
import com.meishu.sdk.core.ad.image.b;
import com.qq.e.ads.nativ.NativeUnifiedAD;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeAdWrapper {
    private NativeUnifiedAD nativeUnifiedAD;

    public GDTNativeAdWrapper(Context context, String str, String str2, b bVar) {
        this.nativeUnifiedAD = new NativeUnifiedAD(context, str2, new GDTNativeAdListenerImpl(bVar));
    }

    public void loadData() {
        this.nativeUnifiedAD.loadData(1);
    }
}
