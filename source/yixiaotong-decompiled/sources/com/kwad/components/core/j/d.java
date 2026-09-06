package com.kwad.components.core.j;

import com.kwad.sdk.api.KsInnerAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d {
    private Object aaW;

    public final void destroy() {
        this.aaW = null;
    }

    public d(Object obj) {
        this.aaW = obj;
    }

    public final void c(c cVar) {
        if (this.aaW == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.aaW).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void d(c cVar) {
        if (this.aaW == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.aaW).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }
}
