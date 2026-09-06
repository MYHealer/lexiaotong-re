package com.kwad.components.ad.splashscreen.presenter.a;

import android.app.Activity;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class c extends e implements j {
    private b KM;

    public void a(az azVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    protected int nL() {
        return 1000;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        int iNL = nL();
        b bVar = new b(getContext(), iNL, iNL);
        this.KM = bVar;
        bVar.a((Activity) null, this.HC.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.KM.kV();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.HC.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C0695a c0695a) {
        String str = c0695a.aps;
        str.hashCode();
        switch (str) {
            case "adShowCallback":
                this.HC.mf();
                break;
            case "adDownloadConfirmTipCancel":
                this.HC.mk();
                break;
            case "adCloseCallback":
                this.HC.mh();
                break;
            case "adDownloadConfirmTipShow":
                this.HC.mj();
                break;
            case "adDownloadConfirmTipDismiss":
                this.HC.ml();
                break;
            case "adAutoCloseCallback":
                this.HC.mg();
                break;
            case "adShowErrorCallback":
                this.HC.me();
                break;
            case "adClickCallback":
                this.HC.mi();
                break;
        }
    }
}
