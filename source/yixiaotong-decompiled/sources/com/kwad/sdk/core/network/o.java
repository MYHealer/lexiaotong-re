package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class o<R extends f, T extends BaseResultData> implements g<R, T> {
    @Override // com.kwad.sdk.core.network.g
    public void onError(R r, int i, String str) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(R r) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(R r, T t) {
    }
}
