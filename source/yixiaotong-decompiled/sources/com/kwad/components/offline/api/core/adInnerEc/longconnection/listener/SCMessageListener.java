package com.kwad.components.offline.api.core.adInnerEc.longconnection.listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface SCMessageListener {
    int getPayloadType();

    boolean isSticky();

    void onMessageReceived(byte[] bArr);
}
