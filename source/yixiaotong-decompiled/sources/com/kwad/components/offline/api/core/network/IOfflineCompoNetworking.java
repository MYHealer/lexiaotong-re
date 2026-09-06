package com.kwad.components.offline.api.core.network;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IOfflineCompoNetworking<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    void cancel();

    R createRequest();

    boolean enableMonitorReport();

    boolean isPostByJson();

    void onResponse(R r, c cVar);

    void request(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener);
}
