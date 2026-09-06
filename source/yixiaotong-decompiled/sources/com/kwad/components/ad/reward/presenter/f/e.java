package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.az;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e implements com.kwad.components.ad.reward.g.a {
    private boolean AX;
    private boolean AY;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f929do;

    public final void b(az azVar) {
        this.f929do = azVar;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hp() {
        this.AY = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hs() {
        this.AY = false;
    }

    private void ku() {
        az azVar = this.f929do;
        if (azVar == null || !this.AY) {
            return;
        }
        if (!this.AX) {
            azVar.yx();
            this.f929do.yy();
            this.AX = true;
            return;
        }
        azVar.yB();
    }

    public final void A(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void B(com.kwad.components.ad.reward.g gVar) {
        az azVar = this.f929do;
        if (azVar != null) {
            azVar.yz();
            this.f929do.yA();
        }
        gVar.b(this);
    }

    public final void aE() {
        ku();
    }

    public final void kv() {
        az azVar = this.f929do;
        if (azVar != null) {
            azVar.yz();
            this.f929do.yA();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hq() {
        this.AY = true;
        ku();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hr() {
        this.AY = false;
        az azVar = this.f929do;
        if (azVar != null) {
            azVar.yC();
        }
    }
}
