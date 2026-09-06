package com.kwad.components.ad.splashscreen.presenter.endcard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f extends com.kwad.components.ad.splashscreen.presenter.e {
    com.kwad.components.ad.splashscreen.f JZ = new com.kwad.components.ad.splashscreen.f() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.f.1
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lY() {
            f.this.HC.mAdTemplate.isEndCardPage = true;
            f.this.a(new e(), true);
            f.this.a(new h(), true);
        }
    };

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.HC.a(this.JZ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.HC.b(this.JZ);
    }
}
