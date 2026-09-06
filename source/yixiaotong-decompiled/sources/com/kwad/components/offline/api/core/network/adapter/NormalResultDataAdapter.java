package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class NormalResultDataAdapter<T extends NormalOfflineCompoResultData> extends NormalResultData {
    private final T mOfflineCompoResultData;

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    public NormalResultDataAdapter(T t) {
        this.mOfflineCompoResultData = t;
    }

    @Override // com.kwad.sdk.core.network.NormalResultData
    public void parseResponse(c cVar) {
        super.parseResponse(cVar);
        this.mOfflineCompoResultData.parseResponse(cVar);
    }
}
