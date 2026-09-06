package com.kwad.components.ad.j;

import android.content.Context;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c {
    public static IAdLiveOfflineView a(com.kwad.components.core.offline.a.c.a aVar, Context context, int i) {
        try {
            return aVar.getView(context, i);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }
}
