package com.kwad.components.core.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c extends d {
    private com.kwad.components.core.page.a.a adB;

    public static c a(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.c(context, aVar);
        return cVar;
    }

    @Override // com.kwad.components.core.page.d, com.kwad.components.core.n.d
    public final void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        View viewFindViewById = findViewById(R.id.ksad_web_tip_bar);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    public final void setH5AuthListener(com.kwad.components.core.page.a.a aVar) {
        if (this.abm == 0) {
            this.adB = aVar;
        } else {
            ((com.kwad.components.core.page.d.a.b) this.abm).setH5AuthListener(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.page.d, com.kwad.components.core.n.d
    /* JADX INFO: renamed from: ub, reason: merged with bridge method [inline-methods] */
    public final com.kwad.components.core.page.d.a.b an() {
        com.kwad.components.core.page.d.a.b bVarAn = super.an();
        com.kwad.components.core.page.a.a aVar = this.adB;
        if (aVar != null) {
            bVarAn.setH5AuthListener(aVar);
            this.adB = null;
        }
        return bVarAn;
    }

    private c(Context context) {
        super(context);
        this.adB = null;
    }

    @Override // com.kwad.components.core.page.d, com.kwad.components.core.n.d
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.core.page.d.a());
        return presenter;
    }
}
