package com.meishu.sdk.platform.gdt.recycler;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTAdInteractionListener implements NativeADEventListener {
    private static final String TAG = "GDTAdInteractionListene";
    private GDTNativeUnifiedAdData adData;
    private RecylcerAdInteractionListener meishuRecylcerAdInteractionListener;

    public GDTAdInteractionListener(GDTNativeUnifiedAdData gDTNativeUnifiedAdData, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        this.adData = gDTNativeUnifiedAdData;
        this.meishuRecylcerAdInteractionListener = recylcerAdInteractionListener;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        try {
            if (this.adData.getAdWrapper() != null && this.adData.getAdWrapper().getSdkAdInfo() != null) {
                LogUtil.d(TAG, "send onADClicked");
                z.a(AdSdk.getContext(), f.a(this.adData.getAdWrapper().getSdkAdInfo().getClk(), this.adData), new i());
                this.adData.getAdWrapper().getSdkAdInfo().getMsLoadedTime();
                this.adData.getAdWrapper().getAdLoader().getPosId();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.meishuRecylcerAdInteractionListener;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdClicked();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        try {
            LogUtil.e(TAG, "onADError, code: " + adError.getErrorCode() + ", msg: " + adError.getErrorMsg());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        try {
            if (this.adData.getAdWrapper() == null || this.adData.getAdWrapper().getLoaderListener() == null || this.adData.isHasExposed()) {
                return;
            }
            this.adData.setHasExposed(true);
            this.adData.getAdWrapper().getLoaderListener().onAdExposure();
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.meishuRecylcerAdInteractionListener;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdExposure();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
    }
}
