package com.kwad.sdk.core.response.model;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdVideoPreCacheConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int DEFAULT_PRE_CACHE_SIZE = 800;
    private static final long serialVersionUID = -3793189825357939577L;
    public int adVideoPreCacheSize;
    public boolean continueLoadingAll;

    public int getAdVideoPreCacheSize() {
        return this.adVideoPreCacheSize;
    }

    public boolean isContinueLoadingAll() {
        return this.continueLoadingAll;
    }

    public void setAdVideoPreCacheSize(int i) {
        this.adVideoPreCacheSize = i;
    }

    public void setContinueLoadingAll(boolean z) {
        this.continueLoadingAll = z;
    }

    public AdVideoPreCacheConfig(int i, boolean z) {
        this.adVideoPreCacheSize = i;
        this.continueLoadingAll = z;
    }

    public AdVideoPreCacheConfig() {
        this.adVideoPreCacheSize = 800;
    }
}
