package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class j extends com.kwad.components.ad.nativead.a.a {
    private View qy;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qy = findViewById(R.id.ksad_video_error_container);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.qy.setVisibility(8);
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.j.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                j.this.fO();
            }
        };
        this.pW.pX.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO() {
        if (this.qy.getVisibility() == 0) {
            return;
        }
        this.qy.setVisibility(0);
    }
}
