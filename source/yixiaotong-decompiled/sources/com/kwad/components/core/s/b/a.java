package com.kwad.components.core.s.b;

import android.widget.FrameLayout;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends Presenter implements j {
    private FrameLayout akX;
    private az akY;
    protected boolean akZ;
    protected com.kwad.components.core.s.a.b ala;
    private com.kwad.components.core.n.a.a alb = new com.kwad.components.core.n.a.a() { // from class: com.kwad.components.core.s.b.a.1
        @Override // com.kwad.components.core.n.a.a
        public final void hk() {
        }

        @Override // com.kwad.components.core.n.a.a
        public final void c(f fVar) {
            a.this.wy();
        }

        @Override // com.kwad.components.core.n.a.a
        public final void d(f fVar) {
            a.this.wz();
        }

        @Override // com.kwad.components.core.n.a.a
        public final void hl() {
            a.this.wA();
        }
    };
    private i go;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C0695a c0695a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.akY = azVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
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
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
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
    public final String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.akX;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.ala = (com.kwad.components.core.s.a.b) SB();
        this.akX = (FrameLayout) findViewById(R.id.ksad_js_container);
        i iVar = new i(getContext(), 1000, 0);
        this.go = iVar;
        iVar.a(this.ala.akN);
        if (this.ala.akQ != null) {
            this.ala.akQ.a(this.go);
            this.go.a(new g() { // from class: com.kwad.components.core.s.b.a.2
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    if (a.this.ala.akQ != null) {
                        a.this.ala.akQ.callTKBridge(str);
                    }
                }
            });
            this.go.a("hasTKBridge", Boolean.TRUE);
        }
        this.go.a(getActivity(), this.ala.mAdResultData, this);
        this.ala.abk.add(this.alb);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        wA();
        this.go.kV();
        this.ala.abk.remove(this.alb);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return this.ala.akN.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.ala.mRootContainer;
    }

    private void wx() {
        az azVar = this.akY;
        if (azVar == null) {
            return;
        }
        if (!this.akZ) {
            azVar.yx();
            this.akY.yy();
            this.akZ = true;
            return;
        }
        azVar.yB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wy() {
        wx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz() {
        az azVar = this.akY;
        if (azVar == null || !this.akZ) {
            return;
        }
        azVar.yC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA() {
        az azVar = this.akY;
        if (azVar == null || !this.akZ) {
            return;
        }
        azVar.yz();
        this.akY.yA();
        if (this.ala.akQ != null) {
            this.ala.akQ.callbackDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        wx();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        aVar.width = (int) ((bt.getScreenWidth(getContext()) / fBB) + 0.5f);
        aVar.height = (int) ((bt.getScreenHeight(getContext()) / fBB) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }
}
