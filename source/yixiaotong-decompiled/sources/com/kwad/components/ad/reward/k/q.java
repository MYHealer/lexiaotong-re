package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class q extends z {
    private WeakReference<com.kwad.components.ad.reward.g> Cf;
    private long zV;

    public q(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.components.ad.reward.g gVar, long j, com.kwad.sdk.core.webview.d.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, dVar, aVar, onDismissListener);
        this.zV = j;
        if (gVar != null) {
            this.Cf = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final void kN() {
        super.kN();
        if (this.apJ != null) {
            com.kwad.components.ad.reward.c.a.ih().e(this.apJ.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final com.kwad.components.core.e.d.a.C0661a a(com.kwad.components.core.e.d.a.C0661a c0661a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        long playDuration;
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.Cf;
        if (weakReference == null || weakReference.get() == null) {
            playDuration = this.zV;
            if (playDuration <= 0) {
                playDuration = 0;
            }
        } else {
            playDuration = this.Cf.get().sz.getPlayDuration();
        }
        return super.a(c0661a, aVar, adTemplate).E(playDuration);
    }
}
