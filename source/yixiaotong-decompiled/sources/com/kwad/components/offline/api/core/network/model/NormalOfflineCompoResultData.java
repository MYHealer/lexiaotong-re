package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.network.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class NormalOfflineCompoResultData extends BaseOfflineCompoResultData {
    public int code;
    public String data;
    public String header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.aSY;
        this.header = null;
    }
}
