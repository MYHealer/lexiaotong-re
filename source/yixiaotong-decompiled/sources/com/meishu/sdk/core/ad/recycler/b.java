package com.meishu.sdk.core.ad.recycler;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.AdErrorInfo;
import java.util.List;

/* JADX INFO: compiled from: RecyclerAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerAdEventListener f4763a;
    public volatile boolean b;
    public volatile boolean c;

    public b(RecyclerMixAdLoader recyclerMixAdLoader, RecyclerAdEventListener recyclerAdEventListener) {
        this.f4763a = recyclerAdEventListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdClosed() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.a, com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public /* bridge */ /* synthetic */ void onAdLoaded(List<RecyclerAdData> list) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdPlatformError(AdPlatformError adPlatformError) {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdReady(List<RecyclerAdData> list) {
        List<RecyclerAdData> list2 = list;
        RecyclerAdEventListener recyclerAdEventListener = this.f4763a;
        if (recyclerAdEventListener != null) {
            recyclerAdEventListener.onAdReady(list2);
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdError() {
        if (this.f4763a == null || this.c || this.b) {
            return;
        }
        this.b = true;
        if (AdSdk.adConfig() == null) {
            this.f4763a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), "SDK IS NOT INITED ！"));
        } else {
            this.f4763a.onAdError(new AdErrorInfo(AdErrorInfo.LOAD_ERROR, ErrorCodeUtil.AD_LOAD_ERROR.intValue(), ErrorCodeUtil.AD_LOAD_ERROR_MSG));
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.a, com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdRenderFail(String str, int i) {
        if (this.f4763a == null || this.b || this.c) {
            return;
        }
        this.c = true;
        this.f4763a.onAdError(new AdErrorInfo(AdErrorInfo.RENDER_ERROR, i, str));
    }
}
