package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.d.a.c;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        if (z) {
            jQ();
        } else {
            jR();
        }
    }

    private void jQ() {
        if (g.g(this.mAdInfo)) {
            a(new s());
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.helper.b.dk(this.mAdTemplate)) {
            a(new c());
        }
        a(new a(this.mAdInfo));
        if (com.kwad.components.ad.reward.a.b.l(this.mAdInfo) || !com.kwad.sdk.core.response.helper.a.ay(this.mAdInfo)) {
            return;
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.a());
    }

    static class a extends com.kwad.components.ad.reward.presenter.c {
        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iP() {
            return 8;
        }

        public a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iO() {
            return R.id.ksad_blur_end_cover;
        }
    }

    private void jR() {
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.helper.b.dk(this.mAdTemplate)) {
            a(new c());
        }
    }
}
