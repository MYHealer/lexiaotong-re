package com.kwad.components.offline.c;

import android.content.Context;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements com.kwad.components.core.offline.a.b.a {
    private final IAdWaynePlayerOfflineCompo axv;

    @Override // com.kwad.sdk.components.b
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public a(IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        this.axv = iAdWaynePlayerOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.axv.priority();
    }

    @Override // com.kwad.components.core.offline.a.b.a
    public final boolean tt() {
        return this.axv.getState() == IAdWaynePlayerOfflineCompo.AdWaynePlayerState.READY;
    }

    @Override // com.kwad.components.core.offline.a.b.a
    public final IAdWaynePlayerPlayModule getAdWaynePlayerPlayModule(String str, boolean z) {
        if (!tt()) {
            return null;
        }
        try {
            return this.axv.getAdWaynePlayerPlayModule(str, z);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }
}
