package com.kwad.components.ad.nativead.b;

import com.kwad.components.core.video.m;
import com.kwad.sdk.api.KsNativeAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e extends com.kwad.components.ad.nativead.a.a {
    private boolean eU = false;
    private KsNativeAd.VideoPlayListener pv;

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.pv = this.pW.pv;
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.e.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                if (e.this.pv != null) {
                    e.this.pv.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                if (e.this.pv != null) {
                    e.this.pv.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                if (e.this.pv != null) {
                    e.this.pv.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPrepared() {
                super.onMediaPrepared();
                if (e.this.pv != null) {
                    try {
                        e.this.pv.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    }
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (e.this.eU) {
                    e.this.eU = false;
                    if (e.this.pv != null) {
                        try {
                            e.this.pv.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                if (e.this.pv != null) {
                    try {
                        e.this.pv.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    }
                }
                e.this.eU = true;
            }
        };
        this.pW.pX.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
