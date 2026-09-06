package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {
    private View ks;
    private View kt;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            c.this.j(false);
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ks = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.kt = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().a(this);
        this.ks.setVisibility(0);
        this.kt.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        if ((this.uj.sQ || this.uj.sP) && !z) {
            this.ks.setVisibility(8);
            this.kt.setVisibility(8);
        } else {
            this.ks.setVisibility(8);
            this.kt.setVisibility(0);
        }
    }

    private void dp() {
        if (this.uj.sQ || this.uj.sP) {
            return;
        }
        this.ks.setVisibility(0);
        this.kt.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        dp();
        if (this.uj.sP && this.kt.getVisibility() == 0) {
            this.kt.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dr() {
        j(true);
    }
}
