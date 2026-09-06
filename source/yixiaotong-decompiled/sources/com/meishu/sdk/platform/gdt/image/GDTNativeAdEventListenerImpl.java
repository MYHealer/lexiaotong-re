package com.meishu.sdk.platform.gdt.image;

import com.meishu.sdk.core.ad.image.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeAdEventListenerImpl implements NativeADEventListener {
    private static final String TAG = "GDTNativeAdEventListene";
    private GDTImageAdDataAdapter adDataAdapter;
    private a nativeADEventListener;

    public GDTNativeAdEventListenerImpl(GDTImageAdDataAdapter gDTImageAdDataAdapter, a aVar) {
        this.adDataAdapter = gDTImageAdDataAdapter;
        this.nativeADEventListener = aVar;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        LogUtil.e(TAG, com.meishu.sdk.activity.a.a("onADError, code: ").append(adError.getErrorCode()).append(", msg: ").append(adError.getErrorMsg()).toString());
        if (this.adDataAdapter.getAdListener() != null) {
            this.adDataAdapter.getAdListener().onNoAD(adError);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        if (this.adDataAdapter.getAdListener() != null) {
            this.adDataAdapter.getAdListener().onAdExposure();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
        LogUtil.d(TAG, "onADStatusChanged: ");
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        a aVar = this.nativeADEventListener;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }
}
