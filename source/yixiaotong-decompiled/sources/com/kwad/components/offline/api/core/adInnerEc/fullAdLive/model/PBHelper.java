package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface PBHelper {
    PbClientStat getPbClientStat();

    PbPayloadType getPbPayloadType();

    <T> T parseFrom(byte[] bArr, Class<T> cls);
}
