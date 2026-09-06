package com.kwad.components.core.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cc;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f extends com.kwad.components.core.video.a implements cc.a {
    private boolean JA;
    private boolean anw;
    private boolean anx;
    private View bZ;
    private final cc ca;
    private final AtomicBoolean cb;

    public interface a extends com.kwad.components.core.video.a.c {
        void onVideoPlayError(int i, int i2);
    }

    private void xI() {
        this.JA = false;
    }

    public final void setShowLandingPage(boolean z) {
        this.anx = z;
    }

    public f(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.ca = new cc(this);
        this.cb = new AtomicBoolean(true);
        this.JA = false;
        this.anw = false;
        this.anx = false;
        this.bZ = this;
    }

    @Override // com.kwad.components.core.video.a
    protected final void xd() {
        super.xd();
        if (this.qf != null) {
            this.qf.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        if (this.qg != null) {
            this.qg.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // com.kwad.components.core.video.a
    protected final void fI() {
        if (this.anw) {
            super.fI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        xI();
        ae();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        ae();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        af();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        af();
    }

    private void ae() {
        if (this.cb.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.ca.sendEmptyMessage(1);
        }
    }

    private void af() {
        if (this.cb.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewDetached");
        this.ca.removeCallbacksAndMessages(null);
        release();
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.JA = true;
    }

    @Override // com.kwad.components.core.video.a
    public final void startPlay() {
        super.startPlay();
    }

    @Override // com.kwad.components.core.video.a
    public final void xj() {
        super.xj();
    }

    @Override // com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        if (!this.JA && message.what == 1) {
            if (this.anx) {
                this.ca.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (cb.r(this.bZ, 70)) {
                startPlay();
            } else {
                xj();
            }
            this.ca.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
