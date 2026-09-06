package com.kwad.auth.login;

import android.content.Context;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.IActivityProxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class KwadRouteHandlerActivity extends BaseProxyActivity {
    @Override // com.kwad.sdk.api.proxy.BaseProxyActivity
    public IActivityProxy getDelegate(Context context) {
        return (IActivityProxy) Loader.get().newComponentProxy(context, KwadRouteHandlerActivity.class, this);
    }
}
