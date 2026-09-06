package com.kwad.components.ad.interstitial.f.a;

import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class a extends com.kwad.components.ad.interstitial.f.b implements j {
    private i go;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(az azVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.go = new i(-1L, getContext());
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.go.a(getActivity(), this.mN.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        i iVar = this.go;
        if (iVar != null) {
            iVar.kV();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.mN.gp;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.i(new com.kwad.components.core.webview.tachikoma.b.i.a() { // from class: com.kwad.components.ad.interstitial.f.a.a.1
            @Override // com.kwad.components.core.webview.tachikoma.b.i.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                com.kwad.components.ad.interstitial.report.a.eV().a(a.this.mN.mAdTemplate, 1L, 177L);
                a.this.a(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C0695a c0695a) {
        if (this.mN == null || this.mN.ls == null) {
            return;
        }
        String str = c0695a.aps;
        str.hashCode();
        switch (str) {
            case "adSkipCallback":
                this.mN.ls.onSkippedAd();
                break;
            case "adShowCallback":
                this.mN.ls.onAdShow();
                break;
            case "adCloseCallback":
                this.mN.ls.onAdClosed();
                break;
            case "adAutoCloseCallback":
                this.mN.ls.onPageDismiss();
                break;
            case "adClickCallback":
                this.mN.ls.onAdClicked();
                break;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        this.mN.mP = true;
        this.mN.c(aVar.bdh, aVar.nm);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        n nVar = new n();
        nVar.aut = !this.mN.ce.isVideoSoundEnable();
        oVar.c(nVar);
    }
}
