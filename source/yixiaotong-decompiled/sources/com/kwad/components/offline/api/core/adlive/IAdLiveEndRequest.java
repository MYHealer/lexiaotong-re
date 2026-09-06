package com.kwad.components.offline.api.core.adlive;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IAdLiveEndRequest {
    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getUrl();

    Map<String, String> getUrlParam();
}
