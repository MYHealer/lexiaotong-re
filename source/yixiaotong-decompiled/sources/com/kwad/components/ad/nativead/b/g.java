package com.kwad.components.ad.nativead.b;

import android.widget.ImageView;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g extends com.kwad.components.ad.nativead.a.a {
    private ImageView qs;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_cover_image);
        this.qs = imageView;
        a(imageView, "NativePlayEndCoverPresenter R.id.ksad_video_cover_image is null");
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.g.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                g.this.fM();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                g.this.fN();
            }
        };
        this.pW.pX.b(this.mVideoPlayStateListener);
        this.qs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM() {
        KSImageLoader.loadImage(this.qs, com.kwad.sdk.core.response.helper.a.aa(com.kwad.sdk.core.response.helper.e.eO(this.pW.mAdTemplate)), this.pW.mAdTemplate);
        this.qs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN() {
        if (this.qs.getVisibility() == 0) {
            this.qs.setVisibility(8);
        }
    }
}
