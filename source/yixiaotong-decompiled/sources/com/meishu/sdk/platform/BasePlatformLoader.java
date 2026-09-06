package com.meishu.sdk.platform;

import android.content.Context;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.core.loader.c;
import com.meishu.sdk.core.loader.concurrent.f;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.loader.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class BasePlatformLoader<Loader extends c, LoaderListener extends IAdLoadListener> implements d<Loader> {
    public Loader adLoader;
    private com.meishu.sdk.core.loader.cache.c cacheAdListener;
    public f conCurrentListener;
    public Context context;
    private int groupIndex;
    public LoaderListener loadListener;
    public d next;
    public SdkAdInfo sdkAdInfo;
    public Map<String, Object> localParams = new HashMap();
    private int index = -1;

    public BasePlatformLoader(Loader loader, SdkAdInfo sdkAdInfo) {
        this.adLoader = loader;
        this.sdkAdInfo = sdkAdInfo;
        this.context = loader.getContext();
        this.loadListener = (LoaderListener) e.a(this, loader.getLoaderListener());
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.loader.d
    public Loader getAdLoader() {
        return this.adLoader;
    }

    @Override // com.meishu.sdk.core.loader.d
    public com.meishu.sdk.core.loader.cache.c getCacheAdListener() {
        return this.cacheAdListener;
    }

    @Override // com.meishu.sdk.core.loader.d
    public f getConCurrentListener() {
        return this.conCurrentListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public Context getContext() {
        return this.context;
    }

    public int getGroupIndex() {
        return this.groupIndex;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public LoaderListener getLoaderListener() {
        return this.loadListener;
    }

    public Map<String, Object> getLocalParams() {
        return this.localParams;
    }

    @Override // com.meishu.sdk.core.loader.d
    public SdkAdInfo getSdkAdInfo() {
        return this.sdkAdInfo;
    }

    @Override // com.meishu.sdk.core.loader.d
    public int getTag() {
        return this.index;
    }

    public d next() {
        return this.next;
    }

    public void sendGdtWinResult(boolean z, int i) {
    }

    @Override // com.meishu.sdk.core.loader.d
    public void setCacheAdListener(com.meishu.sdk.core.loader.cache.c cVar) {
        this.cacheAdListener = cVar;
    }

    @Override // com.meishu.sdk.core.loader.d
    public void setConCurrentLoadListener(f fVar) {
        this.conCurrentListener = fVar;
    }

    @Override // com.meishu.sdk.core.loader.d
    public void setGroupIndex(int i) {
        this.groupIndex = i;
    }

    @Override // com.meishu.sdk.core.loader.d
    public void setLocalParams(Map<String, Object> map) {
        this.localParams = map;
    }

    public void setNext(d dVar) {
        this.next = dVar;
    }

    public void setTag(int i) {
        this.index = i;
    }
}
