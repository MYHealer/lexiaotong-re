package com.kwad.sdk.api.proxy.app;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ServiceProxyRemote extends BaseProxyService {
    @Override // com.kwad.sdk.api.proxy.BaseProxyService
    public IServiceProxy getDelegate(Context context) {
        IServiceProxy iServiceProxy;
        try {
            iServiceProxy = (IServiceProxy) Loader.get().newComponentProxy(context, ServiceProxyRemote.class, this);
        } catch (Throwable unused) {
            iServiceProxy = null;
        }
        return iServiceProxy == null ? new IServiceProxy() { // from class: com.kwad.sdk.api.proxy.app.ServiceProxyRemote.1
            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public IBinder onBind(Service service, Intent intent) {
                return null;
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public void onCreate(Service service) {
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public void onDestroy(Service service) {
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public void onRebind(Service service, Intent intent) {
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public int onStartCommand(Service service, Intent intent, int i, int i2) {
                return 0;
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public boolean onUnbind(Service service, Intent intent) {
                return false;
            }
        } : iServiceProxy;
    }
}
