package com.kwad.components.ad.draw.presenter.b;

import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    private InterfaceC0595a eY;
    private b eZ;
    private boolean fa = false;
    private AdTemplate mAdTemplate;

    /* JADX INFO: renamed from: com.kwad.components.ad.draw.presenter.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0595a {
        void bb();
    }

    public interface b {
        boolean bc();
    }

    public final void a(InterfaceC0595a interfaceC0595a) {
        this.eY = interfaceC0595a;
    }

    public final void a(b bVar) {
        this.eZ = bVar;
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void ba() {
        InterfaceC0595a interfaceC0595a;
        if (this.fa) {
            return;
        }
        this.fa = true;
        if (e.eO(this.mAdTemplate).status == 1 || e.eO(this.mAdTemplate).status == 2 || e.eO(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.eZ;
        if ((bVar == null || !bVar.bc()) && (interfaceC0595a = this.eY) != null) {
            interfaceC0595a.bb();
        }
    }
}
