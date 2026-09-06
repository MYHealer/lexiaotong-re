package com.kwad.components.ad.nativead.b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class k extends com.kwad.components.ad.nativead.a.a {
    private ProgressBar qA;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qA = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.qA.setProgress(0);
        this.qA.setVisibility(8);
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.k.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                k.this.ae(j != 0 ? (int) ((j2 * 100.0f) / j) : 0);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                k.this.fP();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                k.this.fP();
            }
        };
        this.pW.pX.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i) {
        this.qA.setProgress(i);
        if (this.qA.getVisibility() == 0) {
            return;
        }
        this.qA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP() {
        if (this.qA.getVisibility() != 0) {
            return;
        }
        this.qA.setVisibility(8);
    }
}
