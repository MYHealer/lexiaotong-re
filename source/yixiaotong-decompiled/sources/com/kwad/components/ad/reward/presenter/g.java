package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g extends b implements com.kwad.components.core.j.a.InterfaceC0674a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        boolean zLZ = com.kwad.sdk.core.local.a.LZ();
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + zLZ);
        if (this.mAdTemplate.mAdScene == null || !zLZ) {
            return;
        }
        com.kwad.components.core.j.a.a(this.mAdTemplate.mAdScene, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0674a
    public final void onError(int i, String str) {
        List<com.kwad.components.core.j.a.InterfaceC0674a> listHd = this.uj.hd();
        if (listHd != null) {
            Iterator<com.kwad.components.core.j.a.InterfaceC0674a> it = listHd.iterator();
            while (it.hasNext()) {
                it.next().onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0674a
    public final void onRequestResult(int i) {
        List<com.kwad.components.core.j.a.InterfaceC0674a> listHd = this.uj.hd();
        if (listHd != null) {
            Iterator<com.kwad.components.core.j.a.InterfaceC0674a> it = listHd.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0674a
    public final void e(List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean zDf = com.kwad.sdk.core.response.helper.b.df(adTemplate);
        List<com.kwad.components.core.j.a.InterfaceC0674a> listHd = this.uj.hd();
        if (zDf) {
            com.kwad.sdk.core.local.a.g(com.kwad.sdk.core.response.helper.b.dc(adTemplate), com.kwad.sdk.core.response.helper.b.dd(adTemplate));
            if (listHd != null) {
                Iterator<com.kwad.components.core.j.a.InterfaceC0674a> it = listHd.iterator();
                while (it.hasNext()) {
                    it.next().e(list);
                }
            }
        }
    }
}
