package com.kwad.sdk.contentalliance.a.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    public com.kwad.sdk.contentalliance.a.a.a aKK;
    public AdTemplate adTemplate;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    private b(a aVar) {
        this.aKK = new com.kwad.sdk.contentalliance.a.a.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.aKK != null) {
            this.aKK.photoId = aVar.aKK.photoId;
            this.aKK.clickTime = aVar.aKK.clickTime;
            this.aKK.adStyle = aVar.aKK.adStyle;
            this.aKK.contentType = aVar.aKK.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }

    public static class a {
        private com.kwad.sdk.contentalliance.a.a.a aKK;
        private AdTemplate adTemplate;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a b(com.kwad.sdk.contentalliance.a.a.a aVar) {
            this.aKK = aVar;
            return this;
        }

        public final a bD(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public final a dQ(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a dR(String str) {
            this.manifest = str;
            return this;
        }

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public a(String str) {
            this.videoUrl = str;
        }

        public final b IG() {
            return new b(this, (byte) 0);
        }
    }
}
