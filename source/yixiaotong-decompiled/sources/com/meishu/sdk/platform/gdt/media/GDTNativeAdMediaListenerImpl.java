package com.meishu.sdk.platform.gdt.media;

import com.meishu.sdk.core.ad.media.c;
import com.meishu.sdk.core.utils.LogUtil;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeAdMediaListenerImpl implements NativeADMediaListener {
    private static final String TAG = "GDTNativeAdMediaListene";
    private c nativeAdMediaListener;

    public GDTNativeAdMediaListenerImpl(c cVar) {
        this.nativeAdMediaListener = cVar;
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        this.nativeAdMediaListener.onVideoComplete();
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        LogUtil.d(TAG, "onVideoError: ");
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i) {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        this.nativeAdMediaListener.onVideoPause();
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        this.nativeAdMediaListener.onVideoStart();
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
    }
}
