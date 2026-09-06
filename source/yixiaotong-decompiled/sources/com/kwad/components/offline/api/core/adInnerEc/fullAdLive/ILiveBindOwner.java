package com.kwad.components.offline.api.core.adInnerEc.fullAdLive;

import com.kwad.components.offline.api.core.adInnerEc.longconnection.ILiveLongConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ILiveBindOwner {
    IHostLivePlayer getLivePlayer();

    ILiveLongConnection getLongConnection();

    void release();
}
