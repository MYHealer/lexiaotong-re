package com.kwad.components.ad.k;

import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b extends a<l> {
    public com.kwad.components.core.video.b Nx;
    private boolean Ny;
    private l Nz;
    protected DetailVideoView mDetailVideoView;

    public b(AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.Ny = false;
        this.Nz = new m() { // from class: com.kwad.components.ad.k.b.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                b.this.mAdTemplate.setmCurPlayTime(j2);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                try {
                    super.onMediaPlayError(i, i2);
                    if (!b.this.Ny) {
                        b.this.op();
                    } else if (e.Kr()) {
                        b.this.op();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.Nx = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        on();
    }

    private void on() {
        this.Nx.c(this.Nz);
    }

    private void oo() {
        l lVar;
        com.kwad.components.core.video.b bVar = this.Nx;
        if (bVar == null || (lVar = this.Nz) == null) {
            return;
        }
        bVar.d(lVar);
        this.Nz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op() {
        com.kwad.components.core.p.a.vL().j(this.mAdTemplate, 21008);
        this.Ny = true;
    }

    @Override // com.kwad.components.ad.k.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.Nx;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.k.a
    public void resume() {
        this.Nx.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public void pause() {
        this.Nx.pause();
    }

    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(l lVar) {
        com.kwad.components.core.video.b bVar;
        if (lVar == null || (bVar = this.Nx) == null) {
            return;
        }
        bVar.c(lVar);
    }

    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.Nx.d(lVar);
    }

    @Override // com.kwad.components.ad.k.a
    public void release() {
        super.release();
        this.Ny = false;
        oo();
        com.kwad.components.core.video.b bVar = this.Nx;
        if (bVar != null) {
            bVar.clear();
            this.Nx.release();
        }
    }
}
