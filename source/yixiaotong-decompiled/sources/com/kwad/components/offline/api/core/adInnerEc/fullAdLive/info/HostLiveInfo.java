package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.info;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HostLiveInfo {
    public String authorId;
    public String liveStreamId;
    public String multiResolutionPlayUrls;
    public String playUrl;

    public HostLiveInfo setAuthorId(String str) {
        this.authorId = str;
        return this;
    }

    public HostLiveInfo setLiveStreamId(String str) {
        this.liveStreamId = str;
        return this;
    }

    public HostLiveInfo setMultiResolutionPlayUrls(String str) {
        this.multiResolutionPlayUrls = str;
        return this;
    }

    public HostLiveInfo setPlayUrl(String str) {
        this.playUrl = str;
        return this;
    }

    private HostLiveInfo() {
    }

    public static HostLiveInfo obtain() {
        return new HostLiveInfo();
    }
}
