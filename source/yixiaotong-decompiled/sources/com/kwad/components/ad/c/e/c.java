package com.kwad.components.ad.c.e;

import android.app.Activity;
import android.os.SystemClock;
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
import com.opos.mobad.activity.VideoActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class c extends com.kwad.components.ad.c.d.a implements j {
    private b ds;
    private boolean dt = false;

    public void a(az azVar) {
    }

    public void a(o oVar) {
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
    public String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return null;
    }

    @Override // com.kwad.components.ad.c.d.a, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        b bVar = new b(getContext(), -1, -1);
        this.ds = bVar;
        bVar.a((Activity) null, this.cS.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.ds.kV();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C0695a c0695a) {
        String str = c0695a.aps;
        str.hashCode();
        if (!str.equals(VideoActivity.EXTRA_KEY_SHOW_CALLBACK)) {
            if (str.equals("adShowErrorCallback")) {
                this.cS.c(0, "onMediaPlayError");
            }
        } else {
            this.cS.aa();
            com.kwad.components.ad.c.c.c.b(this.cS.mAdTemplate, 2, 2);
            if (this.dt) {
                return;
            }
            this.dt = true;
            com.kwad.components.ad.c.c.c.a(this.cS.mAdTemplate, SystemClock.elapsedRealtime() - this.cS.bU, 2, 2);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
        this.cS.b(adTemplate);
    }
}
