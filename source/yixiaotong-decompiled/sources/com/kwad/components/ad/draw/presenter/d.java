package com.kwad.components.ad.draw.presenter;

import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d extends com.kwad.components.ad.draw.b.a {
    private TextView ep;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.d.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            d.this.ep.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            d.this.ep.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            d.this.ep.setVisibility(0);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ep = (TextView) findViewById(R.id.ksad_video_fail_tip);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (!aq.isNetworkConnected(getContext())) {
            this.ep.setVisibility(0);
        } else {
            this.ep.setVisibility(8);
        }
        this.dQ.dS.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dQ.dS.a(this.mVideoPlayStateListener);
    }
}
