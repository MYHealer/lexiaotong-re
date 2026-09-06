package com.kwad.framework.filedownloader.a;

import com.google.android.exoplayer2.upstream.cache.CacheDataSink;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements com.kwad.framework.filedownloader.f.c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int ab(long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            return 2;
        }
        if (j < com.hihonor.adsdk.common.video.g.a.hnadsb) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
