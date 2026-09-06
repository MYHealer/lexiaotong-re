package com.meishu.sdk.core.loader;

import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.platform.ms.g;

/* JADX INFO: compiled from: AdLoadListenerProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b<T, K extends IAdLoadListener<T>> implements IAdLoadListener<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f4798a;
    public K b;

    public b(d dVar, K k) {
        this.f4798a = dVar;
        this.b = k;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdClosed() {
        LogUtil.d("AdLoadListenerProxy", "send onAdClosed");
        if (this.f4798a.getCacheAdListener() != null) {
            com.meishu.sdk.core.loader.concurrent.a aVar = (com.meishu.sdk.core.loader.concurrent.a) this.f4798a.getCacheAdListener();
            if (aVar.b.e.getLoaderListener() != null) {
                aVar.b.e.getLoaderListener().onAdClosed();
                return;
            }
            return;
        }
        K k = this.b;
        if (k != null) {
            k.onAdClosed();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdError() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdExposure() {
        d dVar = this.f4798a;
        if (!(dVar instanceof g)) {
            a.a(dVar.getContext(), h0.a(this.f4798a.getSdkAdInfo().getImp()));
        }
        if (this.f4798a.getCacheAdListener() != null) {
            com.meishu.sdk.core.loader.concurrent.a aVar = (com.meishu.sdk.core.loader.concurrent.a) this.f4798a.getCacheAdListener();
            if (aVar.b.e.getLoaderListener() != null) {
                aVar.b.e.getLoaderListener().onAdExposure();
            }
        } else {
            K k = this.b;
            if (k != null) {
                k.onAdExposure();
            }
        }
        if (this.f4798a.getConCurrentListener() != null) {
            this.f4798a.getConCurrentListener().onAdExposure();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdLoaded(T t) {
        if (this.f4798a.getConCurrentListener() != null) {
            this.f4798a.getConCurrentListener().b(t, this.f4798a.getTag());
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdPlatformError(AdPlatformError adPlatformError) {
        LogUtil.d("AdLoadListenerProxy", "send onAdPlatformError");
        K k = this.b;
        if (k != null) {
            k.onAdPlatformError(adPlatformError);
        }
        if (this.f4798a.getConCurrentListener() != null) {
            this.f4798a.getConCurrentListener().a(adPlatformError, this.f4798a.getTag());
        }
        if (this.f4798a.getCacheAdListener() != null) {
            com.meishu.sdk.core.loader.cache.c cacheAdListener = this.f4798a.getCacheAdListener();
            String message = adPlatformError.getMessage();
            int iIntValue = adPlatformError.getCode().intValue();
            long loadedTime = this.f4798a.getSdkAdInfo().getLoadedTime();
            com.meishu.sdk.core.loader.concurrent.a aVar = (com.meishu.sdk.core.loader.concurrent.a) cacheAdListener;
            aVar.getClass();
            LogUtil.e("ConCurrentManager", "onAdRenderFail");
            com.meishu.sdk.core.loader.cache.a aVar2 = aVar.f4808a;
            if ((aVar2.e ? aVar2.f : aVar2.b.getLoadedTime()) != loadedTime || aVar.b.e.getLoaderListener() == null) {
                return;
            }
            aVar.b.e.getLoaderListener().onAdRenderFail(message, iIntValue);
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdReady(T t) {
        if (this.f4798a.getConCurrentListener() != null) {
            this.f4798a.getConCurrentListener().a(t, this.f4798a.getTag());
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    public void onAdRenderFail(String str, int i) {
        if (this.f4798a.getConCurrentListener() != null) {
            this.f4798a.getConCurrentListener().a(str, i, this.f4798a.getTag());
        }
    }
}
