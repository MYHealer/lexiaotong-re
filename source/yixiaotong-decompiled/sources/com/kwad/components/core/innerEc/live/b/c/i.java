package com.kwad.components.core.innerEc.live.b.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i extends com.kwad.components.core.innerEc.live.b.a.a {
    private com.kwad.components.core.innerEc.live.config.b UF;
    private com.kwad.components.core.innerEc.live.end.a UG;
    private boolean WW;
    private final com.kwad.components.core.innerEc.live.end.c Wb = new com.kwad.components.core.innerEc.live.end.c() { // from class: com.kwad.components.core.innerEc.live.b.c.i.1
        @Override // com.kwad.components.core.innerEc.live.end.c
        public final void sg() {
        }
    };

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.innerEc.live.config.b bVar = this.Ub.UF;
        this.UF = bVar;
        bVar.a(this.Ub);
        com.kwad.components.core.innerEc.live.end.a aVar = this.Ub.UG;
        this.UG = aVar;
        aVar.a(this.Wb);
        sA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.UG.b(this.Wb);
    }

    private void sA() {
        if (this.WW) {
            return;
        }
        com.kwad.components.core.innerEc.live.end.a aVar = this.UG;
        if (aVar == null || !aVar.sD()) {
            this.WW = true;
            rE();
        }
    }

    private void rE() {
        this.UF.rE();
    }
}
