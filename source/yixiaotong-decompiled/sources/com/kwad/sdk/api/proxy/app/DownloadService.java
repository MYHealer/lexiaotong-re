package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownloadService extends BaseProxyService {
    @Override // com.kwad.sdk.api.proxy.BaseProxyService
    public IServiceProxy getDelegate(Context context) {
        return (IServiceProxy) Loader.get().newComponentProxy(context, DownloadService.class, this);
    }
}
