package com.kwad.components.offline.api.core.adInnerEc.fullAdLive;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IHostLiveService {
    ILiveBindOwner createLiveBindOwner(String str, String str2);

    IHostLivePlayer createLivePlayer();

    IHostLivePlayer createLivePlayer(String str);

    void initService();
}
