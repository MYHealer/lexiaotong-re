package com.kwad.components.ad.splashscreen.presenter.endcard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e extends com.kwad.components.ad.splashscreen.presenter.e {
    private com.kwad.components.core.webview.tachikoma.f.g mU = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.e.1
        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void x(String str) {
            if ("tk_splash_end_card".equals(str)) {
                e.this.a(new d(), true);
                e.this.a(new a(), true);
                e.this.a(new b(), true);
                e.this.a(new c(), true);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.webview.tachikoma.e.c.zG().a(this.mU);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.tachikoma.e.c.zG().b(this.mU);
    }
}
