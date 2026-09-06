package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d extends com.kwad.components.ad.nativead.a.a {
    private View qk;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qk = findViewById(R.id.ksad_video_network_unavailable);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (aq.isNetworkConnected(this.qk.getContext())) {
            this.qk.setVisibility(8);
            return;
        }
        this.qk.setVisibility(0);
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.d.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                d.this.fH();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                d.this.fH();
            }
        };
        this.pW.pX.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH() {
        if (this.qk.getVisibility() != 0) {
            return;
        }
        this.qk.setVisibility(8);
    }
}
